package modelo;

import paquete.EmpleadoPretenso;

///este objeto lo usa el metodo metodoOrdenamientoEmpleador de la clase RondaEncuentroLaborales
//

/*
 * Analizar como este objeto se relaciona con ronda de encuentros
 * para ver constructor, herencia, etc
 */

public class EmpleadPretensoPuntaje {
	
	private double puntaje;
	private EmpleadoPretenso empleadoPretenso;
	
	
	public double getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}
	
	public EmpleadoPretenso getEmpleadoPretenso() {
		return empleadoPretenso;
	}
	
	public void setEmpleadoPretenso(EmpleadoPretenso empleadoPretenso) {
		this.empleadoPretenso = empleadoPretenso;
	}
}
