package state;

import paquete.Persona;
import modelo.Ticket;

public class CanceladoState implements IState{
	private Ticket ticket;
	
	public CanceladoState(Ticket ticket) {
		super();
		this.ticket = ticket;
	}


	@Override
	public void ponerActivo() {
		
	}

	@Override
	public void ponerSuspendido() {
		
	}

	@Override
	public void ponerCancelado() {
		
	}

	@Override
	public void ponerFinalizado() {
		
	}

	@Override
	public Ticket ticketDisponible() {
		return null;
	}


	@Override
	public void actualizarPtj(Persona empl) {
		empl.setPuntajeUsuario(-1);
		
	}

}
