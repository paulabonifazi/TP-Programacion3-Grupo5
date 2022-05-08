package paquete;

public class Persona
{
	private Domicilio domicilio;
	private String telefono;
	private String mail;
	private String nombUsuario;
	private String contrasenia;
	
	private int puntajeUsuario;
	
	/*
	 * ver como hacer un factory 
	 * 
	 */
	public Persona(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia) 
	{
		super();
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.nombUsuario = nombUsuario;
		this.contrasenia = contrasenia;
		this.puntajeUsuario = 0;
	}
	


	public Domicilio getDomicilio() {
		return domicilio;
	}
	

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getNombUsuario() {
		return nombUsuario;
	}


	public void setNombUsuario(String nombUsuario) {
		this.nombUsuario = nombUsuario;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public void Logear()
	{
	
		/*
		 * de ser usuario inexistente tirar excpecion
		 * de ser contraseña erronea tirar excpecion
		 * 
		 */
	}



	public int getPuntajeUsuario() {
		return puntajeUsuario;
	}



	public void setPuntajeUsuario(int puntajeUsuario) {
		this.puntajeUsuario += puntajeUsuario;
	}
	
	
	
	
	
}
