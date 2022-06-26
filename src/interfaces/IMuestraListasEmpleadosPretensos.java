package interfaces;

import java.util.ArrayList;

import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import paquete.Empleador;

//interfaz que contiene los m�todos que muestran las listas que los empleados pretensos tienen!

public interface IMuestraListasEmpleadosPretensos
{
	public void mostrarListaEmpleadores(ArrayList<Empleador> empleador);
	
	public void mostrarListaAsignacionDelEmpleadoPretenso(ListAsignacionEmpleadPretenso lista);
	
	public void mostrarResultado(ArrayList<ListAsignacionEmpleador> lista);
}