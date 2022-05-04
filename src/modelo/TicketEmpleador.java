package modelo;

import java.util.Date;

public class TicketEmpleador extends Ticket 
{	
	private int cantEmpleados;
	private int cantEmpleadosObtenidos;
	
	
	public TicketEmpleador(FormularioBusqueda fbTicket, EstadoTicket estadoTicket, Date fechaTicket, int cantEmpleados,
			int cantEmpleadosObtenidos) 
	{
		super(fbTicket, estadoTicket, fechaTicket);
		this.cantEmpleados = cantEmpleados;
		this.cantEmpleadosObtenidos = cantEmpleadosObtenidos;
	}



	public int getCantEmpleados() {
		return cantEmpleados;
	}



	public void setCantEmpleados(int cantEmpleados) {
		this.cantEmpleados = cantEmpleados;
	}



	public int getCantEmpleadosObtenidos() {
		return cantEmpleadosObtenidos;
	}



	public void setCantEmpleadosObtenidos(int cantEmpleadosObtenidos) {
		this.cantEmpleadosObtenidos = cantEmpleadosObtenidos;
	}
	
	
}
