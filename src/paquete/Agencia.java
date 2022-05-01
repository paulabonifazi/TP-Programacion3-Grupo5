package paquete;

import java.util.ArrayList;

public class Agencia
{
	private static Agencia instancia = null;
	private String nombre;
	
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador> ();						///necesito los array para completar el resot
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso> ();
	
	/*agregar otros tributos, ver cuales!*/
	
	private ArrayList<Persona> personas = new ArrayList<Persona>();
	
	private Agencia() {
		
	}
	
	public static Agencia getInstance()
	{
		if (Agencia.instancia == null)
			Agencia.instancia = new Agencia();
		
		return instancia;
	}
	
}
