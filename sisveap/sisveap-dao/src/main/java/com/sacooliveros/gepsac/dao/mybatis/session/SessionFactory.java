package com.sacooliveros.gepsac.dao.mybatis.session;

import com.sacooliveros.gepsac.dao.exception.DAOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {

    protected static final SqlSessionFactory FACTORY;

    static {
        try {
            Reader reader = Resources.getResourceAsReader(
                    "mybatis-config.xml");

            FACTORY = new SqlSessionFactoryBuilder().build(reader);

        } catch (Exception e) {
            throw new DAOException("Error al crear la fabrica de sesiones", e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return FACTORY;
    }
}
