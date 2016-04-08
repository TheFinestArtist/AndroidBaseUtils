package com.thefinestartist.utils.etc;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.util.SimpleArrayMap;
import android.widget.TextView;

import com.thefinestartist.Base;

/**
 * TypefaceUtil helps to retrieve typeface from assets folder.
 *
 * @author Leonardo Taehwan Kim
 */
public class TypefaceUtil {

    private TypefaceUtil() {}

    private static final SimpleArrayMap<String, Typeface> cache = new SimpleArrayMap<>();

    public static Typeface get(@NonNull String path) {
        synchronized (cache) {
            if (cache.containsKey(path))
                return cache.get(path);

            try {
                Typeface typeface = Typeface.createFromAsset(Base.getContext().getAssets(), path);
                cache.put(path, typeface);
                return typeface;
            } catch (RuntimeException e) {
                return null;
            }
        }
    }

    public static void setTypeface(@NonNull String path, TextView... textViews) {
        if (textViews == null)
            return;

        for (TextView textView : textViews)
            if (textView != null)
                textView.setTypeface(get(path));
    }

    public static void setTypeface(@NonNull String path, boolean includeFontPadding, TextView... textViews) {
        if (textViews == null)
            return;

        for (TextView textView : textViews) {
            if (textView != null) {
                textView.setTypeface(get(path));
                textView.setIncludeFontPadding(includeFontPadding);
            }
        }
    }
}