package prueba;

import java.util.Date;

import modelo.EstadoTicket;
import modelo.FormularioBusqueda;
import modelo.Ticket;
import modelo.TicketEmpleadoPretenso;
import modelo.TicketEmpleador;
import paquete.Domicilio;
import paquete.EmpleadoPretenso;
import paquete.Empleador;
import paquete.ValoracionAspecto;

public class cargaDatos {

	public static void main(String[] args) 
	{
		
		TicketEmpleador ticketEmpleador1 = new TicketEmpleador(new FormularioBusqueda("HomeOffice", "80000", "Completa", "Junior", "Menos de 40", "Nada", "Secundario"), new EstadoTicket("Activo"), new Date(2022, 8, 23), 2, 0);
		TicketEmpleador ticketEmpleador2 = new TicketEmpleador(new FormularioBusqueda("Indistinto", "125000", "Extendida", "Managment", "40 a 50", "Mucha", "Terciario"), new EstadoTicket("Activo"), new Date(2022, 10, 5), 1, 0);
		TicketEmpleador ticketEmpleador3 = new TicketEmpleador(new FormularioBusqueda("Presencial", "90000", "Media", "Senior", "mas de 50", "Media", "Secundario"), new EstadoTicket("Activo"), new Date(2022, 7, 12), 3, 0);
		
		Empleador empleador1 = new Empleador(new Domicilio("Juramento", 256, "Casa"), "22356971", "joseyasociados@gmail.com", "JoseyAsociados", "123456789", "Jose y Asociados S.A.", "Comercio Local",  ticketEmpleador1, new ValoracionAspecto(10, 10, 10, 10, 10, 10, 10, 10)); //juridica
		Empleador empleador2 = new Empleador(new Domicilio("Alvear", 2978), "9 H", "7895630", "juana@gmail.com", "JuanaGonzalez", "987456", "Juana Gonzalez", "Salud", ticketEmpleador2, new ValoracionAspecto(10, 10, 10, 10, 10, 10, 10, 10)); //fisica
		Empleador empleador3 = new Empleador(new Domicilio("Luro", 560), "1 A", "65892150", "raul@gmail.com", "RaulMartinez", "5555555", "Raul Martinez", ticketEmpleador3, new ValoracionAspecto(5, 5, 5, 5, 5, 5, 5)); //fisica
		
		
		TicketEmpleadoPretenso ticketEmpleadoPretenso1 = new TicketEmpleadoPretenso(new FormularioBusqueda("Presencial", "70000", "Completa", "Senior", "menos de 40", "Mucha", "Secundario"), new EstadoTicket("Activo"), new Date(2022, 5, 2), 0);
		TicketEmpleadoPretenso ticketEmpleadoPretenso2 = new TicketEmpleadoPretenso(new FormularioBusqueda("HomeOffice", "170000", "Media", "Managment", "40 a 50", "Mucha", "Secundario"), new EstadoTicket("Activo"), new Date(2022, 5, 2), 0);
		TicketEmpleadoPretenso ticketEmpleadoPretenso3 = new TicketEmpleadoPretenso(new FormularioBusqueda("Presencial", "70000", "completa", "Senior", "menos de 40", "Mucha", "Secundario"), new EstadoTicket("Activo"), new Date(2022, 5, 2), 0);
		TicketEmpleadoPretenso ticketEmpleadoPretenso4 = new TicketEmpleadoPretenso(new FormularioBusqueda("Presencial", "70000", "completa", "Senior", "menos de 40", "Mucha", "Secundario"), new EstadoTicket("Activo"), new Date(2022, 5, 2), 0);
		TicketEmpleadoPretenso ticketEmpleadoPretenso5 = new TicketEmpleadoPretenso(new FormularioBusqueda("Presencial", "70000", "completa", "Senior", "menos de 40", "Mucha", "Secundario"), new EstadoTicket("Activo"), new Date(2022, 5, 2), 0);
		
		
		
		EmpleadoPretenso empleadoPretenso1 = new EmpleadoPretenso();
		EmpleadoPretenso empleadoPretenso2 = new EmpleadoPretenso();
		EmpleadoPretenso empleadoPretenso3 = new EmpleadoPretenso();
		EmpleadoPretenso empleadoPretenso4 = new EmpleadoPretenso();
		EmpleadoPretenso empleadoPretenso5 = new EmpleadoPretenso();
		

	}

}
