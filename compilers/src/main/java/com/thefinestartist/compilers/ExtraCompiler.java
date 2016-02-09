package com.thefinestartist.compilers;

import android.app.Activity;

import com.thefinestartist.annotations.Extra;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

/**
 * Created by TheFinestArtist on 2/7/16.
 */
@SupportedAnnotationTypes("com.thefinestartist.annotations.Extra")
public class ExtraCompiler extends AbstractProcessor {

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    Filer filer;
    Messager messager;
    Types types;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
        types = processingEnv.getTypeUtils();
    }

    private void note(String message, Object... args) {
        messager.printMessage(Diagnostic.Kind.NOTE, String.format(message, args));
    }

    private void error(String message, Object... args) {
        messager.printMessage(Diagnostic.Kind.ERROR, String.format(message, args));
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Map<TypeElement, Set<BindingPoint>> bindingsByClass = new LinkedHashMap<>();
        Set<TypeMirror> bindingTargets = new HashSet<>();

        for (Element element : roundEnv.getElementsAnnotatedWith(Extra.class)) {

            // Verify containing type.
            TypeElement enclosingElement = (TypeElement) element.getEnclosingElement();
            if (enclosingElement.getKind() != ElementKind.CLASS) {
                error("Unexpected @Extra on field in " + element);
                continue;
            }

            // Verify field properties.
            Set<Modifier> modifiers = element.getModifiers();
            if (modifiers.contains(Modifier.PRIVATE)
                    || modifiers.contains(Modifier.PROTECTED)
                    || modifiers.contains(Modifier.STATIC)) {
                error("@Extra fields must not be private, protected, or static: "
                        + enclosingElement.getQualifiedName()
                        + "."
                        + element);
                continue;
            }

            // Get and optionally create a set of all binding points for a type.
            Set<BindingPoint> bindings = bindingsByClass.get(enclosingElement);
            if (bindings == null) {
                bindings = new HashSet<>();
                bindingsByClass.put(enclosingElement, bindings);
            }

            // Assemble information on the binding point.
            String variableName = element.getSimpleName().toString();
            String type = element.asType().toString();
            String value = element.getAnnotation(Extra.class).value();

            if (TypeElementHelper.instanceOf(enclosingElement, Activity.class)) {
                bindings.add(new BindingPoint(ClassType.ACTIVITY, variableName, type, value));
            } else {
                bindings.add(new BindingPoint(ClassType.FRAGMENT, variableName, type, value));
            }

            // Add to the valid binding targets set.
            bindingTargets.add(enclosingElement.asType());
        }

        for (Map.Entry<TypeElement, Set<BindingPoint>> binding : bindingsByClass.entrySet()) {
            TypeElement type = binding.getKey();
            String targetClass = type.getQualifiedName().toString();
            int lastDot = targetClass.lastIndexOf(".");
            String classType = targetClass.substring(lastDot + 1);
            String className = classType + Constants.SUFFIX;
            String packageName = targetClass.substring(0, lastDot);
            StringBuilder bindings = new StringBuilder();
            for (BindingPoint bindingPoint : binding.getValue()) {
                bindings.append(bindingPoint).append("\n");
            }

            // Write the view binder class.
            try {
                JavaFileObject jfo = filer.createSourceFile(packageName + "." + className, type);
                Writer writer = jfo.openWriter();
                if (TypeElementHelper.instanceOf(type, Activity.class)) {
                    writer.write(String.format(Constants.BINDER_ACTIVITY, packageName, className, classType, bindings.toString()));
                } else {
                    writer.write(String.format(Constants.BINDER_FRAGMENT, packageName, className, classType, bindings.toString()));
                }
                writer.flush();
                writer.close();
            } catch (IOException e) {
                error(e.getMessage());
            }
        }

        return true;
    }


    private String resolveParentType(TypeElement typeElement, Set<TypeMirror> parents) {
        TypeMirror type;
        while (true) {
            type = typeElement.getSuperclass();
            if (type.getKind() == TypeKind.NONE) {
                return null;
            }
            if (parents.contains(type)) {
                return type.toString();
            }
            typeElement = (TypeElement) ((DeclaredType) type).asElement();
        }
    }

    private enum ClassType {
        ACTIVITY, FRAGMENT
    }

    private static class BindingPoint {
        private final ClassType classType;
        private final String variableName;
        private final String type;
        private final String value;

        BindingPoint(ClassType classType, String variableName, String type, String value) {
            this.classType = classType;
            this.variableName = variableName;
            this.type = type;
            this.value = value.length() == 0 ? variableName : value;
        }

        @Override
        public String toString() {
            switch (classType) {
                case ACTIVITY:
                    return String.format(Constants.BINDING_ACTIVITY, variableName, type, value);
                case FRAGMENT:
                default:
                    return String.format(Constants.BINDING_FRAGMENT, variableName, type, value);
            }
        }
    }


}
