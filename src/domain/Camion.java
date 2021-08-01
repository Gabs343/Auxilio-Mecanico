package domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public abstract class Camion {
	
	private TipoCamion tipoCamion;
	private TipoReparacion tipoReparacion;
	private Double limitePeso;
	private BigDecimal costo;
	private boolean tieneTaller;
	private boolean ocupado;
	private List<Pedido> pedidos;
	
	public Camion(TipoCamion tipoCamion, TipoReparacion tipoReparacion, Double limitePeso, BigDecimal costo, boolean tieneTaller, boolean ocupado) {
		
		this.tipoCamion = tipoCamion;
		this.tipoReparacion = tipoReparacion;
		this.limitePeso = limitePeso;
		this.costo = costo;
		this.tieneTaller = tieneTaller;
		this.ocupado = ocupado;
		pedidos = new ArrayList<Pedido>();
	}

	public TipoCamion getTipoCamion() {
		return tipoCamion;
	}
	
	public void setTipoCamion(TipoCamion tipoCamion) {
		this.tipoCamion = tipoCamion;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void setPedido(Pedido p) {
		pedidos.add(p);
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
				+ tieneTaller + ", ocupado=" + ocupado + ", pedidos=" + pedidos.size() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipoCamion == null) ? 0 : tipoCamion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camion other = (Camion) obj;
		if (tipoCamion != other.tipoCamion)
			return false;
		return true;
	}
	
	

}
