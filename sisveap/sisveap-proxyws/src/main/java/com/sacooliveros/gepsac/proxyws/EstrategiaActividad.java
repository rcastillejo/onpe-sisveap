
package com.sacooliveros.gepsac.proxyws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for estrategiaActividad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="estrategiaActividad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actividad" type="{http://comun.service.gepsac.sacooliveros.com/}actividad" minOccurs="0"/>
 *         &lt;element name="codigoEstrategia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indicadores" type="{http://comun.service.gepsac.sacooliveros.com/}indicador" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estrategiaActividad", propOrder = {
    "actividad",
    "codigoEstrategia",
    "indicadores"
})
public class EstrategiaActividad {

    protected Actividad actividad;
    protected String codigoEstrategia;
    @XmlElement(nillable = true)
    protected List<Indicador> indicadores;

    /**
     * Gets the value of the actividad property.
     * 
     * @return
     *     possible object is
     *     {@link Actividad }
     *     
     */
    public Actividad getActividad() {
        return actividad;
    }

    /**
     * Sets the value of the actividad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Actividad }
     *     
     */
    public void setActividad(Actividad value) {
        this.actividad = value;
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
     * Gets the value of the indicadores property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the indicadores property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndicadores().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Indicador }
     * 
     * 
     */
    public List<Indicador> getIndicadores() {
        if (indicadores == null) {
            indicadores = new ArrayList<Indicador>();
        }
        return this.indicadores;
    }

}
