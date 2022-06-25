package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
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
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JToggleButton;

public class VentanaAgencia extends JFrame
{

	private JPanel contentPane;
	private JPanel panel2;
	private JPanel panel3;
	private JLabel lblNewLabel2;
	private JButton btnNewButton2;
	private JList list2;
	private JLabel lblNewLabel3;
	private JButton btnNewButton3;
	private JList list3;

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
					VentanaAgencia frame = new VentanaAgencia();
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
	public VentanaAgencia()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBackground(new Color(255, 51, 51));
		tabbedPane.setBorder(new TitledBorder(null, "Agencia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_IngresoDatos = new JPanel();
		panel_IngresoDatos.setBackground(new Color(255, 51, 51));
		panel_IngresoDatos.setToolTipText("Ingreso de datos");
		tabbedPane.addTab("Ingreso de datos", null, panel_IngresoDatos, "Ingreso de datos");
		panel_IngresoDatos.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panel_Columna11 = new JPanel();
		panel_IngresoDatos.add(panel_Columna11);
		panel_Columna11.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_Columna11.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Tipos de trabajo:");
		lblNewLabel.setToolTipText("Tipos de trabajo");
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ingresar tipos de trabajo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setToolTipText("Ingresar");
		panel.add(btnNewButton);
		
		JList list = new JList();
		panel_Columna11.add(list);
		
		JPanel panel_Columna12 = new JPanel();
		panel_IngresoDatos.add(panel_Columna12);
		
		panel_Columna12.setLayout(new BorderLayout(0, 0));
		panel2 = new JPanel();
		panel_Columna12.add(panel2, BorderLayout.NORTH);
		panel2.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel2 = new JLabel("Especificación de rango laboral:");
		lblNewLabel2.setToolTipText("Especificación de rango laboral");
		panel2.add(lblNewLabel2);
		
		btnNewButton2 = new JButton("Ingresar");
		btnNewButton2.setToolTipText("Ingresar");
		panel2.add(btnNewButton2);
		
		list2 = new JList();
		panel_Columna12.add(list2);
		
		JPanel panel_Columna13 = new JPanel();
		panel_IngresoDatos.add(panel_Columna13);
		
		panel_Columna13.setLayout(new BorderLayout(0, 0));
		panel3 = new JPanel();
		panel_Columna13.add(panel3, BorderLayout.NORTH);
		panel3.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel3 = new JLabel("Especificación de tipos de puestos:");
		lblNewLabel3.setToolTipText("Especificación de tipos de puestos");
		panel3.add(lblNewLabel3);
		
		btnNewButton3 = new JButton("Ingresar");
		btnNewButton3.setToolTipText("Ingresar");
		panel3.add(btnNewButton3);
		
		list3 = new JList();
		panel_Columna13.add(list3);
		
		JPanel panel_VisualizacionDatos = new JPanel();
		panel_VisualizacionDatos.setToolTipText("Visualización de datos");
		tabbedPane.addTab("Visualización de datos", null, panel_VisualizacionDatos, "Visualización de datos");
		panel_VisualizacionDatos.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_VisualizacionDatos.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(4, 0, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Empleadores");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setToolTipText("Empleadores");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Solicitud empleadores");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setToolTipText("Solicitud empleadores");
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Empleados");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setToolTipText("Empleados");
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Solicitud empleados");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setToolTipText("Solicitud empleados");
		panel_1.add(btnNewButton_4);
		
		JList list_1 = new JList();
		panel_VisualizacionDatos.add(list_1, BorderLayout.CENTER);
		
		JPanel panel_CalculoComisiones = new JPanel();
		panel_CalculoComisiones.setToolTipText("Cálculo de comisiones");
		tabbedPane.addTab("Cálculo de comisiones", null, panel_CalculoComisiones, "Cálculo de comisiones");
		panel_CalculoComisiones.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_REL = new JPanel();
		panel_REL.setToolTipText("Ronda de Encuentros Laborales");
		tabbedPane.addTab("Ronda de Encuentros Laborales", null, panel_REL, "Ronda de Encuentros Laborales");
		panel_REL.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_REL.add(panel_2, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("Activar ronda");
		panel_2.add(lblNewLabel_1);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Activar");
		panel_2.add(tglbtnNewToggleButton);
		
		JList list_2 = new JList();
		panel_REL.add(list_2, BorderLayout.CENTER);
		
		JPanel panel_RondaContratacion = new JPanel();
		panel_RondaContratacion.setToolTipText("Ronda de Contratación");
		tabbedPane.addTab("Ronda de Contratación", null, panel_RondaContratacion, "Ronda de Contratación");
		panel_RondaContratacion.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_RondaContratacion.add(panel_3, BorderLayout.WEST);
		
		JLabel lblNewLabel_1_1 = new JLabel("Activar ronda");
		panel_3.add(lblNewLabel_1_1);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Activar");
		panel_3.add(tglbtnNewToggleButton_1);
		
		JList list_3 = new JList();
		panel_RondaContratacion.add(list_3, BorderLayout.CENTER);
		
		JPanel panel_Publicidad = new JPanel();
		contentPane.add(panel_Publicidad, BorderLayout.SOUTH);
	}

}
