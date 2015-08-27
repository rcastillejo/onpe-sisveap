/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.dao.myibatis;

import com.sacooliveros.gepsac.dao.mybatis.session.SessionFactory;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Ricardo
 */
public class GenericMyIbatisDAO {

    public SqlSession getConnection() {
        return SessionFactory.getSqlSessionFactory().openSession();
    }

    public void closeConnection(SqlSession session) {
        if (session != null) {
            session.close();
        }
    }
}
