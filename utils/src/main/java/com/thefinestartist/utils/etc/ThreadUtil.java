package com.thefinestartist.utils.etc;

import android.os.Looper;

/**
 * Created by TheFinestArtist on 2/16/16.
 */
public class ThreadUtil {

    public static boolean isMain() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
