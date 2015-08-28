/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.model;

import java.util.Date;

/**
 *
 * @author Ricardo
 */
public class Persona {

    private String dni;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Date ultFecTrabajo;

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

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", ultFecTrabajo=" + ultFecTrabajo + '}';
    }

}
