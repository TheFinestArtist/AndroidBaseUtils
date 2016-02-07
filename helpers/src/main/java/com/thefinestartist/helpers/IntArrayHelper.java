package com.thefinestartist.helpers;

/**
 * IntArrayHelper
 * <p/>
 * Created by TheFinestArtist
 */
public class IntArrayHelper {

    public static boolean contains(int[] array, int value) {
        if (array == null)
            return false;

        for (int i : array)
            if (i == value)
                return true;
        return false;
    }

    public static int[] add(int[] array, int value) {
        if (array == null)
            return new int[]{value};

        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i];
        newArray[array.length] = value;

        return newArray;
    }

}