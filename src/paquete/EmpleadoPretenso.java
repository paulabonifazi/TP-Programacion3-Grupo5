package paquete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import interfaces.IMuestraListasEmpleadosPretensos;
import interfaces.IPersona;
import modelo.ControlEstadosTicket;
import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import modelo.TicketEmpleadoPretenso;
import modelo.TicketSimplificado;

public class EmpleadoPretenso extends Persona implements IPersona, Serializable
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
		this.ticketSimplificado = null; //se asignar� de la Bolsa de Trabajo, producto de la simulaci�n
	}	

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
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
		this.cantBusquedas += cantBusquedas;	//cuento nueva busqueda realizada
	}
	

	public TicketSimplificado getTicketSimplificado() {
		return ticketSimplificado;
	}

	public void setTicketSimplificado(TicketSimplificado ticketSimplificado) {
		this.ticketSimplificado = ticketSimplificado;
	}
	
	
	@Override
	public String getNomRazonS() {
		return null;
	}

    
    @Override
    public double porcentComicion() {
        return 0.0;
    }
    
    /*
    @Override
	public void run() {
	
		 //Cada Empleado Pretenso buscar� hasta 10 en la Bolsa de Empleo o hasta encontrar un 
		 //Ticket Simplificado 
		
		
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
     */
}
