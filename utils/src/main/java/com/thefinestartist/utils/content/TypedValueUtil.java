package com.thefinestartist.utils.content;

import android.util.TypedValue;

import com.thefinestartist.Base;

/**
 * TypedValueUtil helps to manage {@link TypedValue} class conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class TypedValueUtil {

    public static float applyDimension(int unit, float value) {
        return TypedValue.applyDimension(unit, value, Base.getDisplayMetrics());
    }

    public static float complexToDimension(int data) {
        return TypedValue.complexToDimension(data, Base.getDisplayMetrics());
    }

    public static int complexToDimensionPixelOffset(int data) {
        return TypedValue.complexToDimensionPixelOffset(data, Base.getDisplayMetrics());
    }

    public static int complexToDimensionPixelSize(int data) {
        return TypedValue.complexToDimensionPixelSize(data, Base.getDisplayMetrics());
    }
}