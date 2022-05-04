package paquete;

import Interfaces.IPersonaFisica;
import Interfaces.IPersonaJuridica;
import modelo.TicketEmpleador;


public class Empleador extends Persona implements IPersonaFisica, IPersonaJuridica
{
	//ver como hacer para que tenga nombre o razon social!
	private String nomRazonS;
	private String rubro; //salud - comercio local - comercio internacional
	private TicketEmpleador ticket;
	
	
	public Empleador(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nomRazonS, String rubro, TicketEmpleador ticket) 
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		this.nomRazonS = nomRazonS;
		this.rubro = rubro;
		this.ticket = ticket;
	}
	
	
	

	
	
	

}
