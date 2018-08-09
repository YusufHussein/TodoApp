package com.blink22.android.todoapp.ui.todolist;

import javax.inject.Inject;

public class TodoListPresenter implements TodoListMvpPresenter<TodoListMvpView> {
    private TodoListMvpView mTodoListView;

    @Inject
    public TodoListPresenter() {
    }

    @Override
    public void onAttach(TodoListMvpView view) {
        mTodoListView = view;
    }

    @Override
    public void onDetach() {
    }
}
