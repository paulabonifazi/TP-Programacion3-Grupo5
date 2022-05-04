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
	
	
	//quien se encarga de hacer el registro?? (punto 1 funcionalidad emplead)
	//excepcionesdelLogin, hace falta la clase login???
	////metodo que muestre las listas (agencia tambien necesita este metodo -> ver donde ponerlo para no escribirlo 2 veces)
			///metodo que me muestre la lista de empresas (accediendo a la lista de agencia)
			///metodo que me permita seleccionar los posibles empresas (accediendo a la lista de agencia)
			///metodo que me muestre la opcione elegidas

	
}
