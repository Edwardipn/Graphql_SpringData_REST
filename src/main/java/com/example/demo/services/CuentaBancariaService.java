package com.example.demo.services;

import com.example.demo.dtos.CuentaBancariaRequestDto;
import com.example.demo.dtos.CuentaBancariaResponceDto;

public interface CuentaBancariaService {
	/**
	 * Método para agregar una nueva cuenta bancaria
	 * 
	 * @param cuentaBancariaRequestDto DTO con los datos de la cuenta a crear
	 * @return CuentaBancariaResponceDto DTO con los datos de la cuenta creada
	 *         incluyendo su ID
	 */
	CuentaBancariaResponceDto addCuenta(CuentaBancariaRequestDto cuentaBancariaRequestDto);
}
