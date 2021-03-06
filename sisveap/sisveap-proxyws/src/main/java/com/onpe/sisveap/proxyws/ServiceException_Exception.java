
package com.onpe.sisveap.proxyws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "ServiceException", targetNamespace = "http://comun.service.gepsac.sacooliveros.com/")
public class ServiceException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ServiceException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ServiceException_Exception(String message, ServiceException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ServiceException_Exception(String message, ServiceException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.onpe.sisveap.proxyws.ServiceException
     */
    public ServiceException getFaultInfo() {
        return faultInfo;
    }

}
