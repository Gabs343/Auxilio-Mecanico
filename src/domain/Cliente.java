package domain;

import java.math.BigDecimal;

public class Cliente {
	private String nombre;
	private String apellido;
	private Vehiculo vehiculo;
	private Cobertura cobertura;
	private BigDecimal dinero;
	private boolean endeudado;
	
	public Cliente(String nombre, String apellido, Vehiculo vehiculo){
		this.nombre = nombre;
		this.apellido = apellido;
		this.vehiculo = vehiculo;
	}
	
	public Cliente(String nombre, String apellido, Vehiculo vehiculo, Cobertura cobertura, BigDecimal dinero) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.vehiculo = vehiculo;
		this.cobertura = cobertura;
		this.dinero = dinero;
		this.endeudado = false;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public Cobertura getCobertura() {
		return cobertura;
	}
	
	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}
	
	public boolean isEndeudado() {
		return endeudado;
	}
	
	public void setEndeudado(boolean endeudado) {
		this.endeudado = endeudado;
	}

	public BigDecimal getDinero() {
		return dinero;
	}

	public void setDinero(BigDecimal dinero) {
		this.dinero = dinero;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", vehiculo=" + vehiculo + ", cobertura="
				+ cobertura + ", dinero=" + dinero + ", endeudado=" + endeudado + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((vehiculo == null) ? 0 : vehiculo.hashCode());
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
		Cliente other = (Cliente) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (vehiculo == null) {
			if (other.vehiculo != null)
				return false;
		} else if (!vehiculo.getPatente().equals(other.vehiculo.getPatente()))
			return false;
		return true;
	}
	
	
	
	
}
