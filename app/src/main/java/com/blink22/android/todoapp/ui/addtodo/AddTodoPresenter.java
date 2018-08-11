package com.blink22.android.todoapp.ui.addtodo;

import com.blink22.android.todoapp.data.DataManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class AddTodoPresenter implements AddTodoMvpPresenter<AddTodoMvpView> {
    private final DataManager mDataManager;
    private final CompositeDisposable mCompositeDisposable;
    private AddTodoMvpView mAddTodoView;

    @Inject
    public AddTodoPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        mDataManager = dataManager;
        mCompositeDisposable = compositeDisposable;
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
}
