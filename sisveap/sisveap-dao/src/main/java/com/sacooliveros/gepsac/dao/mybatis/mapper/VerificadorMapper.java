package com.sacooliveros.gepsac.dao.mybatis.mapper;

import com.sacooliveros.gepsac.model.Region;
import com.sacooliveros.gepsac.model.Verificador;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VerificadorMapper {

    public List<Verificador> query();
    
    public List<Verificador> queryReqion(@Param("codigoRegion") String codigoRegion);

    public int update(Verificador model);
    
    public Region getRegion(@Param("codigo") String codigo);
}
