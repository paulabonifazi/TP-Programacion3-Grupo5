package modelo;



import java.util.ArrayList;

import paquete.EmpleadoPretenso;
import paquete.Empleador;

public class ListAsignacionEmpleadPretenso {

	private EmpleadoPretenso empleadoPretenso;
	private ArrayList <Empleador> listEmpleados = new ArrayList <Empleador>();
	

	public EmpleadoPretenso getEmpleadoPretenso() {
		return empleadoPretenso;
	}
	public void setEmpleadoPretenso(EmpleadoPretenso empleadoPretenso) {
		this.empleadoPretenso = empleadoPretenso;
	}
	
	public ArrayList<Empleador> getListEmpleados() {
		return listEmpleados;
	}
	public void setListEmpleados(ArrayList<Empleador> listEmpleados) {
		this.listEmpleados = listEmpleados;
	}
	
	
	
}
