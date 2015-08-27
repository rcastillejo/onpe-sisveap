/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.service.planificacion;

import com.sacooliveros.gepsac.model.Plan;
import com.sacooliveros.gepsac.service.exception.ServiceException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ricardo
 */
public interface IPlanificacion {

    @WebMethod(operationName = "configurar")
    List<Plan> listar() throws ServiceException;

    @WebMethod(operationName = "obtenerVigente")
    Plan obtenerVigente() throws ServiceException;

    @WebMethod(operationName = "obtenerConfigurarPlan")
    Plan obtenerConfigurarPlan() throws ServiceException;

    @WebMethod(operationName = "registrar")
    String registrar(@WebParam(name = "plan") Plan plan) throws ServiceException;

    @WebMethod(operationName = "configurar")
    String configurar(@WebParam(name = "plan") Plan plan) throws ServiceException;

    @WebMethod(operationName = "obtenerProgramarPlan")
    Plan obtenerProgramarPlan() throws ServiceException;

    @WebMethod(operationName = "generarProgramacion")
    Plan generarProgramacion(@WebParam(name = "plan") Plan plan) throws ServiceException;

    @WebMethod(operationName = "programar")
    String programar(@WebParam(name = "plan") Plan plan) throws ServiceException;

}
