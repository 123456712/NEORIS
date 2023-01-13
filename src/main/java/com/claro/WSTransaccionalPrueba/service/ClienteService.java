package com.claro.WSTransaccionalPrueba.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.claro.WSTransaccionalPrueba.entity.Cliente;
import com.claro.WSTransaccionalPrueba.entity.Persona;
public interface ClienteService {
	
	public Cliente crear( String nombre, char genero, Date fechaNacimiento, Integer identificacion,
			String direccion, Integer telefono, String contrasena, boolean estado);
	public Cliente crear(Cliente cliente);
	
	public Cliente editar(BigInteger id, String nombre, char genero, Date fechaNacimiento, Double identificacion,
			String direccion, Double telefono, String contrasena, char estado);
	public Cliente editar(Cliente cliente);
	
	public List<Cliente> consultar();
	public void eliminar(Integer id);

}
