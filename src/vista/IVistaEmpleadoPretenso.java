package vista;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import paquete.Empleador;

public interface IVistaEmpleadoPretenso
{
	public void setActionListener(ActionListener actionListener);

	public JTabbedPane getTabbedPane();
	public JTextField getTextField();
	public JTextField getTextField_1();
	public JTextField getTextField_2();
	public JTextField getTextField_3();
	public JFormattedTextField getTextField_4();
	public JTextField getTextField_5();
	public JTextField getTextField_6();
	public JTextField getTextField_7();
	public JFormattedTextField getTextField_8();
	public JTextField getTextField_9();
	public JPasswordField getPasswordField();
	public JPasswordField getPasswordField_1();
	public ButtonGroup getButtonGroup();
	public ButtonGroup getButtonGroup_1();
	public ButtonGroup getButtonGroup_2();
	public ButtonGroup getButtonGroup_3();
	public ButtonGroup getButtonGroup_4();
	public ButtonGroup getButtonGroup_5();
	public ButtonGroup getButtonGroup_6();
	public JTable getTable();
	public JList<Empleador> getList();
	public void setList(JList<Empleador> list);
	public JList<Empleador> getList_1();
	public void setList_1(JList<Empleador> list_1);
}
