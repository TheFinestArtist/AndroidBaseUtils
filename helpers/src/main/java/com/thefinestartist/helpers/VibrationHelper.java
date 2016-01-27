package com.thefinestartist.helpers;

import android.annotation.TargetApi;
import android.os.Vibrator;

/**
 * Created by TheFinestArtist on 5/14/15.
 */
public class VibrationHelper {

    private static Vibrator vibrator;

    public static Vibrator getVibrator() {

        if (vibrator == null) {
            synchronized (VibrationHelper.class) {
                if (vibrator == null) {
                    vibrator = ServiceHelper.getSystemService(Vibrator.class);
                }
            }
        }

        return vibrator;
    }

    public static void eee() {
        getVibrator().vibrate(200);
    }

    @TargetApi(11)
    public static boolean hasVibrator() {
        return getVibrator().hasVibrator();
    }

    public static void vibrate(long milliseconds) {
        getVibrator().vibrate(milliseconds);
    }

    public static void vibrate(long[] pattern) {
        getVibrator().vibrate(pattern, 1);
    }

    public static void vibrate(long[] pattern, int repeat) {
        getVibrator().vibrate(pattern, repeat);
    }
}
