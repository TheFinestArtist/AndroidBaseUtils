package com.thefinestartist.helpers.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.thefinestartist.annotations.Extra;
import com.thefinestartist.helpers.ExtrasHelper;

/**
 * Created by TheFinestArtist on 2/7/16.
 */
public class SubActivity extends AppCompatActivity {

    public static final String TITLE = "TITLE";
    public static final String CONTENT = "CONTENT";

    @Extra(TITLE) String title;
    @Extra(CONTENT) int content;
    @Extra int[] values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExtrasHelper.bind(this);
    }
}
