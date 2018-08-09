package com.blink22.android.todoapp.ui.todolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blink22.android.todoapp.R;
import com.blink22.android.todoapp.data.firestore.model.Todo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder> {
    private List<Todo> mTodos;

    public TodoListAdapter(ArrayList<Todo> todos) {
        mTodos = todos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo_view, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(mTodos.get(position));
    }

    @Override
    public int getItemCount() {
        return mTodos.size();
    }

    public void addItems(List<Todo> todos) {
        mTodos = todos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.todo_subject_text_view)
        TextView mSubjectTextView;
        @BindView(R.id.todo_description_text_view)
        TextView mDescriptionTextView;
        @BindView(R.id.todo_date_text_view)
        TextView mDateTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onBind(Todo todo) {
            mSubjectTextView.setText(todo.getSubject());
            mDescriptionTextView.setText(todo.getDescription());
            mDateTextView.setText(formatDate(todo.getDate()));
        }

        private String formatDate(Date date) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy hh:mm aaa");
            return simpleDateFormat.format(date);
        }
    }
}