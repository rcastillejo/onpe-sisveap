
package com.sacooliveros.gepsac.proxyws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for planIndicador complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="planIndicador">
 *   &lt;complexContent>
 *     &lt;extension base="{http://planificacion.service.gepsac.sacooliveros.com/}indicador">
 *       &lt;sequence>
 *         &lt;element name="codigoActividad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoEstrategia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoPlan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "planIndicador", propOrder = {
    "codigoActividad",
    "codigoEstrategia",
    "codigoPlan",
    "meta"
})
public class PlanIndicador
    extends Indicador
{

    protected String codigoActividad;
    protected String codigoEstrategia;
    protected String codigoPlan;
    protected int meta;

    /**
     * Gets the value of the codigoActividad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoActividad() {
        return codigoActividad;
    }

    /**
     * Sets the value of the codigoActividad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoActividad(String value) {
        this.codigoActividad = value;
    }

    /**
     * Gets the value of the codigoEstrategia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoEstrategia() {
        return codigoEstrategia;
    }

    /**
     * Sets the value of the codigoEstrategia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoEstrategia(String value) {
        this.codigoEstrategia = value;
    }

    /**
     * Gets the value of the codigoPlan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPlan() {
        return codigoPlan;
    }

    /**
     * Sets the value of the codigoPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPlan(String value) {
        this.codigoPlan = value;
    }

    /**
     * Gets the value of the meta property.
     * 
     */
    public int getMeta() {
        return meta;
    }

    /**
     * Sets the value of the meta property.
     * 
     */
    public void setMeta(int value) {
        this.meta = value;
    }

}
