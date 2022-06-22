package vista;

import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public interface IVistaEmpleador
{
	public void setActionListener(ActionListener actionListener);
	public JTextField getTextField_3();
	public JTextField getTextField_4();
	public JTabbedPane getTabbedPane();
	public JLabel getNombreLabel();
	public JLabel getApellidoLabel();
	public JLabel getEdadLabel();
}
