package interfaces;

import java.util.ArrayList;

import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import paquete.Empleador;

public interface MuestraListaEmpleadores
{

	// ListAsignacionEmpleadPretenso guarda un empleadoPretenso con una array de
	// empresas

	// funcionalidad del agencia
	public void mostrarListaEmpleadores(ArrayList<Empleador> empleador);

	/// metodo que muestre solicitud (que es una solicutud)

	// funcionalidad empleador (donde llame al metodo, le debee pasar el nodo de la
	// empresa, es decir que no se encarga de buscarse en el array de agencia)
	// el metodo puede mostrar tanto la lista de asignacion como la lista con las
	// contrataciones, ya que
	// asumo que se tendra una unica lista con las contrataciones(de tipo
	// ListAsignacionEmpleador)para evitar la doble referencia

	public void mostrarListaAsignacionDelEmpleadoPretenso(ListAsignacionEmpleadPretenso lista);
	// la doble referencia aplica en este caso?
	// el empleado debe buscarse entre todas las empresas hasta encontrarse ver si
	// no hay mejor forma
	/// si no llega a estar en ningunaparte -->> LANZAR EXCEPTION u tratar el caso

	public void mostrarResultado(ArrayList<ListAsignacionEmpleador> lista);

}
