package com.blink22.android.todoapp.ui.addtodo;

import android.content.Context;
import android.widget.Toast;

import com.blink22.android.todoapp.R;
import com.blink22.android.todoapp.data.DataManager;
import com.blink22.android.todoapp.data.firestore.model.Todo;

import java.util.Date;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class AddTodoPresenter implements AddTodoMvpPresenter<AddTodoMvpView> {
    private final DataManager mDataManager;
    private final CompositeDisposable mCompositeDisposable;
    private AddTodoMvpView mAddTodoView;
    private Todo mTodo;

    @Inject
    public AddTodoPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        mDataManager = dataManager;
        mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(AddTodoMvpView view) {
        mAddTodoView = view;
        mTodo = mDataManager.getTodoDraft();
        refreshTodo();
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mDataManager.saveTodoDraft(mTodo);
    }

    @Override
    public void onViewInitialized() {
    }

    @Override
    public void setTodoSubject(String subject) {
        mTodo.setSubject(subject);
        mAddTodoView.setSubject(subject);
    }

    @Override
    public void setTodoDescription(String description) {
        mTodo.setDescription(description);
        mAddTodoView.setDescription(description);
    }

    @Override
    public void setTodoDate(Date date) {
        mTodo.setDate(date);
        mAddTodoView.setDate(date);
    }

    @Override
    public void addTodoItem() {
        if (mTodo.getSubject() == null || mTodo.getSubject().length() == 0) {
            Toast.makeText((Context) mAddTodoView, R.string.error_message_todo_subject, Toast.LENGTH_SHORT).show();
            return;
        }
        if (mTodo.getDate() == null) {
            Toast.makeText((Context) mAddTodoView, R.string.error_message_todo_date, Toast.LENGTH_SHORT).show();
            return;
        }
        mDataManager.addTodoItem(mTodo);
        mTodo = new Todo();
        refreshTodo();
        mAddTodoView.goToTodoList();
    }

    private void refreshTodo() {
        setTodoSubject(mTodo.getSubject());
        setTodoDescription(mTodo.getDescription());
        setTodoDate(mTodo.getDate());
    }
}
