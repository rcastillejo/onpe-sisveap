/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.service.distribucion;

import com.sacooliveros.gepsac.model.ArchivoOT;
import com.sacooliveros.gepsac.model.OrdenTrabajo;
import com.sacooliveros.gepsac.service.exception.ServiceException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ricardo
 */
public interface IDistribucion {

    @WebMethod(operationName = "listarArchivoOT")
    List<ArchivoOT> listarArchivoOT() throws ServiceException;

    @WebMethod(operationName = "obtenerArchivoOT")
    ArchivoOT obtenerArchivoOT(@WebParam(name = "codigo") String codigo) throws ServiceException;

    @WebMethod(operationName = "listarOrdenTrabajo")
    List<OrdenTrabajo>  listarOrdenTrabajo(String codigoArchivo) throws ServiceException;

    @WebMethod(operationName = "listarOrdenTrabajoRegion")
    List<OrdenTrabajo>  listarOrdenTrabajoPorRegion(String codigoRegion) throws ServiceException;

    @WebMethod(operationName = "asignarSupervisorArchivoOT")
    String asignarSupervisorArchivoOT(@WebParam(name = "archivoOT") ArchivoOT archivoOT) throws ServiceException;

    @WebMethod(operationName = "asignarVerificadorOT")
    String asignarVerificadorOT(@WebParam(name = "ordenTrabajo") OrdenTrabajo ordenTrabajo) throws ServiceException;
 
    @WebMethod(operationName = "obtenerOT")
    OrdenTrabajo obtenerOT(@WebParam(name = "codigo") String codigo) throws ServiceException;


}
