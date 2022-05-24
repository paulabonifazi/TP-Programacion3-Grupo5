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
	double sueldoPretendido ;
	double comisionTotal = 0.0;
	
	final double v1 = 10000;
	final double v2 = 20000;
	final double v3 = 30000;

	///existiria parametros si guardase todas las listas de asignaciones, pero con cada llamado se borra lo existente -> es como si tubiera unica lista
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

					
		
						if  (listaEmpleadosContratados.get(j).getTicket().getFbTicket().getRemuneracion() == "V1")
							sueldoPretendido = v1;
						else if (listaEmpleadosContratados.get(j).getTicket().getFbTicket().getRemuneracion() == "V2")
							sueldoPretendido = v2;
						else
							sueldoPretendido = v3;
						
						
						if(listaEmpleadosContratados.get(j).getTicket().getFbTicket().getTipoPuesto().equals("JUNIOR"))
							comision = sueldoPretendido * PorcentajeJunior;
						else
							if(listaEmpleadosContratados.get(j).getTicket().getFbTicket().getTipoPuesto().equals("SENIOR"))
								comision = sueldoPretendido * PorcentajeSenior;
							else //if(tipoPuesto == "Gerencial")
								comision = sueldoPretendido;

						//PARA AMBOS SE PUEDE MODIFICAR POR EL PUNTAJE DE USUARIO -> RESTA 1% POR CADA PUNTO

						if(listaEmpleadosContratados.get(i).getPuntajeUsuario() > 0 && listaEmpleadosContratados.get(i).getPuntajeUsuario() <= 99)
							comision -= listaEmpleadosContratados.get(i).getPuntajeUsuario() * 0.01;
						else
							if(listaEmpleadosContratados.get(i).getPuntajeUsuario() >= 100)
								comision = 0;

						comisionEmpleados += comision;

					}

					//calculo comsion que se le cobra al EMPLEADOR
					//necesito datos del registro 

					if(listaCoincidencias.get(i).getEmpleador().isPersonaJuridica())//////a definir    ////////////// //////       /////////////
					{
						if(listaCoincidencias.get(i).getEmpleador().getRubro().equals("SALUD"))
							comisionEmpleador = sueldoPretendido * PorcentajePJSalud;
						else if(listaCoincidencias.get(i).getEmpleador().getRubro().equals("COMERCIO LOCAL"))
								comisionEmpleador = sueldoPretendido * PorcentajePJComercioLocal;
							else //if(rubro =="COMERCIO INTERNACIONAL")
								comisionEmpleador = sueldoPretendido ;
					}
					else //personaFisica
					{
						if(listaCoincidencias.get(i).getEmpleador().getRubro().equals("SALUD"))
							comisionEmpleador = sueldoPretendido * PorcentajePFSalud;
						else if(listaCoincidencias.get(i).getEmpleador().getRubro().equals ("COMERCIO LOCAL"))
								comisionEmpleador = sueldoPretendido * PorcentajePFComercioLocal;
							else //if(rubro =="COMERCIO INTERNACIONAL")
								comisionEmpleador = sueldoPretendido * PorcentajePFComercioInternacional;
					}

					//PARA AMBOS SE PUEDE MODIFICAR POR EL PUNTAJE DE USUARIO -> RESTA 1% POR CADA PUNTO
			
					if(listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() > 0 &&listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() <= 99)
						comisionEmpleador -= listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() * 0.01;
					else
						if(listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() >= 100)
							comisionEmpleador = 0;

					
					comisionTotal = (comisionEmpleador)*listaEmpleadosContratados.size() + comisionEmpleados; 
				}	

				return comisionTotal;//retorno el total de la comision de la lista
			}

}
