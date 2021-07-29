package service;

import java.math.BigDecimal;

import domain.TipoAuxilio;
import domain.TipoReparacion;

public class TipoAuxilioService {
	
	public TipoAuxilio crearTipoAuxilio(String descripcion, TipoReparacion reparacion, boolean necesitaRemolque, BigDecimal costo) {
		return new TipoAuxilio(descripcion, reparacion, necesitaRemolque, costo);
	}

}
