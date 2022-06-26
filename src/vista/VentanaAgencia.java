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
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import controlador.ControladorAgencia;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JToggleButton;
import java.awt.Dimension;

public class VentanaAgencia extends JFrame implements IVistaAgencia, MouseListener
{
	private JPanel contentPane;
	private JPanel panel2;
	private JPanel panel3;
	private JButton btnNewButton2;
	private JList list2;
	private JButton btnNewButton3;
	private JList list3;
	private boolean rondaELActivada = false;
	private boolean rondaContratacionActivada = false;
	private ActionListener actionListener;

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
		
		/*JPanel panel_IngresoDatos = new JPanel();
		panel_IngresoDatos.setBackground(new Color(255, 51, 51));
		panel_IngresoDatos.setToolTipText("Ingreso de datos");
		tabbedPane.addTab("Ingreso de datos", null, panel_IngresoDatos, "Ingreso de datos");
		panel_IngresoDatos.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panel_Columna11 = new JPanel();
		panel_IngresoDatos.add(panel_Columna11);
		panel_Columna11.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_Columna11.add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Ingresar tipos de trabajo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnNewButton.setToolTipText("Ingresar");
		panel.add(btnNewButton);
		
		JList list = new JList();
		panel_Columna11.add(list);
		
		JPanel panel_Columna12 = new JPanel();
		panel_IngresoDatos.add(panel_Columna12);
		
		panel_Columna12.setLayout(new BorderLayout(0, 0));
		panel2 = new JPanel();
		panel_Columna12.add(panel2, BorderLayout.NORTH);
		
		btnNewButton2 = new JButton("Ingresar especificación de rango laboral");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnNewButton2.setToolTipText("Ingresar");
		panel2.add(btnNewButton2);
		
		list2 = new JList();
		panel_Columna12.add(list2);
		
		JPanel panel_Columna13 = new JPanel();
		panel_IngresoDatos.add(panel_Columna13);
		
		panel_Columna13.setLayout(new BorderLayout(0, 0));
		panel3 = new JPanel();
		panel_Columna13.add(panel3, BorderLayout.NORTH);
		
		btnNewButton3 = new JButton("Ingresar especificación de tipos de puestos");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnNewButton3.setToolTipText("Ingresar");
		panel3.add(btnNewButton3);
		
		list3 = new JList();
		panel_Columna13.add(list3);*/
		
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
		
		/*JPanel panel_CalculoComisiones = new JPanel();
		panel_CalculoComisiones.setToolTipText("Cálculo de comisiones");
		tabbedPane.addTab("Cálculo de comisiones", null, panel_CalculoComisiones, "Cálculo de comisiones");
		panel_CalculoComisiones.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_REL = new JPanel();
		panel_REL.setToolTipText("Ronda de Encuentros Laborales");
		tabbedPane.addTab("Ronda de Encuentros Laborales", null, panel_REL, "Ronda de Encuentros Laborales");
		panel_REL.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_REL.add(panel_2, BorderLayout.WEST);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Activar Ronda de Encuentros Laborales");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isRondaELActivada()) {
					tglbtnNewToggleButton.setText("Desactivar Ronda de Encuentros Laborales");
					setRondaELActivada(true);
				} else {
					tglbtnNewToggleButton.setText("Activar Ronda de Encuentros Laborales");
					setRondaELActivada(false);
				}
			}
		});
		panel_2.add(tglbtnNewToggleButton);
		
		JList list_2 = new JList();
		panel_REL.add(list_2, BorderLayout.CENTER);
		
		JPanel panel_RondaContratacion = new JPanel();
		panel_RondaContratacion.setToolTipText("Ronda de Contratación");
		tabbedPane.addTab("Ronda de Contratación", null, panel_RondaContratacion, "Ronda de Contratación");
		panel_RondaContratacion.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_RondaContratacion.add(panel_3, BorderLayout.WEST);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Activar Ronda de Contratación");
		tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isRondaContratacionActivada()) {
					tglbtnNewToggleButton.setText("Desactivar Ronda de Contratación");
					setRondaContratacionActivada(true);
				} else {
					tglbtnNewToggleButton.setText("Activar Ronda de Contratación");
					setRondaContratacionActivada(false);
				}
			}
		});
		panel_3.add(tglbtnNewToggleButton_1);
		
		JList list_3 = new JList();
		panel_RondaContratacion.add(list_3, BorderLayout.CENTER);*/
		
		JPanel panel_Rondas = new JPanel();
		panel_Rondas.setToolTipText("Rondas");
		tabbedPane.addTab("Rondas", null, panel_Rondas, "Ronda de Encuentros Laborales");
		panel_Rondas.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Botones = new JPanel();
		panel_Rondas.add(panel_Botones, BorderLayout.WEST);
		panel_Botones.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_Botones.add(panel_2);
		
		JToggleButton rondaELButton = new JToggleButton("Activar Ronda de Encuentros Laborales");
		panel_2.add(rondaELButton);
		rondaELButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isRondaELActivada()) {
					rondaELButton.setText("Desactivar Ronda de Encuentros Laborales");
					setRondaELActivada(true);
				} else {
					rondaELButton.setText("Activar Ronda de Encuentros Laborales");
					setRondaELActivada(false);
				}
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_Botones.add(panel_3);
		
		JToggleButton rondaContratacionButton = new JToggleButton("Activar Ronda de Contratación");
		panel_3.add(rondaContratacionButton);
		rondaContratacionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isRondaContratacionActivada()) {
					rondaContratacionButton.setText("Desactivar Ronda de Contratación");
					setRondaContratacionActivada(true);
				} else {
					rondaContratacionButton.setText("Activar Ronda de Contratación");
					setRondaContratacionActivada(false);
				}
			}
		});
		
		JPanel panel_Listas = new JPanel();
		panel_Rondas.add(panel_Listas, BorderLayout.CENTER);
		panel_Listas.setLayout(new GridLayout(2, 0, 0, 0));
		
		JList list_RondaEL = new JList();
		panel_Listas.add(list_RondaEL);
		
		JList list_RondaContratacion = new JList();
		panel_Listas.add(list_RondaContratacion);
		
		JPanel panel_Comisiones = new JPanel();
		panel_Comisiones.setPreferredSize(new Dimension(120, 10));
		panel_Comisiones.setBorder(new TitledBorder(null, "Comisiones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Rondas.add(panel_Comisiones, BorderLayout.EAST);
		panel_Comisiones.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_Publicidad = new JPanel();
		contentPane.add(panel_Publicidad, BorderLayout.SOUTH);
	}

	public boolean isRondaELActivada() {
		return rondaELActivada;
	}

	public void setRondaELActivada(boolean rondaELActivada) {
		this.rondaELActivada = rondaELActivada;
	}

	public boolean isRondaContratacionActivada() {
		return rondaContratacionActivada;
	}

	public void setRondaContratacionActivada(boolean rondaContratacionActivada) {
		this.rondaContratacionActivada = rondaContratacionActivada;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActionListener(ActionListener actionListener)
	{
		this.actionListener = actionListener;
	}

}
