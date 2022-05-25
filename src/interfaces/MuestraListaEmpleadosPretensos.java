package interfaces;

import java.util.ArrayList;

import excepciones.NoCoincidenciaException;
import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import paquete.EmpleadoPretenso;

public interface MuestraListaEmpleadosPretensos
{

	//	ListAsignacionEmpleador guarda una empresa con un array de empleadoPretensos	
	// funcionalidad del agencia

	// metodo que muestre solicitud (que es una solicutud)

	public void mostrarListaEmpleadosPretensos(ArrayList<EmpleadoPretenso> empleadoPretenso);

	public void mostrarListaAsignacionDelEmpleador(ListAsignacionEmpleador lista);
	// la doble referencia aplica en este caso?
	// el empleado debe buscarse entre todas las empresas hasta encontrarse ver si
	// no hay mejor forma
	/// si no llega a estar en ningunaparte -->> LANZAR EXCEPTION u tratar el caso

	public void mostrarResultado(ArrayList<ListAsignacionEmpleadPretenso> lista) throws NoCoincidenciaException;
}