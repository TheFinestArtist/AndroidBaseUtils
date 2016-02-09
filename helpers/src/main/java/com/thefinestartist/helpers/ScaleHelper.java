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

    public static float toPixel(float dp) {
        DisplayMetrics displayMetrics = Base.getContext().getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
    }

    public static int toPixel(int dp) {
        DisplayMetrics displayMetrics = Base.getContext().getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
    }

    public static float toPixelFromSP(float sp) {
        DisplayMetrics displayMetrics = Base.getContext().getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, displayMetrics);
    }

    public static int toPixelFromSP(int sp) {
        DisplayMetrics displayMetrics = Base.getContext().getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, displayMetrics);
    }
}
