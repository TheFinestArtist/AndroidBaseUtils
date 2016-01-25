package com.thefinestartist.helpers;

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

    public static void show(final View view) {
        if (view == null) return;

        view.requestFocus();
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                getInputMethodManager().showSoftInput(view, 0);
            }
        }, 200);
    }

    public static void showByUser(View view) {
        if (view == null) return;

        getInputMethodManager().showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public static void hide(View view) {
        if (view == null) return;

        getInputMethodManager().hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void hideByUser(View view) {
        if (view == null) return;

        getInputMethodManager().hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
    }
}