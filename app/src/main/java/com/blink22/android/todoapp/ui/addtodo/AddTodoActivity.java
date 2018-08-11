package com.blink22.android.todoapp.ui.addtodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.blink22.android.todoapp.R;
import com.blink22.android.todoapp.data.firestore.model.Todo;
import com.blink22.android.todoapp.di.component.ActivityComponent;
import com.blink22.android.todoapp.ui.base.BaseActivity;
import com.blink22.android.todoapp.ui.todolist.TodoListMvpView;
import com.blink22.android.todoapp.utils.DrawerUtil;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddTodoActivity extends BaseActivity implements AddTodoMvpView {
    @Inject
    AddTodoMvpPresenter<AddTodoMvpView> mPresenter;
    @BindView(R.id.add_todo_toolbar)
    Toolbar mTodoToolbar;
    private ActivityComponent mActivityComponent;

    public static Intent newIntent(Activity activity) {
        return new Intent(activity, AddTodoActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_todo_activity);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        mPresenter.onAttach(this);
        setSupportActionBar(mTodoToolbar);
        DrawerUtil.setDrawer(this, mTodoToolbar);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void showDraftTodo(Todo todo) {

    }
}
