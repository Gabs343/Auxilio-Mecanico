package service;
import java.math.BigDecimal;
import java.util.List;

import domain.Cliente;
import domain.Pedido;
import domain.TipoCobertura;

public class PagoService {
	
	public boolean pagosPedidosVencidos(List<Pedido> pedidos) {
		boolean pedidosPagados = true;
		for(Pedido pedido: pedidos) {
			if(!pedido.getPagado()) {
				pedidosPagados = false;
				break;
			}
		}
		
		return pedidosPagados;
	}
	
	public void pagoPedido(Pedido p, List<Pedido> pedidos) throws DineroInsuficiente{
		
		for(Pedido pedido: pedidos) {
			if(p.getCliente().getDinero().doubleValue() >= pedido.getCliente().getDinero().doubleValue()) {
				
				p.getCliente().setDinero(p.getCliente().getDinero().add(pedido.getCliente().getDinero()));
				pedido.setPagado(true);
			}
		}
			
		if(pagosPedidosVencidos(pedidos)) {
			p.getCliente().setEndeudado(false);
		}
			
		
		if(p.getCliente().getDinero().doubleValue() >= p.getCosto().doubleValue()) {
				
			p.getCliente().setDinero(p.getCliente().getDinero().subtract(p.getCosto()));
			p.setPagado(true);
					
		}else if(p.getCliente().getCobertura().getTipoCobertura() != TipoCobertura.ECONOMIC){	
			BigDecimal debeDinero = p.getCliente().getDinero().subtract(p.getCosto());
				
			if(p.getCliente().getCobertura().getTipoCobertura() == TipoCobertura.CLASSIC && debeDinero.doubleValue() >= -200) {
					
				p.getCliente().setDinero(p.getCliente().getDinero().subtract(p.getCosto()));
				p.getCliente().setEndeudado(true);
					
			}else {
				throw new DineroInsuficiente("No dispones del dinero suficiente para el pedido");
			}
				
		}else {	
			throw new DineroInsuficiente("No dispones del dinero suficiente para el pedido");
		}
			
	}
	
	
	public void pagoMensualPlatinum() {
		
	}
	
	
}
