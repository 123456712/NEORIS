package com.claro.WSTransaccionalPrueba.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
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

import com.claro.WSTransaccionalPrueba.entity.Cliente;
import com.claro.WSTransaccionalPrueba.entity.Persona;
import com.claro.WSTransaccionalPrueba.service.ClienteService;

@RestController
@RequestMapping(path = "/clientes")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}
	@PostMapping(path = "/crear")
	public ResponseEntity<Cliente> crear(
			@RequestBody(required = true) Cliente cliente){
		
		Cliente response = null;
		try {
			response = new Cliente();
			response = clienteService.crear(cliente);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	@PutMapping(path = "/editar")
	public ResponseEntity<Cliente> editar(
			@RequestBody(required = true) Cliente cliente){
		
		if(cliente.getId_persona() == null ) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		Cliente response = new Cliente();
		try {
			response = clienteService.editar(cliente);
		} catch (Exception e) {
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	@GetMapping(path = "/consultar")
//	public ResponseEntity consultar(){
		public ResponseEntity<List<Cliente>> consultar(){
		
		List<Cliente> response = new ArrayList<Cliente>();
		try {
			response = clienteService.consultar();
		} catch (Exception e) {
		}
		System.out.println(response);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	@DeleteMapping(path = "/eliminar")
	public ResponseEntity eliminar(
			@RequestParam(name = "idCliente", required = true) Integer idCliente){
			clienteService.eliminar(idCliente);
		return ResponseEntity.status(HttpStatus.OK).body("");
		
	}
	

}
