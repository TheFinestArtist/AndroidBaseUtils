package com.thefinestartist.compilers;

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
import javax.annotation.processing.Processor;
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
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

/**
 * Created by TheFinestArtist on 2/7/16.
 */
@SupportedAnnotationTypes("com.thefinestartist.annotations.Extra")
public class ExtraCompiler extends AbstractProcessor {

    static final String SUFFIX = "$$ExtraBinder";

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    Processor instance;
    Types typeUtils;
    Elements elementUtils;
    Filer filer;
    Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        instance = this;
        typeUtils = processingEnv.getTypeUtils();
        elementUtils = processingEnv.getElementUtils();
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }

    private void error(String message, Object... args) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, String.format(message, args));
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Map<TypeElement, Set<InjectionPoint>> injectionsByClass =
                new LinkedHashMap<TypeElement, Set<InjectionPoint>>();
        Set<TypeMirror> injectionTargets = new HashSet<TypeMirror>();

        for (Element element : roundEnv.getElementsAnnotatedWith(Extra.class)) {
            // Verify containing type.
            TypeElement enclosingElement = (TypeElement) element.getEnclosingElement();
            if (enclosingElement.getKind() != ElementKind.CLASS) {
                error("Unexpected @InjectView on field in " + element);
                continue;
            }

            // Verify field properties.
            Set<Modifier> modifiers = element.getModifiers();
            if (modifiers.contains(Modifier.PRIVATE)
                    || modifiers.contains(Modifier.PROTECTED)
                    || modifiers.contains(Modifier.STATIC)) {
                error("@InjectView fields must not be private, protected, or static: "
                        + enclosingElement.getQualifiedName()
                        + "."
                        + element);
                continue;
            }

            // Get and optionally create a set of all injection points for a type.
            Set<InjectionPoint> injections = injectionsByClass.get(enclosingElement);
            if (injections == null) {
                injections = new HashSet<InjectionPoint>();
                injectionsByClass.put(enclosingElement, injections);
            }

            // Assemble information on the injection point.
            String variableName = element.getSimpleName().toString();
            String type = element.asType().toString();
            String value = element.getAnnotation(Extra.class).value();
            injections.add(new InjectionPoint(variableName, type, value));

            // Add to the valid injection targets set.
            injectionTargets.add(enclosingElement.asType());
        }

        for (Map.Entry<TypeElement, Set<InjectionPoint>> injection : injectionsByClass.entrySet()) {
            TypeElement type = injection.getKey();
            String targetClass = type.getQualifiedName().toString();
            int lastDot = targetClass.lastIndexOf(".");
            String activityType = targetClass.substring(lastDot + 1);
            String className = activityType + SUFFIX;
            String packageName = targetClass.substring(0, lastDot);
            String parentClass = resolveParentType(type, injectionTargets);
            StringBuilder injections = new StringBuilder();
            if (parentClass != null) {
                injections.append("        ")
                        .append(parentClass)
                        .append(SUFFIX)
                        .append(".inject(activity);\n\n");
            }
            for (InjectionPoint injectionPoint : injection.getValue()) {
                injections.append(injectionPoint).append("\n");
            }

            // Write the view injector class.
            try {
                JavaFileObject jfo =
                        processingEnv.getFiler().createSourceFile(packageName + "." + className, type);
                Writer writer = jfo.openWriter();
                writer.write(String.format(INJECTOR, packageName, className, activityType, injections.toString()));
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

    private static class InjectionPoint {
        private final String variableName;
        private final String type;
        private final String value;

        InjectionPoint(String variableName, String type, String value) {
            this.variableName = variableName;
            this.type = type;
            this.value = value.length() == 0 ? variableName : value;
        }

        @Override
        public String toString() {
            return String.format(INJECTION, variableName, type, value);
        }
    }

    private static final String INJECTION = "        activity.%s = (%s) intent.getSerializableExtra(\"%s\");";
    private static final String INJECTOR = ""
            + "package %s;\n\n"
            + "import android.content.Intent;\n\n"
            + "public class %s {\n"
            + "    public static void bind(%s activity) {\n"
            + "        Intent intent = activity.getIntent();\n"
            + "%s"
            + "    }\n"
            + "}\n";
}

//package com.thefinestartist.helpers.sample;
//
//        import android.content.Intent;
//
//public class SubActivity$$ExtraBinder {
//    public static void bind(SubActivity activity) {
//        Intent intent = activity.getIntent();
//        activity.title = (String) intent.getSerializableExtra("title");
//        activity.content = (int) intent.getSerializableExtra("content");
//    }
//}
