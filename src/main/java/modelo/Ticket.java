package modelo;

import java.util.Date;
import java.util.GregorianCalendar;

import modelo.FormularioBusqueda;
import patronState.ActivoState;
import patronState.IState;
import patronState.SuspendidoState;

public class Ticket 
{
	
	private FormularioBusqueda fbTicket;
	private IState estado = new ActivoState(this) ;
	
	private Date fechaTicket;
	
	
	public Ticket()
	{
	}
	
	public Ticket(FormularioBusqueda fbTicket, Date fechaTicket)
	{
		this.fbTicket = fbTicket;
		
		this.fechaTicket = fechaTicket;
		
	}

	
	public FormularioBusqueda getFbTicket() {
		return fbTicket;
	}


	public Date getFechaTicket() {
		return fechaTicket;
	}
	
	
	
	public void setFbTicket(FormularioBusqueda fbTicket) {
		this.fbTicket = fbTicket;
	}

	public void setFechaTicket(Date fechaTicket) {
		this.fechaTicket = fechaTicket;
	}


	public IState getEstado() {
		return estado;
	}


	public void setEstado(IState estado) {
		this.estado = estado;
	}
	
	
	
}
