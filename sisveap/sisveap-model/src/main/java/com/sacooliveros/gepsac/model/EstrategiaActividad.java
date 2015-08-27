/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.model;

import java.util.List;

/**
 *
 * @author Ricardo
 */
public class EstrategiaActividad {

    private String codigoEstrategia;
    private Actividad actividad;
    private List<Indicador> indicadores;

    public String getCodigoEstrategia() {
        return codigoEstrategia;
    }

    public void setCodigoEstrategia(String codigoEstrategia) {
        this.codigoEstrategia = codigoEstrategia;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public List<Indicador> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }

    @Override
    public String toString() {
        return "EstrategiaActividad{" + "codigoEstrategia=" + codigoEstrategia + ", actividad=" + actividad + ", indicadores=" + indicadores + '}';
    }

}
