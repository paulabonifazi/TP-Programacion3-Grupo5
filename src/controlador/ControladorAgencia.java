package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import paquete.Agencia;
import vista.IVistaAgencia;
import vista.VentanaAgencia;

public class ControladorAgencia implements ActionListener
{
	private Agencia agencia = Agencia.getInstance();
	private IVistaAgencia vista;
	
	public ControladorAgencia()
	{
		super();
		this.vista = new VentanaAgencia();
		this.vista.setActionListener(this);
	}

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
		if (e.getActionCommand().equalsIgnoreCase("Empleadores"))
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
		}else if (e.getActionCommand().equalsIgnoreCase("Activar Ronda de Encuentros Laborales"))
		{
			Agencia.getInstance().activarRondaEncuentrosLaborales();
		} else if (e.getActionCommand().equalsIgnoreCase("Activar Ronda de Contratación"))
		{
			Agencia.getInstance().activarRondaEleccion();
		}
	}
}
