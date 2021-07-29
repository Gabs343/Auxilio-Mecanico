package domain;

public class CoberturaClassic extends Cobertura{
	public CoberturaClassic(Integer limiteRemolque, Integer limiteReparacion,
			TipoReparacion reparacion, boolean remolque) {
		super(TipoCobertura.CLASSIC, limiteRemolque, limiteReparacion, reparacion, remolque);
	}
}
