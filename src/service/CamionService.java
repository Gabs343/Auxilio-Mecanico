package service;

import java.math.BigDecimal;

import domain.Camion;
import domain.CamionGranGrua;
import domain.CamionMiniGrua;
import domain.CamionMiniTaller;
import domain.Cliente;
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
	
	
	
}
