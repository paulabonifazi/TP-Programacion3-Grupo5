package modelo;

import paquete.Empleador;

import java.util.ArrayList;

import paquete.Empleado;

public class ListAsignacionEmpleador {

	private Empleador empleador;
	private ArrayList <Empleado> listEmpleadosPretensos = new ArrayList <Empleado>();
	public Empleador getEmpleador() {
		return empleador;
	}
	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}
	public ArrayList<Empleado> getListEmpleadosPretensos() {
		return listEmpleadosPretensos;
	}
	public void setListEmpleadosPretensos(ArrayList<Empleado> listEmpleadosPretensos) {
		this.listEmpleadosPretensos = listEmpleadosPretensos;
	}
	
	
	
	
}
