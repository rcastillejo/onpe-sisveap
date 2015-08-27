/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.sca.util;

/**
 *
 * @author Marco
 */
public class Constantes {

    public static final String OPCION_BLOQUEO = "bloqueo";
    public static final String OPCION_DESBLOQUEO = "desbloqueo";
    public static final String OPCION_TEMPLATE = "template";
    public static final String OPCION_POLITICA = "politica";
    public static final String OPCION_AUDITORIA = "auditoria";
    public static final String OPCION_USUARIO = "usuario";
    public static final String OPCION_EMPRESA = "empresa";
    public static final String OPCION_APLICACION = "aplicacion";
    public static final String OPCION_ROL = "rol";
    public static final String OPCION_HORARIO = "horario";
    public static final String OPCION_VOLVER_A_LOGIN = "volverALogin";
    public static final String OPCION_LOGIN_OLVIDE_CLAVE = "olvideClave";
    public static final String OPCION_LOGIN_CAMBIO_CLAVE = "cambioClave";
    public static final String OPCION_INDEX = "inicioSistema";
    public static final String OPCION_LOGIN_CAMBIO_PRIMERA_CLAVE = "cambioPrimeraClave";
    public static final String OPCION_ERROR_SERVIDOR_CORREO = "errorServidorCorreo";
    public static final String OPCION_PERMISO = "permiso";
    public static final String OPCION_IMPORTAR = "importar";

    public static final String EMPTY = "";

    public static final String CODIGO_RESPUESTA_OK = "0000";
    public static final String CODIGO_RESPUESTA_1001 = "1001";
    public static final String CODIGO_RESPUESTA_1002 = "1002";
    public static final String CODIGO_RESPUESTA_1003 = "1003";
    public static final String CODIGO_RESPUESTA_1004 = "1004";
    public static final String CODIGO_RESPUESTA_1005 = "1005";
    public static final String CODIGO_RESPUESTA_1006 = "1006";
    public static final String CODIGO_RESPUESTA_1007 = "1007";
    public static final String CODIGO_RESPUESTA_1008 = "1008";
    public static final String CODIGO_RESPUESTA_1009 = "1009";
    public static final String CODIGO_RESPUESTA_1011 = "1011";
    public static final String CODIGO_RESPUESTA_1013 = "1013";
    public static final String CODIGO_RESPUESTA_1014 = "1014";
    public static final String CODIGO_RESPUESTA_1015 = "1015";
    public static final String CODIGO_RESPUESTA_1016 = "1016";
    public static final String CODIGO_RESPUESTA_1018 = "1018";
    public static final String CODIGO_RESPUESTA_1111 = "1111";
    public static final String CODIGO_RESPUESTA_9999 = "9999";
    public static final String CODIGO_MENSAJE_2000 = "2000";
    public static final String CODIGO_MENSAJE_2001 = "2001";
    public static final String CODIGO_MENSAJE_2002 = "2002";
    public static final String CODIGO_MENSAJE_2003 = "2003";
    public static final String CODIGO_MENSAJE_2004 = "2004";
    public static final String CODIGO_MENSAJE_2005 = "2005";
    public static final String CODIGO_MENSAJE_2006 = "2006";
    public static final String CODIGO_MENSAJE_2007 = "2007";
    public static final String CODIGO_MENSAJE_2008 = "2008";
    public static final String CODIGO_MENSAJE_2009 = "2009";
    public static final String CODIGO_MENSAJE_2010 = "2010";
    public static final String CODIGO_MENSAJE_2011 = "2011";
    public static final String CODIGO_MENSAJE_2012 = "2012";
    public static final String CODIGO_MENSAJE_2013 = "2013";
    public static final String CODIGO_MENSAJE_2014 = "2014";
    public static final String CODIGO_MENSAJE_2015 = "2015";
    public static final String CODIGO_MENSAJE_2019 = "2019";
    public static final String CODIGO_MENSAJE_2020 = "2020";
    public static final String CODIGO_MENSAJE_2021 = "2021";
    public static final String CODIGO_MENSAJE_2022 = "2022";

    // ACTION UTIL
    public static final String CONTENT_TYPE = "text/json;charset=utf-8";
    public static final String CONTENT_TYPE_TEXT = "text/html; charset=utf-8";
    public static final String CONTENT_TYPE_XML = "application/xml";
    public static final String HEADER_PRO_CACHE = "cache-control";
    public static final String HEADER_CACHE = "no-cache";
    
    // CODE
    public static final String CODE_REPEAT = "10";
    public static final String CODE_INTEGRIDAD = "30";
    public static final int CODE_OK = 200;
    public static final String SIZE_ERROR = "300";
    public static final int CODE_FAILED = 500;
    public static final int CODE_FAILED_DELETE = 100;
    public static final String TODOS = "TODOS";
    public static final String BUSQUEDA_DEFAULT = "-1";
    public static final Long BUSQUEDA_DEFAULT_LON = -1L;
    
    // PROCEDIMIENTOS PARA LOS ADAPTER
    public static final String CERO = "0";

    // PROCEDIMIENTOS PARA LOS ADAPTER
    public static final String SP_EMPRESAS_ADAPTER = "PKG_SCA.SPS_CONSULTAR_EMPRESA_DATA";
    public static final String SP_APLI_ADAPTER = "PKG_SCA.SPS_CONSULTAR_APLICACION_DATA";
    public static final String SP_PERMISO_ADAPTER = "PKG_SCA.SPS_CONSULTAR_PERMISO_DATA";
    public static final String SP_USUARIO_ADAPTER = "PKG_SCA.SPS_CONSULTAR_USUARIO_ADAPTER";
    public static final String SP_ROL_ADAPTER = "PKG_SCA.SPS_CONSULTAR_ROL_DATA";
    public static final String SP_EMPRESAS_ADAPTER_POSTGRES = "sps_consultar_empresa_data";
    public static final String SP_APLI_ADAPTER_POSTGRES = "sps_consultar_aplicacion_data";
    public static final String SP_PERMISO_ADAPTER_POSTGRES = "sps_consultar_permiso_data";
    public static final String SP_USUARIO_ADAPTER_POSTGRES = "sps_consultar_usuario_adapter";
    public static final String SP_ROL_ADAPTER_POSTGRES = "sps_consultar_rol_data";
    public static final Integer USUARIO_LOGIN_ID_DEFAULT = -1;
    public static final String NO_SELECCIONADO = "-1";
    public static final String STRING_DEFAULT = "";
    public static final String COMA = ",";
    public static final String TITULO_MENSAJE_OLVIDE_CLAVE = "Novatronic- Clave Temporal";
    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String PHONE_PATTERN = "\\d{10}?";
    public static final String ALPHANUMERIC_PATTERN = "[A-Za-z0-9 \\.\\$\\,\\-\\'\\/\\_&@#]+";
    public static final String NUMERIC_PATTERN = "[0-9]+";
    public static final String ALPHABETHIC_PATTERN = "[A-Za-z]+";
    public static final String NAME_PARAMETER_TEMPLATE_MAP = "nameTemplate";
    public static final String TEMPLATE_OLVIDE_CLAVE = "olvide-clave.vm";
    public static final String TEMPLATE_NUEVO_USUARIO = "usuario-nuevo.vm";
    public static final String TEMPLATE_RESETEO_USUARIO = "reseteo-clave.vm";
    public static final String ASUNTO_CAMBIO_CLAVE = "Cambio de Contraseña";
    public static final String ASUNTO_NUEVO_USUARIO = "Novatronic - Usuario";
    public static final String ASUNTO_RESETEO_USUARIO = "Novatronic - Reseteo";
    public static final String USUARIO_SESSION = "usuario";
    public static final String USUARIO_ADMIN = "admin";
    
    // MENSAJE DE ERROR
    public static final String MENSAJE_ERROR = "Ha ocurrido un error";
    public static final String PATH_REDIRECT = "/pages/login/Login.jsp";
    
    // FORMATO TIPO DATE
    public static final String FORMATO_HORA = "HH:mm";
    public static final String ACTIVO = "1";
    public static final String INACTIVO = "0";
    public static final String NOMBRE_ARCHIVO_AUDITORIA_XLS = "Reporte-Movimientos-Usuario.xlsx";
    public static final String NOMBRE_PLANTILLA_XLS = "template-auditoria.xlsx";
    public static final String NOMBRE_PLANTILLA_XLS_NO = "template-auditoria_no.xlsx";
    public static final String PARAMETRO_PLANTILLA_XLS = "reporte";
    public static final int BYTES_DOWNLOAD = 2048;
    public static final String NOMBRE_ARCHIVO_SALIDA = "auditoria-reporte.xls";
    public static final String EXTENSION_XLS = ".xls";
    public static final String EXTENSION_PDF = ".pdf";
    public static final String EXTENSION_TXT = ".txt";
    public static final String REPORT_AUDITORIA_XLS = "Reporte_Movimientos_Usuario.xls";
    public static final String REPORT_AUDITORIA_PDF = "Reporte_Movimientos_Usuario.pdf";
    public static final Integer NO_SELECCIONADO_INT = -1;
    
    //CONSTANTES PARA POLITICAS POR EMPRESA
    public static final String ATR_HOUR = "HOUR";
    public static final String ATR_MINUTE = "MINUTE";
    public static final String ATR_MIN_LENGTH = "MIN_LENGTH";
    public static final String ATR_MAX_LENGTH = "MAX_LENGTH";
    public static final String ATR_MAX_FAILED_ATTEMPTS = "MAX_FAILED_ATTEMPTS";
    public static final String ATR_YEARS = "YEARS";
    public static final String ATR_MONTHS = "MONTHS";
    public static final String ATR_DAYS = "DAYS";
    public static final String ATR_CRITERION = "CRITERION";
    public static final String ATR_BACKTRACE = "BACKTRACE";
    public static final String ATR_DAY_NOTIFIED = "DAY_NOTIFIED";
    public static final String ATR_MAX_MINUTE = "MAX_MINUTE";
    public static final String ATR_MAX_USER_LENGTH = "MAX_USER_LENGTH";
    public static final String ATR_MIN_USER_LENGTH = "MIN_USER_LENGTH";
    public static final Integer TIPO_PAQUETE_POLITICA = 2;
    public static final String FORMATO_FECHA = "dd/MM/yyyy HH:mm:ss aa";
    
    //MENSAJES ENVIAR A PROPERTIES POSTERIORMENTE
    public static final String NO_SUCH_OPTION = "No existe la opcion";
    public static final String PATH_FILE_UPLOAD_PERMISOS = "D:/reporte/";
    
    //CONSTANTES PARA POLITICAS POR HORARIO   
    public static final String VALOR_DEFECTO_DIA = "1";
    public static final String VALOR_ALT_DIA = "0";
    public static final String VALOR_DEFECTO_HORA_INICIO = "0";
    public static final String VALOR_DEFECTO_HORA_FIN = "23";
    public static final String VALOR_DEFECTO_HORA = "1";
    public static final String VALOR_ALT_HORA = "0";
    public static final String TIPO_APLICACION = "0";
    public static final String TIPO_USUARIO = "1";
    public static final boolean BVALOR_DIA = true;
    public static final boolean BVALOR_HORA = true;
    
    //CONSTANTES PARA POLITICAS   
    public static final String TIPO_CONSULTA_APLICACION = "1";
    public static final String TIPO_CONSULTA_EMPRESA = "2";
    public static final String COMPLEJIDAD_ENTROPY = "1";
    public static final String COMPLEJIDAD_EQUALS = "2";
    public static final String COMPLEJIDAD_SEQUENCE = "3";
    public static final String PERMISOS_POR_USUARIO_SESSION = "permisos";
    public static final String PERMISOS_GLOBAL_SESSION = "permisosTotal";
    public static final String ROLES_POR_USUARIO_SESSION = "roles";
    
    //Properties Email 
    public static final String PROPERTIES_EMAIL = "/com/novatronic/sca/email.properties";
    
    //PATH RESOURCE
    public static final String PATH_RESOURCE = "/com/novatronic/sca/";
    public static final String LOGIN_RESOURCE = PATH_RESOURCE + "LoginResource.properties";

    //TAB
    public static final String TAB_EMPRESA = "0";
    public static final String TAB_APLICACION = "1";
    public static final String EMPRESA_NO_EXIST_APP = "-10";

    public static final int TIME_MEASURE_YEARS = 1;
    public static final int TIME_MEASURE_MONTHS = 3;
    public static final int TIME_MEASURE_WEEKS = 2;
    public static final int TIME_MEASURE_DAYS = 4;
    public static final int TIME_MEASURE_HOURS = 5;
    public static final int TIME_MEASURE_MINUTES = 6;
    public static final int TIME_MEASURE_SECONDS = 7;

    public static final int MIN_NUM_COLUMNAS_IMPORT_PERMISO = 3;
    public static final int MAX_NUM_COLUMNAS_IMPORT_PERMISO = 4;

    public static final String POLITICA_EMPRESA_001 = "unLockedAutomatic_HOUR";
    public static final String POLITICA_EMPRESA_002 = "unLockedAutomatic_MINUTE";
    public static final String POLITICA_EMPRESA_003 = "passwordLength_MIN_LENGTH";
    public static final String POLITICA_EMPRESA_004 = "passwordLength_MAX_LENGTH";
    public static final String POLITICA_EMPRESA_005 = "maxFailedLoginAttempts_MAX_FAILED_ATTEMPTS";
    public static final String POLITICA_EMPRESA_006 = "passwordExpired_YEARS";
    public static final String POLITICA_EMPRESA_007 = "passwordExpired_MONTHS";
    public static final String POLITICA_EMPRESA_008 = "passwordExpired_DAYS";
    public static final String POLITICA_EMPRESA_009 = "passwordStrength_CRITERION";
    public static final String POLITICA_EMPRESA_010 = "oldPassword_BACKTRACE";
    public static final String POLITICA_EMPRESA_011 = "passwordExpiredNotified_DAY_NOTIFIED";
    public static final String POLITICA_EMPRESA_012 = "timeOutApp_MAX_MINUTE";
    public static final String POLITICA_EMPRESA_013 = "userLength_MAX_USER_LENGTH";
    public static final String POLITICA_EMPRESA_014 = "userLength_MIN_USER_LENGTH";

}
