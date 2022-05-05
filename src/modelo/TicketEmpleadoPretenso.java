package modelo;

import java.util.ArrayList;
import java.util.Date;
import paquete.Empleador; 

public class TicketEmpleadoPretenso extends Ticket
{
	
	private String resultado; 
	private ArrayList<Empleador> empleadoresMatch = null; //lista se que va a cargar en la ronda de encuentros
	

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


