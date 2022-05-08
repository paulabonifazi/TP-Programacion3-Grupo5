package excepciones;

public class ContrasenaIncorrectaException extends Exception
{
	
	public ContrasenaIncorrectaException(String arg0)
	{
		super(arg0);
	}

	@Override
	public String getMessage()
	{
		return "Contraseña incorrecta";
	}
}
