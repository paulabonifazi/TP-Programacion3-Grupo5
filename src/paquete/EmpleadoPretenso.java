package paquete;

import java.util.ArrayList;

import excepciones.TicketCanceladoException;
import interfaces.IPersonaFisica;
import interfaces.MuestraListaEmpleadores;
import modelo.ControlEstadosTicket;
import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import modelo.TicketEmpleadoPretenso;

public class EmpleadoPretenso extends Persona implements IPersonaFisica, MuestraListaEmpleadores
{	
	private String nombre;
	private String apellido;
	private int edad;
	private TicketEmpleadoPretenso ticket;
	
	public EmpleadoPretenso(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nombre, String apellido, int edad, TicketEmpleadoPretenso ticket) 
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		this.apellido=apellido;
		this.nombre=nombre;
		this.edad=edad;
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

	@Override
	public void mostrarListaEmpleadores(ArrayList<Empleador> empleador)
	{
		for (int i =0; i<empleador.size(); i++) 
			System.out.println(empleador.get(i).getNombUsuario());		
	}

	@Override
	public void mostrarListaAsignacionDelEmpleadoPretenso(ListAsignacionEmpleadPretenso lista)
	{
		for (int i=0; i<lista.getListEmpleadores().size(); i++)
			System.out.println(lista.getListEmpleadores().get(i).getNombUsuario());
	}

	@Override
	public void mostrarResultado(ArrayList<ListAsignacionEmpleador> lista)
	{
		boolean coincidencia = false;
		int contEmpleador = 0;
		ListAsignacionEmpleador empleadorActual = null;
		while (coincidencia==false && contEmpleador < lista.size()) {
			int contEmpleadoPretenso = 0;
			//comienzo la busqueda en el nodo
			empleadorActual = lista.get(contEmpleador);
			while (coincidencia==false && contEmpleadoPretenso <= empleadorActual.getListEmpleadosPretensos().size()) {
				if (empleadorActual.getListEmpleadosPretensos().get(contEmpleadoPretenso).getNombUsuario().equals(this.getNombUsuario()))///ver si no hay otra forma de buscar
					coincidencia = true;
				else
					contEmpleadoPretenso++;
			}
			contEmpleador++;
		}
		if (coincidencia == false)//si coincidencia es false -> nadie lo contrato -> lanza exception u cartel
			System.out.println("Nadie tuvo en cuenta a " + this.getNombUsuario());
		else
			System.out.println("Hay coincidencia entre " + this.getNombUsuario() + " y " + empleadorActual.getEmpleador().getNombUsuario());
	}
	

	public void activarTicket() {
		ControlEstadosTicket cla = new ControlEstadosTicket();//Se agregó para evitar REFERENCJA A NULL
		try
		{
			cla.activarTicket(ticket);
		} catch (TicketCanceladoException e)
		{
			e.getMessage();
		}
	}
	
	public void suspenderTicket() {
		ControlEstadosTicket cla = new ControlEstadosTicket();
		try
		{
			cla.suspenderTicket(ticket);
		} catch (TicketCanceladoException e)
		{
			e.getMessage();
		}
	}
	
	public void resultadoTicket() {
		ControlEstadosTicket cet = new ControlEstadosTicket();
		cet.resultadoTicketEP(ticket);
		
	}
}
	//