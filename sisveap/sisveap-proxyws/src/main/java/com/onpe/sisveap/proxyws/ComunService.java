
package com.onpe.sisveap.proxyws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ComunService", targetNamespace = "http://comun.service.gepsac.sacooliveros.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ComunService {


    /**
     * 
     * @param arg0
     * @return
     *     returns com.onpe.sisveap.proxyws.Region
     * @throws ServiceException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerRegion", targetNamespace = "http://comun.service.gepsac.sacooliveros.com/", className = "com.onpe.sisveap.proxyws.ObtenerRegion")
    @ResponseWrapper(localName = "obtenerRegionResponse", targetNamespace = "http://comun.service.gepsac.sacooliveros.com/", className = "com.onpe.sisveap.proxyws.ObtenerRegionResponse")
    public Region obtenerRegion(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws ServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.onpe.sisveap.proxyws.Verificador>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarVerificador", targetNamespace = "http://comun.service.gepsac.sacooliveros.com/", className = "com.onpe.sisveap.proxyws.ListarVerificador")
    @ResponseWrapper(localName = "listarVerificadorResponse", targetNamespace = "http://comun.service.gepsac.sacooliveros.com/", className = "com.onpe.sisveap.proxyws.ListarVerificadorResponse")
    public List<Verificador> listarVerificador(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.onpe.sisveap.proxyws.Supervisor>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarSupervisor", targetNamespace = "http://comun.service.gepsac.sacooliveros.com/", className = "com.onpe.sisveap.proxyws.ListarSupervisor")
    @ResponseWrapper(localName = "listarSupervisorResponse", targetNamespace = "http://comun.service.gepsac.sacooliveros.com/", className = "com.onpe.sisveap.proxyws.ListarSupervisorResponse")
    public List<Supervisor> listarSupervisor(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
