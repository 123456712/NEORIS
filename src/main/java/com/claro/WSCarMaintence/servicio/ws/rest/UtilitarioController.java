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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claro.WSCarMaintence.DTO.Cursorparametros;
import com.claro.WSCarMaintence.DTO.Propiedad;
import com.claro.WSCarMaintence.DTO.PropiedadesRequestDTO;
import com.claro.WSCarMaintence.DTO.PropiedadesResponseDTO;
import com.claro.WSCarMaintence.model.Prestamo;

@RestController
@RequestMapping(path = "")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class UtilitarioController {
	
		private final EntityManager entityManager;

		public UtilitarioController(EntityManager entityManager) {
			super();
			this.entityManager = entityManager;
		}

		@GetMapping(path = "/propiedades/admParametrosEAF")
		public ResponseEntity<PropiedadesResponseDTO> consultarPropiedades(
				@RequestBody(required = true) PropiedadesRequestDTO request ) {
			
			PropiedadesResponseDTO response = new PropiedadesResponseDTO();
			try {
				StoredProcedureQuery storedProcedureQuery = entityManager
						.createStoredProcedureQuery("biblioteca.PRC_ADM_PARAMETROS"); 

				// Registrar los parámetros de entrada y salida
				storedProcedureQuery.registerStoredProcedureParameter("IN_COD_APP", String.class, ParameterMode.IN);
				storedProcedureQuery.registerStoredProcedureParameter("IN_NOMBRE", String.class, ParameterMode.IN);
				storedProcedureQuery.registerStoredProcedureParameter("IN_VALOR", String.class, ParameterMode.IN);
				storedProcedureQuery.registerStoredProcedureParameter("IN_ACCION", String.class, ParameterMode.IN);
				storedProcedureQuery.registerStoredProcedureParameter("OUT_CODIGO", Integer.class, ParameterMode.OUT);
				storedProcedureQuery.registerStoredProcedureParameter("OUT_DESCRIPCION", String.class, ParameterMode.OUT);
		 
				// Configuramos el valor de entrada
		        storedProcedureQuery.setParameter("IN_COD_APP", request.getCodapp());
		        storedProcedureQuery.setParameter("IN_NOMBRE", request.getNombre());
		        storedProcedureQuery.setParameter("IN_VALOR", request.getValor());
		        storedProcedureQuery.setParameter("IN_ACCION", "C");
		        
		     // Realizamos la llamada al procedimiento
		        storedProcedureQuery.execute();
		        
		     // Obtenemos los valores de salida
	     		final Integer codigo = (Integer) storedProcedureQuery.getOutputParameterValue("OUT_CODIGO");
	     		final String descripcion = (String) storedProcedureQuery.getOutputParameterValue("OUT_DESCRIPCION");
		     	
		     	List<Propiedad> listaPropiedades =  null;	
		     	if(codigo == 0) {
		          List<Object[]> results = storedProcedureQuery.getResultList();
		          listaPropiedades =  new ArrayList<Propiedad>();
		          listaPropiedades = results.stream().map(result -> new Propiedad(
		          		(String ) result[0],
		          		(String ) result[1],
		          		(String ) result[2])).collect(Collectors.toList());
		     	}	
		     	
		     	response.setCodigo(codigo);
		     	response.setDescripcion(descripcion);
		     	
		     	Cursorparametros cursor = new Cursorparametros();
		     	cursor.setParametros(listaPropiedades);
		     	response.setCursorparametros(cursor);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(response);
	    }

}
