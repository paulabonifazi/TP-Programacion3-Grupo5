package modelo;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Observable;

import modelo.FormularioBusqueda;
import paquete.Persona;
import patronState.ActivoState;
import patronState.IState;
import patronState.SuspendidoState;

public class Ticket extends Observable
{
	
	private FormularioBusqueda fbTicket;
	protected IState estado = new ActivoState(this) ;
	
	private Date fechaTicket;
	
	
	
	public Ticket(FormularioBusqueda fbTicket, Date fechaTicket)
	{
		this.fbTicket = fbTicket;
	
		this.fechaTicket = fechaTicket;
		
	}

	public Ticket()
	{
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
	
	public void ponerActivo() {
		this.estado.ponerActivo();
	}

	
	public void ponerSuspendido() {
		this.estado.ponerSuspendido();
	}

	
	public void ponerCancelado() {
		this.estado.ponerCancelado();
	}

	
	public void ponerFinalizado() {
		this.estado.ponerFinalizado();
	}
}
