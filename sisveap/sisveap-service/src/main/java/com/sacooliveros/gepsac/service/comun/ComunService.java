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
    public List<Estrategia> listarEstrategia() {
        try {
            return controller.listarEstrategia();
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }
    @Override
    public List<EstrategiaActividad> listarEstrategiaActividad(String codEstrategia) {
        try {
            return controller.listarEstrategiaActividad(codEstrategia);
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }
/*
    @Override
    public List<Actividad> listarActividad() {
        try {
            return controller.listarActividad();
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }

    @Override
    public List<Indicador> listarIndicador() {
        try {
            return controller.listarInidicador();
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }*/

}
