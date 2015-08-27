/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.dao;

import java.util.List;

/**
 *
 * @author Ricardo
 */
public interface BaseDao<T> {

    List<T> listar();

    T obtener(String id);

    void ingresar(T t);

    void actualizar(T t);

    void eliminar(T t);
}
