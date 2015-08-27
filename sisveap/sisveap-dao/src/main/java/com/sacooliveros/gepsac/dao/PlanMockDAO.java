/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.dao;

import com.sacooliveros.gepsac.dao.exception.DAOException;
import com.sacooliveros.gepsac.model.Plan;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rcastillejo
 */
public class PlanMockDAO  {
    
    private final List<Plan> planes;
    
    public PlanMockDAO() {
        planes = new ArrayList();
    }
  

    //@Override
    public List listar() {
        return planes;
    }
      
    
    //@Override
    public Plan obtener(String id) {
        Plan planEncontrado = null;
        for (Plan plan : planes) {
            if(plan.getCodigo().equals(id)){
                planEncontrado = plan;
                break;
            }
        }
        return planEncontrado;
    }

    ////@Override
    public Plan obtener(Plan plan) {
        return null;
    }


    //@Override
    public void ingresar(Plan plan) {
        plan.setFecCre(new Date());
        boolean agregado = planes.add(plan);
        if(!agregado){
            throw new DAOException("No se pudo ingresar");
        }
    }

    //@Override
    public void actualizar(Plan plan) {
        plan.setFecMod(new Date());
        Plan planEncontrado = obtener(plan.getCodigo());
        int index = planes.indexOf(planEncontrado);
        planes.set(index, plan);
    }

    //@Override
    public void eliminar(Plan plan) {
        Plan planEncontrado = obtener(plan.getCodigo());
        boolean eliminado = planes.remove(planEncontrado);
        if(!eliminado){
            throw new DAOException("No se pudo eliminar");
        }
    }
 

}
