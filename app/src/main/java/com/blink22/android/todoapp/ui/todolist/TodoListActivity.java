package com.blink22.android.todoapp.ui.todolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.blink22.android.todoapp.R;
import com.blink22.android.todoapp.TodoApp;
import com.blink22.android.todoapp.data.firestore.model.Todo;
import com.blink22.android.todoapp.di.component.ActivityComponent;
import com.blink22.android.todoapp.di.component.DaggerActivityComponent;
import com.blink22.android.todoapp.di.modules.ActivityModule;
import com.blink22.android.todoapp.ui.base.BaseActivity;

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
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_list_activity);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        mPresenter.onAttach(this);
        setupRecyclerView();
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
