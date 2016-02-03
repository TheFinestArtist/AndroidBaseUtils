package com.thefinestartist.helpers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

/**
 * KeyboardHelper helps to show and hide keyboard window
 *
 * @author Leonardo Taehwan Kim
 */
public class KeyboardHelper {

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
                // In case view become null after 200 milliseconds
                if (view == null)
                    return;

                view.requestFocus();
                ServiceHelper.getInputMethodManager().showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
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

        // In case showImmediately is called from other than UI thread
        view.post(new Runnable() {
            @Override
            public void run() {
                view.requestFocus();
                ServiceHelper.getInputMethodManager().showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
            }
        });
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

    public static void hide(View view) {
        if (view == null)
            return;

        view.clearFocus();
        ServiceHelper.getInputMethodManager().hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
//TODO: Support keyboard show and hide listener