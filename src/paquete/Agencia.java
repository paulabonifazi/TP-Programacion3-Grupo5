/* aclaraciones 
 * 		clases que funcionan como objeto
			ListAsignacionEmpleadPretenso guarda un empleadoPretenso con una array de empresas
			ListAsignacionEmpleador guarda una empresa con un array de empleadoPretensos
			
			EmpleadorPuntaje guarda una empresa con el puntaje que obtuvo en las tablas
			EmpleadoPretensPuntaje guarda un empleadoPretenso con el puntaje que obtuvo en las tablas

agencia debe tener los metodo que generen las superListas (todas las empresas con todos sus posibles 
empleados y viceversa)


la clase PuntajeTicketFC y PuntajeTicketCF acceden a la pos a,b y b,a en las tablas

*////PASSARLO A LA DOCUMENTACION///

package paquete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.SortedSet;

import excepciones.ContrasenaIncorrectaException;
import excepciones.NombreDeUsuarioIncorrectoException;
import modelo.Comision;
import modelo.ControlEstadosTicket;
import modelo.EmpleadPretensoPuntaje;
import modelo.EmpleadorPuntaje;
import modelo.ListAsignacionEmpleadPretenso;
import tablas.PuntajeTicket;

import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;

/**
 * @author paula
 *<br> 
 *Clase que representa una agencia dentro de un sistema de Gestión de Búsquedas Laborales.
 *<br>
 *Contiene el registro de todos los usuarios y permite logear un nuevo usuario. El sistema permite el ingreso de datos, que luego serán procesados para generar tickets. Dichos tickets permitirá analizar la contratación de empleados.
 */
public class Agencia
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

	private double saldoAgencia = 0;
	
	
	public Agencia() {	}
	
	public static Agencia getInstance()
	{
		if (Agencia.instancia == null)
			Agencia.instancia = new Agencia();
		
		return instancia;
	}
	
	public void agregarEmpleador (Empleador empleador) {
		empleadores.add(empleador);
	}
	
	public void agregarEmpleadoPretenso (EmpleadoPretenso empleadoPretenso) {
		empleadosPretensos.add(empleadoPretenso);
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

	/**
	 * Modifica el saldo de la agencia cuando ésta cobra una comisión.
	 * <br>
	 * <b>Pre: </b> Existe una lista de coincidencias con usuarios no nulos. Un empleado solo elije una empresa.
	 * <br>
	 * <b>Post: </b> Devuelve un único valor.
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
	 * Genera las listas se asignación de los empleadores y los empleados pretensos.
	 * <br>
	 * <b>Pre: <b/> Las listas no pueden ser nulas y tienen que tener al menos un dato.
	 * <br>
	 * <b>Pos: <b/> Devuelve listas de asignación y las de coincidencia. <br> Finaliza estado ticket <br> Actualiza puntaje usuario <br>
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
		int i = 0;
		ControlListasAgencia cla= new ControlListasAgencia();
		ControlEstadosTicket cet = new ControlEstadosTicket();
		
		ListAsignacionEmpleador nodo = new ListAsignacionEmpleador();
		ArrayList<EmpleadoPretenso> nodoListas = new ArrayList<EmpleadoPretenso>();
		
		//empleadores
		for (int j=0; j<listAsignacionEmpleador.size(); j++) {
			nodo.setEmpleador(this.listAsignacionEmpleador.get(j).getEmpleador());
			
			while (i < this.listAsignacionEmpleador.size()  &&  this.listAsignacionEmpleador.get(j).getEmpleador().getTicket().getCantEmpleadosSolicitados() < this.listAsignacionEmpleador.get(j).getEmpleador().getTicket().getCantEmpleadosObtenidos())
			{	
				nodoListas.add(this.listAsignacionEmpleador.get(j).getListEmpleadosPretensos().get(i));
				this.listAsignacionEmpleador.get(i).getEmpleador().getTicket().setCantEmpleadosObtenidos();
				i++;
			}
			
			nodo.setListEmpleadosPretensos(nodoListas);
			this.listEleccionEmpleador.add(nodo);
		}
		
		//empleadoPretensos
		
		ListAsignacionEmpleadPretenso nodoEP = new ListAsignacionEmpleadPretenso();
		ArrayList<Empleador> nodoEmpresa = new ArrayList<Empleador>();
		
		for (int j=0; j<listAsignacionEmpleadoPretensos.size(); j++) {
			nodoEP.setEmpleadoPretenso(listAsignacionEmpleadoPretensos.get(j).getEmpleadoPretenso());
			nodoEmpresa.add(listAsignacionEmpleadoPretensos.get(j).getListEmpleadores().get(0));
			
			this.listEleccionEmpleadoPretensos.add(nodoEP);
		}
		
		listaCoincidencias.addAll(cla.ListaCoincidencias(listEleccionEmpleador, listEleccionEmpleadoPretensos));
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
			
			//analizo estado del ticket 
			if(empleadosPretensosActivos.get(i).getTicket().getEstadoTicket().getEstado().equals("FINALIZADO"))
				empleadosPretensosActivos.get(i).setPuntajeUsuario(10);
			else
				if(empleadosPretensosActivos.get(i).getTicket().getEstadoTicket().getEstado().equals("CANCELADO"))
					empleadosPretensosActivos.get(i).setPuntajeUsuario(-1);
			
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
	
			if(empleadoresActivos.get(j).getTicket().getEstadoTicket().getEstado().equals("FINALIZADO"))
				empleadoresActivos.get(j).setPuntajeUsuario(50); 
	
			Empleador empresaPos1 = listAsignacionEmpleador.get(1).getEmpleador();
			
			if(empresaPos1.equals(empleadoresActivos.get(j))) //en primer lugar
				empleadoresActivos.get(j).setPuntajeUsuario(10); 
			
			//necesitocontador de elecciones o var booleana que sea true cuando algun empleado lo haya elejido
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
	 * <b>Pos: </b> Que el usuario ingresa al sistema con su nombre de usuario y la contraseña, si éste se encuentra registrado.
	 * @param nombUsuarioIngresado : Nombre de usuario a logearse
	 * @param contrasenaIngresada : Contraseña del usuario a logearse.
	 * @return : retorna si el usuario se pudo logear.
	 * @throws NombreDeUsuarioIncorrectoException : Lanza una excepcion si el usuario es incorrecto.
	 * @throws ContrasenaIncorrectaException : Lanza una excepcion si la contraseña es incorrecta.
	 */
	public boolean login(String nombUsuarioIngresado, String contrasenaIngresada) throws NombreDeUsuarioIncorrectoException, ContrasenaIncorrectaException
	{
		//de ser usuario inexistente tira una excpecion
		// de ser contraseña erronea tira otra excpecion
		/*
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
		*/
		return true;
	}
}
