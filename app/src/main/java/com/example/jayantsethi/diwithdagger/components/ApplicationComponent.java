package com.example.jayantsethi.diwithdagger.components;

import com.example.jayantsethi.diwithdagger.MainActivity;
import com.example.jayantsethi.diwithdagger.modules.ApplicationModule;
import com.example.jayantsethi.diwithdagger.services.NetworkStatusService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    NetworkStatusService networkStatusService();
}
