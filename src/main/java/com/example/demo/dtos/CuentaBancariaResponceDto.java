package com.example.demo.dtos;

import java.util.Date;

import com.example.demo.entities.TipoCuenta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuentaBancariaResponceDto {
	private String id;
	private Date fechaCreacion;
	private double balance;
	private String divisa;
	private TipoCuenta tipoCuenta;
}
