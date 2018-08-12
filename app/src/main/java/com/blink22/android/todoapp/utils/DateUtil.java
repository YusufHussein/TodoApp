package com.blink22.android.todoapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    public static String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
        return simpleDateFormat.format(date);
    }

    public static Date getDate(int year, int monthOfYear, int dayOfMonth) {
        return new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();
    }
}
