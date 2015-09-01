/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.dao.myibatis;

import com.sacooliveros.gepsac.dao.VerificadorDAO;
import com.sacooliveros.gepsac.dao.exception.DAOException;
import com.sacooliveros.gepsac.dao.mybatis.mapper.VerificadorMapper;
import com.sacooliveros.gepsac.model.Region;
import com.sacooliveros.gepsac.model.Verificador;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcastillejo
 */
public class VerificadorMyIbatisDAO extends GenericMyIbatisDAO implements VerificadorDAO {

    private static final Logger log = LoggerFactory.getLogger(VerificadorMyIbatisDAO.class);

    public VerificadorMyIbatisDAO() {
    }

    @Override
    public List<Verificador> buscarPorRegion(String codigoRegion) {
        SqlSession session = null;
        VerificadorMapper mapper;
        List listado;
        try {
            session = getConnection();
            mapper = session.getMapper(VerificadorMapper.class);
            listado = mapper.queryReqion(codigoRegion);
            log.debug("Listado tamanio[{}] [{}] ", listado == null ? 0 : listado.size(), listado);
            return listado;
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public List<Verificador> listar() {
        SqlSession session = null;
        VerificadorMapper mapper;
        List listado;
        try {
            session = getConnection();
            mapper = session.getMapper(VerificadorMapper.class);
            listado = mapper.query();
            log.debug("Listado tamanio[{}] [{}] ", listado == null ? 0 : listado.size(), listado);
            return listado;
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public Verificador obtener(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresar(Verificador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Verificador model) {
        SqlSession session = null;
        VerificadorMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(VerificadorMapper.class);
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
    public void eliminar(Verificador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Region getRegion(String codigo) {
        SqlSession session = null;
        VerificadorMapper mapper;
        Region model;
        try {
            session = getConnection();
            mapper = session.getMapper(VerificadorMapper.class);
            model = mapper.getRegion(codigo);
            log.debug("model [{}] ", model);
            return model;
        } finally {
            closeConnection(session);
        }
    }
}
