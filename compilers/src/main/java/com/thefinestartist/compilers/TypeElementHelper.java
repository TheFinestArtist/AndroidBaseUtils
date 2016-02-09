package com.thefinestartist.compilers;

import javax.annotation.processing.Messager;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.NoType;
import javax.tools.Diagnostic;

/**
 * Created by TheFinestArtist on 2/9/16.
 */
public class TypeElementHelper {

    public static boolean instanceOf(TypeElement typeElement, Class clazz) {
        if (typeElement == null || typeElement instanceof NoType) {
            return false;
        } else if (typeElement.getQualifiedName().toString().equals(clazz.getCanonicalName())) {
            return true;
        } else if (typeElement.getSuperclass() instanceof  DeclaredType) {
            return instanceOf((TypeElement) ((DeclaredType) typeElement.getSuperclass()).asElement(), clazz);
        } else {
            return false;
        }
    }
}
