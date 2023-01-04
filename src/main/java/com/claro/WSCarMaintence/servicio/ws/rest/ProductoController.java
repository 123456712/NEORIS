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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claro.WSCarMaintence.DTO.ResponseConsultaProductosDTO;
import com.claro.WSCarMaintence.model.Categoria;
import com.claro.WSCarMaintence.model.Producto;

@RestController
@RequestMapping(path = "/libro")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ProductoController {


	private final EntityManager entityManager;

	public ProductoController(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@GetMapping(path = "/consultar")
	public ResponseEntity<ResponseConsultaProductosDTO> consultarProducto(
			@RequestParam(name = "id_categoria", required = false) Integer id_categoria,
			@RequestParam(name = "id_autor", required = false) String id_autor,
			@RequestParam(name = "estado", required = false) Integer estado,
			@RequestParam(name = "titulo_libro", required = false) String titulo_libro ,
			@RequestParam(name = "fecha_llegada_biblioteca", required = false) Date fecha_llegada_biblioteca ,
			@RequestParam(name = "max_PERIODO_prestamo", required = false) Integer max_PERIODO_prestamo) {

		ResponseConsultaProductosDTO response = new ResponseConsultaProductosDTO();
		
		try {
			StoredProcedureQuery storedProcedureQuery = entityManager
					.createStoredProcedureQuery("biblioteca.PRC_ADM_PRODUCTOS");

			// Registrar los parámetros de entrada y salida
			storedProcedureQuery.registerStoredProcedureParameter("IN_ACCION", String.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_TIPO_PRODUCTO", String.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_FECHA_INACTIVACION", Date.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_CANTIDAD_EJEMPLARES", Integer.class,ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_ID_PRODUCTO", Integer.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_MAX_PERIODO_PRESTAMO", Integer.class,ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_ID_CATEGORIA", Integer.class, ParameterMode.IN); 
			storedProcedureQuery.registerStoredProcedureParameter("IN_FECHA_LLEGADA_BIBLIOTECA", Date.class,ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_TITULO_PRODUCTO", String.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_IDS_AUTORES", String.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_NUM_PAGINA", Integer.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("IN_TAMANO_PAGINA", Integer.class, ParameterMode.IN);

			storedProcedureQuery.registerStoredProcedureParameter("OUT_CODIGO", Integer.class, ParameterMode.OUT);
			storedProcedureQuery.registerStoredProcedureParameter("OUT_DESCRIPCION", String.class, ParameterMode.OUT);
			storedProcedureQuery.registerStoredProcedureParameter("OUT_TOTAL_REGISTROS", Integer.class, ParameterMode.OUT);

			// Configuramos el valor de entrada
			storedProcedureQuery.setParameter("IN_ACCION", "c");
			storedProcedureQuery.setParameter("IN_TIPO_PRODUCTO", null);
			storedProcedureQuery.setParameter("IN_FECHA_INACTIVACION", null);
			storedProcedureQuery.setParameter("IN_CANTIDAD_EJEMPLARES", null);
			storedProcedureQuery.setParameter("IN_ID_PRODUCTO", null);
			storedProcedureQuery.setParameter("IN_MAX_PERIODO_PRESTAMO", max_PERIODO_prestamo);
			storedProcedureQuery.setParameter("IN_ID_CATEGORIA", id_categoria);
			storedProcedureQuery.setParameter("IN_FECHA_LLEGADA_BIBLIOTECA", fecha_llegada_biblioteca);
			storedProcedureQuery.setParameter("IN_TITULO_PRODUCTO", titulo_libro);
			storedProcedureQuery.setParameter("IN_IDS_AUTORES", id_autor);
			storedProcedureQuery.setParameter("IN_NUM_PAGINA", null);
			storedProcedureQuery.setParameter("IN_TAMANO_PAGINA", null);
			
			// Realizamos la llamada al procedimiento
			storedProcedureQuery.execute();
			List<Object[]> results = storedProcedureQuery.getResultList();
			List<Producto> listaProductos = new ArrayList<Producto>();
			listaProductos = results.stream().map(result -> new Producto(
					 (String) result[0],
					 (Date) result[1],
					 (Integer) result[2],
					 (Integer) result[3],
					 (Integer) result[4],
					 (Integer) result[5],
					 (String) result[6],
					 (String) result[7],
					 (Date) result[8],
					 (Integer) result[9],
					 (String) result[10])).collect(Collectors.toList());

			// Obtenemos los valores de salida
			final Integer codigo = (Integer) storedProcedureQuery.getOutputParameterValue("OUT_CODIGO");
			final String descripcion = (String) storedProcedureQuery.getOutputParameterValue("OUT_DESCRIPCION");
			final Integer totalRegistros = (Integer) storedProcedureQuery.getOutputParameterValue("OUT_TOTAL_REGISTROS");
			
			response.setOutout_codigo(codigo);
			response.setOut_descripcion(descripcion);
			response.setOut_total_registros(totalRegistros);
			response.setOut_cursor_info(listaProductos);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}



}
