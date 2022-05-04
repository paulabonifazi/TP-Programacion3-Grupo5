package modelo;

public class PerfilEmpleador {
	private TicketEmpleador ticket;

	public void lanzar() {
		ticket.generarTicketEmpleador(null, null, null, null, null, null, null);
		ticket.setCantEmpleados(0);
		ticket.setCantEmpleadosObtenidos(0);
	}
}

/*
 *mismo caso que el perfil del empelado preteso
 *se podría eliminar esta clase dado que el ticket se relaciono con dicha clase 
 *
 */