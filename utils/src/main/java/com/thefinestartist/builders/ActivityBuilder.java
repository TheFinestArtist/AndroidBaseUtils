package com.thefinestartist.builders;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.thefinestartist.Base;
import com.thefinestartist.utils.content.ContextUtil;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by TheFinestArtist on 2/7/16.
 */
public class ActivityBuilder {

    final Intent intent;

    public <C extends Activity> ActivityBuilder(@NonNull Class<C> clazz) {
        intent = new Intent(Base.getContext(), clazz);
    }

    public <T extends Serializable> ActivityBuilder set(@NonNull String key, T value) {
        intent.putExtra(key, value);
        return this;
    }

    public ActivityBuilder set(@NonNull String key, Parcelable value) {
        intent.putExtra(key, value);
        return this;
    }

    public ActivityBuilder set(@NonNull String key, Parcelable[] value) {
        intent.putExtra(key, value);
        return this;
    }

    public <T extends Parcelable> ActivityBuilder set(@NonNull String key, ArrayList<T> value) {
        intent.putExtra(key, value);
        return this;
    }

    public ActivityBuilder remove(@NonNull String key) {
        intent.removeExtra(key);
        return this;
    }

    public ActivityBuilder setFlags(int flags) {
        intent.setFlags(flags);
        return this;
    }

    public ActivityBuilder addFlags(int flags) {
        intent.addFlags(flags);
        return this;
    }

    public Intent buildIntent() {
        return intent;
    }

    public void start() {
        ContextUtil.startActivity(intent);
    }

    public void startActivityForResult(@NonNull Activity activity, int requestCode) {
        activity.startActivityForResult(intent, requestCode);
    }

    @TargetApi(16)
    public void startActivityForResult(@NonNull Activity activity, int requestCode, @Nullable Bundle options) {
        activity.startActivityForResult(intent, requestCode, options);
    }
}
