package com.blink22.android.todoapp.di.component;

import android.app.Application;

import com.blink22.android.todoapp.TodoApp;
import com.blink22.android.todoapp.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(TodoApp app);

    Application application();
}