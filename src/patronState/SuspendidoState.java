package patronState;

import modelo.Ticket;
import paquete.Persona;

public class SuspendidoState implements IState{
	private Ticket ticket;
	
	public SuspendidoState(Ticket ticket) {
		super();
		this.ticket = ticket;
	}

	@Override
	public void ponerActivo() {
		this.ticket.setEstado(new ActivoState(this.ticket));				
	}

	@Override
	public void ponerSuspendido() {	
	}

	@Override
	public void ponerCancelado() {
		this.ticket.setEstado(new CanceladoState(this.ticket));
	}

	@Override
	public void ponerFinalizado() {
		System.out.println("No corresponde el cambio de estado");
	}

	@Override
	public Ticket ticketDisponible() {
		return null;
	}

	@Override
	public void actualizarPtj(Persona empl) {
		
	}

}
