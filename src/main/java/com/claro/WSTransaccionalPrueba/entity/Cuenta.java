package com.claro.WSTransaccionalPrueba.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="CUENTA")
@ToString()
public class Cuenta {

	@Id
	@Column(name = "numero_Cuenta", unique=true)
	private Integer numeroCuenta;
	@Column(name = "tipo_Cuenta")
	private String tipoCuenta;
	@Column(name = "estado")
	private boolean estado;
	@Column(name = "saldo")
	private Integer saldo;
	
	@ManyToOne
    @JoinColumn(name="id_persona", nullable=false)
    private Cliente cliente;
	
	public Cuenta() {
	}

	public Cuenta(Integer numeroCuenta, String tipoCuenta, boolean estado, Integer saldo) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.estado = estado;
		this.saldo = saldo;
	}

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
