package com.thefinestartist.utils.etc;

import android.util.TypedValue;

import com.thefinestartist.Base;

/**
 * Created by TheFinestArtist on 1/25/16.
 */
public class TypedValueUtil {

    public static int complexToDimensionPixelSize(int data) {
        return TypedValue.complexToDimensionPixelSize(data, Base.getResources().getDisplayMetrics());
    }
}
// TODO: do some more