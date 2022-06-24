package paquete;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import interfaces.IPersonaFisica;
import interfaces.IPersonaJuridica;
import interfaces.IMuestraListasEmpleadores;
import modelo.ControlEstadosTicket;
import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import modelo.TicketEmpleador;
import modelo.TicketSimplificado;
import util.Util;

public class Empleador extends Persona implements IPersonaFisica, IPersonaJuridica, IMuestraListasEmpleadores, Observer
{
	private boolean personaJuridica;
	private String nomRazonS;
	private String nombre;
	private String apellido;
	private int edad;
	private String rubro; //salud - comercio local - comercio internacional
	private TicketEmpleador ticket;
	private ValoracionAspecto listaPesos;     
	
	protected ArrayList<EmpleadoPretenso> observados = new ArrayList<EmpleadoPretenso>();
	
	
	public Empleador(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nomRazonS, String rubro, TicketEmpleador ticket, ValoracionAspecto listaPesos)
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		Agencia.getInstance().agregarEmpleador(this);
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
	public void mostrarResultado(ArrayList<ListAsignacionEmpleadPretenso> lista)
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
		if (coincidencia == false)
			System.out.println("Nadie tuvo en cuenta a " + this.getNombUsuario());
		else
			System.out.println("Hay coincidencia entre " + this.getNombUsuario() + " y " + empleadoActual.getEmpleadoPretenso().getNombUsuario());		
	}

	
	@Override
	public void run() {						
		//el Empleador generará 3 puestos de trabajo (Ticket Simplificado)
		
		TicketSimplificado ts1 = new TicketSimplificado("Salud","Presencial", this);
		Agencia.getInstance().agregarTicketSimplificado(ts1);
		Util.espera();
		
		TicketSimplificado ts2 = new TicketSimplificado("Comercio Internacional","Indistinto", this);
		Agencia.getInstance().agregarTicketSimplificado(ts2);
		Util.espera();
		
		TicketSimplificado ts3 = new TicketSimplificado("Comercio Local","HomeOffice", this);
		Agencia.getInstance().agregarTicketSimplificado(ts3);
		Util.espera();
	}
	
	public void agregarObservable(EmpleadoPretenso empleadoPretenso) {
		
		empleadoPretenso.addObserver(this);
		this.observados.add(empleadoPretenso);
	}

	public void eliminarObservable(EmpleadoPretenso empleadoPretenso) {
		
		empleadoPretenso.deleteObserver(this);
		this.observados.remove(empleadoPretenso);
	}
	
	@Override
	public void update(Observable empleadoPretenso, Object est) {
		
		EstadoTicket estado = (EstadoTicket) est;
		
		if (this.observados.contains(empleadoPretenso)) 
		{
			System.out.println(empleadoPretenso.);
		}
		else {
			throw new IllegalArgumentException();
			//lanza uina excepción si el empleado pretenso a observar no se encuentra entre los observables
		
		}
		
		
		
		
	}
	
	
}