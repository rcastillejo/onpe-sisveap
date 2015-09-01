/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.controller.comun;

import com.sacooliveros.gepsac.controller.exception.ConrollerModuleException;
import com.sacooliveros.gepsac.dao.DAOFactory;
import com.sacooliveros.gepsac.dao.SupervisorDAO;
import com.sacooliveros.gepsac.dao.VerificadorDAO;
import com.sacooliveros.gepsac.model.Region;
import com.sacooliveros.gepsac.model.Supervisor;
import com.sacooliveros.gepsac.model.Verificador;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class ComunController {

    interface Error {

        interface Codigo {

            String GENERAL = "EPE099";
        }

        interface Mensaje {

            String GENERAL = "No se pudo realizar la  operación [{0}]";
            String LISTAR = "No se encuentra registros";
        }
    }

    
    public List<Supervisor> listarSupervisor(String codigoRegion) {
        List<Supervisor> listado;
        try {
            SupervisorDAO dao = DAOFactory.getDAOFactory().getSupervisorDAO();
            listado = dao.buscarPorRegion(codigoRegion);
        } catch (Exception e) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.GENERAL, e);
        }

        if (listado == null || listado.isEmpty()) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.LISTAR);
        }
        return listado;
    }
    
    public List<Verificador> listarVerificador(String codigoRegion) {
        List<Verificador> listado;
        try {
            VerificadorDAO dao = DAOFactory.getDAOFactory().getVerificadorDAO();
            listado = dao.buscarPorRegion(codigoRegion);
        } catch (Exception e) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.GENERAL, e);
        }

        if (listado == null || listado.isEmpty()) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.LISTAR);
        }
        return listado;
    }
    
    public Region obtenerRegion(String codigoRegion) {
        Region model;
        try {
            VerificadorDAO dao = DAOFactory.getDAOFactory().getVerificadorDAO();
            model = dao.getRegion(codigoRegion);
        } catch (Exception e) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.GENERAL, e);
        }

        if (model == null) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, "No se encontro region");
        }
        return model;
    }

}
