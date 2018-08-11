package com.blink22.android.todoapp.ui.addtodo;

import com.blink22.android.todoapp.ui.base.MvpPresenter;

public interface AddTodoMvpPresenter<V> extends MvpPresenter<V> {
    void onViewInitialized();
}
