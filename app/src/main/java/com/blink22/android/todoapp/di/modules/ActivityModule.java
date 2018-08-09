package com.blink22.android.todoapp.di.modules;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.blink22.android.todoapp.data.firestore.model.Todo;
import com.blink22.android.todoapp.di.PerActivity;
import com.blink22.android.todoapp.ui.todolist.TodoListAdapter;
import com.blink22.android.todoapp.ui.todolist.TodoListMvpPresenter;
import com.blink22.android.todoapp.ui.todolist.TodoListMvpView;
import com.blink22.android.todoapp.ui.todolist.TodoListPresenter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    TodoListMvpPresenter<TodoListMvpView> provideTodoMvpPresenter(
            TodoListPresenter presenter) {
        return presenter;
    }

    @Provides
    TodoListAdapter provideTodoListAdapter() {
        return new TodoListAdapter(new ArrayList<Todo>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
