/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.sca.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 *
 * @author Marco
 * Clase que contiene metódos de manejo y formateo de fechas
 */
public final class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
    private static DateFormat formatFull = new SimpleDateFormat("yyyyMMddHmm");
    static long milisegundos_dia = 24 * 60 * 60 * 1000;

	private static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
	private static SimpleDateFormat dateFormatShort=new SimpleDateFormat("yyyy-MM-dd");
	
    private static Logger logger = Logger.getLogger(DateUtil.class);
    
     /**
     * Método que obtiene la fecha actual
     */
    public static String obtenerFechaActualtoString() {
        String resultado = null;
        try {
            resultado = sdf.format(new Date());
        } catch (Exception e) {
            logger.error("EX* obtenerFechaActualtoString : " + e.getMessage());
        }
        return resultado;
    }
    
     /**
     * Método que convierte una fecha a cadena
     * @param date Objeto de tipo date (fecha)
     * @return String Fecha convertida a cadena
     */ 
    public static String convertirDateToString(Date date) {
        String resultado = null;
        try {
            resultado = sdf.format(date);
        } catch (Exception e) {
            logger.error("EX* convertirDateToString : " + e.getMessage());
        }
        return resultado;
    }
    
    public static String obtenerTemplateFecha() {
        String resultado = null;
        try {
            Date fecha = new Date();
            resultado = formatFull.format(fecha);
                   
        } catch (Exception e) {
            logger.error("EX* obtenerFechaActualtoString : " + e.getMessage());
        }
        return resultado;
    }
//    
//    public static DateTime extraerFechaCambioClave(String date) {
//		String[] d = date.split("\\-");
//		
//		Integer year = Integer.parseInt(d[0].trim());
//		Integer month = Integer.parseInt(d[1].trim());
//		Integer day = Integer.parseInt(d[2].trim().substring(0, 2));
//		String[] hours = d[2].trim().split("\\:");
//		Integer hour = Integer.parseInt(hours[0].substring(3, 5));
//		Integer minute = Integer.parseInt(hours[1]);
//		Integer seconds = Integer.parseInt(hours[2].trim().substring(0, 2));
//		return new DateTime(year, month, day, hour, minute, seconds);
//	}
//    public static Map<String, Object> validarFechaExpiracion(String fechaExpiracion){
//		Map<String,  Object>  map=new HashMap<String,  Object>();
//		
//		DateTime fechaCambioClave=extraerFechaCambioClave(fechaExpiracion);
//		DateTime toDay=new DateTime();
//		int numeroDias=0;
//		int numeroHoras=0;
//		if(fechaCambioClave.toDateMidnight().equals(toDay.toDateMidnight())){
//			int hours=Hours.hoursBetween(toDay,fechaCambioClave).getHours();
//			numeroHoras=hours;
//			map.clear();
//			map.put("numeroDias", numeroDias);
//			map.put("numeroHoras", numeroHoras);
//			if(numeroHoras<=0){
//				map.put("mensaje", "Su cuenta ya caduco hace "+numeroHoras+" Horas");
//				map.put("caduco", true);
//			}else{
//				map.put("mensaje", "Faltan "+numeroHoras+" Horas para que caduque su cuenta");
//				map.put("caduco", false);
//			}
//		}else if(fechaCambioClave.toDateMidnight().isAfter(toDay.toDateMidnight())){
//			map.clear();
//			int dias=Days.daysBetween(toDay,fechaCambioClave).getDays();
//			if(dias==0){
//				Integer hours=Hours.hoursBetween(toDay,fechaCambioClave).getHours();
//				numeroHoras=hours;				
//				map.put("numeroDias", numeroDias);
//				map.put("numeroHoras", numeroHoras);
//				map.put("mensaje", "Faltan "+numeroHoras+" Horas para que caduque su cuenta");
//			}else{
//				numeroDias=dias;
//				map.put("numeroDias", numeroDias);
//				map.put("numeroHoras", numeroHoras);
//				map.put("mensaje", "Faltan "+numeroDias+" Dias para que caduque su cuenta");
//			}			
//			map.put("caduco", false);
//			
//		}else if(fechaCambioClave.toDateMidnight().isBefore(toDay.toDateMidnight())){
//			map.clear();			
//			int dias=Days.daysBetween(toDay,fechaCambioClave).getDays();
//			if(dias==0){
//				Integer hours=Hours.hoursBetween(toDay,fechaCambioClave).getHours();
//				numeroHoras=hours;				
//				map.put("numeroDias", numeroDias);
//				map.put("numeroHoras", numeroHoras);
//				map.put("mensaje", "Hace "+numeroHoras+" Horas ha caducado su cuenta");
//			}else{
//				numeroDias=dias;
//				map.put("numeroDias", numeroDias);
//				map.put("numeroHoras", numeroHoras);
//				map.put("mensaje", "Hace "+numeroDias+" Dias que ha caducado su cuenta");
//			}		
//			map.put("caduco", true);
//		}else{
//			map.clear();
//			map.put("numeroDias", numeroDias);
//			map.put("numeroHoras", numeroHoras);
//			map.put("mensaje", "");
//			map.put("caduco", false);
//		}
//			
//		return map;
//	}
    
     /**
     * Método que valida la fecha de expiración de la contraseña del usuario
     * @param fechaExpiracion Objeto de tipo date (fecha)
     * @return Map<String, Object> 
     */ 
    public static Map<String, Object> validarFechaExpiracion(String fechaExpiracion) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fechaCambioClave = getDateTimestampFromString(fechaExpiracion);
		Date toDay = StringToDate(dateFormat.format(new Date()), "-", 0);
		
		Calendar fc=Calendar.getInstance();
		fc.setTime(fechaCambioClave);			
		Calendar fhoy=Calendar.getInstance();
		fhoy.setTime(toDay);
		long numeroDias = 0;
		long numeroHoras = 0;
		if (equalsDate(fechaCambioClave, toDay)) {
			long hours = cantidadTotalHoras(fc, fhoy);
			numeroHoras = hours;
			map.clear();
			map.put("numeroDias", numeroDias);
			map.put("numeroHoras", numeroHoras);
			if (numeroHoras <= 0) {
				map.put("mensaje", "Su cuenta ya caduco hace " + numeroHoras+ " Horas");
				map.put("caduco", true);
			} else {
				map.put("mensaje", "Faltan " + numeroHoras + " Horas para que caduque su cuenta");
				map.put("caduco", false);
			}
		} else if (differenceBetweenDays(fc, fhoy)>0) {
			map.clear();
			long dias = differenceBetweenDays(fc, fhoy);
			if (dias == 0) {
				long hours = cantidadTotalHoras(fc, fhoy);
				numeroHoras = hours;
				map.put("numeroDias", numeroDias);
				map.put("numeroHoras", numeroHoras);
				map.put("mensaje", "Faltan " + numeroHoras
						+ " Horas para que caduque su cuenta");
			} else {
				numeroDias = dias;
				map.put("numeroDias", numeroDias);
				map.put("numeroHoras", numeroHoras);
				map.put("mensaje", "Faltan " + numeroDias
						+ " Dias para que caduque su cuenta");
			}
			map.put("caduco", false);

		} else if (differenceBetweenDays(fc, fhoy)<0) {
			map.clear();
			long dias = differenceBetweenDays(fc, fhoy);
			numeroDias = dias;
			map.put("numeroDias", numeroDias);
			map.put("numeroHoras", numeroHoras);
			map.put("mensaje", "Hace " + numeroDias
					+ " Dias que su cuenta ya caduco");
			map.put("caduco", true);
		} else {
			map.clear();
			map.put("numeroDias", numeroDias);
			map.put("numeroHoras", numeroHoras);
			map.put("mensaje", "");
			map.put("caduco", false);
		}

		return map;
	}

	public static Date getDateTimestampFromString(String date) {
		String[] d = date.split("\\-");
		Integer year = Integer.parseInt(d[0].trim());
		Integer month = Integer.parseInt(d[1].trim());
		month--;
		Integer day = Integer.parseInt(d[2].trim().substring(0, 2));
		String[] hours = d[2].trim().split("\\:");
		Integer hour = Integer.parseInt(hours[0].substring(3, 5));
		Integer minute = Integer.parseInt(hours[1]);
		Integer seconds = Integer.parseInt(hours[2].trim().substring(0, 2));

		return new GregorianCalendar(year, month, day, hour, minute, seconds)
				.getTime();
	}

	public static Date addTime(int time, int cantidad, Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);

		switch (time) {
		case Constantes.TIME_MEASURE_YEARS:
			gc.add(Calendar.YEAR, cantidad);
			break;
		case Constantes.TIME_MEASURE_MONTHS:
			gc.add(Calendar.MONTH, cantidad);
			break;
		case Constantes.TIME_MEASURE_WEEKS:
			gc.add(Calendar.DATE, (cantidad * 7));
			break;
		case Constantes.TIME_MEASURE_DAYS:
			gc.add(Calendar.DATE, cantidad);
			break; // days
		case Constantes.TIME_MEASURE_HOURS:
			gc.add(Calendar.HOUR, cantidad);
			break; // hours
		case Constantes.TIME_MEASURE_MINUTES:
			gc.add(Calendar.MINUTE, cantidad);
			break; // minutes
		case Constantes.TIME_MEASURE_SECONDS:
			gc.add(Calendar.SECOND, cantidad);
			break; // seconds
		}
		Date d2 = gc.getTime();
		return d2;
	}

     /**
     * Método que calcula la diferencia en dias entre dos fechas
     * @param startDate Fecha de inicio
     * @param endDate Fecha fin
     * @return long
     */
	public static long differenceBetweenDays(Calendar startDate,Calendar endDate) {
		Calendar date = (Calendar) startDate.clone();
		long daysBetween = 0;
		while (date.before(endDate)) {
			date.add(Calendar.DAY_OF_MONTH, 1);
			daysBetween++;
		}
		return daysBetween;
	}

     /**
     * Método que calcula la diferencia en horas entre dos fechas
     * @param fechaInicial Fecha de inicio
     * @param fechaFinal Fecha fin
     * @return long
     */
	public static long diferenciaHorasDias(Calendar fechaInicial,
			Calendar fechaFinal) {
		long diferenciaHoras = 0;
		diferenciaHoras = (fechaFinal.getTimeInMillis() - fechaInicial
				.getTimeInMillis()) / milisegundos_dia;
		if (diferenciaHoras > 0) {
			diferenciaHoras *= 24;
		}
		return diferenciaHoras;
	}

     /**
     * Método que calcula la diferencia en minutos entre dos fechas
     * @param fechaInicial Fecha de inicio
     * @param fechaFinal Fecha fin
     * @return long
     */
	public static long diferenciaMinutos(Calendar fechaInicial,
			Calendar fechaFinal) {
		long diferenciaHoras = 0;
		diferenciaHoras = (fechaFinal.get(Calendar.MINUTE) - fechaInicial
				.get(Calendar.MINUTE));
		return diferenciaHoras;
	}

	public static long cantidadTotalMinutos(Calendar fechaInicial,
			Calendar fechaFinal) {
		long totalMinutos = 0;
		totalMinutos = ((fechaFinal.getTimeInMillis() - fechaInicial
				.getTimeInMillis()) / 1000 / 60);
		return totalMinutos;
	}

     /**
     * Método que calcula la cantidad de horas entre dos fechas
     * @param fechaInicial Fecha de inicio
     * @param fechaFinal Fecha fin
     * @return long
     */
	public static long cantidadTotalHoras(Calendar fechaInicial,Calendar fechaFinal) {
		long totalMinutos = 0;
		totalMinutos = ((fechaFinal.getTimeInMillis() - fechaInicial.getTimeInMillis()) / 1000 / 60 / 60);
		return totalMinutos;
	}

      /**
     * Método que calcula la cantidad de segundos entre dos fechas
     * @param fechaInicial Fecha de inicio
     * @param fechaFinal Fecha fin
     * @return long
     */
	public static long cantidadTotalSegundos(Calendar fechaInicial,
			Calendar fechaFinal) {
		long totalMinutos = 0;
		totalMinutos = ((fechaFinal.getTimeInMillis() - fechaInicial
				.getTimeInMillis()) / 1000);
		return totalMinutos;
	}

	public static long diferenciaHoras(Calendar fechaInicial,
			Calendar fechaFinal) {
		long diferenciaHoras = 0;
		diferenciaHoras = (fechaFinal.get(Calendar.HOUR_OF_DAY) - fechaInicial
				.get(Calendar.HOUR_OF_DAY));
		return diferenciaHoras;
	}

      /**
     * Método que calcula la diferencia de días entre dos fechas
     * @param fechaMayor Fecha de inicio
     * @param fechaMenor Fecha fin
     * @return long
     */
	public static int diferenciaEnDias(Date fechaMayor,Date fechaMenor){
		String[] fechaMen=dateFormat.format(fechaMenor).split("\\-");
		String[] fechaMay=dateFormat.format(fechaMenor).split("\\-");
		Calendar c = Calendar.getInstance();		 
		Calendar fechaInicio = new GregorianCalendar();		 
		fechaInicio.set(Integer.valueOf(fechaMen[0].trim()), Integer.valueOf(fechaMen[1].trim()), Integer.valueOf(fechaMen[2].trim().substring(0, 2)));
		
		Calendar fechaFin = new GregorianCalendar();
		fechaFin.set(Integer.valueOf(fechaMay[0].trim()), Integer.valueOf(fechaMay[1].trim()), Integer.valueOf(fechaMay[2].trim().substring(0, 2)));
		c.setTimeInMillis(fechaFin.getTime().getTime() - fechaInicio.getTime().getTime());
		System.out.println("N. dias: " + c.get(Calendar.DAY_OF_YEAR));
		return 0;
	}

	public static String DateToString(Date fecha, String caracter, int op) {
		String formatoHora = " HH:mm:ss";

		String formato = "yyyy" + caracter + "MM" + caracter + "dd"
				+ formatoHora;
		if (op == 1)
			formato = "yyyy" + caracter + "dd" + caracter + "MM" + formatoHora;
		else if (op == 2)
			formato = "MM" + caracter + "yyyy" + caracter + "dd" + formatoHora;
		else if (op == 3)
			formato = "MM" + caracter + "dd" + caracter + "yyyy" + formatoHora;
		else if (op == 4)
			formato = "dd" + caracter + "yyyy" + caracter + "MM" + formatoHora;
		else if (op == 5)
			formato = "dd" + caracter + "MM" + caracter + "yyyy" + formatoHora;
		SimpleDateFormat sdf = new SimpleDateFormat(formato,
				Locale.getDefault());
		String fechaFormato = null;
		sdf.setLenient(false);
		fechaFormato = sdf.format(fecha);
		return fechaFormato;
	}

	public static Date StringToDate(String fecha, String caracter, int op) {
		String formatoHora = " HH:mm:ss";
		String formato = "yyyy" + caracter + "MM" + caracter + "dd"
				+ formatoHora;
		if (op == 1)
			formato = "yyyy" + caracter + "dd" + caracter + "MM" + formatoHora;
		else if (op == 2)
			formato = "MM" + caracter + "yyyy" + caracter + "dd" + formatoHora;
		else if (op == 3)
			formato = "MM" + caracter + "dd" + caracter + "yyyy" + formatoHora;
		else if (op == 4)
			formato = "dd" + caracter + "yyyy" + caracter + "MM" + formatoHora;
		else if (op == 5)
			formato = "dd" + caracter + "MM" + caracter + "yyyy" + formatoHora;
		SimpleDateFormat sdf = new SimpleDateFormat(formato,
				Locale.getDefault());
		Date fechaFormato = null;
		try {
			sdf.setLenient(false);
			fechaFormato = sdf.parse(fecha);
		} catch (ParseException ex) {
		}
		return fechaFormato;
	}
 
	public static boolean equalsDate(Date fm, Date hoy){
		String fmayor=dateFormatShort.format(fm);
		String fhoy=dateFormatShort.format(hoy);
		if(fmayor.equals(fhoy)){
			return true;
		}
		return false;
	}
	
}
