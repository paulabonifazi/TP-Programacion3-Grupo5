package interfaces;

import java.util.ArrayList;

import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import paquete.EmpleadoPretenso;


//interfaz que contiene los métodos que muestran las listas que los empleadores tienen!
public interface IMuestraListasEmpleadores
{
	public void mostrarListaEmpleadosPretensos(ArrayList<EmpleadoPretenso> empleadoPretenso);

	public void mostrarListaAsignacionDelEmpleador(ListAsignacionEmpleador lista);
	
	public void mostrarResultado(ArrayList<ListAsignacionEmpleadPretenso> lista);
}