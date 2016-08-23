package com.example.jayantsethi.diwithdagger;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

import com.example.jayantsethi.diwithdagger.scopes.PerRequestFromActivity;
import com.example.jayantsethi.diwithdagger.services.NetworkStatusService;

import javax.inject.Inject;

@PerRequestFromActivity
public class NetworkStatusDialog extends AlertDialog{

    private static final String TAG = NetworkStatusDialog.class.getSimpleName();
    private MainActivity context;
    private NetworkStatusService networkStatusService;

    @Inject
    protected NetworkStatusDialog(MainActivity context, NetworkStatusService networkStatusService) {
        super(context);
        this.context = context;
        this.networkStatusService = networkStatusService;
    }

    public void show() {
        String networkStatusString = "Network" +
                (networkStatusService.isConnectedToInternet() ? "" : " not")
                + " connected";


        Log.i(TAG, NetworkStatusService.class.getSimpleName() + " instance hash code : " + networkStatusService.hashCode());
        Log.i(TAG, MainActivity.class.getSimpleName() + " instance hash code : " + context.hashCode());
        Log.i(TAG, NetworkStatusDialog.class.getSimpleName() + " instance hash code : " + this.hashCode());

        new AlertDialog.Builder(context)
                .setTitle("Info")
                .setMessage(networkStatusString)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}
