package com.blink22.android.todoapp.data;

import com.blink22.android.todoapp.data.firestore.FirestoreHelper;
import com.blink22.android.todoapp.data.firestore.model.Todo;
import com.blink22.android.todoapp.data.prefrences.PreferencesHelper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AppDataManager implements DataManager {
    private final FirestoreHelper mFirestoreHelper;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(FirestoreHelper firestoreHelper, PreferencesHelper preferencesHelper) {
        mFirestoreHelper = firestoreHelper;
        mPreferencesHelper = preferencesHelper;
    }

    @Override
    public Observable<List<Todo>> getAllTodos() {
        return mFirestoreHelper.getAllTodos();
    }

    @Override
    public void addTodoItem(Todo todo) {
        mFirestoreHelper.addTodoItem(todo);
    }

    @Override
    public Todo getTodoDraft() {
        return mPreferencesHelper.getTodoDraft();
    }

    @Override
    public void saveTodoDraft(Todo todo) {
        mPreferencesHelper.saveTodoDraft(todo);
    }
}
