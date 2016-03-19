package com.thefinestartist.utils.sample.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.thefinestartist.annotations.Extra;
import com.thefinestartist.binders.ExtrasBinder;

import java.util.ArrayList;

/**
 * Created by TheFinestArtist on 2/7/16.
 */
public class SubActivity extends AppCompatActivity {

    public static final String TITLE = "TITLE";
    public static final String CONTENT = "CONTENT";
    public static final String ARRAY_LIST = "ARRAY_LIST";

    protected @Extra(TITLE) String title;
    static @Extra(CONTENT) int content;
    @Extra int[] values;
    @Extra(ARRAY_LIST) ArrayList<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExtrasBinder.bind(this);
        Log.e("SubActivity", "title: " + title);
        Log.e("SubActivity", "content: " + content);
        Log.e("SubActivity", "values: " + values);
        Log.e("SubActivity", "list: " + list);
    }
}
