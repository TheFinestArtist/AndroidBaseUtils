package com.thefinestartist.builders;

import android.os.Bundle;

import java.io.Serializable;

/**
 * BundleBuilder helps to build {@link Bundle} conveniently.
 *
 * @author Leonardo Taehwan Kim
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