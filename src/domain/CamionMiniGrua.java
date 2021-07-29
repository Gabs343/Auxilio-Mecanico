package domain;

import java.math.BigDecimal;

public class CamionMiniGrua extends Camion{
	
	public CamionMiniGrua(Double limitePeso, BigDecimal costo) {
		super(TipoCamion.MINI_GRUA, TipoReparacion.SIMPLE, limitePeso, costo, false, false);
	}
}
