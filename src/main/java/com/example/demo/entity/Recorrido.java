package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

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
}
