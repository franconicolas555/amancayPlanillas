package com.example.demo.utils;

import com.example.demo.entity.Recorrido;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class PayrollUtils {

    public static List<Integer> getFieldsValidsPayroll(List<Recorrido> recorridos, String month, Integer holiday){
        List<Integer> diasDisponibles = new ArrayList<>();
        Calendar caldd = DateUtils.getFirstDayMonth(DateUtils.getMonth(month));
        Calendar calhh = DateUtils.getLastDayMonth(DateUtils.getMonth(month));
        calhh.add(Calendar.DAY_OF_MONTH, 1);
        while (calhh.after(caldd)) {
            Timestamp fecr = new Timestamp(caldd.getTimeInMillis());
            recorridos.forEach(recorrido -> {
                if ((recorrido.getDiaRecorrido().equals(DateUtils.VAL_LUN)
                        && (caldd.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY))) {
                    diasDisponibles.add(caldd.get(Calendar.DAY_OF_MONTH));
                }
                if ((recorrido.getDiaRecorrido().equals(DateUtils.VAL_MAR)
                        && (caldd.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY))) {
                    diasDisponibles.add(caldd.get(Calendar.DAY_OF_MONTH));
                }
                if ((recorrido.getDiaRecorrido().equals(DateUtils.VAL_MIE)
                        && (caldd.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY))) {
                    diasDisponibles.add(caldd.get(Calendar.DAY_OF_MONTH));
                }
                if ((recorrido.getDiaRecorrido().equals(DateUtils.VAL_JUE)
                        && (caldd.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY))) {
                    diasDisponibles.add(caldd.get(Calendar.DAY_OF_MONTH));
                }
                if ((recorrido.getDiaRecorrido().equals(DateUtils.VAL_VIE)
                        && (caldd.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY))) {
                    diasDisponibles.add(caldd.get(Calendar.DAY_OF_MONTH));
                }
            });
            caldd.add(Calendar.DAY_OF_MONTH, 1);
        }
        return diasDisponibles.stream().filter(day->!day.equals(holiday)).collect(Collectors.toList());
    }
}
