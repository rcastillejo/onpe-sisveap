/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.model;

import com.sacooliveros.gepsac.model.comun.Model;

/**
 *
 * @author Ricardo
 */
public class Actividad extends Model {

    private String nombre;
    private String descripcion;
    private int duracion;
    private String tipoFrecuencia;
    private int sesiones;
    private int frecuencia;

    public Actividad() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTipoFrecuencia() {
        return tipoFrecuencia;
    }

    public void setTipoFrecuencia(String tipoFrecuencia) {
        this.tipoFrecuencia = tipoFrecuencia;
    }

    public int getSesiones() {
        return sesiones;
    }

    public void setSesiones(int sesiones) {
        this.sesiones = sesiones;
    }

    public void calcularFrecuencia() {
        this.frecuencia = (int) Math.ceil(this.duracion / this.sesiones);
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    @Override
    public String toString() {
        return "Actividad{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", duracion=" + duracion + ", tipoFrecuencia=" + tipoFrecuencia + ", sesiones=" + sesiones + ", frecuencia=" + frecuencia + '}';
    }

}
