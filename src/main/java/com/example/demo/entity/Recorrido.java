package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "recorridos")
public class Recorrido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recorrido")
    @JsonProperty("idRecorrido")
    private Long idRecorrido;
    @JsonProperty("diaRecorrido")
    @Column(name = "dia_recorrido")
    private Long diaRecorrido;
    @JsonProperty("horaHasta")
    @Column(name = "hora_hasta")
    private String horaHasta;
    @JsonProperty("horaDesde")
    @Column(name = "hora_desde")
    private String horaDesde;
    @JsonProperty("description")
    @Column(name = "description")
    private Timestamp description;
    @JsonProperty("afiliado")
    @ManyToOne
    @JoinColumn(name = "id_afiliado")
    private Afiliado afiliado;

    public Long getIdRecorrido() {
        return idRecorrido;
    }

    public void setIdRecorrido(Long idRecorrido) {
        this.idRecorrido = idRecorrido;
    }

    public Long getDiaRecorrido() {
        return diaRecorrido;
    }

    public void setDiaRecorrido(Long diaRecorrido) {
        this.diaRecorrido = diaRecorrido;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public String getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(String horaHasta) {
        this.horaHasta = horaHasta;
    }

    public String getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(String horaDesde) {
        this.horaDesde = horaDesde;
    }

    public Timestamp getDescription() {
        return description;
    }

    public void setDescription(Timestamp description) {
        this.description = description;
    }
}
