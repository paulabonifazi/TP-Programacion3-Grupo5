package paquete;

import java.util.ArrayList;

import Interfaces.IPersonaFisica;
import Interfaces.IPersonaJuridica;
import modelo.TicketEmpleador;


public class Empleador extends Persona implements IPersonaFisica, IPersonaJuridica
{
	//ver como hacer para que tenga nombre o razon social!
		//ver como hacer para que tenga nombre o razon social!
	private String nomRazonS;
	private String rubro; //salud - comercio local - comercio internacional
	private TicketEmpleador ticket;
	
	
	public Empleador(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nomRazonS, String rubro, TicketEmpleador ticket) 
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
	///definir como se carga listaPesos
	private ValoracionAspecto listaPesos;                 ///como consoco la cantidad de aspectos -> no seria necesario un array, suficiente con un objeto que guarde los 7 PesosAspectos
	
	
	public Empleador(String nombre, String apellido, String telefono, String fechaNac, Domicilio domicilio,String nomRazonS, String rubro, TicketEmpleador ticket) {
		super(nombre, apellido, telefono, fechaNac, domicilio);
		this.nomRazonS = nomRazonS;
		this.rubro = rubro;
		this.ticket = ticket;
	}
	
	
	

	
	
	

}


	
	/*/* en la parte donde la empresa se registra crea y manda el valor*/
	public void setListaPesos(ValoracionAspecto listaPesos) {
		this.listaPesos = listaPesos;
	}


	public ValoracionAspecto getListaPesos() {
		return listaPesos;
	}

	public TicketEmpleador getTicket() {
		return ticket;
	}
	


}
