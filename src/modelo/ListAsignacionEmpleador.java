package modelo;

import java.util.ArrayList;

import paquete.EmpleadoPretenso;
import paquete.Empleador;

///hize el push sobre 
public class ListAsignacionEmpleador {

	private Empleador empleador;
	private ArrayList <EmpleadoPretenso> listEmpleadosPretensos = new ArrayList <EmpleadoPretenso>();
	
	public Empleador getEmpleador() {
		return empleador;
	}
	
	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}
	
	public ArrayList<EmpleadoPretenso> getListEmpleadosPretensos() {
		return listEmpleadosPretensos;
	}
	
	public void setListEmpleadosPretensos(ArrayList<EmpleadoPretenso> listEmpleadosPretensos) {
		this.listEmpleadosPretensos = listEmpleadosPretensos;
	}
}