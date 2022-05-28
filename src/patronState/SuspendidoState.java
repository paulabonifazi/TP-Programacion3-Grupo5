package patronState;

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
		
	}

	@Override
	public void ponerFinalizado() {
		
	}

}
