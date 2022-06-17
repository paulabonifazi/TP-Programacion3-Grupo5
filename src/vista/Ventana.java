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

public class Ventana extends JFrame
{

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

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
					Ventana frame = new Ventana();
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
	public Ventana()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panelColumna_1 = new JPanel();
		panelColumna_1.setBackground(new Color(30, 144, 255));
		panel.add(panelColumna_1);
		panelColumna_1.setPreferredSize(new Dimension(180, 720));
		JPanel panelColumna_2 = new JPanel();
		panelColumna_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelColumna_2.setBackground(new Color(30, 144, 255));
		panel.add(panelColumna_2);
		panelColumna_2.setLayout(new GridLayout(8, 0, 0, 0));
		panelColumna_2.setPreferredSize(new Dimension(360, 720));
		JLabel cartelBienvenido = new JLabel("Bienvenido");
		cartelBienvenido.setFont(new Font("Dialog", Font.BOLD, 18));
		cartelBienvenido.setForeground(new Color(255, 255, 255));
		cartelBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		panelColumna_2.add(cartelBienvenido);
		
		JLabel titulo = new JLabel("Sistema de Gesti\u00F3n de B\u00FAsquedas Laborales");
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
		
		textFieldUsuario = new JTextField();
		panel_1.add(textFieldUsuario);
		textFieldUsuario.setToolTipText("Usuario");
		textFieldUsuario.setColumns(20);
		
		JPanel panel_Contrasena = new JPanel();
		panelColumna_2.add(panel_Contrasena);
		panel_Contrasena.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel contraseñaLabel = new JLabel("Contrase\u00F1a");
		contraseñaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Contrasena.add(contraseñaLabel);
		
		JPanel panel_2 = new JPanel();
		panel_Contrasena.add(panel_2);
		
		passwordField = new JPasswordField();
		panel_2.add(passwordField);
		passwordField.setColumns(20);
		passwordField.setToolTipText("Contrase\u00F1a");
		
		JPanel panel_Boton = new JPanel();
		panelColumna_2.add(panel_Boton);
		
		JButton loginButton = new JButton("Entrar");
		loginButton.setToolTipText("Entrar");
		panel_Boton.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
			}
		});
		
		JLabel contrasenaOlvidada = new JLabel("\u00BFOlvidaste la contrase\u00F1a?");
		contrasenaOlvidada.setHorizontalAlignment(SwingConstants.CENTER);
		panelColumna_2.add(contrasenaOlvidada);
		
		JLabel nuevoUsuario = new JLabel("\u00BFNuevo usuario? \u00A1Registrate!");
		nuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelColumna_2.add(nuevoUsuario);
		
		JPanel panelColumna_3 = new JPanel();
		panelColumna_3.setBackground(new Color(30, 144, 255));
		panel.add(panelColumna_3);
		panelColumna_3.setPreferredSize(new Dimension(180, 720));
	}

}
