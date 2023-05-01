package com.example.demo.dto;

public class RowDTO {
    private String fecha;
    private String ingreso;
    private String egreso;
    private Long day;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getEgreso() {
        return egreso;
    }

    public void setEgreso(String egreso) {
        this.egreso = egreso;
    }

    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
        this.day = day;
    }
}
