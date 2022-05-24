package modelo;

import java.util.ArrayList;

import paquete.EmpleadoPretenso;
public class Comision {
	final double PorcentajeJunior = 0.8;
	final double PorcentajeSenior = 0.9;
	final double PorcentajePJSalud = 0.8;
	final double PorcentajePJComercioLocal = 0.9;
	final double PorcentajePFSalud = 0.6;
	final double PorcentajePFComercioLocal = 0.7;
	final double PorcentajePFComercioInternacional = 0.8;

	double comisionEmpleados = 0;
	double comisionEmpleador = 0;
	//El sueldo pretrendido que se utiliza es el que desgino cada usuario cuando lleno el formulario 
	double sueldoPretendido ;
	double comisionTotal = 0.0;
	
	final double v1 = 10000;
	final double v2 = 20000;
	final double v3 = 30000;

	public double calculoComision(ArrayList<ListAsignacionEmpleador>listaCoincidencias )
	{
		ArrayList <EmpleadoPretenso>listaEmpleadosContratados = null;
			for(int i=0; i< listaCoincidencias.size(); i++)//recorro la lista de contrataciones 
			{
				listaEmpleadosContratados = listaCoincidencias.get(i).getListEmpleadosPretensos();

				for(int j=0; j <listaEmpleadosContratados.size(); j++ )//recorro la lista de empelados
				{
					double comision = 0;
					//calculo la comision que se le cobra al EMPLEADO
		
					if  (listaEmpleadosContratados.get(j).getTicket().getFbTicket().getRemuneracion().equals("V1"))
						sueldoPretendido = v1;
					else if (listaEmpleadosContratados.get(j).getTicket().getFbTicket().getRemuneracion().equals("V2"))
						sueldoPretendido = v2;
					else
						sueldoPretendido = v3;
						
						
					if(listaEmpleadosContratados.get(j).getTicket().getFbTicket().getTipoPuesto().equals("Junior"))
						comision = sueldoPretendido * PorcentajeJunior;
					else
						if(listaEmpleadosContratados.get(j).getTicket().getFbTicket().getTipoPuesto().equals("Senior"))
							comision = sueldoPretendido * PorcentajeSenior;
						else //tipoPuesto ->"Gerencial"
							comision = sueldoPretendido;

					//RESTA 1% POR CADA PUNTO

					if(listaEmpleadosContratados.get(i).getPuntajeUsuario() > 0 && listaEmpleadosContratados.get(i).getPuntajeUsuario() <= 99)
						comision -= listaEmpleadosContratados.get(i).getPuntajeUsuario() * 0.01;
					else
						if(listaEmpleadosContratados.get(i).getPuntajeUsuario() >= 100)
							comision = 0;

					comisionEmpleados += comision;

				}

				//calculo comsion que se le cobra al EMPLEADOR
					
				if(listaCoincidencias.get(i).getEmpleador().isPersonaJuridica())
				{
					if(listaCoincidencias.get(i).getEmpleador().getRubro().equals("Salud"))
						comisionEmpleador = sueldoPretendido * PorcentajePJSalud;
					else if(listaCoincidencias.get(i).getEmpleador().getRubro().equals("Comercio local"))
							comisionEmpleador = sueldoPretendido * PorcentajePJComercioLocal;
						else //rubro ->"COMERCIO INTERNACIONAL"
							comisionEmpleador = sueldoPretendido;
				}
				else //personaFisica
				{
					if(listaCoincidencias.get(i).getEmpleador().getRubro().equals("Salud"))
						comisionEmpleador = sueldoPretendido * PorcentajePFSalud;
					else if(listaCoincidencias.get(i).getEmpleador().getRubro().equals ("Comercio local"))
						 	comisionEmpleador = sueldoPretendido * PorcentajePFComercioLocal;
						else //rubro ->"COMERCIO INTERNACIONAL"
							comisionEmpleador = sueldoPretendido * PorcentajePFComercioInternacional;
				}

				//RESTA 1% POR CADA PUNTO
			
				if(listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() > 0 && listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() <= 99)
					comisionEmpleador -= listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() * 0.01;
				else
					if(listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() >= 100)
						comisionEmpleador = 0;

					
				comisionTotal = (comisionEmpleador)*listaEmpleadosContratados.size() + comisionEmpleados; 
			}	

			return comisionTotal;//retorno el total de la comision de la lista
		}
}
