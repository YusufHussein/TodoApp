package com.blink22.android.todoapp.ui.addtodo;

import com.blink22.android.todoapp.ui.base.MvpPresenter;

import java.util.Date;

public interface AddTodoMvpPresenter<V> extends MvpPresenter<V> {
    void onViewInitialized();

    void setTodoSubject(String subject);

    void setTodoDescription(String description);

    void setTodoDate(Date date);

    void addTodoItem();
}
