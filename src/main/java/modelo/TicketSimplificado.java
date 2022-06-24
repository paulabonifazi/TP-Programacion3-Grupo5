package modelo;

import java.util.ArrayList;

import paquete.Agencia;
import paquete.Empleador;

public class TicketSimplificado 
{
	private String tipoTrabajo; //Salud - Comercio Local - Comercio Internacional
	private String locacion; // HomeOffice, Presencial, Ambas (Ambas = Indistinto??)
	private Empleador empleador;
	
	
	
	public TicketSimplificado(String tipoTrabajo, String locacion, Empleador empleador) {
		super();
		this.tipoTrabajo = tipoTrabajo;
		this.locacion = locacion;
		this.empleador = empleador;
	}



	public Empleador getEmpleador() {
		return empleador;
	}




	public String getTipoTrabajo() {
		return tipoTrabajo;
	}

	
	public synchronized TicketSimplificado sacarTicketBolsa()
	{
		while(Agencia.getInstance().getBolsaDeEmpleo() == null) {
			try {
				wait();
			} catch (InterruptedException e)
			{					
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
		}
			
		TicketSimplificado ticketAnalizar = Agencia.getInstance().getBolsaDeEmpleo().get(0);
		Agencia.getInstance().emilinarTicketSimplificado(ticketAnalizar);
		//me quedo con el primer ticket de la Bolsa de Empleo	
		
		notifyAll();
		
		return ticketAnalizar;
	}
	
	public synchronized void agregarTicketBolsa(TicketSimplificado ticket) {
		
		//agrego ticket simplificado a la bolsa de empleo
		
		Agencia.getInstance().agregarTicketSimplificado(ticket);
		
		notifyAll();
		
	}
	
	
}
