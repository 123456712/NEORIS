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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claro.WSCarMaintence.model.Categoria;

@RestController
@RequestMapping(path = "/categorias")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class CategoriaController {

	private final EntityManager entityManager;
	
	public CategoriaController(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@GetMapping(path = "/consultar}")
	public ResponseEntity <List <Categoria>> consultarCategoria(
			@RequestParam(name = "id_categoria", required = false) Integer id_categoria) {
		List <Categoria> categoria = new ArrayList<Categoria>();		
		 
	StoredProcedureQuery storedProcedureQuery = entityManager
			.createStoredProcedureQuery("biblioteca.PRC_ADM_CATEGORIAS");
	
	// Registrar los parámetros de entrada y salida
	storedProcedureQuery.registerStoredProcedureParameter("IN_ACCION", String.class, ParameterMode.IN);
	storedProcedureQuery.registerStoredProcedureParameter("IN_ID_CATEGORIA", Integer.class, ParameterMode.IN);
	storedProcedureQuery.registerStoredProcedureParameter("IN_NOMBRE_CATEGORIA", String.class, ParameterMode.IN);
	storedProcedureQuery.registerStoredProcedureParameter("OUT_CODIGO", Integer.class, ParameterMode.OUT);
	storedProcedureQuery.registerStoredProcedureParameter("OUT_DESCRIPCION", String.class, ParameterMode.OUT);
	
	// Configuramos el valor de entrada
	storedProcedureQuery.setParameter("IN_ACCION", "c");
	storedProcedureQuery.setParameter("IN_ID_CATEGORIA", id_categoria);

	// Realizamos la llamada al procedimiento
	storedProcedureQuery.execute();
	categoria = (List <Categoria>) storedProcedureQuery.getResultList();

	// Obtenemos los valores de salida
	final Integer codigo = (Integer) storedProcedureQuery.getOutputParameterValue("OUT_CODIGO");
	final String descripcion = (String) storedProcedureQuery.getOutputParameterValue("OUT_DESCRIPCION");	
	
	return ResponseEntity.status(HttpStatus.OK).body(categoria);
	}
}
