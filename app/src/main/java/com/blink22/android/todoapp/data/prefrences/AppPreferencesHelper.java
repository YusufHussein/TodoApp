package com.blink22.android.todoapp.data.prefrences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.blink22.android.todoapp.data.firestore.model.Todo;

import java.util.Date;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {
    private static final String PREF_KEY_TODO_SUBJECT = "PREF_KEY_TODO_SUBJECT";
    private static final String PREF_KEY_TODO_DESCRIPTION = "PREF_KEY_TODO_DESCRIPTION";
    private static final String PREF_KEY_TODO_DATE = "PREF_KEY_TODO_DATE";
    private static final String PREFERENCE_FILE_NAME = "todo_app_pref";
    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(Context context) {
        mPrefs = context.getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public Todo getTodoDraft() {
        Todo todo = new Todo();
        todo.setSubject(mPrefs.getString(PREF_KEY_TODO_SUBJECT, ""));
        todo.setDescription(mPrefs.getString(PREF_KEY_TODO_DESCRIPTION, ""));
        todo.setDate(new Date(mPrefs.getLong(PREF_KEY_TODO_DATE, new Date().getTime())));
        return todo;
    }

    @Override
    public void saveTodoDraft(Todo todo) {
        mPrefs.edit().putString(PREF_KEY_TODO_SUBJECT, todo.getSubject()).apply();
        mPrefs.edit().putString(PREF_KEY_TODO_DESCRIPTION, todo.getDescription()).apply();
        mPrefs.edit().putLong(PREF_KEY_TODO_DATE, todo.getDate().getTime()).apply();

    }
}
