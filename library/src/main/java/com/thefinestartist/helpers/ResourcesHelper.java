package com.thefinestartist.helpers;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.support.annotation.AnimRes;
import android.support.annotation.BoolRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.PluralsRes;
import android.support.annotation.StringRes;
import android.support.annotation.XmlRes;
import android.support.v4.content.ContextCompat;

/**
 * Created by TheFinestArtist on 1/25/16.
 */
public class ResourcesHelper {

    @ColorInt public static int getColor(@ColorRes int colorRes) {
        return ContextCompat.getColor(Base.getContext(), colorRes);
    }

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
}
