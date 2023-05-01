package com.example.demo.dto;


public class AfiliadoDTO {
    private String nombre;
    private String apellido;
    private String horario;
    private String description;
    private String direccion_desde;
    private String direccion_hasta;
    private String obra_social;
    private String nro_documento;
    private String nro_afiliado;

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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDireccion_desde() {
        return direccion_desde;
    }

    public void setDireccion_desde(String direccion_desde) {
        this.direccion_desde = direccion_desde;
    }

    public String getDireccion_hasta() {
        return direccion_hasta;
    }

    public void setDireccion_hasta(String direccion_hasta) {
        this.direccion_hasta = direccion_hasta;
    }

    public String getObra_social() {
        return obra_social;
    }

    public void setObra_social(String obra_social) {
        this.obra_social = obra_social;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public String getNro_afiliado() {
        return nro_afiliado;
    }

    public void setNro_afiliado(String nro_afiliado) {
        this.nro_afiliado = nro_afiliado;
    }
}
