package com.thefinestartist.helpers;

import android.graphics.Point;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by TheFinestArtist on 1/25/16.
 */
public class ScreenHelper {

    private static WindowManager windowManager;

    public static WindowManager getWindowManager() {

        if (windowManager == null) {
            synchronized (ScreenHelper.class) {
                if (windowManager == null) {
                    windowManager = ServiceHelper.getSystemService(WindowManager.class);
                }
            }
        }

        return windowManager;
    }

    public static int getDeviceWidth() {
        Display display = getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            Point size = new Point();
            display.getSize(size);
            return size.x;
        } else {
            return display.getWidth();
        }
    }

    public static int getDeviceHeight() {
        Display display = getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            Point size = new Point();
            display.getSize(size);
            return size.y;
        } else {
            return display.getHeight();
        }
    }

    public static int getStatusBarHeight() {
        int resourceId = ResourcesHelper.getIdentifier("status_bar_height", "dimen", "android");
        return resourceId > 0 ?
                ResourcesHelper.getDimensionPixelSize(resourceId) :
                0;
    }

    public static int getActionBarHeight() {
        TypedValue tv = new TypedValue();
        return ThemeHelper.resolveAttribute(android.R.attr.actionBarSize, tv, true) ?
                TypedValueHelper.complexToDimensionPixelSize(tv.data) :
                0;
    }

    public static int getNavigationBarHeight() {
        int resourceId = ResourcesHelper.getIdentifier("navigation_bar_height", "dimen", "android");
        return resourceId > 0 ?
                ResourcesHelper.getDimensionPixelSize(resourceId) :
                0;
    }

}
