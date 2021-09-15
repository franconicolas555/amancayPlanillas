package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feriados")
public class Feriado {
    @Id
    @SequenceGenerator(name = "feriado_sequence", sequenceName = "feriado_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feriado_sequence")
    @Column(name = "id_feriado", unique = true, nullable = false)
    private Long idFeriado;
    @JsonProperty("fechaFeriado")
    @Column(name = "fecha_feriado")
    private Date fechaFeriado;
    @JsonProperty("description")
    @Column(name = "description")
    private String description;


    public Long getIdFeriado() {
        return idFeriado;
    }

    public void setIdFeriado(Long idFeriado) {
        this.idFeriado = idFeriado;
    }

    public Date getFechaFeriado() {
        return fechaFeriado;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFechaFeriado(Date fechaFeriado) {
        this.fechaFeriado = fechaFeriado;
    }


}

