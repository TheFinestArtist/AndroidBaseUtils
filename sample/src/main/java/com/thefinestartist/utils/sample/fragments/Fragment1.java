package com.thefinestartist.utils.sample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thefinestartist.annotations.Extra;
import com.thefinestartist.binders.ExtrasBinder;
import com.thefinestartist.utils.sample.R;

/**
 * Created by TheFinestArtist on 2/8/16.
 */
public class Fragment1 extends Fragment {

    public static final String NAME = "NAME";

    @Extra(NAME) String name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ExtrasBinder.bind(this);
        return inflater.inflate(R.layout.fragment1_layout, container, false);
    }

}
