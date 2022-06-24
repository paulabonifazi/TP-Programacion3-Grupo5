package interfaces;

import java.util.ArrayList;

import modelo.Empleador;
import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;

//interfaz que contiene los métodos que muestran las listas que los empleados pretensos tienen!

public interface IMuestraListasEmpleadosPretensos
{
	public void mostrarListaEmpleadores(ArrayList<Empleador> empleador);
	
	public void mostrarListaAsignacionDelEmpleadoPretenso(ListAsignacionEmpleadPretenso lista);
	
	public void mostrarResultado(ArrayList<ListAsignacionEmpleador> lista);
}