package excepciones;

public class NombreDeUsuarioIncorrectoException extends Exception
{
	private String usuario;
	
	public NombreDeUsuarioIncorrectoException(String usuario)
	{
		super();
		this.usuario = usuario;
	}

	@Override
	public String getMessage()
	{
		return "Nombre de usuario incorrecto";
	}

	public String getUsuario()
	{
		return usuario;
	}
}
