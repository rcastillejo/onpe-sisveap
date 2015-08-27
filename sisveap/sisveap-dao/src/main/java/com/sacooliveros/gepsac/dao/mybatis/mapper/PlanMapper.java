package com.sacooliveros.gepsac.dao.mybatis.mapper;

import com.sacooliveros.gepsac.model.Indicador;
import com.sacooliveros.gepsac.model.Plan;
import com.sacooliveros.gepsac.model.PlanActividad;
import com.sacooliveros.gepsac.model.PlanEstrategia;
import com.sacooliveros.gepsac.model.PlanIndicador;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanMapper {

    public List<Plan> query();

    public Plan get(@Param("codigo") String codigo);

    public Plan obtenerVigente(@Param("anio") int anio);

    public int update(Plan model);
    
    public int insertEstrategia(PlanEstrategia model);
    
    public int insertActividad(PlanActividad model);
    
    public int insertIndicador(Indicador model);
    
    public int deleteEstrategia(String codigoPlan);
    
    public int deleteActividad(String codigoPlan);
    
    public int deleteIndicador(String codigoPlan);

    public List<PlanEstrategia> queryPlanEstrategia(@Param("codigo") String codigoPlan);
    
    public List<PlanActividad> queryPlanActividad(@Param("codigo") String codigoPlan, @Param("codigoEstrategia") String codigoEstrategia);
    
    public List<PlanIndicador> queryPlanIndicador(@Param("codigo") String codigoPlan, @Param("codigoEstrategia") String codigoEstrategia , @Param("codigoActividad") String codigoActividad);

}
