package com.thefinestartist;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

/**
 * Created by TheFinestArtist on 1/25/16.
 */
public class Base {

    private static Context context;

    public static void initialize(@NonNull Context context) {
        Base.context = context;
    }

    public static Context getContext() {
        if (Base.context == null)
            throw new NullPointerException("Call Base.initialize(context) within your Application onCreate() method.");

        return Base.context.getApplicationContext();
    }

    public static Resources getResources() {
        return Base.getContext().getResources();
    }

    public static Configuration getConfiguration() {
        return Base.getResources().getConfiguration();
    }

    public static DisplayMetrics getDisplayMetrics() {
        return Base.getResources().getDisplayMetrics();
    }
}
// TODO: add ripple, bitmap, time