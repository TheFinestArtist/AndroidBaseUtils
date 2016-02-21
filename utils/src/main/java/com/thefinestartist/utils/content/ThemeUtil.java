package com.thefinestartist.utils.content;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.AttrRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StyleRes;
import android.support.annotation.StyleableRes;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.thefinestartist.Base;

/**
 * ThemeUtil helps to use {@link Resources.Theme} conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class ThemeUtil {

    public void applyStyle(int resId, boolean force) {
        Base.getTheme().applyStyle(resId, force);
    }

    public void dump(int priority, String tag, String prefix) {
        Base.getTheme().dump(priority, tag, prefix);
    }

    @TargetApi(23)
    public int getChangingConfigurations() {
        return Base.getTheme().getChangingConfigurations();
    }

    public Drawable getDrawable(@DrawableRes int drawableRes) {
        return ResourcesUtil.getDrawable(drawableRes);
    }

    public Resources getResources() {
        return Base.getResources();
    }

    public TypedArray obtainStyledAttributes(@StyleableRes int[] attrs) {
        return Base.getTheme().obtainStyledAttributes(attrs);
    }

    public TypedArray obtainStyledAttributes(@StyleRes int resid, @StyleableRes int[] attrs) {
        return Base.getTheme().obtainStyledAttributes(resid, attrs);
    }

    public TypedArray obtainStyledAttributes(AttributeSet set, @StyleableRes int[] attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        return Base.getTheme().obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes);
    }

    public static boolean resolveAttribute(int resid, TypedValue outValue, boolean resolveRefs) {
        return Base.getTheme().resolveAttribute(resid, outValue, resolveRefs);
    }

    public void setTo(Resources.Theme other) {
        Base.getTheme().setTo(other);
    }
}