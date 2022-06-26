package paquete;

import java.io.Serializable;

public class Domicilio implements Serializable
{
	private String calle;
	private int numero;
	private String descripcion;
	
	
	public Domicilio() {
		super();
	}


	public Domicilio(String calle, int numero, String descripcion)
	{
		super();
		this.calle = calle;
		this.numero = numero;
		this.descripcion = descripcion;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
