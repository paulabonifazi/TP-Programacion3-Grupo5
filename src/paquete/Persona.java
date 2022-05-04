package paquete;

public class Persona
{
	private Domicilio domicilio;
	private String telefono;
	private String fechaNac; // DD/MM/AAAA
	private Domicilio domicilio;
	
	
	
	public Persona(String nombre, String apellido, String telefono, String fechaNac, Domicilio domicilio) 
	{
		super();
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.domicilio = domicilio;
		
	}
	




	public String getNombre() {
		return nombre;
	}
	

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}


	public String getTelefono() {
		return telefono;
	}



	public String getFechaNac() {
		return fechaNac;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}




	public Domicilio getDomicilio() {
		return domicilio;
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
		 * de ser contrase�a erronea tirar excpecion
		 * 
		 */
	}
	
	
}
