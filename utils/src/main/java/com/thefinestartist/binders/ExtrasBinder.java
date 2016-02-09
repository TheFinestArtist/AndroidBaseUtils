package com.thefinestartist.binders;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import java.lang.reflect.Method;

/**
 * Created by TheFinestArtist on 2/7/16.
 */
public class ExtrasBinder {

    static final String SUFFIX = "$$ExtraBinder";

    public static void bind(@NonNull Activity activity) {
        bindObject(activity);
    }

    public static void bind(@NonNull Fragment fragment) {
        bindObject(fragment);
    }

    public static void bind(@NonNull android.app.Fragment fragment) {
        bindObject(fragment);
    }

    private static void bindObject(@NonNull Object object) {
        try {
            Class<?> binder = Class.forName(object.getClass().getName() + SUFFIX);
            Method bind = binder.getMethod("bind", object.getClass());
            bind.invoke(null, object);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Unable to bind extras for " + object, e);
        }
    }
}