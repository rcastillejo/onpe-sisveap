/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.dao.myibatis;

import com.sacooliveros.gepsac.dao.ArchivoOTDAO;
import com.sacooliveros.gepsac.dao.exception.DAOException;
import com.sacooliveros.gepsac.dao.mybatis.mapper.ArchivoOTMapper;
import com.sacooliveros.gepsac.model.ArchivoOT;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcastillejo
 */
public class ArchivoOTMyIbatisDAO extends GenericMyIbatisDAO implements ArchivoOTDAO {

    private static final Logger log = LoggerFactory.getLogger(ArchivoOTMyIbatisDAO.class);

    public ArchivoOTMyIbatisDAO() {
    }

    @Override
    public List<ArchivoOT> listar() {
        SqlSession session = null;
        ArchivoOTMapper mapper;
        List listado;
        try {
            session = getConnection();
            mapper = session.getMapper(ArchivoOTMapper.class);
            listado = mapper.query();
            log.debug("Listado tamanio[{}] [{}] ", listado == null ? 0 : listado.size(), listado);
            return listado;
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public ArchivoOT obtener(String id) {
        
        SqlSession session = null;
        ArchivoOTMapper mapper;
        ArchivoOT model;
        try {
            session = getConnection();
            mapper = session.getMapper(ArchivoOTMapper.class);
            model = mapper.get(id);
            log.info("Archivo OT obtenido [{}]",  model);
            return model;
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public void ingresar(ArchivoOT t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(ArchivoOT model) {
        
        SqlSession session = null;
        ArchivoOTMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(ArchivoOTMapper.class);
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
    public void eliminar(ArchivoOT t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
