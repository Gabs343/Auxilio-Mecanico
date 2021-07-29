package domain;

public enum TipoReparacion {
	NINGUNO("Ninguno"), SIMPLE("Simple"), COMPLEJO("Complejo");
	
	private String nombre;

	private TipoReparacion(String nombre) { this.nombre = nombre; }
	
	public String getNombre() { return nombre; }
}
