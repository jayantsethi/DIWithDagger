package com.example.jayantsethi.diwithdagger.components;

import com.example.jayantsethi.diwithdagger.MainActivity;
import com.example.jayantsethi.diwithdagger.modules.ActivityModule;
import com.example.jayantsethi.diwithdagger.scopes.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
    RequestFromActivityComponent requestFromActivityComponent();
}
