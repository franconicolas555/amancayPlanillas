package com.example.demo.utils;

import com.example.demo.entity.Recorrido;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PayrollUtilsTest {

    private PayrollUtils payrollUtils;

    @Test
    public void getValidFields() {
        List<Recorrido> recorridoList = new ArrayList<>();
        Recorrido recorrido = new Recorrido();
        recorrido.setDiaRecorrido(1L);
        recorrido.setHoraDesde("15:15HS");
        recorrido.setHoraHasta("17:30HS");
        recorridoList.add(recorrido);
        PayrollUtils.getDatesValid(recorridoList, "MAYO", Arrays.asList("02/05/2022"));
    }
}
