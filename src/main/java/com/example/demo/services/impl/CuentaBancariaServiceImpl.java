package com.example.demo.services.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.CuentaBancariaRequestDto;
import com.example.demo.dtos.CuentaBancariaResponceDto;
import com.example.demo.entities.CuentaBancaria;
import com.example.demo.mappers.CuentaBancariaMapper;
import com.example.demo.repository.CuentaBancariaRepository;
import com.example.demo.services.CuentaBancariaService;

import jakarta.transaction.Transactional;

// Anotación que marca esta clase como un componente de servicio de Spring
@Service
// Anotación que proporciona manejo transaccional automático para todos los
// métodos de la clase. Una transacción garantiza que todas las operaciones
// de base de datos se ejecuten como una unidad indivisible: si algo falla,
// todas las operaciones se revierten (rollback); si todo va bien, se confirman
// (commit).
// Esto asegura la integridad y consistencia de los datos.
@Transactional
public class CuentaBancariaServiceImpl implements CuentaBancariaService {

	private final CuentaBancariaRepository cuentaBancariaRepository;
	private final CuentaBancariaMapper cuentaBancariaMapper;

	public CuentaBancariaServiceImpl(CuentaBancariaRepository cuentaBancariaRepository,
			CuentaBancariaMapper cuentaBancariaMapper) {
		this.cuentaBancariaRepository = cuentaBancariaRepository;
		this.cuentaBancariaMapper = cuentaBancariaMapper;
	}

	@Override
	public CuentaBancariaResponceDto addCuenta(CuentaBancariaRequestDto cuentaBancariaRequestDto) {
		// Utiliza el patrón Builder para construir una instancia de CuentaBancaria de
		// forma fluida y legible,
		// asignando valores a todos los atributos necesarios antes de crear el objeto
		// final
		CuentaBancaria cuentaBancaria = CuentaBancaria.builder()
				.id(UUID.randomUUID().toString())
				.fechaCreacion(new Date())
				.balance(cuentaBancariaRequestDto.getBalance())
				.divisa(cuentaBancariaRequestDto.getDivisa())
				.tipoCuenta(cuentaBancariaRequestDto.getTipoCuenta())
				.divisa(cuentaBancariaRequestDto.getDivisa())
				.build();
		// Guarda la nueva cuenta bancaria en la base de datos y devuelve la entidad
		// guardada, que incluye el ID generado y cualquier otro campo que se haya
		// actualizado durante el proceso de guardado.
		CuentaBancaria cuentaBancariaBBDD = cuentaBancariaRepository.save(cuentaBancaria);
		// Convierte la entidad cuentaBancariaBBDD guardada en un DTO de respuesta
		// utilizando el mapper, lo que permite abstraer la lógica de conversión y
		// mantener el código limpio y organizado.
		CuentaBancariaResponceDto cuentaBancariaResponceDto = cuentaBancariaMapper
				.fromCuentaBancariaResponceDto(cuentaBancariaBBDD);
		return cuentaBancariaResponceDto;
	}

}
