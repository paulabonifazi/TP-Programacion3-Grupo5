package paquete;

import java.util.ArrayList;

import interfaces.IPersonaFisica;
import interfaces.MuestraListaEmpleadores;
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
			System.out.println("Nadie contrató a " + this.getNombUsuario());
		else
			System.out.println("Hay coincidencia entre " + this.getNombUsuario() + " y " + empleadorActual.getEmpleador().getNombUsuario());
	}
}
	///quien se encarga de hacer el registro?? (punto 1 funcionalidad emplead)
	//excepcionesdelLogin, hace falta la clase login???
	////metodo que muestre las listas (agencia tambien necesita este metodo -> ver donde ponerlo para no escribirlo 2 veces)	aunque agencia mostraria todos los nodos y esto el suyo unicamente
				//metodo que me muestre la lista de empresas (accediendo a la lista de agencia)
				///metodo que me permita seleccionar los posibles empresas (accediendo a la lista de agencia)
				///metodo que me muestre la opcione elegidas	

