package com.blink22.android.todoapp.ui.todolist;

import com.blink22.android.todoapp.ui.base.MvpPresenter;

public interface TodoListMvpPresenter<V> extends MvpPresenter<V> {
    void onViewInitialized();
}
