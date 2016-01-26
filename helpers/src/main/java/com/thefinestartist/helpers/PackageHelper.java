package com.thefinestartist.helpers;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

/**
 * Created by TheFinestArtist on 1/26/16.
 */
public class PackageHelper {

    public static String FACEBOOK = "com.facebook.katana";
    public static String TWITTER = "com.twitter.android";
    public static String GOOGLE_PLUS = "com.google.android.apps.plus";
    public static String GMAIL = "com.google.android.gm";
    public static String PINTEREST = "com.pinterest";
    public static String TUMBLR = "com.tumblr";
    public static String FANCY = "com.thefancy.app";
    public static String FLIPBOARD = "flipboard.app";
    public static String KAKAOTALK = "com.kakao.talk";
    public static String KAKAOSTORY = "com.kakao.story";

    public static boolean isInstalled(String packageUri) {
        PackageManager packageManager = Base.getContext().getPackageManager();
        try {
            packageManager.getPackageInfo(packageUri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static void updateApp() {
        String packageName = Base.getContext().getPackageName();
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Base.getContext().startActivity(intent);
        } catch (android.content.ActivityNotFoundException anfe) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Base.getContext().startActivity(intent);
        }
    }
}
