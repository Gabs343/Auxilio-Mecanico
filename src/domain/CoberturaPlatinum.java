package domain;

import java.math.BigDecimal;

public class CoberturaPlatinum extends Cobertura{
	public CoberturaPlatinum(Integer limiteRemolque, Integer limiteReparacion,
			TipoReparacion reparacion, boolean remolque, BigDecimal bigDecimal) {
		super(TipoCobertura.PLATINUM, limiteRemolque, limiteReparacion, reparacion, remolque, bigDecimal);
	}
}
