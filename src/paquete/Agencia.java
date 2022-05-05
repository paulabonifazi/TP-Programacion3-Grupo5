package paquete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.SortedSet;

import modelo.EmpleadorPuntaje;
import modelo.ListAsignacionEmpleadPretenso;
import tablas.PuntajeTicket;

public class Agencia
{
	private static Agencia instancia = null;
	private String nombre;

	private ArrayList<Empleador> empleadores = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso> ();
	
	
	
	
	
	private Agencia() {
		
	}
	
	
	public static Agencia getInstance()
	{
		if (Agencia.instancia == null)
			Agencia.instancia = new Agencia();
		
		return instancia;
	}

	
	//Ronda de encuentros laborales:

	/*
	public SortedSet<EmpleadoPretenso> creaListaOrdEmpleadosPretensos(ArrayList<EmpleadoPretenso> empleadosPretensos)
	{
		SortedSet<EmpleadoPretenso> empleadosPretensosOrd =  (SortedSet<EmpleadoPretenso>) new HashSet<EmpleadoPretenso>(empleadosPretensos);
		
		return empleadosPretensosOrd;
		
	}
	
	public SortedSet<Empleador> creaListaOrdEmpleadores(ArrayList<Empleador> empleadores)
	{
		SortedSet<Empleador> empleadoresOrd = (SortedSet<Empleador>) new HashSet<Empleador>(empleadores);
		
		return empleadoresOrd;
		
	}
	
	*/
	
	/*
	 * estos metodos son llamados luego de haberse realizado las rondas de encuentros
	 * en las rondas de encuentros hay que considerar el estado del ticket
	 * primero crearía las listas de encuentros(analizando valor del ticket,
	 *  ver si hay match, etc etc) y luego ordenar dichas listas con los métodos 
	 *  sortedset de arriba o los métodos que realizó kevin (ANALIZAR) en la clase ronda encuentros
	 *  una vez obtenidas las listas ordenadas se procede a la contratacion.
	 *  una vez realizada dicha contratacion se agregan ambos (empleador y empleado pretenso)
	 *  a una lista de contrataciones en agencia!
	 * 
	 */
	
	
	
}
