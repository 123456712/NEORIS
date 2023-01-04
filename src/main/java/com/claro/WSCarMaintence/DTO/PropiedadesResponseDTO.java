package com.claro.WSCarMaintence.DTO;

public class PropiedadesResponseDTO {

	private int codigo;
	private Cursorparametros cursorparametros;
	private String descripcion;
	
	public PropiedadesResponseDTO() {
	}

	public PropiedadesResponseDTO(int codigo, Cursorparametros cursorparametros, String descripcion) {
		super();
		this.codigo = codigo;
		this.cursorparametros = cursorparametros;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cursorparametros getCursorparametros() {
		return cursorparametros;
	}

	public void setCursorparametros(Cursorparametros cursorparametros) {
		this.cursorparametros = cursorparametros;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
