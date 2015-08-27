/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.service.comun;

import com.sacooliveros.gepsac.model.Estrategia;
import com.sacooliveros.gepsac.model.EstrategiaActividad;
import com.sacooliveros.gepsac.service.exception.ServiceException;
import java.util.List;
import javax.jws.WebMethod;

/**
 *
 * @author Ricardo
 */
public interface IComun {
    
    @WebMethod(operationName = "listarEstrategia")
    List<Estrategia> listarEstrategia() throws ServiceException;
    
    @WebMethod(operationName = "listarEstrategiaActividad")
    List<EstrategiaActividad> listarEstrategiaActividad(String codEstrategia) throws ServiceException;
    /*
    @WebMethod(operationName = "listarActividad")
    List<Actividad> listarActividad() throws ServiceException;
    
    @WebMethod(operationName = "listarIndicador")
    List<Indicador> listarIndicador() throws ServiceException;
    */
    
}
