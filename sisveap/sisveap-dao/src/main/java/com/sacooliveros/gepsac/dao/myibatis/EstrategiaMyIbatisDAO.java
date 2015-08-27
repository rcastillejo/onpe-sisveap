/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.dao.myibatis;

import com.sacooliveros.gepsac.dao.EstrategiaDAO;
import com.sacooliveros.gepsac.dao.exception.DAOException;
import com.sacooliveros.gepsac.dao.mybatis.mapper.EstrategiaMapper;
import com.sacooliveros.gepsac.model.Estrategia;
import com.sacooliveros.gepsac.model.EstrategiaActividad;
import com.sacooliveros.gepsac.model.Indicador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcastillejo
 */
public class EstrategiaMyIbatisDAO extends GenericMyIbatisDAO implements EstrategiaDAO {

    private static final Logger log = LoggerFactory.getLogger(EstrategiaMyIbatisDAO.class);
    private final List<Estrategia> planes;

    public EstrategiaMyIbatisDAO() {
        planes = new ArrayList();
    }

    @Override
    public List<Estrategia> listar() {
        SqlSession session = null;
        EstrategiaMapper mapper;
        List<Estrategia> listado;
        try {
            session = getConnection();
            mapper = session.getMapper(EstrategiaMapper.class);
            listado = mapper.query();
            log.debug("Listado tamanio[{}] [{}] ", listado == null ? 0 : listado.size(), listado);
            return listado;
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public Estrategia obtener(String id) {
        SqlSession session = null;
        EstrategiaMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(EstrategiaMapper.class);
            return mapper.get(id);
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public void ingresar(Estrategia plan) {

    }

    @Override
    public void actualizar(Estrategia plan) {
        plan.setFecMod(new Date());
        Estrategia planEncontrado = obtener(plan.getCodigo());
        int index = planes.indexOf(planEncontrado);
        planes.set(index, plan);
    }

    @Override
    public void eliminar(Estrategia plan) {
        Estrategia planEncontrado = obtener(plan.getCodigo());
        boolean eliminado = planes.remove(planEncontrado);
        if (!eliminado) {
            throw new DAOException("No se pudo eliminar");
        }
    }

    @Override
    public List<EstrategiaActividad> listarActividad(String id) {
        SqlSession session = null;
        EstrategiaMapper mapper;

        try {
            session = getConnection();
            //mapper = getMapper(EstrategiaMapper.class);
            List<EstrategiaActividad> listado = session.selectList("queryActividad", id);//mapper.queryActividad(id);
            log.debug("Listado Actividad tamanio[{}] [{}] ", listado == null ? 0 : listado.size(), listado);
            return listado;
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public List<Indicador> listarIndicador(String estratediaId, String actividadId) {
        SqlSession session = null;
        EstrategiaMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(EstrategiaMapper.class);
            List<Indicador> listado = mapper.queryIndicador(estratediaId, actividadId);
            log.debug("Listado Indicador tamanio[{}] [{}] ", listado == null ? 0 : listado.size(), listado);
            return listado;
        } finally {
            closeConnection(session);
        }
    }

}
