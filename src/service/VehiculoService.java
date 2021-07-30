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
			v.setRemolques(remolques + 1); 
		}else {
			v.setRemolques(1); 
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
	
	public Integer getTotalReparaciones(Vehiculo v, List<Pedido> pedidos) {
		Integer reparaciones = 0;
		
		if(!pedidos.isEmpty()) {
			reparaciones = pedidos.get(pedidos.size() - 1).getCliente().getVehiculo().getReparaciones();
		}
		return reparaciones;
	}
	
	public Integer getTotalRemolques(Vehiculo v, List<Pedido> pedidos) {
		Integer remolques = 0;
		
		if(!pedidos.isEmpty()){
			remolques = pedidos.get(pedidos.size() - 1).getCliente().getVehiculo().getRemolques();
		}
		return remolques;
	}
	
	public Integer totalServicios(Vehiculo v) {
		Integer servicios =v.getRemolques() + v.getReparaciones();
		return servicios;
	}
}
