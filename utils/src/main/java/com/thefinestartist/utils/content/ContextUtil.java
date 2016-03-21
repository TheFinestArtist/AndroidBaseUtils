package com.thefinestartist.utils.content;

import android.annotation.TargetApi;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.annotation.StyleableRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import com.thefinestartist.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ContextUtil helps to manage {@link Context} conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class ContextUtil {

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

    public static int checkSelfPermission(@NonNull String permission) {
        return ContextCompat.checkSelfPermission(Base.getContext(), permission);
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

    public static Context getApplicationContext() {
        return Base.getContext().getApplicationContext();
    }

    public static ApplicationInfo getApplicationInfo() {
        return Base.getContext().getApplicationInfo();
    }

    public static AssetManager getAssets() {
        return Base.getContext().getAssets();
    }

    public static File getCacheDir() {
        return Base.getContext().getCacheDir();
    }

    public static ClassLoader getClassLoader() {
        return Base.getContext().getClassLoader();
    }

    public static File getCodeCacheDir() {
        return new ContextCompat().getCodeCacheDir(Base.getContext());
    }

    @ColorInt
    public static int getColor(@ColorRes int colorRes) {
        return ContextCompat.getColor(Base.getContext(), colorRes);
    }

    public static ColorStateList getColorStateList(@ColorRes int colorRes) {
        return ContextCompat.getColorStateList(Base.getContext(), colorRes);
    }

    public static ContentResolver getContentResolver() {
        return Base.getContext().getContentResolver();
    }

    public static File getDatabasePath(String name) {
        return Base.getContext().getDatabasePath(name);
    }

    public static File getDir(String name, int mode) {
        return Base.getContext().getDir(name, mode);
    }

    public static Drawable getDrawable(@DrawableRes int drawableRes) {
        return ContextCompat.getDrawable(Base.getContext(), drawableRes);
    }

    @Nullable
    @TargetApi(8)
    public static File getExternalCacheDir() {
        return Base.getContext().getExternalCacheDir();
    }

    public static File[] getExternalCacheDirs() {
        return ContextCompat.getExternalCacheDirs(Base.getContext());
    }

    @Nullable
    @TargetApi(8)
    public static File getExternalFilesDir(String type) {
        return Base.getContext().getExternalFilesDir(type);
    }

    public static File[] getExternalFilesDirs(String type) {
        return ContextCompat.getExternalFilesDirs(Base.getContext(), type);
    }

    @TargetApi(21)
    public static File[] getExternalMediaDirs() {
        return Base.getContext().getExternalMediaDirs();
    }

    public static File getFileStreamPath(String name) {
        return Base.getContext().getFileStreamPath(name);
    }

    public static File getFilesDir() {
        return Base.getContext().getFilesDir();
    }

    public static Looper getMainLooper() {
        return Base.getContext().getMainLooper();
    }

    public static File getNoBackupFilesDir() {
        return new ContextCompat().getNoBackupFilesDir(Base.getContext());
    }

    @TargetApi(11)
    public static File getObbDir() {
        return Base.getContext().getObbDir();
    }

    public static File[] getObbDirs() {
        return ContextCompat.getObbDirs(Base.getContext());
    }

    @TargetApi(8)
    public static String getPackageCodePath() {
        return Base.getContext().getPackageCodePath();
    }

    public static PackageManager getPackageManager() {
        return Base.getContext().getPackageManager();
    }

    public static String getPackageName() {
        return Base.getContext().getPackageName();
    }

    @TargetApi(8)
    public static String getPackageResourcePath() {
        return Base.getContext().getPackageResourcePath();
    }

    public static Resources getResources() {
        return Base.getContext().getResources();
    }

    public static SharedPreferences getSharedPreferences(String name, int mode) {
        return Base.getContext().getSharedPreferences(name, mode);
    }

    public static String getString(@StringRes int stringRes) {
        return Base.getContext().getString(stringRes);
    }

    public static String getString(@StringRes int stringRes, Object... formatArgs) {
        return Base.getContext().getString(stringRes, formatArgs);
    }

    @TargetApi(23)
    public static <T> T getSystemService(Class<T> serviceClass) {
        return Base.getContext().getSystemService(serviceClass);
    }

    public static Object getSystemService(String name) {
        return Base.getContext().getSystemService(name);
    }

    @TargetApi(23)
    public static String getSystemServiceName(Class<?> serviceClass) {
        return Base.getContext().getSystemServiceName(serviceClass);
    }

    public static CharSequence getText(@StringRes int stringRes) {
        return Base.getContext().getText(stringRes);
    }

    public static Resources.Theme getTheme() {
        return Base.getContext().getTheme();
    }

    public static Drawable getWallpaper() {
        return WallpaperManager.getInstance(Base.getContext()).getDrawable();
    }

    public static int getWallpaperDesiredMinimumHeight() {
        return WallpaperManager.getInstance(Base.getContext()).getDesiredMinimumHeight();
    }

    public static int getWallpaperDesiredMinimumWidth() {
        return WallpaperManager.getInstance(Base.getContext()).getDesiredMinimumWidth();
    }

    public static void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        Base.getContext().grantUriPermission(toPackage, uri, modeFlags);
    }

    public static boolean isRestricted() {
        return Base.getContext().isRestricted();
    }

    public static TypedArray obtainStyledAttributes(@StyleableRes int[] attrs) {
        return Base.getContext().obtainStyledAttributes(attrs);
    }

    public static TypedArray obtainStyledAttributes(AttributeSet set, @StyleableRes int[] attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        return Base.getContext().obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes);
    }

    public static TypedArray obtainStyledAttributes(AttributeSet set, @StyleableRes int[] attrs) {
        return Base.getContext().obtainStyledAttributes(set, attrs);
    }

    public static TypedArray obtainStyledAttributes(@StyleRes int resid, @StyleableRes int[] attrs) {
        return Base.getContext().obtainStyledAttributes(resid, attrs);
    }

    public static FileInputStream openFileInput(String name) throws FileNotFoundException {
        return Base.getContext().openFileInput(name);
    }

    public static FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        return Base.getContext().openFileOutput(name, mode);
    }

    public static SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        return Base.getContext().openOrCreateDatabase(name, mode, factory);
    }

    @TargetApi(11)
    public static SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return Base.getContext().openOrCreateDatabase(name, mode, factory, errorHandler);
    }

    public static Drawable peekWallpaper() {
        return WallpaperManager.getInstance(Base.getContext()).peekDrawable();
    }

    @TargetApi(14)
    public static void registerComponentCallbacks(ComponentCallbacks callback) {
        Base.getContext().registerComponentCallbacks(callback);
    }

    public static Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return Base.getContext().registerReceiver(receiver, filter);
    }

    public static Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        return Base.getContext().registerReceiver(receiver, filter, broadcastPermission, scheduler);
    }

//    public static void removeStickyBroadcast(Intent intent) {
//        Base.getContext().removeStickyBroadcast(intent);
//    }
//
//    @TargetApi(17)
//    public static void removeStickyBroadcastAsUser(Intent intent, UserHandle user) {
//        Base.getContext().removeStickyBroadcastAsUser(intent, user);
//    }

    public static void revokeUriPermission(Uri uri, int modeFlags) {
        Base.getContext().revokeUriPermission(uri, modeFlags);
    }

    public static void sendBroadcast(Intent intent, String receiverPermission) {
        Base.getContext().sendBroadcast(intent, receiverPermission);
    }

    public static void sendBroadcast(Intent intent) {
        Base.getContext().sendBroadcast(intent);
    }

    @TargetApi(17)
    public static void sendBroadcastAsUser(Intent intent, UserHandle user) {
        Base.getContext().sendBroadcastAsUser(intent, user);
    }

    @TargetApi(17)
    public static void sendBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission) {
        Base.getContext().sendBroadcastAsUser(intent, user, receiverPermission);
    }

    public static void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        Base.getContext().sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

    public static void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        Base.getContext().sendOrderedBroadcast(intent, receiverPermission);
    }

    @TargetApi(17)
    public static void sendOrderedBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        Base.getContext().sendOrderedBroadcastAsUser(intent, user, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

//    public static void sendStickyBroadcast(Intent intent) {
//        Base.getContext().sendStickyBroadcast(intent);
//    }
//
//    @TargetApi(17)
//    public static void sendStickyBroadcastAsUser(Intent intent, UserHandle user) {
//        Base.getContext().sendStickyBroadcastAsUser(intent, user);
//    }
//
//    public static void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
//        Base.getContext().sendStickyOrderedBroadcast(intent, resultReceiver, scheduler, initialCode, initialData, initialExtras);
//    }
//
//    @TargetApi(17)
//    public static void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle user, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
//        Base.getContext().sendStickyOrderedBroadcastAsUser(intent, user, resultReceiver, scheduler, initialCode, initialData, initialExtras);
//    }

    public static void setTheme(@StyleRes int styleRes) {
        Base.getContext().setTheme(styleRes);
    }

    public static void setWallpaper(InputStream data) throws IOException {
        WallpaperManager.getInstance(Base.getContext()).setStream(data);
    }

    public static void setWallpaper(Bitmap bitmap) throws IOException {
        WallpaperManager.getInstance(Base.getContext()).setBitmap(bitmap);
    }

    public static boolean startActivities(Intent[] intents, Bundle options) {
        for (Intent intent : intents)
            if (intent != null)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return ContextCompat.startActivities(Base.getContext(), intents, options);
    }

    public static boolean startActivities(Intent[] intents) {
        for (Intent intent : intents)
            if (intent != null)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return ContextCompat.startActivities(Base.getContext(), intents);
    }

    public static void startActivity(@NonNull Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Base.getContext().startActivity(intent);
    }

    @TargetApi(16)
    public static void startActivity(Intent intent, Bundle options) {
        Base.getContext().startActivity(intent, options);
    }

    public static boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        return Base.getContext().startInstrumentation(className, profileFile, arguments);
    }

    @TargetApi(16)
    public static void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        Base.getContext().startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    public static void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        Base.getContext().startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
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

    @TargetApi(14)
    public static void unregisterComponentCallbacks(ComponentCallbacks callback) {
        Base.getContext().unregisterComponentCallbacks(callback);
    }

    public static void unregisterReceiver(BroadcastReceiver receiver) {
        Base.getContext().unregisterReceiver(receiver);
    }
}