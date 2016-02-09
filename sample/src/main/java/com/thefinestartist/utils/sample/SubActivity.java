package com.thefinestartist.utils.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.thefinestartist.annotations.Extra;
import com.thefinestartist.utils.extras.ExtrasUtil;

import java.util.ArrayList;

/**
 * Created by TheFinestArtist on 2/7/16.
 */
public class SubActivity extends AppCompatActivity {

    public static final String TITLE = "TITLE";
    public static final String CONTENT = "CONTENT";
    public static final String ARRAY_LIST = "ARRAY_LIST";

    @Extra(TITLE) String title;
    @Extra(CONTENT) int content;
    @Extra int[] values;
    @Extra(ARRAY_LIST) ArrayList<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExtrasUtil.bind(this);
    }
}
