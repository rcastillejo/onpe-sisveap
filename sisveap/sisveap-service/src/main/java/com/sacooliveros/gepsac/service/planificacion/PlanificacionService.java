/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.service.planificacion;

import com.sacooliveros.gepsac.controller.planificacion.PlanificacionController;
import com.sacooliveros.gepsac.controller.exception.ConrollerModuleException;
import com.sacooliveros.gepsac.model.Plan;
import com.sacooliveros.gepsac.service.exception.ServiceException;
import java.util.List;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ricardo
 */
@WebService(serviceName = "PlanificacionService")
public class PlanificacionService implements IPlanificacion {

    private static final Logger log = LoggerFactory.getLogger(PlanificacionService.class);

    private final PlanificacionController controller;

    public PlanificacionService() {
        controller = new PlanificacionController();
    }

    @Override
    public List<Plan> listar() {
        try {
            return controller.listar();
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }
    
    @Override
    public String registrar(Plan plan) {
        try {
            return controller.registrar(plan);
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }
    
    @Override
    public Plan generarProgramacion(Plan plan) {
        try {
            return controller.generarProgramacion(plan);
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }

    @Override
    public String programar(Plan plan) {
        try {
            return null;//controller.programar(plan);
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }

    @Override
    public Plan obtenerVigente() throws ServiceException {        
        try {
            return controller.obtenerPlanVigente();
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }

    @Override
    public String configurar(Plan plan) throws ServiceException {                
        try {
            return controller.configurar(plan);
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }

    @Override
    public Plan obtenerConfigurarPlan() throws ServiceException {
        try {
            return controller.obtenerConfigurarPlan();
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }

    @Override
    public Plan obtenerProgramarPlan() throws ServiceException {
        try {
            return controller.obtenerProgramarPlan();
        } catch (ConrollerModuleException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(e.getCodigo(), e.getMessage());
        }
    }

}
