package paquete;

import Interfaces.IPersonaFisica;
import modelo.Ticket;
import modelo.TicketEmpleadoPretenso;

public class EmpleadoPretenso extends Persona implements IPersonaFisica
{	
	private String nombre;
	private String apellido;
	private int edad;
	private TicketEmpleadoPretenso ticket;
	
	
	public EmpleadoPretenso(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nombre, String apellido, int edad, TicketEmpleadoPretenso ticket) {
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.ticket = ticket;
	}


	public TicketEmpleadoPretenso getTicket() {
		return ticket;
	}


	public void setTicket(TicketEmpleadoPretenso ticket) {
		this.ticket = ticket;
	}

	
	
	
	
	
}
