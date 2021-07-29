package domain;

public enum TipoCobertura {
	ECONOMIC("Economic"), CLASSIC("Classic"), PLATINUM("Platinum");
	
	private String descripcion;
	
	private TipoCobertura(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
