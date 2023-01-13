package com.claro.WSTransaccionalPrueba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claro.WSTransaccionalPrueba.entity.Cuenta;
import com.claro.WSTransaccionalPrueba.repository.CuentaRepository;
import com.claro.WSTransaccionalPrueba.service.CuentaService;
@Service
public class CuentaServiceImpl implements CuentaService{

	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Override
	public Cuenta crear(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

	@Override
	public List<Cuenta> consultar() {
		return cuentaRepository.findAll();
	}

	@Override
	public Cuenta editar(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

	@Override
	public void eliminar(Integer idCuenta) {
		cuentaRepository.deleteById(idCuenta);
	}

}
