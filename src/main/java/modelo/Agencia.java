package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import excepciones.ContrasenaIncorrectaException;
import excepciones.NombreDeUsuarioIncorrectoException;
import interfaces.IMuestraEmpleadores;
import interfaces.IMuestraEmpleadosPretensos;
import modelo.Comision;
import modelo.ControlEstadosTicket;
import modelo.EmpleadPretensoPuntaje;
import modelo.EmpleadorPuntaje;
import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import modelo.TicketSimplificado;
import tablas.PuntajeTicket;

/**
 * @author paula
 *<br> 
 *Clase que representa una agencia dentro de un sistema de Gesti�n de B�squedas Laborales.
 *<br>
 *Contiene el registro de todos los usuarios y permite logear un nuevo usuario. El sistema permite el ingreso de datos, que luego ser�n procesados para generar tickets. Dichos tickets permitir� analizar la contrataci�n de empleados.
 */
public class Agencia  implements IMuestraEmpleadores, IMuestraEmpleadosPretensos
{
	private static Agencia instancia = null;

	private ArrayList<Empleador> empleadores = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso> ();
	
	private ArrayList<Empleador> empleadoresActivos = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensosActivos = new ArrayList<EmpleadoPretenso> ();
		
	private ArrayList<ListAsignacionEmpleador> listAsignacionEmpleador = new ArrayList<ListAsignacionEmpleador>();//lista de empresas con sus posibles empleados ordenados
	private ArrayList<ListAsignacionEmpleadPretenso> listAsignacionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();//lista de empleadosPretenso con sus posibles empresas ordenados

	private ArrayList<ListAsignacionEmpleador> listEleccionEmpleador = new ArrayList<ListAsignacionEmpleador>();//lista de empresas con sus posibles empleados ordenados
	private ArrayList<ListAsignacionEmpleadPretenso> listEleccionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();//lista de empleadosPretenso con sus posibles empresas ordenados
	
	private ArrayList<ListAsignacionEmpleador> listaCoincidencias = new ArrayList<ListAsignacionEmpleador>();//lista que guarda las coincidencias entre empresa y empleado

	private ArrayList<TicketSimplificado> bolsaDeEmpleo = new ArrayList<TicketSimplificado>();
	
	
	private double saldoAgencia = 0;
	
	
	private Agencia() {	}
	
	public static Agencia getInstance()
	{
		if (Agencia.instancia == null)
			Agencia.instancia = new Agencia();
		
		return instancia;
	}
	
	public void agregarEmpleador (Empleador empleador) {
		this.empleadores.add(empleador);
	}
	
	public void agregarEmpleadoPretenso (EmpleadoPretenso empleadoPretenso) {
		this.empleadosPretensos.add(empleadoPretenso);
	}
	
	
	public double getSaldoAgencia() {
		return saldoAgencia;
	}

	
	public ArrayList<Empleador> getEmpleadores() {
		return empleadores;
	}

	public ArrayList<EmpleadoPretenso> getEmpleadosPretensos() {
		return empleadosPretensos;
	}

	public ArrayList<Empleador> getEmpleadoresActivos() {
		return empleadoresActivos;
	}

	public ArrayList<EmpleadoPretenso> getEmpleadosPretensosActivos() {
		return empleadosPretensosActivos;
	}

	public ArrayList<ListAsignacionEmpleador> getListAsignacionEmpleador() {
		return listAsignacionEmpleador;
	}

	public ArrayList<ListAsignacionEmpleadPretenso> getListAsignacionEmpleadoPretensos() {
		return listAsignacionEmpleadoPretensos;
	}
	

	public ArrayList<ListAsignacionEmpleador> getListEleccionEmpleador() {
		return listEleccionEmpleador;
	}

	public ArrayList<ListAsignacionEmpleadPretenso> getListEleccionEmpleadoPretensos() {
		return listEleccionEmpleadoPretensos;
	}

	public ArrayList<ListAsignacionEmpleador> getListaCoincidencias() {
		return listaCoincidencias;
	}

	
	public ArrayList<TicketSimplificado> getBolsaDeEmpleo() {
		return bolsaDeEmpleo;
	}

	public void setBolsaDeEmpleo(ArrayList<TicketSimplificado> bolsaDeEmpleo) {
		this.bolsaDeEmpleo = bolsaDeEmpleo;
	}
	
	public void agregarTicketSimplificado(TicketSimplificado ticket) {
		this.bolsaDeEmpleo.add(ticket);
	}
	
	public void emilinarTicketSimplificado(TicketSimplificado ticket) {
		this.bolsaDeEmpleo.remove(ticket);
	}

	/**
	 * Modifica el saldo de la agencia cuando �sta cobra una comisi�n.
	 * <br>
	 * <b>Pre: </b> Existe una lista de coincidencias con usuarios no nulos. Un empleado solo elije una empresa.
	 * <br>
	 * <b>Post: </b> Devuelve un �nico valor.
	 * @param listaCoincidencias
	 */
	public void setSaldoAgencia(ArrayList<ListAsignacionEmpleador> listaCoincidencias) {
		Comision comision = new Comision();
		this.saldoAgencia += comision.calculoComision(listaCoincidencias);
	}

	/**
	 * Genera un ArrayList con los empleados pretensos y empleadores activos.
	 * <br>
	 * <b>Pre: </b> Agencia tiene que tener al menos un empelado pretenso y un emperador.
	 * <br>
	 * <b>Post: </b> Devuelve solo los usuarios con estado de ticket activo.  
	 */
	public void generarUsusariosActivos() {
		this.empleadosPretensosActivos.addAll(ControlListasAgencia.filtroTicketActivoEmpleadosPretensos(this.empleadosPretensos));
		this.empleadoresActivos.addAll(ControlListasAgencia.filtroTicketActivoEmpleadores(this.empleadores));		
	}
	
	
	
	/**
	 * Genera las listas se asignaci�n de los empleadores y los empleados pretensos.
	 * <br>
	 * <b>Pre: <b/> Las listas no pueden ser nulas y tienen que tener al menos un dato.
	 * <br>
	 * <b>Pos: <b/> Devuelve listas de asignaci�n y las de coincidencia. <br> Finaliza estado ticket <br> Actualiza puntaje usuario <br>
	 *   
	 */
	public void activarRondaEncuentrosLaborales () {///metodo que genere las listas de asignacion
		
		ControlListasAgencia cla= new ControlListasAgencia();
		ControlEstadosTicket cet = new ControlEstadosTicket();
		
		listAsignacionEmpleador.addAll(cla.generarListAsignacionEmpleador(empleadosPretensosActivos,empleadoresActivos));
		listAsignacionEmpleadoPretensos.addAll(cla.generarListAsignacionEmpleadoPretenso(empleadosPretensosActivos,empleadoresActivos));
		
		activarRondaEleccion();
		
		
	}
	
	public void activarRondaEleccion(){
		int i ;
		ControlListasAgencia cla= new ControlListasAgencia();
		ControlEstadosTicket cet = new ControlEstadosTicket();
		
		//empleadores
		for (int j=0; j<listAsignacionEmpleador.size(); j++) {
			ListAsignacionEmpleador nodo = new ListAsignacionEmpleador();
			ArrayList<EmpleadoPretenso> nodoListas = new ArrayList<EmpleadoPretenso>();
			i=0;
			
			nodo.setEmpleador(this.listAsignacionEmpleador.get(j).getEmpleador());
		
			while (i < this.listAsignacionEmpleador.get(j).getListEmpleadosPretensos().size()  &&
					this.listAsignacionEmpleador.get(j).getEmpleador().getTicket().getCantEmpleadosSolicitados() > this.listAsignacionEmpleador.get(j).getEmpleador().getTicket().getCantEmpleadosObtenidos())
			{	
				nodoListas.add(this.listAsignacionEmpleador.get(j).getListEmpleadosPretensos().get(i));
				this.listAsignacionEmpleador.get(j).getEmpleador().getTicket().setCantEmpleadosObtenidos(1);
				i++;
			}
			nodo.setListEmpleadosPretensos(nodoListas);
			this.listEleccionEmpleador.add(nodo);
			
			nodo=null;
		}
		
		//empleadoPretensos
		
		for (int j=0; j<listAsignacionEmpleadoPretensos.size(); j++) {
			ListAsignacionEmpleadPretenso nodoEP = new ListAsignacionEmpleadPretenso();
			ArrayList<Empleador> nodoEmpresa = new ArrayList<Empleador>();
		
			nodoEP.setEmpleadoPretenso(listAsignacionEmpleadoPretensos.get(j).getEmpleadoPretenso());
			nodoEmpresa.add(listAsignacionEmpleadoPretensos.get(j).getListEmpleadores().get(0));
			nodoEP.setListEmpleadores(nodoEmpresa);
			
			this.listEleccionEmpleadoPretensos.add(nodoEP);
		
			nodoEP=null;
		}
		
		
		listaCoincidencias.addAll(cla.ListaCoincidencias(listEleccionEmpleador, listEleccionEmpleadoPretensos));
		
		//actualiza el puntaje de los usuarios activos	
		
		actualizacionPuntajeUsuario();
		cet.finalizarTickets(listaCoincidencias);		
		setSaldoAgencia(listaCoincidencias);
	}
	

	/**
	 * Actualiza el puntaje de los usuarios
	 * <br>
	 * <b>Pre: </b> Las listas no pueden ser nulas y tienen que tener al menos un dato cargado.
	 * <br>
	 * <b>Pos: </b> Devuelve el puntaje actualizado.
	 * 
	 */
	
	public void actualizacionPuntajeUsuario()
	{
		for(int i=0; i<empleadosPretensosActivos.size(); i++)
		
		{
			
			//actualiza solo si esta finalizado/ cancelado
			empleadosPretensosActivos.get(i).getTicket().getEstado().actualizarPtj(empleadosPretensosActivos.get(i));

			
			//analizo Posicion en la listaEmpleados -> necesito un contador de elementos de la lista
			
			int posicion = 0;
			while(posicion < listAsignacionEmpleadoPretensos.size() && listAsignacionEmpleadoPretensos.get(posicion).getEmpleadoPretenso().equals(empleadosPretensosActivos.get(i)))
				posicion++;	
	
			int ult = listAsignacionEmpleadoPretensos.size();
			//como calculo la posicion?
			if(posicion == ult) //ultimo lugar
				empleadosPretensosActivos.get(i).setPuntajeUsuario(-5);
			else 
				if(posicion == 1) //primero
					empleadosPretensosActivos.get(i).setPuntajeUsuario(5);
		}
	
		for(int j=0; j<empleadoresActivos.size(); j++)
		{
			///actualiza puntaje finalizados
			empleadoresActivos.get(j).getTicket().getEstado().actualizarPtj(empleadoresActivos.get(j)); 
	
			Empleador empresaPos1 = listAsignacionEmpleador.get(1).getEmpleador();
			
			if(empresaPos1.equals(empleadoresActivos.get(j))) //en primer lugar
				empleadoresActivos.get(j).setPuntajeUsuario(10); 
			
			//necesitocontador de elecciones o var booleana que sea true cuando algun empleado lo haya elegido
			int k = 0;
			while(k < listaCoincidencias.size() && listaCoincidencias.get(k).getEmpleador().equals(empleadoresActivos.get(j)))
				k++;
			
			if(k < listaCoincidencias.size())
				if ( listaCoincidencias.get(k).getListEmpleadosPretensos() == null)//sin elecciones
					empleadoresActivos.get(j).setPuntajeUsuario(-20); 
		}
		
		
	}
	

	/**
	 * Logea un usuario.
	 * <br>
	 * <b>Pre: </b> La lista de empleadores y empleados no pueden ser nula.
	 * <br>
	 * <b>Pos: </b> Que el usuario ingresa al sistema con su nombre de usuario y la contrase�a, si �ste se encuentra registrado.
	 * @param nombUsuarioIngresado : Nombre de usuario a logearse
	 * @param contrasenaIngresada : Contrase�a del usuario a logearse.
	 * @return : retorna si el usuario se pudo logear.
	 * @throws NombreDeUsuarioIncorrectoException : Lanza una excepcion si el usuario es incorrecto.
	 * @throws ContrasenaIncorrectaException : Lanza una excepcion si la contrase�a es incorrecta.
	 */
	public boolean login(String nombUsuarioIngresado, String contrasenaIngresada) throws NombreDeUsuarioIncorrectoException, ContrasenaIncorrectaException
	{
		//de ser usuario inexistente tira una excpecion
		// de ser contrase�a erronea tira otra excpecion
		
		int i = 0;
		boolean loginCorrecto = false;
		
		while (i<this.empleadores.size() && !this.empleadores.get(i).getNombUsuario().equals(nombUsuarioIngresado))
			i++;
		if (i<this.empleadores.size())
		{
			if (this.empleadores.get(i).getContrasenia().equals(contrasenaIngresada))
				loginCorrecto = true;
			else
				throw new ContrasenaIncorrectaException("Contrasena incorrecta");
		}
		else
		{
			i = 0;
			while (i<this.empleadosPretensos.size() && !this.empleadosPretensos.get(i).getNombUsuario().equals(nombUsuarioIngresado))
				i++;
			if (i<this.empleadosPretensos.size())
			{
				if (this.empleadosPretensos.get(i).getContrasenia().equals(contrasenaIngresada))
					loginCorrecto = true;
				else
					throw new ContrasenaIncorrectaException("Contrasena incorrecta");
			}
			else
				throw new NombreDeUsuarioIncorrectoException("Nombre de Usuario incorrecto");
		}
		return loginCorrecto;
		
	}
	

	@Override
	public void mostrarEmpleadosPretensos(ArrayList<EmpleadoPretenso> empleadosPretensos) {
		for(int i = 0; i < empleadosPretensos.size(); i++) {
			System.out.println(empleadosPretensos.get(i).getNombre()+empleadosPretensos.get(i).getApellido());
		}
	}

	@Override
	public void mostrarEmpleadores(ArrayList<Empleador> empleadores) {
		for (int i=0; i < empleadores.size(); i++) {
			if (empleadores.get(i).isPersonaJuridica())
				System.out.println(empleadores.get(i).getNomRazonS());
			else
				System.out.println(empleadores.get(i).getNombre()+empleadores.get(i).getApellido());
		}
		
	}

}
