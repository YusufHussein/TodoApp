package com.blink22.android.todoapp.di.component;

import com.blink22.android.todoapp.di.PerActivity;
import com.blink22.android.todoapp.di.modules.ActivityModule;
import com.blink22.android.todoapp.ui.todolist.TodoListActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(TodoListActivity activity);
}
