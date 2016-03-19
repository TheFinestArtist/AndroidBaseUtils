package com.thefinestartist.utils.service;

import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * WindowManagerUtil helps to use {@link WindowManager} conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class WindowManagerUtil {

    // No Instance
    private WindowManagerUtil() {
    }

    public static Display getDefaultDisplay() {
        return ServiceUtil.getWindowManager().getDefaultDisplay();
    }

    public static void removeViewImmediate(View view) {
        ServiceUtil.getWindowManager().removeViewImmediate(view);
    }
}