package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.demo.dtos.CuentaBancariaRequestDto;
import com.example.demo.dtos.CuentaBancariaResponceDto;
import com.example.demo.entities.CuentaBancaria;
import com.example.demo.repository.CuentaBancariaRepository;
import com.example.demo.services.CuentaBancariaService;

@RestController
@RequestMapping("/")
public class CuentaBancariaController {
	private final CuentaBancariaRepository cuentaBancariaRepository;
	private final CuentaBancariaService cuentaBancariaService;
	
	public CuentaBancariaController(CuentaBancariaRepository cuentaBancariaRepository,
			CuentaBancariaService cuentaBancariaService) {
		this.cuentaBancariaRepository = cuentaBancariaRepository;
		this.cuentaBancariaService = cuentaBancariaService;
	}
	
	@GetMapping("/cuentas")
	public List<CuentaBancaria> listarCuentasBancarias(){
		return cuentaBancariaRepository.findAll();
	}
	
	@GetMapping("/cuentas/{id}")
	public CuentaBancaria buscarCuentaBancaria(@PathVariable String id){
	    return cuentaBancariaRepository.findById(id)
	        .orElseThrow(() -> new ResponseStatusException(
	            HttpStatus.NOT_FOUND,"Cuenta no encontrada en buscarCuentaBancaria con id: " + id
	        ));
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminarCuentaBancaria(@PathVariable String id){
	    cuentaBancariaRepository.deleteById(id);
	}
	
	@PostMapping("/cuentas")
	public CuentaBancariaResponceDto guardarCuentasBancarias(@RequestBody CuentaBancariaRequestDto cuentaBancariaRequestDto){
		return cuentaBancariaService.addCuenta(cuentaBancariaRequestDto);
	}

	@PutMapping("/cuentas/{id}")
	public CuentaBancaria actualizarCuentasBancarias(@PathVariable String id, @RequestBody CuentaBancaria cuentaBancaria){
		CuentaBancaria cuentaBancariaBBDD = cuentaBancariaRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(
			            HttpStatus.NOT_FOUND,"Cuenta no encontrada en actualizarCuentasBancarias con  id: " + id
			        ));
		cuentaBancariaBBDD.setBalance(cuentaBancaria.getBalance());
		cuentaBancariaBBDD.setDivisa(cuentaBancaria.getDivisa());
		cuentaBancariaBBDD.setFechaCreacion(cuentaBancaria.getFechaCreacion());
		cuentaBancariaBBDD.setTipoCuenta(cuentaBancaria.getTipoCuenta());
		return cuentaBancariaRepository.save(cuentaBancariaBBDD);
	}	
}
