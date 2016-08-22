package com.example.jayantsethi.diwithdagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.jayantsethi.diwithdagger.components.ActivityComponent;
import com.example.jayantsethi.diwithdagger.components.ApplicationComponent;
import com.example.jayantsethi.diwithdagger.components.DaggerActivityComponent;
import com.example.jayantsethi.diwithdagger.modules.ActivityModule;
import com.example.jayantsethi.diwithdagger.services.NetworkStatusService;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = DaggerApplication.class.getSimpleName();
    @Inject NetworkStatusService networkStatusService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Main Activity created");

        //Inject dependencies
        ApplicationComponent applicationComponent = ((DaggerApplication) getApplication()).getApplicationComponent();

        ActivityComponent activityComponent = DaggerActivityComponent.builder().
                applicationComponent(applicationComponent).
                activityModule(new ActivityModule(this)).
                build();

        activityComponent.inject(this);

        setContentView(R.layout.activity_main);
    }

    public void checkNetworkStatus(View view) {
        String networkStatusString = "Network" +
                (networkStatusService.isConnectedToInternet() ? "" : " not")
                + " connected";

        Toast.makeText(this, networkStatusString, Toast.LENGTH_SHORT).show();
    }
}
