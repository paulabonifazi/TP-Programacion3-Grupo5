package patronState;

import java.io.Serializable;

import modelo.Ticket;

public class SuspendidoState implements IState, Serializable{
	private Ticket ticket;
	private String estado = "SUSPENDIDO";
	
	public SuspendidoState(Ticket ticket) {
		super();
		this.ticket = ticket;
	}

	
	
	public String estadoActual() {
		return estado;
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
		
	}

	@Override
	public void ponerFinalizado() {
		
	}

}
