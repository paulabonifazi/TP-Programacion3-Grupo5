package modelo;

import java.io.Serializable;

public class EstadoTicket implements Serializable{

	private String estadoTicket;

	public EstadoTicket(String estadoTicket) {
		this.estadoTicket = estadoTicket;
	}
	
	public EstadoTicket() {
		super();
	}

	public String getEstado() {
		return estadoTicket;
	}
	
	public void cambiarEstado(String nuevoEstado) {
		this.estadoTicket=nuevoEstado;
	}
	

}
