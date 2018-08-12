package com.blink22.android.todoapp.data;

import com.blink22.android.todoapp.data.firestore.FirestoreHelper;
import com.blink22.android.todoapp.data.firestore.model.Todo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AppDataManager implements DataManager {
    private final FirestoreHelper mFirestoreHelper;

    @Inject
    public AppDataManager(FirestoreHelper firestoreHelper) {
        mFirestoreHelper = firestoreHelper;
    }

    @Override
    public Observable<List<Todo>> getAllTodos() {
        return mFirestoreHelper.getAllTodos();
    }

    @Override
    public void addTodoItem(Todo todo) {
        mFirestoreHelper.addTodoItem(todo);
    }
}
