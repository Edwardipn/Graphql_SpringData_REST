package com.example.demo.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.CuentaBancariaResponceDto;
import com.example.demo.entities.CuentaBancaria;

/**
 * En pocas palabras, en el contexto de Data Mapper:
 * 
 * Es un traductor que mueve datos entre una base de datos y un objeto en tu
 * código,
 * asegurando que no se mezclen. La base de datos no sabe del objeto, y el
 * objeto no sabe de la base de datos; el mapper actúa como intermediario
 * invisible.
 */
@Component
public class CuentaBancariaMapper {
    // Método que convierte una entidad CuentaBancaria a su DTO de respuesta
    public CuentaBancariaResponceDto fromCuentaBancariaResponceDto(CuentaBancaria cuentaBancaria) {
        // Instancia un nuevo objeto CuentaBancariaResponceDto vacío
        CuentaBancariaResponceDto cuentaBancariaResponceDto = new CuentaBancariaResponceDto();
        // Copia todas las propiedades del objeto origen (cuentaBancaria) al objeto
        // destino (cuentaBancariaResponceDto, DTO)
        BeanUtils.copyProperties(cuentaBancaria, cuentaBancariaResponceDto);
        // Retorna el DTO poblado con los datos de la entidad
        return cuentaBancariaResponceDto;
    }
}
