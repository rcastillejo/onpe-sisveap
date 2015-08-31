/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.service.comun;

import com.sacooliveros.gepsac.controller.comun.ComunController;
import com.sacooliveros.gepsac.controller.exception.ConrollerModuleException;
import com.sacooliveros.gepsac.model.Estrategia;
import com.sacooliveros.gepsac.model.EstrategiaActividad;
import com.sacooliveros.gepsac.model.Supervisor;
import com.sacooliveros.gepsac.model.Verificador;
import com.sacooliveros.gepsac.service.exception.ServiceException;
import java.util.List;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ricardo
 */
@WebService(serviceName = "ComunService")
public class ComunService implements IComun {

    private static final Logger log = LoggerFactory.getLogger(ComunService.class);

    private final ComunController controller;

    public ComunService() {
        controller = new ComunController();
    }
        
    @Override
    public List<Supervisor> listarSupervisor(String codigoRegion) {
        try {
            return controller.listarSupervisor(codigoRegion);
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }
    
    @Override
    public List<Verificador> listarVerificador(String codigoRegion) {
        try {
            return controller.listarVerificador(codigoRegion);
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }
    
    
}
