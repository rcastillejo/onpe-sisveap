package com.sacooliveros.gepsac.dao.mybatis.mapper;

import com.sacooliveros.gepsac.model.OrdenTrabajo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdenTrabajoMapper {

    public OrdenTrabajo get(@Param("codigo") String codigo );
    
    public List<OrdenTrabajo> query();
    
    public List<OrdenTrabajo> queryArchivo(@Param("codigoArchivo") String codigoRegion);
    public List<OrdenTrabajo> queryReqion(@Param("codigoRegion") String codigoRegion);

    public int insert(OrdenTrabajo model);
    
    public int update(OrdenTrabajo model);
}
