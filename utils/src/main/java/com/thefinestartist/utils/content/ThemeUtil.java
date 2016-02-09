package com.thefinestartist.utils.content;

import android.util.TypedValue;

import com.thefinestartist.Base;

/**
 * Created by TheFinestArtist on 1/25/16.
 */
public class ThemeUtil {

    public static boolean resolveAttribute(int resid, TypedValue outValue, boolean resolveRefs) {
        return Base.getContext().getTheme().resolveAttribute(resid, outValue, resolveRefs);
    }
}
// TODO: do some more