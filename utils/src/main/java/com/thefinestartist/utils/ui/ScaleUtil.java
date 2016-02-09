package com.thefinestartist.utils.ui;

import android.util.TypedValue;

import com.thefinestartist.utils.content.TypedValueUtil;

/**
 * Created by TheFinestArtist on 1/25/16.
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