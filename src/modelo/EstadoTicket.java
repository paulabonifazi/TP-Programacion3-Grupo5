package modelo;

public class EstadoTicket {///como consulto el estado para las comparaciones, no veo necesario mandarlo con el FB

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
