package com.thefinestartist.utils.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
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
 * ContextUtil helps to use {@link Context} conveniently.
 *
 * @author Leonardo Taehwan Kim
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

    public static int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return Base.getContext().checkUriPermission(uri, pid, uid, modeFlags);
    }

    public static int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        return Base.getContext().checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags);
    }

    public static Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        return Base.getContext().createPackageContext(packageName, flags);
    }

    public static String[] databaseList() {
        return Base.getContext().databaseList();
    }

    public static boolean deleteDatabase(String name) {
        return Base.getContext().deleteDatabase(name);
    }

    public static boolean deleteFile(String name) {
        return Base.getContext().deleteFile(name);
    }

    public static void enforceCallingOrSelfPermission(String permission, String message) {
        Base.getContext().enforceCallingOrSelfPermission(permission, message);
    }

    public static void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        Base.getContext().enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    public static void enforceCallingPermission(String permission, String message) {
        Base.getContext().enforceCallingPermission(permission, message);
    }

    public static void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        Base.getContext().enforceCallingUriPermission(uri, modeFlags, message);
    }

    public static void enforcePermission(String permission, int pid, int uid, String message) {
        Base.getContext().enforcePermission(permission, pid, uid, message);
    }

    public static void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        Base.getContext().enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    public static void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        Base.getContext().enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
    }

    public static String[] fileList() {
        return Base.getContext().fileList();
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
} // TODO: do some more