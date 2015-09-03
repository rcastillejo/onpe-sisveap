package com.sacooliveros.gepsac.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

public interface ConfiguracionMapper {

    public String get(@Param("parametro") String parametro);
    
}
