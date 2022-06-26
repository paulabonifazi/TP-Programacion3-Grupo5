package util;

import java.util.ArrayList;
import java.util.Random;

import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import paquete.Agencia;
import paquete.EmpleadoPretenso;
import paquete.Empleador;
import persistencia.AgenciaDTO;

public class Util
{
	public static final Random r = new Random();

    public static void espera()
    {
    	try
    	{
    		Thread.sleep(r.nextInt(300));
    	} catch (InterruptedException e)
    	{
 
    		e.printStackTrace();
    	}
    }
       
    public static AgenciaDTO agenciaDTOfromAgencia()        {
            
            AgenciaDTO agDTO = new AgenciaDTO();
            ArrayList<Empleador> empleadores = Agencia.getInstance().getEmpleadores();
            ArrayList<EmpleadoPretenso> empleadosPretensos = Agencia.getInstance().getEmpleadosPretensos();
            
            agDTO.setEmpleadores(Agencia.getInstance().getEmpleadores());
            agDTO.setEmpleadosPretensos(Agencia.getInstance().getEmpleadosPretensos());

            return agDTO;
        }
        
        public static void agenciaFromAgenciaDTO(AgenciaDTO agenciaDTO) 
        {
        Agencia.getInstance().setEmpleadores(agenciaDTO.getEmpleadores());
        Agencia.getInstance().setEmpleadosPretensos(agenciaDTO.getEmpleadosPretensos());            
        }
        
        
        public static void agenciaListaFromAgenciaDTO(AgenciaDTO agenciaDTO) 
        {
        Agencia.getInstance().setListaCoincidencias(agenciaDTO.getListaCoincidencias());
        Agencia.getInstance().setListAsignacionEmpleadoPretensos(agenciaDTO.getListAsignacionEmpleadoPretensos()); 
        Agencia.getInstance().setListAsignacionEmpleador(agenciaDTO.getListAsignacionEmpleador());   
        Agencia.getInstance().setListEleccionEmpleadoPretensos(agenciaDTO.getListEleccionEmpleadoPretensos()); 
        Agencia.getInstance().setListEleccionEmpleador(agenciaDTO.getListEleccionEmpleador());   
        }
        
        public static AgenciaDTO agenciaListaDTOfromAgencia() {
            
            AgenciaDTO agDTO = new AgenciaDTO();
            ArrayList<ListAsignacionEmpleador> listaCoincidencias = Agencia.getInstance().getListaCoincidencias();
            ArrayList<ListAsignacionEmpleadPretenso> listaAsigEmpleadPretenso = Agencia.getInstance().getListAsignacionEmpleadoPretensos();
            ArrayList<ListAsignacionEmpleador> listaAsignacionEmpleador = Agencia.getInstance().getListAsignacionEmpleador();
            ArrayList<ListAsignacionEmpleadPretenso> listaEleccionEmpleadPretenso = Agencia.getInstance().getListEleccionEmpleadoPretensos();
            ArrayList<ListAsignacionEmpleador> listaEleccionEmpleador = Agencia.getInstance().getListEleccionEmpleador();
            
            agDTO.setListaCoincidencias(Agencia.getInstance().getListaCoincidencias());
            agDTO.setListAsignacionEmpleadoPretensos(Agencia.getInstance().getListAsignacionEmpleadoPretensos());
            agDTO.setListAsignacionEmpleador( Agencia.getInstance().getListAsignacionEmpleador());
            agDTO.setListEleccionEmpleadoPretensos(Agencia.getInstance().getListEleccionEmpleadoPretensos());
            agDTO.setListEleccionEmpleador(Agencia.getInstance().getListEleccionEmpleador());

            return agDTO;
        }
    
    
    
}
