package paquete;

public class PersonaFactory
{
	public static Persona getPersona(String tipo, Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia)
	{
		Persona respuesta = null;
		
		if (tipo.equals("Empleador"))
			respuesta = new Empleador(domicilio, telefono, mail, nombUsuario, contrasenia);
		else if (tipo.equals("Empleado"))
			respuesta = new Empleado(domicilio, telefono, mail, nombUsuario, contrasenia);
			
		
		return respuesta;
	}
}

/*
 * ver si se puede aplicar factory
 * ya que los constructores de Empleador y empleado tienen diferente cantidad y tipo
 * de parámetros!
 */