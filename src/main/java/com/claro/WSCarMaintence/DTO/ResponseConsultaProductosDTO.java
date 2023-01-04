package com.claro.WSCarMaintence.DTO;

import java.util.List;

import com.claro.WSCarMaintence.model.Producto;

public class ResponseConsultaProductosDTO {
	
	private Integer outout_codigo;
	private String out_descripcion;
	private Integer out_total_registros;
	private List<Producto> out_cursor_info;
	
	public ResponseConsultaProductosDTO() {
	}
	
	public ResponseConsultaProductosDTO(Integer outout_codigo, String out_descripcion, Integer out_total_registros,
			List<Producto> out_cursor_info) {
		super();
		this.outout_codigo = outout_codigo;
		this.out_descripcion = out_descripcion;
		this.out_total_registros = out_total_registros;
		this.out_cursor_info = out_cursor_info;
	}

	public Integer getOutout_codigo() {
		return outout_codigo;
	}

	public void setOutout_codigo(Integer outout_codigo) {
		this.outout_codigo = outout_codigo;
	}

	public String getOut_descripcion() {
		return out_descripcion;
	}

	public void setOut_descripcion(String out_descripcion) {
		this.out_descripcion = out_descripcion;
	}

	public Integer getOut_total_registros() {
		return out_total_registros;
	}

	public void setOut_total_registros(Integer out_total_registros) {
		this.out_total_registros = out_total_registros;
	}

	public List<Producto> getOut_cursor_info() {
		return out_cursor_info;
	}

	public void setOut_cursor_info(List<Producto> out_cursor_info) {
		this.out_cursor_info = out_cursor_info;
	}

   

}
