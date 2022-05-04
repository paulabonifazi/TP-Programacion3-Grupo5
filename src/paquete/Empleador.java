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
	///definir como se carga listaPesos
	private ValoracionAspecto listaPesos;                 ///como consoco la cantidad de aspectos -> no seria necesario un array, suficiente con un objeto que guarde los 7 PesosAspectos
	
	public Empleador(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nomRazonS, String rubro, TicketEmpleador ticket) 
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		this.nomRazonS = nomRazonS;
		this.rubro = rubro;
		this.ticket = ticket;
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

	
	
	
	
	//quien se encarga de hacer el registro?? (punto 1 funcionalidad emplead)
	//excepcionesdelLogin, hace falta la clase login???
	////metodo que muestre las listas (agencia tambien necesita este metodo -> ver donde ponerlo para no escribirlo 2 veces)
			///metodo que me muestre la lista de empleadosPretensos (accediendo a la lista de agencia)
				///metodo que me permita seleccionar los posibles empleados pretensos (accediendo a la lista de agencia)
				///metodo que me muestre las opciones elegidas
			
	

}
