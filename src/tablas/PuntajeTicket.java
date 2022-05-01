package tablas;

import modelo.TicketEmpleadoPretenso;
import modelo.TicketEmpleador;

public class PuntajeTicket {
	private double puntaje;
	
	
	public double getPuntaje(TicketEmpleador ticketEmpleador, TicketEmpleadoPretenso ticketEmpleadoPretenso) {
		double aux = 0;
/////Locacion
		IAspecto aspEmpleadoPretenso =  TablaFactory.getValorAspecto(ticketEmpleadoPretenso.getFbTicket().getLocacion());
	 	IAspecto aspEmpleador =  TablaFactory.getValorAspecto(ticketEmpleador.getFbTicket().getLocacion());
	 	
		aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpleadoPretenso.valor(aspEmpleador);
		puntaje += aux;
//////////Remuneracion
		aspEmpleadoPretenso =  TablaFactory.getValorAspecto(ticketEmpleadoPretenso.getFbTicket().getRemuneracion());
		aspEmpleador =  TablaFactory.getValorAspecto(ticketEmpleador.getFbTicket().getRemuneracion());
	 	
	 	aux = 0;
	 	aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpleadoPretenso.valor(aspEmpleador);
		puntaje += aux;
		
//////////CargaHoraria
		aspEmpleadoPretenso =  TablaFactory.getValorAspecto(ticketEmpleadoPretenso.getFbTicket().getCargaHoraria());
		aspEmpleador =  TablaFactory.getValorAspecto(ticketEmpleador.getFbTicket().getCargaHoraria());
	 	
	 	aux = 0;
	 	aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpleadoPretenso.valor(aspEmpleador);
		puntaje += aux;
		
		
//////////Tipo Puesto
		aspEmpleadoPretenso =  TablaFactory.getValorAspecto(ticketEmpleadoPretenso.getFbTicket().getTipoPuesto());
		aspEmpleador =  TablaFactory.getValorAspecto(ticketEmpleador.getFbTicket().getTipoPuesto());
		
	 	aux = 0;
	 	aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpleadoPretenso.valor(aspEmpleador);
		puntaje += aux;
		
//////////Rango Etario
		aspEmpleadoPretenso =  TablaFactory.getValorAspecto(ticketEmpleadoPretenso.getFbTicket().getRangoEtario());
		aspEmpleador =  TablaFactory.getValorAspecto(ticketEmpleador.getFbTicket().getRangoEtario());
		
	 	aux = 0;
	 	aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpleadoPretenso.valor(aspEmpleador);
		puntaje += aux;
		
////////// Experiencia Previa
		aspEmpleadoPretenso =  TablaFactory.getValorAspecto(ticketEmpleadoPretenso.getFbTicket().getExperienciaPrevia());
		aspEmpleador =  TablaFactory.getValorAspecto(ticketEmpleador.getFbTicket().getExperienciaPrevia());
		
	 	aux = 0;
	 	aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpleadoPretenso.valor(aspEmpleador);
		puntaje += aux;
		
//////////Estudios cursados
		aspEmpleadoPretenso =  TablaFactory.getValorAspecto(ticketEmpleadoPretenso.getFbTicket().getEstudiosCursados());
		aspEmpleador =  TablaFactory.getValorAspecto(ticketEmpleador.getFbTicket().getEstudiosCursados());
		
	 	aux = 0;
	 	aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpleadoPretenso.valor(aspEmpleador);
		puntaje += aux;
		
		
		return puntaje;
	}

}
