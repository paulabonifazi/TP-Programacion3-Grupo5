
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

import paquete.Empleador;




public class RondaEncuentrosLaborales {///podria se abstract u hacerlo en otra clase
	ArrayList<ListAsignacionEmpleadPretenso> listaAsignEmpleadPretenso = new ArrayList<ListAsignacionEmpleadPretenso>();///las que se le muestran al user
	ArrayList<ListAsignacionEmpleador> listaAsignEmpleador = new ArrayList<ListAsignacionEmpleador>();	
	
	
	ArrayList<ListAsignacionEmpleadPretenso> listaCoincidenciaEmpleadPretenso = new ArrayList<ListAsignacionEmpleadPretenso>();//el resultado que me devuelven
	ArrayList<ListAsignacionEmpleador> listaCoincidenciaEmpleador = new ArrayList<ListAsignacionEmpleador>();	
	
	
	///definir el tipo de arrayList
	public ArrayList listasAsignacionEmpleadoPretenso(ArrayList empleador,  ArrayList empleadosPretensos) {//las lista deberian venir ordenadas por algun criterio, por si hay que haver alguna busqueda futura
		///creo un for
		//copio en la posicion i empleadoPretenso.getEmpleaPreten en listaAsignEmpleadPretenso.empleadoPretenso
		//listaAsignEmpleadPretenso.empresas = metodo listaOrdenEmpresaPorPuntaje
		
		ListAsignacionEmpleadPretenso nuevoNodo = new ListAsignacionEmpleadPretenso();	
		
		for (int i=0; i<empleadosPretensos.size(); i++) {
			nuevoNodo.setEmpleadoPretenso(empleadosPretensos.get(i)./*getEmpleadoPretenso*/);
			
			nuevoNodo.setListEmpleados()=metodoOrdenamientoEmpresa(empleador.get(i),empleadosPretensos);
			
			
			listaAsignEmpleadPretenso.add(nuevoNodo);
		}
	 
	return listaAsignEmpleadPretenso;
	}

	public ArrayList listasAsignacionEmpresa(ArrayList empleador,  ArrayList empleadosPretensos) {
		///creo un for
		//copio en la posicion i empleador.getEmpleador en listaAsignEmpleador.empleador
		//listaAsignEmpleador.empleadoPretenao = metodo listaOrdenEmpleadPretensPuntaje     ////ver si puedo usar el mismo metodo que arriba
		

		///commit//

		
	}
	
	public ArrayList metodoOrdenamientoEmpresa(Empleador empleador, ArrayList listaEmpleaPretenso) {
		
		///crear una nueva lista con puntaje y empleadoPretenso
			//la insercion es ordenada segun el puntaje
				//la insercion es doble  para la nuevaLista con puntaje propia de este metodo y para la lista que tiene que devolver
		//-.> si 

		
		///al finalizar el metodo tendre 2 lista ordenadas una con un campo puntaje y la otra no,,, devuelvo la ultima
		

		return null;
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
