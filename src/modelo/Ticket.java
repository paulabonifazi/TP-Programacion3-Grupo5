package modelo;

import java.util.Date;

public class Ticket {
	
	protected FormularioBusqueda fbTicket;//ver si private
	protected EstadoTicket estadoTicket;
	
	private Date fechaTicket;
	
	public Ticket() {
		super();
	}

	public void generarTicket(String locacion, String remuneracion, String cargaHoraria, String tipoPuesto,
			String rangoEtario, String experienciaPrevia, String estudiosCursados) {
		
		fbTicket = new FormularioBusqueda(null, null, null, null, null, null, null);
		estadoTicket = new EstadoTicket(null);
		fechaTicket = new Date();
		 
	}
	
	public FormularioBusqueda getFbTicket() {
		return fbTicket;
	}

	public EstadoTicket getEstadoTicket() {
		return estadoTicket;
	}

	public Date getFechaTicket() {
		return fechaTicket;
	}
	
	
	
	

}
