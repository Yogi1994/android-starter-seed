package com.wicklers.androidstarterseed;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import dagger.android.AndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by yogi on 13/11/17.
 */

public class App extends Application implements HasActivityInjector {


    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {

        }
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return null;
    }
}
