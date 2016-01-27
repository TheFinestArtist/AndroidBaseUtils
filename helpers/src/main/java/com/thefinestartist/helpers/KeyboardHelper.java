package com.thefinestartist.helpers;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * KeyboardHelper
 * It pops up keyboard to input texts and drops a cursor to a view(final View view, such as EditText)
 *
 * @author The Finest Artist
 */
public class KeyboardHelper {

    private static InputMethodManager inputMethodManager;

    public static InputMethodManager getInputMethodManager() {

        if (inputMethodManager == null) {
            synchronized (KeyboardHelper.class) {
                if (inputMethodManager == null) {
                    inputMethodManager = ServiceHelper.getSystemService(InputMethodManager.class);
                }
            }
        }

        return inputMethodManager;
    }

    public static void showDelayed(final View view) {
        if (view == null) return;
        view.requestFocus();
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                getInputMethodManager().showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
            }
        }, 200);
    }

    /**
     * Please note that this method doesn't guarantee to show keyboard every time
     * Do not use this method in onCreate() or onCreateView() lifecycle
     * @param view
     */
    public static void showImmediately(View view) {
        if (view == null) return;
        view.requestFocus();
        getInputMethodManager().showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public static void hide(Activity activity) {
        if (activity == null) return;
        hide(activity.getCurrentFocus());
    }

    public static void hide(View view) {
        if (view == null) return;
        view.clearFocus();
        getInputMethodManager().hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
    }
}