/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.model;

import com.sacooliveros.gepsac.model.comun.Estado;
import java.util.Date;

/**
 *
 * @author Ricardo
 */
public class Persona {

    private String codigo;
    private String dni;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Date ultFecTrabajo;
    private Estado estado;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getUltFecTrabajo() {
        return ultFecTrabajo;
    }

    public void setUltFecTrabajo(Date ultFecTrabajo) {
        this.ultFecTrabajo = ultFecTrabajo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setEstado(String estado) {
        Estado est = new Estado();
        est.setCodigo(estado);
        this.estado = est;
    }

    @Override
    public String toString() {
        return "Persona{" + "codigo=" + codigo + ", dni=" + dni + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", ultFecTrabajo=" + ultFecTrabajo + ", estado=" + estado + '}';
    }

}
