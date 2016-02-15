package com.thefinestartist;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;

import com.thefinestartist.binders.ExtrasBinder;
import com.thefinestartist.converters.UnitConverter;
import com.thefinestartist.utils.content.ResourcesUtil;
import com.thefinestartist.utils.content.ThemeUtil;
import com.thefinestartist.utils.content.TypedValueUtil;
import com.thefinestartist.utils.service.WindowManagerUtil;
import com.thefinestartist.utils.ui.KeyboardUtil;
import com.thefinestartist.utils.ui.ScreenUtil;

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
     * ExtrasBinder
     */
    public static void bindExtras(Activity activity) {
        ExtrasBinder.bind(activity);
    }

    public static void bindExtras(Fragment fragment) {
        ExtrasBinder.bind(fragment);
    }

    public static void bindExtras(android.app.Fragment fragment) {
        ExtrasBinder.bind(fragment);
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

    /**
     * UnitConverter
     */
    public static float dpToPx(float dp) {
        return UnitConverter.dpToPx(dp);
    }

    public static int dpToPx(int dp) {
        return UnitConverter.dpToPx(dp);
    }

    public static float pxToDp(float px) {
        return UnitConverter.pxToDp(px);
    }

    public static int pxToDp(int px) {
        return UnitConverter.pxToDp(px);
    }

    public static float spToPx(float sp) {
        return UnitConverter.spToPx(sp);
    }

    public static int spToPx(int sp) {
        return UnitConverter.spToPx(sp);
    }

    public static float pxToSp(float px) {
        return UnitConverter.pxToSp(px);
    }

    public static int pxToSp(int px) {
        return UnitConverter.pxToSp(px);
    }

    /**
     * ScreenUtil
     */
    public static int getDeviceWidth() {
        return ScreenUtil.getDeviceWidth();
    }

    public static int getDeviceHeight() {
        return ScreenUtil.getDeviceHeight();
    }

    public static ScreenUtil.Rotation getRotation() {
        return ScreenUtil.getRotation();
    }

    public static int getStatusBarHeight() {
        return ScreenUtil.getStatusBarHeight();
    }

    public static int getToolbarHeight() {
        return ScreenUtil.getToolbarHeight();
    }

    public static int getActionBarHeight() {
        return ScreenUtil.getActionBarHeight();
    }

    public static int getNavigationBarHeight() {
        return ScreenUtil.getNavigationBarHeight();
    }
}
// TODO: add ripple, bitmap, time, keystore, contact list, picture list, video list