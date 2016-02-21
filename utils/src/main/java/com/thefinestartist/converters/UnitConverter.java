package com.thefinestartist.converters;

import com.thefinestartist.Base;

/**
 * UnitConverter helps to convert dp or sp size into pixel.
 *
 * @author Leonardo Taehwan Kim
 */
public class UnitConverter {

    public static float dpToPx(float dp) {
        return dp * Base.getDisplayMetrics().density;
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Base.getDisplayMetrics().density + 0.5f);
    }

    public static float pxToDp(float px) {
        return px / Base.getDisplayMetrics().density;
    }

    public static int pxToDp(int px) {
        return (int) (px / Base.getDisplayMetrics().density + 0.5f);
    }

    public static float spToPx(float sp) {
        return sp * Base.getDisplayMetrics().scaledDensity;
    }

    public static int spToPx(int sp) {
        return (int) (sp * Base.getDisplayMetrics().scaledDensity + 0.5f);
    }

    public static float pxToSp(float px) {
        return px / Base.getDisplayMetrics().scaledDensity;
    }

    public static int pxToSp(int px) {
        return (int) (px / Base.getDisplayMetrics().scaledDensity + 0.5f);
    }
}