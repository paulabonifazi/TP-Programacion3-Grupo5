package tablas;

import modelo.TicketEmpleadoPretenso;
import modelo.TicketEmpleador;

public abstract class PuntajeTicket {
	private double puntaje;
	
	
	public double getPuntaje(TicketEmpleador ticketEmpleador, TicketEmpleadoPretenso ticketEmpleadoPretenso) {
		double aux = 0;
/////Locacion
		IAspecto aspEmpleado =  TablaFactory.getValorAspecto("acceso a FB empleadoPretenso");
	 	IAspecto aspEmpresa =  TablaFactory.getValorAspecto("acceso a FB empleador");
	 	
		aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpld.valor(aspEmprs);
		puntaje += aux;
//////////Remuneracion
		aspEmpleado =  TablaFactory.getValorAspecto("acceso a FB empleadoPretenso");
	 	aspEmpresa =  TablaFactory.getValorAspecto("acceso a FB empleador");
	 	
	 	aux = 0;
	 	aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpld.valor(aspEmprs);
		puntaje += aux;
		
//////////CargaHoraria
		aspEmpleado =  TablaFactory.getValorAspecto("acceso a FB empleadoPretenso");
	 	aspEmpresa =  TablaFactory.getValorAspecto("acceso a FB empleador");
	 	
	 	aux = 0;
	 	aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpld.valor(aspEmprs);
		puntaje += aux;
		
		
//////////Tipo Puesto
		aspEmpleado =  TablaFactory.getValorAspecto("acceso a FB empleadoPretenso");
	 	aspEmpresa =  TablaFactory.getValorAspecto("acceso a FB empleador");
		
	 	aux = 0;
	 	aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpld.valor(aspEmprs);
		puntaje += aux;
		
//////////Rango Etario
		aspEmpleado =  TablaFactory.getValorAspecto("acceso a FB empleadoPretenso");
	 	aspEmpresa =  TablaFactory.getValorAspecto("acceso a FB empleador");
		
	 	aux = 0;
	 	aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpld.valor(aspEmprs);
		puntaje += aux;
		
////////// Experiencia Previa
		aspEmpleado =  TablaFactory.getValorAspecto("acceso a FB empleadoPretenso");
	 	aspEmpresa =  TablaFactory.getValorAspecto("acceso a FB empleador");
		
	 	aux = 0;
	 	aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpld.valor(aspEmprs);
		puntaje += aux;
		
//////////Estudios cursados
		aspEmpleado =  TablaFactory.getValorAspecto("acceso a FB empleadoPretenso");
	 	aspEmpresa =  TablaFactory.getValorAspecto("acceso a FB empleador");
		
	 	aux = 0;
	 	aux = CONSEGUIRPESO(EL QUE DA LA EMPRESA) * aspEmpld.valor(aspEmprs);
		puntaje += aux;
		
		
		return puntaje;
	}

}
