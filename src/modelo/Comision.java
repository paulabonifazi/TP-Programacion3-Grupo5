
package modelo;

import decorator.EmplPretensoComisioFactory;
import decorator.EmpleadoComisioFactory;
import paquete.EmpleadoPretenso;

import java.util.ArrayList;
public class Comision {
	final double PorcentajeJunior = 0.8;
	final double PorcentajeSenior = 0.9;
	

	double comisionEmpleados = 0;
	double comisionEmpleador = 0;
	//El sueldo pretrendido que se utiliza es el que eligio cada usuario cuando lleno el formulario 
	double sueldoPretendido =0.0;
	double sueldoPretendidoE =0.0;
	double comisionTotal = 0.0;
	double c = 0.0;
	int N =0;
	double comision;
	final double v1 = 10000;
	final double v2 = 20000;
	final double v3 = 30000;

	 public double calculoComision(ArrayList<ListAsignacionEmpleador>listaCoincidencias )
		{
		
		 	ArrayList<EmpleadoPretenso>listaEmpleadosContratados = new ArrayList<EmpleadoPretenso>() ;
			for(int i=0; i< listaCoincidencias.size(); i++)//recorro la lista de contrataciones 
			{
				comisionEmpleador = 0;
				listaEmpleadosContratados.addAll(listaCoincidencias.get(i).getListEmpleadosPretensos());
				
				for(int j=0; j <listaEmpleadosContratados.size(); j++ )//recorro la lista de empelados
				{
					comision = 0;
					//calculo la comision que se le cobra al EMPLEADO
	
					if  (listaEmpleadosContratados.get(j).getTicket().getFbTicket().getRemuneracion().equals("V1"))
						sueldoPretendido = v1;
					else if (listaEmpleadosContratados.get(j).getTicket().getFbTicket().getRemuneracion().equals("V2"))
						sueldoPretendido = v2;
					else
						sueldoPretendido = v3;
					
					comisionEmpleados = (sueldoPretendido * EmplPretensoComisioFactory.getPorcentajeComision(listaEmpleadosContratados.get(j)));
	
					//RESTA 1% POR CADA PUNTO
					if(listaEmpleadosContratados.get(j).getPuntajeUsuario() > 0 && listaEmpleadosContratados.get(j).getPuntajeUsuario() <= 99)
						comision -= listaEmpleadosContratados.get(j).getPuntajeUsuario() * 0.01;
					else
						if(listaEmpleadosContratados.get(j).getPuntajeUsuario() >= 100)
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
                                    //+ el 0.2
                                    comisionEmpleador = (sueldoPretendidoE * (EmpleadoComisioFactory.getPorcentajeComision(listaCoincidencias.get(i).getEmpleador()) + 0.2));
            
				}
				else //personaFisica
				{//dejo tal cual
                                    comisionEmpleador = (sueldoPretendidoE * (EmpleadoComisioFactory.getPorcentajeComision(listaCoincidencias.get(i).getEmpleador()) ));
				}
	
				//RESTA 1% POR CADA PUNTo
				if(listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() > 0 && listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() <= 99)
					comisionEmpleador -= listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() * 0.01;
				else
					if(listaCoincidencias.get(i).getEmpleador().getPuntajeUsuario() >= 100)
						comisionEmpleador = 0;
				
				N = listaCoincidencias.get(i).getListEmpleadosPretensos().size();
				comisionTotal = (comisionEmpleador)*N + comisionEmpleados;
	
				c+=comisionTotal;
			}	
	
			return c;//retorno el total de la comision de la lista
		}

}
