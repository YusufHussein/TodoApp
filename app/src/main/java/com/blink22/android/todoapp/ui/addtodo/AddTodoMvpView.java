package com.blink22.android.todoapp.ui.addtodo;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Date;

public interface AddTodoMvpView {
    void setSubject(String subject);

    void setDescription(String description);

    void setDate(Date date);

    void goToTodoList();
}
