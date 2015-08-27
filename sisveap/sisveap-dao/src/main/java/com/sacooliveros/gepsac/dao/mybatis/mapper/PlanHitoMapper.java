package com.sacooliveros.gepsac.dao.mybatis.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface PlanHitoMapper {

    @Select("SELECT fec_hito FROM tp_plan_hito WHERE cod_plan=#{codigo}")
    public List<Date> query(String codigo);

    @Select("SELECT fec_hito FROM tp_plan_hito WHERE cod_plan=#{codigo}")
    public Date get(String codigo);

    @Insert("INSERT INTO tp_plan_hito(cod_plan, fec_hito)"
            + "VALUES(#{codigo},#{fecHito})")
    public int insert(String codigo, Date fecHito);

    @Delete("DELETE FROM tp_plan_hito "
            + "WHERE cod_plan = #{codigo}")
    public int delete(String codigo);

}
