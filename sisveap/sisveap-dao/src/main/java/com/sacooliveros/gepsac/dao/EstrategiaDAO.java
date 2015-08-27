/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sacooliveros.gepsac.dao;

import com.sacooliveros.gepsac.model.Estrategia;
import com.sacooliveros.gepsac.model.EstrategiaActividad;
import com.sacooliveros.gepsac.model.Indicador;
import java.util.List;

/**
 *
 * @author rcastillejo
 */
public interface EstrategiaDAO extends BaseDao<Estrategia>{
    
    List<EstrategiaActividad> listarActividad(String id);
    List<Indicador> listarIndicador(String estrategiaId, String actividadId);
    
}
