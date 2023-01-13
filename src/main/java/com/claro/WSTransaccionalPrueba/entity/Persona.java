package com.claro.WSTransaccionalPrueba.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="PERSONA")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private Integer id_persona;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "genero")
	private char genero;
	@Column(name = "fecha_nacimiento" , nullable = true)
	private Date fechaNacimiento;
	@Column(name = "identificacion",unique=true,  nullable = true)
	private Integer identificacion;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private Integer telefono;
	
	public Persona() {
	}
	public Integer getId_persona() {
		return id_persona;
	}
	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Integer getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Integer identificacion) {
		this.identificacion = identificacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	
	

}
