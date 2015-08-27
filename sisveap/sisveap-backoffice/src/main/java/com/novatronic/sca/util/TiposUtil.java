package com.novatronic.sca.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;




public class TiposUtil {

	
	public static boolean validarLista(List<?> lista) {
		boolean isValid = false;
        if(lista != null && lista.size()>0){
        	isValid = true;
        } 
        return isValid;
    }
	
    public static Integer obtenerValorNumerico(Boolean valor) {
        return valor != false ? 1 : 0;
    }

    public static String obtenerValorDia(boolean valor) {
        return valor ? "1" : "0";
    }

    public static String formatoSimpleFecha(Object objeto, String formato) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        if (objeto != null && !objeto.toString().equals("")) {
            Date fecha = (Date) objeto;
            return sdf.format(fecha.getTime());
        }
        return Constantes.STRING_DEFAULT;
    }

    public static String verificarSeleccion(String cadena) {

        if (cadena != null && !cadena.equals(Constantes.NO_SELECCIONADO)) {
            return cadena;
        } else {
            return Constantes.STRING_DEFAULT;
        }
    }

    public static String verificarTexto(String cadena) {

        if (cadena != null && !cadena.equals(Constantes.STRING_DEFAULT)) {
            return cadena;
        } else {
            return Constantes.STRING_DEFAULT;
        }
    }
        
    public static String validarTexto(String cadena) {
    	if (cadena != null && !cadena.equals(Constantes.STRING_DEFAULT)) {
    		if(cadena.trim().length()>0){
    			return cadena.trim();
    					
    		}else{
    			return Constantes.STRING_DEFAULT;
    		}
    	} else {
            return Constantes.STRING_DEFAULT;
        }
    }

    public static Long parsearStringALong(String cadena) {
        if (cadena != null && !cadena.equals("")) {
            return Long.parseLong(cadena);
        }

        return null;
    }

    public static boolean isValidString(String name) {
        if (name.trim().length() > 0 && name.length() <= 60) {
            if (name.matches(Constantes.ALPHANUMERIC_PATTERN)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean isValidPhone(String phone, Boolean isRequired) {
        if (!isRequired && Constantes.EMPTY.equals(phone.trim())) {
            return true;
        }
        if (phone.matches(Constantes.PHONE_PATTERN)) {
            return true;
        }
        return false;
    }

    public static boolean isValidEmail(String email, Boolean isRequired) {
        if (!isRequired && Constantes.EMPTY.equals(email.trim())) {
            return true;
        }
        if (!(email.trim().length() > 0 && email.length() <= 60)) {
            return false;
        }
        if (!email.trim().contains(" ") && email.matches(Constantes.EMAIL_PATTERN)) {
            return true;
        }
        return false;
    }

    public static Boolean existeAtributoPolitica(String atributo, String valor) {
        if (atributo != null && atributo.equals(valor)) {
            return true;
        }
        return false;
    }
    //20131117155404_2.txt_PERMISO_MDP.txt

    public static String obtenerNombreFile(String name) {
        if (name.lastIndexOf(".") >= 0) {
            return name.substring(0, name.lastIndexOf("."));
        } else {
            return Constantes.STRING_DEFAULT;

        }
    }

    public static boolean verificarMnemonico(String cadena) {
    	if (cadena != null && !cadena.equals(Constantes.STRING_DEFAULT)) {
    		String [] value=cadena.split(" ");
    		if(value.length>1){
    			return false;
    		}
    		return true;
    	} else {
            return false;
        }
    }
}
