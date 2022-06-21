package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import paquete.Empleador;

import javax.swing.JList;

public class VentanaEmpleadoPretenso extends JFrame implements IVistaEmpleadoPretenso, KeyListener
{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private ActionListener actionListener;
	private JButton loginButton;
	private JButton registroButton;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					VentanaEmpleadoPretenso frame = new VentanaEmpleadoPretenso();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaEmpleadoPretenso()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(30, 144, 255));
		tabbedPane.setBorder(new TitledBorder(null, "Empleado Pretenso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_Login = new JPanel();
		tabbedPane.addTab("Login", null, panel_Login, "Login");
		panel_Login.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panelColumna_1 = new JPanel();
		panelColumna_1.setPreferredSize(new Dimension(180, 720));
		panelColumna_1.setBackground(new Color(30, 144, 255));
		panel_Login.add(panelColumna_1);
		
		JPanel panelColumna_2 = new JPanel();
		panelColumna_2.setPreferredSize(new Dimension(360, 720));
		panelColumna_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelColumna_2.setBackground(new Color(30, 144, 255));
		panel_Login.add(panelColumna_2);
		panelColumna_2.setLayout(new GridLayout(8, 0, 0, 0));
		
		JLabel cartelBienvenido = new JLabel("Bienvenido");
		cartelBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		cartelBienvenido.setForeground(Color.WHITE);
		cartelBienvenido.setFont(new Font("Dialog", Font.BOLD, 18));
		panelColumna_2.add(cartelBienvenido);
		
		JLabel titulo = new JLabel("Sistema de Gestión de Búsquedas Laborales");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelColumna_2.add(titulo);
		
		JPanel panel_Usuario = new JPanel();
		panelColumna_2.add(panel_Usuario);
		panel_Usuario.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel usuarioLabel = new JLabel("Usuario");
		usuarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Usuario.add(usuarioLabel);
		
		JPanel panel_1 = new JPanel();
		panel_Usuario.add(panel_1);
		
		textField = new JTextField();
		textField.setToolTipText("Usuario");
		textField.setColumns(20);
		this.textField.addKeyListener(this);
		panel_1.add(textField);
		
		JPanel panel_Contrasena = new JPanel();
		panelColumna_2.add(panel_Contrasena);
		panel_Contrasena.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel contrasenaLabel = new JLabel("Contraseña");
		contrasenaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Contrasena.add(contrasenaLabel);
		
		JPanel panel_2 = new JPanel();
		panel_Contrasena.add(panel_2);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Contraseña");
		passwordField.setColumns(20);
		this.passwordField.addKeyListener(this);
		panel_2.add(passwordField);
		
		JPanel panel_Boton = new JPanel();
		panelColumna_2.add(panel_Boton);
		
		this.loginButton = new JButton("Entrar");
		loginButton.setToolTipText("Entrar");
		panel_Boton.add(loginButton);
		this.loginButton.setEnabled(false);
		
		JLabel contrasenaOlvidada = new JLabel("¿Olvidaste la contraseña?");
		contrasenaOlvidada.setHorizontalAlignment(SwingConstants.CENTER);
		panelColumna_2.add(contrasenaOlvidada);
		
		JLabel nuevoUsuario = new JLabel("¿Nuevo usuario? ¡Registrate!");
		nuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelColumna_2.add(nuevoUsuario);
		
		JPanel panelColumna_3 = new JPanel();
		panelColumna_3.setPreferredSize(new Dimension(180, 720));
		panelColumna_3.setBackground(new Color(30, 144, 255));
		panel_Login.add(panelColumna_3);
		
		JPanel panel_Registro = new JPanel();
		tabbedPane.addTab("Registro", null, panel_Registro, "Registro");
		panel_Registro.setLayout(new BorderLayout(0, 0));
		
		JPanel panelColumna_1_1 = new JPanel();
		panelColumna_1_1.setPreferredSize(new Dimension(100, 10));
		panelColumna_1_1.setBackground(new Color(30, 144, 255));
		panel_Registro.add(panelColumna_1_1, BorderLayout.WEST);
		
		JPanel panelColumna_2_1 = new JPanel();
		panelColumna_2_1.setPreferredSize(new Dimension(360, 720));
		panelColumna_2_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_Registro.add(panelColumna_2_1, BorderLayout.CENTER);
		panelColumna_2_1.setLayout(new GridLayout(10, 0, 0, 0));
		
		JPanel panel_NombreNuevo = new JPanel();
		panelColumna_2_1.add(panel_NombreNuevo);
		panel_NombreNuevo.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_NombreNuevo.add(nombreLabel);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_NombreNuevo.add(panel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Usuario");
		textField_2.setColumns(20);
		this.textField_2.addKeyListener(this);
		panel_1_1_1.add(textField_2);
		
		JPanel panel_ApellidoNuevo = new JPanel();
		panelColumna_2_1.add(panel_ApellidoNuevo);
		panel_ApellidoNuevo.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel apellidoLabel = new JLabel("Apellido:");
		apellidoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ApellidoNuevo.add(apellidoLabel);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_ApellidoNuevo.add(panel_2_1_1);
		
		textField_3 = new JTextField();
		panel_2_1_1.add(textField_3);
		textField_3.setColumns(20);
		this.textField_3.addKeyListener(this);
		
		JPanel panel_NombreNuevo_1 = new JPanel();
		panelColumna_2_1.add(panel_NombreNuevo_1);
		panel_NombreNuevo_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel nombreLabel_1 = new JLabel("Edad:");
		nombreLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_NombreNuevo_1.add(nombreLabel_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_NombreNuevo_1.add(panel_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Edad");
		textField_4.setColumns(20);
		this.textField_4.addKeyListener(this);
		panel_1_1_1_1.add(textField_4);
		
		JPanel panel_ApellidoNuevo_1 = new JPanel();
		panelColumna_2_1.add(panel_ApellidoNuevo_1);
		panel_ApellidoNuevo_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel apellidoLabel_1 = new JLabel("Dirección:");
		apellidoLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ApellidoNuevo_1.add(apellidoLabel_1);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_ApellidoNuevo_1.add(panel_2_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(20);
		panel_2_1_1_1.add(textField_5);
		this.textField_5.addKeyListener(this);
		
		JPanel panel_UsuarioNuevo_1 = new JPanel();
		panelColumna_2_1.add(panel_UsuarioNuevo_1);
		panel_UsuarioNuevo_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel usuarioLabel_1_1 = new JLabel("Teléfono:");
		usuarioLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_UsuarioNuevo_1.add(usuarioLabel_1_1);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_UsuarioNuevo_1.add(panel_1_1_2);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("Teléfono");
		textField_6.setColumns(20);
		this.textField_6.addKeyListener(this);
		panel_1_1_2.add(textField_6);
		
		JPanel panel_ContrasenaNuevo_1 = new JPanel();
		panelColumna_2_1.add(panel_ContrasenaNuevo_1);
		panel_ContrasenaNuevo_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel contrasenaLabel_1_1 = new JLabel("e-Mail:");
		contrasenaLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ContrasenaNuevo_1.add(contrasenaLabel_1_1);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_ContrasenaNuevo_1.add(panel_2_1_2);
		
		textField_7 = new JTextField();
		panel_2_1_2.add(textField_7);
		textField_7.setColumns(20);
		this.textField_7.addKeyListener(this);
		
		JPanel panel_UsuarioNuevo = new JPanel();
		panelColumna_2_1.add(panel_UsuarioNuevo);
		panel_UsuarioNuevo.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel usuarioLabel_1 = new JLabel("Nombre de Usuario:");
		usuarioLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_UsuarioNuevo.add(usuarioLabel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_UsuarioNuevo.add(panel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Usuario");
		textField_1.setColumns(20);
		this.textField_1.addKeyListener(this);
		panel_1_1.add(textField_1);
		
		JPanel panel_ContrasenaNuevo = new JPanel();
		panelColumna_2_1.add(panel_ContrasenaNuevo);
		panel_ContrasenaNuevo.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel contrasenaLabel_1 = new JLabel("Contraseña:");
		contrasenaLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ContrasenaNuevo.add(contrasenaLabel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_ContrasenaNuevo.add(panel_2_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setToolTipText("Contraseña");
		passwordField_1.setColumns(20);
		this.passwordField_1.addKeyListener(this);
		panel_2_1.add(passwordField_1);
		
		JLabel textoEnBlanco = new JLabel("");
		textoEnBlanco.setHorizontalAlignment(SwingConstants.CENTER);
		panelColumna_2_1.add(textoEnBlanco);
		
		JPanel panel_Boton_1 = new JPanel();
		panelColumna_2_1.add(panel_Boton_1);
		
		this.registroButton = new JButton("Registrarse");
		registroButton.setToolTipText("Registrarse");
		panel_Boton_1.add(registroButton);
		this.registroButton.setEnabled(false);
		
		JPanel panelColumna_3_1 = new JPanel();
		panelColumna_3_1.setPreferredSize(new Dimension(100, 10));
		panelColumna_3_1.setBackground(new Color(30, 144, 255));
		panel_Registro.add(panelColumna_3_1, BorderLayout.EAST);
		
		JPanel panel_Ticket = new JPanel();
		panel_Ticket.setVisible(false);
		panel_Ticket.setToolTipText("Ticket");
		tabbedPane.addTab("Ticket", null, panel_Ticket, "Ticket");
		tabbedPane.setEnabledAt(2, false);
		
		JPanel panel_ListaEmpleadores = new JPanel();
		panel_ListaEmpleadores.setVisible(false);
		panel_ListaEmpleadores.setToolTipText("Lista de Empleadores");
		tabbedPane.addTab("Lista de Empleadores", null, panel_ListaEmpleadores, "Lista de Empleadores");
		tabbedPane.setEnabledAt(3, false);
		
		JList<Empleador> list = new JList<Empleador>();
		panel_ListaEmpleadores.add(list);
		
		JPanel panel_RondaEleccion = new JPanel();
		panel_RondaEleccion.setToolTipText("Ronda de Elección");
		tabbedPane.addTab("Ronda de Elección", null, panel_RondaEleccion, "Ronda de Elección");
		tabbedPane.setEnabledAt(4, false);
		
		JPanel panel_Resultado = new JPanel();
		panel_Resultado.setVisible(false);
		panel_Resultado.setToolTipText("Resultado");
		tabbedPane.addTab("Resultado", null, panel_Resultado, "Resultado");
		tabbedPane.setEnabledAt(5, false);
		
		JPanel panel_Publicidad = new JPanel();
		contentPane.add(panel_Publicidad, BorderLayout.SOUTH);
	}

	@Override
	public void setActionListener(ActionListener actionListener)
	{
		this.loginButton.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	@Override
	public void keyTyped(KeyEvent e){}

	@Override
	public void keyPressed(KeyEvent e){}

	@Override
	public void keyReleased(KeyEvent e)
	{
		String usuario = this.textField.getText();
		String contrasena = this.passwordField.getText();
		String nombre = this.textField_2.getText();
		String apellido = this.textField_3.getText();
		String edad = this.textField_4.getText();
		String direccion = this.textField_5.getText();
		String telefono = this.textField_6.getText();
		String email = this.textField_7.getText();
		String nuevoUsuario = this.textField_1.getText();
		String nuevaContrasena = this.passwordField_1.getText();
		this.loginButton.setEnabled(!(usuario.isBlank() || contrasena.isBlank()));
		this.registroButton.setEnabled(!(nombre.isBlank() || apellido.isBlank() || edad.isBlank() || direccion.isBlank() || telefono.isBlank() || email.isBlank() || nuevoUsuario.isBlank() || nuevaContrasena.isBlank()));
	}

	public JTabbedPane getTabbedPane()
	{
		return tabbedPane;
	}

}
