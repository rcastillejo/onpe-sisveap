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
public class RestriccionFecha {

    private Date fecha;
    private String descripcion;

    public RestriccionFecha(Date fecha) {
        this.fecha = fecha;
    }

    public RestriccionFecha() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
