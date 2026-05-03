package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

// Marca esta clase como una entidad JPA que será persistida en la base de datos
@Entity
public class CuentaBancaria {
	// Marca este campo como la clave primaria de la tabla en la base de datos
	@Id
	private String id;
	private Date fechaCreacion;
	private double balance;
	private String divisa;

	// Especifica que el enum se almacenará como String en la base de datos en lugar
	// de usar el ordinal numérico
	@Enumerated(EnumType.STRING)
	private TipoCuenta tipoCuenta;

	/**
	 * En Spring Boot Data Rest, una proyección es una plantilla que te permite
	 * elegir qué datos mostrar de una entidad (como un usuario o un producto)
	 * cuando alguien pide información por la API.
	 * 
	 * En lugar de mostrar (o "devolver") todos los datos del objeto (como nombre,
	 * edad, contraseña, fecha, etc.), la proyección te permite filtrar y mostrar
	 * solo los que te interesan (por ejemplo, solo el nombre y el correo, sin la
	 * contraseña). También puede incluir datos de otras entidades relacionadas.
	 */

	// Constructor sin parámetros
	public CuentaBancaria() {
	}

	// Constructor con todos los parámetros
	public CuentaBancaria(String id, Date fechaCreacion, double balance, String divisa, TipoCuenta tipoCuenta) {
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.balance = balance;
		this.divisa = divisa;
		this.tipoCuenta = tipoCuenta;
	}

	// Getters y Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDivisa() {
		return divisa;
	}

	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	// Método estático para crear una instancia de Builder
	public static Builder builder() {
		return new Builder();
	}

	// Clase interna Builder para implementar el patrón Builder
	public static class Builder {
		private String id;
		private Date fechaCreacion;
		private double balance;
		private String divisa;
		private TipoCuenta tipoCuenta;

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder fechaCreacion(Date fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
			return this;
		}

		public Builder balance(double balance) {
			this.balance = balance;
			return this;
		}

		public Builder divisa(String divisa) {
			this.divisa = divisa;
			return this;
		}

		public Builder tipoCuenta(TipoCuenta tipoCuenta) {
			this.tipoCuenta = tipoCuenta;
			return this;
		}

		// Construye la instancia de CuentaBancaria
		public CuentaBancaria build() {
			CuentaBancaria cuentaBancaria = new CuentaBancaria();
			cuentaBancaria.id = this.id;
			cuentaBancaria.fechaCreacion = this.fechaCreacion;
			cuentaBancaria.balance = this.balance;
			cuentaBancaria.divisa = this.divisa;
			cuentaBancaria.tipoCuenta = this.tipoCuenta;
			return cuentaBancaria;
		}
	}

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", fechaCreacion=" + fechaCreacion + ", balance=" + balance
				+ ", divisa=" + divisa + ", tipoCuenta=" + tipoCuenta + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((divisa == null) ? 0 : divisa.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tipoCuenta == null) ? 0 : tipoCuenta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaBancaria other = (CuentaBancaria) obj;
		if (divisa == null) {
			if (other.divisa != null)
				return false;
		} else if (!divisa.equals(other.divisa))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipoCuenta != other.tipoCuenta)
			return false;
		return true;
	}
}
