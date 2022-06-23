package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import modelo.EstadoTicket;
import modelo.FormularioBusqueda;
import modelo.TicketEmpleadoPretenso;
import paquete.Agencia;
import paquete.Domicilio;
import paquete.EmpleadoPretenso;
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

	/*private void login()
	{
		Persona persona = null;
		if (persona != null)
		{
			
		} else
			JOptionPane.showMessageDialog(null, "Nombre de usuario/Contraseña incorrecta");

	}*/

	@Override
	public void update(Observable o, Object arg)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getActionCommand().equalsIgnoreCase("Registrarse"))
		{
			EmpleadoPretenso empleado = new EmpleadoPretenso(new Domicilio(this.vista.getTextField_5().getText(), 0, null) , this.vista.getTextField_6().getText(), this.vista.getTextField_7().getText(), this.vista.getTextField_1().getText(), this.vista.getPasswordField_1().getText(), this.vista.getTextField_2().getText(), this.vista.getTextField_3().getText(), Integer.parseInt(this.vista.getTextField_4().getText()), null);
			Agencia.getInstance().agregarEmpleadoPretenso(empleado);
		}
		else if (e.getActionCommand().equalsIgnoreCase("Crear ticket")) {
			String usuario;
			if (!this.vista.getTextField().getText().isBlank())
				usuario = this.vista.getTextField().getText();
			else
				usuario = this.vista.getTextField_1().getText();
			int i = 0;
			while (i < Agencia.getInstance().getEmpleadosPretensos().size() && !Agencia.getInstance().getEmpleadosPretensos().get(i).getNombUsuario().equals(usuario))
				i++;
			Agencia.getInstance().getEmpleadosPretensos().get(i).setTicket(new TicketEmpleadoPretenso(new FormularioBusqueda(this.vista.getButtonGroup().getSelection().getActionCommand(), this.vista.getButtonGroup_1().getSelection().getActionCommand(), this.vista.getButtonGroup_2().getSelection().getActionCommand(), this.vista.getButtonGroup_3().getSelection().getActionCommand(), this.vista.getButtonGroup_4().getSelection().getActionCommand(), this.vista.getButtonGroup_5().getSelection().getActionCommand(), this.vista.getButtonGroup_6().getSelection().getActionCommand()), new EstadoTicket("Activo"), new Date(2022, 05, 23)));
		}
	}
}
