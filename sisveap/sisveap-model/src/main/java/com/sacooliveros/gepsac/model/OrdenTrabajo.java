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
public class OrdenTrabajo extends Model {
    private String codigoArchivo;
    private Date fecIngreso;
    private Date fecAsignado;

    private Persona persona;
    private Region region;
    private Supervisor supervisor;
    private Verificador verificador;

    public String getCodigoArchivo() {
        return codigoArchivo;
    }

    public void setCodigoArchivo(String codigoArchivo) {
        this.codigoArchivo = codigoArchivo;
    }

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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Verificador getVerificador() {
        return verificador;
    }

    public void setVerificador(Verificador verificador) {
        this.verificador = verificador;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "OrdenTrabajo{" + "fecIngreso=" + fecIngreso + ", fecAsignado=" + fecAsignado + ", persona=" + persona + ", region=" + region + ", supervisor=" + supervisor + ", verificador=" + verificador + ',' + super.toString() + '}';
    }


}
