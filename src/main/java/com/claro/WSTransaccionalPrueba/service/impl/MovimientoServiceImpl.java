package com.claro.WSTransaccionalPrueba.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claro.WSTransaccionalPrueba.DTO.RespuestaPRC;
import com.claro.WSTransaccionalPrueba.entity.Movimiento;
import com.claro.WSTransaccionalPrueba.repository.MovimientoRepository;
import com.claro.WSTransaccionalPrueba.service.MovimientoService;
@Service
public class MovimientoServiceImpl implements MovimientoService {
	
	private final EntityManager entityManager;
	@Autowired
	private MovimientoRepository movimientoRepository;
	
	public MovimientoServiceImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public RespuestaPRC depositar(Integer valor, Integer numeroCuenta, String tipoCuenta) {
		RespuestaPRC respuestaPRC = new RespuestaPRC();
		ejecutarPrcTransaccion(respuestaPRC, valor, numeroCuenta, tipoCuenta, "D");
		return respuestaPRC;
	}

	@Override
	public RespuestaPRC retirar(Integer valor, Integer numeroCuenta, String tipoCuenta) {
		RespuestaPRC respuestaPRC = new RespuestaPRC();
		ejecutarPrcTransaccion(respuestaPRC, valor, numeroCuenta, tipoCuenta, "R");
		return respuestaPRC;
	}
	@Override
	public List<Movimiento> consultar(Date des,Date has) {
		try {
//			return movimientoRepository.findByFechaBetween(new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-13"), new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-13"));
			return movimientoRepository.findByFechaBetween(des, has);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	private RespuestaPRC ejecutarPrcTransaccion(RespuestaPRC respuestaPRC, Integer valor, Integer numeroCuenta, String tipoCuenta, String tipoTransaccion ) {
		try {
			StoredProcedureQuery storedProcedureQuery = entityManager
					.createStoredProcedureQuery("neoris.PKG_MOVIMIENTOS.PRC_TRANSACCION");
			
			// Registrar los parámetros de entrada y salida
			storedProcedureQuery.registerStoredProcedureParameter("IN_NUMERO_CUENTA", Integer.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_TIPO_CUENTA", String.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_VALOR", Integer.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_TIPO_TRANSACCION", String.class, ParameterMode.IN);

			storedProcedureQuery.registerStoredProcedureParameter("OUT_CODIGO", Integer.class, ParameterMode.OUT);
			storedProcedureQuery.registerStoredProcedureParameter("OUT_DESCRIPCION", String.class, ParameterMode.OUT);
			
			// Configuramos el valor de entrada
			storedProcedureQuery.setParameter("IN_NUMERO_CUENTA", numeroCuenta);
			storedProcedureQuery.setParameter("IN_TIPO_CUENTA", tipoCuenta);
			storedProcedureQuery.setParameter("IN_VALOR", valor);
			storedProcedureQuery.setParameter("IN_TIPO_TRANSACCION", tipoTransaccion);
			
			// Realizamos la llamada al procedimiento
			storedProcedureQuery.execute();
			
			// Obtenemos los valores de salida
			respuestaPRC.setCodigo((Integer) storedProcedureQuery.getOutputParameterValue("OUT_CODIGO"));
			respuestaPRC.setDescripcionRespuesta((String) storedProcedureQuery.getOutputParameterValue("OUT_DESCRIPCION"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return respuestaPRC;
		
	}

	

}
