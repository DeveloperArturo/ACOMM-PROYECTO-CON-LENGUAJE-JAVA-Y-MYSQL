package Formulario;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.PasswordView;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Toolkit;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.mysql.jdbc.Blob;
import com.mysql.jdbc.ByteArrayRow;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;


import Array.ArrayUsuario;
import Clases.claseUsuario;
import Imprimir.UsuarioImprimir;
import libreria.fondo;
import libreria.imprimir;
import libreria.seguridad;
import libreria.superConsulta;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import javax.print.DocFlavor.BYTE_ARRAY;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Usuario extends JFrame implements ActionListener, MouseListener, MouseMotionListener, PropertyChangeListener, KeyListener{
	TableRowSorter<DefaultTableModel> buscar1;
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
	private DefaultTableModel modelo;
	private JTextField txt1;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt2;
	private JPanel panel;
	private JLabel lbdatos;
	private JPanel panelfondo;
	private JPanel panelImagen;
	public static  JTable table;
	private JScrollPane scrollPane;
	private JPanel panelSeguridad;
	private JPanel panelDetalle;
	private JLabel lblNombre;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JLabel lblDetalleDeEmpleado;
	private JLabel lblTipo;
	private JLabel lblTurno;
	private JLabel lblSeguridad;
	private JLabel lblPassword;
	private JButton btnImprimir;
	private JButton btnConsultar;
	private JButton btnImagen;
	private JTextField txtPaterno;
	private JTextField txtMaterno;
	private JTextField txtNombre;
	private JComboBox cmbTurno;
	private JComboBox cmbTipo;
	private JPasswordField passwordField;
	private JTextField txtbutu;
	private JButton btnAñadir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private int p;
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
	private HashMap<Integer,claseUsuario> h=new HashMap<>();
	
	

	/**
	 * Formulario Usuario
	 * Diseñador Arturo Gil Serpa
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
					Usuario frame = new Usuario();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creando el Usuario
	 */
	public Usuario() {
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
		contentPane.addMouseListener(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/imprimir.png"));
			ImageIcon fondo2=new ImageIcon(getClass().getResource("/img/imprimir2.png"));
		
		panelMenu = new JPanel();
		panelMenu.setVisible(false);
		
		btnpresionar = new JButton("ÁCOMM Karaoke");
		btnpresionar.addActionListener(this);
		
		btnseguridad = new JButton("");
		btnseguridad.addActionListener(this);
		//seguridad5
	
		btnseguridad.setBorderPainted(false);
		btnseguridad.setContentAreaFilled(false);
		btnseguridad.setDefaultCapable(false);
		btnseguridad.setFocusPainted(false);
		btnseguridad.setFocusTraversalKeysEnabled(false);
		btnseguridad.setFocusable(false);
	
		
		
		btnseguridad.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnseguridad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnseguridad.setBounds(455, 2, 86, 22);
			ImageIcon fondo80=new ImageIcon(getClass().getResource("/img/seguridadd2.png"));
		ImageIcon icon80=new ImageIcon(fondo80.getImage().getScaledInstance(btnseguridad.getWidth(),btnseguridad.getHeight(),Image.SCALE_DEFAULT));
		btnseguridad.setIcon(icon80);
		
		btnseguridad.setRolloverIcon(new ImageIcon(getClass().getResource("/img/seguridad8.png")));
		
		contentPane.add(btnseguridad);
		btnpresionar.setFocusTraversalKeysEnabled(false);
		btnpresionar.setFocusable(false);
		btnpresionar.setFocusPainted(false);
		btnpresionar.setDefaultCapable(false);
		btnpresionar.setContentAreaFilled(false);
		btnpresionar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnpresionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnpresionar.setForeground(new Color(165, 42, 42));
		btnpresionar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnpresionar.setBounds(836, 45, 140, 23);
		contentPane.add(btnpresionar);
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelMenu.setBackground(Color.BLACK);
		panelMenu.setBounds(10, 84, 382, 536);
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
		
		brnArtista =  new JButton("");
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
		panel.setBounds(402, 226, 383, 205);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbdatos = new JLabel("Datos Personales");
		lbdatos.setForeground(SystemColor.windowBorder);
		lbdatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbdatos.setBounds(37, 11, 101, 14);
		panel.add(lbdatos);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(SystemColor.windowBorder);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 57, 55, 14);
		panel.add(lblNombre);
		
		lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setForeground(SystemColor.windowBorder);
		lblApellidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidoPaterno.setBounds(10, 111, 101, 14);
		panel.add(lblApellidoPaterno);
		
		lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setForeground(SystemColor.windowBorder);
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidoMaterno.setBounds(10, 160, 112, 14);
		panel.add(lblApellidoMaterno);
		
		txtPaterno = new JTextField();
		txtPaterno.addKeyListener(this);
		txtPaterno.setForeground(SystemColor.windowBorder);
		txtPaterno.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtPaterno.setBackground(UIManager.getColor("CheckBox.light"));
		txtPaterno.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtPaterno.setBounds(129, 100, 203, 28);
		panel.add(txtPaterno);
		txtPaterno.setColumns(10);
		
		txtMaterno = new JTextField();
		txtMaterno.addKeyListener(this);
		txtMaterno.setForeground(SystemColor.windowBorder);
		txtMaterno.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtMaterno.setColumns(10);
		txtMaterno.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtMaterno.setBackground(SystemColor.controlHighlight);
		txtMaterno.setBounds(129, 148, 203, 28);
		panel.add(txtMaterno);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setForeground(SystemColor.windowBorder);
		txtNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtNombre.setColumns(10);
		txtNombre.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtNombre.setBackground(SystemColor.controlHighlight);
		txtNombre.setBounds(129, 50, 203, 28);
		panel.add(txtNombre);
		
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		txt2.setBackground(new Color(154, 205, 50));
		txt2.setBounds(795, 217, 214, 8);
		contentPane.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		txt3.setBackground(new Color(220, 20, 60));
		txt3.setBounds(402, 451, 339, 8);
		contentPane.add(txt3);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		txt4.setBackground(new Color(70, 130, 180));
		txt4.setBounds(757, 451, 244, 8);
		contentPane.add(txt4);
		
		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		txt1.setBackground(new Color(255, 165, 0));
		txt1.setBounds(402, 217, 383, 8);
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
		panelImagen.setBounds(785, 108, 215, 205);
		panelfondo.add(panelImagen);
		panelImagen.setLayout(null);
		
		lbimagen = new JLabel("");
		lbimagen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbimagen.addMouseListener(this);
		lbimagen.setBounds(10, 11, 205, 183);
		panelImagen.add(lbimagen);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(Color.WHITE, 3));
		scrollPane.setBounds(0, 0, 386, 489);
		panelfondo.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Paterno", "Materno", "Empleado", "Turno", "Password"
			}
		));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		panelSeguridad = new JPanel();
		panelSeguridad.setLayout(null);
		panelSeguridad.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelSeguridad.setBackground(Color.WHITE);
		panelSeguridad.setBounds(747, 341, 245, 222);
		panelfondo.add(panelSeguridad);
		
		lblSeguridad = new JLabel("Seguridad");
		lblSeguridad.setForeground(SystemColor.windowBorder);
		lblSeguridad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeguridad.setBounds(40, 22, 82, 14);
		panelSeguridad.add(lblSeguridad);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(SystemColor.windowBorder);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(10, 102, 82, 14);
		panelSeguridad.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.controlHighlight);
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		passwordField.setBounds(76, 95, 159, 29);
		panelSeguridad.add(passwordField);
		
		panelDetalle = new JPanel();
		panelDetalle.setLayout(null);
		panelDetalle.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelDetalle.setBackground(Color.WHITE);
		panelDetalle.setBounds(393, 341, 337, 222);
		panelfondo.add(panelDetalle);
		
		lblDetalleDeEmpleado = new JLabel("Detalle de Empleado");
		lblDetalleDeEmpleado.setForeground(SystemColor.windowBorder);
		lblDetalleDeEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDetalleDeEmpleado.setBounds(47, 22, 135, 14);
		panelDetalle.add(lblDetalleDeEmpleado);
		
		lblTipo = new JLabel("Tipo ");
		lblTipo.setForeground(SystemColor.windowBorder);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipo.setBounds(10, 79, 55, 14);
		panelDetalle.add(lblTipo);
		
		lblTurno = new JLabel("Turno");
		lblTurno.setForeground(SystemColor.windowBorder);
		lblTurno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTurno.setBounds(10, 119, 55, 14);
		panelDetalle.add(lblTurno);
		
		cmbTurno = new JComboBox();
		cmbTurno.setFont(new Font("Times New Roman", Font.BOLD, 13));
		cmbTurno.setModel(new DefaultComboBoxModel(new String[] {"Tarde", "Noche"}));
		cmbTurno.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		cmbTurno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbTurno.setBounds(72, 106, 152, 27);
		panelDetalle.add(cmbTurno);
		
		cmbTipo = new JComboBox();
		cmbTipo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Supervisor", "Mozo"}));
		cmbTipo.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		cmbTipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbTipo.setBounds(72, 67, 152, 27);
		panelDetalle.add(cmbTipo);
		
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
		
		btnConsultar = new JButton("");
		btnConsultar.addActionListener(this);
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.setFocusable(false);
		btnConsultar.setFocusTraversalKeysEnabled(false);
		btnConsultar.setFocusPainted(false);
		btnConsultar.setDefaultCapable(false);
		btnConsultar.setContentAreaFilled(false);
		btnConsultar.setBorderPainted(false);
		btnConsultar.setBounds(601, 16, 199, 52);
		ImageIcon fondo4=new ImageIcon(getClass().getResource("/img/consul1.png"));
		ImageIcon icon4=new ImageIcon(fondo4.getImage().getScaledInstance(btnConsultar.getWidth(),btnConsultar.getHeight(),Image.SCALE_DEFAULT));
		btnConsultar.setIcon(icon4);
		ImageIcon fondo0=new ImageIcon(getClass().getResource("/img/consultar2.png"));
		ImageIcon icon0=new ImageIcon(fondo0.getImage().getScaledInstance(btnConsultar.getWidth(),btnConsultar.getHeight(),Image.SCALE_DEFAULT));
		btnConsultar.setRolloverIcon(icon0);
		panelfondo.add(btnConsultar);
		
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
		txtbutu.setBackground(new Color(154, 205, 50));
		txtbutu.setBounds(0, 492, 378, 8);
		panelfondo.add(txtbutu);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.addActionListener(this);
		btnAñadir.setIcon(new ImageIcon(Usuario.class.getResource("/img/a\u00F1adir.png")));
		btnAñadir.setFocusPainted(false);
		btnAñadir.setFocusTraversalKeysEnabled(false);
		btnAñadir.setFocusable(false);
		btnAñadir.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadir.setForeground(SystemColor.windowBorder);
		btnAñadir.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnAñadir.setBounds(289, 511, 89, 52);
		panelfondo.add(btnAñadir);
		
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
		
		lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setForeground(Color.WHITE);
		lblUsuarios.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUsuarios.setBounds(56, 86, 66, 14);
		contentPane.add(lblUsuarios);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Usuario.class.getResource("/img/usuarioss.png")));
		label_3.setBounds(20, 74, 38, 45);
		contentPane.add(label_3);
		
		lb = new JLabel("");
		lb.setBounds(9, 74, 1002, 45);
		contentPane.add(lb);
		ImageIcon fondo3=new ImageIcon(getClass().getResource("/img/cv.png"));
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
		label.setBounds(996, 2, 11, 14);
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
		modelo.addColumn("Nombres");
		modelo.addColumn("Paterno");
		modelo.addColumn("Materno");
		modelo.addColumn("Empleado");
		modelo.addColumn("Turno");
		modelo.addColumn("Password");
		table.setModel(modelo);
		
		lbccodigo = new JLabel("");
		lbccodigo.setVisible(false);
		lbccodigo.setBounds(435, 75, 46, 14);
		panelfondo.add(lbccodigo);
		
		
		listar();
		ancho();
	
	
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnseguridad) {
			actionPerformedBtnseguridad(arg0);
		}
		if (arg0.getSource() == btnpresionar) {
			actionPerformedBtnpresionar(arg0);
		}
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
		if (arg0.getSource() == btnConsultar) {
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
		if (arg0.getSource() == btnAñadir) {
			do_btnAñadir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnImagen) {
			do_btnImagen_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnX) {
			do_btnX_actionPerformed(arg0);
		}
	}
	ArrayUsuario usuario=new ArrayUsuario();


	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane .getWidth() / 100;
	}
	private void ancho(){
		TableColumnModel u = table.getColumnModel();
		u.getColumn(0).setPreferredWidth(anchoColumna(33)); 
		u.getColumn(1).setPreferredWidth(anchoColumna(54)); 
		u.getColumn(2).setPreferredWidth(anchoColumna(57));  
		u.getColumn(3).setPreferredWidth(anchoColumna(56)); 
		u.getColumn(4).setPreferredWidth(anchoColumna(59));  
		u.getColumn(5).setPreferredWidth(anchoColumna(38));  
		u.getColumn(6).setPreferredWidth(anchoColumna(60));  
		

	}
	
	
		
	

	

	
	
	private void listar(){
		Connection c = null;
		try {
		
				Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		try {
	
			
	com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from usuarios");
			
	ResultSet r=p.executeQuery();

modelo.setRowCount(0);
	while (r.next()) {


	String cadena=r.getString(7);
	String password="";
	for (int i = 0; i < cadena.length(); i++) {
	 password+="•";
		
	}

				
modelo.addRow(new Object[]{r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),password});
table.setModel(modelo);	
	
	
claseUsuario u=new claseUsuario(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),password);
	usuario.agregar(u);
	lbimagen.updateUI();
	h.put(r.getInt(1),u);
		
	}
		} catch (Exception e) {
		
		
		}

}	
	 
	 
		Image i;
	 public static int codigo;
	 public  static String nombre;
	 public  static String paterno;
	 public  static String materno;
	 public  static String tipo;
	 public  static  String turno;
	 
	private void imagen(){
	Connection c=null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	 c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
					
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		
	com.mysql.jdbc.Statement s=(com.mysql.jdbc.Statement) c.createStatement();
	
ResultSetImpl r=(ResultSetImpl) s.executeQuery("select imagen from usuarios where cod_usuarios="+usuario.recibir(p).getcodigo());
	
if(r.next()){
	
	
		 Blob l=(Blob) r.getBlob("imagen");
		 i=javax.imageio.ImageIO.read(l.getBinaryStream());
		
		 
	lbimagen.setIcon(new ImageIcon(i.getScaledInstance(lbimagen.getWidth(),lbimagen.getHeight(), i.SCALE_AREA_AVERAGING)));

	
}
	


	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
	}

	
	private void datos(){
		Connection c=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		 c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			
		com.mysql.jdbc.Statement s=(com.mysql.jdbc.Statement) c.createStatement();
		
	ResultSetImpl r=(ResultSetImpl) s.executeQuery("select cod_usuarios,nombre,apellido_paterno,apellido_materno,tipo,turno   from usuarios where cod_usuarios="+usuario.recibir(p).getcodigo());
		
	if(r.next()){
		
		
		
		codigo=r.getInt(1);
		 nombre=r.getString(2);
		 paterno=r.getString(3);
		 materno=r.getString(4);
		 tipo=r.getString(5);
		 turno=r.getString(6);
		 
		
		
	}
		


		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		}


	

	protected void do_btnX_actionPerformed(ActionEvent arg0) {
		int i=JOptionPane.showConfirmDialog(null,"Desea salir","salir", JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(i==JOptionPane.YES_OPTION){
		dispose();
		Acomm t=new Acomm();
		t.setVisible(true);
		t.setLocationRelativeTo(null);
		try {
			

			
			
			
			 Acomm.velmil=3000;
			
			 Acomm.tarea =new TimerTask(){
			

				public void run(){
					
				
					
					switch (Acomm.contador) {
					case 0:
						Acomm.contador=1;
							ImageIcon fondo=new ImageIcon(getClass().getResource("/img/music.png"));
							ImageIcon iconos=new ImageIcon(fondo.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel.getHeight(),Image.SCALE_DEFAULT));
							t.Carrusel.setIcon(iconos);
						break;

					case 1:
						Acomm.contador=2;
						ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/cancion.jpg"));
						ImageIcon iconos1=new ImageIcon(fondo1.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel .getHeight(),Image.SCALE_DEFAULT));
						t.Carrusel.setIcon(iconos1);
						
						break;
					case 2:
						Acomm.contador=3;
						ImageIcon fondo2=new ImageIcon(getClass().getResource("/img/noches.png"));
						ImageIcon iconos2=new ImageIcon(fondo2.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel .getHeight(),Image.SCALE_DEFAULT));
						t.Carrusel.setIcon(iconos2);
						break;
					case 3:
						Acomm.contador=4;
						ImageIcon fondo3=new ImageIcon(getClass().getResource("/img/arcoiris.png"));
						ImageIcon iconos3=new ImageIcon(fondo3.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel .getHeight(),Image.SCALE_DEFAULT));
						t.Carrusel.setIcon(iconos3);
						break;
						
					case 4:
						Acomm.contador=0;
					ImageIcon fondo4=new ImageIcon(getClass().getResource("/img/estrella.png"));
					ImageIcon iconos4=new ImageIcon(fondo4.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel .getHeight(),Image.SCALE_DEFAULT));
					t.Carrusel.setIcon(iconos4);
					break;
					
				
				}
					
			}
			
			
			
			};
			
			
			Acomm.timer=new Timer();
			
			Acomm.timer.scheduleAtFixedRate(Acomm.tarea, Acomm.velmil,Acomm.velmil);
		

			
		}

				

		
			

	 catch (Exception e) {
		e.printStackTrace();
	
		
	}

	
		}else{
			JOptionPane.showMessageDialog(null,"exito");
		}
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
	lbimagen.setIcon(new ImageIcon(imagen.getScaledInstance(lbimagen.getWidth(),lbimagen.getHeight(), imagen.SCALE_AREA_AVERAGING)));
		}
		
	}
	 FileInputStream fi;
	protected void do_btnAñadir_actionPerformed(ActionEvent arg0) {
	Connection c=null;

		String pas=new String(passwordField.getPassword());
	
	try {
		
	Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
		
	} catch (Exception e) {
		e.getMessage();
	}
	
	try {
	PreparedStatement ps=c.prepareStatement("insert into usuarios values(?,?,?,?,?,?,?,?)");
		ps.setInt(1,usuario.generar());
		ps.setString(2,txtNombre.getText());
		ps.setString(3,txtPaterno.getText());
		ps.setString(4,txtMaterno.getText());
		ps.setString(5,cmbTipo.getSelectedItem().toString());
		ps.setString(6,cmbTurno.getSelectedItem().toString());
		ps.setString(7,pas);
		fi=new FileInputStream(ruta);
		ps.setBinaryStream(8,fi);
		ps.executeUpdate();
		
		listar();
		JOptionPane.showMessageDialog(null,"Correcto");
		
		
	} catch (SQLException | FileNotFoundException e) {
		
		e.printStackTrace();
	
	}
	
	dispose();
	new Usuario().setVisible(true);
		

		
}
	protected void do_btnNuevo_actionPerformed(ActionEvent arg0) {
		txtNombre.setText("");
		txtPaterno.setText("");
		txtMaterno.setText("");
		cmbTipo.setSelectedIndex(0);
		cmbTurno.setSelectedIndex(0);
		lbimagen.setIcon(null);
		passwordField.setText("");
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent arg0) {
		
		Connection c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (int i = 0; i < usuario.tamaño(); i++) {

			if(lbccodigo.getText().equals("")==true){	
				lbccodigo.setText("1");
				p=table.getSelectedRow();
			}
			else if(usuario.recibir(i).getcodigo()==Integer.parseInt(lbccodigo.getText())){
			p=i;
					
			}
		}
		
		int codigo=usuario.recibir(p).getcodigo();
		try {
	PreparedStatement p=c.prepareStatement("delete from usuarios where cod_usuarios="+codigo);
		
	

		int i=JOptionPane.showConfirmDialog(null,"Desea Eliminar","Eliminar", 	JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(i==JOptionPane.YES_OPTION){
	
			p.executeUpdate();
			
			listar();
		}
		else{
		JOptionPane.showMessageDialog(null,"exito");
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void do_btnModificar_actionPerformed(ActionEvent arg0) {
		
	String pas=new String(passwordField.getPassword());
	Connection c=null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	for (int i = 0; i < usuario.tamaño(); i++) {

			if(lbccodigo.getText().equals("")==true){	
				lbccodigo.setText("1");
				p=table.getSelectedRow();
			}
			else if(usuario.recibir(i).getcodigo()==Integer.parseInt(lbccodigo.getText())){
			p=i;
					
		}
	}
	
	try {
		
		
		
			int codigo=usuario.recibir(p).getcodigo();
		PreparedStatement p=c.prepareStatement("update usuarios  set nombre=?,apellido_paterno=?,"
				+ "apellido_materno=?,tipo=?,turno=?,passwor=?,imagen=?  where cod_usuarios="+codigo
				);


			
			p.setString(1,txtNombre.getText());
			p.setString(2,txtPaterno.getText());
			p.setString(3,txtMaterno.getText());
			p.setString(4,cmbTipo.getSelectedItem().toString());
			p.setString(5,cmbTurno.getSelectedItem().toString());
			p.setString(6,pas);
			fi=new FileInputStream(ruta);
			p.setBinaryStream(7,fi);
			p.executeUpdate();
			listar();

			
		


	} catch (Exception ex) {
		for (int i = 0; i < usuario.tamaño(); i++) {

			if(lbccodigo.getText().equals("")==true){	
				lbccodigo.setText("1");
				p=table.getSelectedRow();
			}
			else if(usuario.recibir(i).getcodigo()==Integer.parseInt(lbccodigo.getText())){
			p=i;
					
		}
	}
		
		try {
		
			
					int codigo=usuario.recibir(p).getcodigo();
						PreparedStatement p=c.prepareStatement("update usuarios  set nombre=?,apellido_paterno=?,"
								+ "apellido_materno=?,tipo=?,turno=?,passwor=? where cod_usuarios="+codigo
								);
							
					
							p.setString(1,txtNombre.getText());
							p.setString(2,txtPaterno.getText());
							p.setString(3,txtMaterno.getText());
							p.setString(4,cmbTipo.getSelectedItem().toString());
							p.setString(5,cmbTurno.getSelectedItem().toString());
							p.setString(6,pas);
							p.executeUpdate();
							listar();
						
		
	
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		

	}
	
	JOptionPane.showMessageDialog(null,"Datos Actulizados con exito");

	
	dispose();
	new Usuario().setVisible(true);
		
}
	
	

			
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lbimagen) {
			mouseClickedLbimagen(arg0);
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
		if (e.getSource() == contentPane) {
			mousePressedContentPane(e);
		}
		
		
		
		
		
	}
	public void mouseReleased(MouseEvent e) {
	}
	
	
	
	
	protected void do_table_mouseClicked(MouseEvent arg0) {
		p=table.getSelectedRow();
		txtNombre.setText(usuario.recibir(p).getNombres());
		txtPaterno.setText(usuario.recibir(p).getApellidoPaterno());
		txtMaterno.setText(usuario.recibir(p).getApellidoMaterno());
		cmbTipo.setSelectedItem(usuario.recibir(p).getTipoEmpleado());
		cmbTurno.setSelectedItem(usuario.recibir(p).getTurno());
		passwordField.setText(usuario.recibir(p).getPassword());
		imagen();
		datos();
		

	}
	
	protected void do_btnGrabar_actionPerformed(ActionEvent arg0) {

	dispose();
	superConsulta superConsulta=new superConsulta();
	superConsulta.setVisible(true);
	superConsulta.setLocationRelativeTo(null);
	
			
		
	}
	protected void do_btnImprimir_actionPerformed(ActionEvent arg0) {
		
		UsuarioImprimir ui=new UsuarioImprimir();
		ui.setVisible(true);
		ui.setLocationRelativeTo(null);
		
		
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
	protected void do_btncancion_actionPerformed(ActionEvent arg0) {dispose();
	
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
	protected void mousePressedContentPane(MouseEvent e) {
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == contentPane) {
			mouseDraggedContentPane(arg0);
		}
	}
	int x,y;
	public  JLabel lbimagen;
	private JButton btnpresionar;
	public static  JLabel lbccodigo;
	private JButton btnseguridad;
	
	public void mouseMoved(MouseEvent arg0) {
		
		x=arg0.getX();
		y=arg0.getY();
		
		
	}
	
	
	protected void mouseDraggedContentPane(MouseEvent arg0) {
		
		
	Point p=MouseInfo.getPointerInfo().getLocation();
	setLocation(p.x-x, p.y-y);
		
	}
	
	public void propertyChange(PropertyChangeEvent arg0) {
		
	}
	
	protected void mouseClickedLbimagen(MouseEvent arg0) {
	
		fondo f=new fondo();
	
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		
		
	fondo.lbfondo.setIcon(new ImageIcon(i.getScaledInstance(fondo.lbfondo.getWidth(),fondo.lbfondo.getHeight(), Image.SCALE_AREA_AVERAGING)));
	
	fondo.codigo1=codigo;
	fondo.nombre1=nombre;
	fondo.paterno1=paterno;
	fondo.materno1=materno;
	fondo.tipo1=tipo;
	fondo.turno1=turno;
	
	}
	

	protected void actionPerformedBtnpresionar(ActionEvent arg0) {
		
		
		
		
		if(h.containsKey(Integer.parseInt(lbccodigo.getText()))){
			
		claseUsuario cl=h.get(Integer.parseInt(lbccodigo.getText()));
	
		
		
		modelo.setRowCount(0);
		modelo.addRow(new Object[]{cl.getcodigo(),cl.getNombres(),cl.getApellidoPaterno(),cl.getApellidoMaterno(),
				cl.getTipoEmpleado(),cl.getTurno(),cl.getPassword()});
		table.setModel(modelo);
	for (int i = 0; i < usuario.tamaño(); i++) {
			
			if(usuario.recibir(i).getcodigo()==Integer.parseInt(lbccodigo.getText())){
					p=i;
			}
		}
		
	txtNombre.setText(usuario.recibir(p).getNombres());
	txtPaterno.setText(usuario.recibir(p).getApellidoPaterno());
	txtMaterno.setText(usuario.recibir(p).getApellidoMaterno());
	cmbTipo.setSelectedItem(usuario.recibir(p).getTipoEmpleado());
	cmbTurno.setSelectedItem(usuario.recibir(p).getTurno());
	passwordField.setText(usuario.recibir(p).getPassword());
	imagen();
		
	
	

		}else{
			JOptionPane.showMessageDialog(null, "no hay");
		}
	}
	protected void actionPerformedBtnseguridad(ActionEvent arg0) {
		dispose();
		seguridad seguro=new seguridad();
		seguro.setVisible(true);
		seguro.setLocationRelativeTo(null);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtMaterno) {
			keyTypedTxtMaterno(e);
		}
		if (e.getSource() == txtPaterno) {
			keyTypedTxtPaterno(e);
		}
		if (e.getSource() == txtNombre) {
			keyTypedTxtNombre(e);
		}
	}
	protected void keyTypedTxtNombre(KeyEvent e) {
		
		if(txtNombre.getText().matches("\\D*")==false){
			e.consume();
			txtNombre.setText("");
			JOptionPane.showMessageDialog(null,"No se acepta Numeros");
		}
		
	}
	protected void keyTypedTxtPaterno(KeyEvent e) {
		
		if(txtPaterno.getText().matches("\\D*")==false){
			e.consume();
			txtPaterno.setText("");
			JOptionPane.showMessageDialog(null,"No se acepta Numeros");
		}
	}
	protected void keyTypedTxtMaterno(KeyEvent e) {
		
		if(txtMaterno.getText().matches("\\D*")==false){
			e.consume();
			txtMaterno.setText("");
			JOptionPane.showMessageDialog(null,"No se acepta Numeros");
		}
	}
}
