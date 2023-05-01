package com.example.demo.dto;

public class PlanillaDTO {
    private Long dia;
    private String horaDesde;
    private String horaHasta;

    public Long getDia() {
        return dia;
    }

    public void setDia(Long dia) {
        this.dia = dia;
    }

    public String getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(String horaDesde) {
        this.horaDesde = horaDesde;
    }

    public String getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(String horaHasta) {
        this.horaHasta = horaHasta;
    }
}
