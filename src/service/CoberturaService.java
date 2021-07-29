package service;

import java.math.BigDecimal;

import domain.Cliente;
import domain.Cobertura;
import domain.CoberturaClassic;
import domain.CoberturaEconomic;
import domain.CoberturaPlatinum;
import domain.TipoReparacion;
import domain.Vehiculo;

public class CoberturaService {
	
	public Cobertura crearCoberturaEconomic() {
		return new CoberturaEconomic(0, 5, TipoReparacion.SIMPLE, false);
	}
	
	public Cobertura crearCoberturaClassic() {
		return new CoberturaClassic(5, 9999, TipoReparacion.COMPLEJO, true);
	}
	
	public Cobertura crearCoberturaPlatinum() {
		return new CoberturaPlatinum(9999, 9999, TipoReparacion.COMPLEJO, true, new BigDecimal(10000));
	}
	
	public boolean permiteReparacion(Cliente cl) {
		
		return  cl.getCobertura().getLimiteReparacion() >= cl.getVehiculo().getReparaciones() ? true : false;
	}
	
	public boolean permiteRemolque(Cliente cl) {
		boolean permite = false;
		if(cl.getCobertura().isRemolque() && cl.getCobertura().getLimiteRemolque() >= cl.getVehiculo().getRemolques()) {
			permite = true;
		}
		return permite;
	}
	
}
