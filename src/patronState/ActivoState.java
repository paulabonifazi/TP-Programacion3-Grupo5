package patronState;

<<<<<<< Updated upstream
public class ActivoState implements IState{
	private Ticket ticket;
	
	
	public ActivoState(Ticket ticket) {
		super();
		this.ticket = ticket;
	}

=======
import java.io.Serializable;

import modelo.Ticket;

public class ActivoState implements IState, Serializable{
	private Ticket ticket;
	private String estado = "ACTIVO";
	
	public ActivoState(Ticket ticket) {
		this.ticket = ticket;
	}

	
	public String estadoActual() {
		return estado;
	}
	
	
	public Ticket getTicket() {
		return ticket;
	}


	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


>>>>>>> Stashed changes
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
