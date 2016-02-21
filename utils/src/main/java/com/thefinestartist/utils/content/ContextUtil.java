package com.thefinestartist.utils.content;

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
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import com.thefinestartist.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

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

    public static File getCodeCacheDir() {
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
        return Base.getContext().getCodeCacheDir();
    }

    public static int getColor(int id) {

    }

    public static ColorStateList getColorStateList(int id) {

    }

    public static ContentResolver getContentResolver() {

    }

    public static File getDatabasePath(String name) {

    }

    public static File getDir(String name, int mode) {

    }

    public static Drawable getDrawable(int id) {

    }

    public static File getExternalCacheDir() {

    }

    public static File[] getExternalCacheDirs() {

    }

    public static File getExternalFilesDir(String type) {

    }

    public static File[] getExternalMediaDirs() {

    }

    public static File getFileStreamPath(String name) {

    }

    public static File getFilesDir() {

    }

    public static Looper getMainLooper() {

    }

    public static File getNoBackupFilesDir() {

    }

    public static File getObbDir() {

    }

    public static File[] getObbDirs() {

    }

    public static String getPackageCodePath() {

    }

    public static PackageManager getPackageManager() {

    }

    public static String getPackageName() {

    }

    public static String getPackageResourcePath() {

    }

    public static Resources getResources() {

    }

    public static SharedPreferences getSharedPreferences(String name, int mode) {

    }

    public static String getString(int resId) {

    }

    public static String getString(int resId, Object... formatArgs) {

    }

    public static T getSystemService(Class<T> serviceClass) {

    }

    public static Object getSystemService(String name) {

    }

    public static String getSystemServiceName(Class<?> serviceClass) {

    }

    public static CharSequence getText(int resId) {

    }

    public static Resources.Theme getTheme() {

    }

    public static Drawable getWallpaper() {

    }

    public static int getWallpaperDesiredMinimumHeight() {

    }

    public static int getWallpaperDesiredMinimumWidth() {

    }

    public static void grantUriPermission(String toPackage, Uri uri, int modeFlags) {

    }

    public boolean isRestricted() {

    }

    public static TypedArray obtainStyledAttributes(int[] attrs) {

    }

    public static TypedArray obtainStyledAttributes(AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes) {

    }

    public static TypedArray obtainStyledAttributes(AttributeSet set, int[] attrs) {

    }

    public static TypedArray obtainStyledAttributes(int resid, int[] attrs) {

    }

    public static FileInputStream openFileInput(String name) {

    }

    public static FileOutputStream openFileOutput(String name, int mode) {

    }

    public static SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {

    }

    public static SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {

    }

    public static Drawable peekWallpaper() {

    }

    public static void registerComponentCallbacks(ComponentCallbacks callback) {

    }

    public static Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {

    }

    public static Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {

    }

    public static void removeStickyBroadcast(Intent intent) {

    }

    public static void removeStickyBroadcastAsUser(Intent intent, UserHandle user) {

    }

    public static void revokeUriPermission(Uri uri, int modeFlags) {

    }

    public static void sendBroadcast(Intent intent, String receiverPermission) {
        Base.getContext().sendBroadcast(intent, receiverPermission);
    }

    public static void sendBroadcast(Intent intent) {
        Base.getContext().sendBroadcast(intent);
    }

    public static void sendBroadcastAsUser(Intent intent, UserHandle user) {

    }

    public static void sendBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission) {

    }

    public static void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {

    }

    public static void sendOrderedBroadcast(Intent intent, String receiverPermission) {

    }

    public static void sendOrderedBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {

    }

    public static void sendStickyBroadcast(Intent intent) {

    }

    public static void sendStickyBroadcastAsUser(Intent intent, UserHandle user) {

    }

    public static void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {

    }

    public static void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle user, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {

    }

    public static void setTheme(int resid) {

    }

    public static void setWallpaper(InputStream data) {

    }

    public static void setWallpaper(Bitmap bitmap) {

    }

    public static void startActivities(Intent[] intents, Bundle options) {

    }

    public static void startActivities(Intent[] intents) {

    }

    public static void startActivity(@NonNull Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Base.getContext().startActivity(intent);
    }

    public static void startActivity(Intent intent, Bundle options) {

    }

    public static boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {

    }

    public static void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) {

    }

    public static void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) {

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

    public void unregisterComponentCallbacks(ComponentCallbacks callback) {

    }

    public static void unregisterReceiver(BroadcastReceiver receiver) {

    }
}