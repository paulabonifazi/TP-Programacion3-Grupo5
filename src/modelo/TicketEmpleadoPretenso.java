package modelo;

public class TicketEmpleadoPretenso extends Ticket{
	
	private Ticket ticket;
	private String resultado; 

	public void generarTicketEmpleadoPretenso(String locacion, String remuneracion, String cargaHoraria, String tipoPuesto,
			String rangoEtario, String experienciaPrevia, String estudiosCursados) {
		ticket.generarTicket(null, null, null, null, null, null, null);
		
	}

	public String getResultado() {
		return resultado;
	}


}
