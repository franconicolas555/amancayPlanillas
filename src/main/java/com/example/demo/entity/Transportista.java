package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transportistas")
public class Transportista {

    @JsonProperty("idTransportista")
    @Id
    @Column(name = "id_transportista", unique = true, nullable = false)
    private Long idTransportista;
    @JsonProperty("nombre")
    @Column(name = "nombre")
    private String nombre;
    @JsonProperty("apellido")
    @Column(name = "apellido")
    private String apellido;
    @JsonProperty("cuit")
    @Column(name = "cuit")
    private String cuit;
    @JsonProperty("nroPrestador")
    @Column(name = "nro_prestador")
    private String nroPrestador;

    public Transportista(Long idTransportista) {
        this.idTransportista = idTransportista;
    }

    public Transportista() {

    }

    public Long getIdTransportista() {
        return idTransportista;
    }

    public void setIdTransportista(Long idTransportista) {
        this.idTransportista = idTransportista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getNroPrestador() {
        return nroPrestador;
    }

    public void setNroPrestador(String nroPrestador) {
        this.nroPrestador = nroPrestador;
    }
}
