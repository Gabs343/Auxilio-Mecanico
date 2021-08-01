package service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Auxilio;
import domain.Camion;
import domain.Vehiculo;
import domain.Cliente;
import domain.Pedido;
import domain.TipoAuxilio;
import domain.TipoCamion;
import domain.TipoCobertura;
import domain.Cobertura;
import domain.TipoReparacion;

public class AuxilioService {
	private Auxilio auxilio;
	private CoberturaService coberturaServ;
	private PedidoService pedidoServ;
	private ClienteService clienteServ;
	private VehiculoService vehiculoServ;
	private TipoAuxilioService tipoAuxilioServ;
	private PagoService pagoServ;
	private CamionService camionServ;
	
	public AuxilioService() {
		auxilio = new Auxilio();
		coberturaServ = new CoberturaService();
		pedidoServ = new PedidoService();
		clienteServ = new ClienteService();
		vehiculoServ = new VehiculoService();
		tipoAuxilioServ = new TipoAuxilioService();
		pagoServ = new PagoService();
		camionServ = new CamionService();
	}
	
	public void agregarPedido(Pedido p){
		
		try {
			if(p.getTipoAuxilio().isNecesitaRemolque()) {
				vehiculoServ.sumarRemolques(p.getCliente().getVehiculo(), pedidoServ.pedidosDeCliente(p.getCliente(), auxilio.getPedidos()));
				
				if(coberturaServ.permiteRemolque(p.getCliente())) {
		
					responderConCamion(p);
					
					if(p.getCliente().getCobertura().getTipoCobertura() != TipoCobertura.PLATINUM) {
						pagoServ.pagoPedido(p, pedidoServ.pedidosSinPagarDeCliente(p.getCliente(), auxilio.getPedidos()));
					}
					
					p.getCliente().getVehiculo().setReparaciones(vehiculoServ.getTotalReparaciones(p.getCliente().getVehiculo(), pedidoServ.pedidosDeCliente(p.getCliente(), auxilio.getPedidos())));
					auxilio.addPedido(p);
					
					camionServ.añadirPedido(p.getCamion(), p);
					
				}else {
					throw new NoPermiteRemolques("No se aceptan remolques");
				}
			}else {
				vehiculoServ.sumarReparaciones(p.getCliente().getVehiculo(), pedidoServ.pedidosDeCliente(p.getCliente(), auxilio.getPedidos()));
				
				if(coberturaServ.permiteReparacion(p.getCliente())) {
					
					responderConCamion(p);
					
					if(p.getCliente().getCobertura().getTipoCobertura() != TipoCobertura.PLATINUM) {
						pagoServ.pagoPedido(p, pedidoServ.pedidosSinPagarDeCliente(p.getCliente(), auxilio.getPedidos()));
					}
					
					p.getCliente().getVehiculo().setRemolques(vehiculoServ.getTotalRemolques(p.getCliente().getVehiculo(), pedidoServ.pedidosDeCliente(p.getCliente(), auxilio.getPedidos())));
					auxilio.addPedido(p);
					
					camionServ.añadirPedido(p.getCamion(), p);
					
				}else {
					throw new NoPermiteReparaciones("No se aceptan reparaciones");	
				}
			}
		}catch(NoPermiteReparaciones e) {
			System.out.println(e.getMessage());
		}catch(NoPermiteRemolques e) {
			System.out.println(e.getMessage());
		}catch(DineroInsuficiente e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public Pedido crearPedido(String nombre, String apellido, BigDecimal dinero, String patente, Double peso, String lugar, TipoCobertura tipoCobertura, TipoAuxilio tipoAuxilio) {
		Vehiculo vehiculo = vehiculoServ.crearVehiculo(patente, peso);
		Cobertura cobertura = getCoberturaByTipo(tipoCobertura);

		Cliente cliente = clienteServ.crearCliente(nombre, apellido, vehiculo, cobertura, dinero);
		
		return pedidoServ.crearPedido(lugar, cliente, tipoAuxilio);
	}
	
	public void responderConCamion(Pedido p) {
		
		TipoCamion tipoCamion = getTipoCamionByPedido(p);
		Camion camion = getCamionByTipo(tipoCamion, p.getTipoAuxilio().getReparacion());
		
		if(!pedidoServ.getPedidosByCamion(camion, auxilio.getPedidos()).isEmpty()) {

			camionServ.añadirPedidos(camion, pedidoServ.getPedidosByCamion(camion, pedidoServ.getPedidosNoFinalizados(auxilio.getPedidos())));
		}
	
		pedidoServ.añadirCamion(p, camion);
		pedidoServ.actualizarCosto(p, camion.getCosto());
		
	}	
	
	protected Cobertura getCoberturaByTipo(TipoCobertura tipoCobertura) {
		Cobertura cobertura = null;
		if (TipoCobertura.ECONOMIC == tipoCobertura) {
			cobertura = coberturaServ.crearCoberturaEconomic();
		}else if(TipoCobertura.CLASSIC == tipoCobertura){
			cobertura = coberturaServ.crearCoberturaClassic();
		}else {
			cobertura = coberturaServ.crearCoberturaPlatinum();
		}
		return cobertura;
	}
	
	protected TipoCamion getTipoCamionByPedido(Pedido p) {
		TipoCamion tipoCamion = null;
		if(!p.getTipoAuxilio().isNecesitaRemolque() && p.getTipoAuxilio().getReparacion() == TipoReparacion.SIMPLE) {
			tipoCamion = TipoCamion.MINI_TALLER;
		}else if(p.getTipoAuxilio().isNecesitaRemolque() &&
				p.getCliente().getVehiculo().getPeso() <= 3000) {
			tipoCamion = TipoCamion.MINI_GRUA;
		}else{
			tipoCamion = TipoCamion.GRAN_GRUA;
		}
		
		return tipoCamion;
	}
	
	protected Camion getCamionByTipo(TipoCamion tipoCamion, TipoReparacion tipoReparacion) {
		Camion camion = null;
		if(TipoCamion.MINI_TALLER == tipoCamion) {
			camion = camionServ.crearCamionMiniTaller();
		}else if(TipoCamion.MINI_GRUA == tipoCamion) {
			camion = camionServ.crearCamionMiniGrua();
		}else if(TipoCamion.GRAN_GRUA == tipoCamion) {
			if(TipoReparacion.COMPLEJO == tipoReparacion) {
				camion = camionServ.crearCamionGranGruaConTaller(tipoReparacion);
			}else {
				camion = camionServ.crearCamionGranGrua(tipoReparacion);
			}
			
		}
		
		return camion;
	}
	
	public void agregarTipoDeAuxilio(String descripcion, TipoReparacion reparacion, boolean necesitaRemolque, BigDecimal costo) {
		TipoAuxilio auxilioDisponible = tipoAuxilioServ.crearTipoAuxilio(descripcion, reparacion, necesitaRemolque, costo);
		auxilio.addTipoAuxilio(auxilioDisponible);
		
	}
	
	public TipoAuxilio getTipoAuxilioPorDescripcion(String descripcion) throws TipoAuxilioNotFound{
		TipoAuxilio tipoAuxilio = null;
		
		for(TipoAuxilio tipoAuxilios : auxilio.getTiposDeAuxilios()) {
			if(tipoAuxilios.getDescripcion().equals(descripcion)) {
				Integer index = auxilio.getTiposDeAuxilios().indexOf(tipoAuxilios);
				tipoAuxilio = auxilio.getTiposDeAuxilios().get(index);
			}
		}
			
		if(tipoAuxilio == null) {
			throw new TipoAuxilioNotFound("Tipo de auxilio no encontrado");
		}
		
		return tipoAuxilio;
		
	}
	
	public void terminarPedido(Pedido p) {
		pedidoServ.setStatus(p, true);
		camionServ.eliminarPedido(p.getCamion(), p);
		System.out.println("Se ha finalizado el pedido del cliente: " + p.getCliente().getNombre() + " " + p.getCliente().getApellido());
	}
	
	public void listaDePedidos() {
		auxilio.getPedidos().stream().forEach(p -> System.out.println(p.toString()));
	}
	
	public void listaDeTiposDeAuxilio() {
		auxilio.getTiposDeAuxilios().stream().forEach(tAux -> System.out.println(tAux.toString()));
	}

}
