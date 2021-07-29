package domain;

import java.math.BigDecimal;

public class CamionMiniTaller extends Camion{
	
	public CamionMiniTaller(Double limitePeso, BigDecimal costo) {
		super(TipoCamion.MINI_TALLER, TipoReparacion.SIMPLE, limitePeso, costo, false, false);
	}
}
