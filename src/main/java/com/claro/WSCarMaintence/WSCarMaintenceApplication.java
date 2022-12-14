package com.claro.WSCarMaintence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WSCarMaintenceApplication {

//	static {
//		Configurador.configurar(Constantes.RUTA_ARCHIVO_PROPIEDADES, UtilsConstantes.LOGGER_PRINCIPAL,
//				Constantes.APLICACION);
//	}
	public static void main(String[] args) {
		SpringApplication.run(WSCarMaintenceApplication.class, args);
		
	}

}
