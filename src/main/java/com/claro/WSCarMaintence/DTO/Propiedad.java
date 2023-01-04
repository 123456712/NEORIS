package com.claro.WSCarMaintence.DTO;

public class Propiedad {

	private String codapp;
	private String nombre;
	private String valor;
	
	public Propiedad() {
	}

	public Propiedad(String codapp, String nombre, String valor) {
		super();
		this.codapp = codapp;
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getCodapp() {
		return codapp;
	}

	public void setCodapp(String codapp) {
		this.codapp = codapp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
