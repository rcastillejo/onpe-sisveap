
package com.onpe.sisveap.proxyws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for verificador complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="verificador">
 *   &lt;complexContent>
 *     &lt;extension base="{http://comun.service.gepsac.sacooliveros.com/}persona">
 *       &lt;sequence>
 *         &lt;element name="cantOTEnProceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="region" type="{http://comun.service.gepsac.sacooliveros.com/}region" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verificador", propOrder = {
    "cantOTEnProceso",
    "region"
})
public class Verificador
    extends Persona
{

    protected int cantOTEnProceso;
    protected Region region;

    /**
     * Gets the value of the cantOTEnProceso property.
     * 
     */
    public int getCantOTEnProceso() {
        return cantOTEnProceso;
    }

    /**
     * Sets the value of the cantOTEnProceso property.
     * 
     */
    public void setCantOTEnProceso(int value) {
        this.cantOTEnProceso = value;
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

}
