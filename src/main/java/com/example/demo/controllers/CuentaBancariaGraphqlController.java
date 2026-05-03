package com.example.demo.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.entities.CuentaBancaria;
import com.example.demo.repository.CuentaBancariaRepository;

@Controller
public class CuentaBancariaGraphqlController {

	private final CuentaBancariaRepository cuentaBancariaRepository;
	public CuentaBancariaGraphqlController(CuentaBancariaRepository cuentaBancariaRepository) {
		this.cuentaBancariaRepository = cuentaBancariaRepository;
	}
	@QueryMapping
	public List<CuentaBancaria> listarCuentas(){
		return cuentaBancariaRepository.findAll();
	}
	
}
