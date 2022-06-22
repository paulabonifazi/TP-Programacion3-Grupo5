package concurrencia;

import paquete.Empleador;

public class TicketSimplificado extends Thread
{
	private String tipoTrabajo; //salud - comercio local - comercio internacional
	private String locacion; // HomeOffice, Presencial, Ambas (AMbas = Indistinto??)
	private Empleador empleador;
	
	
	
	public TicketSimplificado(String tipoTrabajo, String locacion, Empleador empleador) {
		super();
		this.tipoTrabajo = tipoTrabajo;
		this.locacion = locacion;
		this.empleador = empleador;
	}


	//únicamente publica el tipo de trabajo
	public String getTipoTrabajo() {
		return tipoTrabajo;
	}


	@Override
	public void run() {
		
	}
}
