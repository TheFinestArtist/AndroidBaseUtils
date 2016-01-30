package com.thefinestartist.helpers;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Vibrator;

/**
 * VibratorHelper is a helper class which helps to use Android {@link Vibrator} conviniently
 *
 * @author Leonardo Taehwan Kim
 */
public class VibratorHelper {

    protected static Vibrator vibrator;

    public static Vibrator getInstance() {

        if (vibrator == null) {
            synchronized (VibratorHelper.class) {
                if (vibrator == null) {
                    vibrator = ServiceHelper.getSystemService(Vibrator.class);
                }
            }
        }

        return vibrator;
    }

    public static boolean hasVibrator() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return getInstance() != null;
        } else {
            return getInstance() != null && getInstance().hasVibrator();
        }
    }

    public static void eee() {
        vibrate(200);
    }

    public static void vibrate(long milliseconds) {
        vibrate(new long[]{milliseconds});
    }

    public static void vibrate(long[] pattern) {
        vibrate(pattern, 1);
    }

    public static void vibrate(long[] pattern, int repeat) {
        if (getInstance() == null)
            return;

        getInstance().vibrate(pattern, repeat);
    }

    @TargetApi(21)
    public static void vibrate(long milliseconds, AudioAttributes attributes) {
        vibrate(new long[]{milliseconds}, 1, attributes);
    }

    @TargetApi(21)
    public static void vibrate(long[] pattern, int repeat, AudioAttributes attributes) {
        if (getInstance() == null)
            return;

        getInstance().vibrate(pattern, repeat, attributes);
    }
}
