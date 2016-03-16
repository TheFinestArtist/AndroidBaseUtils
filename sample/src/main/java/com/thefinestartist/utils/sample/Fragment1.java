package com.thefinestartist.utils.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thefinestartist.annotations.Extra;
import com.thefinestartist.binders.ExtrasBinder;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by TheFinestArtist on 2/8/16.
 */
public class Fragment1 extends Fragment {

    public static final String NAME = "NAME";

    @Extra(NAME) String name;
    @Bind(R.id.view) View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1_layout, container, false);
        ButterKnife.bind(this, rootView);
        ExtrasBinder.bind(this);
        Log.e("Fragment1", "Name: " + name);
        return rootView;
    }

}
