package com.thefinestartist.helpers;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.support.annotation.AnimRes;
import android.support.annotation.BoolRes;
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
public class ResourcesHelper {

    // From Resources.java
    public static String getString(@StringRes int stringRes) {
        return Base.getContext().getString(stringRes);
    }

    public static String getString(@StringRes int stringRes, Object... formatArgs) {
        return Base.getContext().getString(stringRes, formatArgs);
    }

    public static String getQuantityString(@PluralsRes int pluralsRes, int quantity, Object... formatArgs) {
        return Base.getContext().getResources().getQuantityString(pluralsRes, quantity, formatArgs);
    }

    public static String getQuantityString(@PluralsRes int pluralsRes, int quantity) throws Resources.NotFoundException {
        return Base.getContext().getResources().getQuantityString(pluralsRes, quantity);
    }

    public static boolean getBoolean(@BoolRes int boolRes) {
        return Base.getContext().getResources().getBoolean(boolRes);
    }

    public static int getInteger(@IntegerRes int integerRes) {
        return Base.getContext().getResources().getInteger(integerRes);
    }

    public static XmlResourceParser getLayout(@LayoutRes int layoutRes) {
        return Base.getContext().getResources().getLayout(layoutRes);
    }

    public static XmlResourceParser getAnimation(@AnimRes int animRes) {
        return Base.getContext().getResources().getAnimation(animRes);
    }

    public static XmlResourceParser getXml(@XmlRes int xmlRes) {
        return Base.getContext().getResources().getXml(xmlRes);
    }

    public static int getIdentifier(String name, String defType, String defPackage) {
        return Base.getContext().getResources().getIdentifier(name, defType, defPackage);
    }

    public static int getDimensionPixelOffset(@DimenRes int dimenRes) {
        return Base.getContext().getResources().getDimensionPixelOffset(dimenRes);
    }

    public static int getDimensionPixelSize(@DimenRes int dimenRes) {
        return Base.getContext().getResources().getDimensionPixelSize(dimenRes);
    }

}
