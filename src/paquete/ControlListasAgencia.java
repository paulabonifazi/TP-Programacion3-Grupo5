package paquete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import modelo.ControlEstadosTicket;
import modelo.EmpleadPretensoPuntaje;
import modelo.EmpleadorPuntaje;
import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import tablas.PuntajeTicket;

public class ControlListasAgencia {

	
	public ArrayList<ListAsignacionEmpleador> generarListAsignacionEmpleador(ArrayList<EmpleadoPretenso> empleadosPretensosActivos,ArrayList<Empleador> empleadoresActivos) {
		ArrayList<ListAsignacionEmpleador> listAsignacionEmpleador = new ArrayList<ListAsignacionEmpleador>();
		for (int i=0; i<empleadoresActivos.size(); i++)
			listAsignacionEmpleador.add(listasAsignacionEmpresa(empleadosPretensosActivos,empleadoresActivos.get(i)));
			System.out.println("blalalalala"+listAsignacionEmpleador.get(i));
		return listAsignacionEmpleador;
	}
	
	public ArrayList<ListAsignacionEmpleadPretenso> generarListAsignacionEmpleadoPretenso(ArrayList<EmpleadoPretenso> empleadosPretensosActivos,ArrayList<Empleador> empleadoresActivos) {
		ArrayList<ListAsignacionEmpleadPretenso> listAsignacionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();
		for (int i=0; i<empleadosPretensosActivos.size(); i++)
			listAsignacionEmpleadoPretensos.add(listasAsignacionEmpleadoPretenso(empleadoresActivos, empleadosPretensosActivos.get(i)));
		return listAsignacionEmpleadoPretensos;
	}
		
	//filtro solo ticket activos
	public static ArrayList<EmpleadoPretenso> filtroTicketActivoEmpleadosPretensos(ArrayList<EmpleadoPretenso> empleadosPretensos) {
		ArrayList<EmpleadoPretenso> empleadosPretensosActivos = new ArrayList<EmpleadoPretenso>();
		for (int i=0; i<empleadosPretensos.size();i++) {
			if (empleadosPretensos.get(i).getTicket().getEstadoTicket().getEstado().equals("Activo")) {
				empleadosPretensosActivos.add(empleadosPretensos.get(i));
				//System.out.println(empleadosPretensosActivos.get(i));
			}
		}
		return empleadosPretensosActivos;
	}
	
	public static ArrayList<Empleador> filtroTicketActivoEmpleadores(ArrayList<Empleador> empleadores) {
		ArrayList<Empleador> empleadoresActivos = new ArrayList<Empleador>();
		for (int i=0; i<empleadores.size();i++) {
			if (empleadores.get(i).getTicket().getEstadoTicket().getEstado().equals("Activo")) {
				empleadoresActivos.add(empleadores.get(i));
				//System.out.println(empleadoresActivos.get(i));
			}
		}
		return empleadoresActivos;
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
	
	for (int i=0; i<listaEmpleadores.size(); i++) {///creo la lista Con Puntajes 
		empleadorPuntaje.setEmpleador(listaEmpleadores.get(i)); 
		empleadorPuntaje.setPuntaje(new PuntajeTicket().getPuntajeFC(listaEmpleadores.get(i), empleadoPretensos.getTicket())); 
				//(a,b) que el (b,a) de la tabla por que si no lo es .> necisto cambiar FC a CF
		listaOrdenada.add(empleadorPuntaje);
		}
	

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
	
		for (int i=0; i<listaEmpleaPretenso.size(); i++) {///creo la lista Con Puntajes 
			
				empleadoPretensPuntaje.setEmpleadoPretenso(listaEmpleaPretenso.get(i));
				empleadoPretensPuntaje.setPuntaje(new PuntajeTicket().getPuntajeCF(empleador, listaEmpleaPretenso.get(i).getTicket()));
				listaOrdenada.add(empleadoPretensPuntaje);
			}
	
		
	Collections.sort(listaOrdenada, new Comparator<EmpleadPretensoPuntaje>() {
		@Override
		public int compare(EmpleadPretensoPuntaje p2, EmpleadPretensoPuntaje p1) {
				return new Double(p2.getPuntaje()).compareTo(new Double(p1.getPuntaje()));
				}
		});
	
	for (int j = 0; j< listaOrdenada.size(); j++) ///cargo lista con el orden de listaOrdenada
		{lista.add(listaOrdenada.get(j).getEmpleadoPretenso());
		}
	
	return lista;
	
	}
		
		//  METODO COINCIDENCIAS -> buscar las coincidencias y guardar en un arrayList del mismo tipo quer la lista de empleadores

		//recibo 2 arrayList de arrayList
		//									-> ListaDeEmpleadores = Cada nodo tiene la empleados y un arrayList de a los empleados Pretensos que eligio
		//									-> ListaDeEmpleadosPretensos = Cada nodo tiene al empleado Pretenso y al unico empleador que eligio
		
		//Recorrer el arrayListe de empleadores y buscar en el de empleadosPretensos si coinciden

	///comenzar las lista en null, -> si en algun momento se pide mostra u sumilat sy es null -> no hay nada
		
	  ///equivale a lista de contrataciones
		
	 public  ArrayList<ListAsignacionEmpleador> ListaCoincidencias (ArrayList<ListAsignacionEmpleador> ListaDeEmpleadores, ArrayList<ListAsignacionEmpleadPretenso> ListaDeEmpleadosPretensos) 
		{	
			 ListAsignacionEmpleador nodo = new ListAsignacionEmpleador();
			 ArrayList<EmpleadoPretenso>empleado;
			 ArrayList<ListAsignacionEmpleador> listaCoincidencias = new ArrayList<ListAsignacionEmpleador>();
			 
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
						ListaDeEmpleadores.get(i).getEmpleador().getTicket().setCantEmpleadosObtenidos(1);
					}
					cont++;
				}
				listaCoincidencias.add(nodo);
				
				System.out.println("ListaCoincidencias"+listaCoincidencias.get(i).getListEmpleadosPretensos().size());
			}
			
			
			return listaCoincidencias;
				
		}
	
}
