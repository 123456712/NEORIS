package com.claro.WSCarMaintence.servicio.ws.rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claro.WSCarMaintence.model.Autor;


@RestController
@RequestMapping(path = "/autor")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST})
public class AutorController {

	private final EntityManager entityManager;
	
	
	public AutorController(final EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@PostMapping(path = "/consultar")
	public ResponseEntity <List<Autor>> consultarAutor(@RequestParam(name = "id_autor", required = false) Integer id_autor) {
		List<Autor> autor = new ArrayList<Autor>();

		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("biblioteca.PRC_ADM_AUTOR");		
		
		// Registrar los parámetros de entrada y salida
        storedProcedureQuery.registerStoredProcedureParameter("IN_ACCION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("IN_ID_AUTOR", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("IN_NOMBRE_AUTOR", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("OUT_CODIGO", Integer.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("OUT_DESCRIPCION", String.class, ParameterMode.OUT);	


     // Configuramos el valor de entrada
        storedProcedureQuery.setParameter("IN_ACCION", "c");
        storedProcedureQuery.setParameter("IN_ID_AUTOR", id_autor);
        storedProcedureQuery.setParameter("IN_NOMBRE_AUTOR", null);
        
        // Realizamos la llamada al procedimiento
        storedProcedureQuery.execute();
        autor = (List <Autor>)storedProcedureQuery.getResultList();
 
        // Obtenemos los valores de salida
        final Integer codigo = (Integer) storedProcedureQuery.getOutputParameterValue("OUT_CODIGO");
        final String descripcion = (String) storedProcedureQuery.getOutputParameterValue("OUT_DESCRIPCION");        

		return ResponseEntity.status(HttpStatus.OK).body(autor);
	}
}
