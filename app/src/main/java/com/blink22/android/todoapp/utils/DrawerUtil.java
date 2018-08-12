package com.blink22.android.todoapp.utils;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.blink22.android.todoapp.R;
import com.blink22.android.todoapp.ui.addtodo.AddTodoActivity;
import com.blink22.android.todoapp.ui.todolist.TodoListActivity;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;


public class DrawerUtil {
    public static void setDrawer(final Activity activity, Toolbar toolbar) {
        PrimaryDrawerItem drawerItemTodoList = new PrimaryDrawerItem()
                .withIdentifier(NavigationItemEnum.TODO_LIST.getId())
                .withSelectable(false)
                .withName(NavigationItemEnum.TODO_LIST.getLabelResourceId());
        PrimaryDrawerItem drawerItemAddTodo = new PrimaryDrawerItem()
                .withIdentifier(NavigationItemEnum.ADD_TODO.getId())
                .withSelectable(false)
                .withName(NavigationItemEnum.ADD_TODO.getLabelResourceId());
        new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withCloseOnClick(true)
                .withSelectedItem(-1)
                .addDrawerItems(drawerItemTodoList, drawerItemAddTodo)
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    if (drawerItem.getIdentifier() == NavigationItemEnum.TODO_LIST.getId() && !(activity instanceof TodoListActivity)) {
                        Intent intent = TodoListActivity.newIntent(activity);
                        Log.e("TODO LIST", "Todo List pressed");
                        activity.startActivity(intent);
                    }
                    if (drawerItem.getIdentifier() == NavigationItemEnum.ADD_TODO.getId() && !(activity instanceof AddTodoActivity)) {
                        Intent intent = AddTodoActivity.newIntent(activity);
                        Log.e("ADD TODO", "Add todo pressed");
                        activity.startActivity(intent);
                    }
                    return false;
                }).build();

    }

    /**
     * Credit to AFGhazy
     */
    private enum NavigationItemEnum {
        TODO_LIST(R.string.item_title_todo_list, 0), ADD_TODO(R.string.item_title_add_todo, 1);
        private int mLabelResourceId;
        private int mId;

        NavigationItemEnum(int labelResourceId, int id) {
            mLabelResourceId = labelResourceId;
            mId = id;
        }

        public int getLabelResourceId() {
            return mLabelResourceId;
        }

        public int getId() {
            return mId;
        }
    }
}