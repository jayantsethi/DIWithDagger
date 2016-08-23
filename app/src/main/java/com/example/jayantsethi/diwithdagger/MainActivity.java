package com.example.jayantsethi.diwithdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.jayantsethi.diwithdagger.components.ActivityComponent;
import com.example.jayantsethi.diwithdagger.components.ApplicationComponent;
import com.example.jayantsethi.diwithdagger.components.DaggerActivityComponent;
import com.example.jayantsethi.diwithdagger.modules.ActivityModule;
import com.example.jayantsethi.diwithdagger.services.NetworkStatusService;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Inject NetworkStatusService networkStatusService;
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Main Activity created");

        //Inject dependencies
        ApplicationComponent applicationComponent = ((DaggerApplication) getApplication()).getApplicationComponent();

        activityComponent = DaggerActivityComponent.builder().
                applicationComponent(applicationComponent).
                activityModule(new ActivityModule(this)).
                build();

        activityComponent.inject(this);

        setContentView(R.layout.activity_main);
    }

    public void checkNetworkStatus(View view) {
        NetworkStatusDialog networkStatusDialog = activityComponent.requestFromActivityComponent().networkStatusDialog();
        networkStatusDialog.show();
    }
}
