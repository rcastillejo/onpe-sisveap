package com.sacooliveros.gepsac.dao.mybatis.mapper;
 
import com.sacooliveros.gepsac.model.Estrategia;
import com.sacooliveros.gepsac.model.EstrategiaActividad;
import com.sacooliveros.gepsac.model.Indicador;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EstrategiaMapper {

  
  public List<Estrategia> query();
  
  public List<EstrategiaActividad> queryActividad(@Param("codigoEstrategia") String codigoEstrategia);
  
  public List<Indicador> queryIndicador(
          @Param("codigoEstrategia") String codigoEstrategia, 
          @Param("codigoActividad") String codigoActividad);

  
  @Select("SELECT * FROM tp_estrategia where cod_estrategia = #{codigoEstrategia")
  public Estrategia get(@Param("codigoEstrategia") String codigoEstrategia);
  
   

}
