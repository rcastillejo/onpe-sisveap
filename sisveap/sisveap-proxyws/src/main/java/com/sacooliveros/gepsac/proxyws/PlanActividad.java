
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
 * <p>Java class for planActividad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="planActividad">
 *   &lt;complexContent>
 *     &lt;extension base="{http://planificacion.service.gepsac.sacooliveros.com/}estrategiaActividad">
 *       &lt;sequence>
 *         &lt;element name="codigoPlan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://planificacion.service.gepsac.sacooliveros.com/}estado" minOccurs="0"/>
 *         &lt;element name="fechaEjecutada" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaProgramada" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="indicadoresSeleccionados" type="{http://planificacion.service.gepsac.sacooliveros.com/}planIndicador" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="meta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="programado" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "planActividad", propOrder = {
    "codigoPlan",
    "estado",
    "fechaEjecutada",
    "fechaProgramada",
    "indicadoresSeleccionados",
    "meta",
    "programado"
})
public class PlanActividad
    extends EstrategiaActividad
{

    protected String codigoPlan;
    protected Estado estado;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEjecutada;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaProgramada;
    @XmlElement(nillable = true)
    protected List<PlanIndicador> indicadoresSeleccionados;
    protected int meta;
    protected boolean programado;

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
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link Estado }
     *     
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link Estado }
     *     
     */
    public void setEstado(Estado value) {
        this.estado = value;
    }

    /**
     * Gets the value of the fechaEjecutada property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEjecutada() {
        return fechaEjecutada;
    }

    /**
     * Sets the value of the fechaEjecutada property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEjecutada(XMLGregorianCalendar value) {
        this.fechaEjecutada = value;
    }

    /**
     * Gets the value of the fechaProgramada property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaProgramada() {
        return fechaProgramada;
    }

    /**
     * Sets the value of the fechaProgramada property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaProgramada(XMLGregorianCalendar value) {
        this.fechaProgramada = value;
    }

    /**
     * Gets the value of the indicadoresSeleccionados property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the indicadoresSeleccionados property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndicadoresSeleccionados().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PlanIndicador }
     * 
     * 
     */
    public List<PlanIndicador> getIndicadoresSeleccionados() {
        if (indicadoresSeleccionados == null) {
            indicadoresSeleccionados = new ArrayList<PlanIndicador>();
        }
        return this.indicadoresSeleccionados;
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

    /**
     * Gets the value of the programado property.
     * 
     */
    public boolean isProgramado() {
        return programado;
    }

    /**
     * Sets the value of the programado property.
     * 
     */
    public void setProgramado(boolean value) {
        this.programado = value;
    }

}
