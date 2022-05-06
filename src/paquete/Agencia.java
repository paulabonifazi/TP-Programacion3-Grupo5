package paquete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.SortedSet;

import modelo.EmpleadorPuntaje;
import modelo.ListAsignacionEmpleadPretenso;
import tablas.PuntajeTicket;

import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import modelo.RondaEncuentrosLaborales;

public class Agencia
{
	private static Agencia instancia = null;
	private String nombre;

	private ArrayList<Empleador> empleadores = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso> ();
	
	
	
	
	
	private ArrayList<EmpleadoPretenso> listaEmpleadoPretenso = new ArrayList<EmpleadoPretenso>();  ///listas de empleadosPretensos
	private ArrayList<Empleador> listaEmpleadores = new ArrayList<Empleador>();						///lista empleadores
	
	private ArrayList<ListAsignacionEmpleador> listAsignacionEmpleador = new ArrayList<ListAsignacionEmpleador>();//lista de empresas con sus posibles empleados ordenados
	private ArrayList<ListAsignacionEmpleadPretenso> listAsignacionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();//lista de empleadosPretenso con sus posibles empresas ordenados
	
	private ArrayList<ListAsignacionEmpleador> listaContratacion = new ArrayList<ListAsignacionEmpleador>();//lista que guarda las coincidencias entre empresa y empleado
		///unica lista para evitar la doble referencia de que empleadoPretensis conosca a empresa (si empleadoPretenso quiere saber con qyuien esta -> reviso la lista hasta encontrarla)
	
	
	
	///metodo que genere las lista de empresas y lista de empleadores 
	public void agregarEmpleador (Empleador empleador) {
		empleadores.add(empleador);
	}
	
	public void agregarEmpleadoPretenso (EmpleadoPretenso empleadoPretenso) {
		empleadosPretensos.add(empleadoPretenso);
	}
	
	
	///metodo que genere las listas de asignacion (con los metodos de RondaEncuentroLaboral) (punto 5 funcionalidad agencia)
	public void generarListAsignacionEmpleador() {
		for (int i=0; i<this.empleadores.size(); i++)
			listAsignacionEmpleador.add(RondaEncuentrosLaborales.listasAsignacionEmpresa(this.empleadosPretensos,this.empleadores.get(i)));///la idea general es esta, definir si dejmos REL o movemos los metodos aca
	}
	
	
	public void generarListAsignacionEmpleadoPretenso() {
		for (int i=0; i<this.empleadosPretensos.size(); i++)
			listAsignacionEmpleadoPretensos.add(RondaEncuentrosLaborales.listasAsignacionEmpleadoPretenso(this.empleadores, this.empleadosPretensos.get(i)));///la idea general es esta, definir si dejmos REL o movemos los metodos aca
	}
	
	
	///metodo que recolecte y arma la lista de las elecciones
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private Agencia() {	}
	
	
	
	public static Agencia getInstance()
	{
		if (Agencia.instancia == null)
			Agencia.instancia = new Agencia();
		
		return instancia;
	}

	
	//Ronda de encuentros laborales:

	/*
	public SortedSet<EmpleadoPretenso> creaListaOrdEmpleadosPretensos(ArrayList<EmpleadoPretenso> empleadosPretensos)
	{
		SortedSet<EmpleadoPretenso> empleadosPretensosOrd =  (SortedSet<EmpleadoPretenso>) new HashSet<EmpleadoPretenso>(empleadosPretensos);
		
		return empleadosPretensosOrd;
		
	}
	
	public SortedSet<Empleador> creaListaOrdEmpleadores(ArrayList<Empleador> empleadores)
	{
		SortedSet<Empleador> empleadoresOrd = (SortedSet<Empleador>) new HashSet<Empleador>(empleadores);
		
		return empleadoresOrd;
		
	}
	
	*/
	
	/*
	 * estos metodos son llamados luego de haberse realizado las rondas de encuentros
	 * en las rondas de encuentros hay que considerar el estado del ticket
	 * primero crearía las listas de encuentros(analizando valor del ticket,
	 *  ver si hay match, etc etc) y luego ordenar dichas listas con los métodos 
	 *  sortedset de arriba o los métodos que realizó kevin (ANALIZAR) en la clase ronda encuentros
	 *  una vez obtenidas las listas ordenadas se procede a la contratacion.
	 *  una vez realizada dicha contratacion se agregan ambos (empleador y empleado pretenso)
	 *  a una lista de contrataciones en agencia!
	 * 
	 */
	
	
	
	
	///metodo que genere la lista con las contrataciones (emmpresa/empleado consultan en esta con quien se quedarton) (punto 6 funcionalidad agencia)
	///metodo que calcule las comisiones en base a esa lista
	///cambio en los estado de los tickets, actualizacion de los puntajes de usurario

	
	
	
	
	
	
	
	
	
	//Agencia calcula la comision si cierra contrato!!!!!!!

		//Necesito la lista de contratados

		//Sueldo pretendido -> Sale del formulario de busqueda -> analisar que pasa si la empresa ofrecio un o y el empleado elijio otro -> ejemplo: se queda con el mayor sueldo
		double sueldoPretendido = ... ;

		public double calculoComision(TipoListaContrataciones ListaDeContrataciones)
		{
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
		
		
		private String est = "ACTIVADO";
		
		public String estado()
		{
			//si usuario pide suspender ... 
			
			if(susp == 1)
				this.est = "SUSPENDIDO";
			else
				this.est = "ACTIVADO";
			
			//necesito el resultado
			if(resultado.equals("EXITO")
				this.est = "FINALIZADO";
			else
				if(resultado.equals("FRACASO"))
					this.est = "CANCELADO";
			
			return this.est;
		}
		
		//
		
		private String res = "ESPERA"; //cuando inicia 
		
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









	
	
	
	
	
	
	
	
	
	
