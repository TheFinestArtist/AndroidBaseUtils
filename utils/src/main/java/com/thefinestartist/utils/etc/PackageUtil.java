package com.thefinestartist.utils.etc;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.thefinestartist.Base;

/**
 * PackageUtil helps to handle methods related to package.
 *
 * @author Leonardo Taehwan Kim
 */
public class PackageUtil {

    public static final String FACEBOOK = "com.facebook.katana";
    public static final String TWITTER = "com.twitter.android";
    public static final String GOOGLE_PLUS = "com.google.android.apps.plus";
    public static final String GMAIL = "com.google.android.gm";
    public static final String PINTEREST = "com.pinterest";
    public static final String TUMBLR = "com.tumblr";
    public static final String FANCY = "com.thefancy.app";
    public static final String FLIPBOARD = "flipboard.app";
    public static final String KAKAOTALK = "com.kakao.talk";
    public static final String KAKAOSTORY = "com.kakao.story";

    public static boolean isInstalled(String packageName) {
        PackageManager packageManager = Base.getContext().getPackageManager();
        try {
            packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static String getPackageName() {
        return Base.getContext().getPackageName();
    }

    public static void openPlayStore() {
        String packageName = Base.getContext().getPackageName();
        openPlayStore(packageName);
    }

    public static void openPlayStore(String packageName) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Base.getContext().startActivity(intent);
        } catch (ActivityNotFoundException exception) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Base.getContext().startActivity(intent);
        }
    }
}