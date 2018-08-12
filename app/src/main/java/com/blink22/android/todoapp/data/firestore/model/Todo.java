package com.blink22.android.todoapp.data.firestore.model;

import java.util.Date;
import java.util.UUID;

public class Todo {
    private UUID mId;
    private String mSubject;
    private String mDescription;
    private Date mDate;

    public Todo() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getSubject() {
        return mSubject;
    }

    public void setSubject(String subject) {
        mSubject = subject;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
