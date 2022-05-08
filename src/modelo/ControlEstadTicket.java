
package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import paquete.EmpleadoPretenso;
import paquete.Empleador;
import tablas.PuntajeTicket;

//*///*/
public class ControlEstadTicket {
	
//TicketFinalizar		
	public void finalizarTickets(ArrayList<ListAsignacionEmpleador> lista) {
		for (int i=0; i<lista.size(); i++) {
			lista.get(i).getEmpleador().getTicket().getEstadoTicket().cambiarEstado("FINALIZADO");
			for (int j=0; j<lista.get(i).getListEmpleadosPretensos().size(); i++)
				lista.get(i).getListEmpleadosPretensos().get(j).getTicket().getEstadoTicket().cambiarEstado("FINALIZADO");
		}
	}

//ticketActivo/Suspendido
	///reveer, que parametros necesito para suspender,o sea el empleado como automanda su referencia, podria mandar directamente el ticket
	public void suspenderTicket (Ticket ticket) {
		if (ticket.getEstadoTicket().getEstado().equals("CANCELADO"))
		{}///LANZAR EXCEPTION
		else
			ticket.getEstadoTicket().cambiarEstado("SUSPENDIDO");
	}
	
	public void activarTicket (Ticket ticket) {
		if (ticket.getEstadoTicket().getEstado().equals("CANCELADO"))
		{}///LANZAR EXCEPTION
		else
			ticket.getEstadoTicket().cambiarEstado("ACTIVO");
	}
		
	

		
		//SE MODIFICA DCESPUES DE LA RONDA DE ENCUENTRO 
		//O A PETICION DEL usuario
		
		
		public String resultado()
		{
			if(this.est == "ACTIVO" || this.est == "SUSPENDIDO")
				this.res = "ESPERA";
			else
				if(this.est == "FINALIZADO")
					this.res = "EXITO";
				else //necesito un contador de rondas sin ser elegidos
					if(this.est == "CANCELADO" || contRondasSinEleccion > 3) 
						this.est = "FRACASO";
			
			return this.est;
			//ver que onda como hacer esto xq el estado necesita el resultado y viceversa
		}
	}



/*
 * analizar para que la agencia se encargue!!
 * terminar métodos!
 */
 