package paquete;

public class PersonaFisica extends Persona 
{
	private String nomUsuario;
	private String contrasenia;

	public PersonaFisica(String nombre, String apellido, String telefono, String fechaNac, String aalle, int numCalle)
	{
		super(nombre, apellido, telefono, fechaNac, aalle, numCalle);
		
	}

	public String getNomUsuario() 
	{
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) 
	{
		this.nomUsuario = nomUsuario;
	}

	public String getContrasenia() 
	{
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) 
	{
		this.contrasenia = contrasenia;
	}

	
}
