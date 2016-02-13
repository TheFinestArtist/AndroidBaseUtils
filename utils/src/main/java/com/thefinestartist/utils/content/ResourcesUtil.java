package com.thefinestartist.utils.content;

import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.support.annotation.AnimRes;
import android.support.annotation.ArrayRes;
import android.support.annotation.BoolRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.PluralsRes;
import android.support.annotation.StringRes;
import android.support.annotation.XmlRes;

import com.thefinestartist.Base;

/**
 * Created by TheFinestArtist on 1/25/16.
 */
public class ResourcesUtil {

    // From Resources.java
    private static void finishPreloading() {
        Base.getResources().finishPreloading();
    }

    private static void flushLayoutCache() {
        Base.getResources().flushLayoutCache();
    }

    public static AssetManager getAssets() {
        return Base.getResources().getAssets();
    }

    public static XmlResourceParser getAnimation(@AnimRes int animRes) {
        return Base.getResources().getAnimation(animRes);
    }

    public static boolean getBoolean(@BoolRes int boolRes) {
        return Base.getResources().getBoolean(boolRes);
    }

    @ColorInt
    public static int getColor(@ColorRes int colorRes) {
        return ContextUtil.getColor(colorRes);
    }

    @ColorInt
    public static int getColor(@ColorRes int colorRes, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            return Base.getResources().getColor(colorRes, theme);
        else
            return getColor(colorRes);
    }

    public static ColorStateList getColorStateList(@ColorRes int colorRes) {
        return ContextUtil.getColorStateList(colorRes);
    }

    public static ColorStateList getColorStateList(@ColorRes int colorRes, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            return Base.getResources().getColorStateList(colorRes, theme);
        else
            return getColorStateList(colorRes);
    }

    public static Configuration getConfiguration() {
        return Base.getConfiguration();
    }

    public static String getString(@StringRes int stringRes) {
        return Base.getContext().getString(stringRes);
    }

    public static String getString(@StringRes int stringRes, Object... formatArgs) {
        return Base.getContext().getString(stringRes, formatArgs);
    }

    public static String getQuantityString(@PluralsRes int pluralsRes, int quantity, Object... formatArgs) {
        return Base.getResources().getQuantityString(pluralsRes, quantity, formatArgs);
    }

    public static String getQuantityString(@PluralsRes int pluralsRes, int quantity) throws Resources.NotFoundException {
        return Base.getResources().getQuantityString(pluralsRes, quantity);
    }

    public static int getInteger(@IntegerRes int integerRes) {
        return Base.getResources().getInteger(integerRes);
    }

    public static int[] getColorArray(@ArrayRes int array) {
        if (array == 0)
            return null;

        TypedArray typedArray = Base.getResources().obtainTypedArray(array);
        int[] colors = new int[typedArray.length()];
        for (int i = 0; i < typedArray.length(); i++)
            colors[i] = typedArray.getColor(i, 0);
        typedArray.recycle();
        return colors;
    }

    public static XmlResourceParser getLayout(@LayoutRes int layoutRes) {
        return Base.getResources().getLayout(layoutRes);
    }

    public static XmlResourceParser getXml(@XmlRes int xmlRes) {
        return Base.getResources().getXml(xmlRes);
    }

    public static int getIdentifier(String name, String defType, String defPackage) {
        return Base.getResources().getIdentifier(name, defType, defPackage);
    }

    public static float getDimension(@DimenRes int dimenRes) {
        return Base.getResources().getDimension(dimenRes);
    }

    public static int getDimensionPixelOffset(@DimenRes int dimenRes) {
        return Base.getResources().getDimensionPixelOffset(dimenRes);
    }

    public static int getDimensionPixelSize(@DimenRes int dimenRes) {
        return Base.getResources().getDimensionPixelSize(dimenRes);
    }
}