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
	//El sueldo pretrendido que se utiliza es el que eligio cada usuario cuando lleno el formulario 
	double sueldoPretendido =0.0;
	double sueldoPretendidoE =0.0;
	double comisionTotal = 0.0;
	double c = 0.0;
	final double v1 = 10000;
	final double v2 = 20000;
	final double v3 = 30000;

	///existiria parametros si guardase todas las listas de asignaciones, pero con cada llamado se borra lo existente -> es como si tubiera unica lista
		 public double calculoComision(ArrayList<ListAsignacionEmpleador>listaCoincidencias )
			{
			
			 	ArrayList<EmpleadoPretenso>listaEmpleadosContratados = new ArrayList<EmpleadoPretenso>() ;
				for(int i=0; i< listaCoincidencias.size(); i++)//recorro la lista de contrataciones 
				{
					 
					listaEmpleadosContratados.addAll(listaCoincidencias.get(i).getListEmpleadosPretensos());
					System.out.println("blblblblbl"+listaEmpleadosContratados.size());
					
					for(int j=0; j <listaEmpleadosContratados.size(); j++ )//recorro la lista de empelados
					{
						System.out.println("blblblblbl -> e,pleados");
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
					if(listaCoincidencias.get(i).getEmpleador().getTicket().getFbTicket().getRemuneracion().equals("V1"))
						sueldoPretendidoE = v1;
					else if (listaCoincidencias.get(i).getEmpleador().getTicket().getFbTicket().getRemuneracion().equals("V2"))
						sueldoPretendidoE = v2;
					else if (listaCoincidencias.get(i).getEmpleador().getTicket().getFbTicket().getRemuneracion().equals("V3"))
						sueldoPretendidoE = v3;
					
					if(listaCoincidencias.get(i).getEmpleador().isPersonaJuridica())
					{
						
						if(listaCoincidencias.get(i).getEmpleador().getRubro().equals("Salud"))
							comisionEmpleador = sueldoPretendidoE * PorcentajePJSalud;
						else if(listaCoincidencias.get(i).getEmpleador().getRubro().equals("Comercio local"))
								comisionEmpleador = sueldoPretendidoE * PorcentajePJComercioLocal;
							else //rubro ->"COMERCIO INTERNACIONAL"
								comisionEmpleador = sueldoPretendidoE;
						System.out.println(comisionEmpleador);
					}
					else //personaFisica
					{
						System.out.println("blblblblbl -> fisica");
						if(listaCoincidencias.get(i).getEmpleador().getRubro().equals("Salud"))
							comisionEmpleador = sueldoPretendidoE * PorcentajePFSalud;
						else if(listaCoincidencias.get(i).getEmpleador().getRubro().equals ("Comercio local"))
								comisionEmpleador = sueldoPretendidoE * PorcentajePFComercioLocal;
							else //rubro ->"COMERCIO INTERNACIONAL"
								comisionEmpleador = sueldoPretendidoE * PorcentajePFComercioInternacional;
					}

					//RESTA 1% POR CADA PUNTO
			
					if(listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() > 0 && listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() <= 99)
						comisionEmpleador -= listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() * 0.01;
					else
						if(listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() >= 100)
							comisionEmpleador = 0;

					int N = listaEmpleadosContratados.size();
					comisionTotal = (comisionEmpleador)*N + comisionEmpleados;
					
					c+=comisionTotal;
				}	

				return c;//retorno el total de la comision de la lista
			}

}
