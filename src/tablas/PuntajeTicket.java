package tablas;

import modelo.TicketEmpleadoPretenso;
import modelo.TicketEmpleador;

public class PuntajeTicket {
	private double puntaje;
	
	
	public double getPuntaje(TicketEmpleador ticketEmpleador, TicketEmpleadoPretenso ticketEmpleadoPretenso) {
		double aux = 0;
		
		IAspecto aspEmpld =  TablaFactory.getValorAspecto("acceso a FB empleadoPretenso");
	 	IAspecto aspEmprs =  TablaFactory.getValorAspecto("acceso a FB empleador");
	 	
		aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpld.valor(aspEmprs);
		puntaje += aux;
		
		/* LO MISMO CON TODOS LOS ASPECTOS */ 
		
		
		return puntaje;
	}

}
