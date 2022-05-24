package modelo;

public class EstadoTicket {

	private String estadoTicket;

	public EstadoTicket(String estadoTicket) {
		super();
		this.estadoTicket = estadoTicket;
	}
	
	public String getEstado() {
		return estadoTicket;
	}
	
	public void cambiarEstado(String nuevoEstado) {///
		this.estadoTicket=nuevoEstado;
	}
	

}
