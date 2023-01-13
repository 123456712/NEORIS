package com.claro.WSTransaccionalPrueba.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claro.WSTransaccionalPrueba.entity.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer>{

	List<Movimiento> findByFechaBetween(Date des, Date has);

}
