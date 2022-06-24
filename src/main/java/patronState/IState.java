package patronState;

import java.io.Serializable;

import modelo.EmpleadoPretenso;
import modelo.Persona;
import modelo.Ticket;

public interface IState extends Serializable{
	//cuando no corresponda el cambio -> exception 
		void ponerActivo();
		void ponerSuspendido();
		void ponerCancelado();
		void ponerFinalizado();
		Ticket ticketDisponible();
		void actualizarPtj(Persona empl);
}
