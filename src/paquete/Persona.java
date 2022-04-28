package paquete;

import modelo.Ticket;

public class Persona
{
	private Domicilio domicilio;
	private String telefono;
	private String mail;
	private String nombUsuario;
	private String contrasenia;
	private Ticket ticket;
	
	
	/*
	 * ver como hacer un factory 
	 * 
	 */
	public Persona(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			Ticket ticket) 
	{
		super();
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.nombUsuario = nombUsuario;
		this.contrasenia = contrasenia;
		this.ticket = ticket;
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
		 * de ser contraseņa erronea tirar excpecion
		 * 
		 */
	}
	
	
}
