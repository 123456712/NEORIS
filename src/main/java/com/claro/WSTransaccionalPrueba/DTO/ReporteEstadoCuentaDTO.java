package com.claro.WSTransaccionalPrueba.DTO;

import java.util.Date;

public class ReporteEstadoCuentaDTO {
	
	private Date fecha;
	private String cliente;
	private Integer numeroCuenta;
	private String tipo;
	private Integer saldoInicial;
	private boolean estado;
	private Integer movimiento;
	private Integer saldoDisponible;
	
	public ReporteEstadoCuentaDTO() {
	}

	public ReporteEstadoCuentaDTO(Date fecha, String cliente, Integer numeroCuenta, String tipo, Integer saldoInicial,
			boolean estado, Integer movimiento, Integer saldoDisponible) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.numeroCuenta = numeroCuenta;
		this.tipo = tipo;
		this.saldoInicial = saldoInicial;
		this.estado = estado;
		this.movimiento = movimiento;
		this.saldoDisponible = saldoDisponible;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Integer saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Integer getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Integer movimiento) {
		this.movimiento = movimiento;
	}

	public Integer getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(Integer saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}
	
	

}
