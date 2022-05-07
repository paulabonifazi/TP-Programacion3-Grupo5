<<<<<<< Updated upstream
/* aclaraciones 
 * 		clases que funcionan como objeto
			ListAsignacionEmpleadPretenso guarda un empleadoPretenso con una array de empresas
			ListAsignacionEmpleador guarda una empresa con un array de empleadoPretensos
			
			EmpleadorPuntaje guarda una empresa con el puntaje que obtuvo en las tablas
			EmpleadoPretensPuntaje guarda un empleadoPretenso con el puntaje que obtuvo en las tablas

agencia debe tener los metodo que generen las superListas (todas las empresas con todos sus posibles empleados y viceversa)


la clase PuntajeTicketFC y PuntajeTicketCF acceden a la pos a,b y b,a en las tablas

*/
=======
>>>>>>> Stashed changes

package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import paquete.EmpleadoPretenso;
import paquete.Empleador;
import paquete.TIPOListaEmpleadosPretensos;
import paquete.TipoListaContrataciones;
import tablas.PuntajeTicket;


public class RondaEncuentrosLaborales {
	
<<<<<<< Updated upstream
///a este metodo lo llama agencia y le devuelve un nodo que contiene una lista de empresas para empleadoPretenso (agencia se debe encargar de ir guardandolos en un array)
																						///array de todas las empresas y el empleadoPretenso al que se le va agenerar la lista
	public ListAsignacionEmpleadPretenso listasAsignacionEmpleadoPretenso(ArrayList<Empleador> empleador,  EmpleadoPretenso empleadoPretensos) {
		
		ListAsignacionEmpleadPretenso nuevoNodo = new ListAsignacionEmpleadPretenso();	
		
		nuevoNodo.setEmpleadoPretenso(empleadoPretensos);
		nuevoNodo.setListEmpleadores(metodoOrdenamientoEpleadoPretenso(empleadoPretensos, empleador));///traigo una lista de las empresas ordenada
			
		return nuevoNodo;
	}
	
=======

>>>>>>> Stashed changes
	
	//Agencia calcula la comision si cierra contrato!!!!!!!

		//Necesito la lista de contratados

		//Sueldo pretendido -> Sale del formulario de busqueda -> analisar que pasa si la empresa ofrecio un o y el empleado elijio otro -> ejemplo: se queda con el mayor sueldo
		//los porcentajes los pongo en una constante?

		public double calculoComision(TipoListaContrataciones ListaDeContrataciones)
		{
			double sueldoPretendido = this.empleadosPretensos.get(0).getTicket().getFbTicket().getRemuneracion();
			double comision = 0;
			TIPOListaEmpleadosPretensos ListaEmpleadosContratados;
			
			for(int i=0; i< ListaDeContrataciones.size(); i++)//recorro la lista de contrataciones 
			{
				ListaEmpleadosContratados = ListaDeContrataciones.get(i).getListaEmpleados();

				for(int j=0; j <ListaEmpleadosContratados.size(); j++ )//recorro la lista de empelados
				{
					//calculo la comision que se le cobra al empleado

					//NECESITO EL FORMULARIO DE BUSQUEDA -> TIPO DE PUESTO LABORAL
					if(tipoPuesto == "JUNIOR")
						comision = sueldoPretendido * 0.8;
					else
						if(tipoPuesto == "SENIOR")
							comision = sueldoPretendido * 0.9;
						else //if(tipoPuesto == "Gerencial")
							comision = sueldoPretendido;
					

					//PARA AMBOS SE PUEDE MODIFICAR POR EL PUNTAJE DE USUARIO -> RESTA 1% POR CADA PUNTO
					//nECESITO EL PUNTAJE DE uSUARIO YA ACTUALIADO 
					//PENSAR LA CONSIDERACION DE CUANTO SE RE RESTA!!!! SI LLEGA A 100 PUNTOS NO AGA COMISION??/
						
					if(puntajeUsuario != 0)
						comision -= puntajeUsuario * 0.01;

				}


				//calculo comsion que se le cobra al empleador

				//necesito datos del registro 
				if(personaJuridica)
				{
					if(rubro == "SALUD")
						comision = sueldoPretendido * 0.8;
					else if(rubro == "COMERCIO LOCAL")
							comision = sueldoPretendido * 0.9;
						else //if(rubro =="COMERCIO INTERNACIONAL")
							comision = sueldoPretendido ;
				}
				else //personaFisica
				{
					if(rubro == "SALUD")
						comision = sueldoPretendido * 0.6;
					else if(rubro == "COMERCIO LOCAL")
							comision = sueldoPretendido * 0.7;
						else //if(rubro =="COMERCIO INTERNACIONAL")
							comision = sueldoPretendido * 0.8;
				}

				//PARA AMBOS SE PUEDE MODIFICAR POR EL PUNTAJE DE USUARIO -> RESTA 1% POR CADA PUNTO
				//nECESITO EL PUNTAJE DE uSUARIO YA ACTUALIADO 
				//PENSAR LA CONSIDERACION DE CUANTO SE RE RESTA!!!! SI LLEGA A 100 PUNTOS NO AGA COMISION??/
			}	
		}


	
	
	
	
	
	
		
		//////puntajeUsuario
		
		
		
		
		//el admin se encarga de actulizar el puntaje????/
		
		//El puntaje es infinito?? o le damos un maximo y minimo 
		//NO SE ACTUALIZA UNICAMENTE CUANDO FINALIZA UNA CONTRATACION!!!!!!!
		
		//NECESITO EL TIPOuSUARIO -> EMPLEADO O EMPLEADOR
		//private int puntajeInicial = 0;
		
		//ver si existe una funcion predefinida que indique el ultimo elemnto
		private int pU = 0;
		
		public int actualizacionPuntajeUsuario()
		{
			if(tipoUsuario == "EMPLEADO")
			{
				//analizo estado del ticket 
				if(estadoTicket == "FINALIZADO")
					pU += 10;
				else
					if(estadoTicket == "CANCELADO")
						pU -= -1;
				
				//analizo Posicion en la listaEmpleados -> necesito un contador de elementos de la lista
				if(posicion == cantListados) //ultimo lugar
					pU -= 5;
				else 
					if(posicion == 1) //primero
						pU += 5;
				
			}
			else // EMPLEADOR
			{
				if(estadoTicket == "FINALIZADO")
					pU += 50;
				
				if(posicion == 1) 
					pU += 10;
				
				//necesitocontador de elecciones o var booleana que sea true cuando algun empleado lo haya elejido
				(contElecciones == 0)//sin elecciones
					pU -= 20;
			}
		}
		
		
		
		
		
		///////cambio estado ticket
		
		
		
		
		
		//SE MODIFICA DCESPUES DE LA RONDA DE ENCUENTRO 
		//O A PETICION DEL usuario
		
		
//TicketFinalizar		
		public void finalizarTickets(ArrayList<ListAsignacionEmpleador> lista) {
			for (int i=0; i<lista.size(); i++) {
				lista.get(i).getEmpleador().getTicket().getEstadoTicket().cambiarEstado("FINALIZADO");
				for (int j=0; j<lista.get(i).getListEmpleadosPretensos().size(); i++)
					lista.get(i).getListEmpleadosPretensos().get(j).getTicket().getEstadoTicket().cambiarEstado("FINALIZADO");
			}
		}

//ticketActivo/Suspendido
		
		
		public void suspenderTicketEmpleadoPretenso (EmpleadoPretenso empleadoPretenso) {
			EmpleadoPretenso empleadoPretensoSuspender;
			empleadoPretensoSuspender = buscarTicketEmpleadoPretenso (empleadoPretenso);
			if (empleadoPretensoSuspender.getTicket().getEstadoTicket().getEstado().equals("CANCELADO"))
			{}///LANZAR EXCEPTION
			else
				empleadoPretensoSuspender.getTicket().getEstadoTicket().cambiarEstado("SUSPENDIDO");
		}
		
		public void activarTicketEmpleadoPretenso (EmpleadoPretenso empleadoPretenso) {
			EmpleadoPretenso empleadoPretensoActivar;
			empleadoPretensoActivar = buscarTicketEmpleadoPretenso (empleadoPretenso);
			if (empleadoPretensoActivar.getTicket().getEstadoTicket().getEstado().equals("CANCELADO"))
			{}///LANZAR EXCEPTION
			else
				empleadoPretensoActivar.getTicket().getEstadoTicket().cambiarEstado("ACTIVO");
		}
		
		public void suspenderTicketEmpleador (Empleador empleador) {
			Empleador empleadorSuspender;
			empleadorSuspender = buscarTickettEmpleador (empleador);
			if (empleadorSuspender.getTicket().getEstadoTicket().getEstado().equals("CANCELADO"))
			{}///LANZAR EXCEPTION
			else
				empleadorSuspender.getTicket().getEstadoTicket().cambiarEstado("SUSPENDIDO");
		}
		
		public void activarTicketEmpleador (Empleador empleador) {
			Empleador empleadorSuspender;
			empleadorSuspender = buscarTickettEmpleador (empleador);
			if (empleadorSuspender.getTicket().getEstadoTicket().getEstado().equals("CANCELADO"))
			{}///LANZAR EXCEPTION
			else
				empleadorSuspender.getTicket().getEstadoTicket().cambiarEstado("ACTIVO");
		}
		
	
<<<<<<< Updated upstream
	public ArrayList RondaContratacion(ArrayList desicionEmpresas,  ArrayList desicionEmpleadPretens) {///devuelvo una lista de emprresas con los empleados contratados
	/*ArrayList<ListAsignacionEmpleadPretenso> listaCoincidenciaEmpleadPretenso = new ArrayList<ListAsignacionEmpleadPretenso>();//el resultado que me devuelven
	ArrayList<ListAsignacionEmpleador> listaCoincidenciaEmpleador = new ArrayList<ListAsignacionEmpleador>();	*/
	
	//cada empleado para saber que empresa los contrato se tendria que buscar entre todas las empresas
		ArrayList lista = null;
		//creo un for
	//en la primer posicion pongo de listaFinal pongo la primer empresa de desicionEmpresa
		//	recorro desicionempleadPretenso 
		//  busco si coincide la empresa actual con su eleccion
		//	si es v la agrego y elimino el elemento, si es f paso ala siguiente /**si crease 2 lista, en este punto agrego a ambas lsitas/

		return lista;
		
	}///ver si es mas combeniete 2 listas una de empresas con los empleados contratados y otra de empleados con la empresa en la que quedo
			///doble referecnia
	
}
=======
		///me devuelve empresa/ empleado
		
		public Empleador buscarTickettEmpleador(Empleador empleador) {
			int cont=0;
			while(cont< this.empleadores.size() && !this.empleadores.get(cont).equals(empleador))
				cont++;
			///considerar qie lanze una exception si no encontro lo que busca
			if (cont > this.empleadores.size())
				{}
			
			return this.empleadores.get(cont);
		}

	
		public EmpleadoPretenso buscarTicketEmpleadoPretenso(EmpleadoPretenso empleadoPretenso) {
			int cont=0;
			while(cont< this.empleadosPretensos.size() && !this.empleadosPretensos.get(cont).equals(empleadoPretenso))
				cont++;
			///considerar qie lanze una exception si no encontro lo que busca o considerarlo en el contrato
			if (cont > this.empleadosPretensos.size())
				{}
			
			return this.empleadosPretensos.get(cont);
		}




	
	
	
	
	
		
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









	
	
	
	
	
	
}

/*
 * analizar para que la agencia se encargue!!
 * terminar métodos!
 */
 
>>>>>>> Stashed changes
