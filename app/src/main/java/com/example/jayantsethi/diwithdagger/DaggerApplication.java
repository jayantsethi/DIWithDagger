package com.example.jayantsethi.diwithdagger;

import android.app.Application;
import android.util.Log;

import com.example.jayantsethi.diwithdagger.components.ApplicationComponent;
import com.example.jayantsethi.diwithdagger.components.DaggerApplicationComponent;
import com.example.jayantsethi.diwithdagger.modules.ApplicationModule;

public class DaggerApplication extends Application{

    private static final String TAG = DaggerApplication.class.getSimpleName();
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Application Created");

        //Initialize the application component here
        applicationComponent = DaggerApplicationComponent.
                builder().
                applicationModule(new ApplicationModule(this)).
                build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
