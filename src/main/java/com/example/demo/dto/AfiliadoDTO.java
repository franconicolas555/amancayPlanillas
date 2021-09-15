package com.example.demo.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class AfiliadoDTO {
    private String nombre;
    private String apellido;
    private String direccion;
    private Long estado;
    private String nroAfiliado;
    private String transportista;
    private String recorridos;
    private String direccionhasta;
    private String profesional;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getEstado() {
        return estado;
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

    public String getTransportista() {
        return transportista;
    }

    public void setTransportista(String transportista) {
        this.transportista = transportista;
    }

    public String getRecorridos() {
        return recorridos;
    }

    public void setRecorridos(String recorridos) {
        this.recorridos = recorridos;
    }

    public String getDireccionhasta() {
        return direccionhasta;
    }

    public void setDireccionhasta(String direccionhasta) {
        this.direccionhasta = direccionhasta;
    }

    public String getProfesional() {
        return profesional;
    }

    public void setProfesional(String profesional) {
        this.profesional = profesional;
    }

    public List<Long> getParseRecorridos(String recorridos) {
        String[] diasRecorridos = recorridos.split(",");
        return Arrays.stream(diasRecorridos).map(str -> Long.parseLong(str)).collect(Collectors.toList());
    }
}
