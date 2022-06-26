package prueba;

import java.io.IOException;

import paquete.Agencia;
import persistencia.AgenciaDTO;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;
import util.Util;

public class Lectura {
	
	public static void main (String [] args) {

	IPersistencia idao = new PersistenciaXML();


	try
	{
	    idao.abrirInput("agencia.xml");
	    
	    AgenciaDTO agenciaDTO = (AgenciaDTO) idao.leer();
	    Util.agenciaFromAgenciaDTO(agenciaDTO);///usa el singleton
	    
	    idao.cerrarInput();
	    System.out.println("Agencia recuperada: ");
	    System.out.println(Agencia.getInstance());
	} catch (Exception e)
	{
	    // TODO Auto-generated catch block
	    System.out.println("Exception " + e.getMessage());
	}

    
		
	Agencia.getInstance().generarUsusariosActivos();
		
	Agencia.getInstance().activarRondaEncuentrosLaborales();


	    try
	        {
	                    idao.abrirOutput("agenciaListas.xml");
	            System.out.println("Crea archivo escritura");
	            AgenciaDTO edto=Util.agenciaListaDTOfromAgencia();
	            
	            idao.escribir(edto);
	            
	            
	            System.out.println("grabada exitosamente");
	            idao.cerrarOutput();
	            System.out.println("Archivo cerrado");
	        } catch (IOException e)
	        {
	            // TODO Auto-generated catch block
	            System.out.println(e.getLocalizedMessage());
	        }
	    
	
	System.out.println("____________________________________________________");
	System.out.println("Empleados pretensos asignados:");
	for(int i=0; i<Agencia.getInstance().getListAsignacionEmpleador().size(); i++) {
		System.out.println("*******************");
		if (Agencia.getInstance().getListAsignacionEmpleador().get(i).getEmpleador().isPersonaJuridica())
			System.out.println(Agencia.getInstance().getListAsignacionEmpleador().get(i).getEmpleador().getNomRazonS());
		else
			System.out.println(Agencia.getInstance().getListAsignacionEmpleador().get(i).getEmpleador().getNombre()+Agencia.getInstance().getListAsignacionEmpleador().get(i).getEmpleador().getApellido());
		
		for(int j=0; j < Agencia.getInstance().getListAsignacionEmpleador().get(i).getListEmpleadosPretensos().size(); j++) {
			System.out.println(Agencia.getInstance().getListAsignacionEmpleador().get(i).getListEmpleadosPretensos().get(j).getNombre()+Agencia.getInstance().getListAsignacionEmpleador().get(i).getListEmpleadosPretensos().get(j).getApellido());
		}
	}
	
	
	System.out.println("____________________________________________________");
	System.out.println("Empleadores asignados:");
	for(int i=0; i<Agencia.getInstance().getListAsignacionEmpleadoPretensos().size(); i++) {
		System.out.println("*******************");
		System.out.println(Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(i).getEmpleadoPretenso().getNombre()+Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(i).getEmpleadoPretenso().getApellido());
		
		for(int j=0; j < Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().size(); j++) {
			if (Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().get(j).isPersonaJuridica())
				System.out.println(Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getNomRazonS());
			else
				System.out.println(Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getNombre()+Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getApellido());
			
		}
	}
	
	
	
	System.out.println("____________________________________________________");
	System.out.println("Empleadores elegidos:");
	for(int i=0; i<Agencia.getInstance().getListEleccionEmpleadoPretensos().size(); i++) {
		System.out.println("*******************");
		System.out.println(Agencia.getInstance().getListEleccionEmpleadoPretensos().get(i).getEmpleadoPretenso().getNombre()+Agencia.getInstance().getListEleccionEmpleadoPretensos().get(i).getEmpleadoPretenso().getApellido());
		
		for(int j=0; j < Agencia.getInstance().getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().size(); j++) {
			if (Agencia.getInstance().getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().get(j).isPersonaJuridica())
				System.out.println(Agencia.getInstance().getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getNomRazonS());
			else
				System.out.println(Agencia.getInstance().getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getNombre()+Agencia.getInstance().getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getApellido());
			
		}
	}
	
	System.out.println("Empleados pretensos elegidos:");
	for(int i=0; i<Agencia.getInstance().getListEleccionEmpleador().size(); i++) {
		System.out.println("*******************");
		if (Agencia.getInstance().getListEleccionEmpleador().get(i).getEmpleador().isPersonaJuridica())
			System.out.println(Agencia.getInstance().getListEleccionEmpleador().get(i).getEmpleador().getNomRazonS());
		else
			System.out.println(Agencia.getInstance().getListEleccionEmpleador().get(i).getEmpleador().getNombre()+Agencia.getInstance().getListEleccionEmpleador().get(i).getEmpleador().getApellido());
		
		for(int j=0; j < Agencia.getInstance().getListEleccionEmpleador().get(i).getListEmpleadosPretensos().size(); j++) {
			System.out.println(Agencia.getInstance().getListEleccionEmpleador().get(i).getListEmpleadosPretensos().get(j).getNombre()+Agencia.getInstance().getListEleccionEmpleador().get(i).getListEmpleadosPretensos().get(j).getApellido());
		}
	}
	
	
	
	System.out.println("____________________________________________________");
	System.out.println("Lista de asignaciones:");
	for(int i=0; i<Agencia.getInstance().getListaCoincidencias().size(); i++) {
		System.out.println("*******************");
		if (Agencia.getInstance().getListaCoincidencias().get(i).getEmpleador().isPersonaJuridica())
			System.out.println(Agencia.getInstance().getListaCoincidencias().get(i).getEmpleador().getNomRazonS());
		else
			System.out.println(Agencia.getInstance().getListaCoincidencias().get(i).getEmpleador().getNombre()+Agencia.getInstance().getListaCoincidencias().get(i).getEmpleador().getApellido());
		
		for(int j=0; j < Agencia.getInstance().getListaCoincidencias().get(i).getListEmpleadosPretensos().size(); j++) {
			System.out.println(Agencia.getInstance().getListaCoincidencias().get(i).getListEmpleadosPretensos().get(j).getNombre()+Agencia.getInstance().getListaCoincidencias().get(i).getListEmpleadosPretensos().get(j).getApellido());
		}
	}
	
	
	System.out.println("saldo "+Agencia.getInstance().getSaldoAgencia());
	
	
	
	
	
	
	
	
	}
}
