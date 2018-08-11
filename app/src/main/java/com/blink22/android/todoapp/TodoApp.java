package com.blink22.android.todoapp;

import android.app.Application;

import com.blink22.android.todoapp.data.DataManager;
import com.blink22.android.todoapp.di.component.AppComponent;
import com.blink22.android.todoapp.di.component.DaggerAppComponent;
import com.blink22.android.todoapp.di.modules.AppModule;

import javax.inject.Inject;

public class TodoApp extends Application {
    @Inject
    DataManager mDataManager;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeAppComponent();
    }

    private void initializeAppComponent() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        mAppComponent.inject(this);
    }

    public AppComponent getComponent() {
        return mAppComponent;
    }
}