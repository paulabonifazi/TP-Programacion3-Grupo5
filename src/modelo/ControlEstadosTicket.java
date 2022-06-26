
package modelo;

import java.util.ArrayList;

public class ControlEstadosTicket {
//	suspenderTicket();lista.get(i).getEmpleador().getTicket().getEstado().ponerCancelado();
//TicketFinalizar		
	public void finalizarTickets(ArrayList<ListAsignacionEmpleador> lista) {
		for (int i=0; i<lista.size(); i++) {
			if (lista.get(i).getEmpleador().getTicket().getCantEmpleadosObtenidos() == lista.get(i).getEmpleador().getTicket().getCantEmpleadosSolicitados())
				lista.get(i).getEmpleador().getTicket().ponerFinalizado();
			for (int j=0; j<lista.get(i).getListEmpleadosPretensos().size(); j++) 
				lista.get(i).getListEmpleadosPretensos().get(j).getTicket().ponerFinalizado();
		}
	}

//ticketActivo/Suspendido

	public static void suspenderTicket (Ticket ticket) {
		ticket.ponerSuspendido();
	}
	
	public static void activarTicket (Ticket ticket) {
		ticket.ponerActivo();
	}
		
	//SE MODIFICA DCESPUES DE LA RONDA DE ENCUENTRO 
	//O A PETICION DEL usuario
	
	//el resultado esta en INICIADO cuando se crea el ticket
/*	public String resultadoTicketEP(TicketEmpleadoPretenso ticket)
	{
		String estado = null; 
		if(ticket.getEstadoTicket().getEstado().equals("FINALIZADO")) //exito
			estado = "EXITO";
		else
			if(ticket.getEstadoTicket().getEstado().equals("CANCELADO"))//fracaso
				estado = "FRACASO";	
		
		return estado;
	}*/
	}


