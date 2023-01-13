package com.claro.WSTransaccionalPrueba.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claro.WSTransaccionalPrueba.entity.Cliente;
import com.claro.WSTransaccionalPrueba.entity.Persona;
import com.claro.WSTransaccionalPrueba.repository.ClienteRepository;
import com.claro.WSTransaccionalPrueba.service.ClienteService;
@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente crear(String nombre, char genero, Date fechaNacimiento, Integer identificacion, String direccion,
			Integer telefono, String contrasena, boolean estado) {
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		cliente.setGenero(genero);
		cliente.setFechaNacimiento(fechaNacimiento);
		cliente.setIdentificacion(identificacion);
		cliente.setDireccion(direccion);
		cliente.setTelefono(telefono);
		cliente.setContrasena(contrasena);
		cliente.setEstado(estado);
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente editar(BigInteger id, String nombre, char genero, Date fechaNacimiento, Double identificacion,
			String direccion, Double telefono, String contrasena, char estado) {
		return null;
	}

	@Override
	public List<Cliente> consultar() {
		return clienteRepository.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public Cliente crear(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente editar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	
}
