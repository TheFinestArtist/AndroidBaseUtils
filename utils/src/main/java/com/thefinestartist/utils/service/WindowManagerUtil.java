package com.thefinestartist.utils.service;

import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.thefinestartist.utils.service.ServiceUtil;

/**
 * WindowManagerUtil is a helper class which helps to use Android {@link WindowManager} conveniently
 *
 * @author Leonardo Taehwan Kim
 */
public class WindowManagerUtil {

    public static WindowManager getService() {
        return ServiceUtil.getWindowManager();
    }

    public static Display getDefaultDisplay() {
        return getService().getDefaultDisplay();
    }

    public static void removeViewImmediate(View view) {
        getService().removeViewImmediate(view);
    }
}
