package persistencia;

import java.util.ArrayList;

import modelo.Agencia;
import modelo.EmpleadoPretenso;
import modelo.Empleador;

public class Util
{
       
    public static AgenciaDTO agenciaDTOfromAgencia() //renombra los metodos
    {
	
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
    
    
    
    
    
}
