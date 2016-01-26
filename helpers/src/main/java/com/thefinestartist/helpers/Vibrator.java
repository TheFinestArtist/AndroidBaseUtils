package com.thefinestartist.helpers;

import android.content.Context;

/**
 * Created by TheFinestArtist on 5/14/15.
 */
public class Vibrator {
    public static void eee() {
        android.os.Vibrator vibrator = ServiceHelper.getSystemService(android.os.Vibrator.class);
        vibrator.vibrate(200);
    }
}
