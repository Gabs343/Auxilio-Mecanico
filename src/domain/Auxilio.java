package domain;

import java.util.List;
import java.util.ArrayList;

public class Auxilio {
	private List<Pedido> pedidos;
	private List<TipoAuxilio> tiposDeAuxilios;
	
	public Auxilio() {
		pedidos = new ArrayList<Pedido>();
		tiposDeAuxilios = new ArrayList<TipoAuxilio>();
	}
	
	public void addPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public void setListaPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos; 
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public Pedido getPedido(Integer nroPedido) {
		return pedidos.get(nroPedido);
	}

	public List<TipoAuxilio> getTiposDeAuxilios() {
		return tiposDeAuxilios;
	}

	public void setTiposDeAuxilios(List<TipoAuxilio> tiposDeAuxilios) {
		this.tiposDeAuxilios = tiposDeAuxilios;
	}
	
	public void addTipoAuxilio(TipoAuxilio tipoAuxilio) {
		tiposDeAuxilios.add(tipoAuxilio);
	}

	@Override
	public String toString() {
		return "Auxilio [pedidos=" + pedidos + ", tiposDeAuxilios=" + tiposDeAuxilios + "]";
	}

	
	
}
