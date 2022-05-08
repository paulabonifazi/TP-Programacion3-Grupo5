package excepciones;

public class NombreDeUsuarioIncorrectoException extends Exception
{
	
	public NombreDeUsuarioIncorrectoException(String arg0)
	{
		super(arg0);
	}

	@Override
	public String getMessage()
	{
		return "Nombre de usuario incorrecto";
	}
}
