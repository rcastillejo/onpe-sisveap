/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.model;

import com.sacooliveros.gepsac.model.comun.Estado;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class PlanActividad extends EstrategiaActividad {

    private String codigoPlan;
    private Date fechaProgramada;
    private Date fechaEjecutada;
    private int meta;
    private boolean programado;
    private Estado estado;
    private List<PlanIndicador> indicadoresSeleccionados;

    public void setProgramado(boolean programado) {
        this.programado = programado;
    }

    public Date getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(Date fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public Date getFechaEjecutada() {
        return fechaEjecutada;
    }

    public void setFechaEjecutada(Date fechaEjecutada) {
        this.fechaEjecutada = fechaEjecutada;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public boolean isProgramado() {
        return programado;
    }

    public String getCodigoPlan() {
        return codigoPlan;
    }

    public void setCodigoPlan(String codigoPlan) {
        this.codigoPlan = codigoPlan;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<PlanIndicador> getIndicadoresSeleccionados() {
        return indicadoresSeleccionados;
    }

    public void setIndicadoresSeleccionados(List<PlanIndicador> indicadoresSeleccionados) {
        this.indicadoresSeleccionados = indicadoresSeleccionados;
    }

    @Override
    public String toString() {
        return "PlanActividad{" + "codigoPlan=" + codigoPlan + ", fechaProgramada=" + fechaProgramada + ", fechaEjecutada=" + fechaEjecutada + ", meta=" + meta + ", programado=" + programado + ", estado=" + estado + ", indicadoresSeleccionados=" + indicadoresSeleccionados + '}';
    }
    

}
