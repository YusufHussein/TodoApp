package com.blink22.android.todoapp.ui.addtodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.blink22.android.todoapp.R;
import com.blink22.android.todoapp.di.component.ActivityComponent;
import com.blink22.android.todoapp.ui.base.BaseActivity;
import com.blink22.android.todoapp.ui.todolist.TodoListActivity;
import com.blink22.android.todoapp.utils.DateUtil;
import com.blink22.android.todoapp.utils.DrawerUtil;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddTodoActivity extends BaseActivity implements AddTodoMvpView, DatePickerDialog.OnDateSetListener {
    @Inject
    AddTodoMvpPresenter<AddTodoMvpView> mPresenter;
    @BindView(R.id.todo_subject_edit_text)
    EditText mSubjectEditText;
    @BindView(R.id.todo_description_edit_text)
    EditText mDescriptionEditText;
    @BindView(R.id.todo_date_button)
    Button mDateButton;
    @BindView(R.id.add_todo_button)
    Button mAddButton;
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
        mPresenter.setTodoSubject(mSubjectEditText.getText().toString());
        mPresenter.setTodoDescription(mDescriptionEditText.getText().toString());
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        mPresenter.setTodoDate(DateUtil.getDate(year, monthOfYear, dayOfMonth));
    }

    @Override
    public void setSubject(String subject) {
        mSubjectEditText.setText(subject);
    }

    @Override
    public void setDescription(String description) {
        mDescriptionEditText.setText(description);
    }

    @Override
    public void setDate(Date date) {
        if(date != null) {
            mDateButton.setText(DateUtil.formatDate(date));
        } else {
            mDateButton.setText(R.string.button_label_todo_date);
        }
    }

    @OnClick(R.id.todo_date_button)
    public void onDateButtonClick() {
        Calendar now = Calendar.getInstance();
        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
                AddTodoActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show(getFragmentManager(), "DatePickerDialog");
    }

    public void goToTodoList() {
        Intent intent = TodoListActivity.newIntent(this);
        startActivity(intent);
    }

    @OnClick(R.id.add_todo_button)
    public void addTodo() {
        mPresenter.setTodoSubject(mSubjectEditText.getText().toString());
        mPresenter.setTodoDescription(mDescriptionEditText.getText().toString());
        mPresenter.addTodoItem();
    }
}
