package service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import domain.Camion;
import domain.Cliente;
import domain.Pedido;
import domain.TipoAuxilio;

public class PedidoService {
	
	public Pedido crearPedido(String lugar, Cliente cliente, TipoAuxilio tipoAuxilio) {
		BigDecimal costo = tipoAuxilio.getCosto();
		return new Pedido(lugar, cliente, tipoAuxilio, costo);
	}
	
	public void actualizarCosto(Pedido p, BigDecimal costoExtra) {
		p.setCosto(p.getCosto().add(costoExtra));
	}
	
	public void añadirCamion(Pedido p, Camion c) {
		p.setCamion(c);
	}
	
	public List<Pedido> pedidosDeCliente(Cliente cl, List<Pedido> pedidos) {
		List<Pedido> pedidosDeCliente = 
				pedidos.stream().filter(p -> p.getCliente().equals(cl)).collect(Collectors.toList());
		return pedidosDeCliente;
	}
	
	public List<Pedido> pedidosSinPagarDeCliente(Cliente cl, List<Pedido> pedidos) {
		List<Pedido> pedidosDeCliente = 
				pedidos.stream().filter(p -> p.getCliente().equals(cl) && !p.getPagado()).collect(Collectors.toList());
		return pedidosDeCliente;
	}
	
	
}
