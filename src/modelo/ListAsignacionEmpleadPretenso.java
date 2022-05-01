package modelo;



import java.util.ArrayList;

import paquete.EmpleadoPretenso;
import paquete.Empleador;

public class ListAsignacionEmpleadPretenso {

	private EmpleadoPretenso empleadoPretenso;
	private ArrayList <Empleador> listEmpleadores = new ArrayList <Empleador>();
	

	public EmpleadoPretenso getEmpleadoPretenso() {
		return empleadoPretenso;
	}
	public void setEmpleadoPretenso(EmpleadoPretenso empleadoPretenso) {
		this.empleadoPretenso = empleadoPretenso;
	}
	
	public ArrayList<Empleador> getListEmpleadores() {
		return listEmpleadores;
	}
	public void setListEmpleadores(ArrayList<Empleador> listEmpleados) {
		this.listEmpleadores = listEmpleados;
	}
	
	
	
}
