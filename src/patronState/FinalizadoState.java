package patronState;

import java.io.Serializable;

import modelo.Ticket;
import paquete.EmpleadoPretenso;
import paquete.Persona;

public class FinalizadoState implements IState{
	private Ticket ticket;
	
	public FinalizadoState(Ticket ticket) {
		super();
		this.ticket = ticket;
	}

	
	@Override
	public void ponerActivo() {
		System.out.println("No corresponde el cambio de estado");
	}

	@Override
	public void ponerSuspendido() {
		System.out.println("No corresponde el cambio de estado");
	}

	@Override
	public void ponerCancelado() {
		System.out.println("No corresponde el cambio de estado");
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
	/*	if (emp.getNombUsuario()=="si es empleador")
			emp.setPuntajeUsuario(50);*/
	}

}
