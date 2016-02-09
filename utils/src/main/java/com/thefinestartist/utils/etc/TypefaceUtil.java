package com.thefinestartist.utils.etc;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.util.SimpleArrayMap;

import com.thefinestartist.Base;

/**
 * Created by TheFinestArtist on 2/2/16.
 */
public class TypefaceUtil {

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
}
