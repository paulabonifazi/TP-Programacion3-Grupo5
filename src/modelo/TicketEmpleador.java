package modelo;

import java.util.Date;

public class TicketEmpleador extends Ticket {
	


	private Ticket ticket;
	private int cantEmpleados;
	private int cantEmpleadosObtenidos;
	
	
	
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



	public void generarTicketEmpleador(String locacion, String remuneracion, String cargaHoraria, String tipoPuesto,
			String rangoEtario, String experienciaPrevia, String estudiosCursados) {
		ticket.generarTicket(null, null, null, null, null, null, null);
		
	}
	
	
}
