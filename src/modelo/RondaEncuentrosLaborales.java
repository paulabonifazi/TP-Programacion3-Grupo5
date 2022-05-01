
///quien dispara la Ronda? LO HACE AGENCIA
	//agencia tendria un arrayList de rondas?


/// las listas de asignacion son particulares para cada uno///
/*
recibo la lista de empleados y empleadores de agencia

tomo la primer empresa y le creo lista asignacion de empleadPretenso (ejecuto el calculu puntaje a cada emplPrete y los ordeno en una lista)
		para guardar estos datos necesito una lista de empresas con un campo de lista de posibles empleados
	
		
tomo el primer empleado y le creo lista asignacion de empresa (ejecuto el calculu puntaje a cada empresay los ordeno en una lista)
		para guardar estos datos necesito una lista de empleados con un campo de lista de posibles empresas
		
en este punto tengo dos listas (con todas las empresas y todos los empleados)
							una de empresas con los empleados ordenados (listAA)
							una de empleados con las empresas ordenadas (listaBB)
				
en alguna parte la empresa quiere ver sus candidatos -> le doy listaAA.ListCandidatos (al ser una lista con un campo de lista -> ubico la empresa y mando la lista pertinente)
	hace su eleccion y me devuelve listPosibleCandidatos (esto se repite con todas las empresas)
armo una nueva lista de tipo listaAA donde el campo empleado sera el que me devolvierosv(listPosibleCandidato)

lo mismo que arriba pero para empleadPretenso

cuando todos terminen sus elecciones (ver como verificar)

en este punto tengo dos nuevas listas
						la de empresas (listaAAFinal) estas lista tienen sus elecciones
						la de empleados (listaBBFinal)

por ultimo armo las listas de contrataciones (lista de tipo listAA y listBB)
							no podria tener una unica lista por que si un empleadPretenso quisiera ver quien lo contrato deberia de 
							recorrer todas las empresas buscandose (el campo puntaje no es pertinernte, no implica que escojiese la de mejor puntaje)
							
al final agencia tiene sus 
	
		*/				
					


package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import paquete.EmpleadoPretenso;
import paquete.Empleador;
import tablas.PuntajeTicket;

///cuando se defina como agencia llama a la ronda y les manda los datos a emplead/res se completan los arrays y corrijo lo de getEmpleado 

public class RondaEncuentrosLaborales {///podria se abstract u hacerlo en otra clase
	
	/*ArrayList<ListAsignacionEmpleadPretenso> listaCoincidenciaEmpleadPretenso = new ArrayList<ListAsignacionEmpleadPretenso>();//el resultado que me devuelven
	ArrayList<ListAsignacionEmpleador> listaCoincidenciaEmpleador = new ArrayList<ListAsignacionEmpleador>();	*/
	
///a este metodo lo llama agencia y le devuelve una lista  de empresas a cada empleadoPretenso
	///definir el tipo de arrayList
	public ArrayList listasAsignacionEmpleadoPretenso(ArrayList<Empleador> empleador,  ArrayList<EmpleadoPretenso> empleadosPretensos) {//las lista deberian venir ordenadas por algun criterio, por si hay que haver alguna busqueda futura
		
		ArrayList<ListAsignacionEmpleadPretenso> listaAsignEmpleadPretenso = new ArrayList<ListAsignacionEmpleadPretenso>();///las que se le muestran al user
		ListAsignacionEmpleadPretenso nuevoNodo = new ListAsignacionEmpleadPretenso();	
		
		for (int i=0; i<empleadosPretensos.size(); i++) {
			nuevoNodo.setEmpleadoPretenso(empleadosPretensos.get(i));
			
			nuevoNodo.setListEmpleadores(metodoOrdenamientoEpleadoPretenso(empleadosPretensos.get(i), empleador));///traigo una lista de las empresas 
			
			listaAsignEmpleadPretenso.add(nuevoNodo);
		
		}
	 
	return listaAsignEmpleadPretenso;
	}
	
///a este metodo lo llama agencia y le devuelve una lista  de empleadosPretensos a cada empresa

	public ArrayList listasAsignacionEmpresa(ArrayList<Empleador> empleador,  ArrayList<EmpleadoPretenso> empleadosPretensos) {
		
		ArrayList<ListAsignacionEmpleador> listaAsignEmpleador = new ArrayList<ListAsignacionEmpleador>();///las que se le muestran al user
		ListAsignacionEmpleador nuevoNodo = new ListAsignacionEmpleador();	
		
		for (int i=0; i<empleador.size(); i++) {
			nuevoNodo.setEmpleador(empleador.get(i));
			nuevoNodo.setListEmpleadosPretensos(metodoOrdenamientoEmpleador(empleador.get(i) , empleadosPretensos));//traigo una lista de empleadosPretensos
			
			listaAsignEmpleador.add(nuevoNodo);
		
		}	

		return listaAsignEmpleador;
	}
	
	
	

		///crear una nueva lista con puntaje y empleadoPretenso
		//la insercion es ordenada segun el puntaje
			
		

	public ArrayList<EmpleadoPretenso> metodoOrdenamientoEmpleador(Empleador empleador, ArrayList<EmpleadoPretenso> listaEmpleaPretenso) {
		
		ArrayList<EmpleadoPretenso> lista = new  ArrayList<EmpleadoPretenso>();
		ArrayList<ListaEmpleadPretensoPuntaje> listaOrdenada = new ArrayList<ListaEmpleadPretensoPuntaje>();
		ListaEmpleadPretensoPuntaje empleadoPretensPuntaje = new ListaEmpleadPretensoPuntaje();
		
		for (int i=0; i<=listaEmpleaPretenso.size(); i++) {///creo la listaCon Puntajes (listaOrdenada)
			
			empleadoPretensPuntaje.setEmpleadoPretenso(listaEmpleaPretenso.get(i));
			empleadoPretensPuntaje.setPuntaje(new PuntajeTicket().getPuntaje("conseguiFB", "ConseguirFB"));//considerar hacer el new afuera 
			
			listaOrdenada.add(empleadoPretensPuntaje);
		}
		
		////reveer como ordenarlo
		Collections.sort(listaOrdenada, new Comparator<ListaEmpleadPretensoPuntaje>() {
			@Override
			public int compare(ListaEmpleadPretensoPuntaje p2, ListaEmpleadPretensoPuntaje p1) {
				return new Double(p2.getPuntaje()).compareTo(new Double(p1.getPuntaje()));
			}
		});
		
		
		for (int j = 0; j< listaOrdenada.size(); j++) ///cargo lista con el orden de listaOrdenada
			lista.add(listaOrdenada.get(j).getEmpleadoPretenso());
		
	return lista;

	
	///al finalizar el metodo tendre 2 lista ordenadas una con un campo puntaje y la otra no,,, devuelvo la ultima	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Empleador> metodoOrdenamientoEpleadoPretenso(EmpleadoPretenso empleadoPretenso, ArrayList<Empleador> empleador) {
		ArrayList <Empleador> lista = new ArrayList <Empleador>();
		

		return lista;
		
	}
	
	/*
en Agencia tendre dos lista con las lista que cree arriba
	se les muestra la lista pertinente a cada empleado/dor para que tomen sus deciciones
	agencia crea dos nuevas listas con las decicioens que las solicito para armar el metod de abajo
*/
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList RondaContratacion(ArrayList desicionEmpresas,  ArrayList desicionEmpleadPretens) {///devuelvo una lista de emprresas con los empleados contratados
	//cada empleado para saber que empresa los contrato se tendria que buscar entre todas las empresas
		
		//creo un for
	//en la primer posicion pongo de listaFinal pongo la primer empresa de desicionEmpresa
		//	recorro desicionempleadPretenso 
		//  busco si coincide la empresa actual con su eleccion
		//	si es v la agrego y elimino el elemento, si es f paso ala siguiente /**si crease 2 lista, en este punto agrego a ambas lsitas/

		return lista;
		
	}///ver si es mas combeniete 2 listas una de empresas con los empleados contratados y otra de empleados con la empresa en la que quedo
			///doble referecnia
	
}
