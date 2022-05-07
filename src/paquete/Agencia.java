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
<<<<<<< Updated upstream
=======
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.SortedSet;

import modelo.EmpleadPretensoPuntaje;
import modelo.EmpleadorPuntaje;
import modelo.ListAsignacionEmpleadPretenso;
import tablas.PuntajeTicket;

import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import modelo.RondaEncuentrosLaborales;
>>>>>>> Stashed changes

public class Agencia
{
	private static Agencia instancia = null;
	private String nombre;
	
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso> ();
	
<<<<<<< Updated upstream
	/*/* ir guardando los registros en las array de arriba
	
	
	
	
	/*agregar otros tributos, ver cuales!*/
	
	private ArrayList<Persona> personas = new ArrayList<Persona>();
	
	private Agencia() {
		
	}
	
	public static Agencia getInstance()
	{
		if (Agencia.instancia == null)
			Agencia.instancia = new Agencia();
		
		return instancia;
	}
	
}
=======
	private ArrayList<EmpleadoPretenso> listaEmpleadoPretenso = new ArrayList<EmpleadoPretenso>();  ///listas de empleadosPretensos
	private ArrayList<Empleador> listaEmpleadores = new ArrayList<Empleador>();						///lista empleadores
	
	private ArrayList<ListAsignacionEmpleador> listAsignacionEmpleador = new ArrayList<ListAsignacionEmpleador>();//lista de empresas con sus posibles empleados ordenados
	private ArrayList<ListAsignacionEmpleadPretenso> listAsignacionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();//lista de empleadosPretenso con sus posibles empresas ordenados
	
	private ArrayList<ListAsignacionEmpleador> listaContratacion = new ArrayList<ListAsignacionEmpleador>();//lista que guarda las coincidencias entre empresa y empleado

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
	
	
	///metodo que genere las listas de asignacion
	public void generarListAsignacionEmpleador() {
		filtroTicketActivoEmpleadores(this.empleadores);	///solo trabajo con los activos
		for (int i=0; i<this.empleadores.size(); i++)
			listAsignacionEmpleador.add(listasAsignacionEmpresa(this.empleadosPretensos,this.empleadores.get(i)));
	}
	
	public void generarListAsignacionEmpleadoPretenso() {
		filtroTicketActivoEmpleadosPretensos(this.empleadosPretensos);
		for (int i=0; i<this.empleadosPretensos.size(); i++)
			listAsignacionEmpleadoPretensos.add(listasAsignacionEmpleadoPretenso(this.empleadores, this.empleadosPretensos.get(i)));
	}
		
	//filtro solo ticket activos
	///ver si conservo la lista original
	public ArrayList<EmpleadoPretenso> filtroTicketActivoEmpleadosPretensos(ArrayList<EmpleadoPretenso> empleadosPretensos) {
		for (int i=0; i<empleadosPretensos.size();i++)
			if (!empleadosPretensos.get(i).getTicket().getEstadoTicket().getEstado().equals("ACTIVO"))
				empleadosPretensos.remove(i);
		return empleadosPretensos;
	}
	
	public ArrayList<Empleador> filtroTicketActivoEmpleadores(ArrayList<Empleador> empleadores) {
		for (int i=0; i<empleadores.size();i++)
			if (!empleadores.get(i).getTicket().getEstadoTicket().getEstado().equals("ACTIVO"))
				empleadores.remove(i);
		return empleadores;
	}
	

	///le devuelve un nodo que contiene una lista de empresas para empleadoPretenso 
	public  ListAsignacionEmpleadPretenso listasAsignacionEmpleadoPretenso(ArrayList<Empleador> empleador,  EmpleadoPretenso empleadoPretensos) {

			ListAsignacionEmpleadPretenso nuevoNodo = new ListAsignacionEmpleadPretenso();	
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
		
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///no hago todo en un metodo, porque puede ser que quiera la lista solo de las empresas u empleados (tipo una funcionalidad que me deja ver los candidatos pero no seleccionar, solo ver)

	

		//  METODO COINCIDENCIAS -> buscar las coincidencias y guardar en un arrayList del mismo tipo quer la lista de empleadores

		//recibo 2 arrayList de arrayList
		//									-> ListaDeEmpleadores = Cada nodo tiene la empleados y un arrayList de a los empleados Pretensos que eligio
		//									-> ListaDeEmpleadosPretensos = Cada nodo tiene al empleado Pretenso y al unico empleador que eligio
		
		//Recorrer el arrayListe de empleadores y buscar en el de empleadosPretensos si coinciden

		public  ArrayList<ListAsignacionEmpleador> ListaCoincidencias(ArrayList<ListAsignacionEmpleador> ListaDeEmpleadores, ArrayList<ListAsignacionEmpleadPretenso> ListaDeEmpleadosPretensos) 
		{
			 String empleador;
			 ArrayList<EmpleadoPretenso> ListaPosiblesEmpleados ;
			 String empleadoPretenso;

			for(int i = 0; i < ListaDeEmpleadores.size(); i++)//Recorre el arrayList de empleadores
			{
				//trabahar con var para simplificar
				empleador = ListaDeEmpleadores.get(i).getEmpleador().getNombUsuario();
				ListaPosiblesEmpleados = ListaDeEmpleadores.get(i).getListEmpleadosPretensos();

				//CREAR UN NUEVO OBJETO DE lISTACOINCIDENCIAS 
				//CARGAR EL NOMBRE DE LA EMPRESA

				for(int j = 0; j < ListaPosiblesEmpleados.size(); j++)// recorre la lsita de los empleados elegidos por el empleador
				{
					empleadoPretenso = ListaPosiblesEmpleados.get(j).getNombUsuario();
					int k = 0;
					while(k < ListaDeEmpleadosPretensos.size() && ListaDeEmpleadosPretensos.get(k).getEmpleadoPretenso().getNombUsuario() != empleadoPretenso)//recorro buscando la coincidencia en la lista de los empleados -> si aparece el nombre en esa lista entonces hay coincidencia
						k++;

					if(k < ListaDeEmpleadosPretensos.size()) //coincidencia
					{
						//AGREGAR EMPLEADO A LA LISTA DE EMPLEADOS CON COINCIDENCIA DEL ELEMENTO CREADO
					}
				}
				//CARGAR ELEMENTO A LA LISTA DE COINCIDENCIAS
				
			}
			return null;
		}


	//Hay que crear una lista de contratados, ya que de la lista de coincidencias puede pasar que: 
		//  como un empleador puede elegir mas empleadosPretensos de la cantidad solicitada, puede pasar que todos los empleados pretensos lo allan elegido 
		//por lo que el problema seria que no puede contratar mas de lo solicitado 
		//  ----> posible solucion, se contrata a las N primeros por tener los mejores puntajes 

		public ArrayList<ListAsignacionEmpleador> ListaDeContrataciones( ArrayList<ListAsignacionEmpleador> ListaCoincidencias)
		{
			//NECESITO LA CANTIDAD DE SOLICITADOS EN EL TICKET

			ArrayList<EmpleadoPretenso> ListaPosiblesEmpleados;

			for(int i=0; i< ListaCoincidencias.size(); i++)
			{
				ListaPosiblesEmpleados = ListaCoincidencias.get(i).getListEmpleadosPretensos();

				//eminimal los que sobren de  la cantidad solicitada en el ticket de empelador
			}
			return null;
		}

	}


>>>>>>> Stashed changes
