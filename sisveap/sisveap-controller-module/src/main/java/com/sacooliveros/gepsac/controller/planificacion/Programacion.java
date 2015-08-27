/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.controller.planificacion;

import com.sacooliveros.gepsac.controller.exception.LimiteHoraLaboralException;
import com.sacooliveros.gepsac.controller.util.Constantes;
import com.sacooliveros.gepsac.model.Actividad;
import com.sacooliveros.gepsac.model.Plan;
import com.sacooliveros.gepsac.model.PlanActividad;
import com.sacooliveros.gepsac.model.PlanEstrategia;
import com.sacooliveros.gepsac.model.RestriccionFecha;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ricardo
 * @TODO Mejorar el algoritmo de asignamiento de fechas no programadas
 */
public class Programacion {

    private static final Logger log = LoggerFactory.getLogger(Programacion.class);
    private Calendar fechaInicio;
    private Calendar fechaFin;
    private int diasDisponibles;
    private int semanasDisponibles;
    private int mesesDisponibles;
    private int horasDia;
    private List<RestriccionFecha> restriccionFechas;
    private List<PlanActividad> actividades;
    private List<Date> hitos;

    private final TreeMap<Integer, PlanActividad> actividadesNoProgramadas;
    private final Map<Integer, Integer> diasAsignados;

    public Programacion() {
        diasAsignados = new HashMap<>();
        actividadesNoProgramadas = new TreeMap<>();
    }

    public void configure(Plan plan) {
        setFechaInicio(plan.getFecInicio());
        setFechaFin(plan.getFecFin());
        horasDia = Constantes.HORAS_LABORAL;
        restriccionFechas = plan.getRestriccionFechas();
        setActividades(plan.getEstrategiasSeleccionadas());
        leerHitos(plan.getHitos());
    }

    private void leerHitos(String strhitos) {
        if (!(strhitos == null || strhitos.isEmpty())) {
            SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FMT_FECHA);
            String[] arrayHitos = strhitos.split(",");
            hitos = new ArrayList<>();
            for (String strHito : arrayHitos) {
                try {
                    hitos.add(sdf.parse(strHito));
                } catch (ParseException e) {
                    log.warn("El hito no se pudo interpretar [{}]", strHito);
                }
            }
        }
    }

    public boolean isWorkingDay(Calendar cal) {
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        log.debug("Evaluando dia [{}={}] ... ", new Object[]{cal.getTime(), dayOfWeek});
        return !(dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY);
    }

    public boolean isAvailableDay(Calendar cal) {
        if (restriccionFechas == null || restriccionFechas.isEmpty()) {
            return Boolean.TRUE;
        } else {
            int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
            int dayOfYearNotAvailable;
            Calendar calRestriccion;
            for (RestriccionFecha restriccionFecha : restriccionFechas) {
                calRestriccion = Calendar.getInstance();
                calRestriccion.setTime(restriccionFecha.getFecha());
                dayOfYearNotAvailable = calRestriccion.get(Calendar.DAY_OF_YEAR);
                if (dayOfYear == dayOfYearNotAvailable) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }
    }

    public void calcularFechasDisponibles() {
        diasDisponibles = fechaFin.get(Calendar.DAY_OF_YEAR) - fechaInicio.get(Calendar.DAY_OF_YEAR);
        semanasDisponibles = (int) Math.ceil((double) diasDisponibles / Constantes.DIAS_SEMANAS);
        mesesDisponibles = (int) Math.ceil((double) semanasDisponibles / Constantes.SEMANAS_MES);
        log.trace("diasDisponibles={}, semanasDisponibles={}, mesesDisponibles={}",
                new Object[]{diasDisponibles, semanasDisponibles, mesesDisponibles});
    }

    public void elaborarCronograma() {
        int intervalo = (int) diasDisponibles / (actividades.size() + 1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaInicio.getTime());

        while (existeNoProgramado()) {
            asignarFechas(intervalo, cal);
            cal.setTime(fechaInicio.getTime());
            cal.add(Calendar.DAY_OF_YEAR, 1);
        }

    }

    public boolean existeNoProgramado() {
        for (PlanActividad actividad : actividades) {
            log.debug("Revisando programacion actividad[{}], estado[{}]", new Object[]{actividad.getActividad(), actividad.isProgramado()});
            if (!actividad.isProgramado()) {
                return true;
            }
        }
        return false;
    }

    public void asignarFechas(int intervalo, Calendar cal) {
        log.trace("Elaborando cronograma [intervalo={}, fechaActual={}] ...", new Object[]{intervalo, cal.getTime()});
        for (PlanActividad actividad : actividades) {
            if (!actividad.isProgramado()) {
                cal.add(Calendar.DAY_OF_YEAR, intervalo);
                if (cal.before(fechaFin)) {//La fecha no pasa del fin
                    Calendar validDate = getValidaDay(cal);
                    programarActividad(validDate, actividad);
                } else {// SI pasa se vuelve asignar desde el principio
                    cal.setTime(fechaInicio.getTime());
                    asignarFechas(intervalo, cal);
                }
            }
        }
    }

    public Calendar getValidaDay(Calendar cal) {
        Calendar current = Calendar.getInstance();
        current.setTime(cal.getTime());
        while (!(isAvailableDay(current) && isWorkingDay(current))) {
            current.add(Calendar.DAY_OF_YEAR, 1);
        }
        return current;
    }

    public void programarActividad(Calendar fecha, PlanActividad actividad) {
        Date fecAsignar = fecha.getTime();
        try {
            validarAsignarHora(fecha, actividad.getActividad());
            actividad.setFechaProgramada(fecAsignar);
            actividad.setProgramado(true);
            log.trace("Programacion actividad [fecha={}, planActividad={}]", new Object[]{fecAsignar, actividad});
        } catch (LimiteHoraLaboralException e) {
            log.warn("Supero el limite [fecha={}, planActividad={}, actividad={}], {}", new Object[]{fecAsignar, actividad, actividad.getActividad(), e.getMessage()});
        }
    }

    public void validarAsignarHora(Calendar cal, Actividad actividad) {
        int day = cal.get(Calendar.DAY_OF_YEAR);
        int horasActividad = actividad.getFrecuencia();
        Integer horas = diasAsignados.get(day);
        horas = horas == null ? horasActividad : horas;

        if (horas > horasDia) {
            throw new LimiteHoraLaboralException("Supero el limite de hora [" + horasDia + "], [" + horas + "]");
        }
        diasAsignados.put(day, horas + actividad.getFrecuencia());
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = Calendar.getInstance();
        this.fechaInicio.setTime(fechaInicio);
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = Calendar.getInstance();
        this.fechaFin.setTime(fechaFin);
    }

    public void setHorasDia(int horasDia) {
        this.horasDia = horasDia;
    }

    public void setRestriccionFechas(List<RestriccionFecha> restriccionFechas) {
        this.restriccionFechas = restriccionFechas;
    }

    public void setActividades(List<PlanEstrategia> estrategias) {
        actividades = new ArrayList<>();
        for (PlanEstrategia estrategiasSeleccionada : estrategias) {
            for (PlanActividad actividadSeleccionada : estrategiasSeleccionada.getActividadesSeleccionadas()) {
                actividades.add(actividadSeleccionada);
            }
        }
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public Calendar getFechaFin() {
        return fechaFin;
    }

    public int getDiasDisponibles() {
        return diasDisponibles;
    }

    public int getSemanasDisponibles() {
        return semanasDisponibles;
    }

    public int getMesesDisponibles() {
        return mesesDisponibles;
    }

    public TreeMap<Integer, PlanActividad> getActividadesNoProgramadas() {
        return actividadesNoProgramadas;
    }

    public List<PlanActividad> getActividades() {
        return actividades;
    }

    public int getHorasDia() {
        return horasDia;
    }

    public List<Date> getHitos() {
        return hitos;
    }

}
