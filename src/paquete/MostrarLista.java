package paquete;

import java.util.ArrayList;

import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;

public class MostrarLista {
	///ver si es necesario que exista esta clase
	
//	ListAsignacionEmpleadPretenso guarda un empleadoPretenso con una array de empresas
//	ListAsignacionEmpleador guarda una empresa con un array de empleadoPretensos	
	// Empleador 
	
//funcionalidad del agencia
	public void mostrarListaEmpleadores(ArrayList<Empleador> empleador) {
		for (int i =0; i<empleador.size(); i++) 
			System.out.println(empleador.get(i).getNombUsuario());		
	}
	
	///metodo que muestre solicitud (que es una solicutud)
	
	public void mostrarListaEmpleadosPretenso(ArrayList<EmpleadoPretenso> empleadoPretenso) {
		for (int i =0; i<empleadoPretenso.size(); i++) 
			System.out.println(empleadoPretenso.get(i).getNombUsuario());		
	}
	
	
//funcionalidad empleador (donde llame al metodo, le debee pasar el nodo de la empresa, es decir que no se encarga de buscarse en el array de agencia)
//el metodo puede mostrar tanto la lista de asignacion como la lista con las contrataciones, ya que	
	//asumo que se tendra una unica lista con las contrataciones(de tipo ListAsignacionEmpleador)para evitar la doble referencia
		
	public void mostrarListaAsignacionEmpleador (ListAsignacionEmpleador lista) {
		for (int i=0; i<lista.getListEmpleadosPretensos().size(); i++)
			System.out.println(lista.getListEmpleadosPretensos().get(i).getNombUsuario());
	}
	
	
///empleadoPretenso algo similar
	
	public void mostrarListaAsignacionEmpleadoPretenso (ListAsignacionEmpleadPretenso lista) {
		for (int i=0; i<lista.getListEmpleadores().size(); i++)
			System.out.println(lista.getListEmpleadores().get(i).getNombUsuario());
	}
	
	//la doble referencia aplica en este caso?
	//el empleado debe buscarse entre todas las empresas hasta encontrarse ver si no hay mejor forma
	///si no llega a estar en ningunaparte -->> LANZAR EXCEPTION u tratar el caso
	
	public void mostrarResultado (ArrayList<ListAsignacionEmpleador> lista) {
		boolean coincidencia = false;
		int contEmpresa = 0;
		
		while (coincidencia==false && contEmpresa < lista.size()) {
			int contEmpleadoPretenso = 0;
				//comienzo la busqueda en el nodo
				while (coincidencia==false && contEmpleadoPretenso <= lista.get(contEmpresa).getListEmpleadosPretensos().size()) {
					if (lista.get(contEmpresa).getListEmpleadosPretensos().get(contEmpleadoPretenso).getNombUsuario().equals("dependeDondePongaElMetodo"))///ver si no hay otra forma de buscar
						coincidencia = true;
					else
						contEmpleadoPretenso++;
				}
			contEmpresa++;
		}
		
		//si coincidencia es false -> nadie lo contrato -> lanza exception u cartel
	}
	
}
