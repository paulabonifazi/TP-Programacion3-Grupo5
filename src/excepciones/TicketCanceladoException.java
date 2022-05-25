package excepciones;

public class TicketCanceladoException extends Exception
{
	public TicketCanceladoException(String arg0)
	{
		super(arg0);
	}

	@Override
	public String getMessage()
	{
		return "TICKET CANCELADO.";
	}

}
