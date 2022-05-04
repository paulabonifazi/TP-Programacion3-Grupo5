/* aclaraciones 
 * 		clases que funcionan como objeto
			ListAsignacionEmpleadPretenso guarda un empleadoPretenso con una array de empresas
			ListAsignacionEmpleador guarda una empresa con un array de empleadoPretensos
			
			EmpleadorPuntaje guarda una empresa con el puntaje que obtuvo en las tablas
			EmpleadoPretensPuntaje guarda un empleadoPretenso con el puntaje que obtuvo en las tablas

agencia debe tener los metodo que generen las superListas (todas las empresas con todos sus posibles empleados y viceversa)


la clase PuntajeTicketFC y PuntajeTicketCF acceden a la pos a,b y b,a en las tablas

*/

package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import paquete.EmpleadoPretenso;
import paquete.Empleador;
import tablas.PuntajeTicket;


public class RondaEncuentrosLaborales {
	
///a este metodo lo llama agencia y le devuelve un nodo que contiene una lista de empresas para empleadoPretenso (agencia se debe encargar de ir guardandolos en un array)
																						///array de todas las empresas y el empleadoPretenso al que se le va agenerar la lista
	public ListAsignacionEmpleadPretenso listasAsignacionEmpleadoPretenso(ArrayList<Empleador> empleador,  EmpleadoPretenso empleadoPretensos) {
		
		ListAsignacionEmpleadPretenso nuevoNodo = new ListAsignacionEmpleadPretenso();	
		
		nuevoNodo.setEmpleadoPretenso(empleadoPretensos);
		nuevoNodo.setListEmpleadores(metodoOrdenamientoEpleadoPretenso(empleadoPretensos, empleador));///traigo una lista de las empresas ordenada
			
		return nuevoNodo;
	}
	
	
	///el metodo me devuelve una listaOrdenada de empresas para el empleadoPretneos en cuestion
	public ArrayList<Empleador> metodoOrdenamientoEpleadoPretenso( EmpleadoPretenso empleadoPretensos, ArrayList<Empleador> listaEmpleadores) {
		
		ArrayList<Empleador> lista = new  ArrayList<Empleador>();						//lista que voy a devolver
		ArrayList<EmpleadorPuntaje> listaOrdenada = new ArrayList<EmpleadorPuntaje>();   //lista que contiene el puntaje y se ordena segun este atributo
		
		EmpleadorPuntaje empleadorPuntaje = new EmpleadorPuntaje();	
		
		for (int i=0; i<=listaEmpleadores.size(); i++) {///creo la lista Con Puntajes 
			
			empleadorPuntaje.setEmpleador(listaEmpleadores.get(i)); 
			empleadorPuntaje.setPuntaje(new PuntajeTicket().getPuntajeFC(listaEmpleadores.get(i), empleadoPretensos.getTicket())); ///considerar hacer el new afuera ///es lo mismo el
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

	///al finalizar el metodo tendre 2 lista ordenadas una con un campo puntaje y la otra no,,, devuelvo la ultima		
	}
	





///a este metodo lo llama agencia y le devuelve un nodo que tine una lista de empleadosPretensos para la empresa (agencia se debe encargar de ir guardandolos en un array)

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
			empleadoPretensPuntaje.setPuntaje(new PuntajeTicket().getPuntajeCF(empleador, listaEmpleaPretenso.get(i).getTicket()));//considerar hacer el new afuera 
			
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

	///al finalizar el metodo tendre 2 lista ordenadas una con un campo puntaje y la otra no,,, devuelvo la ultima	
		
	}
	
	///no hago todo en un metodo, porque puede ser que quiera la lista solo de las empresas u empleados (tipo una funcionalidad que me deja ver los candidatos pero no seleccionar, solo ver)

	
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

/*
 * analizar para que la agencia se encargue!!
 * terminar métodos!
 */
 */