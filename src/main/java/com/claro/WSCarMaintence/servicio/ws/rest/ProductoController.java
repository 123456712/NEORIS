package com.claro.WSCarMaintence.servicio.ws.rest;

import java.util.ArrayList;
import java.util.Date;
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

	@GetMapping(path = "/consultar}")
	public ResponseEntity<List<Producto>> consultarProducto(
			@RequestParam(name = "id_producto", required = false) Integer id_producto,
			@RequestParam(name = "fk_idCategoria", required = false) Integer fk_idCategoria,
			@RequestParam(name = "tipoProducto", required = false) String tipoProducto,
			@RequestParam(name = "fechaIngreso", required = false) Date fechaIngreso,
			@RequestParam(name = "periodoMaximoPrestamo", required = false) Integer periodoMaximoPrestamo) {

		List<Producto> producto = new ArrayList<Producto>();
		StoredProcedureQuery storedProcedureQuery = entityManager
				.createStoredProcedureQuery("biblioteca.PRC_ADM_PRODUCTOS");

		// Registrar los parámetros de entrada y salida
		storedProcedureQuery.registerStoredProcedureParameter("IN_ACCION", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("IN_TIPO_PRODUCTO", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("IN_FECHA_INACTIVACION", Date.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("IN_CANTIDAD_EJEMPLARES", Integer.class,
				ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("IN_ID_PRODUCTO", Integer.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("IN_MAX_PERIODO_PRESTAMO", Integer.class,
				ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("IN_ID_CATEGORIA", Integer.class, ParameterMode.IN); 
		storedProcedureQuery.registerStoredProcedureParameter("IN_FECHA_LLEGADA_BIBLIOTECA", Date.class,
				ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("IN_TITULO_PRODUCTO", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("IN_IDS_AUTORES", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("IN_NUM_PAGINA", Integer.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("IN_TAMANO_PAGINA", Integer.class, ParameterMode.IN);

		storedProcedureQuery.registerStoredProcedureParameter("OUT_CODIGO", Integer.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("OUT_DESCRIPCION", String.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("OUT_TOTAL_REGISTROS", Integer.class, ParameterMode.OUT);

		// Configuramos el valor de entrada
		storedProcedureQuery.setParameter("IN_ACCION", "c");
		storedProcedureQuery.setParameter("IN_ID_PRODUCTO", id_producto);
		storedProcedureQuery.setParameter("IN_ID_CATEGORIA", fk_idCategoria);
		storedProcedureQuery.setParameter("IN_TIPO_PRODUCTO", tipoProducto);
		storedProcedureQuery.setParameter("IN_FECHA_LLEGADA_BIBLIOTECA", fechaIngreso);
		storedProcedureQuery.setParameter("IN_MAX_PERIODO_PRESTAMO", periodoMaximoPrestamo);
		
	/*	storedProcedureQuery.setParameter("IN_ACCION", "c");
		storedProcedureQuery.setParameter("IN_ID_PRODUCTO", null);
		storedProcedureQuery.setParameter("IN_ID_CATEGORIA", null);
		storedProcedureQuery.setParameter("IN_TIPO_PRODUCTO", null);
		storedProcedureQuery.setParameter("IN_FECHA_LLEGADA_BIBLIOTECA", null);
		storedProcedureQuery.setParameter("IN_MAX_PERIODO_PRESTAMO", null);*/
		
		storedProcedureQuery.setParameter("IN_FECHA_INACTIVACION", null);
		storedProcedureQuery.setParameter("IN_CANTIDAD_EJEMPLARES", null);
		storedProcedureQuery.setParameter("IN_MAX_PERIODO_PRESTAMO", null);
		storedProcedureQuery.setParameter("IN_TITULO_PRODUCTO", null);
		storedProcedureQuery.setParameter("IN_IDS_AUTORES", null);
		storedProcedureQuery.setParameter("IN_NUM_PAGINA", null);
		storedProcedureQuery.setParameter("IN_TAMANO_PAGINA", null);

		// Realizamos la llamada al procedimiento
		storedProcedureQuery.execute();
		producto = (List<Producto>) storedProcedureQuery.getResultList();

		// Obtenemos los valores de salida
		final Integer codigo = (Integer) storedProcedureQuery.getOutputParameterValue("OUT_CODIGO");
		final String descripcion = (String) storedProcedureQuery.getOutputParameterValue("OUT_DESCRIPCION");
		final Integer totalRegistros = (Integer) storedProcedureQuery.getOutputParameterValue("OUT_TOTAL_REGISTROS");

		return ResponseEntity.status(HttpStatus.OK).body(producto);
	}



}
