package paquete;

import Interfaces.IPersonaFisica;

public class Empleado extends Persona implements IPersonaFisica
{
	private String nombre;
	private String apellido;
	private int edad;
	
	
	public Empleado(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nombre, String apellido, int edad) 
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	/*
	 * ver como hacer un factory
	 * 
	 */
	
	
}
