package com.sacooliveros.gepsac.dao.mybatis.mapper;
 
import com.sacooliveros.gepsac.model.Actividad;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface ActividadMapper {

  @Select("SELECT * FROM tp_actividad")
  public List<Actividad> query();
  
}
