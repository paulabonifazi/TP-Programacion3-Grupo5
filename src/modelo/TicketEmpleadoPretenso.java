package modelo;

import java.util.Date;

public class TicketEmpleadoPretenso extends Ticket
{
	
	private String resultado; 
	

	public TicketEmpleadoPretenso(FormularioBusqueda fbTicket, EstadoTicket estadoTicket, Date fechaTicket,
			String resultado) 
	{
		super(fbTicket, estadoTicket, fechaTicket);
		this.resultado = resultado;
	}




	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	public String getResultado() {
		return resultado;
	}


}


