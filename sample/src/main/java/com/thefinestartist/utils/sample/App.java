package com.thefinestartist.utils.sample;

import android.app.Application;

import com.thefinestartist.Base;

/**
 * Created by TheFinestArtist on 2/10/16.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Base.initialize(this);
    }
}
