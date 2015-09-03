/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.controller.distribucion;

import com.sacooliveros.gepsac.controller.exception.ConrollerModuleException;
import com.sacooliveros.gepsac.dao.ArchivoOTDAO;
import com.sacooliveros.gepsac.dao.ConfiguracionDAO;
import com.sacooliveros.gepsac.dao.DAOFactory;
import com.sacooliveros.gepsac.dao.OrdenTrabajoDAO;
import com.sacooliveros.gepsac.dao.VerificadorDAO;
import com.sacooliveros.gepsac.model.ArchivoOT;
import com.sacooliveros.gepsac.model.OrdenTrabajo;
import com.sacooliveros.gepsac.model.Verificador;
import com.sacooliveros.gepsac.model.util.Estado;
import java.text.MessageFormat;
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

    interface Config {

        String LIMITE_OT_VERIFICADOR = "VER_OT_MAX";
    }

    interface Mensaje {

        String ASIGNAR_SUPERVISOR = "El archivo de Ordenes de trabajo fue asignado [{0}]";
        String ASIGNAR_VERIFICADOR = "La orden de trabajo fue asignada [{0}]";
        String ASIGNAR_VERIFICADOR_OTS = "Las ordenes de trabajo fueron asignadas";
        String CONFIGURAR = "Los cambios se grabaron con éxito [{0}]";
        String PROGRAMAR = "La programación fue satisfactoria [{0}]";

    }

    interface Error {

        interface Codigo {

            String GENERAL = "ERR099";
            String VER_NO_DISP = "ERR059";
        }

        interface Mensaje {

            String GENERAL = "No se pudo realizar la  operación [{0}]";
            String LISTAR_ARHC_OT = "No se encuentra los archivos de ordenes de trabajo";
            String LISTAR_OT = "No se encuentra los archivos de ordenes de trabajo";
            String ARCHIVOOT_NO_DISP = "No se encuentra disponible archivo OT";
            String OT_NO_DISP = "No se encuentra disponible orden de trabajo";
            String ASIGNAR_SUPERVISOR = "Error al asignar supervisor a un archivo de OT";
            String ASIGNAR_VERIFICADOR = "Error al asignar verificador a una orden de trabajo";
            String CONFIGURAR = "Error al configurar el plan";
            String PROGRAMAR = "Error al programar el plan";
            String CONSULTAR_VIGENTE = "No se encontro un plan vigente";
            String CONSULTAR_PARA_CONFIGURAR = "Plan no disponible para configurar";
            String CONSULTAR_CONFIGURADO = "Error al consultar plan configurado";
            String CONSULTAR_PARA_PROGRAMAR = "Plan no disponible para realizar la programacion";
            String CONSULTAR_PROGRAMADO = "Error al consultar plan programado";
            String VERIFICADOR_MAX_OT = "El verificador {0}, tiene asignado 8 OT";
            String VERIFICADOR_NULL = "Error al consultar el verificador {0}";
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
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.LISTAR_ARHC_OT);
        }
        return listado;
    }

    public ArchivoOT obtenerArchivoOT(String codigo) {
        ArchivoOT model;
        try {
            ArchivoOTDAO dao = DAOFactory.getDAOFactory().getArchivoOTDAO();
            model = dao.obtener(codigo);
        } catch (Exception e) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.GENERAL, e);
        }

        if (model == null) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.ARCHIVOOT_NO_DISP);
        }
        return model;
    }

    public List<OrdenTrabajo> listarOrdenTrabajo(String codigoArchivo) {
        List<OrdenTrabajo> listado;
        try {
            OrdenTrabajoDAO dao = DAOFactory.getDAOFactory().getOrdenTrabajoDAO();
            listado = dao.buscarPorArchivo(codigoArchivo);
        } catch (Exception e) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.GENERAL, e);
        }

        if (listado == null || listado.isEmpty()) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.LISTAR_OT);
        }
        return listado;
    }

    public List<OrdenTrabajo> listarOrdenTrabajoPorRegion(String codigoRegion) {
        List<OrdenTrabajo> listado;
        try {
            OrdenTrabajoDAO dao = DAOFactory.getDAOFactory().getOrdenTrabajoDAO();
            listado = dao.buscarPorRegion(codigoRegion);
        } catch (Exception e) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.GENERAL, e);
        }

        if (listado == null || listado.isEmpty()) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.LISTAR_OT);
        }
        return listado;
    }

    public String asignarSupervisor(ArchivoOT archivoOT) {
        try {
            ArchivoOTDAO dao = DAOFactory.getDAOFactory().getArchivoOTDAO();
            ArchivoOT archivoOTActualizar = dao.obtener(archivoOT.getCodigo());
            archivoOTActualizar.setEstado(Estado.ArchivoOT.ASIGNADO);
            archivoOTActualizar.setFecAsignacion(new Date());

            OrdenTrabajoDAO otDao = DAOFactory.getDAOFactory().getOrdenTrabajoDAO();

            for (OrdenTrabajo ot : archivoOT.getOrdenes()) {
                OrdenTrabajo otActualizar = otDao.obtener(ot.getCodigo());
                log.debug("ot obtenido[{}]", otActualizar);
                otActualizar.setFecAsignado(new Date());
                otActualizar.setSupervisor(ot.getSupervisor());
                otActualizar.setEstado(Estado.OT.ASIGNADO);
                log.debug("Actualizar ot[{}]", otActualizar);
                otDao.actualizar(otActualizar);
            }
            log.debug("Actualizar archivo ot[{}]", archivoOTActualizar);

            dao.actualizar(archivoOTActualizar);
            return MessageFormat.format(Mensaje.ASIGNAR_SUPERVISOR, archivoOT.getCodigo());
        } catch (Exception e) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.ASIGNAR_SUPERVISOR, e);
        }
    }

    public Verificador verificarDisponbilidad(Verificador verificadorConsultar) {
        String codigoVerificador = verificadorConsultar.getCodigo();
        try {
            VerificadorDAO dao = DAOFactory.getDAOFactory().getVerificadorDAO();
            Verificador verificador = dao.obtener(codigoVerificador);
            log.debug("Obtenido [{}]", verificador);

            ConfiguracionDAO configDao = DAOFactory.getDAOFactory().getConfiguracionDAO();
            int limiteOtVer = Integer.parseInt(configDao.get(Config.LIMITE_OT_VERIFICADOR));
            log.debug("Limite ot por verificador [{}]", limiteOtVer);

            if (verificador == null) {
                throw new ConrollerModuleException(Error.Codigo.GENERAL, MessageFormat.format(Error.Mensaje.VERIFICADOR_NULL, codigoVerificador));
            }

            if (verificador.getCantOTEnProceso() > limiteOtVer) {
                throw new ConrollerModuleException(Error.Codigo.VER_NO_DISP, MessageFormat.format(Error.Mensaje.VERIFICADOR_MAX_OT, codigoVerificador));
            }
            return verificador;
        } catch (Exception e) {
            log.error("Error al grabar la configuración", e);
            throw new ConrollerModuleException(Error.Codigo.GENERAL, MessageFormat.format(Error.Mensaje.VERIFICADOR_NULL, codigoVerificador), e);
        }
    }

    public Verificador actualizarDisponibilidad(Verificador verificador) {

        VerificadorDAO verdao = DAOFactory.getDAOFactory().getVerificadorDAO();

        Verificador verificadorActualizar = verdao.obtener(verificador.getCodigo());
        log.debug("Verificador a actualizar [{}]", verificadorActualizar);

        ConfiguracionDAO configDao = DAOFactory.getDAOFactory().getConfiguracionDAO();
        int limiteOtVer = Integer.parseInt(configDao.get(Config.LIMITE_OT_VERIFICADOR));
        log.debug("Limite ot por verificador [{}]", limiteOtVer);

        if (verificadorActualizar.getCantOTEnProceso() == limiteOtVer) {
            verificadorActualizar.setEstado(Estado.Verificador.NO_DISPONIBLE);
            log.debug("Verificador llego al limite [{}]", verificadorActualizar);
        } else if (verificadorActualizar.getCantOTEnProceso() < limiteOtVer) {
            verificadorActualizar.setEstado(Estado.Verificador.DISPONIBLE);
            log.debug("Verificador aun no llega al limite [{}]", verificadorActualizar);
        }
        verdao.actualizar(verificadorActualizar);
        log.debug("Verificador a actualizado [{}]", verificadorActualizar);
        return verificadorActualizar;
    }

    public String asignarVerificador(OrdenTrabajo ordenTrabajo) {

        try {

            Verificador verificadorAsignar = verificarDisponbilidad(ordenTrabajo.getVerificador());
            log.debug("Verificador disponible [{}]", verificadorAsignar);

            OrdenTrabajoDAO dao = DAOFactory.getDAOFactory().getOrdenTrabajoDAO();
            OrdenTrabajo oTActualizar = dao.obtener(ordenTrabajo.getCodigo());
            oTActualizar.setEstado(Estado.OT.PROCESO);
            oTActualizar.setFecAsignado(new Date());

            Verificador verificadorDesAsignar = oTActualizar.getVerificador();

            oTActualizar.setVerificador(verificadorAsignar);

            log.debug("Actualizar ot[{}]", oTActualizar);

            dao.actualizar(oTActualizar);

            /*VerificadorDAO verdao = DAOFactory.getDAOFactory().getVerificadorDAO();

             verificadorAsignar = verdao.obtener(verificadorAsignar.getCodigo());
             log.debug("Verificador a asignar [{}]", verificadorAsignar);
            
             if (verificadorAsignar.getCantOTEnProceso() == LIMITE_OT_VERIFICADOR) {
             log.debug("Actualizando disponibilidad verificador [{}]", verificadorAsignar);
             verificadorAsignar.setEstado(Estado.Verificador.NO_DISPONIBLE);
             verdao.actualizar(verificadorAsignar);
             }

             verificadorDesAsignar = verdao.obtener(verificadorDesAsignar.getCodigo());
             log.debug("Verificador a desasignar [{}]", verificadorDesAsignar);

             if (verificadorDesAsignar.getCantOTEnProceso() < LIMITE_OT_VERIFICADOR) {
             verificadorDesAsignar.setEstado(Estado.Verificador.DISPONIBLE);
             verdao.actualizar(verificadorDesAsignar);
             }*/
            log.debug("actualizando disponibilidad verificadorAsignar ... [{}]", verificadorAsignar);
            actualizarDisponibilidad(verificadorAsignar);
            if (verificadorDesAsignar != null && verificadorDesAsignar.getCodigo() != null) {
                log.debug("actualizando disponibilidad verificadorDesAsignar ... [{}]", verificadorDesAsignar);
                actualizarDisponibilidad(verificadorDesAsignar);
            }

            return MessageFormat.format(Mensaje.ASIGNAR_VERIFICADOR, ordenTrabajo.getCodigo());
        } catch (ConrollerModuleException e) {
            throw e;
        } catch (Exception e) {
            log.error("Error al grabar la configuración", e);
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.ASIGNAR_VERIFICADOR, e);
        }
    }

    public String asignarVerificadores(List<OrdenTrabajo> ordenesTrabajo) {
        try {
            String codigoArchivo = null;
            for (OrdenTrabajo ordenTrabajo : ordenesTrabajo) {
                asignarVerificador(ordenTrabajo);
                codigoArchivo = ordenTrabajo.getCodigoArchivo();
            }

            ArchivoOTDAO aotdao = DAOFactory.getDAOFactory().getArchivoOTDAO();
            ArchivoOT archivoOT = aotdao.obtener(codigoArchivo);
            archivoOT.setEstado(Estado.ArchivoOT.PROCESO);
            aotdao.actualizar(archivoOT);
            return Mensaje.ASIGNAR_VERIFICADOR_OTS;
        } catch (Exception e) {
            log.error("Error al grabar la configuración", e);
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.ASIGNAR_VERIFICADOR, e);
        }
    }

    public OrdenTrabajo obtenerOT(String codigo) {
        OrdenTrabajo model;
        try {
            OrdenTrabajoDAO dao = DAOFactory.getDAOFactory().getOrdenTrabajoDAO();
            model = dao.obtener(codigo);
        } catch (Exception e) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.GENERAL, e);
        }

        if (model == null) {
            throw new ConrollerModuleException(Error.Codigo.GENERAL, Error.Mensaje.OT_NO_DISP);
        }
        return model;
    }

}
