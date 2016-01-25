package com.thefinestartist.helpers;

import android.content.Context;
import android.support.annotation.NonNull;

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
            throw new NullPointerException("Please call Base.initialize(context) within your Application onCreate() method.");

        return Base.context;
    }
}
