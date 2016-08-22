package com.example.jayantsethi.diwithdagger.modules;

import com.example.jayantsethi.diwithdagger.MainActivity;
import com.example.jayantsethi.diwithdagger.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private MainActivity activity;

    public ActivityModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    MainActivity provideMainActivity() {
        return activity;
    }
}
