
package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import paquete.EmpleadoPretenso;
import paquete.Empleador;
import tablas.PuntajeTicket;

//*///*/
public  class FinalRonda {
	
//TicketFinalizar		
	public void finalizarTickets(ArrayList<ListAsignacionEmpleador> lista) {
		for (int i=0; i<lista.size(); i++) {
			lista.get(i).getEmpleador().getTicket().getEstadoTicket().cambiarEstado("FINALIZADO");
			for (int j=0; j<lista.get(i).getListEmpleadosPretensos().size(); i++)
				lista.get(i).getListEmpleadosPretensos().get(j).getTicket().getEstadoTicket().cambiarEstado("FINALIZADO");
		}
	}

//ticketActivo/Suspendido
	///reveer, que parametros necesito para suspender,o sea el empleado como automanda su referencia, podria mandar directamente el ticket
	public void suspenderTicket (Ticket ticket) {
		if (ticket.getEstadoTicket().getEstado().equals("CANCELADO"))
		{}///LANZAR EXCEPTION
		else
			ticket.getEstadoTicket().cambiarEstado("SUSPENDIDO");
	}
	
	public void activarTicket (Ticket ticket) {
		if (ticket.getEstadoTicket().getEstado().equals("CANCELADO"))
		{}///LANZAR EXCEPTION
		else
			ticket.getEstadoTicket().cambiarEstado("ACTIVO");
	}
	
	
	
	
///Un ticket pasa a cancelado por petición de la parte (quien seria la parte)
	
	///me devuelve empresa/ empleado
	public Empleador buscarTickettEmpleador(Empleador empleador,ArrayList<Empleador> listaEmleadores) {
		int cont=0;
		while(cont< listaEmleadores.size() && !listaEmleadores.get(cont).equals(empleador))
			cont++;
		///considerar qie lanze una exception si no encontro lo que busca
		if (cont > listaEmleadores.size())
			{}
		
		return listaEmleadores.get(cont);
	}


	public EmpleadoPretenso buscarTicketEmpleadoPretenso(EmpleadoPretenso empleadoPretenso, ArrayList<EmpleadoPretenso> listaEmpleadoPretenso) {
		int cont=0;
		while(cont< listaEmpleadoPretenso.size() && !listaEmpleadoPretenso.get(cont).equals(empleadoPretenso))
			cont++;
		///considerar qie lanze una exception si no encontro lo que busca o considerarlo en el contrato
		if (cont > listaEmpleadoPretenso.size())
			{}
		
		return listaEmpleadoPretenso.get(cont);
	}

 
/////////comision
	
	
	
	
	
	
	
	
	
		
		//////puntajeUsuario
		
		
		
	public class PuntajeUsuario 
	{
		
		//El puntaje el minimo es 0 cuando empieza y llega hasta 100
		//ListaEmpleadosPretensos y ListaEmpleadores -> deberian ser las listas con los empleados y empleadores que se cargan despues de que llenan el registro

		public void actualizacionPuntajeUsuario(ArrayList<EmpleadoPretenso> ListaRegistroEmpleadosPretensos, ArrayList<Empleador> ListaRegistroEmpleadores,  ArrayList<Empleador> ListaCoincidencias, ArrayList<Empleador> ListasAsignacionEmpresa, ArrayList<EmpleadoPretenso> ListasAsignacionEmpleadoPretenso)
		{
			int pU;

			for(int i=0; i<ListaEmplListaRegistroEmpleadosPretensoseadosPretensos.size(); i++)
			
			{
				pU = ListaRegistroEmpleadosPretensos.get(i).getRegistro.getPuntajeUsuario;
				//analizo estado del ticket 
				if(ListaRegistroEmpleadosPretensos.get(i).getTicket.getEstadoTicket.equals("FINALIZADO"))
					pU += 10;
				else
					if(ListaRegistroEmpleadosPretensos.get(i).getTicket.getEstadoTicket.equals("CANCELADO"))
						pU -= -1;
				
				//analizo Posicion en la listaEmpleados -> necesito un contador de elementos de la lista
				
				int posicion = 0;
				while(posicion < ListasAsignacionEmpleadoPretenso.size() && ListasAsignacionEmpleadoPretenso.get(posicion).getEmpleadoPretenso.getNombreEmpleadoPretenso.equals(ListaRegistroEmpleadosPretensos.get(i).getRegistro.getNombre))
				
				int ult = ListasAsignacionEmpleadoPretenso.size();
				//como calculo la posicion?
				if(posicion == ult) //ultimo lugar
					pU -= 5;
				else 
					if(posicion == 1) //primero
						pU += 5;
				
			}

			for(int j=0; j<ListaRegistroEmpleadores.size(); j++)
			{
				pU = ListaRegistroEmpleadores.get(j).getRegistro.getPuntajeUsuario;

				if(ListaRegistroEmpleadores.get(j).getTicket.getEstadoTicket.equals("FINALIZADO"))
					pU += 50;

				String empresaPos1 = ListasAsignacionEmpleador.get(1).getEmpleador.getNombre;
				if(empresaPos1.equals(ListaRegistroEmpleadores.get(j).getRegistro.getNombre)) //en primer lugar
					pU += 10;
				
				//necesitocontador de elecciones o var booleana que sea true cuando algun empleado lo haya elejido
				int k = 0;
				while(k < ListaCoincidencias.size() && ListaCoincidencias.getEmpresa(k).getNombreEmpresa.equais(ListaRegistroEmpleadores.get(i).getEmpresa.getNombreEmpresa))
					k++;
				
				if(k < ListaCoincidencias.size())
					if ( ListaCoincidencias.getEmpresa(k).getEmpleados == NULL)//sin elecciones
						pU -= 20;
			}
		}
		
		
		
		
		
		
		///////cambio estado ticket
		

		
		//SE MODIFICA DCESPUES DE LA RONDA DE ENCUENTRO 
		//O A PETICION DEL usuario
		
		
		public String resultado()
		{
			if(this.est == "ACTIVO" || this.est == "SUSPENDIDO")
				this.res = "ESPERA";
			else
				if(this.est == "FINALIZADO")
					this.res = "EXITO";
				else //necesito un contador de rondas sin ser elegidos
					if(this.est == "CANCELADO" || contRondasSinEleccion > 3) 
						this.est = "FRACASO";
			
			return this.est;
			//ver que onda como hacer esto xq el estado necesita el resultado y viceversa
		}
	}



/*
 * analizar para que la agencia se encargue!!
 * terminar métodos!
 */
 