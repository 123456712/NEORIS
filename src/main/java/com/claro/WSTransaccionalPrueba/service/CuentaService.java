package com.claro.WSTransaccionalPrueba.service;

import java.util.List;

import com.claro.WSTransaccionalPrueba.entity.Cuenta;

public interface CuentaService {
	
	public Cuenta crear(Cuenta cuenta);
	public List<Cuenta> consultar();
	public Cuenta editar(Cuenta cuenta);
	public void eliminar(Integer idCuenta);

}
