package com.thefinestartist.helpers;

import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.thefinestartist.Base;

/**
 * Created by TheFinestArtist on 1/25/16.
 */
public class ScaleHelper {

    public static float applyDimension(int unit, float value) {
        return TypedValue.applyDimension(unit, value, Base.getContext().getResources().getDisplayMetrics());
    }

    public static float applyDimension(int unit, int value) {
        return TypedValue.applyDimension(unit, value, Base.getContext().getResources().getDisplayMetrics());
    }

    public static float toPixel(float density) {
        DisplayMetrics displayMetrics = Base.getContext().getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, density, displayMetrics);
    }

    public static int toPixel(int density) {
        DisplayMetrics displayMetrics = Base.getContext().getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, density, displayMetrics);
    }

    public static float toPixelFromSP(float scale) {
        DisplayMetrics displayMetrics = Base.getContext().getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, scale, displayMetrics);
    }

    public static int toPixelFromSP(int scale) {
        DisplayMetrics displayMetrics = Base.getContext().getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, scale, displayMetrics);
    }
}
