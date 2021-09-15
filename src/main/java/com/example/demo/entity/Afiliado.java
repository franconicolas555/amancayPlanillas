package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "afiliados")
public class Afiliado {
    @JsonProperty("idAfiliado")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_afiliado")
    private Long idAfiliado;
    @JsonProperty("nombre")
    @Column(name = "nombre")
    private String nombre;
    @JsonProperty("apellido")
    @Column(name = "apellido")
    private String apellido;
    @JsonProperty("nroDocumento")
    @Column(name = "nro_documento")
    private String nroDocumento;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "direccion_hasta")
    private String direccionHasta;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "estado")
    private Long estado;
    @Column(name = "nro_afiliado")
    private String nroAfiliado;
    @Column(name = "profesional")
    private String profesional;
    @JsonProperty("transportista")
    @ManyToOne
    @JoinColumn(name = "id_transportista")
    private Transportista transportista;

    public Long getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(Long idAfiliado) {
        this.idAfiliado = idAfiliado;
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

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getEstado() {
        return estado;
    }

    public Transportista getTransportista() {
        return transportista;
    }

    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public String getNroAfiliado() {
        return nroAfiliado;
    }

    public void setNroAfiliado(String nroAfiliado) {
        this.nroAfiliado = nroAfiliado;
    }

    public String getDireccionHasta() {
        return direccionHasta;
    }

    public void setDireccionHasta(String direccionHasta) {
        this.direccionHasta = direccionHasta;
    }

    public String getProfesional() {
        return profesional;
    }

    public void setProfesional(String profesional) {
        this.profesional = profesional;
    }
}
