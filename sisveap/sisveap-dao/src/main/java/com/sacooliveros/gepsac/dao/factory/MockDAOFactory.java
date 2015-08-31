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
import com.sacooliveros.gepsac.dao.PlanMockDAO;
import com.sacooliveros.gepsac.dao.SupervisorDAO;
import com.sacooliveros.gepsac.dao.VerificadorDAO;

/**
 *
 * @author rcastillejo
 */
public class MockDAOFactory extends DAOFactory {

    private static MockDAOFactory instance;
    private final PlanMockDAO planEstrategicoDao;

    public static MockDAOFactory getInstance() {
        if (instance == null) {
            instance = new MockDAOFactory();
        }
        return instance;
    }

    public MockDAOFactory() {
        planEstrategicoDao = new PlanMockDAO();
    }

    @Override
    public PlanDAO getPlanEstrategicoDAO() {
        return null;//planEstrategicoDao;
    }

    @Override
    public EstrategiaDAO getEstrategiaDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArchivoOTDAO getArchivoOTDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrdenTrabajoDAO getOrdenTrabajoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SupervisorDAO getSupervisorDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VerificadorDAO getVerificadorDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
