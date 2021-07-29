package domain;

public class CoberturaEconomic extends Cobertura{

	public CoberturaEconomic(Integer limiteRemolque, Integer limiteReparacion,
			TipoReparacion reparacion, boolean remolque) {
		super(TipoCobertura.ECONOMIC, limiteRemolque, limiteReparacion, reparacion, remolque);
	}
	
}
