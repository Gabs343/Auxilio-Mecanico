package service;
import java.util.List;

import domain.Pedido;
import domain.Vehiculo;

public class VehiculoService {
	
	public Vehiculo crearVehiculo(String patente, Double peso) {
		return new Vehiculo(patente, peso);
	}
	
	public void sumarRemolques(Vehiculo v, List<Pedido> pedidos){
		Integer remolques = null;
		
		for(Pedido p : pedidos) {
			if(p.getCliente().getVehiculo().equals(v)) {
				remolques = p.getCliente().getVehiculo().getRemolques();
			}
		}
				
		if(remolques != null) {
			v.setReparaciones(remolques + 1); 
		}else {
			v.setReparaciones(1); 
		}
	}
	
	public void sumarReparaciones(Vehiculo v, List<Pedido> pedidos){
		Integer reparaciones = null;
		for(Pedido p : pedidos) {
			if(p.getCliente().getVehiculo().equals(v)) {
				reparaciones = p.getCliente().getVehiculo().getReparaciones();
			}
		}
				
		if(reparaciones != null) {
			v.setReparaciones(reparaciones + 1); 
		}else {
			v.setReparaciones(1); 
		}
		
	}
	
	public Integer totalServicios(Vehiculo v) {
		Integer servicios =v.getRemolques() + v.getReparaciones();
		return servicios;
	}
}
