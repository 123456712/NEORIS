package com.claro.WSTransaccionalPrueba.repository;
import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claro.WSTransaccionalPrueba.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	

}
