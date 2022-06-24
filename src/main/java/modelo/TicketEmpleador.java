package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class TicketEmpleador extends Ticket 
{	
	private int cantEmpleadosSolicitados;
	private int cantEmpleadosObtenidos;
	
	public TicketEmpleador(FormularioBusqueda fbTicket, Date fechaTicket, int cantEmpleadosSolicitados,int cantEmpleadosObtenidos) 
	{
		super(fbTicket, fechaTicket);
		this.cantEmpleadosSolicitados = cantEmpleadosSolicitados;
		this.cantEmpleadosObtenidos = cantEmpleadosObtenidos;
	}



	public TicketEmpleador() {
		super();
	}



	public int getCantEmpleadosSolicitados() {
		return cantEmpleadosSolicitados;
	}



	public void setCantEmpleadosSolicitados(int cantEmpleados) {
		this.cantEmpleadosSolicitados = cantEmpleados;
	}



	public int getCantEmpleadosObtenidos() {
		return cantEmpleadosObtenidos;
	}



	public void setCantEmpleadosObtenidos(int nro) {
		this.cantEmpleadosObtenidos+=nro;
	}
	

	
	
}
