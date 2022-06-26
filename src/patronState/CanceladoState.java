package patronState;

import modelo.Ticket;
import paquete.Persona;

public class CanceladoState implements IState{
	private Ticket ticket;
	
	public CanceladoState(Ticket ticket) {
		super();
		this.ticket = ticket;
	}
	

	@Override
	public void ponerActivo() {
		System.out.println("No corresponde el cambio de estado");
	}

	@Override
	public void ponerSuspendido() {
		System.out.println("No corresponde el cambio de estado");
	}

	@Override
	public void ponerCancelado() {
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
		empl.setPuntajeUsuario(-1);
		
	}

}
