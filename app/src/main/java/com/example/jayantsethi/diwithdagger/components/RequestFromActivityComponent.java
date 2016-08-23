package com.example.jayantsethi.diwithdagger.components;

import com.example.jayantsethi.diwithdagger.NetworkStatusDialog;
import com.example.jayantsethi.diwithdagger.scopes.PerRequestFromActivity;

import dagger.Subcomponent;

@PerRequestFromActivity
@Subcomponent
public interface RequestFromActivityComponent {
    NetworkStatusDialog networkStatusDialog();
}
