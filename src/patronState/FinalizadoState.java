package patronState;

<<<<<<< Updated upstream
public class FinalizadoState implements IState{
	private Ticket ticket;
	
=======
import java.io.Serializable;

import modelo.Ticket;

public class FinalizadoState implements IState, Serializable{
	private Ticket ticket;
	private String estado = "FINALIZADO";
>>>>>>> Stashed changes
	
	public FinalizadoState(Ticket ticket) {
		super();
		this.ticket = ticket;
	}

<<<<<<< Updated upstream
	@Override
	public void ponerActivo() {
		
		
=======
	
	public String estadoActual() {
		return estado;
	}
	
	
	@Override
	public void ponerActivo() {

>>>>>>> Stashed changes
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
