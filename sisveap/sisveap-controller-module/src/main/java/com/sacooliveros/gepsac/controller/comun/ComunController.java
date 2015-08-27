/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.controller.comun;

import com.sacooliveros.gepsac.controller.exception.ConrollerModuleException;
import com.sacooliveros.gepsac.dao.DAOFactory;
import com.sacooliveros.gepsac.dao.EstrategiaDAO;
import com.sacooliveros.gepsac.model.Estrategia;
import com.sacooliveros.gepsac.model.EstrategiaActividad;
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

    public List<Estrategia> listarEstrategia() {
        List<Estrategia> listado;
        try {
            EstrategiaDAO dao = DAOFactory.getDAOFactory().getEstrategiaDAO();
            listado = dao.listar();
        } catch (Exception e) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.GENERAL, e);
        }

        if (listado == null || listado.isEmpty()) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.LISTAR);
        }
        return listado;
    }

    public List<EstrategiaActividad> listarEstrategiaActividad(String codigoEstrategia) {
        List<EstrategiaActividad> listado;
        try {
            EstrategiaDAO dao = DAOFactory.getDAOFactory().getEstrategiaDAO();
            listado = dao.listarActividad(codigoEstrategia);
            
            for (EstrategiaActividad actividad : listado) {
                actividad.setIndicadores(dao.listarIndicador(codigoEstrategia, actividad.getActividad().getCodigo()));
            }
            
        } catch (Exception e) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.GENERAL, e);
        }

        if (listado == null || listado.isEmpty()) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.LISTAR);
        }
        return listado;
    }
    /*
     public List<Actividad> listarActividad() {
     List<Actividad> listado;
     try {
     ActividadDAO dao = DAOFactory.getDAOFactory().getActividadDAO();
     listado = dao.listar();
     } catch (Exception e) {
     throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.GENERAL, e);
     }

     if (listado == null || listado.isEmpty()) {
     throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.LISTAR);
     }
     return listado;
     } 

     public List<Inidicador> listarIndicador() {
     List<Inidicador> listado;
     try {
     IndicadorDAO dao = DAOFactory.getDAOFactory().getIndicadorDAO();
     listado = dao.listar();
     } catch (Exception e) {
     throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.GENERAL, e);
     }

     if (listado == null || listado.isEmpty()) {
     throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.LISTAR);
     }
     return listado;
     } */

}
