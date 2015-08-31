
package com.onpe.sisveap.proxyws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for archivoOT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="archivoOT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://distribucion.service.gepsac.sacooliveros.com/}model">
 *       &lt;sequence>
 *         &lt;element name="cantRegistro" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fecAsignacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ordenes" type="{http://distribucion.service.gepsac.sacooliveros.com/}ordenTrabajo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ruta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "archivoOT", propOrder = {
    "cantRegistro",
    "fecAsignacion",
    "fecRegistro",
    "nombre",
    "ordenes",
    "ruta"
})
public class ArchivoOT
    extends Model
{

    protected int cantRegistro;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecAsignacion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecRegistro;
    protected String nombre;
    @XmlElement(nillable = true)
    protected List<OrdenTrabajo> ordenes;
    protected String ruta;

    /**
     * Gets the value of the cantRegistro property.
     * 
     */
    public int getCantRegistro() {
        return cantRegistro;
    }

    /**
     * Sets the value of the cantRegistro property.
     * 
     */
    public void setCantRegistro(int value) {
        this.cantRegistro = value;
    }

    /**
     * Gets the value of the fecAsignacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecAsignacion() {
        return fecAsignacion;
    }

    /**
     * Sets the value of the fecAsignacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecAsignacion(XMLGregorianCalendar value) {
        this.fecAsignacion = value;
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
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the ordenes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ordenes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrdenes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrdenTrabajo }
     * 
     * 
     */
    public List<OrdenTrabajo> getOrdenes() {
        if (ordenes == null) {
            ordenes = new ArrayList<OrdenTrabajo>();
        }
        return this.ordenes;
    }

    /**
     * Gets the value of the ruta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Sets the value of the ruta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuta(String value) {
        this.ruta = value;
    }

}
