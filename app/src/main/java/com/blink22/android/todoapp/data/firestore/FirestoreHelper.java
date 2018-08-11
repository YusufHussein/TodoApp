package com.blink22.android.todoapp.data.firestore;

import com.blink22.android.todoapp.data.firestore.model.Todo;

import java.util.List;

import io.reactivex.Observable;

public interface FirestoreHelper {
    Observable<List<Todo>> getAllTodos();
}
