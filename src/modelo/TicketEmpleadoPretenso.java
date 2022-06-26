package modelo;

import java.util.ArrayList;
import java.util.Date;
import paquete.Empleador; 

public class TicketEmpleadoPretenso extends Ticket
{
	
	private String resultado; 

	public TicketEmpleadoPretenso(FormularioBusqueda fbTicket, Date fechaTicket) 
	{
		super(fbTicket, fechaTicket);
		this.resultado = "Iniciado";
	}
	

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	public String getResultado() {
		return resultado;
	}


}


