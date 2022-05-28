package patronState;

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
