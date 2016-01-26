package com.thefinestartist.widgets;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.thefinestartist.helpers.ResourcesHelper;

/**
 * Snackbars
 *
 * @author The Finest Artist
 */
public class Snackbars {

    public static void show(@NonNull Activity activity, final String message) {
        final View content = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        if (content == null)
            return;

//        Snackbar snackbar = Snackbar.make(content, message, Snackbar.LENGTH_LONG);
//        snackbar.setActionTextColor(getColor(activity, R.color.orange));
//        View view = snackbar.getView();
//        view.setBackgroundColor(ResourcesHelper.getColor(R.color.white));
//        TextView textView = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
//        textView.setTextColor(getColor(activity, R.color.orange));
//        textView.setLineSpacing(0, 1.1f);
//        textView.setIncludeFontPadding(false);
//        snackbar.show();
    }

    public static void alert(@NonNull final Activity activity, final String message) {
        final View content = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        if (content == null)
            return;

//        Snackbar snackbar = Snackbar.make(content, message, Snackbar.LENGTH_LONG);
//        snackbar.setActionTextColor(getColor(activity, R.color.white));
//        View view = snackbar.getView();
//        view.setBackgroundColor(getColor(activity, R.color.orange));
//        TextView textView = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
//        textView.setTextColor(getColor(activity, R.color.white));
//        textView.setLineSpacing(0, 1.1f);
//        textView.setIncludeFontPadding(false);
//        snackbar.show();
    }

}//end of class