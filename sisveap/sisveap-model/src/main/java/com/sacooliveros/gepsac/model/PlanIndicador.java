/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.model;

/**
 *
 * @author Ricardo
 */
public class PlanIndicador extends Indicador {

    private String codigoPlan;
    private String codigoEstrategia;
    private String codigoActividad;
    private int meta;

    public String getCodigoEstrategia() {
        return codigoEstrategia;
    }

    public void setCodigoEstrategia(String codigoEstrategia) {
        this.codigoEstrategia = codigoEstrategia;
    }

    public String getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(String codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public String getCodigoPlan() {
        return codigoPlan;
    }

    public void setCodigoPlan(String codigoPlan) {
        this.codigoPlan = codigoPlan;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "PlanIndicador{" + "codigoPlan=" + codigoPlan + ", codigoEstrategia=" + codigoEstrategia + ", codigoActividad=" + codigoActividad + ", meta=" + meta + '}';
    }


}
