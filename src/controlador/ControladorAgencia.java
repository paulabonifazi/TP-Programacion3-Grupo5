package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import paquete.Agencia;
import vista.IVistaAgencia;

public class ControladorAgencia implements ActionListener, Observer
{
	private Agencia agencia = Agencia.getInstance();
	private IVistaAgencia vista;
	
	public Agencia getAgencia()
	{
		return agencia;
	}

	public void setAgencia(Agencia agencia)
	{
		this.agencia = agencia;
	}

	public IVistaAgencia getVista()
	{
		return vista;
	}

	public void setVista(IVistaAgencia vista)
	{
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equalsIgnoreCase("Ingresar tipos de trabajo"))
		{
			//this.vista.
		} else if (e.getActionCommand().equalsIgnoreCase("Empleadores"))
		{
			Agencia.getInstance().mostrarEmpleadores(Agencia.getInstance().getEmpleadores());
		} else if (e.getActionCommand().equalsIgnoreCase("Solicitud empleadores"))
		{
			Agencia.getInstance().mostrarEmpleadores(Agencia.getInstance().getEmpleadoresActivos());
		} else if (e.getActionCommand().equalsIgnoreCase("Empleados"))
		{
			Agencia.getInstance().mostrarEmpleadosPretensos(Agencia.getInstance().getEmpleadosPretensos());
		} else if (e.getActionCommand().equalsIgnoreCase("Solicitud empleados"))
		{
			Agencia.getInstance().mostrarEmpleadosPretensos(Agencia.getInstance().getEmpleadosPretensosActivos());
		}
	}

	@Override
	public void update(Observable o, Object arg)
	{
		// TODO Auto-generated method stub
		
	}

}
