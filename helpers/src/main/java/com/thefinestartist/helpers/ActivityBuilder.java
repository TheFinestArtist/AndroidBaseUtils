package com.thefinestartist.helpers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.thefinestartist.Base;

import java.io.Serializable;

/**
 * Created by TheFinestArtist on 2/7/16.
 */
public class ActivityBuilder {

    final Intent intent;

    public <C extends Activity> ActivityBuilder(Class<C> clazz) {
        intent = new Intent(Base.getContext(), clazz);
    }

    public ActivityBuilder(@NonNull Intent intent) {
        this.intent = intent;
    }

    public <T extends Serializable> ActivityBuilder set(String key, T value) {
        intent.putExtra(key, value);
        return this;
    }

    public <T> T get(String key) {
        return (T) intent.getSerializableExtra(key);
    }

    public Intent build() {
        return intent;
    }

    public void start() {
        ContextHelper.startActivity(intent);
    }

    public void startActivityForResult(@NonNull Activity activity, int requestCode) {
        activity.startActivityForResult(intent, requestCode);
    }

    @TargetApi(16)
    public void startActivityForResult(@NonNull Activity activity, int requestCode, @Nullable Bundle options) {
        activity.startActivityForResult(intent, requestCode, options);
    }
}
