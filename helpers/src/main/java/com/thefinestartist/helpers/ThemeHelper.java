package com.thefinestartist.helpers;

import android.util.TypedValue;

import com.thefinestartist.Base;

/**
 * Created by TheFinestArtist on 1/25/16.
 */
public class ThemeHelper {

    public static boolean resolveAttribute(int resid, TypedValue outValue, boolean resolveRefs) {
        return Base.getContext().getTheme().resolveAttribute(resid, outValue, resolveRefs);
    }
}
// TODO: do some more