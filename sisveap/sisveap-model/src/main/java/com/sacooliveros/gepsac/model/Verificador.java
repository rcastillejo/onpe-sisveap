/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.model;

import com.sacooliveros.gepsac.model.comun.Estado;

/**
 *
 * @author Ricardo
 */
public class Verificador extends Persona {
    private Region region;
    private Estado estado;
    private int cantOTEnProceso;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getCantOTEnProceso() {
        return cantOTEnProceso;
    }

    public void setCantOTEnProceso(int cantOTEnProceso) {
        this.cantOTEnProceso = cantOTEnProceso;
    }

    @Override
    public String toString() {
        return "Verificador{" + "region=" + region + ", estado=" + estado + ", cantOTEnProceso=" + cantOTEnProceso + '}';
    }
    
}
