package com.thefinestartist.helpers;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.os.Vibrator;

/**
 * VibratorHelper is a helper class which helps to use Android {@link Vibrator} conveniently
 *
 * @author Leonardo Taehwan Kim
 */
public class VibratorHelper {

    public static Vibrator getService() {
        return ServiceHelper.getVibrator();
    }

    @TargetApi(11)
    public static boolean hasVibrator() {
        return getService().hasVibrator();
    }

    public static void eee() {
        vibrate(200);
    }

    public static void vibrate(long milliseconds) {
        vibrate(new long[]{milliseconds});
    }

    public static void vibrate(long[] pattern) {
        vibrate(pattern, -1);
    }

    public static void vibrate(long[] pattern, int repeat) {
        getService().vibrate(pattern, repeat);
    }

    @TargetApi(21)
    public static void vibrate(long milliseconds, AudioAttributes attributes) {
        vibrate(new long[]{milliseconds}, -1, attributes);
    }

    @TargetApi(21)
    public static void vibrate(long[] pattern, int repeat, AudioAttributes attributes) {
        getService().vibrate(pattern, repeat, attributes);
    }

    public static void cancel() {
        getService().cancel();
    }
}