package com.thefinestartist.helpers;

import android.os.Bundle;

import java.io.Serializable;

/**
 * Created by TheFinestArtist on 2/7/16.
 */
public class BundleBuilder {

    final Bundle bundle = new Bundle();

    public <T extends Serializable> BundleBuilder set(String key, T value) {
        bundle.putSerializable(key, value);
        return this;
    }

    public <T> T get(String key) {
        return (T) bundle.getSerializable(key);
    }

    public Bundle build() {
        return bundle;
    }
}
