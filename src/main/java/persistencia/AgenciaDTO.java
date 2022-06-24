package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.EmpleadoPretenso;
import modelo.Empleador;
import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;

public class AgenciaDTO implements Serializable{
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso> ();
	
	private ArrayList<Empleador> empleadoresActivos = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensosActivos = new ArrayList<EmpleadoPretenso> ();
		
	private ArrayList<ListAsignacionEmpleador> listAsignacionEmpleador = new ArrayList<ListAsignacionEmpleador>();//lista de empresas con sus posibles empleados ordenados
	private ArrayList<ListAsignacionEmpleadPretenso> listAsignacionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();//lista de empleadosPretenso con sus posibles empresas ordenados

	private ArrayList<ListAsignacionEmpleador> listEleccionEmpleador = new ArrayList<ListAsignacionEmpleador>();//lista de empresas con sus posibles empleados ordenados
	private ArrayList<ListAsignacionEmpleadPretenso> listEleccionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();//lista de empleadosPretenso con sus posibles empresas ordenados
	
	private ArrayList<ListAsignacionEmpleador> listaCoincidencias = new ArrayList<ListAsignacionEmpleador>();//lista que guarda las coincidencias entre empresa y empleado

	private double saldoAgencia = 0;
	
	

	public AgenciaDTO(ArrayList<Empleador> empleadores, ArrayList<EmpleadoPretenso> empleadosPretensos,
			ArrayList<Empleador> empleadoresActivos, ArrayList<EmpleadoPretenso> empleadosPretensosActivos,
			ArrayList<ListAsignacionEmpleador> listAsignacionEmpleador,
			ArrayList<ListAsignacionEmpleadPretenso> listAsignacionEmpleadoPretensos,
			ArrayList<ListAsignacionEmpleador> listEleccionEmpleador,
			ArrayList<ListAsignacionEmpleadPretenso> listEleccionEmpleadoPretensos,
			ArrayList<ListAsignacionEmpleador> listaCoincidencias, double saldoAgencia) {
		super();
		this.empleadores = empleadores;
		this.empleadosPretensos = empleadosPretensos;
		this.empleadoresActivos = empleadoresActivos;
		this.empleadosPretensosActivos = empleadosPretensosActivos;
		this.listAsignacionEmpleador = listAsignacionEmpleador;
		this.listAsignacionEmpleadoPretensos = listAsignacionEmpleadoPretensos;
		this.listEleccionEmpleador = listEleccionEmpleador;
		this.listEleccionEmpleadoPretensos = listEleccionEmpleadoPretensos;
		this.listaCoincidencias = listaCoincidencias;
		this.saldoAgencia = saldoAgencia;
	}

	public ArrayList<Empleador> getEmpleadoresActivos() {
		return empleadoresActivos;
	}

	public void setEmpleadoresActivos(ArrayList<Empleador> empleadoresActivos) {
		this.empleadoresActivos = empleadoresActivos;
	}

	public ArrayList<EmpleadoPretenso> getEmpleadosPretensosActivos() {
		return empleadosPretensosActivos;
	}

	public void setEmpleadosPretensosActivos(ArrayList<EmpleadoPretenso> empleadosPretensosActivos) {
		this.empleadosPretensosActivos = empleadosPretensosActivos;
	}

	public ArrayList<ListAsignacionEmpleador> getListAsignacionEmpleador() {
		return listAsignacionEmpleador;
	}

	public void setListAsignacionEmpleador(ArrayList<ListAsignacionEmpleador> listAsignacionEmpleador) {
		this.listAsignacionEmpleador = listAsignacionEmpleador;
	}

	public ArrayList<ListAsignacionEmpleadPretenso> getListAsignacionEmpleadoPretensos() {
		return listAsignacionEmpleadoPretensos;
	}

	public void setListAsignacionEmpleadoPretensos(
			ArrayList<ListAsignacionEmpleadPretenso> listAsignacionEmpleadoPretensos) {
		this.listAsignacionEmpleadoPretensos = listAsignacionEmpleadoPretensos;
	}

	public ArrayList<ListAsignacionEmpleador> getListEleccionEmpleador() {
		return listEleccionEmpleador;
	}

	public void setListEleccionEmpleador(ArrayList<ListAsignacionEmpleador> listEleccionEmpleador) {
		this.listEleccionEmpleador = listEleccionEmpleador;
	}

	public ArrayList<ListAsignacionEmpleadPretenso> getListEleccionEmpleadoPretensos() {
		return listEleccionEmpleadoPretensos;
	}

	public void setListEleccionEmpleadoPretensos(ArrayList<ListAsignacionEmpleadPretenso> listEleccionEmpleadoPretensos) {
		this.listEleccionEmpleadoPretensos = listEleccionEmpleadoPretensos;
	}

	public ArrayList<ListAsignacionEmpleador> getListaCoincidencias() {
		return listaCoincidencias;
	}

	public void setListaCoincidencias(ArrayList<ListAsignacionEmpleador> listaCoincidencias) {
		this.listaCoincidencias = listaCoincidencias;
	}

	public double getSaldoAgencia() {
		return saldoAgencia;
	}

	public void setSaldoAgencia(double saldoAgencia) {
		this.saldoAgencia = saldoAgencia;
	}

	public AgenciaDTO() {
		super();
	}
	
	public void agregarEmpleador (Empleador empleador) {
		this.empleadores.add(empleador);
	}
	
	public void agregarEmpleadoPretenso (EmpleadoPretenso empleadoPretenso) {
		this.empleadosPretensos.add(empleadoPretenso);
	}
	

	public ArrayList<Empleador> getEmpleadores() {
		return empleadores;
	}

	public void setEmpleadores(ArrayList<Empleador> empleadores) {
		this.empleadores = empleadores;
	}

	public ArrayList<EmpleadoPretenso> getEmpleadosPretensos() {
		return empleadosPretensos;
	}

	public void setEmpleadosPretensos(ArrayList<EmpleadoPretenso> empleadosPretensos) {
		this.empleadosPretensos = empleadosPretensos;
	}

	

}
