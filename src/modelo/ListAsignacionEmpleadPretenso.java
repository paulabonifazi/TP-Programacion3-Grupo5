package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class ListAsignacionEmpleadPretenso implements Serializable{

	private EmpleadoPretenso empleadoPretenso;
	private ArrayList <Empleador> listEmpleadores = new ArrayList <Empleador>();
	

	public ListAsignacionEmpleadPretenso() {
		super();
	}

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
