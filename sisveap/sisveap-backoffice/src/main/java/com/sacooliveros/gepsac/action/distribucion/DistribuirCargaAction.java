/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.action.distribucion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sacooliveros.gepsac.exception.LoggerUtil;
import com.novatronic.sca.util.ActionUtil;
import com.novatronic.sca.util.Config;
import com.novatronic.sca.util.Resultado;
import com.sacooliveros.gepsac.proxyws.ComunService;
import com.sacooliveros.gepsac.proxyws.PlanificacionService;
import com.sacooliveros.gepsac.proxyws.util.ProxyUtil;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcastillejo
 */
public class DistribuirCargaAction extends DispatchAction {

    private static final Logger logger = LoggerFactory.getLogger(DistribuirCargaAction.class);
    private final Gson jsonBuilder;

    public DistribuirCargaAction() {
        jsonBuilder = new GsonBuilder().create();
    }
    
    public void listarArchivoOT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        try {
            ComunService service = ProxyUtil.getCommonServicePort(Config.TIMEOUT);

            Resultado resultado = createSuccessResult(service.listarArchivoOT());

            generalAction(resultado, response);
        } catch (Exception e) {
            //logger.error("Error al obtener plan", e);
            LoggerUtil.error(logger, "consultarEstrategia", "planificación",
                    Calendar.getInstance(), ActionUtil.obtenerNombreUsuarioLogeado(request),
                    e.getMessage(), e);
            generalAction(createErrorResult(e), response);
        }
    }
    
    public void obtenerArchivoOT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        try {
            ComunService service = ProxyUtil.getCommonServicePort(Config.TIMEOUT);
            
            String codigo = request.getParameter("codigoArchivoOT");

            Resultado resultado = createSuccessResult(service.obtenerArchivoOT(codigo));

            generalAction(resultado, response);
        } catch (Exception e) {
            //logger.error("Error al obtener plan", e);
            LoggerUtil.error(logger, "obtenerArchivoOT", "distribuicion",
                    Calendar.getInstance(), ActionUtil.obtenerNombreUsuarioLogeado(request),
                    e.getMessage(), e);
            generalAction(createErrorResult(e), response);
        }
    }
    
    public void asignarSupervisorArchivoOT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        try {
            ComunService service = ProxyUtil.getCommonServicePort(Config.TIMEOUT);
            
            String json = request.getParameter("archivoOT");
            logger.debug("json [{}]", json);
            com.sacooliveros.gepsac.proxyws.Plan plan = jsonBuilder.fromJson(json, com.sacooliveros.gepsac.proxyws.Plan.class);

            logger.debug("archivo OT [{}]", plan);
            String msg = service.asignarSupervisor(plan);

            logger.info("Archivo OT asignado [{}]", msg);
            generalAction(createSuccessResult(msg), response);
        } catch (Exception e) {
            //logger.error("Error al obtener plan", e);
            LoggerUtil.error(logger, "obtenerArchivoOT", "distribuicion",
                    Calendar.getInstance(), ActionUtil.obtenerNombreUsuarioLogeado(request),
                    e.getMessage(), e);
            generalAction(createErrorResult(e), response);
        }
    }
    
    public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("programarPlan");
    }

    private Resultado createSuccessResult(Object obj) {
        String json = jsonBuilder.toJson(obj, obj.getClass());
        return new Resultado(json, HttpServletResponse.SC_OK);
    }

    private Resultado createErrorResult(Exception e) {
        return createErrorResult(e.getMessage());
    }

    private Resultado createErrorResult(String message) {
        return new Resultado(null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message);
    }

    private void generalAction(Resultado resultado, HttpServletResponse response) {
        String json;
        String mensaje;
        json = resultado.getJson();
        mensaje = resultado.getMensaje();

        if (StringUtils.isNotBlank(json)) {
            ActionUtil.enviarJson(json, response);
        }

        if (StringUtils.isNotBlank(mensaje)) {
            try {
                response.getWriter().write(mensaje);
                response.flushBuffer();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        response.setStatus(resultado.getCodigo());
    }
}
