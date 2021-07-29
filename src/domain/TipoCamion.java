package domain;

public enum TipoCamion {
	MINI_TALLER("Mini_Taller"), MINI_GRUA("MMINI_GRUA"), GRAN_GRUA("Gran_Grua");
	
	private String camion;
	
	private TipoCamion(String camion) {
		this.camion = camion;
	}
	
	public String getCamion() {
		return camion;
	}
}
