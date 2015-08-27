
package com.sacooliveros.gepsac.proxyws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for planEstrategia complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="planEstrategia">
 *   &lt;complexContent>
 *     &lt;extension base="{http://planificacion.service.gepsac.sacooliveros.com/}estrategia">
 *       &lt;sequence>
 *         &lt;element name="actividadesSeleccionadas" type="{http://planificacion.service.gepsac.sacooliveros.com/}planActividad" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="codigoPlan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "planEstrategia", propOrder = {
    "actividadesSeleccionadas",
    "codigoPlan"
})
public class PlanEstrategia
    extends Estrategia
{

    @XmlElement(nillable = true)
    protected List<PlanActividad> actividadesSeleccionadas;
    protected String codigoPlan;

    /**
     * Gets the value of the actividadesSeleccionadas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actividadesSeleccionadas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActividadesSeleccionadas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PlanActividad }
     * 
     * 
     */
    public List<PlanActividad> getActividadesSeleccionadas() {
        if (actividadesSeleccionadas == null) {
            actividadesSeleccionadas = new ArrayList<PlanActividad>();
        }
        return this.actividadesSeleccionadas;
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

}
