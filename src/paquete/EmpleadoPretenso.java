package paquete;

import interfaces.IPersonaFisica;
import modelo.Ticket;
import modelo.TicketEmpleadoPretenso;

public class EmpleadoPretenso extends Persona implements IPersonaFisica
{	
	private String nombre;
	private String apellido;
	private int edad;
	private TicketEmpleadoPretenso ticket;
	
	public EmpleadoPretenso(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nombre, String apellido, int edad, TicketEmpleadoPretenso ticket) 
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		this.ticket = ticket;
	}

	

	public TicketEmpleadoPretenso getTicket() {
		return ticket;
	}

	public void setTicket(TicketEmpleadoPretenso ticket) {
		this.ticket = ticket;
	}

	@Override
	public String getNombre()
	{
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public String getApellido()
	{
		// TODO Auto-generated method stub
		return apellido;
	}

	@Override
	public int getEdad()
	{
		// TODO Auto-generated method stub
		return edad;
	}
	
	///quien se encarga de hacer el registro?? (punto 1 funcionalidad emplead)
	//excepcionesdelLogin, hace falta la clase login???
	////metodo que muestre las listas (agencia tambien necesita este metodo -> ver donde ponerlo para no escribirlo 2 veces)	aunque agencia mostraria todos los nodos y esto el suyo unicamente
				//metodo que me muestre la lista de empresas (accediendo a la lista de agencia)
				///metodo que me permita seleccionar los posibles empresas (accediendo a la lista de agencia)
				///metodo que me muestre la opcione elegidas
	
	
	
}

