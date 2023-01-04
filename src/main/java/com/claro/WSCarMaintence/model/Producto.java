package com.claro.WSCarMaintence.model;

import java.util.Date;

public class Producto {
   
	private String tipo;
	private Date fecha_inactivacion;
	private Integer cantidad_ejemplares;
	private Integer id_producto;
	private Integer max_periodo_prestamo;
	private Integer id_Categoria;
	private String nombre_categoria;
	private String titulo;
	private Date fecha_llegada_biblioteca;
	private Integer cantidad_ejemplares_disponibles;
	private String autores;
	
	public Producto(String tipo, Date fecha_inactivacion, Integer cantidad_ejemplares, Integer id_producto,
			Integer max_periodo_prestamo, Integer id_Categoria, String nombre_categoria, String titulo,
			Date fecha_llegada_biblioteca, Integer cantidad_ejemplares_disponibles, String autores) {
		super();
		this.tipo = tipo;
		this.fecha_inactivacion = fecha_inactivacion;
		this.cantidad_ejemplares = cantidad_ejemplares;
		this.id_producto = id_producto;
		this.max_periodo_prestamo = max_periodo_prestamo;
		this.id_Categoria = id_Categoria;
		this.nombre_categoria = nombre_categoria;
		this.titulo = titulo;
		this.fecha_llegada_biblioteca = fecha_llegada_biblioteca;
		this.cantidad_ejemplares_disponibles = cantidad_ejemplares_disponibles;
		this.autores = autores;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecha_inactivacion() {
		return fecha_inactivacion;
	}

	public void setFecha_inactivacion(Date fecha_inactivacion) {
		this.fecha_inactivacion = fecha_inactivacion;
	}

	public Integer getCantidad_ejemplares() {
		return cantidad_ejemplares;
	}

	public void setCantidad_ejemplares(Integer cantidad_ejemplares) {
		this.cantidad_ejemplares = cantidad_ejemplares;
	}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public Integer getMax_periodo_prestamo() {
		return max_periodo_prestamo;
	}

	public void setMax_periodo_prestamo(Integer max_periodo_prestamo) {
		this.max_periodo_prestamo = max_periodo_prestamo;
	}

	public Integer getId_Categoria() {
		return id_Categoria;
	}

	public void setId_Categoria(Integer id_Categoria) {
		this.id_Categoria = id_Categoria;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha_llegada_biblioteca() {
		return fecha_llegada_biblioteca;
	}

	public void setFecha_llegada_biblioteca(Date fecha_llegada_biblioteca) {
		this.fecha_llegada_biblioteca = fecha_llegada_biblioteca;
	}

	public Integer getCantidad_ejemplares_disponibles() {
		return cantidad_ejemplares_disponibles;
	}

	public void setCantidad_ejemplares_disponibles(Integer cantidad_ejemplares_disponibles) {
		this.cantidad_ejemplares_disponibles = cantidad_ejemplares_disponibles;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}
	
}
