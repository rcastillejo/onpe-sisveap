/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.dao.factory;

import com.sacooliveros.gepsac.dao.ArchivoOTDAO;
import com.sacooliveros.gepsac.dao.DAOFactory;
import com.sacooliveros.gepsac.dao.EstrategiaDAO;
import com.sacooliveros.gepsac.dao.OrdenTrabajoDAO;
import com.sacooliveros.gepsac.dao.PlanDAO;
import com.sacooliveros.gepsac.dao.SupervisorDAO;
import com.sacooliveros.gepsac.dao.VerificadorDAO;
import com.sacooliveros.gepsac.dao.myibatis.ArchivoOTMyIbatisDAO;
import com.sacooliveros.gepsac.dao.myibatis.EstrategiaMyIbatisDAO;
import com.sacooliveros.gepsac.dao.myibatis.OrdenTrabajoMyIbatisDAO;
import com.sacooliveros.gepsac.dao.myibatis.PlanMyIbatisDAO;
import com.sacooliveros.gepsac.dao.myibatis.SupervisorMyIbatisDAO;
import com.sacooliveros.gepsac.dao.myibatis.VerificadorMyIbatisDAO;

/**
 *
 * @author rcastillejo
 */
public class MyBatisDAOFactory extends DAOFactory {

    @Override
    public PlanDAO getPlanEstrategicoDAO() {
        return new PlanMyIbatisDAO();
    }

    @Override
    public EstrategiaDAO getEstrategiaDAO() {
        return new EstrategiaMyIbatisDAO();
    }

    @Override
    public ArchivoOTDAO getArchivoOTDAO() {
        return new ArchivoOTMyIbatisDAO();
    }

    @Override
    public OrdenTrabajoDAO getOrdenTrabajoDAO() {
        return new OrdenTrabajoMyIbatisDAO();
    }

    @Override
    public SupervisorDAO getSupervisorDAO() {
        return new SupervisorMyIbatisDAO();
    }

    @Override
    public VerificadorDAO getVerificadorDAO() {
        return new VerificadorMyIbatisDAO();
    }

}
