package Formulario;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;

import Array.ArrayBebida;
import Clases.claseBebida;
import Clases.claseUsuario;
import libreria.superBebida;

import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Bebida extends JFrame implements  ActionListener, MouseListener, MouseMotionListener, KeyListener {

	private JPanel contentPane;
	private JLabel labelUsuario;
	private JButton btnmini;
	private JButton btnX;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JButton btnAcon;
	private JLabel lb;
	private JLabel label_3;
	private JLabel lblUsuarios;
	private JLabel label_4;
	private DefaultTableModel modelo;
	private JTextField txt1;
	private JTextField txt3;
	private JTextField txt2;
	private JPanel panel;
	private JLabel lbdatos;
	private JPanel panelfondo;
	private JPanel panelImagen;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panelDetalle;
	private JLabel lblNombre;
	private JLabel lblApellidoMaterno;
	private JLabel lblDetalleDeEmpleado;
	private JLabel lblTipo;
	private JLabel lblTurno;
	private JLabel lbImagen;
	private JButton btnImprimir;
	private JButton btnGrabar;
	private JButton btnImagen;
	private JTextField txtN;
	private JComboBox cmbTipo;
	private JTextField txtbutu;
	private JButton btnA�adir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private int s;
	private HashMap<Integer,claseBebida> h=new HashMap<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		try {

			
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bebida frame = new Bebida();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bebida() {
		setUndecorated(true);
		final int ANCHO = 1000,
		          ALTO = 650,
		          DX = 8,
		          DY = 53;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((getToolkit().getScreenSize().width - ANCHO - DX) / 2,
				  (getToolkit().getScreenSize().height - ALTO - DY) / 2,
				   1019, 737);


		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		contentPane.addMouseMotionListener(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/imprimir.png"));
			ImageIcon fondo2=new ImageIcon(getClass().getResource("/img/imprimir2.png"));
		
		panelMenu = new JPanel();
		panelMenu.setVisible(false);
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelMenu.setBackground(Color.BLACK);
		panelMenu.setBounds(2, 84, 382, 536);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Usuario.class.getResource("/img/usuar.png")));
		label_8.setBounds(23, 92, 46, 14);
		panelMenu.add(label_8);
		
		label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(Usuario.class.getResource("/img/genero.png")));
		label_13.setBounds(20, 372, 46, 30);
		panelMenu.add(label_13);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(66, 92, 52, 14);
		panelMenu.add(lblUsuario);
		
		label_6 = new JLabel("x");
		label_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(359, 3, 11, 14);
		panelMenu.add(label_6);
		
		btnxx = new JButton("");
		btnxx.addActionListener(this);
		btnxx.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnxx.setIcon(new ImageIcon(Usuario.class.getResource("/img/negro.png")));
		btnxx.setForeground(Color.WHITE);
		btnxx.setFocusable(false);
		btnxx.setFocusTraversalKeysEnabled(false);
		btnxx.setFocusPainted(false);
		btnxx.setContentAreaFilled(false);
		btnxx.setBorderPainted(false);
		btnxx.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnxx.setBackground(Color.WHITE);
		btnxx.setBounds(345, 0, 37, 28);
		panelMenu.add(btnxx);
		
		label_7 = new JLabel("");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(10, 5, 46, 49);
		panelMenu.add(label_7);
		ImageIcon fondo10=new ImageIcon(getClass().getResource("/img/paginaWeb.png"));
		ImageIcon icon10=new ImageIcon(fondo10.getImage().getScaledInstance(label_7.getWidth(), label_7.getHeight(),Image.SCALE_DEFAULT));
		label_7.setIcon(icon10);
		
		btnUsuario = new JButton("");
		btnUsuario.addActionListener(this);
		btnUsuario.addMouseListener(this);
		btnUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUsuario.setForeground(Color.WHITE);
		btnUsuario.setContentAreaFilled(false);
		btnUsuario.setDefaultCapable(false);
		btnUsuario.setFocusPainted(false);
		btnUsuario.setFocusTraversalKeysEnabled(false);
		btnUsuario.setFocusable(false);
		btnUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuario.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnUsuario.setBounds(-11, 74, 282, 49);
		panelMenu.add(btnUsuario);
		
		
		btnCliente = new JButton("");
		btnCliente.addActionListener(this);
		btnCliente.addMouseListener(this);
		btnCliente.setForeground(Color.WHITE);
		btnCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCliente.setContentAreaFilled(false);
		btnCliente.setDefaultCapable(false);
		btnCliente.setFocusPainted(false);
		btnCliente.setFocusTraversalKeysEnabled(false);
		btnCliente.setFocusable(false);
		btnCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCliente.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnCliente.setBounds(-11, 136, 282, 49);
		panelMenu.add(btnCliente);
		
		btnBebida = new JButton("");
		btnBebida.addActionListener(this);
		btnBebida.addMouseListener(this);
		btnBebida.setForeground(Color.WHITE);
		btnBebida.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBebida.setContentAreaFilled(false);
		btnBebida.setDefaultCapable(false);
		btnBebida.setFocusPainted(false);
		btnBebida.setFocusTraversalKeysEnabled(false);
		btnBebida.setFocusable(false);
		btnBebida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBebida.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnBebida.setBounds(-11, 194, 282, 49);
		panelMenu.add(btnBebida);
		
		btncancion = new JButton("");
		btncancion.addActionListener(this);
		btncancion.addMouseListener(this);
		btncancion.setForeground(Color.WHITE);
		btncancion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btncancion.setContentAreaFilled(false);
		btncancion.setDefaultCapable(false);
		btncancion.setFocusPainted(false);
		btncancion.setFocusTraversalKeysEnabled(false);
		btncancion.setFocusable(false);
		btncancion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btncancion.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btncancion.setBounds(-11, 254, 282, 49);
		panelMenu.add(btncancion);
		
		brnArtista = new JButton("");
		brnArtista.addActionListener(this);
		brnArtista.addMouseListener(this);
		brnArtista.setForeground(Color.WHITE);
		brnArtista.setFont(new Font("Tahoma", Font.BOLD, 13));
		brnArtista.setContentAreaFilled(false);
		brnArtista.setDefaultCapable(false);
		brnArtista.setFocusPainted(false);
		brnArtista.setFocusTraversalKeysEnabled(false);
		brnArtista.setFocusable(false);
		brnArtista.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		brnArtista.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		brnArtista.setBounds(-11, 312, 282, 49);
		panelMenu.add(brnArtista);
		
		btnGenero = new JButton("");
		btnGenero.addActionListener(this);
		btnGenero.addMouseListener(this);
		btnGenero.setForeground(Color.WHITE);
		btnGenero.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGenero.setContentAreaFilled(false);
		btnGenero.setDefaultCapable(false);
		btnGenero.setFocusPainted(false);
		btnGenero.setFocusTraversalKeysEnabled(false);
		btnGenero.setFocusable(false);
		btnGenero.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenero.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnGenero.setBounds(-11, 369, 282, 49);
		panelMenu.add(btnGenero);
		
		btnPedido = new JButton("");
		btnPedido.addActionListener(this);
		btnPedido.addMouseListener(this);
		btnPedido.setForeground(Color.WHITE);
		btnPedido.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPedido.setContentAreaFilled(false); 
		btnPedido.setDefaultCapable(false);
		btnPedido.setFocusPainted(false);
		btnPedido.setFocusTraversalKeysEnabled(false);
		btnPedido.setFocusable(false);
		btnPedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPedido.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnPedido.setBounds(-11, 428, 282, 49);
		panelMenu.add(btnPedido);
		
		btnPiqueo = new JButton("");
		btnPiqueo.addActionListener(this);
		btnPiqueo.addMouseListener(this);
		btnPiqueo.setForeground(Color.WHITE);
		btnPiqueo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPiqueo.setContentAreaFilled(false);
		btnPiqueo.setDefaultCapable(false);
		btnPiqueo.setFocusPainted(false);
		btnPiqueo.setFocusTraversalKeysEnabled(false);
		btnPiqueo.setFocusable(false);
		btnPiqueo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPiqueo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnPiqueo.setBounds(-11, 487, 282, 38);
		panelMenu.add(btnPiqueo);
		
		label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Usuario.class.getResource("/img/clien.png")));
		label_9.setBounds(23, 136, 46, 32);
		panelMenu.add(label_9);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(Color.WHITE);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCliente.setBounds(66, 154, 52, 14);
		panelMenu.add(lblCliente);
		
		label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Usuario.class.getResource("/img/bebida.png")));
		label_10.setBounds(23, 196, 46, 30);
		panelMenu.add(label_10);
		
		lblBebida = new JLabel("Bebida");
		lblBebida.setForeground(Color.WHITE);
		lblBebida.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBebida.setBounds(66, 206, 52, 14);
		panelMenu.add(lblBebida);
		
		label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(Usuario.class.getResource("/img/canc.png")));
		label_11.setBounds(24, 254, 46, 30);
		panelMenu.add(label_11);
		
		lblCancion = new JLabel("Cancion");
		lblCancion.setForeground(Color.WHITE);
		lblCancion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCancion.setBounds(66, 270, 52, 14);
		panelMenu.add(lblCancion);
		
		label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(Usuario.class.getResource("/img/artis.png")));
		label_12.setBounds(20, 314, 46, 30);
		panelMenu.add(label_12);
		
		lblArtista = new JLabel("Artista");
		lblArtista.setForeground(Color.WHITE);
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblArtista.setBounds(66, 330, 52, 14);
		panelMenu.add(lblArtista);
		
		lblGenero = new JLabel("Genero");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGenero.setBounds(66, 382, 52, 14);
		panelMenu.add(lblGenero);
		
		label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(Usuario.class.getResource("/img/modificar.png")));
		label_14.setBounds(20, 432, 46, 30);
		panelMenu.add(label_14);
		
		lblPedido = new JLabel("Pedido");
		lblPedido.setForeground(Color.WHITE);
		lblPedido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPedido.setBounds(66, 448, 52, 14);
		panelMenu.add(lblPedido);
		
		label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(Usuario.class.getResource("/img/piqueo.png")));
		label_15.setBounds(17, 495, 46, 30);
		panelMenu.add(label_15);
		
		lblPiqueo = new JLabel("Piqueo");
		lblPiqueo.setForeground(Color.WHITE);
		lblPiqueo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPiqueo.setBounds(78, 511, 52, 14);
		panelMenu.add(lblPiqueo);
		
		
		label_5 = new JLabel("");
		label_5.setVisible(false);
		label_5.setIcon(new ImageIcon(Usuario.class.getResource("/img/trinegro.png")));
		label_5.setBounds(2, 32, 98, 69);
		contentPane.add(label_5);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setBounds(402, 226, 339, 188);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbdatos = new JLabel("Detalle de Bebida");
		lbdatos.setForeground(SystemColor.windowBorder);
		lbdatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbdatos.setBounds(37, 11, 101, 14);
		panel.add(lbdatos);
		
		lblNombre = new JLabel("Nombre Bebida\r\n");
		lblNombre.setForeground(SystemColor.windowBorder);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 60, 101, 14);
		panel.add(lblNombre);
		
		lblApellidoMaterno = new JLabel("Estado");
		lblApellidoMaterno.setForeground(SystemColor.windowBorder);
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidoMaterno.setBounds(10, 130, 112, 14);
		panel.add(lblApellidoMaterno);
		
		txtN = new JTextField();
		txtN.addKeyListener(this);
		txtN.setForeground(SystemColor.windowBorder);
		txtN.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtN.setBackground(UIManager.getColor("CheckBox.light"));
		txtN.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtN.setBounds(129, 53, 203, 28);
		panel.add(txtN);
		txtN.setColumns(10);
		
		cmbE = new JComboBox();
		cmbE.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbE.setModel(new DefaultComboBoxModel(new String[] {"Habilitado", "Inhabilitado"}));
		cmbE.setFont(new Font("Times New Roman", Font.BOLD, 13));
		cmbE.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		cmbE.setBounds(131, 117, 201, 27);
		panel.add(cmbE);
		
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		txt2.setBackground(new Color(70, 130, 180));
		txt2.setBounds(757, 217, 244, 8);
		contentPane.add(txt2);
		
		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		txt1.setBackground(new Color(70, 130, 180));
		txt1.setBounds(402, 217, 339, 8);
		contentPane.add(txt1);
		
		panelfondo = new JPanel();
		panelfondo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelfondo.setBackground(SystemColor.control);
		panelfondo.setBounds(10, 118, 1002, 574);
		contentPane.add(panelfondo);
		panelfondo.setLayout(null);
		
		panelImagen = new JPanel();
		panelImagen.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelImagen.setBackground(Color.WHITE);
		panelImagen.setBounds(747, 108, 245, 381);
		panelfondo.add(panelImagen);
		panelImagen.setLayout(null);
		
		lbImagen = new JLabel("");
		lbImagen.setBounds(10, 11, 225, 323);
		panelImagen.add(lbImagen);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(Color.WHITE, 3));
		scrollPane.setBounds(0, 0, 378, 489);
		panelfondo.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.addMouseListener(this);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		panelDetalle = new JPanel();
		panelDetalle.setLayout(null);
		panelDetalle.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelDetalle.setBackground(Color.WHITE);
		panelDetalle.setBounds(393, 312, 337, 251);
		panelfondo.add(panelDetalle);
		
		lblDetalleDeEmpleado = new JLabel("Tipo De Bebida");
		lblDetalleDeEmpleado.setForeground(SystemColor.windowBorder);
		lblDetalleDeEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDetalleDeEmpleado.setBounds(45, 11, 135, 14);
		panelDetalle.add(lblDetalleDeEmpleado);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(SystemColor.windowBorder);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipo.setBounds(10, 62, 96, 14);
		panelDetalle.add(lblTipo);
		
		lblTurno = new JLabel("Precio");
		lblTurno.setForeground(SystemColor.windowBorder);
		lblTurno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTurno.setBounds(10, 131, 82, 14);
		panelDetalle.add(lblTurno);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Cerveza ", "Vinos", "Whisky"}));
		cmbTipo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		cmbTipo.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		cmbTipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbTipo.setBounds(96, 56, 179, 27);
		panelDetalle.add(cmbTipo);
		
		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(this);
		txtPrecio.setForeground(SystemColor.windowBorder);
		txtPrecio.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtPrecio.setColumns(10);
		txtPrecio.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtPrecio.setBackground(SystemColor.controlHighlight);
		txtPrecio.setBounds(96, 117, 179, 28);
		panelDetalle.add(txtPrecio);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setForeground(SystemColor.windowBorder);
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMarca.setBounds(10, 188, 82, 14);
		panelDetalle.add(lblMarca);
		
		txtMar = new JTextField();
		txtMar.setForeground(SystemColor.windowBorder);
		txtMar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtMar.setColumns(10);
		txtMar.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtMar.setBackground(SystemColor.controlHighlight);
		txtMar.setBounds(96, 174, 179, 28);
		panelDetalle.add(txtMar);
		
		btnImprimir = new JButton("");
		btnImprimir.addActionListener(this);
		btnImprimir.setRolloverIcon(new ImageIcon(Usuario.class.getResource("/img/imprimir2.png")));
		btnImprimir.setContentAreaFilled(false);
		btnImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImprimir.setBorderPainted(false);
		btnImprimir.setDefaultCapable(false);
		btnImprimir.setFocusTraversalKeysEnabled(false);
		btnImprimir.setFocusPainted(false);
		btnImprimir.setFocusable(false);
		btnImprimir.setIcon(new ImageIcon(Usuario.class.getResource("/img/imprimir.png")));
		btnImprimir.setBounds(393, 11, 198, 62);
		panelfondo.add(btnImprimir);
		
		btnGrabar = new JButton("");
		btnGrabar.addActionListener(this);
		btnGrabar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGrabar.setFocusable(false);
		btnGrabar.setFocusTraversalKeysEnabled(false);
		btnGrabar.setFocusPainted(false);
		btnGrabar.setDefaultCapable(false);
		btnGrabar.setContentAreaFilled(false);
		btnGrabar.setBorderPainted(false);
		btnGrabar.setBounds(601, 16, 199, 52);
		
		ImageIcon fondo5=new ImageIcon(getClass().getResource("/img/consultar2.png"));
		ImageIcon icon5=new ImageIcon(fondo5.getImage().getScaledInstance(btnGrabar.getWidth(),	btnGrabar.getHeight(),Image.SCALE_DEFAULT));
		btnGrabar.setRolloverIcon(icon5);
		ImageIcon fondo4=new ImageIcon(getClass().getResource("/img/consul1.png"));
		ImageIcon icon4=new ImageIcon(fondo4.getImage().getScaledInstance(btnGrabar.getWidth(),	btnGrabar.getHeight(),Image.SCALE_DEFAULT));
		btnGrabar.setIcon(icon4);
		
		panelfondo.add(btnGrabar);
		
		btnImagen = new JButton("");
		btnImagen.addActionListener(this);
		btnImagen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImagen.setRolloverIcon(new ImageIcon(Usuario.class.getResource("/img/imagen2.png")));
		btnImagen.setIcon(new ImageIcon(Usuario.class.getResource("/img/imagen.png")));
		btnImagen.setFocusable(false);
		btnImagen.setFocusTraversalKeysEnabled(false);
		btnImagen.setFocusPainted(false);
		btnImagen.setDefaultCapable(false);
		btnImagen.setContentAreaFilled(false);
		btnImagen.setBorderPainted(false);
		btnImagen.setBounds(810, 15, 182, 52);
		panelfondo.add(btnImagen);
		
		txtbutu = new JTextField();
		txtbutu.setColumns(10);
		txtbutu.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		txtbutu.setBackground(new Color(218, 165, 32));
		txtbutu.setBounds(0, 492, 378, 8);
		panelfondo.add(txtbutu);
		
		btnA�adir = new JButton("A\u00F1adir");
		btnA�adir.addActionListener(this);
		btnA�adir.setIcon(new ImageIcon(Usuario.class.getResource("/img/a\u00F1adir.png")));
		btnA�adir.setFocusPainted(false);
		btnA�adir.setFocusTraversalKeysEnabled(false);
		btnA�adir.setFocusable(false);
		btnA�adir.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnA�adir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnA�adir.setForeground(SystemColor.windowBorder);
		btnA�adir.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnA�adir.setBounds(289, 511, 89, 52);
		panelfondo.add(btnA�adir);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setIcon(new ImageIcon(Usuario.class.getResource("/img/modificar.png")));
		btnModificar.setForeground(SystemColor.windowBorder);
		btnModificar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnModificar.setFocusable(false);
		btnModificar.setFocusTraversalKeysEnabled(false);
		btnModificar.setFocusPainted(false);
		btnModificar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnModificar.setBounds(182, 511, 102, 52);
		panelfondo.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setIcon(new ImageIcon(Usuario.class.getResource("/img/remover.png")));
		btnEliminar.setForeground(SystemColor.windowBorder);
		btnEliminar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnEliminar.setFocusable(false);
		btnEliminar.setFocusTraversalKeysEnabled(false);
		btnEliminar.setFocusPainted(false);
		btnEliminar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnEliminar.setBounds(80, 511, 96, 52);
		panelfondo.add(btnEliminar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevo.setIcon(new ImageIcon(Usuario.class.getResource("/img/nuevo.png")));
		btnNuevo.setForeground(SystemColor.windowBorder);
		btnNuevo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNuevo.setFocusable(false);
		btnNuevo.setFocusTraversalKeysEnabled(false);
		btnNuevo.setFocusPainted(false);
		btnNuevo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnNuevo.setBounds(6, 511, 66, 52);
		panelfondo.add(btnNuevo);
		
		label_4 = new JLabel("\u00C1COMM Karaoke");
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_4.addMouseListener(this);
		label_4.setForeground(new Color(165, 42, 42));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(873, 49, 108, 14);
		contentPane.add(label_4);
		
		lblUsuarios = new JLabel("Bebida");
		lblUsuarios.setForeground(Color.WHITE);
		lblUsuarios.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUsuarios.setBounds(56, 86, 66, 14);
		contentPane.add(lblUsuarios);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Bebida.class.getResource("/img/bebida.png")));
		label_3.setBounds(20, 74, 38, 45);
		contentPane.add(label_3);
		
		lb = new JLabel("");
		lb.setBounds(9, 74, 1002, 45);
		contentPane.add(lb);
		ImageIcon fondo3=new ImageIcon(getClass().getResource("/img/men.png"));
		ImageIcon icon3=new ImageIcon(fondo3.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(),Image.SCALE_DEFAULT));
		lb.setIcon(icon3);
		
		label_2 = new JLabel("\u00C1COMM Karaoke");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(68, 7, 140, 14);
		contentPane.add(label_2);
		
		btnAcon = new JButton("");
		btnAcon.addActionListener(this);
		btnAcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAcon.setRolloverIcon(new ImageIcon(Usuario.class.getResource("/img/princi2.png")));
		btnAcon.setIcon(new ImageIcon(Usuario.class.getResource("/img/logo.png")));
		btnAcon.setFocusable(false);
		btnAcon.setFocusTraversalKeysEnabled(false);
		btnAcon.setFocusPainted(false);
		btnAcon.setContentAreaFilled(false);
		btnAcon.setBorderPainted(false);
		btnAcon.setBounds(10, -4, 48, 56);
		contentPane.add(btnAcon);
		
		label_1 = new JLabel("-");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_1.setBounds(965, 1, 11, 14);
		contentPane.add(label_1);
		
		label = new JLabel("x");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(998, -1, 11, 14);
		contentPane.add(label);
		
		btnmini = new JButton("");
		btnmini.addActionListener(this);
		btnmini.setRolloverIcon(new ImageIcon(Usuario.class.getResource("/img/transs.png")));
		btnmini.setIcon(new ImageIcon(Usuario.class.getResource("/img/btnx.png")));
		btnmini.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnmini.setForeground(Color.WHITE);
		btnmini.setFocusable(false);
		btnmini.setFocusTraversalKeysEnabled(false);
		btnmini.setFocusPainted(false);
		btnmini.setContentAreaFilled(false);
		btnmini.setBorderPainted(false);
		btnmini.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnmini.setBackground(Color.WHITE);
		btnmini.setBounds(952, -4, 37, 28);
		contentPane.add(btnmini);
		
		btnX = new JButton("");
		btnX.addActionListener(this);
		btnX.setRolloverIcon(new ImageIcon(Usuario.class.getResource("/img/transs.png")));
		btnX.setIcon(new ImageIcon(Usuario.class.getResource("/img/btnx.png")));
		btnX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnX.setForeground(Color.WHITE);
		btnX.setFocusable(false);
		btnX.setFocusTraversalKeysEnabled(false);
		btnX.setFocusPainted(false);
		btnX.setContentAreaFilled(false);
		btnX.setBorderPainted(false);
		btnX.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnX.setBackground(Color.WHITE);
		btnX.setBounds(984, -4, 37, 28);
		contentPane.add(btnX);
		
		labelUsuario = new JLabel("");
		labelUsuario.setBounds(0, 0, 1019, 737);
		contentPane.add(labelUsuario);
		ImageIcon fondo20=new ImageIcon(getClass().getResource("/img/princi.png"));
		ImageIcon icon20=new ImageIcon(fondo20.getImage().getScaledInstance(labelUsuario.getWidth(), labelUsuario.getHeight(),Image.SCALE_DEFAULT));
		labelUsuario.setIcon(icon20);
		
		modelo=new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Marca");
		modelo.addColumn("Tipo");
		modelo.addColumn("Precio");
		modelo.addColumn("Estado");
		table.setModel(modelo);
		
		txt3 = new JTextField();
		txt3.setBounds(393, 304, 334, 8);
		panelfondo.add(txt3);
		txt3.setColumns(10);
		txt3.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		txt3.setBackground(new Color(0, 128, 0));
		
		lbccodigo = new JLabel("");
		lbccodigo.setVisible(false);
		lbccodigo.setBounds(441, 84, 46, 14);
		panelfondo.add(lbccodigo);
		
		

		
		
		ancho();
		listartabla();
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnmini) {
			actionPerformedBtnmini(arg0);
		}
		if (arg0.getSource() == btnPiqueo) {
			do_btnPiqueo_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnPedido) {
			do_btnPedido_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnGenero) {
			do_btnGenero_actionPerformed(arg0);
		}
		if (arg0.getSource() == brnArtista) {
			do_brnArtista_actionPerformed(arg0);
		}
		if (arg0.getSource() == btncancion) {
			do_btncancion_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnBebida) {
			do_btnBebida_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnCliente) {
			do_btnCliente_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnUsuario) {
			do_btnUsuario_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnxx) {
			do_btnxx_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAcon) {
			do_btnAcon_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnImprimir) {
			do_btnImprimir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			do_btnGrabar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			do_btnNuevo_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnA�adir) {
			do_btnA�adir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnImagen) {
			do_btnImagen_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnX) {
			do_btnX_actionPerformed(arg0);
		}
	}

	private JLabel blID;
	private JLabel label_5;
	private JPanel panelMenu;
	private JButton btnxx;
	private JLabel label_6;
	private JLabel label_7;
	private JButton btnUsuario;
	private JButton btnCliente;
	private JButton btnBebida;
	private JButton btncancion;
	private JButton brnArtista;
	private JButton btnGenero;
	private JButton btnPedido;
	private JButton btnPiqueo;
	private JLabel label_8;
	private JLabel lblUsuario;
	private JLabel label_9;
	private JLabel lblCliente;
	private JLabel label_10;
	private JLabel lblBebida;
	private JLabel label_11;
	private JLabel lblCancion;
	private JLabel label_12;
	private JLabel lblArtista;
	private JLabel label_13;
	private JLabel lblGenero;
	private JLabel label_14;
	private JLabel lblPedido;
	private JLabel label_15;
	private JLabel lblPiqueo;
	private JComboBox cmbE;
	private JTextField txtPrecio;
	private JLabel lblMarca;
	private JTextField txtMar;
	
	
	
	
	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane .getWidth() / 100;
	}
	private void ancho(){
		TableColumnModel u = table.getColumnModel();
		u.getColumn(0).setPreferredWidth(anchoColumna(39)); 
		u.getColumn(1).setPreferredWidth(anchoColumna(63)); 
		u.getColumn(2).setPreferredWidth(anchoColumna(96));  
		u.getColumn(3).setPreferredWidth(anchoColumna(75)); 
		u.getColumn(4).setPreferredWidth(anchoColumna(59));  
		u.getColumn(5).setPreferredWidth(anchoColumna(59));  
		

	}
	
	
	
	protected void do_btnX_actionPerformed(ActionEvent arg0) {
		int i=JOptionPane.showConfirmDialog(null,"Desea salir","salir", JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(i==JOptionPane.YES_OPTION)
		dispose();
		else
			JOptionPane.showMessageDialog(null,"exito");
	}
	String ruta;
	protected void do_btnImagen_actionPerformed(ActionEvent arg0) {
		

		
		JFileChooser busca=new JFileChooser();
		
		FileNameExtensionFilter estension=new FileNameExtensionFilter("Seleccionar imagen","jpg","png");
		busca.setFileFilter(estension);
		
		
		if(busca.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
				Toolkit tool=Toolkit.getDefaultToolkit();
				ruta=busca.getSelectedFile().toString();
				Image imagen=tool.createImage(ruta);
				lbImagen.setIcon(new ImageIcon(imagen.getScaledInstance(lbImagen.getWidth(),lbImagen.getHeight(), imagen.SCALE_AREA_AVERAGING)));
		}
		
	}
	ArrayBebida bebida=new ArrayBebida();
	FileInputStream f;
	protected void do_btnA�adir_actionPerformed(ActionEvent arg0) {
		Connection c=null;

	
	try {
		
	Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
		
	} catch (Exception e) {
		e.getMessage();
	}
		

	try {
	PreparedStatement ps=c.prepareStatement("insert into bebidas values(?,?,?,?,?,?,?)");
	
		ps.setInt(1,bebida.generar());
		ps.setString(2,txtN.getText());
		ps.setString(3,txtMar.getText());
		ps.setString(4,cmbTipo.getSelectedItem().toString());
		ps.setDouble(5,Double.parseDouble(txtPrecio.getText()));
		ps.setString(6,cmbE.getSelectedItem().toString());
		f=new FileInputStream(ruta);
		ps.setBinaryStream(7,f);
		ps.executeUpdate();
		listartabla();
		JOptionPane.showMessageDialog(null,"Correcto");
		
		
		
	} catch (SQLException | FileNotFoundException e) {
		
		e.printStackTrace();
	
	}
	
		dispose();
		new Bebida().setVisible(true);
			
		

		
	}

	private void listartabla(){
		Connection c = null;
		try {
		
				Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		
		try {
			
			
			com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from bebidas");
					
			ResultSet r=p.executeQuery();

		modelo.setRowCount(0);

			while (r.next()) {
modelo.addRow(new Object[]{r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getDouble(5),r.getString(6)});
		table.setModel(modelo);
			
claseBebida b=new claseBebida(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getDouble(5),r.getString(6));
			bebida.agregar(b);
			lbImagen.updateUI();
			
			h.put(r.getInt(1),b);
				
			}
				} catch (Exception e) {
				
				
				}
			
			
		}
private void limpiar(){
		
	
		txtN.setText("");
		txtPrecio.setText("");
		txtMar.setText("");
		lbImagen.setIcon(null);
		cmbE.setSelectedIndex(0);
		cmbTipo.setSelectedIndex(0);
		
	}
	protected void do_btnNuevo_actionPerformed(ActionEvent arg0) {
		limpiar();
		
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent arg0) {
		Connection c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (int i = 0; i < bebida.tama�o(); i++) {

			if(lbccodigo.getText().equals("")==true){	
				lbccodigo.setText("1");
				s=table.getSelectedRow();
			}
			else if(bebida.Obtener(i).getIDBebida()==Integer.parseInt(lbccodigo.getText())){
			s=i;
					
			}
		}
		
		int codigo=bebida.Obtener(s).getIDBebida();
		try {
			PreparedStatement p=c.prepareStatement("delete from bebidas where cod_bebida="+codigo);
			
			
			int i=JOptionPane.showConfirmDialog(null,"Desea Eliminar","Eliminar", JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(i==JOptionPane.YES_OPTION){
				
			p.executeUpdate();
			listartabla();
			
			}else{
				JOptionPane.showMessageDialog(null,"exito");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		
	}
	

	
	private void imagen(){
	Connection c=null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	 c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
					
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		
	com.mysql.jdbc.Statement ss=(com.mysql.jdbc.Statement) c.createStatement();
	
ResultSetImpl r=(ResultSetImpl) ss.executeQuery("select image from bebidas where cod_bebida="+bebida.Obtener(s).getIDBebida());
	
if(r.next()){
	
	 Blob l=(Blob) r.getBlob("image");
	
	Image i=javax.imageio.ImageIO.read(l.getBinaryStream());
	


	lbImagen.setIcon(new ImageIcon(i.getScaledInstance(lbImagen.getWidth(),lbImagen.getHeight(), i.SCALE_AREA_AVERAGING)));
}
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
	}
	
	
	
	protected void do_btnModificar_actionPerformed(ActionEvent arg0) {
		Connection c=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		for (int i = 0; i < bebida.tama�o(); i++) {

				if(lbccodigo.getText().equals("")==true){	
					lbccodigo.setText("1");
					s=table.getSelectedRow();
				}
				else if(bebida.Obtener(i).getIDBebida()==Integer.parseInt(lbccodigo.getText())){
				s=i;
						
			}
		}
		try {
			
		

	
			int codigo=bebida.Obtener(s).getIDBebida();
	PreparedStatement p=c.prepareStatement("update bebidas set nombre=?,marca=?,"
			+ " tipo=?,precio=?,estado=?,image=?  where cod_bebida="+codigo
			);

		p.setString(1,txtN.getText());
		p.setString(2,txtMar.getText());
		p.setString(3,cmbTipo.getSelectedItem().toString());
		p.setDouble(4,Double.parseDouble(txtPrecio.getText()));
		p.setString(5,cmbE.getSelectedItem().toString());
		f=new FileInputStream(ruta);
		p.setBinaryStream(6,f);
		p.executeUpdate();
		listartabla();

		

		} catch (Exception ex) {
			
			for (int i = 0; i < bebida.tama�o(); i++) {

				if(lbccodigo.getText().equals("")==true){	
					lbccodigo.setText("1");
					s=table.getSelectedRow();
				}
				else if(bebida.Obtener(i).getIDBebida()==Integer.parseInt(lbccodigo.getText())){
				s=i;
						
			}
		}
			try {
			
			int codigo=bebida.Obtener(s).getIDBebida();
			PreparedStatement p=c.prepareStatement("update bebidas set nombre=?,marca=?,"
					+ " tipo=?,precio=?,estado=? where cod_bebida="+codigo
					);
			
					p.setString(1,txtN.getText());
					p.setString(2,txtMar.getText());
					p.setString(3,cmbTipo.getSelectedItem().toString());
					p.setDouble(4,Double.parseDouble(txtPrecio.getText()));
					p.setString(5,cmbE.getSelectedItem().toString());
					p.executeUpdate();
					listartabla();
				
		
		
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		
		
		}
	
		
		JOptionPane.showMessageDialog(null,"Datos Actulizados con exito");
		
	dispose();
	new Bebida().setVisible(true);
		
		
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_4) {
			mouseClickedLabel_4(arg0);
		}
		if (arg0.getSource() == table) {
			do_table_mouseClicked(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnPiqueo) {
			do_btnPiqueo_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnPedido) {
			do_btnPedido_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnGenero) {
			do_btnGenero_mouseEntered(arg0);
		}
		if (arg0.getSource() == brnArtista) {
			do_brnArtista_mouseEntered(arg0);
		}
		if (arg0.getSource() == btncancion) {
			do_btncancion_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnBebida) {
			do_btnBebida_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnCliente) {
			do_btnCliente_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnUsuario) {
			do_btnUsuario_mouseEntered(arg0);
		}
	}
	
	
	public void mousePressed(MouseEvent e) {
	}
	
	
	public void mouseReleased(MouseEvent e) {
	}
	
	
	
	
	protected void do_table_mouseClicked(MouseEvent arg0) {
		s=table.getSelectedRow();
		 txtN.setText(bebida.Obtener(s).getNombre());
		 cmbTipo.setSelectedItem(bebida.Obtener(s).getTipoBebida());
		 txtMar.setText(bebida.Obtener(s).getMarca());
		 txtPrecio.setText(String.valueOf(bebida.Obtener(s).getPrecio()));
		 cmbE.setSelectedItem(bebida.Obtener(s).getEstado());
		 	imagen();
			
			
	}
	protected void do_btnGrabar_actionPerformed(ActionEvent arg0) {
		dispose();
		superBebida su=new superBebida();
		su.setVisible(true);
		su.setLocationRelativeTo(null);
		
	}
	protected void do_btnImprimir_actionPerformed(ActionEvent arg0) {
		MessageFormat header=new MessageFormat("Acomm karaoke");
		MessageFormat footer=new MessageFormat("Detalle Bebida{0,number,integer}");
		try {
			table.print(JTable.PrintMode.NORMAL, header,footer);
			
		} catch (java.awt.print.PrinterException e) {
			System.err.format("Cannot print %s%n",e.getMessage());
		}
		
	
		
	
		
		
	}
	protected void do_btnAcon_actionPerformed(ActionEvent arg0) {
		label_5.setVisible(true);
		panelMenu.setVisible(true);
		scrollPane .setVisible(false);
		table.setVisible(false);
	
	}
	
	protected void do_btnxx_actionPerformed(ActionEvent arg0) {
		label_5.setVisible(false);
		panelMenu.setVisible(false);
		scrollPane .setVisible(true);
		table.setVisible(true);
		
	}
	
	public void mouseExited(MouseEvent arg0) {
		if (arg0.getSource() == btnUsuario) {
			do_btnUsuario_mouseExited(arg0);
		}
		if (arg0.getSource() == btnCliente) {
			do_btnCliente_mouseExited(arg0);
		}
		if (arg0.getSource() ==btnBebida) {
			do_btnBebida_mouseExited(arg0);
		}
		if (arg0.getSource() == btncancion) {
			do_btncancion_mouseExited(arg0);
		}
		if (arg0.getSource() == brnArtista) {
			do_brnArtista_mouseExited(arg0);
		}
		if (arg0.getSource() == btnGenero) {
			do_btnGenero_mouseExited(arg0);
		}
		if (arg0.getSource() == btnPedido) {
			do_btnPedido_mouseExited(arg0);
		}
		if (arg0.getSource() == btnPiqueo) {
			do_btnPiqueo_mouseExited(arg0);
		}
	}
	
	protected void do_btnUsuario_mouseExited(MouseEvent arg0) {
		btnUsuario.setContentAreaFilled(false);
		btnUsuario.setDefaultCapable(false);
		btnUsuario.setFocusPainted(false);
		btnUsuario.setFocusTraversalKeysEnabled(false);
		btnUsuario.setFocusable(false);
		btnUsuario.setIcon(null);
		lblUsuario.setVisible(true);
		label_8.setVisible(true);
		
		
		
	}
	protected void do_btnCliente_mouseExited(MouseEvent arg0) {
		btnCliente.setContentAreaFilled(false);
		btnCliente.setDefaultCapable(false);
		btnCliente.setFocusPainted(false);
		btnCliente.setFocusTraversalKeysEnabled(false);
		btnCliente.setFocusable(false);
		btnCliente.setIcon(null);
		lblCliente.setVisible(true);
		label_9.setVisible(true);
		
	}
	
	protected void do_btnBebida_mouseExited(MouseEvent arg0) {
		btnBebida.setContentAreaFilled(false);
		btnBebida.setDefaultCapable(false);
		btnBebida.setFocusPainted(false);
		btnBebida.setFocusTraversalKeysEnabled(false);
		btnBebida.setFocusable(false);
		btnBebida.setIcon(null);
		lblBebida.setVisible(true);
		label_10 .setVisible(true);
	}
	
	protected void do_btncancion_mouseExited(MouseEvent arg0) {
		btncancion.setContentAreaFilled(false);
		btncancion.setDefaultCapable(false);
		btncancion.setFocusPainted(false);
		btncancion.setFocusTraversalKeysEnabled(false);
		btncancion.setFocusable(false);
		btncancion.setIcon(null);
		lblCancion.setVisible(true);
		label_11 .setVisible(true);
	}
	
	protected void do_brnArtista_mouseExited(MouseEvent arg0) {
		brnArtista.setContentAreaFilled(false);
		brnArtista.setDefaultCapable(false);
		brnArtista.setFocusPainted(false);
		brnArtista.setFocusTraversalKeysEnabled(false);
		brnArtista.setFocusable(false);
		brnArtista.setIcon(null);
		lblArtista.setVisible(true);
		label_12.setVisible(true);
	}
	
	protected void do_btnGenero_mouseExited(MouseEvent arg0) {
		btnGenero.setContentAreaFilled(false);
		btnGenero.setDefaultCapable(false);
		btnGenero.setFocusPainted(false);
		btnGenero.setFocusTraversalKeysEnabled(false);
		btnGenero.setFocusable(false);
		btnGenero.setIcon(null);
		lblGenero.setVisible(true);
		label_13.setVisible(true);
		
		
	}
	
	protected void do_btnPedido_mouseExited(MouseEvent arg0) {
		btnPedido.setContentAreaFilled(false);
		btnPedido.setDefaultCapable(false);
		btnPedido.setFocusPainted(false);
		btnPedido.setFocusTraversalKeysEnabled(false);
		btnPedido.setFocusable(false);
		btnPedido.setIcon(null);
		lblPedido.setVisible(true);
		label_14.setVisible(true);
	}
	
	protected void do_btnPiqueo_mouseExited(MouseEvent arg0) {
		btnPiqueo.setContentAreaFilled(false);
		btnPiqueo.setDefaultCapable(false);
		btnPiqueo.setFocusPainted(false);
		btnPiqueo.setFocusTraversalKeysEnabled(false);
		btnPiqueo.setFocusable(false);
		btnPiqueo.setIcon(null);
		lblPiqueo.setVisible(true);
		label_15.setVisible(true);
	}
	
	protected void do_btnCliente_mouseEntered(MouseEvent arg0) {
		btnCliente.setFocusTraversalKeysEnabled(true);
		btnCliente.setContentAreaFilled(true);
		btnCliente.setBorderPainted(false);
		
		ImageIcon fondo12=new ImageIcon(getClass().getResource("/img/plomoC.png"));
		ImageIcon icon12=new ImageIcon(fondo12.getImage().getScaledInstance(	btnCliente.getWidth(), 	btnCliente.getHeight(),Image.SCALE_DEFAULT));
		btnCliente.setIcon(icon12);
	}
	protected void do_btnBebida_mouseEntered(MouseEvent arg0) {
		btnBebida.setFocusTraversalKeysEnabled(true);
		btnBebida.setContentAreaFilled(true);
		btnBebida.setBorderPainted(false);
		
		ImageIcon fondo11=new ImageIcon(getClass().getResource("/img/plomoB.png"));
		ImageIcon icon11=new ImageIcon(fondo11.getImage().getScaledInstance(	btnBebida.getWidth(), 	btnBebida.getHeight(),Image.SCALE_DEFAULT));
		btnBebida.setIcon(icon11);
		
	}
	protected void do_btncancion_mouseEntered(MouseEvent arg0) {
		btncancion.setFocusTraversalKeysEnabled(true);
		btncancion.setContentAreaFilled(true);
		btncancion.setBorderPainted(false);
		
		ImageIcon fondo11=new ImageIcon(getClass().getResource("/img/plomocan.png"));
		ImageIcon icon11=new ImageIcon(fondo11.getImage().getScaledInstance(	btncancion.getWidth(), btncancion.getHeight(),Image.SCALE_DEFAULT));
		btncancion.setIcon(icon11);
	
		
	}
	protected void do_brnArtista_mouseEntered(MouseEvent arg0) {
		brnArtista.setFocusTraversalKeysEnabled(true);
		brnArtista.setContentAreaFilled(true);
		brnArtista.setBorderPainted(false);
		
		ImageIcon fondo11=new ImageIcon(getClass().getResource("/img/plomoA.png"));
		ImageIcon icon11=new ImageIcon(fondo11.getImage().getScaledInstance(	brnArtista.getWidth(), brnArtista.getHeight(),Image.SCALE_DEFAULT));
		brnArtista.setIcon(icon11);
	
		
	}
	protected void do_btnGenero_mouseEntered(MouseEvent arg0) {
		btnGenero.setFocusTraversalKeysEnabled(true);
		btnGenero.setContentAreaFilled(true);
		btnGenero.setBorderPainted(false);
		
		ImageIcon fondo12=new ImageIcon(getClass().getResource("/img/plomoG.png"));
		ImageIcon icon12=new ImageIcon(fondo12.getImage().getScaledInstance(	btnGenero.getWidth(), 	btnGenero.getHeight(),Image.SCALE_DEFAULT));
		btnGenero.setIcon(icon12);
	}
	protected void do_btnPedido_mouseEntered(MouseEvent arg0) {
		btnPedido.setFocusTraversalKeysEnabled(true);
		btnPedido.setContentAreaFilled(true);
		btnPedido.setBorderPainted(false);
		ImageIcon fondo12=new ImageIcon(getClass().getResource("/img/plomoPP.png"));
		ImageIcon icon12=new ImageIcon(fondo12.getImage().getScaledInstance(	btnPedido.getWidth(), btnPedido.getHeight(),Image.SCALE_DEFAULT));
		btnPedido.setIcon(icon12);
	}
	protected void do_btnPiqueo_mouseEntered(MouseEvent arg0) {
		btnPiqueo.setFocusTraversalKeysEnabled(true);
		btnPiqueo.setContentAreaFilled(true);
		btnPiqueo.setBorderPainted(false);
		
		ImageIcon fondo12=new ImageIcon(getClass().getResource("/img/plomoPiqueo.png"));
		ImageIcon icon12=new ImageIcon(fondo12.getImage().getScaledInstance(	btnPiqueo.getWidth(), 	btnPiqueo.getHeight(),Image.SCALE_DEFAULT));
		btnPiqueo.setIcon(icon12);
	}
	protected void do_btnUsuario_mouseEntered(MouseEvent arg0) {
		btnUsuario.setFocusTraversalKeysEnabled(true);
		btnUsuario.setContentAreaFilled(true);
		btnUsuario.setBorderPainted(false);
		
		ImageIcon fondo11=new ImageIcon(getClass().getResource("/img/plomoU.png"));
		ImageIcon icon11=new ImageIcon(fondo11.getImage().getScaledInstance(	btnUsuario.getWidth(), 	btnUsuario.getHeight(),Image.SCALE_DEFAULT));
		btnUsuario.setIcon(icon11);
	
		
		
	}
	protected void do_btnUsuario_actionPerformed(ActionEvent arg0) {
		dispose();
		Usuario u= new Usuario();
		u.setVisible(true);
		u.setLocationRelativeTo(null);
	}
	protected void do_btnCliente_actionPerformed(ActionEvent arg0) {
		dispose();
		Cliente c=new Cliente();
		c.setVisible(true);
		c.setLocationRelativeTo(null);
	}
	protected void do_btnBebida_actionPerformed(ActionEvent arg0) {
		dispose();
		Bebida c=new Bebida();
		c.setVisible(true);
		c.setLocationRelativeTo(null);
	}
	protected void do_btncancion_actionPerformed(ActionEvent arg0) {
		dispose();
		Cancion c=new Cancion();
		c.setVisible(true);
		c.setLocationRelativeTo(null);
	}
	protected void do_brnArtista_actionPerformed(ActionEvent arg0) {
		dispose();
		Artista c=new Artista();
		c.setVisible(true);
		c.setLocationRelativeTo(null);
	}
	protected void do_btnGenero_actionPerformed(ActionEvent arg0) {
		dispose();
		Genero c=new Genero();
		c.setVisible(true);
		c.setLocationRelativeTo(null);
	}
	protected void do_btnPedido_actionPerformed(ActionEvent arg0) {
		dispose();
		Pedido c=new Pedido();
		c.setVisible(true);
		c.setLocationRelativeTo(null);
	}
	protected void do_btnPiqueo_actionPerformed(ActionEvent arg0) {
		dispose();
		Piqueo c=new Piqueo();
		c.setVisible(true);
		c.setLocationRelativeTo(null);
	}
	protected void actionPerformedBtnmini(ActionEvent arg0) {
		setExtendedState(1);
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == contentPane) {
			mouseDraggedContentPane(e);
		}
		
		
	}
	int x,y;
	public static JLabel lbccodigo;
	
	public void mouseMoved(MouseEvent e) {
		
		x=e.getX();
		y=e.getY();
		
		
	}
	protected void mouseDraggedContentPane(MouseEvent e) {
		
		Point p=MouseInfo.getPointerInfo().getLocation();
		setLocation(p.x-x, p.y-y);
			
	}
	protected void mouseClickedLabel_4(MouseEvent arg0) {
		

		
		if(h.containsKey(Integer.parseInt(lbccodigo.getText()))){
			
		claseBebida cl=h.get(Integer.parseInt(lbccodigo.getText()));
	
		
		
		modelo.setRowCount(0);
		modelo.addRow(new Object[]{cl.getIDBebida(),cl.getNombre(),cl.getMarca(),cl.getTipoBebida(),
				cl.getPrecio(),cl.getEstado()});
		table.setModel(modelo);
	for (int i = 0; i < bebida.tama�o(); i++) {
			
			if(bebida.Obtener(i).getIDBebida()==Integer.parseInt(lbccodigo.getText())){
					s=i;
			}
		}
		
	txtN.setText(bebida.Obtener(s).getNombre());
	txtMar.setText(bebida.Obtener(s).getMarca());
	txtPrecio.setText(bebida.Obtener(s).getPrecio()+"");
	cmbTipo.setSelectedItem(bebida.Obtener(s).getTipoBebida());
	cmbE.setSelectedItem(bebida.Obtener(s).getEstado());
	imagen();
		
	
	

		}else{
			JOptionPane.showMessageDialog(null, "no hay");
		}
		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtPrecio) {
			keyTypedTxtPrecio(e);
		}
		if (e.getSource() == txtN) {
			keyTypedTxtN(e);
		}
	}
	protected void keyTypedTxtN(KeyEvent e) {
		

		if(txtN.getText().matches("\\D*")==false){
			e.consume();
			JOptionPane.showMessageDialog(null,"No se acepta Numeros");
		}
	
	}
	protected void keyTypedTxtPrecio(KeyEvent e) {

		if(txtPrecio.getText().matches("\\d*")==false){
			e.consume();
			JOptionPane.showMessageDialog(null,"No se acepta Letras");
		}
		
		
	}
}
