package com.thefinestartist;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.View;

import com.thefinestartist.utils.ui.KeyboardUtil;

/**
 * Base helps to get {@link Context}, {@link Resources}, {@link AssetManager}, {@link Configuration} and {@link DisplayMetrics} in any class.
 *
 * @author Leonardo Taehwan Kim
 */
public class Base {

    private static Context context;

    public static void initialize(@NonNull Context context) {
        Base.context = context;
    }

    public static Context getContext() {
        synchronized (Base.class) {
            if (Base.context == null)
                throw new NullPointerException("Call Base.initialize(context) within your Application onCreate() method.");

            return Base.context.getApplicationContext();
        }
    }

    public static Resources getResources() {
        return Base.getContext().getResources();
    }

    public static AssetManager getAssets() {
        return Base.getContext().getAssets();
    }

    public static Configuration getConfiguration() {
        return Base.getResources().getConfiguration();
    }

    public static DisplayMetrics getDisplayMetrics() {
        return Base.getResources().getDisplayMetrics();
    }

    /**
     * KeyboardUtil
     */
    public static void showKeyboard(View view) {
        KeyboardUtil.show(view);
    }

    public static void showKeyboardImmediately(View view) {
        KeyboardUtil.showImmediately(view);
    }

    public static void hideKeyboard(Fragment fragment) {
        KeyboardUtil.hide(fragment);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void hideKeyboard(android.app.Fragment fragment) {
        KeyboardUtil.hide(fragment);
    }

    public static void hideKeyboard(Activity activity) {
        KeyboardUtil.hide(activity);
    }

    public static void hideKeyboard(Dialog dialog) {
        KeyboardUtil.hide(dialog);
    }

    public static void hideKeyboard(View view) {
        KeyboardUtil.hide(view);
    }
}
// TODO: add ripple, bitmap, time, keystore, contact list, picture list, video list