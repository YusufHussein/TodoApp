package com.blink22.android.todoapp.ui.todolist;

import com.blink22.android.todoapp.data.firestore.model.Todo;

import java.util.List;

public interface TodoListMvpView {
    void updateTodoList(List<Todo> todos);
}
