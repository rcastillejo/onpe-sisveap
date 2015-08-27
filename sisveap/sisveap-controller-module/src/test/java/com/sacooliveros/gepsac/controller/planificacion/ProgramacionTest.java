/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.controller.planificacion;

import com.sacooliveros.gepsac.controller.exception.LimiteHoraLaboralException;
import com.sacooliveros.gepsac.model.Actividad;
import com.sacooliveros.gepsac.model.PlanActividad;
import com.sacooliveros.gepsac.model.PlanEstrategia;
import com.sacooliveros.gepsac.model.RestriccionFecha;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ricardo
 */
public class ProgramacionTest {

    private static final Logger log = LoggerFactory.getLogger(ProgramacionTest.class);

    public ProgramacionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isWorkingDay method, of class Programacion.
     */
    @Test
    public void testIsWorkingDay() {
        System.out.println("isWorkingDay");

        Calendar cal = Calendar.getInstance();
        Programacion instance = new Programacion();

        cal.set(2015, 6, 28);
        System.out.println("evaluando " + cal.getTime());
        assertTrue(instance.isWorkingDay(cal));
        cal.set(2015, 6, 29);
        System.out.println("evaluando " + cal.getTime());
        assertTrue(instance.isWorkingDay(cal));
        cal.set(2015, 6, 31);
        System.out.println("evaluando " + cal.getTime());
        assertTrue(instance.isWorkingDay(cal));
        cal.set(2015, 7, 1);
        System.out.println("evaluando " + cal.getTime());
        assertFalse(instance.isWorkingDay(cal));
    }

    /**
     * Test of isAvailableDay method, of class Programacion.
     */
    @Test
    public void testIsAvailableDay() {
        System.out.println("testIsAvailableDay");
        List<RestriccionFecha> fechasRestringidas;
        fechasRestringidas = new ArrayList<>();

        fechasRestringidas.add(new RestriccionFecha(new Date(2015, 6, 28)));
        fechasRestringidas.add(new RestriccionFecha(new Date(2015, 6, 29)));
        fechasRestringidas.add(new RestriccionFecha(new Date(2015, 11, 25)));

        Calendar cal = Calendar.getInstance();
        Programacion instance = new Programacion();
        instance.setRestriccionFechas(fechasRestringidas);

        cal.set(2015, 0, 1);
        System.out.println("cal1 " + cal.getTime());
        assertTrue(instance.isAvailableDay(cal));
        cal.set(2015, 6, 28);
        System.out.println("cal2 " + cal.getTime());
        assertFalse(instance.isAvailableDay(cal));
        cal.set(2015, 6, 29);
        System.out.println("cal3 " + cal.getTime());
        assertFalse(instance.isAvailableDay(cal));
        cal.set(2015, 11, 25);
        System.out.println("cal4 " + cal.getTime());
        assertFalse(instance.isAvailableDay(cal));
    }

    /**
     * Test of elaborarCronograma method, of class Programacion.
     */
    @Test
    public void testCalcularFechasDisponibles() {
        System.out.println("testCalcularFechasDisponibles");
        Programacion instance = new Programacion();
        instance.setFechaInicio(new Date(2015, 2, 16));
        instance.setFechaFin(new Date(2015, 11, 18));

        instance.calcularFechasDisponibles();

        System.out.println("dias " + instance.getDiasDisponibles());
        System.out.println("semanas " + instance.getSemanasDisponibles());
        System.out.println("meses " + instance.getMesesDisponibles());

    }

    /**
     * Test of elaborarCronograma method, of class Programacion.
     */
    @Test
    public void testElaborarCronograma() {
        System.out.println("elaborarCronograma");
        List<PlanActividad> actividadesPlan;
        List<RestriccionFecha> fechasRestringidas;
        fechasRestringidas = new ArrayList<>();
        Programacion instance = new Programacion();
        Calendar calFec = Calendar.getInstance();
        calFec.set(2015, 2, 16);
        instance.setFechaInicio(calFec.getTime());
        calFec.set(2015, 11, 18);
        instance.setFechaFin(calFec.getTime());
        instance.setHorasDia(8);

        calFec.set(2015, 6, 28);
        fechasRestringidas.add(new RestriccionFecha(calFec.getTime()));
        calFec.set(2015, 6, 29);
        fechasRestringidas.add(new RestriccionFecha(calFec.getTime()));
        calFec.set(2015, 11, 25);
        fechasRestringidas.add(new RestriccionFecha(calFec.getTime()));

        Actividad actividad;
        PlanActividad actividadPlan;

        List<PlanEstrategia> estrategias = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            PlanEstrategia estrategia = new PlanEstrategia();
            actividadesPlan = new ArrayList<>();
            for (int j = 0; j < 16; j++) {
                actividadPlan = new PlanActividad();
                actividad = new Actividad();
                actividad.setCodigo("AC000-" + i + "-" + j);
                actividad.setNombre("AC000-" + i + "-" + j);
                actividad.setFrecuencia((int) (Math.random() * 3 + 1));
                //actividad.setFrecuencia(8);
                actividadPlan.setActividad(actividad);
                actividadesPlan.add(actividadPlan);
            }
            estrategia.setActividadesSeleccionadas(actividadesPlan);
            estrategias.add(estrategia);
        }

        log.debug("rango de fechas [inicio={},fin{}]", instance.getFechaInicio().getTime(), instance.getFechaFin().getTime());

        instance.setRestriccionFechas(fechasRestringidas);

        instance.setActividades(estrategias);

        instance.calcularFechasDisponibles();

        instance.elaborarCronograma();

        for (PlanActividad planActividad : instance.getActividades()) {
            log.debug("actividad de plan programado [actividad={},planActividad{}]", planActividad.getActividad(), planActividad);
        }

        for (Map.Entry<Integer, PlanActividad> entrySet : instance.getActividadesNoProgramadas().entrySet()) {
            PlanActividad planActividad = entrySet.getValue();
            log.debug("actividad de plan NO programado [actividad={},planActividad{}]", planActividad.getActividad(), planActividad);
        }

        assertTrue(instance.getActividades() != null && !instance.getActividades().isEmpty());
        assertTrue(instance.getActividadesNoProgramadas() == null || instance.getActividadesNoProgramadas().isEmpty());
    }

    /**
     * Test of validarLimiteHora method, of class Programacion.
     */
    @Test
    public void testValidarAsignarHora() {
        System.out.println("testValidarAsignarHora");
        Calendar cal = Calendar.getInstance();
        Actividad actividad = new Actividad();
        actividad.setFrecuencia(5);

        Programacion instance = new Programacion();
        instance.setHorasDia(8);
        try {
            instance.validarAsignarHora(cal, actividad);
            assertTrue(true);
        } catch (LimiteHoraLaboralException e) {
            fail("error");
        }
        try {
            instance.validarAsignarHora(cal, actividad);
            fail("error");
        } catch (LimiteHoraLaboralException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testCalendarAdd() {
        System.out.println("testCalendarAdd");
        Calendar cal = Calendar.getInstance();

        log.debug("fecha [{}]", cal.getTime());
        cal.add(Calendar.DAY_OF_YEAR, 5);
        log.debug("fecha [{}]", cal.getTime());
    }

}
