/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.model;

import com.sacooliveros.gepsac.model.comun.Model;
import java.util.Date;

/**
 *
 * @author Ricardo
 */
public class OrdenTrabajo extends Model{
    private Date fecIngreso;
    private Date fecAsignado;
    
    private Persona persona;
    private Region region;
    private Supervisor supervisor;
    private Verificador verificador;

    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public Date getFecAsignado() {
        return fecAsignado;
    }

    public void setFecAsignado(Date fecAsignado) {
        this.fecAsignado = fecAsignado;
    }
    
    
}
