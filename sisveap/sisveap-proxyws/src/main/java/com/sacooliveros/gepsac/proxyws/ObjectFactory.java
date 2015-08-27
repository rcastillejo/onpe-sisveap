
package com.sacooliveros.gepsac.proxyws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sacooliveros.gepsac.proxyws package. 
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

    private final static QName _ListarEstrategia_QNAME = new QName("http://comun.service.gepsac.sacooliveros.com/", "listarEstrategia");
    private final static QName _ListarEstrategiaActividadResponse_QNAME = new QName("http://comun.service.gepsac.sacooliveros.com/", "listarEstrategiaActividadResponse");
    private final static QName _ListarEstrategiaResponse_QNAME = new QName("http://comun.service.gepsac.sacooliveros.com/", "listarEstrategiaResponse");
    private final static QName _ListarEstrategiaActividad_QNAME = new QName("http://comun.service.gepsac.sacooliveros.com/", "listarEstrategiaActividad");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sacooliveros.gepsac.proxyws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Estrategia }
     * 
     */
    public Estrategia createEstrategia() {
        return new Estrategia();
    }

    /**
     * Create an instance of {@link Estado }
     * 
     */
    public Estado createEstado() {
        return new Estado();
    }

    /**
     * Create an instance of {@link ListarEstrategiaActividad }
     * 
     */
    public ListarEstrategiaActividad createListarEstrategiaActividad() {
        return new ListarEstrategiaActividad();
    }

    /**
     * Create an instance of {@link Actividad }
     * 
     */
    public Actividad createActividad() {
        return new Actividad();
    }

    /**
     * Create an instance of {@link Indicador }
     * 
     */
    public Indicador createIndicador() {
        return new Indicador();
    }

    /**
     * Create an instance of {@link ListarEstrategiaActividadResponse }
     * 
     */
    public ListarEstrategiaActividadResponse createListarEstrategiaActividadResponse() {
        return new ListarEstrategiaActividadResponse();
    }

    /**
     * Create an instance of {@link ListarEstrategia }
     * 
     */
    public ListarEstrategia createListarEstrategia() {
        return new ListarEstrategia();
    }

    /**
     * Create an instance of {@link Model }
     * 
     */
    public Model createModel() {
        return new Model();
    }

    /**
     * Create an instance of {@link ListarEstrategiaResponse }
     * 
     */
    public ListarEstrategiaResponse createListarEstrategiaResponse() {
        return new ListarEstrategiaResponse();
    }

    /**
     * Create an instance of {@link EstrategiaActividad }
     * 
     */
    public EstrategiaActividad createEstrategiaActividad() {
        return new EstrategiaActividad();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarEstrategia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comun.service.gepsac.sacooliveros.com/", name = "listarEstrategia")
    public JAXBElement<ListarEstrategia> createListarEstrategia(ListarEstrategia value) {
        return new JAXBElement<ListarEstrategia>(_ListarEstrategia_QNAME, ListarEstrategia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarEstrategiaActividadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comun.service.gepsac.sacooliveros.com/", name = "listarEstrategiaActividadResponse")
    public JAXBElement<ListarEstrategiaActividadResponse> createListarEstrategiaActividadResponse(ListarEstrategiaActividadResponse value) {
        return new JAXBElement<ListarEstrategiaActividadResponse>(_ListarEstrategiaActividadResponse_QNAME, ListarEstrategiaActividadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarEstrategiaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comun.service.gepsac.sacooliveros.com/", name = "listarEstrategiaResponse")
    public JAXBElement<ListarEstrategiaResponse> createListarEstrategiaResponse(ListarEstrategiaResponse value) {
        return new JAXBElement<ListarEstrategiaResponse>(_ListarEstrategiaResponse_QNAME, ListarEstrategiaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarEstrategiaActividad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comun.service.gepsac.sacooliveros.com/", name = "listarEstrategiaActividad")
    public JAXBElement<ListarEstrategiaActividad> createListarEstrategiaActividad(ListarEstrategiaActividad value) {
        return new JAXBElement<ListarEstrategiaActividad>(_ListarEstrategiaActividad_QNAME, ListarEstrategiaActividad.class, null, value);
    }

}
