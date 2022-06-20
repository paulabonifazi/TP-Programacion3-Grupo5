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
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JList;

public class VentanaEmpleador extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_1;
	private JPasswordField passwordField_1;

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
					VentanaEmpleador frame = new VentanaEmpleador();
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
	public VentanaEmpleador()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(30, 144, 255));
		tabbedPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Empleador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_Login = new JPanel();
		tabbedPane.addTab("Login", null, panel_Login, null);
		panel_Login.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panelColumna_1 = new JPanel();
		panelColumna_1.setPreferredSize(new Dimension(180, 720));
		panelColumna_1.setBackground(new Color(0, 128, 0));
		panel_Login.add(panelColumna_1);
		
		JPanel panelColumna_2 = new JPanel();
		panelColumna_2.setPreferredSize(new Dimension(360, 720));
		panelColumna_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelColumna_2.setBackground(new Color(0, 128, 0));
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
		panel_2.add(passwordField);
		
		JPanel panel_Boton = new JPanel();
		panelColumna_2.add(panel_Boton);
		
		JButton loginButton = new JButton("Entrar");
		loginButton.setToolTipText("Entrar");
		panel_Boton.add(loginButton);
		
		JLabel contrasenaOlvidada = new JLabel("¿Olvidaste la contraseña?");
		contrasenaOlvidada.setHorizontalAlignment(SwingConstants.CENTER);
		panelColumna_2.add(contrasenaOlvidada);
		
		JLabel nuevoUsuario = new JLabel("¿Nuevo usuario? ¡Registrate!");
		nuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelColumna_2.add(nuevoUsuario);
		
		JPanel panelColumna_3 = new JPanel();
		panelColumna_3.setPreferredSize(new Dimension(180, 720));
		panelColumna_3.setBackground(new Color(0, 128, 0));
		panel_Login.add(panelColumna_3);
		
		JPanel panel_Registro = new JPanel();
		tabbedPane.addTab("Registro", null, panel_Registro, null);
		panel_Registro.setLayout(new BorderLayout(0, 0));
		JPanel panelColumna_1_1 = new JPanel();
		panelColumna_1_1.setPreferredSize(new Dimension(100, 10));
		panelColumna_1_1.setBackground(new Color(0, 128, 0));
		panel_Registro.add(panelColumna_1_1, BorderLayout.WEST);
		
		JPanel panelColumna_2_1 = new JPanel();
		panelColumna_2_1.setPreferredSize(new Dimension(360, 720));
		panelColumna_2_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_Registro.add(panelColumna_2_1);
		panelColumna_2_1.setLayout(new GridLayout(10, 0, 0, 0));
		
		JPanel panel_Persona = new JPanel();
		panelColumna_2_1.add(panel_Persona);
		panel_Persona.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel soyPersona = new JLabel("Soy persona:");
		panel_Persona.add(soyPersona);
		soyPersona.setHorizontalAlignment(SwingConstants.CENTER);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Física");
		panel_Persona.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Jurídica");
		panel_Persona.add(rdbtnNewRadioButton_1);
		
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
		
		JPanel panel_NombreNuevo_1 = new JPanel();
		panelColumna_2_1.add(panel_NombreNuevo_1);
		panel_NombreNuevo_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel nombreLabel_1 = new JLabel("Edad:");
		nombreLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_NombreNuevo_1.add(nombreLabel_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_NombreNuevo_1.add(panel_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Usuario");
		textField_4.setColumns(20);
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
		
		JPanel panel_UsuarioNuevo_1 = new JPanel();
		panelColumna_2_1.add(panel_UsuarioNuevo_1);
		panel_UsuarioNuevo_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel usuarioLabel_1_1 = new JLabel("Teléfono:");
		usuarioLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_UsuarioNuevo_1.add(usuarioLabel_1_1);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_UsuarioNuevo_1.add(panel_1_1_2);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("Usuario");
		textField_6.setColumns(20);
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
		panel_2_1.add(passwordField_1);
		
		JPanel panel_Boton_1 = new JPanel();
		panelColumna_2_1.add(panel_Boton_1);
		
		JButton loginButton_1 = new JButton("Registrarse");
		loginButton_1.setToolTipText("Registrarse");
		panel_Boton_1.add(loginButton_1);
		
		JPanel panelColumna_3_1 = new JPanel();
		panelColumna_3_1.setPreferredSize(new Dimension(100, 10));
		panelColumna_3_1.setBackground(new Color(0, 128, 0));
		panel_Registro.add(panelColumna_3_1, BorderLayout.EAST);
		
		
		JPanel panel_Ticket = new JPanel();
		panel_Ticket.setToolTipText("Ticket");
		tabbedPane.addTab("Ticket", null, panel_Ticket, null);
		
		JPanel panel_ListaEmpleados = new JPanel();
		panel_ListaEmpleados.setToolTipText("Lista de Empleados Pretensos");
		tabbedPane.addTab("Lista de Empleados Pretensos", null, panel_ListaEmpleados, null);
		
		JList list = new JList();
		panel_ListaEmpleados.add(list);
		
		JPanel panel_RondaEleccion = new JPanel();
		panel_RondaEleccion.setToolTipText("Ronda de Elección");
		tabbedPane.addTab("Ronda de Elección", null, panel_RondaEleccion, null);
		
		JPanel panel_Resultado = new JPanel();
		panel_Resultado.setToolTipText("Resultado");
		tabbedPane.addTab("Resultado", null, panel_Resultado, null);
		
		JPanel panel_Publicidad = new JPanel();
		contentPane.add(panel_Publicidad, BorderLayout.SOUTH);
	}

}
