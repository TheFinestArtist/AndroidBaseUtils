package com.thefinestartist.helpers;

import android.app.Activity;
import android.support.annotation.NonNull;

import java.lang.reflect.Method;

/**
 * Created by TheFinestArtist on 2/7/16.
 */
public class ExtrasHelper {

    static final String SUFFIX = "$$ExtraBinder";

    public static void bind(@NonNull Activity activity) {
        try {
            Class<?> injector = Class.forName(activity.getClass().getName() + SUFFIX);
            Method bind = injector.getMethod("bind", activity.getClass());
            bind.invoke(null, activity);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Unable to bind extras for activity " + activity, e);
        }
    }
}