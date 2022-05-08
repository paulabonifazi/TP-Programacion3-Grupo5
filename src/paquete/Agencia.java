/* aclaraciones 
 * 		clases que funcionan como objeto
			ListAsignacionEmpleadPretenso guarda un empleadoPretenso con una array de empresas
			ListAsignacionEmpleador guarda una empresa con un array de empleadoPretensos
			
			EmpleadorPuntaje guarda una empresa con el puntaje que obtuvo en las tablas
			EmpleadoPretensPuntaje guarda un empleadoPretenso con el puntaje que obtuvo en las tablas

agencia debe tener los metodo que generen las superListas (todas las empresas con todos sus posibles 
empleados y viceversa)


la clase PuntajeTicketFC y PuntajeTicketCF acceden a la pos a,b y b,a en las tablas

*////PASSARLO A LA DOCUMENTACION///

package paquete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.SortedSet;

import excepciones.ContrasenaIncorrectaException;
import excepciones.NombreDeUsuarioIncorrectoException;
import modelo.ControlEstadTicket;
import modelo.EmpleadPretensoPuntaje;
import modelo.EmpleadorPuntaje;
import modelo.ListAsignacionEmpleadPretenso;
import tablas.PuntajeTicket;

import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;

public class Agencia
{
	private static Agencia instancia = null;
	private String nombre;

	//no tendria que considerar conservar todas las listas de contratacion que se generan, yaque al ejecutar dos veces se pierde lo anterior
	
	private ArrayList<Empleador> empleadoresActivos = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensosActivos = new ArrayList<EmpleadoPretenso> ();
	
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso> ();
		
	private ArrayList<ListAsignacionEmpleador> listAsignacionEmpleador = new ArrayList<ListAsignacionEmpleador>();//lista de empresas con sus posibles empleados ordenados
	private ArrayList<ListAsignacionEmpleadPretenso> listAsignacionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();//lista de empleadosPretenso con sus posibles empresas ordenados

	private ArrayList<ListAsignacionEmpleador> listEleccionEmpleador = new ArrayList<ListAsignacionEmpleador>();//lista de empresas con sus posibles empleados ordenados
	private ArrayList<ListAsignacionEmpleadPretenso> listEleccionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();//lista de empleadosPretenso con sus posibles empresas ordenados
	
	private ArrayList<ListAsignacionEmpleador> listaCoincidencias = new ArrayList<ListAsignacionEmpleador>();;//lista que guarda las coincidencias entre empresa y empleado

	 private double saldoAgencia = calculoComision();

	 final double v1 = 10000;
	 final double v2 = 20000;
	 final double v3 = 30000;
	
	private Agencia() {	}
	
	public static Agencia getInstance()
	{
		if (Agencia.instancia == null)
			Agencia.instancia = new Agencia();
		
		return instancia;
	}
	
	public void agregarEmpleador (Empleador empleador) {
		empleadores.add(empleador);
	}
	
	public void agregarEmpleadoPretenso (EmpleadoPretenso empleadoPretenso) {
		empleadosPretensos.add(empleadoPretenso);
	}
	
	public void activarRondaEncuentrosLaborales () {///metodo que genere las listas de asignacion
		generarListAsignacionEmpleador();
		generarListAsignacionEmpleadoPretenso();
		
		actualizacionPuntajeUsuario();
	}
	
	public void generarListAsignacionEmpleador() {
		filtroTicketActivoEmpleadores();	///solo trabajo con los activos
		for (int i=0; i<this.empleadoresActivos.size(); i++)
			listAsignacionEmpleador.add(listasAsignacionEmpresa(this.empleadosPretensosActivos,this.empleadoresActivos.get(i)));
	}
	
	public void generarListAsignacionEmpleadoPretenso() {
		filtroTicketActivoEmpleadosPretensos();
		for (int i=0; i<this.empleadosPretensosActivos.size(); i++)
			listAsignacionEmpleadoPretensos.add(listasAsignacionEmpleadoPretenso(this.empleadoresActivos, this.empleadosPretensosActivos.get(i)));
	}
		
	//filtro solo ticket activos
	public void filtroTicketActivoEmpleadosPretensos() {
		for (int i=0; i<this.empleadosPretensos.size();i++)
			if (this.empleadosPretensos.get(i).getTicket().getEstadoTicket().getEstado().equals("ACTIVO"))
				this.empleadosPretensosActivos.add(this.empleadosPretensos.get(i));
	}
	
	public void filtroTicketActivoEmpleadores() {
		for (int i=0; i<this.empleadores.size();i++)
			if (this.empleadores.get(i).getTicket().getEstadoTicket().getEstado().equals("ACTIVO"))
				this.empleadoresActivos.add(this.empleadores.get(i));
	}
	

	///le devuelve un nodo que contiene una lista de empresas para empleadoPretenso 
	public  ListAsignacionEmpleadPretenso listasAsignacionEmpleadoPretenso(ArrayList<Empleador> empleador,  EmpleadoPretenso empleadoPretensos) {

			ListAsignacionEmpleadPretenso nuevoNodo = new ListAsignacionEmpleadPretenso();		///sigue existiendo al finalizar el metodo???
			nuevoNodo.setEmpleadoPretenso(empleadoPretensos);
			nuevoNodo.setListEmpleadores(metodoOrdenamientoEpleadoPretenso(empleadoPretensos, empleador));///traigo una lista de las empresas ordenada

			return nuevoNodo;
	}


	///el metodo me devuelve una listaOrdenada de empresas para el empleadoPretneos 
	public ArrayList<Empleador> metodoOrdenamientoEpleadoPretenso( EmpleadoPretenso empleadoPretensos, ArrayList<Empleador> listaEmpleadores) {
	
	ArrayList<Empleador> lista = new  ArrayList<Empleador>();						//lista que voy a devolver
	ArrayList<EmpleadorPuntaje> listaOrdenada = new ArrayList<EmpleadorPuntaje>();   //lista que contiene el puntaje y se ordena segun este atributo
	EmpleadorPuntaje empleadorPuntaje = new EmpleadorPuntaje();	
	
	for (int i=0; i<=listaEmpleadores.size(); i++) {///creo la lista Con Puntajes 
		empleadorPuntaje.setEmpleador(listaEmpleadores.get(i)); 
		empleadorPuntaje.setPuntaje(new PuntajeTicket().getPuntajeFC(listaEmpleadores.get(i), empleadoPretensos.getTicket())); 
				//(a,b) que el (b,a) de la tabla por que si no lo es .> necisto cambiar FC a CF
		listaOrdenada.add(empleadorPuntaje);
		}
	
	////probar si el metodo funciona bien///
	Collections.sort(listaOrdenada, new Comparator<EmpleadorPuntaje>() {
	@Override
		public int compare(EmpleadorPuntaje p2, EmpleadorPuntaje p1) {
			return new Double(p2.getPuntaje()).compareTo(new Double(p1.getPuntaje()));
			}
		});
	
	for (int j = 0; j< listaOrdenada.size(); j++) 				///cargo lista con el orden de listaOrdenada
		lista.add(listaOrdenada.get(j).getEmpleador());
	
	return lista;	
	}
	
	
	///le devuelve un nodo que tine una lista de empleadosPretensos para la empresa 
	public ListAsignacionEmpleador listasAsignacionEmpresa(  ArrayList<EmpleadoPretenso> empleadosPretensos , Empleador empleador) {
		ListAsignacionEmpleador nuevoNodo = new ListAsignacionEmpleador();	
		nuevoNodo.setEmpleador(empleador);
		nuevoNodo.setListEmpleadosPretensos(metodoOrdenamientoEmpleador(empleador , empleadosPretensos));//traigo una lista de empleadosPretensos ordenada
	
		return nuevoNodo;
	}
	
	
	///el metodo devuelve una lista ordenada por puntaje de empleadosPretensos
	public ArrayList<EmpleadoPretenso> metodoOrdenamientoEmpleador(Empleador empleador, ArrayList<EmpleadoPretenso> listaEmpleaPretenso) {
	
		ArrayList<EmpleadoPretenso> lista = new  ArrayList<EmpleadoPretenso>();						//lista que voy a devolver
		ArrayList<EmpleadPretensoPuntaje> listaOrdenada = new ArrayList<EmpleadPretensoPuntaje>();   //lista que contiene el puntaje y se ordena segun este atributo
		EmpleadPretensoPuntaje empleadoPretensPuntaje = new EmpleadPretensoPuntaje();	
	
		for (int i=0; i<=listaEmpleaPretenso.size(); i++) {///creo la lista Con Puntajes 
				empleadoPretensPuntaje.setEmpleadoPretenso(listaEmpleaPretenso.get(i));
				empleadoPretensPuntaje.setPuntaje(new PuntajeTicket().getPuntajeCF(empleador, listaEmpleaPretenso.get(i).getTicket()));
				listaOrdenada.add(empleadoPretensPuntaje);
	}
	
	////reveer como ordenarlo
	Collections.sort(listaOrdenada, new Comparator<EmpleadPretensoPuntaje>() {
		@Override
		public int compare(EmpleadPretensoPuntaje p2, EmpleadPretensoPuntaje p1) {
				return new Double(p2.getPuntaje()).compareTo(new Double(p1.getPuntaje()));
				}
		});
	
	for (int j = 0; j< listaOrdenada.size(); j++) ///cargo lista con el orden de listaOrdenada
		lista.add(listaOrdenada.get(j).getEmpleadoPretenso());
	
	return lista;
	}
		
		//  METODO COINCIDENCIAS -> buscar las coincidencias y guardar en un arrayList del mismo tipo quer la lista de empleadores

		//recibo 2 arrayList de arrayList
		//									-> ListaDeEmpleadores = Cada nodo tiene la empleados y un arrayList de a los empleados Pretensos que eligio
		//									-> ListaDeEmpleadosPretensos = Cada nodo tiene al empleado Pretenso y al unico empleador que eligio
		
		//Recorrer el arrayListe de empleadores y buscar en el de empleadosPretensos si coinciden

	///comenzar las lista en null, -> si en algun momento se pide mostra u sumilat sy es null -> no hay nada
		
	  ///equivale a lista de contrataciones
		
	 public  void ListaCoincidencias(ArrayList<ListAsignacionEmpleador> ListaDeEmpleadores, ArrayList<ListAsignacionEmpleadPretenso> ListaDeEmpleadosPretensos) 
		{	
			 ListAsignacionEmpleador nodo = new ListAsignacionEmpleador();
			 ArrayList<EmpleadoPretenso>Empleado;
			 
			 String empleador;
			 ArrayList<EmpleadoPretenso> ListaPosiblesEmpleados ;
			 String empleadoPretenso;
			 int cont;

			for(int i = 0; i < ListaDeEmpleadores.size(); i++)//Recorre el arrayList de empleadores
			{
				//trabahar con var para simplificar
				ListaPosiblesEmpleados = ListaDeEmpleadores.get(i).getListEmpleadosPretensos();

				//CREAR UN NUEVO OBJETO DE lISTACOINCIDENCIAS 
				nodo.setEmpleador(ListaDeEmpleadores.get(i).getEmpleador());
				//CARGAR EL NOMBRE DE LA EMPRESA
				cont = 0;
				while (	cont < ListaPosiblesEmpleados.size() &&	ListaDeEmpleadores.get(i).getEmpleador().getTicket().getCantEmpleadosSolicitados() > ListaDeEmpleadores.get(i).getEmpleador().getTicket().getCantEmpleadosObtenidos())
				{
					empleadoPretenso = ListaPosiblesEmpleados.get(cont).getNombUsuario();
					int k = 0;
					while(k < ListaDeEmpleadosPretensos.size() && !ListaDeEmpleadosPretensos.get(k).getEmpleadoPretenso().getNombUsuario().equals(empleadoPretenso))//recorro buscando la coincidencia en la lista de los empleados -> si aparece el nombre en esa lista entonces hay coincidencia
						k++;

					if(k < ListaDeEmpleadosPretensos.size()) //coincidencia
					{
						nodo.setListEmpleadosPretensos(ListaPosiblesEmpleados);
						nodo.getListEmpleadosPretensos().add(ListaDeEmpleadosPretensos.get(k).getEmpleadoPretenso());
						ListaDeEmpleadores.get(i).getEmpleador().getTicket().setCantEmpleadosObtenidos();
					}
					cont++;
				}
				listaCoincidencias.add(nodo);
			}
			new ControlEstadTicket().finalizarTickets(listaCoincidencias);    				////ver si es correcto
		}

	public void actualizacionPuntajeUsuario()
	{
		for(int i=0; i<empleadosPretensosActivos.size(); i++)
		
		{
			
			//analizo estado del ticket 
			if(empleadosPretensosActivos.get(i).getTicket().getEstadoTicket().equals("FINALIZADO"))
				empleadosPretensosActivos.get(i).setPuntajeUsuario(10);
			else
				if(empleadosPretensosActivos.get(i).getTicket().getEstadoTicket().equals("CANCELADO"))
					empleadosPretensosActivos.get(i).setPuntajeUsuario(-1);
			
			//analizo Posicion en la listaEmpleados -> necesito un contador de elementos de la lista
			
			int posicion = 0;
			while(posicion < listAsignacionEmpleadoPretensos.size() && listAsignacionEmpleadoPretensos.get(posicion).getEmpleadoPretenso().equals(empleadosPretensosActivos.get(i)))
				posicion++;	
	
			int ult = listAsignacionEmpleadoPretensos.size();
			//como calculo la posicion?
			if(posicion == ult) //ultimo lugar
				empleadosPretensosActivos.get(i).setPuntajeUsuario(-5);
			else 
				if(posicion == 1) //primero
					empleadosPretensosActivos.get(i).setPuntajeUsuario(5);
		}
	
		for(int j=0; j<empleadoresActivos.size(); j++)
		{
	
			if(empleadoresActivos.get(j).getTicket().getEstadoTicket().equals("FINALIZADO"))
				empleadoresActivos.get(j).setPuntajeUsuario(50); 
	
			Empleador empresaPos1 = listAsignacionEmpleador.get(1).getEmpleador();
			
			if(empresaPos1.equals(empleadoresActivos.get(j))) //en primer lugar
				empleadoresActivos.get(j).setPuntajeUsuario(10); 
			
			//necesitocontador de elecciones o var booleana que sea true cuando algun empleado lo haya elejido
			int k = 0;
			while(k < listaCoincidencias.size() && listaCoincidencias.get(k).getEmpleador().equals(empleadoresActivos.get(j)))
				k++;
			
			if(k < listaCoincidencias.size())
				if ( listaCoincidencias.get(k).getListEmpleadosPretensos() == null)//sin elecciones
					empleadoresActivos.get(j).setPuntajeUsuario(-20); 
		}
	}

	public boolean login(String nombUsuarioIngresado, String contrasenaIngresada) throws NombreDeUsuarioIncorrectoException, ContrasenaIncorrectaException
	{
		/**
		 * de ser usuario inexistente tira una excpecion
		 * de ser contraseña erronea tira otra excpecion
		 **/
		int i = 0;
		boolean loginCorrecto = false;
		while (i<this.empleadores.size() && !this.empleadores.get(i).getNombUsuario().equals(nombUsuarioIngresado))
			i++;
		if (i<this.empleadores.size())
		{
			if (this.empleadores.get(i).getContrasenia().equals(contrasenaIngresada))
				loginCorrecto = true;
			else
				throw new ContrasenaIncorrectaException("Contrasena incorrecta");
		}
		else
		{
			i = 0;
			while (i<this.empleadosPretensos.size() && !this.empleadosPretensos.get(i).getNombUsuario().equals(nombUsuarioIngresado))
				i++;
			if (i<this.empleadosPretensos.size())
			{
				if (this.empleadosPretensos.get(i).getContrasenia().equals(contrasenaIngresada))
					loginCorrecto = true;
				else
					throw new ContrasenaIncorrectaException("Contrasena incorrecta");
			}
			else
				throw new NombreDeUsuarioIncorrectoException("Nombre de Usuario incorrecto");
		}
		return loginCorrecto;
	}
}
