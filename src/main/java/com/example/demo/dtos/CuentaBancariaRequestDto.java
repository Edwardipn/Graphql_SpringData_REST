package com.example.demo.dtos;

import com.example.demo.entities.TipoCuenta;

public class CuentaBancariaRequestDto {

	private double balance;
	private String divisa;
	private TipoCuenta tipoCuenta;

	// Constructor sin parámetros
	public CuentaBancariaRequestDto() {
	}

	// Constructor con todos los parámetros
	public CuentaBancariaRequestDto(double balance, String divisa, TipoCuenta tipoCuenta) {
		this.balance = balance;
		this.divisa = divisa;
		this.tipoCuenta = tipoCuenta;
	}

	// Getters y Setters
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

	@Override
	public String toString() {
		return "CuentaBancariaRequestDto [balance=" + balance + ", divisa=" + divisa + ", tipoCuenta="
				+ tipoCuenta + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((divisa == null) ? 0 : divisa.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		CuentaBancariaRequestDto other = (CuentaBancariaRequestDto) obj;
		if (divisa == null) {
			if (other.divisa != null)
				return false;
		} else if (!divisa.equals(other.divisa))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (tipoCuenta != other.tipoCuenta)
			return false;
		return true;
	}
}
