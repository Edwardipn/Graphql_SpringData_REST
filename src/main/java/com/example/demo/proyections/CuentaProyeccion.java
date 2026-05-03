package com.example.demo.proyections;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.entities.CuentaBancaria;
import com.example.demo.entities.TipoCuenta;

@Projection(types = CuentaBancaria.class, name = "proyeccionCuentaBancaria")
public interface CuentaProyeccion {
	
	public String getId();
	public TipoCuenta getTipoCuenta();
	public Double getBalance();
}
