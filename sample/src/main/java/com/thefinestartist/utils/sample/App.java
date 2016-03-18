package com.thefinestartist.utils.sample;

import android.app.Application;
import android.util.Log;

import com.thefinestartist.Base;

/**
 * Created by TheFinestArtist on 2/10/16.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Base.initialize(this);

        Log.v("App", "App v");
        Log.d("App", "App d");
        Log.i("App", "App i");
        Log.w("App", "App w");
        Log.e("App", "App e");
        Log.e("App", "Caller: " + Fragment1.getCallerClassName());

        char c = 'a';
        log(c);
    }

    public void log(Object message) {
        Log.e("App", "Log: " + message);
        Log.e("App", "Log: " + message.getClass().getCanonicalName());
    }
}
