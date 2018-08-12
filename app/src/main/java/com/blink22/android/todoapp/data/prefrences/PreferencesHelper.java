package com.blink22.android.todoapp.data.prefrences;

import com.blink22.android.todoapp.data.firestore.model.Todo;

public interface PreferencesHelper {
    Todo getTodoDraft();

    void saveTodoDraft(Todo todo);
}
