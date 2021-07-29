package domain;

public class Vehiculo {
	private String patente;
	private Double peso;
	private Integer reparaciones;
	private Integer remolques;
	
	
	public Vehiculo(String patente, Double peso) {
		this.patente = patente;
		this.peso = peso;
		this.reparaciones = 0;
		this.remolques = 0;
	}
	
	public String getPatente() {
		return patente;
	}
	
	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	public Double getPeso() {
		return peso;
	}
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public Integer getReparaciones() {
		return reparaciones;
	}
	
	public void setReparaciones(Integer reparaciones) {
		this.reparaciones = reparaciones;
	}
	
	public Integer getRemolques() {
		return remolques;
	}
	
	public void setRemolques(Integer remolques) {
		this.remolques = remolques;
	}

	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + ", peso=" + peso + ", reparaciones=" + reparaciones + ", remolques="
				+ remolques + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patente == null) ? 0 : patente.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
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
		Vehiculo other = (Vehiculo) obj;
		if (patente == null) {
			if (other.patente != null)
				return false;
		} else if (!patente.equals(other.patente))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		return true;
	}
	
	

}
