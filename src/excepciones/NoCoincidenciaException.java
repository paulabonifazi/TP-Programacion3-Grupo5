package excepciones;

public class NoCoincidenciaException extends Exception
{
	private String usuario;

	public NoCoincidenciaException(String nombreUsuario)
	{
		super();
		this.usuario = nombreUsuario;
	}

	@Override
	public String getMessage()
	{
		return "Nadie tuvo en cuenta a " + this.usuario;
	}
	
}
