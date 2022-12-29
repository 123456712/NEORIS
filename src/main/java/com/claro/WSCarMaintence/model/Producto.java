package com.claro.WSCarMaintence.model;

import java.util.Date;

public class Producto {
   

	private int id_producto;
	
	private int fk_idCategoria;

	private String cantidadEjemplares;

	private int periodoMaximoPrestamo;
	
	private String titulo;

	private Date fechaInactivacion;


	private Date fechaIngreso;

    private String autores;

/*
	@OneToMany(mappedBy = "producto")
    List<Mantenimiento> mantenimientos;
	

	public Producto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public int getCantidadEjemplares() {
		return cantidadEjemplares;
	}

	public void setCantidadEjemplares(int cantidadEjemplares) {
		this.cantidadEjemplares = cantidadEjemplares;
	}

	public int getPeriodoMaximoPrestamo() {
		return periodoMaximoPrestamo;
	}

	public void setPeriodoMaximoPrestamo(int periodoMaximoPrestamo) {
		this.periodoMaximoPrestamo = periodoMaximoPrestamo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaInActivacion() {
		return fechaInActivacion;
	}

	public void setFechaInActivacion(Date fechaInActivacion) {
		this.fechaInActivacion = fechaInActivacion;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

*/

}
