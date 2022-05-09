package paquete;

import excepciones.ContrasenaIncorrectaException;
import excepciones.NombreDeUsuarioIncorrectoException;

public class Persona
{
	private Domicilio domicilio;
	private String telefono;
	private String mail;
	private String nombUsuario;
	private String contrasenia;
	
	private int puntajeUsuario;
	
	
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
	
	public void login(String nombUsuarioIngresado, String contrasenaIngresada) throws NombreDeUsuarioIncorrectoException, ContrasenaIncorrectaException
	{
		/**
		 * trata excpecion de ser usuario inexistente 
		 * trata excpecion de ser contraseña erronea
		 * Lo mejor sería hacer 2 funciones en Agencja: una para buscar el usuario y otra para la contraseña para evitar multicatch 
		 **/
		try
		{
			Agencia.getInstance().login(nombUsuarioIngresado, contrasenaIngresada);
		} catch (NombreDeUsuarioIncorrectoException e)
		{
			System.out.println(e.getMessage());
		}catch (ContrasenaIncorrectaException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public int getPuntajeUsuario() {
		return puntajeUsuario;
	}

	public void setPuntajeUsuario(int puntajeUsuario) {
		this.puntajeUsuario += puntajeUsuario;
	}
	
}
