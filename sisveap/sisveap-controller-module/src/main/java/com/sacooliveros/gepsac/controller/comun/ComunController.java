/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.controller.comun;

import com.sacooliveros.gepsac.controller.exception.ConrollerModuleException;
import com.sacooliveros.gepsac.dao.DAOFactory;
import com.sacooliveros.gepsac.dao.EstrategiaDAO;
import com.sacooliveros.gepsac.dao.SupervisorDAO;
import com.sacooliveros.gepsac.dao.VerificadorDAO;
import com.sacooliveros.gepsac.model.Estrategia;
import com.sacooliveros.gepsac.model.EstrategiaActividad;
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

    
    public List<Supervisor> listarSupervisor() {
        List<Supervisor> listado;
        try {
            SupervisorDAO dao = DAOFactory.getDAOFactory().getSupervisorDAO();
            listado = dao.listar();
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

}
