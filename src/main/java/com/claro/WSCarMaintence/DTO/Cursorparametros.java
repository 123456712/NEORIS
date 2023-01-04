package com.claro.WSCarMaintence.DTO;

import java.util.List;

public class Cursorparametros {
	
	private List<Propiedad> parametros;
	
	public Cursorparametros() {
	}

	public Cursorparametros(List<Propiedad> parametros) {
		super();
		this.parametros = parametros;
	}

	public List<Propiedad> getParametros() {
		return parametros;
	}

	public void setParametros(List<Propiedad> parametros) {
		this.parametros = parametros;
	}
	
	

}
