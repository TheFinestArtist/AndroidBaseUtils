package com.thefinestartist.utils.sample.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thefinestartist.annotations.Extra;
import com.thefinestartist.binders.ExtrasBinder;

import java.util.List;

/**
 * Created by TheFinestArtist on 2/15/16.
 */
public class Fragment3 extends Fragment {

    @Extra String[] titles;
    @Extra List<String> contents;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ExtrasBinder.bind(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
