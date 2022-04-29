package paquete;

import Interfaces.IPersonaFisica;
import modelo.TicketEmpleadoPretenso;

public class Empleado extends Persona implements IPersonaFisica
{
	private String nombre;
	private String apellido;
	private int edad;
	private TicketEmpleadoPretenso ticket;
	
	
	
	public Empleado(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nombre, String apellido, int edad, TicketEmpleadoPretenso ticket) 
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.ticket = ticket;
	}
	
	
	


	
	
}
