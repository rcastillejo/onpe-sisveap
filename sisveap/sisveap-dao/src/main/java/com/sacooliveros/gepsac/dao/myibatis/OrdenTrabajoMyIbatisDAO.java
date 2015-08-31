/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.dao.myibatis;

import com.sacooliveros.gepsac.dao.OrdenTrabajoDAO;
import com.sacooliveros.gepsac.dao.exception.DAOException;
import com.sacooliveros.gepsac.dao.mybatis.mapper.OrdenTrabajoMapper;
import com.sacooliveros.gepsac.dao.mybatis.mapper.SupervisorMapper;
import com.sacooliveros.gepsac.dao.mybatis.mapper.VerificadorMapper;
import com.sacooliveros.gepsac.model.OrdenTrabajo;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcastillejo
 */
public class OrdenTrabajoMyIbatisDAO extends GenericMyIbatisDAO implements OrdenTrabajoDAO {

    private static final Logger log = LoggerFactory.getLogger(OrdenTrabajoMyIbatisDAO.class);

    public OrdenTrabajoMyIbatisDAO() {
    }

    @Override
    public List<OrdenTrabajo> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<OrdenTrabajo> buscarPorRegion(String codigoRegion) {
        SqlSession session = null;
        OrdenTrabajoMapper mapper;
        List listado;
        try {
            session = getConnection();
            mapper = session.getMapper(OrdenTrabajoMapper.class);
            listado = mapper.queryReqion(codigoRegion);
            log.debug("Listado tamanio[{}] [{}] ", listado == null ? 0 : listado.size(), listado);
            return listado;
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public OrdenTrabajo obtener(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresar(OrdenTrabajo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(OrdenTrabajo model) {
        
        SqlSession session = null;
        OrdenTrabajoMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(OrdenTrabajoMapper.class);
            log.debug("Actualizando [{}] ...", model);
            if (mapper.update(model) == 0) {
                throw new DAOException("No se pudo actualizar");
            }
            session.commit();
            log.info("Verificador actualizado [{}]", model);
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public void eliminar(OrdenTrabajo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    
}
