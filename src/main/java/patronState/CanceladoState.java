package patronState;

import java.io.Serializable;

import modelo.Ticket;

public class CanceladoState implements IState, Serializable{
	private Ticket ticket;
	private String estado = "CANCELADO";
	
	public CanceladoState(Ticket ticket) {
		super();
		this.ticket = ticket;
	}

	
	public String estadoActual() {
		return estado;
	}
	
	
	
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
