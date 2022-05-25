
package modelo;

import java.util.ArrayList;

import excepciones.TicketCanceladoException;

public class ControlEstadosTicket {
	
//TicketFinalizar		
	public void finalizarTickets(ArrayList<ListAsignacionEmpleador> lista) {
		for (int i=0; i<lista.size(); i++) {
			if (lista.get(i).getEmpleador().getTicket().getCantEmpleadosObtenidos() == lista.get(i).getEmpleador().getTicket().getCantEmpleadosSolicitados())
				lista.get(i).getEmpleador().getTicket().getEstadoTicket().cambiarEstado("Finalizado");
			for (int j=0; j<lista.get(i).getListEmpleadosPretensos().size(); i++)
				lista.get(i).getListEmpleadosPretensos().get(j).getTicket().getEstadoTicket().cambiarEstado("FINALIZADO");
		}
	}

//ticketActivo/Suspendido

	public void suspenderTicket (Ticket ticket) throws TicketCanceladoException {
		if (ticket.getEstadoTicket().getEstado().equals("Cancelado"))
			throw new TicketCanceladoException("Ticket cancelado");
		else
			ticket.getEstadoTicket().cambiarEstado("Suspendido");
	}
	
	public void activarTicket (Ticket ticket) throws TicketCanceladoException {
		if (ticket.getEstadoTicket().getEstado().equals("Cancelado"))
			throw new TicketCanceladoException("Ticket cancelado");
		else
			ticket.getEstadoTicket().cambiarEstado("Activo");
	}
		
		//SE MODIFICA DCESPUES DE LA RONDA DE ENCUENTRO 
		//O A PETICION DEL usuario
		
		//el resultado esta en INICIADO cuando se crea el ticket
		public String resultadoTicketEP(TicketEmpleadoPretenso ticket)
		{
			String estado = null; 
			if(ticket.getEstadoTicket().getEstado().equals("Finalizado")) //exito
				estado = "Exito";
			else
				if(ticket.getEstadoTicket().getEstado().equals("Cancelado"))//fracaso
					estado = "Fracaso";	
			
			return estado;
			//ver que onda como hacer esto xq el estado necesita el resultado y viceversa
		}
	}


