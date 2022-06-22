package patronState;

<<<<<<< Updated upstream
public class SuspendidoState implements IState{
	private Ticket ticket;
	
=======
import java.io.Serializable;

import modelo.Ticket;

public class SuspendidoState implements IState, Serializable{
	private Ticket ticket;
	private String estado = "SUSPENDIDO";
>>>>>>> Stashed changes
	
	public SuspendidoState(Ticket ticket) {
		super();
		this.ticket = ticket;
	}

<<<<<<< Updated upstream
=======
	
	
	public String estadoActual() {
		return estado;
	}



>>>>>>> Stashed changes
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
