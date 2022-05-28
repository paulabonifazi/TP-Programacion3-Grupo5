package patronState;

import java.util.Date;
import java.util.GregorianCalendar;

import modelo.FormularioBusqueda;

public class Ticket 
{
	
	private FormularioBusqueda fbTicket;
	private IState estado;
	
	private GregorianCalendar fechaTicket;
	
	

	public Ticket(FormularioBusqueda fbTicket, GregorianCalendar fechaTicket)
	{
		super();
		this.fbTicket = fbTicket;
		this.estado = new SuspendidoState(this);
		this.fechaTicket = fechaTicket;
	}

	
	public FormularioBusqueda getFbTicket() {
		return fbTicket;
	}


	public GregorianCalendar getFechaTicket() {
		return fechaTicket;
	}
	
	
	
	public void ponerActivo() {
		this.estado.ponerActivo();		
	}
	public void ponerSuspendido() {
		this.estado.ponerSuspendido();
	}
	public void ponerCancelado(){
		this.estado.ponerCancelado();
	}
	public void ponerFinalizado(){
		this.estado.ponerFinalizado();
	}


	public void setEstado(IState estado) {
		this.estado = estado;
	}
	
	
	
}
