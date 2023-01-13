package com.claro.WSTransaccionalPrueba.service;

import java.util.Date;
import java.util.List;

import com.claro.WSTransaccionalPrueba.DTO.RespuestaPRC;
import com.claro.WSTransaccionalPrueba.entity.Movimiento;

public interface MovimientoService {
	
	public RespuestaPRC depositar(Integer valor, Integer numeroCuenta, String tipoCuenta);
	public RespuestaPRC retirar(Integer valor, Integer numeroCuenta, String tipoCuenta);
	public List<Movimiento> consultar(Date des,Date has);

}
