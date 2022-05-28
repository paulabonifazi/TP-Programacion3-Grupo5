package patronState;

public class ActivoState implements IState{
	private Ticket ticket;
	
	
	public ActivoState(Ticket ticket) {
		super();
		this.ticket = ticket;
	}

	@Override
	public void ponerActivo() {
		///si no hace nada se deja vacio?		
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

}
