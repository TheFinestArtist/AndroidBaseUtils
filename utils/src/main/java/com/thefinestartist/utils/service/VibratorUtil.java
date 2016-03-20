package com.thefinestartist.utils.service;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.os.Vibrator;

/**
 * VibratorUtil helps to manage {@link Vibrator} conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class VibratorUtil {

    // No Instance
    private VibratorUtil() {
    }

    @TargetApi(11)
    public static boolean hasVibrator() {
        return ServiceUtil.getVibrator().hasVibrator();
    }

    public static void vibrate() {
        vibrate(200);
    }

    public static void vibrate(long milliseconds) {
        vibrate(new long[]{milliseconds});
    }

    public static void vibrate(long[] pattern) {
        vibrate(pattern, -1);
    }

    public static void vibrate(long[] pattern, int repeat) {
        ServiceUtil.getVibrator().vibrate(pattern, repeat);
    }

    @TargetApi(21)
    public static void vibrate(long milliseconds, AudioAttributes attributes) {
        vibrate(new long[]{milliseconds}, -1, attributes);
    }

    @TargetApi(21)
    public static void vibrate(long[] pattern, int repeat, AudioAttributes attributes) {
        ServiceUtil.getVibrator().vibrate(pattern, repeat, attributes);
    }

    public static void cancel() {
        ServiceUtil.getVibrator().cancel();
    }
}