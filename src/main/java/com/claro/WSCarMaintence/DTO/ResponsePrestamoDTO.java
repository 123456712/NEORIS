package com.claro.WSCarMaintence.DTO;

import java.util.List;

import com.claro.WSCarMaintence.model.Prestamo;

public class ResponsePrestamoDTO {
	private Integer out_codigo;
	private String out_descripcion;
	private List<Prestamo> listaPrestamo;
	
	public ResponsePrestamoDTO() {
	}
			
	public ResponsePrestamoDTO(Integer out_codigo, String out_descripcion, List<Prestamo> listaPrestamo) {
		super();
		this.out_codigo = out_codigo;
		this.out_descripcion = out_descripcion;
		this.listaPrestamo = listaPrestamo;
	}

	public Integer getOut_codigo() {
		return out_codigo;
	}

	public void setOut_codigo(Integer out_codigo) {
		this.out_codigo = out_codigo;
	}

	public String getOut_descripcion() {
		return out_descripcion;
	}

	public void setOut_descripcion(String out_descripcion) {
		this.out_descripcion = out_descripcion;
	}

	public List<Prestamo> getListaPrestamo() {
		return listaPrestamo;
	}

	public void setListaPrestamo(List<Prestamo> listaPrestamo) {
		this.listaPrestamo = listaPrestamo;
	}
	
	
}
