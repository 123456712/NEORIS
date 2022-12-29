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

	private int id_prestamo;
	private Date fechaInicioPrestamo;
	private Date fechaFinPrestamo;
	private int fk_id_producto;
	private int fk_id_usuario;
	private int fk_prestamoPadre;
	
	
	public int getId_prestamo() {
		return id_prestamo;
	}
	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}
	public Date getFechaInicioPrestamo() {
		return fechaInicioPrestamo;
	}
	public void setFechaInicioPrestamo(Date fechaInicioPrestamo) {
		this.fechaInicioPrestamo = fechaInicioPrestamo;
	}
	public Date getFechaFinPrestamo() {
		return fechaFinPrestamo;
	}
	public void setFechaFinPrestamo(Date fechaFinPrestamo) {
		this.fechaFinPrestamo = fechaFinPrestamo;
	}
	public int getFk_id_producto() {
		return fk_id_producto;
	}
	public void setFk_id_producto(int fk_id_producto) {
		this.fk_id_producto = fk_id_producto;
	}
	public int getFk_id_usuario() {
		return fk_id_usuario;
	}
	public void setFk_id_usuario(int fk_id_usuario) {
		this.fk_id_usuario = fk_id_usuario;
	}
	public int getFk_prestamoPadre() {
		return fk_prestamoPadre;
	}
	public void setFk_prestamoPadre(int fk_prestamoPadre) {
		this.fk_prestamoPadre = fk_prestamoPadre;
	}
	
	
}
