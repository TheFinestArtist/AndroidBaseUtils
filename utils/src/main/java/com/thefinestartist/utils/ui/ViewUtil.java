package com.thefinestartist.utils.ui;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.view.View;

import com.thefinestartist.Base;

/**
 * Created by TheFinestArtist on 2/2/16.
 */
public class ViewUtil {

    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    public static void setBackground(View view, @DrawableRes int drawableRes) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackgroundDrawable(Base.getResources().getDrawable(drawableRes));
        } else {
            view.setBackground(Base.getResources().getDrawable(drawableRes));
        }
    }
}