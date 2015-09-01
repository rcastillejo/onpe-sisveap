
package com.onpe.sisveap.proxyws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.onpe.sisveap.proxyws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListarVerificadorResponse_QNAME = new QName("http://comun.service.gepsac.sacooliveros.com/", "listarVerificadorResponse");
    private final static QName _ObtenerRegion_QNAME = new QName("http://comun.service.gepsac.sacooliveros.com/", "obtenerRegion");
    private final static QName _ObtenerRegionResponse_QNAME = new QName("http://comun.service.gepsac.sacooliveros.com/", "obtenerRegionResponse");
    private final static QName _ListarSupervisorResponse_QNAME = new QName("http://comun.service.gepsac.sacooliveros.com/", "listarSupervisorResponse");
    private final static QName _ServiceException_QNAME = new QName("http://comun.service.gepsac.sacooliveros.com/", "ServiceException");
    private final static QName _ListarVerificador_QNAME = new QName("http://comun.service.gepsac.sacooliveros.com/", "listarVerificador");
    private final static QName _ListarSupervisor_QNAME = new QName("http://comun.service.gepsac.sacooliveros.com/", "listarSupervisor");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.onpe.sisveap.proxyws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Persona }
     * 
     */
    public Persona createPersona() {
        return new Persona();
    }

    /**
     * Create an instance of {@link ListarSupervisorResponse }
     * 
     */
    public ListarSupervisorResponse createListarSupervisorResponse() {
        return new ListarSupervisorResponse();
    }

    /**
     * Create an instance of {@link Supervisor }
     * 
     */
    public Supervisor createSupervisor() {
        return new Supervisor();
    }

    /**
     * Create an instance of {@link Verificador }
     * 
     */
    public Verificador createVerificador() {
        return new Verificador();
    }

    /**
     * Create an instance of {@link ListarVerificadorResponse }
     * 
     */
    public ListarVerificadorResponse createListarVerificadorResponse() {
        return new ListarVerificadorResponse();
    }

    /**
     * Create an instance of {@link ObtenerRegionResponse }
     * 
     */
    public ObtenerRegionResponse createObtenerRegionResponse() {
        return new ObtenerRegionResponse();
    }

    /**
     * Create an instance of {@link ListarVerificador }
     * 
     */
    public ListarVerificador createListarVerificador() {
        return new ListarVerificador();
    }

    /**
     * Create an instance of {@link Estado }
     * 
     */
    public Estado createEstado() {
        return new Estado();
    }

    /**
     * Create an instance of {@link ListarSupervisor }
     * 
     */
    public ListarSupervisor createListarSupervisor() {
        return new ListarSupervisor();
    }

    /**
     * Create an instance of {@link ServiceException }
     * 
     */
    public ServiceException createServiceException() {
        return new ServiceException();
    }

    /**
     * Create an instance of {@link Region }
     * 
     */
    public Region createRegion() {
        return new Region();
    }

    /**
     * Create an instance of {@link ObtenerRegion }
     * 
     */
    public ObtenerRegion createObtenerRegion() {
        return new ObtenerRegion();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarVerificadorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comun.service.gepsac.sacooliveros.com/", name = "listarVerificadorResponse")
    public JAXBElement<ListarVerificadorResponse> createListarVerificadorResponse(ListarVerificadorResponse value) {
        return new JAXBElement<ListarVerificadorResponse>(_ListarVerificadorResponse_QNAME, ListarVerificadorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerRegion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comun.service.gepsac.sacooliveros.com/", name = "obtenerRegion")
    public JAXBElement<ObtenerRegion> createObtenerRegion(ObtenerRegion value) {
        return new JAXBElement<ObtenerRegion>(_ObtenerRegion_QNAME, ObtenerRegion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerRegionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comun.service.gepsac.sacooliveros.com/", name = "obtenerRegionResponse")
    public JAXBElement<ObtenerRegionResponse> createObtenerRegionResponse(ObtenerRegionResponse value) {
        return new JAXBElement<ObtenerRegionResponse>(_ObtenerRegionResponse_QNAME, ObtenerRegionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarSupervisorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comun.service.gepsac.sacooliveros.com/", name = "listarSupervisorResponse")
    public JAXBElement<ListarSupervisorResponse> createListarSupervisorResponse(ListarSupervisorResponse value) {
        return new JAXBElement<ListarSupervisorResponse>(_ListarSupervisorResponse_QNAME, ListarSupervisorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comun.service.gepsac.sacooliveros.com/", name = "ServiceException")
    public JAXBElement<ServiceException> createServiceException(ServiceException value) {
        return new JAXBElement<ServiceException>(_ServiceException_QNAME, ServiceException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarVerificador }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comun.service.gepsac.sacooliveros.com/", name = "listarVerificador")
    public JAXBElement<ListarVerificador> createListarVerificador(ListarVerificador value) {
        return new JAXBElement<ListarVerificador>(_ListarVerificador_QNAME, ListarVerificador.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarSupervisor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comun.service.gepsac.sacooliveros.com/", name = "listarSupervisor")
    public JAXBElement<ListarSupervisor> createListarSupervisor(ListarSupervisor value) {
        return new JAXBElement<ListarSupervisor>(_ListarSupervisor_QNAME, ListarSupervisor.class, null, value);
    }

}
