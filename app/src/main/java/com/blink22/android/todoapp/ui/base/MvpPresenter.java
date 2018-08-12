package com.blink22.android.todoapp.ui.base;

public interface MvpPresenter<V> {
    void onAttach(V view);
    void onDetach();
}
