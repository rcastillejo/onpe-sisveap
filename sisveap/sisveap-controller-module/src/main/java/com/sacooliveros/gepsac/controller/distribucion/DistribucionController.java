/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.controller.distribucion;

import com.sacooliveros.gepsac.controller.exception.ConrollerModuleException;
import com.sacooliveros.gepsac.dao.ArchivoOTDAO;
import com.sacooliveros.gepsac.dao.DAOFactory;
import com.sacooliveros.gepsac.dao.OrdenTrabajoDAO;
import com.sacooliveros.gepsac.dao.PlanDAO;
import com.sacooliveros.gepsac.dao.SupervisorDAO;
import com.sacooliveros.gepsac.model.ArchivoOT;
import com.sacooliveros.gepsac.model.OrdenTrabajo;
import com.sacooliveros.gepsac.model.Plan;
import com.sacooliveros.gepsac.model.PlanActividad;
import com.sacooliveros.gepsac.model.PlanEstrategia;
import com.sacooliveros.gepsac.model.PlanIndicador;
import com.sacooliveros.gepsac.model.util.Estado;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ricardo
 */
public class DistribucionController {

    private static final Logger log = LoggerFactory.getLogger(DistribucionController.class);

    interface Mensaje {

        String ASIGNAR_SUPERVISOR = "El archivo de Ordenes de trabajo fue asignado [{0}]";
        String ASIGNAR_VERIFICADOR = "La orden de trabajo fue asignada [{0}]";
        String CONFIGURAR = "Los cambios se grabaron con éxito [{0}]";
        String PROGRAMAR = "La programación fue satisfactoria [{0}]";

    }

    interface Error {

        interface Codigo {

            String GENERAL = "ERR099";
        }

        interface Mensaje {

            String GENERAL = "No se pudo realizar la  operación [{0}]";
            String LISTAR = "No se encuentra planes";
            String ASIGNAR_SUPERVISOR = "Error al asignar supervisor a un archivo de OT";
            String ASIGNAR_VERIFICADOR = "Error al asignar verificador a una orden de trabajo";
            String CONFIGURAR = "Error al configurar el plan";
            String PROGRAMAR = "Error al programar el plan";
            String CONSULTAR_VIGENTE = "No se encontro un plan vigente";
            String CONSULTAR_PARA_CONFIGURAR = "Plan no disponible para configurar";
            String CONSULTAR_CONFIGURADO = "Error al consultar plan configurado";
            String CONSULTAR_PARA_PROGRAMAR = "Plan no disponible para realizar la programacion";
            String CONSULTAR_PROGRAMADO = "Error al consultar plan programado";
        }
    }

    public List<ArchivoOT> listarArchivoOT() {
        List<ArchivoOT> listado;
        try {
            ArchivoOTDAO dao = DAOFactory.getDAOFactory().getArchivoOTDAO();
            listado = dao.listar();
        } catch (Exception e) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.GENERAL, e);
        }

        if (listado == null || listado.isEmpty()) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.LISTAR);
        }
        return listado;
    }

    public List<OrdenTrabajo> listarOrdenTrabajo(String codigoRegion) {
        List<OrdenTrabajo> listado;
        try {
            OrdenTrabajoDAO dao = DAOFactory.getDAOFactory().getOrdenTrabajoDAO();
            listado = dao.buscarPorRegion(codigoRegion);
        } catch (Exception e) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.GENERAL, e);
        }

        if (listado == null || listado.isEmpty()) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.LISTAR);
        }
        return listado;
    }

    public String asignarSupervisor(ArchivoOT archivoOT) {
        try {
            ArchivoOTDAO dao = DAOFactory.getDAOFactory().getArchivoOTDAO();

            archivoOT.setEstado(Estado.ArchivoOT.PROCESO);
            archivoOT.setFecAsignacion(new Date());

            dao.actualizar(archivoOT);
            return MessageFormat.format(Mensaje.ASIGNAR_SUPERVISOR, archivoOT.getCodigo());
        } catch (Exception e) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.ASIGNAR_SUPERVISOR, e);
        }
    }

    public String asignarVerificador(OrdenTrabajo ordenTrabajo) {
        try {
        
            return MessageFormat.format(Mensaje.ASIGNAR_VERIFICADOR, ordenTrabajo.getCodigo());
        } catch (Exception e) {
            log.error("Error al grabar la configuración", e);
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.ASIGNAR_VERIFICADOR, e);
        }
    }

}