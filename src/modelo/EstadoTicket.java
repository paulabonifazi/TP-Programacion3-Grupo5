package modelo;

public class EstadoTicket {///como consulto el estado para las comparaciones, no veo necesario mandarlo con el FB
			///tiene sentido un double dispatch?

	private String estadoTicket;

	public EstadoTicket(String estadoTicket) {
		super();
		this.estadoTicket = estadoTicket;
	}
	
	public String getEstadoTicket() {
		return estadoTicket;
	}
	
	public void cambiarEstado(String nuevoEstado) {///
		this.estadoTicket=nuevoEstado;
	}
	

}
