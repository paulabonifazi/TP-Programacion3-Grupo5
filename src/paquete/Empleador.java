package paquete;

import Interfaces.IPersonaFisica;
import Interfaces.IPersonaJuridica;

public class Empleador extends Persona implements IPersonaFisica, IPersonaJuridica
{
	//ver como hacer para que tenga nombre o razon social!
	private String nomRazonS;
	private String rubro; //salud - comercio local - comercio internacional
	
	
	public Empleador(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nomRazonS, String rubro) 
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		this.nomRazonS = nomRazonS;
		this.rubro = rubro;
	}

	
	
	

}