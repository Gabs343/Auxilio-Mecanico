package service;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

import domain.Camion;
import domain.CamionGranGrua;
import domain.CamionMiniGrua;
import domain.CamionMiniTaller;
import domain.Cliente;
import domain.Pedido;
import domain.TipoCamion;
import domain.TipoReparacion;

public class CamionService {
	
	public Camion crearCamionMiniTaller() {
		return new CamionMiniTaller(1000.0, new BigDecimal(700));
	}
	
	public Camion crearCamionMiniGrua() {
		return new CamionMiniGrua(3000.0, new BigDecimal(2500));
	}
	
	public Camion crearCamionGranGrua(TipoReparacion tipoReparacion) {
		return new CamionGranGrua(tipoReparacion, 5000.0, new BigDecimal(5000), false);
	}
	
	public Camion crearCamionGranGruaConTaller(TipoReparacion tipoReparacion) {
		return new CamionGranGrua(tipoReparacion, 5000.0, new BigDecimal(7000), true);
	}
	
	public void liberarCamion(Camion camion) {
		camion.setOcupado(false);
	}
	
	public void añadirPedido(Camion c, Pedido p) {
		c.setPedido(p);
		c.setOcupado(true);
	}
	
	public void añadirPedidos(Camion c, List<Pedido> pedidos) {
		c.setPedidos(pedidos);
	}
	
	public void eliminarPedido(Camion c, Pedido p) {
		c.getPedidos().remove(p);
	}
	
}
