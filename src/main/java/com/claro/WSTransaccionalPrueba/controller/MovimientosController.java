package com.claro.WSTransaccionalPrueba.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.UpperCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claro.WSTransaccionalPrueba.DTO.MovimientoRequestDTO;
import com.claro.WSTransaccionalPrueba.DTO.ReporteEstadoCuentaDTO;
import com.claro.WSTransaccionalPrueba.DTO.RespuestaPRC;
import com.claro.WSTransaccionalPrueba.entity.Movimiento;
import com.claro.WSTransaccionalPrueba.service.MovimientoService;

@RestController
@RequestMapping(path = "/movimientos")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class MovimientosController {

	@Autowired
	private MovimientoService movimientoService ;  
	
	@PostMapping(path = "/depositar")
	public ResponseEntity depositar(
			@RequestBody(required = true) MovimientoRequestDTO movimiento){
		RespuestaPRC response  = new RespuestaPRC();
		try {
			response  = movimientoService.depositar(movimiento.getValor(), movimiento.getNumeroCuenta(), movimiento.getTipoCuenta());
		} catch (Exception e) {
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@PostMapping(path = "/retirar")
	public ResponseEntity retirar(
			@RequestBody(required = true) MovimientoRequestDTO movimiento){
		RespuestaPRC response  = new RespuestaPRC();
		try {
			response  = movimientoService.retirar(movimiento.getValor(), movimiento.getNumeroCuenta(), movimiento.getTipoCuenta());
		} catch (Exception e) {
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(path = "/reporte")
	public ResponseEntity reporte(
			@RequestParam(name = "fechaInicio", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
			@RequestParam(name = "fechaFin", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd")  Date fechaFin
			){
		System.out.println(fechaInicio);
		System.out.println(fechaFin);
		List<ReporteEstadoCuentaDTO> reporte = new ArrayList<>();
		try {
			List<Movimiento> movimientos = movimientoService.consultar(fechaInicio, fechaFin);
			
			reporte = movimientos.stream().map(result -> new ReporteEstadoCuentaDTO(
					result.getFecha()
					, result.getCuenta().getCliente().getNombre()
					, result.getCuenta().getNumeroCuenta()
					, result.getCuenta().getTipoCuenta()
					, result.getSaldo()
					, result.getCuenta().getEstado()
					, (result.getTipoMovimiento() == 'D')? result.getValor(): (result.getValor() * -1)
					, result.getCuenta().getSaldo()
					 )).collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println(e);
		}
		return ResponseEntity.status(HttpStatus.OK).body(reporte);
	}
	
}
