package com.example.demo.utils;

import java.util.Calendar;

public class DateUtils {

    public static final Long VAL_LUN = new Long(1);
    public static final Long VAL_MAR = new Long(2);
    public static final Long VAL_MIE = new Long(3);
    public static final Long VAL_JUE = new Long(4);
    public static final Long VAL_VIE = new Long(5);


    public static Calendar getFirstDayMonth(Integer month) {
        Calendar caldd = Calendar.getInstance();
        caldd.set(Calendar.MONTH, month);
        caldd.set(Calendar.DAY_OF_MONTH, 1);
        caldd.set(Calendar.HOUR_OF_DAY, 0);
        caldd.clear(Calendar.MINUTE);
        caldd.clear(Calendar.SECOND);
        caldd.clear(Calendar.MILLISECOND);
        return caldd;
    }

    public static Calendar getLastDayMonth(Integer month) {
        Calendar calhh = Calendar.getInstance();
        calhh.set(Calendar.MONTH, month);
        calhh.set(Calendar.DAY_OF_MONTH, calhh.getActualMaximum(Calendar.DAY_OF_MONTH));
        calhh.set(Calendar.HOUR_OF_DAY, 0);
        calhh.clear(Calendar.MINUTE);
        calhh.clear(Calendar.SECOND);
        calhh.clear(Calendar.MILLISECOND);
        return calhh;
    }


    public static Integer getMonth(String monthString) {
        Integer month = 0;
        switch (monthString.toUpperCase()) {
            case "ENERO":
                month = 0;
                break;
            case "FEBRERO":
                month = 1;
                break;
            case "MARZO":
                month = 2;
                break;
            case "ABRIL":
                month = 3;
                break;
            case "MAYO":
                month = 4;
                break;
            case "JUNIO":
                month = 5;
                break;
            case "JULIO":
                month = 6;
                break;
            case "AGOSTO":
                month = 7;
                break;
            case "SEPTIEMBRE":
                month = 8;
                break;
            case "OCTUBRE":
                month = 9;
                break;
            case "NOVIEMBRE":
                month = 10;
                break;
            case "DICIEMBRE":
                month = 11;
                break;
        }
        return month;
    }

}
