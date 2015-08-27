
package com.sacooliveros.gepsac.proxyws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for plan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="plan">
 *   &lt;complexContent>
 *     &lt;extension base="{http://planificacion.service.gepsac.sacooliveros.com/}model">
 *       &lt;sequence>
 *         &lt;element name="anio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estrategiasSeleccionadas" type="{http://planificacion.service.gepsac.sacooliveros.com/}planEstrategia" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fecConfiguracion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecFin" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecInicio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecProgramacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="hitos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="restriccionFechas" type="{http://planificacion.service.gepsac.sacooliveros.com/}restriccionFecha" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "plan", propOrder = {
    "anio",
    "estrategiasSeleccionadas",
    "fecConfiguracion",
    "fecFin",
    "fecInicio",
    "fecProgramacion",
    "fecRegistro",
    "hitos",
    "restriccionFechas",
    "titulo"
})
public class Plan
    extends Model
{

    protected int anio;
    @XmlElement(nillable = true)
    protected List<PlanEstrategia> estrategiasSeleccionadas;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecConfiguracion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecFin;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecInicio;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecProgramacion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecRegistro;
    protected String hitos;
    @XmlElement(nillable = true)
    protected List<RestriccionFecha> restriccionFechas;
    protected String titulo;

    /**
     * Gets the value of the anio property.
     * 
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Sets the value of the anio property.
     * 
     */
    public void setAnio(int value) {
        this.anio = value;
    }

    /**
     * Gets the value of the estrategiasSeleccionadas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the estrategiasSeleccionadas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEstrategiasSeleccionadas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PlanEstrategia }
     * 
     * 
     */
    public List<PlanEstrategia> getEstrategiasSeleccionadas() {
        if (estrategiasSeleccionadas == null) {
            estrategiasSeleccionadas = new ArrayList<PlanEstrategia>();
        }
        return this.estrategiasSeleccionadas;
    }

    /**
     * Gets the value of the fecConfiguracion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecConfiguracion() {
        return fecConfiguracion;
    }

    /**
     * Sets the value of the fecConfiguracion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecConfiguracion(XMLGregorianCalendar value) {
        this.fecConfiguracion = value;
    }

    /**
     * Gets the value of the fecFin property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecFin() {
        return fecFin;
    }

    /**
     * Sets the value of the fecFin property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecFin(XMLGregorianCalendar value) {
        this.fecFin = value;
    }

    /**
     * Gets the value of the fecInicio property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecInicio() {
        return fecInicio;
    }

    /**
     * Sets the value of the fecInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecInicio(XMLGregorianCalendar value) {
        this.fecInicio = value;
    }

    /**
     * Gets the value of the fecProgramacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecProgramacion() {
        return fecProgramacion;
    }

    /**
     * Sets the value of the fecProgramacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecProgramacion(XMLGregorianCalendar value) {
        this.fecProgramacion = value;
    }

    /**
     * Gets the value of the fecRegistro property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecRegistro() {
        return fecRegistro;
    }

    /**
     * Sets the value of the fecRegistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecRegistro(XMLGregorianCalendar value) {
        this.fecRegistro = value;
    }

    /**
     * Gets the value of the hitos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHitos() {
        return hitos;
    }

    /**
     * Sets the value of the hitos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHitos(String value) {
        this.hitos = value;
    }

    /**
     * Gets the value of the restriccionFechas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the restriccionFechas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRestriccionFechas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RestriccionFecha }
     * 
     * 
     */
    public List<RestriccionFecha> getRestriccionFechas() {
        if (restriccionFechas == null) {
            restriccionFechas = new ArrayList<RestriccionFecha>();
        }
        return this.restriccionFechas;
    }

    /**
     * Gets the value of the titulo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets the value of the titulo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

}
