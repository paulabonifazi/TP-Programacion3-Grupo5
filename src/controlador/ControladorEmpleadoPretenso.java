package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import paquete.Agencia;
import paquete.Persona;
import vista.IVistaEmpleadoPretenso;
import vista.VentanaEmpleadoPretenso;

public class ControladorEmpleadoPretenso implements ActionListener, Observer
{
	//private static ControladorEmpleadoPretenso instance = null;
	private Agencia agencia = Agencia.getInstance();
	private IVistaEmpleadoPretenso vista;

	/*public static ControladorEmpleadoPretenso getInstance()
	{
		if (ControladorEmpleadoPretenso.instance == null)
			ControladorEmpleadoPretenso.instance = new ControladorEmpleadoPretenso();
		return instance;
	}*/

	public ControladorEmpleadoPretenso()
	{
		this.vista = new VentanaEmpleadoPretenso();
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

	public IVistaEmpleadoPretenso getVista()
	{
		return vista;
	}

	public void setVista(IVistaEmpleadoPretenso vista)
	{
		this.vista = vista;
		this.vista.setActionListener(this);
	}

	private void login()
	{
		Persona persona = null;
		if (persona != null)
		{
			
		} else
			JOptionPane.showMessageDialog(null, "Nombre de usuario/Contraseña incorrecta");

	}

	@Override
	public void update(Observable o, Object arg)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
