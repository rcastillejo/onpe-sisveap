/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.dao.myibatis;

import com.sacooliveros.gepsac.dao.ConfiguracionDAO;
import com.sacooliveros.gepsac.dao.mybatis.mapper.ConfiguracionMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcastillejo
 */
public class ConfiguracionMyIbatisDAO extends GenericMyIbatisDAO implements ConfiguracionDAO {

    private static final Logger log = LoggerFactory.getLogger(ConfiguracionMyIbatisDAO.class);

    public ConfiguracionMyIbatisDAO() {
    }

    @Override
    public String get(String parametro) {
        SqlSession session = null;
        ConfiguracionMapper mapper;
        String valorConfig;
        try {
            session = getConnection();
            mapper = session.getMapper(ConfiguracionMapper.class);
            valorConfig = mapper.get(parametro);
            log.debug("valorConfig [{}] ", valorConfig);
            return valorConfig;
        } finally {
            closeConnection(session);
        }
    }

}
