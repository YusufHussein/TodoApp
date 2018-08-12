package com.blink22.android.todoapp.ui.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.blink22.android.todoapp.R;
import com.blink22.android.todoapp.data.firestore.model.Todo;
import com.blink22.android.todoapp.di.component.ActivityComponent;
import com.blink22.android.todoapp.ui.base.BaseActivity;
import com.blink22.android.todoapp.utils.DrawerUtil;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TodoListActivity extends BaseActivity implements TodoListMvpView {
    @Inject
    TodoListMvpPresenter<TodoListMvpView> mPresenter;
    @Inject
    TodoListAdapter mTodoListAdapter;
    @Inject
    LinearLayoutManager mLayoutManager;
    @BindView(R.id.todo_list_recycler_view)
    RecyclerView mTodoRecyclerView;
    @BindView(R.id.todo_list_toolbar)
    Toolbar mTodoToolbar;
    private ActivityComponent mActivityComponent;

    public static Intent newIntent(Activity activity) {
        return new Intent(activity, TodoListActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_list_activity);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        mPresenter.onAttach(this);
        setupRecyclerView();
        setSupportActionBar(mTodoToolbar);
        DrawerUtil.setDrawer(this, mTodoToolbar);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    private void setupRecyclerView() {
        mTodoRecyclerView.setLayoutManager(mLayoutManager);
        mTodoRecyclerView.setAdapter(mTodoListAdapter);
        mPresenter.onViewInitialized();
    }

    @Override
    public void updateTodoList(List<Todo> todos) {
        mTodoListAdapter.addItems(todos);
    }
}
