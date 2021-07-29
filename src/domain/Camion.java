package domain;

import java.math.BigDecimal;

public abstract class Camion {
	
	private TipoCamion tipoCamion;
	private TipoReparacion tipoReparacion;
	private Double limitePeso;
	private BigDecimal costo;
	private boolean tieneTaller;
	private boolean ocupado;
	
	public Camion(TipoCamion tipoCamion, TipoReparacion tipoReparacion, Double limitePeso, BigDecimal costo, boolean tieneTaller, boolean ocupado) {
		
		this.tipoCamion = tipoCamion;
		this.tipoReparacion = tipoReparacion;
		this.limitePeso = limitePeso;
		this.costo = costo;
		this.tieneTaller = tieneTaller;
		this.ocupado = ocupado;
	}

	public TipoCamion getTipoCamion() {
		return tipoCamion;
	}
	
	public void setTipoCamion(TipoCamion tipoCamion) {
		this.tipoCamion = tipoCamion;
	}
	
	public TipoReparacion getTipoReparacion() {
		return tipoReparacion;
	}

	public void setTipoReparacion(TipoReparacion tipoReparacion) {
		this.tipoReparacion = tipoReparacion;
	}

	public Double getLimitePeso() {
		return limitePeso;
	}
	
	public void setLimitePeso(Double limitePeso) {
		this.limitePeso = limitePeso;
	}
	
	public BigDecimal getCosto() {
		return costo;
	}
	
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}
	
	public boolean isTieneTaller() {
		return tieneTaller;
	}
	
	public void setTieneTaller(boolean tieneTaller) {
		this.tieneTaller = tieneTaller;
	}
	
	public boolean isOcupado() {
		return ocupado;
	}
	
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	
	@Override
	public String toString() {
		return "Camion [tipoCamion=" + tipoCamion + ", limitePeso=" + limitePeso + ", costo=" + costo + ", tieneTaller="
				+ tieneTaller + ", ocupado=" + ocupado + "]";
	}
	
	

}
