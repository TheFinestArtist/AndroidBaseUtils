package com.thefinestartist.helpers;

import android.graphics.Point;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;

/**
 * ScreenHelper is a helper class which helps to calculate screen size conveniently
 *
 * @author Leonardo Taehwan Kim
 */
public class ScreenHelper {

    public static int getDeviceWidth() {
        Display display = WindowManagerHelper.getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            Point size = new Point();
            display.getSize(size);
            return size.x;
        } else {
            return display.getWidth();
        }
    }

    public static int getDeviceHeight() {
        Display display = WindowManagerHelper.getDefaultDisplay();
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
