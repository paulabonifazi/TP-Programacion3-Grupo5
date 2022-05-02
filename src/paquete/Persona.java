package paquete;

public class Persona
{
	private String nombre;
	private String apellido;
	private String telefono;
	private String fechaNac; // DD/MM/AAAA
	private Domicilio domicilio;
	
	
	
	public Persona(String nombre, String apellido, String telefono, String fechaNac, Domicilio domicilio) 
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.domicilio = domicilio;
		
	}




	public String getNombre() {
		return nombre;
	}



	public String getApellido() {
		return apellido;
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



	
	
}
