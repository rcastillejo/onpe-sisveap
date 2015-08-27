
package com.sacooliveros.sisveap.proxyws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for actividad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actividad">
 *   &lt;complexContent>
 *     &lt;extension base="{http://comun.service.gepsac.sacooliveros.com/}model">
 *       &lt;sequence>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="duracion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="frecuencia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sesiones" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipoFrecuencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actividad", propOrder = {
    "descripcion",
    "duracion",
    "frecuencia",
    "nombre",
    "sesiones",
    "tipoFrecuencia"
})
public class Actividad
    extends Model
{

    protected String descripcion;
    protected int duracion;
    protected int frecuencia;
    protected String nombre;
    protected int sesiones;
    protected String tipoFrecuencia;

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the duracion property.
     * 
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Sets the value of the duracion property.
     * 
     */
    public void setDuracion(int value) {
        this.duracion = value;
    }

    /**
     * Gets the value of the frecuencia property.
     * 
     */
    public int getFrecuencia() {
        return frecuencia;
    }

    /**
     * Sets the value of the frecuencia property.
     * 
     */
    public void setFrecuencia(int value) {
        this.frecuencia = value;
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
     * Gets the value of the sesiones property.
     * 
     */
    public int getSesiones() {
        return sesiones;
    }

    /**
     * Sets the value of the sesiones property.
     * 
     */
    public void setSesiones(int value) {
        this.sesiones = value;
    }

    /**
     * Gets the value of the tipoFrecuencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoFrecuencia() {
        return tipoFrecuencia;
    }

    /**
     * Sets the value of the tipoFrecuencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoFrecuencia(String value) {
        this.tipoFrecuencia = value;
    }

}
