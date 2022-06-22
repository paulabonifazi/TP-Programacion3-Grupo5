package patronState;

<<<<<<< Updated upstream
public class CanceladoState implements IState{
	private Ticket ticket;
	
=======
import java.io.Serializable;

import modelo.Ticket;

public class CanceladoState implements IState, Serializable{
	private Ticket ticket;
	private String estado = "CANCELADO";
>>>>>>> Stashed changes
	
	public CanceladoState(Ticket ticket) {
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
		
		
	}

	@Override
	public void ponerSuspendido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ponerCancelado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ponerFinalizado() {
		// TODO Auto-generated method stub
		
	}

}
