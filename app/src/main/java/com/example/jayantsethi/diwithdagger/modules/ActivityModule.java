package com.example.jayantsethi.diwithdagger.modules;

import android.util.Log;

import com.example.jayantsethi.diwithdagger.MainActivity;
import com.example.jayantsethi.diwithdagger.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private static final String TAG = ActivityModule.class.getSimpleName();
    private MainActivity activity;

    public ActivityModule(MainActivity activity) {
        this.activity = activity;
        Log.i(TAG, MainActivity.class.getSimpleName() + " instance hash code : " + activity.hashCode());
    }

    @Provides
    @PerActivity
    MainActivity provideMainActivity() {
        return activity;
    }
}
