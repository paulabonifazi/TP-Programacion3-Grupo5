package paquete;

import java.util.ArrayList;

public class Agencia
{
	private static Agencia instancia = null;
	private String nombre;
	
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso> ();
	
	/*/* ir guardando los registros en las array de arriba
	
	
	
	
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
