/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.dao.myibatis;

import com.sacooliveros.gepsac.dao.PlanDAO;
import com.sacooliveros.gepsac.dao.exception.DAOException;
import com.sacooliveros.gepsac.dao.mybatis.mapper.PlanMapper;
import com.sacooliveros.gepsac.model.Plan;
import com.sacooliveros.gepsac.model.PlanActividad;
import com.sacooliveros.gepsac.model.PlanEstrategia;
import com.sacooliveros.gepsac.model.PlanIndicador;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcastillejo
 */
public class PlanMyIbatisDAO extends GenericMyIbatisDAO implements PlanDAO {

    private static final Logger log = LoggerFactory.getLogger(PlanMyIbatisDAO.class);

    public PlanMyIbatisDAO() {
    }

    @Override
    public List listar() {
        SqlSession session = null;
        PlanMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(PlanMapper.class);
            List listado = mapper.query();
            log.debug("Listado Actividad tamanio[{}] [{}] ", listado == null ? 0 : listado.size(), listado);
            return listado;
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public Plan obtener(String id) {
        Plan plan;
        SqlSession session = null;
        PlanMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(PlanMapper.class);
            plan = mapper.get(id);
            log.info("Plan obtenido [{}]", plan);
            return mapper.get(id);
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public Plan obtenerVigente(int anio) {
        Plan planVigente;
        SqlSession session = null;
        PlanMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(PlanMapper.class);
            planVigente = mapper.obtenerVigente(anio);
            log.info("Plan vigente obtenido [{}]", planVigente);
            return planVigente;
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public void ingresar(Plan plan) {

    }

    @Override
    public void actualizar(Plan plan) {
        SqlSession session = null;
        PlanMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(PlanMapper.class);
            log.debug("Actualizando [{}] ...", plan);
            if (mapper.update(plan) == 0) {
                throw new DAOException("No se pudo actualizar");
            }
            session.commit();
            log.info("Plan actualizado [{}]", plan);
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public void insertEstrategia(PlanEstrategia estrategia) {
        SqlSession session = null;
        PlanMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(PlanMapper.class);
            log.debug("Ingresando [{}] ...", estrategia);
            if (mapper.insertEstrategia(estrategia) == 0) {
                throw new DAOException("No se pudo ingresar");
            }
            session.commit();
            log.info("Estrategia ingresada [{}]", estrategia);
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public void insertActividad(PlanActividad actividad) {
        SqlSession session = null;
        PlanMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(PlanMapper.class);
            log.debug("Ingresando [{}] ...", actividad);
            if (mapper.insertActividad(actividad) == 0) {
                throw new DAOException("No se pudo ingresar");
            }
            session.commit();
            log.info("Actividad ingresada [{}]", actividad);
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public void insertIndicador(PlanIndicador indicador) {
        SqlSession session = null;
        PlanMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(PlanMapper.class);
            log.debug("Ingresando [{}] ...", indicador);
            if (mapper.insertIndicador(indicador) == 0) {
                throw new DAOException("No se pudo ingresar");
            }
            session.commit();
            log.info("Actividad ingresada [{}]", indicador);
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public void eliminar(Plan plan) {

    }

    @Override
    public void deleteEstrategia(String codigoPlan) {
        SqlSession session = null;
        PlanMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(PlanMapper.class);
            log.debug("Eliminado [{}] ...", codigoPlan);
            if (mapper.deleteEstrategia(codigoPlan) == 0) {
                throw new DAOException("No se pudo eliminar");
            }
            session.commit();
            log.info("Estrategias del plan [{}] eliminados", codigoPlan);
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public void deleteActividad(String codigoPlan) {
        SqlSession session = null;
        PlanMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(PlanMapper.class);
            log.debug("Eliminado [{}] ...", codigoPlan);
            if (mapper.deleteActividad(codigoPlan) == 0) {
                throw new DAOException("No se pudo eliminar");
            }
            session.commit();
            log.info("Actividades del plan [{}] eliminados", codigoPlan);
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public void deleteIndicador(String codigoPlan) {
        SqlSession session = null;
        PlanMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(PlanMapper.class);
            log.debug("Eliminado [{}] ...", codigoPlan);
            if (mapper.deleteIndicador(codigoPlan) == 0) {
                throw new DAOException("No se pudo eliminar");
            }
            session.commit();
            log.info("Inidicadores del plan [{}] eliminados", codigoPlan);
        } finally {
            closeConnection(session);
        }
    }
    
    @Override
    public List listarPlanEstrategia(String codigoPlan) {
        SqlSession session = null;
        PlanMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(PlanMapper.class);
            List listado = mapper.queryPlanEstrategia(codigoPlan);
            log.debug("Listado Estrategia tamanio[{}] [{}] ", listado == null ? 0 : listado.size(), listado);
            return listado;
        } finally {
            closeConnection(session);
        }
    }
    
    @Override
    public List listarPlanActividad(String codigoPlan, String codigoEstrategia) {
        SqlSession session = null;
        PlanMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(PlanMapper.class);
            List listado = mapper.queryPlanActividad(codigoPlan, codigoEstrategia);
            log.debug("Listado Actividad tamanio[{}] [{}] ", listado == null ? 0 : listado.size(), listado);
            return listado;
        } finally {
            closeConnection(session);
        }
    }

    @Override
    public List<PlanIndicador> listarPlanIndicador(String codigoPlan, String codigoEstrategia, String codigoActividad) {
        SqlSession session = null;
        PlanMapper mapper;

        try {
            session = getConnection();
            mapper = session.getMapper(PlanMapper.class);
            List listado = mapper.queryPlanIndicador(codigoPlan, codigoEstrategia, codigoActividad);
            log.debug("Listado Indicador tamanio[{}] [{}] ", listado == null ? 0 : listado.size(), listado);
            return listado;
        } finally {
            closeConnection(session);
        }
    }

}
