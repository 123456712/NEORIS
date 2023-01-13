package com.claro.WSTransaccionalPrueba.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="CLIENTE")
@PrimaryKeyJoinColumn(referencedColumnName = "id_persona")
public class Cliente extends Persona{
	
	@Column(name = "contrasena")
	private String contrasena;
	@Column(name = "estado")
	private boolean estado;
	
//	@OneToMany(mappedBy="cliente")
//    private List<Cuenta> cuentas;
	
	public Cliente() {
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
//	public List<Cuenta> getCuentas() {
//		return cuentas;
//	}
//
//	public void setCuentas(List<Cuenta> cuentas) {
//		this.cuentas = cuentas;
//	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
