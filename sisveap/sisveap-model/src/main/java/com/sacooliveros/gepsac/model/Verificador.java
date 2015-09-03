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
public class Verificador extends Persona {

    private Region region;
    private int cantOTEnProceso;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public int getCantOTEnProceso() {
        return cantOTEnProceso;
    }

    public void setCantOTEnProceso(int cantOTEnProceso) {
        this.cantOTEnProceso = cantOTEnProceso;
    }

    @Override
    public String toString() {
        return "Verificador{" + "region=" + region + ", cantOTEnProceso=" + cantOTEnProceso + "," + super.toString() + '}';
    }

}
