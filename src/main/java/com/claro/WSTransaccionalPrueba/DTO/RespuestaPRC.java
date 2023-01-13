package com.claro.WSTransaccionalPrueba.DTO;

public class RespuestaPRC {
	private Integer codigo;
	private String descripcionRespuesta;
	
	public RespuestaPRC() {
	}
	
	public RespuestaPRC(Integer codigo, String descripcionRespuesta) {
		super();
		this.codigo = codigo;
		this.descripcionRespuesta = descripcionRespuesta;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescripcionRespuesta() {
		return descripcionRespuesta;
	}
	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}
	
	

}
