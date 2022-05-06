package excepciones;

public class ContrasenaIncorrectaException extends Exception
{
	private String contrasena;

	public ContrasenaIncorrectaException(String contrasena)
	{
		super();
		this.contrasena = contrasena;
	}

	@Override
	public String getMessage()
	{
		return "Contraseña incorrecta";
	}

	public String getContrasena()
	{
		return contrasena;
	}
}
