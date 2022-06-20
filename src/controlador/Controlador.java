package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import paquete.Agencia;
import paquete.Persona;

public class Controlador implements ActionListener
{
	private static Controlador instance = null;
	private Agencia agencia = new Agencia();
	//private IVista vista;

	public static Controlador getInstance()
	{
		if (Controlador.instance == null)
			Controlador.instance = new Controlador();
		return instance;
	}

	private Controlador()
	{
	
	}

	public Agencia getAgencia()
	{
		return agencia;
	}

	public void setAgencia(Agencia agencia)
	{
		this.agencia = agencia;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equalsIgnoreCase("Entrar"))
		{
			this.login();

		}
	}
	private void login()
	{
		Persona persona = null;
		if (persona != null)
		{
		} else
			JOptionPane.showMessageDialog(null, "Nombre de usuario/Contraseña incorrecta");

	}
}
