package paquete;

import java.util.ArrayList;

import interfaces.IPersonaFisica;
import interfaces.IPersonaJuridica;
import interfaces.MuestraListaEmpleadosPretensos;
import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import modelo.TicketEmpleador;

public class Empleador extends Persona implements IPersonaFisica, IPersonaJuridica, MuestraListaEmpleadosPretensos
{
	//ver como hacer para que tenga nombre o razon social!
	private String nomRazonS;
	private String rubro; //salud - comercio local - comercio internacional
	private TicketEmpleador ticket;
	///definir como se carga listaPesos
	private ValoracionAspecto listaPesos;                 ///como consoco la cantidad de aspectos -> no seria necesario un array, suficiente con un objeto que guarde los 7 PesosAspectos
	
	public Empleador(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nomRazonS, String rubro, TicketEmpleador ticket) 
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		this.nomRazonS = nomRazonS;
		this.rubro = rubro;
		this.ticket = ticket;
	}
	
	/*/* en la parte donde la empresa se registra crea y manda el valor*/
	public void setListaPesos(ValoracionAspecto listaPesos) {
		this.listaPesos = listaPesos;
	}

	public ValoracionAspecto getListaPesos() {
		return listaPesos;
	}

	public TicketEmpleador getTicket() {
		return ticket;
	}

	@Override
	public String getNomRazonS()
	{
		// TODO Auto-generated method stub
		return nomRazonS;
	}

	@Override
	public String getNombre()
	{
		// TODO Auto-generated method stub
		return null;
		//return nombre;
	}

	@Override
	public String getApellido()
	{
		// TODO Auto-generated method stub
		return null;
		//return apellido;
	}

	@Override
	public int getEdad()
	{
		// TODO Auto-generated method stub
		return 0;
		//return edad;
	}

	public String getRubro()
	{
		return rubro;
	}

	@Override
	public void mostrarListaEmpleadosPretensos(ArrayList<EmpleadoPretenso> empleadoPretenso)
	{
		for (int i = 0; i<empleadoPretenso.size(); i++) 
			System.out.println(empleadoPretenso.get(i).getNombUsuario());
	}
	
	@Override
	public void mostrarListaAsignacionDelEmpleador(ListAsignacionEmpleador lista)
	{
		for (int i=0; i<lista.getListEmpleadosPretensos().size(); i++)
			System.out.println(lista.getListEmpleadosPretensos().get(i).getNombUsuario());
	}

	@Override
	public void mostrarResultado(ArrayList<ListAsignacionEmpleadPretenso> lista)
	{
		boolean coincidencia = false;
		int contEmpleado = 0;
		ListAsignacionEmpleadPretenso empleadoActual = null;
		while (coincidencia==false && contEmpleado < lista.size()) {
			int contEmpleador = 0;
			//comienzo la busqueda en el nodo
			empleadoActual = lista.get(contEmpleado);
			while (coincidencia==false && contEmpleador <= empleadoActual.getListEmpleadores().size()) {
				if (empleadoActual.getListEmpleadores().get(contEmpleador).getNombUsuario().equals(this.getNombUsuario()))///ver si no hay otra forma de buscar
					coincidencia = true;
				else
					contEmpleador++;
			}
			contEmpleado++;
		}
		if (coincidencia == false)//si coincidencia es false -> nadie lo contrato -> lanza exception u cartel
			System.out.println("Nadie tuvo en cuenta a " + this.getNombUsuario());
		else
			System.out.println("Hay coincidencia entre " + this.getNombUsuario() + " y " + empleadoActual.getEmpleadoPretenso().getNombUsuario());		
	}

}
