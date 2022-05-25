package paquete;

import java.util.ArrayList;

import excepciones.NoCoincidenciaException;
import excepciones.TicketCanceladoException;
import interfaces.IPersonaFisica;
import interfaces.IPersonaJuridica;
import interfaces.MuestraListaEmpleadosPretensos;
import modelo.ControlEstadosTicket;
import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import modelo.TicketEmpleador;

public class Empleador extends Persona implements IPersonaFisica, IPersonaJuridica, MuestraListaEmpleadosPretensos
{
	private boolean personaJuridica;
	private String nomRazonS;
	private String nombre;
	private String apellido;
	private int edad;
	private String rubro; //salud - comercio local - comercio internacional
	private TicketEmpleador ticket;
	private ValoracionAspecto listaPesos;                
	
	public Empleador(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nomRazonS, String rubro, TicketEmpleador ticket, ValoracionAspecto listaPesos)
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		this.personaJuridica = true;
		this.nomRazonS = nomRazonS;
		this.nombre = null;
		this.apellido = null;
		this.edad = 0;
		this.rubro = rubro;
		this.ticket = ticket;
		this.listaPesos = listaPesos;
	}

	public Empleador(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nombre, String apellido, int edad, String rubro, TicketEmpleador ticket, ValoracionAspecto listaPesos)
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		this.personaJuridica = false;
		this.nomRazonS = null;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.rubro = rubro;
		this.ticket = ticket;
		this.listaPesos = listaPesos;
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

	@Override
	public String getNomRazonS()
	{
		// TODO Auto-generated method stub
		return nomRazonS;
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
		int edad;
		if (personaJuridica)
			edad = 0;
		else
			edad = this.edad;
		return edad;
	}

	public boolean isPersonaJuridica()
	{
		return personaJuridica;
	}

	public String getRubro()
	{
		return rubro;
	}

	@Override
	public void mostrarListaEmpleadosPretensos(ArrayList<EmpleadoPretenso> empleadoPretenso)
	{
		for (int i = 0; i<empleadoPretenso.size(); i++) 
			System.out.println(empleadoPretenso.get(i).getNombUsuario());
	}
	
	@Override
	public void mostrarListaAsignacionDelEmpleador(ListAsignacionEmpleador lista)
	{
		for (int i=0; i<lista.getListEmpleadosPretensos().size(); i++)
			System.out.println(lista.getListEmpleadosPretensos().get(i).getNombUsuario());
	}

	@Override
	public void mostrarResultado(ArrayList<ListAsignacionEmpleadPretenso> lista) throws NoCoincidenciaException
	{
		boolean coincidencia = false;
		int contEmpleado = 0;
		ListAsignacionEmpleadPretenso empleadoActual = null;
		while (coincidencia==false && contEmpleado < lista.size()) {
			int contEmpleador = 0;
			//comienzo la busqueda en el nodo
			empleadoActual = lista.get(contEmpleado);
			while (coincidencia==false && contEmpleador <= empleadoActual.getListEmpleadores().size()) {
				if (empleadoActual.getListEmpleadores().get(contEmpleador).getNombUsuario().equals(this.getNombUsuario()))///ver si no hay otra forma de buscar
					coincidencia = true;
				else
					contEmpleador++;
			}
			contEmpleado++;
		}
		if (coincidencia == false)//si coincidencia es false -> nadie lo contrato -> lanza exception u cartel
			throw new NoCoincidenciaException(this.getNombUsuario());
		else
			System.out.println("Hay coincidencia entre " + this.getNombUsuario() + " y " + empleadoActual.getEmpleadoPretenso().getNombUsuario());		
	}

	public void activarTicket() {
		ControlEstadosTicket cla=new ControlEstadosTicket();
		try
		{
			cla.activarTicket(ticket);
		} catch (TicketCanceladoException e)
		{
			e.getMessage();
		}
	}
	
	public void suspenderTicket() {
		ControlEstadosTicket cla=new ControlEstadosTicket();
		try
		{
			cla.suspenderTicket(ticket);
		} catch (TicketCanceladoException e)
		{
			e.getMessage();
		}
	}
}