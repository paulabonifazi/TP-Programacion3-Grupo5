package modelo;

import java.util.Observable;

public class EstadoTicket  extends Observable
{

	private String estadoTicket;

	public EstadoTicket(String estadoTicket) {
		super();
		this.estadoTicket = estadoTicket;
	}
	
	public String getEstado() {
		return estadoTicket;
	}
	
	public void cambiarEstado(String nuevoEstado) {
		this.estadoTicket=nuevoEstado;
	}
	

}
