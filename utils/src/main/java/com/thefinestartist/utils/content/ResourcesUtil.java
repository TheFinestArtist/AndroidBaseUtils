package com.thefinestartist.utils.content;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.AnyRes;
import android.support.annotation.ArrayRes;
import android.support.annotation.BoolRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.PluralsRes;
import android.support.annotation.RawRes;
import android.support.annotation.StringRes;
import android.support.annotation.XmlRes;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.thefinestartist.Base;
import com.thefinestartist.utils.etc.APILevel;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

/**
 * ResourcesUtil helps to manage {@link Resources} conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class ResourcesUtil {

    private static void finishPreloading() {
        Base.getResources().finishPreloading();
    }

    private static void flushLayoutCache() {
        Base.getResources().flushLayoutCache();
    }

    public static XmlResourceParser getAnimation(@AnimRes int animRes) {
        return Base.getResources().getAnimation(animRes);
    }

    public static AssetManager getAssets() {
        return Base.getResources().getAssets();
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
        if (APILevel.require(23))
            return Base.getResources().getColor(colorRes, theme);
        else
            return getColor(colorRes);
    }

    public static ColorStateList getColorStateList(@ColorRes int colorRes) {
        return ContextUtil.getColorStateList(colorRes);
    }

    public static ColorStateList getColorStateList(@ColorRes int colorRes, Resources.Theme theme) {
        if (APILevel.require(23))
            return Base.getResources().getColorStateList(colorRes, theme);
        else
            return getColorStateList(colorRes);
    }

    public static Configuration getConfiguration() {
        return Base.getConfiguration();
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

    public static DisplayMetrics getDisplayMetrics() {
        return Base.getDisplayMetrics();
    }

    public static Drawable getDrawable(@DrawableRes int drawableRes) {
        return ContextUtil.getDrawable(drawableRes);
    }

    public static Drawable getDrawable(@DrawableRes int drawableRes, Resources.Theme theme) {
        if (APILevel.require(21))
            return Base.getResources().getDrawable(drawableRes, theme);
        else
            return Base.getResources().getDrawable(drawableRes);
    }

    public static Drawable getDrawableForDensity(@DrawableRes int drawableRes, int density) {
        if (APILevel.require(21))
            return Base.getResources().getDrawableForDensity(drawableRes, density, Base.getContext().getTheme());
        else if (APILevel.require(15))
            return Base.getResources().getDrawableForDensity(drawableRes, density);
        else
            return Base.getResources().getDrawable(drawableRes);
    }

    public static float getFraction(int id, int base, int pbase) {
        return Base.getResources().getFraction(id, base, pbase);
    }

    public static int getIdentifier(String name, String defType, String defPackage) {
        return Base.getResources().getIdentifier(name, defType, defPackage);
    }

    public static int[] getIntArray(@ArrayRes int arrayRes) {
        return Base.getResources().getIntArray(arrayRes);
    }

    public static int getInteger(@IntegerRes int integerRes) {
        return Base.getResources().getInteger(integerRes);
    }

    public static XmlResourceParser getLayout(@LayoutRes int layoutRes) {
        return Base.getResources().getLayout(layoutRes);
    }

    public static Movie getMovie(@RawRes int rawRes) {
        return Base.getResources().getMovie(rawRes);
    }

    public static String getQuantityString(int id, int quantity, Object... formatArgs) {
        return Base.getResources().getQuantityString(id, quantity, formatArgs);
    }

    public static String getQuantityString(@PluralsRes int pluralsRes, int quantity) throws Resources.NotFoundException {
        return Base.getResources().getQuantityString(pluralsRes, quantity);
    }

    public static CharSequence getQuantityText(int id, int quantity) {
        return Base.getResources().getQuantityText(id, quantity);
    }

    public static String getResourceEntryName(@AnyRes int anyRes) {
        return Base.getResources().getResourceEntryName(anyRes);
    }

    public static String getResourceName(@AnyRes int anyRes) {
        return Base.getResources().getResourceName(anyRes);
    }

    public static String getResourcePackageName(@AnyRes int anyRes) {
        return Base.getResources().getResourcePackageName(anyRes);
    }

    public static String getResourceTypeName(@AnyRes int anyRes) {
        return Base.getResources().getResourceTypeName(anyRes);
    }

    public static String getString(@StringRes int stringRes) {
        return Base.getResources().getString(stringRes);
    }

    public static String getString(@StringRes int stringRes, Object... formatArgs) {
        return Base.getResources().getString(stringRes, formatArgs);
    }

    public static String[] getStringArray(@ArrayRes int arrayRes) {
        return Base.getResources().getStringArray(arrayRes);
    }

    public static Resources getSystem() {
        return Base.getResources().getSystem();
    }

    public static CharSequence getText(@StringRes int stringRes, CharSequence def) {
        return Base.getResources().getText(stringRes, def);
    }

    public static CharSequence getText(@StringRes int stringRes) {
        return Base.getResources().getText(stringRes);
    }

    public static CharSequence[] getTextArray(@ArrayRes int arrayRes) {
        return Base.getResources().getTextArray(arrayRes);
    }

    public static void getValue(String name, TypedValue outValue, boolean resolveRefs) {
        Base.getResources().getValue(name, outValue, resolveRefs);
    }

    public static void getValue(@AnyRes int anyRes, TypedValue outValue, boolean resolveRefs) {
        Base.getResources().getValue(anyRes, outValue, resolveRefs);
    }

    public static void getValueForDensity(@AnyRes int anyRes, int density, TypedValue outValue, boolean resolveRefs) {
        if (APILevel.require(15))
            Base.getResources().getValueForDensity(anyRes, density, outValue, resolveRefs);
        else
            Base.getResources().getValue(anyRes, outValue, resolveRefs);
    }

    public static XmlResourceParser getXml(@XmlRes int xmlRes) {
        return Base.getResources().getXml(xmlRes);
    }

    public static Resources.Theme newTheme() {
        return Base.getResources().newTheme();
    }

    public static TypedArray obtainAttributes(AttributeSet set, int[] attrs) {
        return Base.getResources().obtainAttributes(set, attrs);
    }

    public static TypedArray obtainTypedArray(@ArrayRes int anyRes) {
        return Base.getResources().obtainTypedArray(anyRes);
    }

    public static InputStream openRawResource(@RawRes int rawRes) {
        return Base.getResources().openRawResource(rawRes);
    }

    public static InputStream openRawResource(@RawRes int rawRes, TypedValue value) {
        return Base.getResources().openRawResource(rawRes, value);
    }

    public static AssetFileDescriptor openRawResourceFd(@RawRes int rawRes) {
        return Base.getResources().openRawResourceFd(rawRes);
    }

    public static void parseBundleExtra(String tagName, AttributeSet attrs, Bundle outBundle) throws XmlPullParserException {
        Base.getResources().parseBundleExtra(tagName, attrs, outBundle);
    }

    public static void parseBundleExtras(XmlResourceParser parser, Bundle outBundle) throws XmlPullParserException, IOException {
        Base.getResources().parseBundleExtras(parser, outBundle);
    }

    public static void updateConfiguration(Configuration config, DisplayMetrics metrics) {
        Base.getResources().updateConfiguration(config, metrics);
    }

    // Added methods
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
}