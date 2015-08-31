package com.sacooliveros.gepsac.dao.mybatis.mapper;

import com.sacooliveros.gepsac.model.ArchivoOT;
import java.util.List;

public interface ArchivoOTMapper {

    public ArchivoOT get(String codigo);
    
    public List<ArchivoOT> query();

    public int insert(ArchivoOT model);
    
    public int update(ArchivoOT model);
}
