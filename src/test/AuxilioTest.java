package test;

import service.AuxilioService;
import service.NoPermiteRemolques;
import service.NoPermiteReparaciones;
import service.TipoAuxilioNotFound;

import java.math.BigDecimal;

import domain.TipoCobertura;
import domain.TipoReparacion;
import domain.Pedido;

public class AuxilioTest {

	public static void main(String[] args) {
		AuxilioService auxilioServ = new AuxilioService();
		
		auxilioServ.agregarTipoDeAuxilio("Bateria", TipoReparacion.SIMPLE, false, new BigDecimal(100));
		auxilioServ.agregarTipoDeAuxilio("Choque", TipoReparacion.SIMPLE, false, new BigDecimal(500));
		auxilioServ.agregarTipoDeAuxilio("Pinchadura", TipoReparacion.SIMPLE, true, new BigDecimal(700));
		auxilioServ.agregarTipoDeAuxilio("Daño Motor", TipoReparacion.COMPLEJO, true, new BigDecimal(1000));
		
		try {
			System.out.println("CASO 1: Cliente con cobertura economica realizando un pedido con remolque");
			Pedido pedido_1 = auxilioServ.crearPedido("Gabriel", "Lopez", new BigDecimal(500), "AABBCC", 343.3, "Calle-1", TipoCobertura.ECONOMIC, auxilioServ.getTipoAuxilioPorDescripcion("Daño Motor"));
			auxilioServ.agregarPedido(pedido_1); 
			System.out.println("-------------------------------------");
			
			System.out.println("CASO 2: Cliente con cobertura clasica sin deuda y con un vehiculo menor a 3 tons se le asigna la mini-grua");
			Pedido pedido_2 = auxilioServ.crearPedido("Gabriel", "Lopez", new BigDecimal(5000), "AABBCC", 2050.4, "Calle-2", TipoCobertura.CLASSIC, auxilioServ.getTipoAuxilioPorDescripcion("Daño Motor"));
			auxilioServ.agregarPedido(pedido_2);
			System.out.println("-------------------------------------");
			
			System.out.println("CASO 3: Cliente con cobertura clasica sin deuda y con un vehiculo mayor a 3 tons se le asigna la gran-grua con taller ya que el tipo de reparacion es complejo");
			Pedido pedido_3 = auxilioServ.crearPedido("Carlos", "Martinez", new BigDecimal(10000), "XXYYZZ", 3500.0, "Calle-3", TipoCobertura.CLASSIC, auxilioServ.getTipoAuxilioPorDescripcion("Daño Motor"));
			auxilioServ.agregarPedido(pedido_3);
			auxilioServ.terminarPedido(pedido_3);
			System.out.println("-------------------------------------");
			
			System.out.println("CASO 4: Cliente con cobertura clasica realizando dos pedidos, en el primero queda debiendo 200, al pedir el segundo paga los 200 anteriores pero no le alcanza para cubrir el segundo pedido");
			Pedido pedido_4 = auxilioServ.crearPedido("Alejandro", "Perez", new BigDecimal(1000), "DDEEFF", 2500.0, "Calle-4", TipoCobertura.CLASSIC, auxilioServ.getTipoAuxilioPorDescripcion("Choque"));
			auxilioServ.agregarPedido(pedido_4);
			
			Pedido pedido_5 = auxilioServ.crearPedido("Alejandro", "Perez", new BigDecimal(1000), "DDEEFF", 2500.0, "Calle-5", TipoCobertura.CLASSIC, auxilioServ.getTipoAuxilioPorDescripcion("Choque"));
			auxilioServ.agregarPedido(pedido_5);
			System.out.println("-------------------------------------");
			
			System.out.println("Caso 5:");
			Pedido pedido_6 = auxilioServ.crearPedido("Juanito", "Perez", new BigDecimal(1000), "XXYYZZ", 3500.0, "Calle-6", TipoCobertura.PLATINUM, auxilioServ.getTipoAuxilioPorDescripcion("Pinchadura"));
			auxilioServ.agregarPedido(pedido_6);
			System.out.println("-------------------------------------");
			
		}catch(TipoAuxilioNotFound e) {
			e.getMessage();
		}
			
		
		
		auxilioServ.listaDePedidos();
		//auxilioServ.listaDeTiposDeAuxilio();
	}

}
