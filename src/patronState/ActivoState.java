package patronState;

import modelo.Ticket;
import paquete.Persona;

public class ActivoState implements IState{
	private Ticket ticket;
	
	public ActivoState(Ticket ticket) {
		this.ticket = ticket;
	}
	
	
	@Override
	public void ponerActivo() {	
	}

	@Override
	public void ponerSuspendido() {
		this.ticket.setEstado(new SuspendidoState(this.ticket));
		
	}

	@Override
	public void ponerCancelado() {
		this.ticket.setEstado(new CanceladoState(this.ticket));		
	}

	@Override
	public void ponerFinalizado() {
		this.ticket.setEstado(new FinalizadoState(this.ticket));	
		
	}

	@Override
	public Ticket ticketDisponible() {
		return this.ticket;
	}

	@Override
	public void actualizarPtj(Persona empl) {
		
	}

}
