package com.sacooliveros.gepsac.dao.mybatis.mapper;

import com.sacooliveros.gepsac.model.Supervisor;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupervisorMapper {

    public List<Supervisor> query();
    
    public List<Supervisor> queryReqion(@Param("codigoRegion") String codigoRegion);
}
