package com.thefinestartist.compilers;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.NoType;

/**
 * Created by TheFinestArtist on 2/9/16.
 */
public class TypeElementUtil {

    private TypeElementUtil() {}

    public static boolean instanceOf(TypeElement typeElement, Class clazz) {
        if (typeElement == null || typeElement instanceof NoType) {
            return false;
        } else if (typeElement.getQualifiedName().toString().equals(clazz.getCanonicalName())) {
            return true;
        } else if (typeElement.getSuperclass() instanceof DeclaredType) {
            return instanceOf((TypeElement) ((DeclaredType) typeElement.getSuperclass()).asElement(), clazz);
        } else {
            return false;
        }
    }
}