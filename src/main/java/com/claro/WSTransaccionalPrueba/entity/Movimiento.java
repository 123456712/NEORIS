package com.claro.WSTransaccionalPrueba.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="MOVIMIENTO")
public class Movimiento {
	
	@Id
	@Column(name = "id_movimiento")
	private Integer idMovimiento;
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Column(name = "tipo_Movimiento")
	private char tipoMovimiento;
	@Column(name = "valor")
	private Integer valor;
	@Column(name = "saldo")
	private Integer saldo;
	
	@ManyToOne
    @JoinColumn(name="numero_Cuenta", nullable=false)
    private Cuenta cuenta;
	
	public Movimiento() {
	}

	public Movimiento(Date fecha, char tipoMovimiento, Integer valor, Integer saldo) {
		super();
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
		this.valor = valor;
		this.saldo = saldo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public char getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(char tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Integer getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	

	

}
