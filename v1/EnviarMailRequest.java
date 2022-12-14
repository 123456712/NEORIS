
package com.amx.co.schema.mobile.enterprise.aplicationintegration.enviarnotificacionmail.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EnviarMailRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EnviarMailRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="plantilla" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="correosDestino" type="{http://www.amx.com/co/schema/mobile/enterprise/aplicationIntegration/EnviarNotificacionMail/v1.0}CorreosDestino" maxOccurs="unbounded"/>
 *         &lt;element name="parametrosMensaje" type="{http://www.amx.com/co/schema/mobile/enterprise/aplicationIntegration/EnviarNotificacionMail/v1.0}ParametrosMensaje" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnviarMailRequest", propOrder = {
    "plantilla",
    "correosDestino",
    "parametrosMensaje"
})
public class EnviarMailRequest {

    protected int plantilla;
    @XmlElement(required = true)
    protected List<CorreosDestino> correosDestino;
    @XmlElement(required = true)
    protected List<ParametrosMensaje> parametrosMensaje;

    /**
     * Obtiene el valor de la propiedad plantilla.
     * 
     */
    public int getPlantilla() {
        return plantilla;
    }

    /**
     * Define el valor de la propiedad plantilla.
     * 
     */
    public void setPlantilla(int value) {
        this.plantilla = value;
    }

    /**
     * Gets the value of the correosDestino property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the correosDestino property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCorreosDestino().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CorreosDestino }
     * 
     * 
     */
    public List<CorreosDestino> getCorreosDestino() {
        if (correosDestino == null) {
            correosDestino = new ArrayList<CorreosDestino>();
        }
        return this.correosDestino;
    }
    
    

    public void setCorreosDestino(List<CorreosDestino> correosDestino) {
		this.correosDestino = correosDestino;
	}
    
    

	public void setParametrosMensaje(List<ParametrosMensaje> parametrosMensaje) {
		this.parametrosMensaje = parametrosMensaje;
	}

	/**
     * Gets the value of the parametrosMensaje property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parametrosMensaje property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParametrosMensaje().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParametrosMensaje }
     * 
     * 
     */
    public List<ParametrosMensaje> getParametrosMensaje() {
        if (parametrosMensaje == null) {
            parametrosMensaje = new ArrayList<ParametrosMensaje>();
        }
        return this.parametrosMensaje;
    }

}
