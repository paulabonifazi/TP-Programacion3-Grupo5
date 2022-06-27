package paquete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import decorator.IPersona;
import interfaces.IMuestraListasEmpleadosPretensos;
import modelo.ControlEstadosTicket;
import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import modelo.TicketEmpleadoPretenso;
import modelo.TicketSimplificado;

public class EmpleadoPretenso extends Persona implements IPersona, IMuestraListasEmpleadosPretensos, Serializable
{	
	private String nombre;
	private String apellido;
	private int edad;
	private TicketEmpleadoPretenso ticket;
	private TicketSimplificado ticketSimplificado;
	private int cantBusquedas = 0;
	
	
	public EmpleadoPretenso() {
		super();
	}

	public EmpleadoPretenso(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nombre, String apellido, int edad, TicketEmpleadoPretenso ticket) 
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		Agencia.getInstance().agregarEmpleadoPretenso(this);
		this.apellido=apellido;
		this.nombre=nombre;
		this.edad=edad;
		this.ticket = ticket;
		this.ticketSimplificado = null; //se asignar� de la Bolsa de Trabajo, producto de la simulaci�n
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public TicketEmpleadoPretenso getTicket() {
		return ticket;
	}

	public void setTicket(TicketEmpleadoPretenso ticket) {
		this.ticket = ticket;
	}


	public int getCantBusquedas() {
		return cantBusquedas;
	}

	public void setCantBusquedas(int cantBusquedas) {
		this.cantBusquedas += cantBusquedas;	//cuento nueva b�squeda realizada
	}
	

	public TicketSimplificado getTicketSimplificado() {
		return ticketSimplificado;
	}

	public void setTicketSimplificado(TicketSimplificado ticketSimplificado) {
		this.ticketSimplificado = ticketSimplificado;
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
		if (coincidencia == false)
			System.out.println("Nadie contrat� a " + this.getNombUsuario());
		else
			System.out.println("Hay coincidencia entre " + this.getNombUsuario() + " y " + empleadorActual.getEmpleador().getNombUsuario());
	}


    @Override
    public String getNomRazonS() {
        // TODO Implement this method
        return null;
    }

    @Override
    public double porcentComicion() {
        return 0.0;
    }
    
    @Override
	public void run() {
		/*
		 Cada Empleado Pretenso buscar� hasta 10 en la Bolsa de Empleo o hasta encontrar un 
		 Ticket Simplificado 
		 */
		
		Random r = new Random();
		
		while( (this.getCantBusquedas() < 10) || (this.getTicketSimplificado() == null))
		{
			this.ticketSimplificado = this.ticketSimplificado.sacarTicketBolsa();
			
			if (this.getTicket().getFbTicket().getTipoPuesto().equals(this.getTicketSimplificado().getTipoTrabajo()) && (r.nextInt() <= 5) ) { //acepta la petici�n de empleo
				//modifico listas de elecci�n
				int i = 0;
				
				//agrego empleado pretenso a la lista de asignacion del empleador
				while ( (i < Agencia.getInstance().getListAsignacionEmpleador().size()) && !(Agencia.getInstance().getListAsignacionEmpleador().get(i).getEmpleador().equals(this.getTicketSimplificado().getEmpleador())) )
				{
					i++;
				}
				Agencia.getInstance().getListAsignacionEmpleador().get(i).getListEmpleadosPretensos().add(this);
				
				//El ticket pasa a ser suspendido porque hubo contratacion
				ControlEstadosTicket.suspenderTicket(this.ticket);
				this.ticketSimplificado.getEmpleador().getTicket().setCantEmpleadosObtenidos(1);
				
				//agrego empleador a la lista de asignacion del empleado pretenso
				ListAsignacionEmpleadPretenso nodoEP = new ListAsignacionEmpleadPretenso();
				nodoEP.setEmpleadoPretenso(this);
				nodoEP.getListEmpleadores().add(this.ticketSimplificado.getEmpleador());
				Agencia.getInstance().getListEleccionEmpleadoPretensos().add(nodoEP);
				
				//agrego empleador y empleado a la lista de elecciones
				ListAsignacionEmpleador nodoE = new ListAsignacionEmpleador();
				nodoE.setEmpleador(this.ticketSimplificado.getEmpleador());
				nodoE.getListEmpleadosPretensos().add(this);
				Agencia.getInstance().getListaCoincidencias().add(nodoE);
			}
			else {
				//no hay contratacion
				this.ticketSimplificado.agregarTicketBolsa(this.ticketSimplificado);
				this.ticketSimplificado = null;
			}
			this.cantBusquedas++;
			
			this.ticket.hasChanged();
			this.ticket.notifyObservers();
		}
	}
}
