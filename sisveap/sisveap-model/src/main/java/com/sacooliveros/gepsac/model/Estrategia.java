/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.model;

import com.sacooliveros.gepsac.model.comun.Model;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class Estrategia extends Model {

    private String nombre;
    private String descripcion;

    private List<EstrategiaActividad> actividades;

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

    public List<EstrategiaActividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<EstrategiaActividad> actividades) {
        this.actividades = actividades;
    }

}
