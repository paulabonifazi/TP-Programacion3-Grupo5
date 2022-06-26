package state;

import java.io.Serializable;

import paquete.EmpleadoPretenso;
import paquete.Persona;
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
