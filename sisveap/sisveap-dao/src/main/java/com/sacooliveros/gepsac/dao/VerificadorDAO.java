/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sacooliveros.gepsac.dao;

import com.sacooliveros.gepsac.model.Estrategia;
import com.sacooliveros.gepsac.model.Verificador;
import java.util.List;

/**
 *
 * @author rcastillejo
 */
public interface VerificadorDAO extends BaseDao<Verificador>{
        
    List<Verificador> buscarPorRegion(String codigoRegion);
}
