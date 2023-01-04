package com.claro.WSCarMaintence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


public class Prestamo { 
	
	private Integer id_prestamo;
	private Integer id_libro;
	private String nombre_libro;
	private Date fecha_maxima_entrega;
	private Date fecha_entrega;
	private Integer id_usuario;
	
	public Prestamo() {
	}
	
	public Prestamo(Integer id_prestamo, Integer id_libro, String nombre_libro, Date fecha_maxima_entrega,
			Date fecha_entrega, Integer id_usuario) {
		super();
		this.id_prestamo = id_prestamo;
		this.id_libro = id_libro;
		this.nombre_libro = nombre_libro;
		this.fecha_maxima_entrega = fecha_maxima_entrega;
		this.fecha_entrega = fecha_entrega;
		this.id_usuario = id_usuario;
	}

	public Integer getId_prestamo() {
		return id_prestamo;
	}

	public void setId_prestamo(Integer id_prestamo) {
		this.id_prestamo = id_prestamo;
	}

	public Integer getId_libro() {
		return id_libro;
	}

	public void setId_libro(Integer id_libro) {
		this.id_libro = id_libro;
	}

	public String getNombre_libro() {
		return nombre_libro;
	}

	public void setNombre_libro(String nombre_libro) {
		this.nombre_libro = nombre_libro;
	}

	public Date getFecha_maxima_entrega() {
		return fecha_maxima_entrega;
	}

	public void setFecha_maxima_entrega(Date fecha_maxima_entrega) {
		this.fecha_maxima_entrega = fecha_maxima_entrega;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
	
	
}
