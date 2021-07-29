package domain;

import java.math.BigDecimal;

public class TipoAuxilio {
	private String descripcion;
	private TipoReparacion reparacion;
	private boolean necesitaRemolque;
	private BigDecimal costo;
	
	public TipoAuxilio (String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoAuxilio(String descripcion, TipoReparacion reparacion, boolean necesitaRemolque, BigDecimal costo) {
		this.descripcion = descripcion;
		this.reparacion = reparacion;
		this.necesitaRemolque = necesitaRemolque;
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public TipoReparacion getReparacion() {
		return reparacion;
	}
	
	public void setReparacion(TipoReparacion reparacion) {
		this.reparacion = reparacion;
	}
	
	public boolean isNecesitaRemolque() {
		return necesitaRemolque;
	}
	
	public void setNecesitaRemolque(boolean necesitaRemolque) {
		this.necesitaRemolque = necesitaRemolque;
	}
	
	public BigDecimal getCosto() {
		return costo;
	}
	
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "TipoAuxilio [descripcion=" + descripcion + ", reparacion=" + reparacion + ", necesitaRemolque="
				+ necesitaRemolque + ", costo=" + costo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
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
		TipoAuxilio other = (TipoAuxilio) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}
	
	
	
	
	
	
}
