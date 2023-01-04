package com.claro.WSCarMaintence.servicio.ws.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claro.WSCarMaintence.DTO.RequestSolicitarPrestamo;
import com.claro.WSCarMaintence.DTO.ResponsePrestamoDTO;
import com.claro.WSCarMaintence.model.Autor;
import com.claro.WSCarMaintence.model.Prestamo;

@RestController
@RequestMapping(path = "/prestamo")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class PrestamoController {

	private final EntityManager entityManager;

	public PrestamoController(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	} 

	@PostMapping(path = "/solicitar")
	public ResponseEntity <ResponsePrestamoDTO> solicitarPrestamo(
			@RequestBody(required = true) RequestSolicitarPrestamo request) {

		ResponsePrestamoDTO response = new ResponsePrestamoDTO();
		try {
			StoredProcedureQuery storedProcedureQuery = entityManager
					.createStoredProcedureQuery("biblioteca.PRC_REALIZAR_PRESTAMO"); 

			// Registrar los parámetros de entrada y salida
			storedProcedureQuery.registerStoredProcedureParameter("IN_ID_USUARIO", Integer.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_ID_LIBRO", Integer.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("OUT_CODIGO", Integer.class, ParameterMode.OUT);
			storedProcedureQuery.registerStoredProcedureParameter("OUT_DESCRIPCION", String.class, ParameterMode.OUT);
	 
			// Configuramos el valor de entrada
	        storedProcedureQuery.setParameter("IN_ID_USUARIO", request.getId_usuario());
	        storedProcedureQuery.setParameter("IN_ID_LIBRO", request.getId_libro());
	        
	     // Realizamos la llamada al procedimiento
	        storedProcedureQuery.execute();
	        
	     // Obtenemos los valores de salida
	     		final Integer codigo = (Integer) storedProcedureQuery.getOutputParameterValue("OUT_CODIGO");
	     		final String descripcion = (String) storedProcedureQuery.getOutputParameterValue("OUT_DESCRIPCION");
	     	
	     	List<Prestamo> listPrestamo =  null;	
	     	if(codigo == 0) {
	          List<Object[]> results = storedProcedureQuery.getResultList();
	          listPrestamo =  new ArrayList<Prestamo>();
	          listPrestamo = results.stream().map(result -> new Prestamo(
	          		(Integer ) result[0],
	          		(Integer ) result[1],
	          		(String ) result[2],
	          		(Date ) result[3],
	          		(Date ) result[4],
	          		(Integer ) result[5])).collect(Collectors.toList());
	     	}	
	     	
	     	response.setOut_codigo(codigo);
	     	response.setOut_descripcion(descripcion);
	     	response.setListaPrestamo(listPrestamo);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping(path = "/consultar")
	public ResponseEntity<List<Prestamo>> consultarPrestamo(
			@RequestParam(required = false, name = "id_usuario") Integer id_usuario,
			@RequestParam(required = false, name = "id_libro") Integer id_libro) {
		
		List<Prestamo> listPrestamo =  new ArrayList<Prestamo>();
		
		try {
			StoredProcedureQuery storedProcedureQuery = entityManager
					.createStoredProcedureQuery("biblioteca.PRC_CONSULTAR_PRESTAMOS");
			// Registrar los parámetros de entrada y salida
			storedProcedureQuery.registerStoredProcedureParameter("IN_ID_USUARIO", Integer.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_ID_LIBRO", Integer.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("OUT_CODIGO", Integer.class, ParameterMode.OUT);
			storedProcedureQuery.registerStoredProcedureParameter("OUT_DESCRIPCION", String.class, ParameterMode.OUT);

			// Configuramos el valor de entrada
			storedProcedureQuery.setParameter("IN_ID_USUARIO", id_usuario);
			storedProcedureQuery.setParameter("IN_ID_LIBRO", id_libro);
			
			// Realizamos la llamada al procedimiento
	        storedProcedureQuery.execute();
	        List<Object[]> results = storedProcedureQuery.getResultList();
	        listPrestamo = results.stream().map(result -> new Prestamo(
	        		(Integer ) result[0],
	        		(Integer ) result[1],
	        		(String ) result[2],
	        		(Date ) result[3],
	        		(Date ) result[4],
	        		(Integer ) result[5])).collect(Collectors.toList());
	 

			// Obtenemos los valores de salida
			final Integer codigo = (Integer) storedProcedureQuery.getOutputParameterValue("OUT_CODIGO");
			final String descripcion = (String) storedProcedureQuery.getOutputParameterValue("OUT_DESCRIPCION");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(listPrestamo);
	}
}
