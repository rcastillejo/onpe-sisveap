/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.service.comun;

import com.sacooliveros.gepsac.model.Estrategia;
import com.sacooliveros.gepsac.model.EstrategiaActividad;
import com.sacooliveros.gepsac.model.Supervisor;
import com.sacooliveros.gepsac.model.Verificador;
import com.sacooliveros.gepsac.service.exception.ServiceException;
import java.util.List;
import javax.jws.WebMethod;

/**
 *
 * @author Ricardo
 */
public interface IComun {
    
    @WebMethod(operationName = "listarSupervisor")
    List<Supervisor> listarSupervisor() throws ServiceException;
    
    @WebMethod(operationName = "listarVerificador")
    List<Verificador> listarVerificador(String codigoRegion) throws ServiceException;
    
}
