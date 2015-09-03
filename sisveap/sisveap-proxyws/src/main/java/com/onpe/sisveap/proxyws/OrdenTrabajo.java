
package com.onpe.sisveap.proxyws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ordenTrabajo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ordenTrabajo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://distribucion.service.gepsac.sacooliveros.com/}model">
 *       &lt;sequence>
 *         &lt;element name="codigoArchivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecAsignado" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecIngreso" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="persona" type="{http://distribucion.service.gepsac.sacooliveros.com/}persona" minOccurs="0"/>
 *         &lt;element name="region" type="{http://distribucion.service.gepsac.sacooliveros.com/}region" minOccurs="0"/>
 *         &lt;element name="supervisor" type="{http://distribucion.service.gepsac.sacooliveros.com/}supervisor" minOccurs="0"/>
 *         &lt;element name="verificador" type="{http://distribucion.service.gepsac.sacooliveros.com/}verificador" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ordenTrabajo", propOrder = {
    "codigoArchivo",
    "fecAsignado",
    "fecIngreso",
    "persona",
    "region",
    "supervisor",
    "verificador"
})
public class OrdenTrabajo
    extends Model
{

    protected String codigoArchivo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecAsignado;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecIngreso;
    protected Persona persona;
    protected Region region;
    protected Supervisor supervisor;
    protected Verificador verificador;

    /**
     * Gets the value of the codigoArchivo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoArchivo() {
        return codigoArchivo;
    }

    /**
     * Sets the value of the codigoArchivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoArchivo(String value) {
        this.codigoArchivo = value;
    }

    /**
     * Gets the value of the fecAsignado property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecAsignado() {
        return fecAsignado;
    }

    /**
     * Sets the value of the fecAsignado property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecAsignado(XMLGregorianCalendar value) {
        this.fecAsignado = value;
    }

    /**
     * Gets the value of the fecIngreso property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecIngreso() {
        return fecIngreso;
    }

    /**
     * Sets the value of the fecIngreso property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecIngreso(XMLGregorianCalendar value) {
        this.fecIngreso = value;
    }

    /**
     * Gets the value of the persona property.
     * 
     * @return
     *     possible object is
     *     {@link Persona }
     *     
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Sets the value of the persona property.
     * 
     * @param value
     *     allowed object is
     *     {@link Persona }
     *     
     */
    public void setPersona(Persona value) {
        this.persona = value;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link Region }
     *     
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link Region }
     *     
     */
    public void setRegion(Region value) {
        this.region = value;
    }

    /**
     * Gets the value of the supervisor property.
     * 
     * @return
     *     possible object is
     *     {@link Supervisor }
     *     
     */
    public Supervisor getSupervisor() {
        return supervisor;
    }

    /**
     * Sets the value of the supervisor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Supervisor }
     *     
     */
    public void setSupervisor(Supervisor value) {
        this.supervisor = value;
    }

    /**
     * Gets the value of the verificador property.
     * 
     * @return
     *     possible object is
     *     {@link Verificador }
     *     
     */
    public Verificador getVerificador() {
        return verificador;
    }

    /**
     * Sets the value of the verificador property.
     * 
     * @param value
     *     allowed object is
     *     {@link Verificador }
     *     
     */
    public void setVerificador(Verificador value) {
        this.verificador = value;
    }

}
