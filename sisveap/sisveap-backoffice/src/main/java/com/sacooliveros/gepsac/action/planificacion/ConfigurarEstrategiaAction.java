/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.action.planificacion;

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
public class ConfigurarEstrategiaAction extends DispatchAction {

    private static final Logger logger = LoggerFactory.getLogger(ConfigurarEstrategiaAction.class);
    private final Gson jsonBuilder;

    public ConfigurarEstrategiaAction() {
        jsonBuilder = new GsonBuilder().create();
    }

    public void initConsultarEstrategia(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        try {
            ComunService service = ProxyUtil.getCommonServicePort(Config.TIMEOUT);

            Resultado resultado = createSuccessResult(service.listarEstrategia());

            generalAction(resultado, response);
        } catch (Exception e) {
            //logger.error("Error al obtener plan", e);
            LoggerUtil.error(logger, "consultarEstrategia", "planificación",
                    Calendar.getInstance(), ActionUtil.obtenerNombreUsuarioLogeado(request),
                    e.getMessage(), e);
            generalAction(createErrorResult(e), response);
        }
    }

    public void initConsultarActividad(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        try {
            ComunService service = ProxyUtil.getCommonServicePort(Config.TIMEOUT);
            String codigoEstrategia = request.getParameter("codigoEstrategia");
            logger.debug("Consultando actividades de la estrategia [{}]", codigoEstrategia);

            Resultado resultado = createSuccessResult(service.listarEstrategiaActividad(codigoEstrategia));

            generalAction(resultado, response);
        } catch (Exception e) {
            //logger.error("Error al obtener plan", e);
            LoggerUtil.error(logger, "consultarActividad", "planificación",
                    Calendar.getInstance(), ActionUtil.obtenerNombreUsuarioLogeado(request),
                    e.getMessage(), e);
            generalAction(createErrorResult(e), response);
        }
    }

    public void guardarConfiguracionPlan(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("guardando configuracion del plan ... ");
        try {
            PlanificacionService service = ProxyUtil.getPlanificacionServicePort(Config.TIMEOUT);
            String json = request.getParameter("configuracionPlan");
            logger.debug("json [{}]", json);
            com.sacooliveros.gepsac.proxyws.Plan plan = jsonBuilder.fromJson(json, com.sacooliveros.gepsac.proxyws.Plan.class);

            logger.debug("plan [{}]", plan);
            String msg = service.configurar(plan);

            logger.info("Configuracion plan guardado [{}]", msg);
            generalAction(createSuccessResult(msg), response);
        } catch (Exception e) {
            //logger.error("Error al guardar la configuracion del plan", e);
            LoggerUtil.error(logger, "guardarConfiguracionPlan", "planificación",
                    Calendar.getInstance(), ActionUtil.obtenerNombreUsuarioLogeado(request),
                    e.getMessage(), e);
            generalAction(createErrorResult(e), response);
        }
    }

    public void obtenerPlanRegistrado(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("obtenerPlanRegistrado ...");
        try {
            PlanificacionService service = ProxyUtil.getPlanificacionServicePort(Config.TIMEOUT);

            Resultado resultado = createSuccessResult(service.obtenerConfigurarPlan());

            generalAction(resultado, response);
        } catch (Exception e) {
            LoggerUtil.error(logger, "obtenerPlanVigente", "planificación",
                    Calendar.getInstance(), ActionUtil.obtenerNombreUsuarioLogeado(request),
                    e.getMessage(), e);
            generalAction(createErrorResult(e), response);
        }
    }

    public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("configurarEstrategia");
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
