package com.claro.WSTransaccionalPrueba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claro.WSTransaccionalPrueba.entity.Cuenta;
import com.claro.WSTransaccionalPrueba.service.CuentaService;

@RestController
@RequestMapping(path = "/cuentas")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;
	
	@PostMapping(path = "/crear")
	public ResponseEntity<Cuenta> crear(
			@RequestBody(required = true) Cuenta cuenta){
		Cuenta response = null;
		try {
			response = new Cuenta();
			response = cuentaService.crear(cuenta);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@PutMapping(path = "/editar")
	public ResponseEntity<Cuenta> editar(
			@RequestBody(required = true) Cuenta cuenta){
		Cuenta response = new Cuenta();
		try {
			response = cuentaService.editar(cuenta);
		} catch (Exception e) {
			System.out.println(e);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@DeleteMapping(path = "/eliminar")
	public ResponseEntity eliminar(
			@RequestParam(name = "numeroCuenta", required = true) Integer numeroCuenta){
		try {
			 cuentaService.eliminar(numeroCuenta);
		} catch (Exception e) {
			System.out.println(e);
		}
		return ResponseEntity.status(HttpStatus.OK).body("");
		
	}
	@GetMapping(path = "/consultar")
	public ResponseEntity<List<Cuenta>> consultar(){
		
		List<Cuenta> response = new ArrayList<Cuenta>();
		try {
			response = cuentaService.consultar();
		} catch (Exception e) {
			System.out.println(e);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
}
