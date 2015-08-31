/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.dao.myibatis;

import com.sacooliveros.gepsac.dao.OrdenTrabajoDAO;
import com.sacooliveros.gepsac.dao.SupervisorDAO;
import com.sacooliveros.gepsac.dao.mybatis.mapper.EstrategiaMapper;
import com.sacooliveros.gepsac.dao.mybatis.mapper.SupervisorMapper;
import com.sacooliveros.gepsac.model.ArchivoOT;
import com.sacooliveros.gepsac.model.Estrategia;
import com.sacooliveros.gepsac.model.Supervisor;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcastillejo
 */
public class SupervisorMyIbatisDAO extends GenericMyIbatisDAO implements SupervisorDAO {

    private static final Logger log = LoggerFactory.getLogger(SupervisorMyIbatisDAO.class);

    public SupervisorMyIbatisDAO() {
    }

    @Override
    public List<Supervisor> listar() {        
        SqlSession session = null;
        SupervisorMapper mapper;
        List listado;
        try {
            session = getConnection();
            mapper = session.getMapper(SupervisorMapper.class);
            listado = mapper.query();
            log.debug("Listado tamanio[{}] [{}] ", listado == null ? 0 : listado.size(), listado);
            return listado;
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public Supervisor obtener(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresar(Supervisor t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Supervisor t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Supervisor t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Supervisor> buscarPorRegion(String codigoRegion) {            
        SqlSession session = null;
        SupervisorMapper mapper;
        List listado;
        try {
            session = getConnection();
            mapper = session.getMapper(SupervisorMapper.class);
            listado = mapper.queryReqion(codigoRegion);
            log.debug("Listado tamanio[{}] [{}] ", listado == null ? 0 : listado.size(), listado);
            return listado;
        } finally {
            closeConnection(session);
        }
    }

}
