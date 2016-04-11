package com.thefinestartist.binders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import java.lang.reflect.Method;

/**
 * ExtrasBinder binds data from {@link Intent} or {@link Bundle} to matching variable.
 *
 * @author Leonardo Taehwan Kim
 */
public class ExtrasBinder {

    private ExtrasBinder() {}

    static final String SUFFIX = "$$ExtraBinder";

    public static void bind(Activity activity) {
        if (activity == null)
            return;

        bindObject(activity);
    }

    public static void bind(Fragment fragment) {
        if (fragment == null)
            return;

        bindObject(fragment);
    }

    public static void bind(android.app.Fragment fragment) {
        if (fragment == null)
            return;

        bindObject(fragment);
    }

    private static void bindObject(@NonNull Object object) {
        try {
            Class<?> binder = Class.forName(object.getClass().getName() + SUFFIX);
            Method bind = binder.getMethod("bind", object.getClass());
            bind.invoke(null, object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Unable to bind extras for " + object, e);
        }
    }
}