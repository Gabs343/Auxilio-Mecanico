package domain;

import java.math.BigDecimal;

public abstract class Cobertura {
	private TipoCobertura cobertura;
	private Integer limiteRemolque;
	private Integer limiteReparacion;
	private TipoReparacion reparacion;
	private BigDecimal costo;
	private boolean remolque;
	
	public Cobertura(TipoCobertura cobertura, Integer limiteRemolque, Integer limiteReparacion, TipoReparacion reparacion,
			boolean remolque, BigDecimal costo) {
		
		this.cobertura = cobertura;
		this.limiteRemolque = limiteRemolque;
		this.limiteReparacion = limiteReparacion;
		this.reparacion = reparacion;
		this.remolque = remolque;
		this.costo = costo;
	}
	
	public Cobertura(TipoCobertura cobertura, Integer limiteRemolque, Integer limiteReparacion, TipoReparacion reparacion,
			boolean remolque) {
		
		this.cobertura = cobertura;
		this.limiteRemolque = limiteRemolque;
		this.limiteReparacion = limiteReparacion;
		this.reparacion = reparacion;
		this.remolque = remolque;
	}
	
	public void setCobertura(TipoCobertura cobertura) {
		this.cobertura = cobertura;
	}
	
	public TipoCobertura getTipoCobertura() {
		return cobertura;
	}
	
	public Integer getLimiteRemolque() {
		return limiteRemolque;
	}
	
	public void setLimiteRemolque(Integer limiteRemolque) {
		this.limiteRemolque = limiteRemolque;
	}
	
	public Integer getLimiteReparacion() {
		return limiteReparacion;
	}
	
	public void setLimiteReparacion(Integer limiteReparacion) {
		this.limiteReparacion = limiteReparacion;
	}
	
	public TipoReparacion getReparacion() {
		return reparacion;
	}
	
	public void setReparacion(TipoReparacion reparacion) {
		this.reparacion = reparacion;
	}
	
	public boolean isRemolque() {
		return remolque;
	}
	
	public void setRemolque(boolean remolque) {
		this.remolque = remolque;
	}

	@Override
	public String toString() {
		return "Cobertura [cobertura=" + cobertura + ", limiteRemolque=" + limiteRemolque + ", limiteReparacion="
				+ limiteReparacion + ", reparacion=" + reparacion + ", remolque=" + remolque + "]";
	}
	
	
	
}
