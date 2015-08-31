/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.model.util;

/**
 *
 * @author Ricardo
 */
public interface Estado {
    
    interface PlanEstrategico{
        String REGISTRADO = "PLA0001";
        String CONFIGURADO = "PLA0002";
        String PROGRAMADO = "PLA0003";
    }
    
    interface ArchivoOT{
        String PENDIENTE = "AOT0001";
        String PROCESO = "AOT0002";
        String ASIGNADO = "AOT0003";
        String TERMINADO = "AOT0004";
        String RECHAZADO = "AOT0005";
    }
    
    interface OT{
        String PENDIENTE = "ORT0001";
        String PROCESO = "ORT0002";
        String ASIGNADO = "ORT0003";
        String TERMINADO = "ORT0004";
        String RECHAZADO = "ORT0005";
    }
}
