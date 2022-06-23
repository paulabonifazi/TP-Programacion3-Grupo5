package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class ListAsignacionEmpleador implements Serializable{

	private Empleador empleador;
	private ArrayList <EmpleadoPretenso> listEmpleadosPretensos = new ArrayList <EmpleadoPretenso>();
	
	public ListAsignacionEmpleador() {
		super();
	}

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