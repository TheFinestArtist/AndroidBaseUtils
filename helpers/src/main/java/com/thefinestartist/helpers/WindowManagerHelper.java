package com.thefinestartist.helpers;

import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * WindowManagerHelper is a helper class which helps to use Android {@link WindowManager} conveniently
 *
 * @author Leonardo Taehwan Kim
 */
public class WindowManagerHelper {

    public static WindowManager getService() {
        return ServiceHelper.getWindowManager();
    }

    public static Display getDefaultDisplay() {
        return getService().getDefaultDisplay();
    }

    public static void removeViewImmediate(View view) {
        getService().removeViewImmediate(view);
    }
}
