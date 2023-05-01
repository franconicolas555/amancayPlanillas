package com.example.demo.utils;

import com.example.demo.dto.RowDTO;
import com.example.demo.entity.Recorrido;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PayrollUtils {

    public static List<Integer> getFieldsValidsPayroll(List<Recorrido> recorridos, String month, List<Integer> holidays) {
        ArrayList<Integer> diasDisponibles = new ArrayList<>();
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
        diasDisponibles.removeIf(day -> holidays.contains(day));
        return diasDisponibles;
    }

    public static List<RowDTO> getDatesValid(List<Recorrido> recorridos, String month, List<String> holidays) {
        ArrayList<RowDTO> diasDisponibles = new ArrayList<>();
        Calendar caldd = DateUtils.getFirstDayMonth(DateUtils.getMonth(month));
        Calendar calhh = DateUtils.getLastDayMonth(DateUtils.getMonth(month));
        calhh.add(Calendar.DAY_OF_MONTH, 1);
        while (calhh.after(caldd)) {
            Timestamp fecr = new Timestamp(caldd.getTimeInMillis());
            Date date = new Date();
            date.setTime(fecr.getTime());
            String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
            recorridos.forEach(recorrido -> {

                if ((recorrido.getDiaRecorrido().equals(DateUtils.VAL_LUN)
                        && (caldd.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY))) {
                    addRow(diasDisponibles, recorrido, formattedDate);
                }
                if ((recorrido.getDiaRecorrido().equals(DateUtils.VAL_MAR)
                        && (caldd.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY))) {
                    addRow(diasDisponibles, recorrido, formattedDate);
                }
                if ((recorrido.getDiaRecorrido().equals(DateUtils.VAL_MIE)
                        && (caldd.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY))) {
                    addRow(diasDisponibles, recorrido, formattedDate);
                }
                if ((recorrido.getDiaRecorrido().equals(DateUtils.VAL_JUE)
                        && (caldd.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY))) {
                    addRow(diasDisponibles, recorrido, formattedDate);
                }
                if ((recorrido.getDiaRecorrido().equals(DateUtils.VAL_VIE)
                        && (caldd.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY))) {
                    addRow(diasDisponibles, recorrido, formattedDate);
                }
            });
            caldd.add(Calendar.DAY_OF_MONTH, 1);
        }
        diasDisponibles.removeIf(day -> holidays.contains(day.getFecha()));
        return diasDisponibles;
    }


    private static void addRow(List<RowDTO> rows, Recorrido recorrido, String formattedDate) {
        RowDTO row = new RowDTO();
        row.setFecha(formattedDate);
        row.setIngreso(recorrido.getHoraDesde());
        row.setEgreso(recorrido.getHoraHasta());
        row.setDay(recorrido.getDiaRecorrido());
        rows.add(row);
    }
}
