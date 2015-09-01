/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.service.distribucion;

import com.sacooliveros.gepsac.controller.distribucion.DistribucionController;
import com.sacooliveros.gepsac.controller.exception.ConrollerModuleException;
import com.sacooliveros.gepsac.model.ArchivoOT;
import com.sacooliveros.gepsac.model.OrdenTrabajo;
import com.sacooliveros.gepsac.service.exception.ServiceException;
import java.util.List;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ricardo
 */
@WebService(serviceName = "DistribucionService")
public class DistribucionService implements IDistribucion {

    private static final Logger log = LoggerFactory.getLogger(DistribucionService.class);

    private final DistribucionController controller;

    public DistribucionService() {
        controller = new DistribucionController();
    }

    @Override
    public List<ArchivoOT> listarArchivoOT() {
        try {
            return controller.listarArchivoOT();
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }

    @Override
    public ArchivoOT obtenerArchivoOT(String codigo) throws ServiceException {
        try {
            ArchivoOT archivoOT = controller.obtenerArchivoOT(codigo);
            List<OrdenTrabajo> ordenes= controller.listarOrdenTrabajo(codigo);
            archivoOT.setOrdenes(ordenes);
            return archivoOT;
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }

    @Override
    public List<OrdenTrabajo> listarOrdenTrabajo(String codigoArchivo) {
        try {
            return controller.listarOrdenTrabajo(codigoArchivo);
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }

    @Override
    public List<OrdenTrabajo> listarOrdenTrabajoPorRegion(String codigoRegion) {
        try {
            return controller.listarOrdenTrabajoPorRegion(codigoRegion);
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }
    
    @Override
    public String asignarSupervisorArchivoOT(ArchivoOT archivoOT) {
        try {
            return controller.asignarSupervisor(archivoOT);
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }
    
    @Override
    public String asignarVerificadorOT(OrdenTrabajo ordenTrabajo) {
        try {
            return controller.asignarVerificador(ordenTrabajo);
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }

    @Override
    public OrdenTrabajo obtenerOT(String codigo) throws ServiceException {
        try {
            return controller.obtenerOT(codigo);
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }
    
}
