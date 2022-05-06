package paquete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.SortedSet;

import modelo.EmpleadorPuntaje;
import modelo.ListAsignacionEmpleadPretenso;
import tablas.PuntajeTicket;

import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import modelo.RondaEncuentrosLaborales;

public class Agencia
{
	private static Agencia instancia = null;
	private String nombre;

	private ArrayList<Empleador> empleadores = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso> ();
	
	
	
	
	
	private ArrayList<EmpleadoPretenso> listaEmpleadoPretenso = new ArrayList<EmpleadoPretenso>();  ///listas de empleadosPretensos
	private ArrayList<Empleador> listaEmpleadores = new ArrayList<Empleador>();						///lista empleadores
	
	private ArrayList<ListAsignacionEmpleador> listAsignacionEmpleador = new ArrayList<ListAsignacionEmpleador>();//lista de empresas con sus posibles empleados ordenados
	private ArrayList<ListAsignacionEmpleadPretenso> listAsignacionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();//lista de empleadosPretenso con sus posibles empresas ordenados
	
	private ArrayList<ListAsignacionEmpleador> listaContratacion = new ArrayList<ListAsignacionEmpleador>();//lista que guarda las coincidencias entre empresa y empleado
		///unica lista para evitar la doble referencia de que empleadoPretensis conosca a empresa (si empleadoPretenso quiere saber con qyuien esta -> reviso la lista hasta encontrarla)
	
	
	
	///metodo que genere las lista de empresas y lista de empleadores 
	public void agregarEmpleador (Empleador empleador) {
		empleadores.add(empleador);
	}
	
	public void agregarEmpleadoPretenso (EmpleadoPretenso empleadoPretenso) {
		empleadosPretensos.add(empleadoPretenso);
	}
	
	
	///metodo que genere las listas de asignacion (con los metodos de RondaEncuentroLaboral) (punto 5 funcionalidad agencia)
	public void generarListAsignacionEmpleador() {
		for (int i=0; i<this.empleadores.size(); i++)
			listAsignacionEmpleador.add(RondaEncuentrosLaborales.listasAsignacionEmpresa(this.empleadosPretensos,this.empleadores.get(i)));///la idea general es esta, definir si dejmos REL o movemos los metodos aca
	}
	
	
	public void generarListAsignacionEmpleadoPretenso() {
		for (int i=0; i<this.empleadosPretensos.size(); i++)
			listAsignacionEmpleadoPretensos.add(RondaEncuentrosLaborales.listasAsignacionEmpleadoPretenso(this.empleadores, this.empleadosPretensos.get(i)));///la idea general es esta, definir si dejmos REL o movemos los metodos aca
	}
	
	
	///metodo que recolecte y arma la lista de las elecciones
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private Agencia() {	}
	
	
	
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
	
	
	
	
	///metodo que genere la lista con las contrataciones (emmpresa/empleado consultan en esta con quien se quedarton) (punto 6 funcionalidad agencia)
	///metodo que calcule las comisiones en base a esa lista
	///cambio en los estado de los tickets, actualizacion de los puntajes de usurario

	
	
