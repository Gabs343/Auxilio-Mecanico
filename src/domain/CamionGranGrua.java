package domain;

import java.math.BigDecimal;

public class CamionGranGrua extends Camion{
	
	public CamionGranGrua(TipoReparacion tipoReparacion, Double limitePeso, BigDecimal costo, boolean tieneTaller) {
		super(TipoCamion.GRAN_GRUA, tipoReparacion, limitePeso, costo, tieneTaller, false);
	}

}
