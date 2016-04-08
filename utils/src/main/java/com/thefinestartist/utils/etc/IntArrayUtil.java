package com.thefinestartist.utils.etc;

/**
 * IntArrayUtil helps to manage IntArray conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class IntArrayUtil {

    private IntArrayUtil() {}

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
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        return newArray;
    }
}