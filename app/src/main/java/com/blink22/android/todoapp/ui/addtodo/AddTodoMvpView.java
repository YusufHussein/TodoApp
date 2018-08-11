package com.blink22.android.todoapp.ui.addtodo;

import com.blink22.android.todoapp.data.firestore.model.Todo;

import java.util.List;

public interface AddTodoMvpView {
    void showDraftTodo(Todo todo);
}
