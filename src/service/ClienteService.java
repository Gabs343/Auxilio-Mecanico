package service;
import java.math.BigDecimal;
import domain.Cliente;
import domain.Vehiculo;
import domain.Cobertura;
import domain.Pedido;

public class ClienteService {
	
	public Cliente crearCliente(String nombre, String apellido, Vehiculo vehiculo, Cobertura cobertura, BigDecimal dinero) {
		return new Cliente(nombre, apellido, vehiculo, cobertura, dinero);
	}
	
	public boolean estaEndeudado(Cliente cl) {
		return cl.isEndeudado();
	}
	
	public void actualizarDinero(Cliente cl, BigDecimal dinero) {
		cl.setDinero(dinero);
	}
}
