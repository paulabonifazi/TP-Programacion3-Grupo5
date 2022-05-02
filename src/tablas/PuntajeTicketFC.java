package tablas;

import modelo.TicketEmpleadoPretenso;
import modelo.TicketEmpleador;
import paquete.Empleador;

public class PuntajeTicketFC {
	private double puntaje;
	
//fijo empleador  vario el empleadoPretenso
	
	public double getPuntaje(Empleador empleador, TicketEmpleadoPretenso ticketEmpleadoPretenso) {
		double aux = 0;
/////Locacion
		IAspecto aspEmpleadoPretenso =  TablaFactory.getValorAspecto(ticketEmpleadoPretenso.getFbTicket().getLocacion());  ///creo los elementos que va a usar el doubleDispath en el factory
	 	IAspecto aspEmpleador =  TablaFactory.getValorAspecto(empleador.getTicket().getFbTicket().getLocacion());
	 	
		aux = empleador.getListaPesos().getPesoLocacion() * aspEmpleador.valor(aspEmpleadoPretenso);						/// multiplico el peso que definio el empleador para ese aspecto * el valor que hay en las tablas 
		puntaje += aux;																										//voy acumulando el puntaje
//////////Remuneracion
		aspEmpleadoPretenso =  TablaFactory.getValorAspecto(ticketEmpleadoPretenso.getFbTicket().getRemuneracion());
		aspEmpleador =  TablaFactory.getValorAspecto(empleador.getTicket().getFbTicket().getRemuneracion());
	 	
	 	aux = 0;
	 	aux = empleador.getListaPesos().getPesoRemuneracion() * aspEmpleador.valor(aspEmpleadoPretenso);
		puntaje += aux;
		
//////////CargaHoraria
		aspEmpleadoPretenso =  TablaFactory.getValorAspecto(ticketEmpleadoPretenso.getFbTicket().getCargaHoraria());
		aspEmpleador =  TablaFactory.getValorAspecto(empleador.getTicket().getFbTicket().getCargaHoraria());
	 	
	 	aux = 0;
	 	aux = empleador.getListaPesos().getPesoCargaHoraria() * aspEmpleador.valor(aspEmpleadoPretenso);
		puntaje += aux;
		
		
//////////Tipo Puesto
		aspEmpleadoPretenso =  TablaFactory.getValorAspecto(ticketEmpleadoPretenso.getFbTicket().getTipoPuesto());
		aspEmpleador =  TablaFactory.getValorAspecto(empleador.getTicket().getFbTicket().getTipoPuesto());
		
	 	aux = 0;
	 	aux = empleador.getListaPesos().getPesoTipoPuesto() * aspEmpleador.valor(aspEmpleadoPretenso);
		puntaje += aux;
		
//////////Rango Etario
		aspEmpleadoPretenso =  TablaFactory.getValorAspecto(ticketEmpleadoPretenso.getFbTicket().getRangoEtario());
		aspEmpleador =  TablaFactory.getValorAspecto(empleador.getTicket().getFbTicket().getRangoEtario());
		
	 	aux = 0;
	 	aux = empleador.getListaPesos().getPesoRangoEtario() * aspEmpleador.valor(aspEmpleadoPretenso);
		puntaje += aux;
		
////////// Experiencia Previa
		aspEmpleadoPretenso =  TablaFactory.getValorAspecto(ticketEmpleadoPretenso.getFbTicket().getExperienciaPrevia());
		aspEmpleador =  TablaFactory.getValorAspecto(empleador.getTicket().getFbTicket().getExperienciaPrevia());
		
	 	aux = 0;
	 	aux = empleador.getListaPesos().getPesoExperienciaPrevia() * aspEmpleador.valor(aspEmpleadoPretenso);
		puntaje += aux;
		
//////////Estudios cursados
		aspEmpleadoPretenso =  TablaFactory.getValorAspecto(ticketEmpleadoPretenso.getFbTicket().getEstudiosCursados());
		aspEmpleador =  TablaFactory.getValorAspecto(empleador.getTicket().getFbTicket().getEstudiosCursados());
		
	 	aux = 0;
	 	aux = empleador.getListaPesos().getPesoEstudiosCursados() * aspEmpleador.valor(aspEmpleadoPretenso);
		puntaje += aux;
		
		
		return puntaje;
	}

}
