package paquete;

import java.util.ArrayList;
import java.util.Random;

import interfaces.IPersonaFisica;
import interfaces.IMuestraListasEmpleadosPretensos;
import modelo.ControlEstadosTicket;
import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import modelo.TicketEmpleadoPretenso;
import modelo.TicketSimplificado;

public class EmpleadoPretenso extends Persona implements IPersonaFisica, IMuestraListasEmpleadosPretensos
{	
	private String nombre;
	private String apellido;
	private int edad;
	private TicketEmpleadoPretenso ticket;
	private TicketSimplificado ticketSimplificado;
	private int cantBusquedas = 0;
	
	public EmpleadoPretenso(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nombre, String apellido, int edad, TicketEmpleadoPretenso ticket) 
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		Agencia.getInstance().agregarEmpleadoPretenso(this);
		this.apellido=apellido;
		this.nombre=nombre;
		this.edad=edad;
		this.ticket = ticket;
		this.ticketSimplificado = null; //se asignará de la Bolsa de Trabajo, producto de la simulación
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

	/*
	public void setCantBusquedas(int cantBusquedas) {
		this.cantBusquedas += cantBusquedas;	//cuento nueva búsqueda realizada
	}
	*/

	public TicketSimplificado getTicketSimplificado() {
		return ticketSimplificado;
	}

	/*
	public void setTicketSimplificado(TicketSimplificado ticketSimplificado) {
		this.ticketSimplificado = ticketSimplificado;
	}
	*/

	
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
			System.out.println("Nadie contrató a " + this.getNombUsuario());
		else
			System.out.println("Hay coincidencia entre " + this.getNombUsuario() + " y " + empleadorActual.getEmpleador().getNombUsuario());
	}

	@Override
	public void run() {
		/*
		 Cada Empleado Pretenso buscará hasta 10 en la Bolsa de Empleo o hasta encontrar un 
		 Ticket Simplificado 
		 */
		
		Random r = new Random();
		
		while( (this.getCantBusquedas() < 10) || (this.getTicketSimplificado() == null))
		{
			this.ticketSimplificado = this.ticketSimplificado.sacarTicketBolsa();
			
			if (this.getTicket().getFbTicket().getTipoPuesto().equals(this.getTicketSimplificado().getTipoTrabajo()) && (r.nextInt(10) <= 5) ) { //acepta la petición de empleo
				//modifico listas de elección
				int i = 0;
				
				//agrego empleado pretenso a la lista de asignación del empleador
				while ( (i < Agencia.getInstance().getListAsignacionEmpleador().size()) && !(Agencia.getInstance().getListAsignacionEmpleador().get(i).getEmpleador().equals(this.getTicketSimplificado().getEmpleador())) )
				{
					i++;
				}
				Agencia.getInstance().getListAsignacionEmpleador().get(i).getListEmpleadosPretensos().add(this);
				
				//El ticket pasa a ser suspendido porque hubo contratación
				ControlEstadosTicket.suspenderTicket(this.ticket);
				this.ticketSimplificado.getEmpleador().getTicket().setCantEmpleadosObtenidos(1);
				
				//agrego empleador a la lista de asignación del empleado pretenso
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
				//no hay contratación
				this.ticketSimplificado.agregarTicketBolsa(this.ticketSimplificado);
				this.ticketSimplificado = null;
			}
			this.cantBusquedas++;
			
			this.ticket.getEstadoTicket().hasChanged();
			this.ticket.getEstadoTicket().notifyObservers();
		}
	}
	
	
	
}