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
public class Plan extends Model {

    private Date fecRegistro;
    private Date fecConfiguracion;
    private Date fecProgramacion;
    private Date fecInicio;
    private Date fecFin;
    
    private String titulo;
    private int anio;
    private String hitos;

    private List<RestriccionFecha> restriccionFechas;

    private List<PlanEstrategia> estrategiasSeleccionadas;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public Date getFecConfiguracion() {
        return fecConfiguracion;
    }

    public void setFecConfiguracion(Date fecConfiguracion) {
        this.fecConfiguracion = fecConfiguracion;
    }

    public Date getFecProgramacion() {
        return fecProgramacion;
    }

    public void setFecProgramacion(Date fecProgramacion) {
        this.fecProgramacion = fecProgramacion;
    }

    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public String getHitos() {
        return hitos;
    }

    public void setHitos(String hitos) {
        this.hitos = hitos;
    }

    public List<RestriccionFecha> getRestriccionFechas() {
        return restriccionFechas;
    }

    public void setRestriccionFechas(List<RestriccionFecha> restriccionFechas) {
        this.restriccionFechas = restriccionFechas;
    }

    public List<PlanEstrategia> getEstrategiasSeleccionadas() {
        return estrategiasSeleccionadas;
    }

    public void setEstrategiasSeleccionadas(List<PlanEstrategia> estrategiasSeleccionadas) {
        this.estrategiasSeleccionadas = estrategiasSeleccionadas;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "Plan{" + "fecRegistro=" + fecRegistro + ", fecConfiguracion=" + fecConfiguracion + ", fecProgramacion=" + fecProgramacion + ", fecInicio=" + fecInicio + ", fecFin=" + fecFin + ", titulo=" + titulo + ", anio=" + anio + ", hitos=" + hitos + ", restriccionFechas=" + restriccionFechas + ", estrategiasSeleccionadas=" + estrategiasSeleccionadas + '}';
    }

}
