package domain;
import java.math.BigDecimal;

public class Pedido {
	private String lugar;
	private Cliente cliente;
	private TipoAuxilio tipoAuxilio;
	private Camion camion;
	private boolean pagado;
	private boolean finalizado;
	private BigDecimal costo;
	
	public Pedido(String lugar, Cliente cliente, TipoAuxilio tipoAuxilio, BigDecimal costo) {
		this.lugar = lugar;
		this.cliente = cliente;
		this.tipoAuxilio = tipoAuxilio;
		this.costo = costo;
		pagado = false;
	}

	public String getLugar() {
		return lugar;
	}
	
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public TipoAuxilio getTipoAuxilio() {
		return tipoAuxilio;
	}
	
	public void setTipoAxulio(TipoAuxilio tipoAuxilio) {
		this.tipoAuxilio = tipoAuxilio;
	}
	
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}
	
	public BigDecimal getCosto() {
		return costo;
	}
	
	public boolean getPagado() {
		return pagado;
	}
	
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	
	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Camion getCamion() {
		return camion;
	}

	public void setCamion(Camion camion) {
		this.camion = camion;
	}

	@Override
	public String toString() {
		return "Pedido [lugar=" + lugar + ", cliente=" + cliente + ", tipoAuxilio=" + tipoAuxilio + ", camion=" + camion
				+ ", pagado=" + pagado + ", finalizado=" + finalizado + ", costo=" + costo + "]";
	}

	

	
	
	
}
