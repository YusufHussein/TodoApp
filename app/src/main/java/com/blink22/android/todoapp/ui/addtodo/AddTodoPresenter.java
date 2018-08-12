package com.blink22.android.todoapp.ui.addtodo;

import android.content.Context;
import android.widget.Toast;

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
        mTodo = new Todo();
    }

    @Override
    public void onAttach(AddTodoMvpView view) {
        mAddTodoView = view;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
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
            Toast.makeText((Context) mAddTodoView, "You have to enter a subject", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mTodo.getDate() == null) {
            Toast.makeText((Context) mAddTodoView, "You have to enter a date", Toast.LENGTH_SHORT).show();
            return;
        }
        mDataManager.addTodoItem(mTodo);
        clearTodo();
        mAddTodoView.goToTodoList();
    }

    private void clearTodo() {
        mTodo = new Todo();
        setTodoSubject(mTodo.getSubject());
        setTodoDescription(mTodo.getDescription());
        setTodoDate(mTodo.getDate());
    }
}
