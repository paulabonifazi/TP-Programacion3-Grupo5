package state;

import java.io.Serializable;

import paquete.EmpleadoPretenso;
import paquete.Persona;
import modelo.Ticket;

public class FinalizadoState implements IState{
	private Ticket ticket;
	
	public FinalizadoState(Ticket ticket) {
		super();
		this.ticket = ticket;
	}

	
	@Override
	public void ponerActivo() {

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


	@Override
	public Ticket ticketDisponible() {
		return null;
	}


	@Override
	public void actualizarPtj(Persona emp) {
		emp.setPuntajeUsuario(10);
		if (emp.getNombUsuario()=="si es empleador")
			emp.setPuntajeUsuario(50);
	}

}
