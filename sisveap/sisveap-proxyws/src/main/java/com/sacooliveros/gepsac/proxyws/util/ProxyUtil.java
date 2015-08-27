/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.proxyws.util;

import com.sacooliveros.gepsac.proxyws.ComunService;
import com.sacooliveros.gepsac.proxyws.ComunService_Service;
import com.sacooliveros.gepsac.proxyws.PlanificacionService;
import com.sacooliveros.gepsac.proxyws.PlanificacionService_Service;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author Ricardo
 */
public class ProxyUtil {
    private static final String PLAN_ENDPOINT = "http://localhost:8180/gepsac-service/PlanificacionService";
    private static final String COMMON_ENDPOINT = "http://localhost:8180/gepsac-service/ComunService";

    public static PlanificacionService getPlanificacionServicePort(long timeout) {
        PlanificacionService_Service service = new PlanificacionService_Service();
        PlanificacionService port = service.getPlanificacionServicePort();
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, PLAN_ENDPOINT);
        bp.getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", timeout);
        bp.getRequestContext().put("com.sun.xml.internal.ws.request.timeout", timeout);
        return port;
    }

    public static ComunService getCommonServicePort(long timeout) {
        ComunService_Service service = new ComunService_Service();
        ComunService port = service.getComunServicePort();
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, COMMON_ENDPOINT);
        bp.getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", timeout);
        bp.getRequestContext().put("com.sun.xml.internal.ws.request.timeout", timeout);
        return port;
    }

}
