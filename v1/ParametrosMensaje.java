
package com.amx.co.schema.mobile.enterprise.aplicationintegration.enviarnotificacionmail.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ParametrosMensaje complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ParametrosMensaje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idParametro" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParametrosMensaje", propOrder = {
    "idParametro",
    "valor"
})
public class ParametrosMensaje {

    @XmlElement(required = true)
    protected String idParametro;
    @XmlElement(required = true)
    protected String valor;

    /**
     * Obtiene el valor de la propiedad idParametro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdParametro() {
        return idParametro;
    }

    /**
     * Define el valor de la propiedad idParametro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdParametro(String value) {
        this.idParametro = value;
    }

    /**
     * Obtiene el valor de la propiedad valor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValor() {
        return valor;
    }

    /**
     * Define el valor de la propiedad valor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValor(String value) {
        this.valor = value;
    }

}
