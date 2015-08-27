/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.form.planificacion;

import java.util.Map;
import java.util.TreeMap;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author rcastillejo
 */
public class ProgramarPlanForm extends ActionForm {

    private Map<String, String> filtro = new TreeMap<String, String>();
    private Map<String, String> data = new TreeMap<String, String>();
    //private Plan plan;
    /**
     * Resultado
     */
    private Map resultado;
    /**
     * Mensajes Satisfactorio
     */
    private String mensaje;
    /**
     * Mensajes de Error
     */
    private String mensajeError;

    public Map<String, String> getFiltro() {
        return filtro;
    }

    public void setFiltro(Map<String, String> filtro) {
        this.filtro = filtro;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public Map getResultado() {
        return resultado;
    }

    public void setResultado(Map resultado) {
        this.resultado = resultado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

}
