package com.thefinestartist.utils.ui;

import android.util.TypedValue;

import com.thefinestartist.utils.content.TypedValueUtil;

/**
 * ScaleUtil helps to convert dp or sp size into pixel.
 */
public class ScaleUtil {

    public static float applyDimension(int unit, float value) {
        return TypedValueUtil.applyDimension(unit, value);
    }

    public static float applyDimension(int unit, int value) {
        return TypedValueUtil.applyDimension(unit, value);
    }

    public static float toPixel(float dp) {
        return TypedValueUtil.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp);
    }

    public static int toPixel(int dp) {
        return (int) TypedValueUtil.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp);
    }

    public static float toPixelFromSP(float sp) {
        return TypedValueUtil.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp);
    }

    public static int toPixelFromSP(int sp) {
        return (int) TypedValueUtil.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp);
    }
}