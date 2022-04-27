package modelo;

public class PerfilEmpleador {
	private TicketEmpleador ticket;

	public void lanzar() {
		ticket.generarTicketEmpleador(null, null, null, null, null, null, null);
		ticket.setCantEmpleados(0);
		ticket.setCantEmpleadosObtenidos(0);
	}
}
