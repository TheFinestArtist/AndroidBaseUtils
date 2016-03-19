package com.thefinestartist.utils.etc;

import android.os.Looper;

/**
 * ThreadUtil helps to deal with thread conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class ThreadUtil {

    // No Instance
    private ThreadUtil() {
    }

    public static boolean isMain() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}