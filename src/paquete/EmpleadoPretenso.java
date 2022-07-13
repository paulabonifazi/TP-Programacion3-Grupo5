package paquete;

import java.io.Serializable;


import interfaces.IPersona;
import modelo.TicketEmpleadoPretenso;
import modelo.TicketSimplificado;

public class EmpleadoPretenso extends Persona implements IPersona, Serializable, Runnable
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
		this.ticketSimplificado = null; //se asignarï¿½ de la Bolsa de Trabajo, producto de la simulaciï¿½n
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

	@Override
	public void run() 
	{
		//espera a que el array no esté vacío
		// TODO Auto-generated method stub
		
	}
    
    
}
