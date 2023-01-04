package com.claro.WSCarMaintence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

public class Categoria {

	private Integer id_categoria;
	private String nombre_categoria;
	
	
	
	public Categoria(Integer id_categoria, String nombre_categoria) {
		super();
		this.id_categoria = id_categoria;
		this.nombre_categoria = nombre_categoria;
	}



	public Integer getId_categoria() {
		return id_categoria;
	}



	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}



	public String getNombre_categoria() {
		return nombre_categoria;
	}



	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}
	

	
	
	

}
