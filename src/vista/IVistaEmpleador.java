package vista;

import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

public interface IVistaEmpleador
{
	public void setActionListener(ActionListener actionListener);

	public JTabbedPane getTabbedPane();
}
