package com.blink22.android.todoapp.ui.todolist;

import com.blink22.android.todoapp.data.DataManager;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class TodoListPresenter implements TodoListMvpPresenter<TodoListMvpView> {
    private final DataManager mDataManager;
    private final CompositeDisposable mCompositeDisposable;
    private TodoListMvpView mTodoListView;

    @Inject
    public TodoListPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        mDataManager = dataManager;
        mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(TodoListMvpView view) {
        mTodoListView = view;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
    }

    @Override
    public void onViewInitialized() {
        mCompositeDisposable.add(mDataManager.getAllTodos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(todos -> mTodoListView.updateTodoList(todos))
        );
    }
}
