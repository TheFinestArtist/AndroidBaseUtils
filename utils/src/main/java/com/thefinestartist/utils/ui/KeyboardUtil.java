package com.thefinestartist.utils.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.thefinestartist.utils.etc.ThreadUtil;
import com.thefinestartist.utils.service.ServiceUtil;

/**
 * KeyboardUtil helps to show and hide keyboard conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class KeyboardUtil {

    /**
     * Helps to show keyboard in {@link Activity#onCreate(Bundle)}, {@link Activity#onStart()},
     * {@link Activity#onResume()},
     * {@link MenuItem.OnActionExpandListener#onMenuItemActionExpand(MenuItem)},
     * {@link Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)} and etc
     * This method guarantee to show keyboard every time.
     */
    public static void show(final View view) {
        if (view == null)
            return;

        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                showInMainThread(view);
            }
        }, 200);
    }

    /**
     * Please note that this method does not guarantee to show keyboard every time. To guarantee
     * to show keyboard, please use {@link #show(View)} instead. It doesn't have any delay, use
     * this method when it is able to show keyboard immediately. EX) when user click a button to
     * show keyboard
     */
    public static void showImmediately(final View view) {
        if (view == null)
            return;

        if (ThreadUtil.isMain()) {
            showInMainThread(view);
        } else {
            view.post(new Runnable() {
                @Override
                public void run() {
                    showInMainThread(view);
                }
            });
        }
    }

    private static void showInMainThread(final View view) {
        if (view == null)
            return;

        view.requestFocus();
        ServiceUtil.getInputMethodManager().showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public static void hide(Fragment fragment) {
        if (fragment == null || fragment.getActivity() == null)
            return;

        hide(fragment.getActivity());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void hide(android.app.Fragment fragment) {
        if (fragment == null || fragment.getActivity() == null)
            return;

        hide(fragment.getActivity());
    }

    public static void hide(Activity activity) {
        if (activity == null)
            return;

        hide(activity.getCurrentFocus());
    }

    public static void hide(Dialog dialog) {
        if (dialog == null)
            return;

        hide(dialog.getCurrentFocus());
    }

    public static void hide(View view) {
        if (view == null)
            return;

        view.clearFocus();
        ServiceUtil.getInputMethodManager().hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

//    coordinatorLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//        @Override
//        public void onGlobalLayout() {
//            Rect r = new Rect();
//            coordinatorLayout.getWindowVisibleDisplayFrame(r);
//            if (ResourcesUtil.navigationBarHeight == -1) {
//                ResourcesUtil.navigationBarHeight = coordinatorLayout.getRootView().getHeight() - r.height() - ResourcesUtil.statusBarHeight;
//            }
//            int usableHeight = coordinatorLayout.getRootView().getHeight() - ResourcesUtil.statusBarHeight - ResourcesUtil.navigationBarHeight;
//            int keyboardHeight = usableHeight - r.height();
//            if (isKeyboardOpened) {
//                if (keyboardHeight < 100) {
//                    onKeyboardChanged(usableHeight, keyboardHeight, false);
//                    isKeyboardOpened = false;
//                }
//            } else {
//                if (keyboardHeight > 100) {
//                    onKeyboardChanged(usableHeight, keyboardHeight, true);
//                    isKeyboardOpened = true;
//                }
//            }
//        }
//    });
}
//TODO: Support keyboard show and hide listener
//TODO: Keyboard height