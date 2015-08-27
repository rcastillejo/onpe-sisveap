package com.novatronic.sca.util;

import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {

    private static final Logger logger = Logger.getLogger(PropertiesUtil.class);

    public static void main(String[] args) {
    	
    	PropertiesUtil util=new  PropertiesUtil();
    	System.out.println(util.getMessageFromResource("login.formulario.clave.actual",Constantes.LOGIN_RESOURCE));
    	
	}
    public Properties getConfiguration() {
        Properties props = new Properties();
        try {
            props.load(getClass().getResourceAsStream(Constantes.PROPERTIES_EMAIL));

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return props;
    }
    public   String getMessageFromResource(String code,String resource) {
        Properties props = new Properties();
        String msg="";
        
        try {
            props.load(getClass().getResourceAsStream(resource));
            msg=(String) props.get(code);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return msg;
    }
}
