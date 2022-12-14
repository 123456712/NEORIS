package com.claro.WSCarMaintence.servicio.ws.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claro.WSCarMaintence.Exception.RequestException;
import com.claro.WSCarMaintence.interfase.MecanicoRepository;
import com.claro.WSCarMaintence.model.Mecanicos;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/mecanicos")
@CrossOrigin(origins = "*")
public class MecanicoController {

	//import org.apache.log4j.LogManager;
	private Logger logger = LogManager.getLogger(MecanicoController.class);
	@Autowired    
	private MecanicoRepository service;    

	@GetMapping("/all")
	public ResponseEntity<List<Mecanicos>> getAllMecanics()  
	{    
		List <Mecanicos> lst = new ArrayList<Mecanicos>();
		lst= service.selectAll();
		System.out.println(lst.size());   
		if(lst.size()!=0) {
			return new ResponseEntity<List<Mecanicos>>(lst, HttpStatus.OK);
		}
		return new ResponseEntity<List<Mecanicos>>(lst, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/available")
	@ApiOperation(value = "Mecánicos disponibles", notes = "Servicio REST para obtener los mecánicos disponibles.")
	public ResponseEntity<List<Mecanicos>> mecanicosDisponibles() {
		try {
			
			return new ResponseEntity<List<Mecanicos>>(service.consultarMecanicosDisponibles(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@PostMapping("/add")
	public void addMecanico(@RequestParam(name = "in_tipo_documento", required = true) String in_tipo_documento
			,@RequestParam(name = "in_documento", required = true) int in_documento
			,@RequestParam(name = "in_primer_nombre", required = true) String in_primer_nombre
			,@RequestParam(name = "in_segundo_nombre", required = false) String in_segundo_nombre
			,@RequestParam(name = "in_primer_apellido", required = true) String in_primer_apellido
			,@RequestParam(name = "in_segundo_apellido", required = false) String in_segundo_apellido
			,@RequestParam(name = "in_celular", required = true) String in_celular
			,@RequestParam(name = "in_direccion", required = true) String in_direccion
			,@RequestParam(name = "in_email", required = true) String in_email
			,@RequestParam(name = "in_estado", required = true) String in_estado
			){		
		logger.info("--------- INICIO DE METODO PARA ADICIONAR UN MECANICO---------------");
		try {
			Pattern pattern = Pattern
					.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
							+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"); 
			Matcher mather = pattern.matcher(in_email);

			if (!mather.find()) {
				logger.info("*** EL CORREO NO CUMPLE CON EL FORMATO:");
				throw new RequestException ("Formato de Email incorrecto");
				
			}

			Mecanicos mecanico= new Mecanicos();

			mecanico.setTipoDocumento(in_tipo_documento);
			mecanico.setDocumento(in_documento);
			mecanico.setPrimerNombre(in_primer_nombre);
			mecanico.setSegundoNombre(in_segundo_nombre);
			mecanico.setPrimerApellido(in_primer_apellido);
			mecanico.setSegundoApellido(in_segundo_apellido);
			mecanico.setCelular(in_celular);
			mecanico.setDireccion(in_direccion);
			mecanico.setEmail(in_email);
			mecanico.setEstado(in_estado);

			logger.info("El request con el que se consume el procedimiento sp_crear_mecanico:"+ mecanico );

			service.insertMecanico(in_tipo_documento,in_documento,in_primer_nombre,in_segundo_nombre
					,in_primer_apellido,in_segundo_apellido,in_celular,in_direccion,in_email,in_estado);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
