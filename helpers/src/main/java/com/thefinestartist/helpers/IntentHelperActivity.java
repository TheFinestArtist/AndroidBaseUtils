package com.thefinestartist.helpers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by TheFinestArtist on 2/7/16.
 */
public class IntentHelperActivity extends AppCompatActivity {

    ActivityBuilder activityBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBuilder = new ActivityBuilder(getIntent());
    }

    public <T> T get(String key) {
        return activityBuilder.get(key);
    }
}