package modelo;

import paquete.Empleador;

import java.util.ArrayList;

import paquete.Empleado;

public class ListAsignacionEmpleadPretenso {

	private Empleado empleadoPretenso;
	private ArrayList <Empleador> listEmpleados = new ArrayList <Empleador>();
	

	public Empleado getEmpleadoPretenso() {
		return empleadoPretenso;
	}
	public void setEmpleadoPretenso(Empleado empleadoPretenso) {
		this.empleadoPretenso = empleadoPretenso;
	}
	
	public ArrayList<Empleador> getListEmpleados() {
		return listEmpleados;
	}
	public void setListEmpleados(ArrayList<Empleador> listEmpleados) {
		this.listEmpleados = listEmpleados;
	}
	
	
	
}
