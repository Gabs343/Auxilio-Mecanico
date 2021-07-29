package service;

public class NoPermiteReparaciones extends Exception{
	NoPermiteReparaciones(String mensaje){
		super(mensaje);
	}
}
