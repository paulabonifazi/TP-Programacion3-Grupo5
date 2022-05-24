package modelo;

import java.util.Date;

public class Ticket
{
	
	protected FormularioBusqueda fbTicket;//no puede ser private porque sino sus clases hijas no pueden acceder!
	protected EstadoTicket estadoTicket;
	
	private Date fechaTicket;
	
	

	public Ticket(FormularioBusqueda fbTicket, EstadoTicket estadoTicket, Date fechaTicket)
	{
		super();
		this.fbTicket = fbTicket;
		this.estadoTicket = estadoTicket;
		this.fechaTicket = fechaTicket;
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
