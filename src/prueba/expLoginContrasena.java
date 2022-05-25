package prueba;

import java.util.Date;

import excepciones.ContrasenaIncorrectaException;
import excepciones.NombreDeUsuarioIncorrectoException;
import modelo.EstadoTicket;
import modelo.FormularioBusqueda;
import modelo.Ticket;
import modelo.TicketEmpleadoPretenso;
import modelo.TicketEmpleador;
import paquete.Agencia;
import paquete.Domicilio;
import paquete.EmpleadoPretenso;
import paquete.Empleador;
import paquete.ValoracionAspecto;

public class expLoginContrasena {

	public static void main(String[] args) 
	{
		
		TicketEmpleador ticketEmpleador1 = new TicketEmpleador(new FormularioBusqueda("HomeOffice", "80000", "Completa", "Junior", "Menos de 40", "Nada", "Secundario"), new EstadoTicket("Activo"), new Date(2022, 8, 23), 2, 0);
		TicketEmpleador ticketEmpleador2 = new TicketEmpleador(new FormularioBusqueda("Indistinto", "125000", "Extendida", "Managment", "40 a 50", "Mucha", "Terciario"), new EstadoTicket("Activo"), new Date(2022, 10, 5), 1, 0);
		TicketEmpleador ticketEmpleador3 = new TicketEmpleador(new FormularioBusqueda("Presencial", "90000", "Media", "Senior", "Mas de 50", "Media", "Secundario"), new EstadoTicket("Activo"), new Date(2022, 7, 12), 3, 0);
		
		Empleador empleador1 = new Empleador(new Domicilio("Juramento", 256, "Casa"), "22356971", "joseyasociados@gmail.com", "JoseyAsociados", "123456789", "Jose y Asociados S.A.", "Comercio Local",  ticketEmpleador1, new ValoracionAspecto(10, 10, 10, 10, 10, 10, 10)); //juridica
		Empleador empleador2 = new Empleador(new Domicilio("Alvear", 2978, "9 H"), "7895630", "juana@gmail.com", "JuanaGonzalez", "987456", "Juana Gonzalez", "Salud", ticketEmpleador2, new ValoracionAspecto(10, 10, 10, 10, 10, 10, 10)); //fisica
		Empleador empleador3 = new Empleador(new Domicilio("Luro", 560, "1 A"), "65892150", "raul@gmail.com", "RaulMartinez", "5555555", "Raul Martinez", "Comercio Esterior", ticketEmpleador3, new ValoracionAspecto(5, 5, 5, 5, 5, 5, 5)); //fisica
		
		
		
		
		TicketEmpleadoPretenso ticketEmpleadoPretenso1 = new TicketEmpleadoPretenso(new FormularioBusqueda("Presencial", "70000", "Completa", "Senior", "Menos de 40", "Mucha", "Secundario"), new EstadoTicket("Activo"), new Date(2022, 5, 2));
		TicketEmpleadoPretenso ticketEmpleadoPretenso2 = new TicketEmpleadoPretenso(new FormularioBusqueda("HomeOffice", "170000", "Media", "Managment", "40 a 50", "Media", "Terciario"), new EstadoTicket("Activo"), new Date(2022, 8, 9));
		TicketEmpleadoPretenso ticketEmpleadoPretenso3 = new TicketEmpleadoPretenso(new FormularioBusqueda("Indistinto", "85000", "Extendida", "Junior", "Mas de 50", "Nada", "Primario"), new EstadoTicket("Activo"), new Date(2022, 11, 7));
		TicketEmpleadoPretenso ticketEmpleadoPretenso4 = new TicketEmpleadoPretenso(new FormularioBusqueda("Presencial", "12000", "Extendida", "Managment", "Menos de 40", "Mucha", "Terciario"), new EstadoTicket("Activo"), new Date(2022, 10, 5));
		TicketEmpleadoPretenso ticketEmpleadoPretenso5 = new TicketEmpleadoPretenso(new FormularioBusqueda("HomeOffice", "70000", "Completa", "Senior", "40 a 50", "Media", "Primario"), new EstadoTicket("Activo"), new Date(2022, 6, 20));
		
		
		EmpleadoPretenso empleadoPretenso1 = new EmpleadoPretenso(new Domicilio("Saavedra", 5842, "Casa"), "552564", "paola@hyty.com", "PaolaArgento", "hola1256", "Paola", "Argento", 34, ticketEmpleadoPretenso1);
		EmpleadoPretenso empleadoPretenso2 = new EmpleadoPretenso(new Domicilio("Mateu", 4563, "7 A"), "999999", "celeste@gmail.com", "CelesteRodriguez", "contrasenia", "Celeste", "Rodriguez", 48, ticketEmpleadoPretenso2);
		EmpleadoPretenso empleadoPretenso3 = new EmpleadoPretenso(new Domicilio("San Luis", 23, "5 F"), "56215", "tatiana@outlook.com", "TatianaAguirre", "asdfasdf", "Tatiana", "Aguirre", 56, ticketEmpleadoPretenso1);
		EmpleadoPretenso empleadoPretenso5 = new EmpleadoPretenso(new Domicilio("Santiago del Estero", 666, "3 I"), "08004556666", "lautaro@gmail.com", "LautaroLazuli", "holahola", "Lautaro", "Lazuli", 42, ticketEmpleadoPretenso1);
		EmpleadoPretenso empleadoPretenso4 = new EmpleadoPretenso(new Domicilio("Calle Falsa", 123, "Casa"), "1565156", "camila@adf.com", "CamilaLopez", "nosequeponer", "Camila", "Lopez", 28, ticketEmpleadoPretenso1);
		
		
		
		Agencia agencia = new Agencia();
		
		agencia.agregarEmpleador(empleador1);
		agencia.agregarEmpleador(empleador2);
		agencia.agregarEmpleador(empleador3);
		
		
		agencia.agregarEmpleadoPretenso(empleadoPretenso1);
		agencia.agregarEmpleadoPretenso(empleadoPretenso2);
		agencia.agregarEmpleadoPretenso(empleadoPretenso3);
		agencia.agregarEmpleadoPretenso(empleadoPretenso4);
		agencia.agregarEmpleadoPretenso(empleadoPretenso5);
		
		//------------------------------
		for (int i=0; i<agencia.getEmpleadosPretensos().size(); i++)
			System.out.println(agencia.getEmpleadosPretensos().get(i).getNombre());
		
		for (int i=0; i<agencia.getEmpleadores().size(); i++)
			System.out.println(agencia.getEmpleadores().get(i).getNomRazonS());
			
		agencia.generarUsusariosActivos();
		
	
		System.out.println(agencia.getEmpleadoresActivos());
		System.out.println(agencia.getEmpleadosPretensosActivos());
		
		
		/*agencia.activarRondaEncuentrosLaborales();//ACÁ CRASHEA


		System.out.println(agencia.getListAsignacionEmpleador());
		System.out.println(agencia.getListAsignacionEmpleadoPretensos());
		
		System.out.println(agencia.getListEleccionEmpleador());
		System.out.println(agencia.getListEleccionEmpleadoPretensos());
		
		System.out.println(agencia.getListaCoincidencias());*/
		//-----------------------------
		try {
			agencia.login("Paola", "hola1256");
			System.out.println("Logueo exitoso");
		} catch (NombreDeUsuarioIncorrectoException e) {
			System.out.println(e.getMessage());
		} catch (ContrasenaIncorrectaException e) {
			System.out.println(e.getMessage());
		}
		//agencia.getSaldoAgencia();
	}
	
}