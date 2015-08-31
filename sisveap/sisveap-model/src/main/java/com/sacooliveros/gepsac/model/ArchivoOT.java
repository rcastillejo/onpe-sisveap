/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.model;

import com.sacooliveros.gepsac.model.comun.Model;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class ArchivoOT extends Model {

    private Date fecRegistro;
    private Date fecAsignacion;
    private String nombre;
    private String ruta;
    private int cantRegistro;
    private List<OrdenTrabajo> ordenes;

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public Date getFecAsignacion() {
        return fecAsignacion;
    }

    public void setFecAsignacion(Date fecAsignacion) {
        this.fecAsignacion = fecAsignacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getCantRegistro() {
        return cantRegistro;
    }

    public void setCantRegistro(int cantRegistro) {
        this.cantRegistro = cantRegistro;
    }

    public List<OrdenTrabajo> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<OrdenTrabajo> ordenes) {
        this.ordenes = ordenes;
    }

    @Override
    public String toString() {
        return "ArchivoOT{" + "fecRegistro=" + fecRegistro + ", fecAsignacion=" + fecAsignacion + ", nombre=" + nombre + ", ruta=" + ruta + ", cantRegistro=" + cantRegistro + ", ordenes=" + ordenes + ", " + super.toString() + '}';
    }

}
