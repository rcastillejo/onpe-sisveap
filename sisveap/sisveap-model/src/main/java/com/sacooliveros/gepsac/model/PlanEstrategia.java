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
public class PlanEstrategia extends Estrategia {

    private String codigoPlan;
    private List<PlanActividad> actividadesSeleccionadas;

    public List<PlanActividad> getActividadesSeleccionadas() {
        return actividadesSeleccionadas;
    }

    public void setActividadesSeleccionadas(List<PlanActividad> actividadesSeleccionadas) {
        this.actividadesSeleccionadas = actividadesSeleccionadas;
    }

    public String getCodigoPlan() {
        return codigoPlan;
    }

    public void setCodigoPlan(String codigoPlan) {
        this.codigoPlan = codigoPlan;
    }

    @Override
    public String toString() {
        return "PlanEstrategia{" + "codigoPlan=" + codigoPlan + ", actividadesSeleccionadas=" + actividadesSeleccionadas + '}';
    }

}
