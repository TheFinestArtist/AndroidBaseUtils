package com.thefinestartist.utils.content;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import com.thefinestartist.Base;

import java.io.File;

/**
 * Created by TheFinestArtist on 2/2/16.
 */
public class ContextUtil {

    // From ContextCompat
    public static boolean startActivities(Intent[] intents) {
        for (Intent intent : intents)
            if (intent != null)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return ContextCompat.startActivities(Base.getContext(), intents);
    }

    public static boolean startActivities(Intent[] intents, Bundle options) {
        for (Intent intent : intents)
            if (intent != null)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return ContextCompat.startActivities(Base.getContext(), intents, options);
    }

    public static File[] getObbDirs() {
        return ContextCompat.getObbDirs(Base.getContext());
    }

    public static File[] getExternalFilesDirs(String type) {
        return ContextCompat.getExternalFilesDirs(Base.getContext(), type);
    }

    public static File[] getExternalCacheDirs() {
        return ContextCompat.getExternalCacheDirs(Base.getContext());
    }

    public static Drawable getDrawable(@DrawableRes int drawableRes) {
        return ContextCompat.getDrawable(Base.getContext(), drawableRes);
    }

    public static ColorStateList getColorStateList(@ColorRes int colorRes) {
        return ContextCompat.getColorStateList(Base.getContext(), colorRes);
    }

    @ColorInt
    public static int getColor(@ColorRes int colorRes) {
        return ContextCompat.getColor(Base.getContext(), colorRes);
    }

    public static int checkSelfPermission(@NonNull String permission) {
        return ContextCompat.checkSelfPermission(Base.getContext(), permission);
    }

    public static File getNoBackupFilesDir() {
        return new ContextCompat().getNoBackupFilesDir(Base.getContext());
    }

    public final File getCodeCacheDir() {
        return new ContextCompat().getCodeCacheDir(Base.getContext());
    }

    // From Context
    public static boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return Base.getContext().bindService(service, conn, flags);
    }

    public static int checkCallingOrSelfPermission(String permission) {
        return Base.getContext().checkCallingOrSelfPermission(permission);
    }

    public static int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        return Base.getContext().checkCallingOrSelfUriPermission(uri, modeFlags);
    }

    public static int checkCallingPermission(String permission) {
        return Base.getContext().checkCallingPermission(permission);
    }

    public static int checkCallingUriPermission(Uri uri, int modeFlags) {
        return Base.getContext().checkCallingUriPermission(uri, modeFlags);
    }

    public static int checkPermission(String permission, int pid, int uid) {
        return Base.getContext().checkPermission(permission, pid, uid);
    }

    public static void sendBroadcast(Intent intent, String receiverPermission) {
        Base.getContext().sendBroadcast(intent, receiverPermission);
    }

    public static void sendBroadcast(Intent intent) {
        Base.getContext().sendBroadcast(intent);
    }

    public static void startActivity(@NonNull Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Base.getContext().startActivity(intent);
    }

    public static ComponentName startService(Intent service) {
        return Base.getContext().startService(service);
    }

    public static boolean stopService(Intent service) {
        return Base.getContext().stopService(service);
    }

    public static void unbindService(ServiceConnection conn) {
        Base.getContext().unbindService(conn);
    }
}