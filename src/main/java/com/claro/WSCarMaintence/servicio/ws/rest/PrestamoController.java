package com.claro.WSCarMaintence.servicio.ws.rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity <List<Prestamo>> solicitarPrestamo(
			@PathVariable(required = true, name = "fk_id_usuario") Integer fk_id_usuario,
			@PathVariable(required = true, name = "fk_id_producto") Integer fk_id_producto) {

		List <Prestamo> prestamo = new ArrayList<Prestamo>();
		StoredProcedureQuery storedProcedureQuery = entityManager
				.createStoredProcedureQuery("biblioteca.PRC_REALIZAR_PRESTAMO"); 

		// Registrar los parámetros de entrada y salida
		storedProcedureQuery.registerStoredProcedureParameter("IN_ACCION", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("IN_ID_USUARIO", Integer.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("IN_ID_LIBRO", Integer.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("OUT_CODIGO", Integer.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("OUT_DESCRIPCION", String.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("OUT_CURSOR_INFO", String.class, ParameterMode.OUT);
 
		// Configuramos el valor de entrada
		
        storedProcedureQuery.setParameter("IN_ACCION", "c");
        storedProcedureQuery.setParameter("IN_ID_USUARIO", fk_id_usuario);
        storedProcedureQuery.setParameter("IN_ID_LIBRO", fk_id_producto);
		
		// Obtenemos los valores de salida
		final Integer codigo = (Integer) storedProcedureQuery.getOutputParameterValue("OUT_CODIGO");
		final String descripcion = (String) storedProcedureQuery.getOutputParameterValue("OUT_DESCRIPCION");
		final String cursor = (String) storedProcedureQuery.getOutputParameterValue("OUT_CURSOR_INFO");
		
        // Realizamos la llamada al procedimiento
        storedProcedureQuery.execute();
        prestamo = (List <Prestamo>) storedProcedureQuery.getResultList();

		return ResponseEntity.status(HttpStatus.OK).body(prestamo);
	}

	@GetMapping(path = "/consultar")
	public ResponseEntity<List<Prestamo>> consultarPrestamo(
			@PathVariable(required = true, name = "id_usuario") Integer id_usuario,
			@PathVariable(required = true, name = "id_libro") Integer id_libro) {
		List<Prestamo> listPrestamo =  new ArrayList<Prestamo>();
		if (id_usuario == null && id_libro == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listPrestamo);
		}
		
		StoredProcedureQuery storedProcedureQuery = entityManager
				.createStoredProcedureQuery("biblioteca.PRC_REALIZAR_PRESTAMO");
		// Registrar los parámetros de entrada y salida
		storedProcedureQuery.registerStoredProcedureParameter("IN_ACCION", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("IN_ID_USUARIO", Integer.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("IN_ID_LIBRO", Integer.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("OUT_CODIGO", Integer.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("OUT_DESCRIPCION", String.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("OUT_CURSOR_INFO", String.class, ParameterMode.OUT);

		// Configuramos el valor de entrada
		storedProcedureQuery.setParameter("IN_ACCION", "c");
		storedProcedureQuery.setParameter("IN_ID_USUARIO", null);
		storedProcedureQuery.setParameter("IN_ID_LIBRO", null);

		// Obtenemos los valores de salida
		final Integer codigo = (Integer) storedProcedureQuery.getOutputParameterValue("OUT_CODIGO");
		final String descripcion = (String) storedProcedureQuery.getOutputParameterValue("OUT_DESCRIPCION");
		final String cursor = (String) storedProcedureQuery.getOutputParameterValue("OUT_CURSOR_INFO");	
		
		return ResponseEntity.status(HttpStatus.OK).body(listPrestamo);
	}
}
