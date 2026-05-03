package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.entities.CuentaBancaria;
import com.example.demo.entities.TipoCuenta;

import java.util.List;

// Anotación que expone automáticamente esta interfaz como un endpoint REST, 
// permitiendo acceso HTTP a los métodos del repositorio
@RepositoryRestResource
public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria,String> {
	@RestResource(path = "/byType")
    /** Método que busca cuentas bancarias por tipo de cuenta*/
    // - List<CuentaBancaria>: retorna una lista de objetos CuentaBancaria  5511877286
    // - findByTipoCuenta: nombre del método que sigue la convención de Spring Data (find + By + propiedad)
    // - @Param("t"): mapea el parámetro a la query como "t" (permite referenciar en URLs REST)
    // - TipoCuenta tipoCuenta: parámetro de entrada para filtrar por tipo de cuenta
    List<CuentaBancaria> findByTipoCuenta(@Param("t") TipoCuenta tipoCuenta);
}
