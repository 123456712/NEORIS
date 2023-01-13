package com.claro.WSTransaccionalPrueba.DTO;

public class MovimientoRequestDTO {
	
	private Integer valor;
	private Integer numeroCuenta;
	private String tipoCuenta;
	
	
	public MovimientoRequestDTO() {
	}

	public MovimientoRequestDTO(Integer valor, Integer numeroCuenta, String tipoCuenta) {
		super();
		this.valor = valor;
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
	}



	public Integer getValor() {
		return valor;
	}


	public void setValor(Integer valor) {
		this.valor = valor;
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
	
	
	
}
