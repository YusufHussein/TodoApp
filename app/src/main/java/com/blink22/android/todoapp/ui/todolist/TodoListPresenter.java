package com.blink22.android.todoapp.ui.todolist;

import com.blink22.android.todoapp.data.firestore.model.Todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public void onViewInitialized() {
    }
}
