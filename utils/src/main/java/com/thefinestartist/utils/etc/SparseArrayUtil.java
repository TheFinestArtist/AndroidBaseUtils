package com.thefinestartist.utils.etc;

import android.util.SparseArray;

import java.util.ArrayList;

/**
 * Created by TheFinestArtist on 1/26/16.
 */
public class SparseArrayUtil {

    public static <C> ArrayList<C> asArrayList(SparseArray<C> sparseArray) {
        if (sparseArray == null)
            return new ArrayList<C>();

        ArrayList<C> arrayList = new ArrayList<C>(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++)
            arrayList.add(sparseArray.valueAt(i));
        return arrayList;
    }
}