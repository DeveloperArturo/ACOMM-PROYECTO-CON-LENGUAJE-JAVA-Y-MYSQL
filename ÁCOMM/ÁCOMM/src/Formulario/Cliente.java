package Formulario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import Array.ArrayCliente;
import Array.ArrayUsuario;
import Clases.claseCliente;
import Clases.claseUsuario;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;



public class Cliente extends JFrame implements ActionListener, MouseListener, MouseMotionListener, KeyListener {


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
	private JPanel panelfondo;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnImprimir;
	private JButton btnGrabar;
	private JButton btnImagen;
	private int p;

	/**
	 * Launch the application.
	 * 
	 * 197, 11, 704, 489  table alta
	 * 197, 0, 555, 8 linea baja
	 * 197, 0, 704, 8 line alta
	 * 197, 11, 555, 489 tabla baja
	 * 901, 0, 101, 506 panelbuton baja
	 * 42, 0, 38, 45 imagen baja
	 * 901, 0, 101, 506 para el segundo panel
	 * 
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
					Cliente frame = new Cliente();
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
	public Cliente() {
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/imprimir.png"));
			ImageIcon fondo2=new ImageIcon(getClass().getResource("/img/imprimir2.png"));
		
		panelMenu = new JPanel();
		panelMenu.setVisible(true);
		
		panelAdicionar = new JPanel();
		panelAdicionar.setVisible(false);
		panelAdicionar.setOpaque(false);
		panelAdicionar.setDoubleBuffered(false);
		panelAdicionar.setBackground(new Color(70, 130, 180));
		panelAdicionar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelAdicionar.setFocusable(false);
		panelAdicionar.setFocusTraversalKeysEnabled(false);
		panelAdicionar.setBounds(852, 74, 87, 45);
		contentPane.add(panelAdicionar);
		panelAdicionar.setLayout(null);
		
		btnAdicionarr = new JButton("");
		btnAdicionarr.addActionListener(this);
		btnAdicionarr.setContentAreaFilled(false);
		btnAdicionarr.setDefaultCapable(false);
		btnAdicionarr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionarr.setFocusPainted(false);
		btnAdicionarr.setFocusTraversalKeysEnabled(false);
		btnAdicionarr.setFocusable(false);
		btnAdicionarr.setIcon(new ImageIcon(Cliente.class.getResource("/img/a\u00F1adir.png")));
		btnAdicionarr.setBounds(10, 0, 67, 45);
		panelAdicionar.add(btnAdicionarr);
		
		btnModificarr = new JButton("");
		btnModificarr.addActionListener(this);
		btnModificarr.setBounds(0, 0, 67, 45);
		panelAdicionar.add(btnModificarr);
		btnModificarr.setIcon(new ImageIcon(Cliente.class.getResource("/img/modificar.png")));
		btnModificarr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarr.setFocusable(false);
		btnModificarr.setFocusTraversalKeysEnabled(false);
		btnModificarr.setFocusPainted(false);
		btnModificarr.setDefaultCapable(false);
		btnModificarr.setContentAreaFilled(false);
		
		btnremover = new JButton("");
		btnremover.addActionListener(this);
		btnremover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnremover.setBounds(0, 0, 67, 45);
		panelAdicionar.add(btnremover);
		btnremover.setIcon(new ImageIcon(Cliente.class.getResource("/img/remover.png")));
		btnremover.setFocusable(false);
		btnremover.setFocusTraversalKeysEnabled(false);
		btnremover.setFocusPainted(false);
		btnremover.setDefaultCapable(false);
		btnremover.setContentAreaFilled(false);
		
		txtlinea = new JTextField();
		txtlinea.setVisible(false);
		txtlinea.setColumns(10);
		txtlinea.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		txtlinea.setBackground(new Color(0, 128, 0));
		txtlinea.setBounds(761, 118, 251, 8);
		contentPane.add(txtlinea);
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelMenu.setBackground(Color.BLACK);
		panelMenu.setBounds(10, 118, 197, 588);
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
		btnUsuario.setBounds(-11, 74, 186, 49);
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
		btnCliente.setBounds(-11, 136, 186, 49);
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
		btnBebida.setBounds(-11, 194, 186, 49);
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
		btncancion.setBounds(-11, 254, 186, 49);
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
		brnArtista.setBounds(-11, 312, 186, 49);
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
		btnGenero.setBounds(-11, 369, 186, 49);
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
		btnPedido.setBounds(-11, 428, 186, 49);
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
		btnPiqueo.setBounds(-11, 487, 186, 38);
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
		
		panelfondo = new JPanel();
		panelfondo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelfondo.setBackground(new Color(255, 255, 255));
		panelfondo.setBounds(10, 118, 1002, 588);
		contentPane.add(panelfondo);
		panelfondo.setLayout(null);
		
		paneldiseño = new JPanel();
		paneldiseño.setBounds(753, 11, 249, 577);
		panelfondo.add(paneldiseño);
		paneldiseño.setVisible(false);
		paneldiseño.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		paneldiseño.setLayout(null);
		
		lblDetalleDeCliente = new JLabel("Registro");
		lblDetalleDeCliente.setBounds(32, 183, 145, 14);
		paneldiseño.add(lblDetalleDeCliente);
		lblDetalleDeCliente.setForeground(SystemColor.windowBorder);
		lblDetalleDeCliente.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		paneldatos = new JPanel();
		paneldatos.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		paneldatos.setBackground(new Color(255, 255, 255));
		paneldatos.setBounds(0, 9, 249, 165);
		paneldiseño.add(paneldatos);
		paneldatos.setLayout(null);
		
		lblDetallesPersonales = new JLabel("Detalles Personales");
		lblDetallesPersonales.setForeground(SystemColor.windowBorder);
		lblDetallesPersonales.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDetallesPersonales.setBounds(36, 0, 135, 14);
		paneldatos.add(lblDetallesPersonales);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(SystemColor.windowBorder);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNombre.setBounds(0, 37, 48, 14);
		paneldatos.add(lblNombre);
		
		lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setForeground(SystemColor.windowBorder);
		lblApellidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblApellidoPaterno.setBounds(0, 62, 92, 14);
		paneldatos.add(lblApellidoPaterno);
		
		lblApellidomaterno = new JLabel("ApellidoMaterno");
		lblApellidomaterno.setForeground(SystemColor.windowBorder);
		lblApellidomaterno.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblApellidomaterno.setBounds(0, 88, 92, 14);
		paneldatos.add(lblApellidomaterno);
		
		lblDireccion = new JLabel("Correo");
		lblDireccion.setForeground(SystemColor.windowBorder);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDireccion.setBounds(0, 113, 67, 14);
		paneldatos.add(lblDireccion);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(SystemColor.windowBorder);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTelefono.setBounds(0, 138, 67, 14);
		paneldatos.add(lblTelefono);
		
		txtpa = new JTextField();
		txtpa.addKeyListener(this);
		txtpa.setForeground(Color.DARK_GRAY);
		txtpa.setBackground(SystemColor.controlHighlight);
		txtpa.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtpa.setBounds(103, 59, 136, 20);
		paneldatos.add(txtpa);
		txtpa.setColumns(10);
		
		txtM = new JTextField();
		txtM.addKeyListener(this);
		txtM.setForeground(Color.DARK_GRAY);
		txtM.setColumns(10);
		txtM.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtM.setBackground(SystemColor.controlHighlight);
		txtM.setBounds(102, 85, 136, 20);
		paneldatos.add(txtM);
		
		txtCorreo = new JTextField();
		txtCorreo.addKeyListener(this);
		txtCorreo.setForeground(Color.DARK_GRAY);
		txtCorreo.setColumns(10);
		txtCorreo.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtCorreo.setBackground(SystemColor.controlHighlight);
		txtCorreo.setBounds(103, 110, 136, 20);
		paneldatos.add(txtCorreo);
		
		txttelef = new JTextField();
		txttelef.addKeyListener(this);
		txttelef.setForeground(Color.DARK_GRAY);
		txttelef.setColumns(10);
		txttelef.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txttelef.setBackground(SystemColor.controlHighlight);
		txttelef.setBounds(103, 135, 136, 20);
		paneldatos.add(txttelef);
		
		txtN = new JTextField();
		txtN.addKeyListener(this);
		txtN.setForeground(Color.DARK_GRAY);
		txtN.setColumns(10);
		txtN.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtN.setBackground(SystemColor.controlHighlight);
		txtN.setBounds(103, 34, 136, 20);
		paneldatos.add(txtN);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 184, 249, 221);
		paneldiseño.add(panel);
		
		lblNacio = new JLabel("Nacio");
		lblNacio.setForeground(SystemColor.windowBorder);
		lblNacio.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNacio.setBounds(0, 28, 48, 14);
		panel.add(lblNacio);
		
		lblAfiliacion = new JLabel("Afiliacion");
		lblAfiliacion.setForeground(SystemColor.windowBorder);
		lblAfiliacion.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAfiliacion.setBounds(0, 65, 58, 14);
		panel.add(lblAfiliacion);
		
		lblDni = new JLabel("DNI");
		lblDni.setForeground(SystemColor.windowBorder);
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDni.setBounds(0, 99, 58, 14);
		panel.add(lblDni);
		
		lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setForeground(SystemColor.windowBorder);
		lblEstadoCivil.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEstadoCivil.setBounds(0, 124, 68, 14);
		panel.add(lblEstadoCivil);
		
		lblTipoCliente = new JLabel("Tipo Cliente");
		lblTipoCliente.setForeground(SystemColor.windowBorder);
		lblTipoCliente.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTipoCliente.setBounds(0, 152, 68, 14);
		panel.add(lblTipoCliente);
		
		lblIdusuario = new JLabel("IDUsuario\r\n");
		lblIdusuario.setForeground(SystemColor.windowBorder);
		lblIdusuario.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblIdusuario.setBounds(0, 184, 68, 14);
		panel.add(lblIdusuario);
		
		txtD = new JTextField();
		txtD.addKeyListener(this);
		txtD.setForeground(Color.DARK_GRAY);
		txtD.setColumns(10);
		txtD.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtD.setBackground(SystemColor.controlHighlight);
		txtD.setBounds(79, 96, 136, 20);
		panel.add(txtD);
		
		cmbC = new JComboBox();
		cmbC.setForeground(Color.DARK_GRAY);
		cmbC.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		cmbC.setBackground(Color.WHITE);
		cmbC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbC.setModel(new DefaultComboBoxModel(new String[] {"Soltero", "Casado", " Viudo", "Divorciado", "No especifica"}));
		cmbC.setBounds(77, 121, 138, 20);
		panel.add(cmbC);
		
		cmtipo = new JComboBox();
		cmtipo.setForeground(Color.DARK_GRAY);
		cmtipo.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		cmtipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmtipo.setModel(new DefaultComboBoxModel(new String[] {"Estandar", "Bronce", " Plata", "Oro", "Diamante"}));
		cmtipo.setBounds(77, 150, 138, 20);
		panel.add(cmtipo);
		
		cmbUsuario = new JComboBox();
		cmbUsuario.setForeground(Color.DARK_GRAY);
		cmbUsuario.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		cmbUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbUsuario.setBounds(78, 181, 138, 20);
		panel.add(cmbUsuario);
		
		nacio = new JDateChooser();
		nacio.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nacio.setForeground(Color.DARK_GRAY);
		nacio.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		nacio.setBounds(79, 28, 136, 26);
		panel.add(nacio);
		
		afiliacion = new JDateChooser();
		afiliacion.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		afiliacion.setForeground(Color.DARK_GRAY);
		afiliacion.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		afiliacion.setBounds(79, 59, 136, 26);
		panel.add(afiliacion);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 410, 249, 178);
		paneldiseño.add(panel_1);
		
		lbimagennn = new JLabel("");
		lbimagennn.setForeground(Color.WHITE);
		lbimagennn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbimagennn.setBounds(10, 11, 229, 167);
		panel_1.add(lbimagennn);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		textField.setBackground(new Color(128, 0, 0));
		textField.setBounds(-2, 175, 251, 8);
		paneldiseño.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		textField_1.setBackground(new Color(210, 105, 30));
		textField_1.setBounds(-2, 403, 251, 8);
		paneldiseño.add(textField_1);
		
		txtl = new JTextField();
		txtl.setColumns(10);
		txtl.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		txtl.setBackground(new Color(70, 130, 180));
		txtl.setBounds(197, 0, 704, 8 );
		panelfondo.add(txtl);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		scrollPane.setBounds(197, 11, 704, 489 );
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
				"ID", "IDUsuario", "Nombre", "Paterno", "Materno", "Nacio", "Afiliacion", "Direccion", "Telefono", "DNI", "Civil", "Tipo"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(33);
		table.getColumnModel().getColumn(1).setPreferredWidth(58);
		table.getColumnModel().getColumn(2).setPreferredWidth(48);
		table.getColumnModel().getColumn(3).setPreferredWidth(57);
		table.getColumnModel().getColumn(4).setPreferredWidth(56);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(55);
		table.getColumnModel().getColumn(7).setPreferredWidth(61);
		table.getColumnModel().getColumn(8).setPreferredWidth(54);
		table.getColumnModel().getColumn(9).setPreferredWidth(33);
		table.getColumnModel().getColumn(10).setPreferredWidth(38);
		table.getColumnModel().getColumn(11).setPreferredWidth(35);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
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
		btnImprimir.setBounds(222, 511, 165, 62);
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
		btnGrabar.setBounds(397, 515, 184, 56);
		btnGrabar.setIcon(new ImageIcon(getClass().getResource("/img/correo.png")));
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
		btnImagen.setBounds(591, 516, 156, 52);
		panelfondo.add(btnImagen);
		
		panelbuton = new JPanel();
		panelbuton.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelbuton.setBackground(Color.DARK_GRAY);
		panelbuton.setBounds(901, 0, 101, 588 );
		panelfondo.add(panelbuton);
		
		panelbuton.setLayout(null);
		
		btnAñadir = new JButton("");
		btnAñadir.addActionListener(this);
		btnAñadir.setContentAreaFilled(false);
		btnAñadir.setBorderPainted(false);
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadir.setFocusTraversalKeysEnabled(false);
		btnAñadir.setDefaultCapable(false);
		btnAñadir.setFocusPainted(false);
		btnAñadir.setFocusable(false);
		btnAñadir.setIcon(new ImageIcon(Cliente.class.getResource("/img/a\u00F1adir.png")));
		btnAñadir.setBounds(0, 91, 65, 45);
		panelbuton.add(btnAñadir);
		
		labelIm = new JLabel("");
		labelIm.setIcon(new ImageIcon(Cliente.class.getResource("/img/clien.png")));
		labelIm.setBounds(42, 0, 38, 45);
		panelbuton.add(labelIm);
		
		btnM = new JButton("");
		btnM.addActionListener(this);
		btnM.setIcon(new ImageIcon(Cliente.class.getResource("/img/modificar.png")));
		btnM.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnM.setFocusable(false);
		btnM.setFocusTraversalKeysEnabled(false);
		btnM.setFocusPainted(false);
		btnM.setDefaultCapable(false);
		btnM.setContentAreaFilled(false);
		btnM.setBorderPainted(false);
		btnM.setBounds(0, 172, 65, 45);
		panelbuton.add(btnM);
		
		btnE = new JButton("");
		btnE.addActionListener(this);
		btnE.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnE.setIcon(new ImageIcon(Cliente.class.getResource("/img/remover.png")));
		btnE.setFocusable(false);
		btnE.setFocusTraversalKeysEnabled(false);
		btnE.setFocusPainted(false);
		btnE.setDefaultCapable(false);
		btnE.setContentAreaFilled(false);
		btnE.setBorderPainted(false);
		btnE.setBounds(0, 251, 65, 45);
		panelbuton.add(btnE);
		
		btnN = new JButton("");
		btnN.addActionListener(this);
		btnN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnN.setIcon(new ImageIcon(Cliente.class.getResource("/img/nuevo.png")));
		btnN.setFocusable(false);
		btnN.setFocusTraversalKeysEnabled(false);
		btnN.setFocusPainted(false);
		btnN.setDefaultCapable(false);
		btnN.setContentAreaFilled(false);
		btnN.setBorderPainted(false);
		btnN.setBounds(0, 342, 55, 45);
		panelbuton.add(btnN);
		
		lblAadir = new JLabel("A\u00F1adir");
		lblAadir.setForeground(Color.WHITE);
		lblAadir.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAadir.setBounds(10, 76, 108, 14);
		panelbuton.add(lblAadir);
		
		lblModificar = new JLabel("Modificar");
		lblModificar.setForeground(Color.WHITE);
		lblModificar.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblModificar.setBounds(10, 147, 108, 14);
		panelbuton.add(lblModificar);
		
		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEliminar.setBounds(10, 226, 108, 14);
		panelbuton.add(lblEliminar);
		
		lblNuevo = new JLabel("Eliminar Todo");
		lblNuevo.setForeground(Color.WHITE);
		lblNuevo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNuevo.setBounds(10, 317, 108, 14);
		panelbuton.add(lblNuevo);
		
		label_4 = new JLabel("\u00C1COMM Karaoke");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(873, 49, 108, 14);
		contentPane.add(label_4);
		
		lblUsuarios = new JLabel("Cliente");
		lblUsuarios.setForeground(Color.WHITE);
		lblUsuarios.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUsuarios.setBounds(56, 86, 66, 14);
		contentPane.add(lblUsuarios);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Cliente.class.getResource("/img/clien.png")));
		label_3.setBounds(20, 74, 38, 45);
		contentPane.add(label_3);
		
		lb = new JLabel("");
		lb.setBounds(9, 74, 1002, 45);
		contentPane.add(lb);
		ImageIcon fondo3=new ImageIcon(getClass().getResource("/img/cuadrozul.png"));
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
		labelUsuario.addMouseMotionListener(this);
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
		modelo.addColumn("Direccion");
		modelo.addColumn("Nacio");
		modelo.addColumn("Afiliacion");
		modelo.addColumn("E.Civil");
		modelo.addColumn("Tipo");
		modelo.addColumn("DNI");
		modelo.addColumn("IDUsuario");
		modelo.addColumn("Telefono");
		table.setModel(modelo);

		
		listartabla();
		ancho();
		codigoUsuario();
		
	
		
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
		if (arg0.getSource() == btnremover) {
			do_btnremover_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnModificarr) {
			do_btnModificarr_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAdicionarr) {
			do_btnAdicionarr_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnN) {
			do_btnN_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnE) {
			do_btnE_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnM) {
			do_btnM_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAñadir) {
			do_btnAñadir_actionPerformed(arg0);
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
		if (arg0.getSource() == btnImagen) {
			do_btnImagen_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnX) {
			do_btnX_actionPerformed(arg0);
		}
	}

	private JLabel blID;
	public JPanel panelMenu;
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
	private JTextField txtl;
	private JPanel panelbuton;
	private JLabel labelIm;
	private JButton btnAñadir;
	private JButton btnM;
	private JButton btnE;
	private JButton btnN;
	private JLabel lblAadir;
	private JLabel lblModificar;
	private JLabel lblEliminar;
	private JLabel lblNuevo;
	private JPanel paneldiseño;
	private JTextField txtlinea;
	private JPanel paneldatos;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lbimagennn;
	private JLabel lblDetallesPersonales;
	private JLabel lblNombre;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidomaterno;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JLabel lblDetalleDeCliente;
	private JLabel lblNacio;
	private JLabel lblAfiliacion;
	private JLabel lblDni;
	private JLabel lblEstadoCivil;
	private JLabel lblTipoCliente;
	private JLabel lblIdusuario;
	private JTextField txtpa;
	private JTextField txtM;
	private JTextField txtCorreo;
	private JTextField txttelef;
	private JTextField txtN;
	private JTextField txtD;
	private JComboBox cmbC;
	private JComboBox cmtipo;
	private JComboBox<String> cmbUsuario;
	private JPanel panelAdicionar;
	private JButton btnAdicionarr;
	private JButton btnModificarr;
	private JButton btnremover;
	
	
	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane .getWidth() / 100;
	}
	private void ancho(){
		TableColumnModel u = table.getColumnModel();
		u.getColumn(0).setPreferredWidth(anchoColumna(33)); 
		u.getColumn(1).setPreferredWidth(anchoColumna(58)); 
		u.getColumn(2).setPreferredWidth(anchoColumna(48));  
		u.getColumn(3).setPreferredWidth(anchoColumna(57)); 
		u.getColumn(4).setPreferredWidth(anchoColumna(56));  
		u.getColumn(5).setPreferredWidth(anchoColumna(40));  
		u.getColumn(6).setPreferredWidth(anchoColumna(55));  
		u.getColumn(7).setPreferredWidth(anchoColumna(61));  
		u.getColumn(8).setPreferredWidth(anchoColumna(54));  
		u.getColumn(9).setPreferredWidth(anchoColumna(33));  
		u.getColumn(10).setPreferredWidth(anchoColumna(38));  
		u.getColumn(11).setPreferredWidth(anchoColumna(35));  
	
		

	}
	
	private void listartabla(){
		modelo.setRowCount(0);
		
		
		Connection c = null;
		try {
		
				Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		try {
	
			
	com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from cliente");
			
	ResultSet r=p.executeQuery();

modelo.setRowCount(0);
	while (r.next()) {
	modelo.addRow(new Object[]{r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),
			r.getString(8),r.getString(9),r.getInt(10),r.getString(11),r.getInt(12)});
		table.setModel(modelo);
	
claseCliente cli=new claseCliente(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),
		r.getString(8),r.getString(9),r.getInt(10),r.getString(11),r.getInt(12));
	cliente.agregar(cli);
	lbimagennn.updateUI();
		
	}
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	
		
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
				lbimagennn.setIcon(new ImageIcon(imagen.getScaledInstance(	lbimagennn.getWidth(),lbimagennn.getHeight(), imagen.SCALE_AREA_AVERAGING)));
		}
		
	}
	public void mouseClicked(MouseEvent arg0) {
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
	
ResultSetImpl r=(ResultSetImpl) s.executeQuery("select image from cliente where cod_cliente ="+cliente.obtener(p).getIDcliente());
	
if(r.next()){
	
	 Blob l=(Blob) r.getBlob("image");
	
	Image i=javax.imageio.ImageIO.read(l.getBinaryStream());
	
	lbimagennn.setIcon(new ImageIcon(i.getScaledInstance(lbimagennn.getWidth(),lbimagennn.getHeight(), i.SCALE_AREA_AVERAGING)));
}
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
	}
	
	public void mouseReleased(MouseEvent e) {
	}
	
	
	claseCliente cc=new claseCliente();
	
	protected void do_table_mouseClicked(MouseEvent arg0) {
		
		
		
		 p=table.getSelectedRow();
		 txtN.setText(cliente.obtener(p).getNombres());
		 txtpa.setText(cliente.obtener(p).getApellidoPaterno());
		 txtM.setText(cliente.obtener(p).getApellidoMaterno());
		 txtCorreo.setText(cliente.obtener(p).getDireccion());
		 txtD.setText(""+cliente.obtener(p).getDni());
		 txttelef.setText(""+cliente.obtener(p).getTelefono());
		 nacio.setDate(cc.SimpleDateFormatNacimiento(cliente.obtener(p).getFechanacimiento()));
		 afiliacion.setDate(cc.SimpleDateFormatNacimiento(cliente.obtener(p).getFechaAfiliacion()));
		cmbC.setSelectedItem(cliente.obtener(p).getEstadoCivil());
		cmtipo.setSelectedItem(cliente.obtener(p).getTipodeCliente());
		cmbUsuario.setSelectedItem(cliente.obtener(p).getUsurio());
		imagen();
		
			
			
	}
	ArrayCliente cliente=new ArrayCliente();
private void excel(){

		
		Workbook libros =new HSSFWorkbook();
		
		Sheet  hoja=libros.createSheet("hoja1");
	
		Row fila=null;
		Cell celda=null;
		
		fila=hoja.createRow(0);
		celda=fila.createCell(0);
		celda.setCellValue("Codigo");
		
		celda=fila.createCell(1);
		celda.setCellValue("Nombres");
		
		celda=fila.createCell(2);
		celda.setCellValue("Paterno");
		celda=fila.createCell(3);
		celda.setCellValue("Materno");
		
		celda=fila.createCell(4);
		celda.setCellValue("Correo");
		
		celda=fila.createCell(5);
		celda.setCellValue("Nacimiento");
		
		celda=fila.createCell(6);
		celda.setCellValue("Afiliacion");
		
		celda=fila.createCell(7);
		celda.setCellValue("Estado Civil");
		
		celda=fila.createCell(8);
		celda.setCellValue("Tipo");
		
		
		celda=fila.createCell(9);
		celda.setCellValue("Dni");
		
		celda=fila.createCell(10);
		celda.setCellValue("Usuario");
		
		celda=fila.createCell(11);
		celda.setCellValue("Telefono");
		
		
		
		
		
	
		for (int f = 0; f <table.getRowCount();f++) {
			fila=hoja.createRow(f+2);
		for (int i = 0; i < table.getRowCount(); i++) {
			
				 celda=fila.createCell(0);
			celda.setCellValue(table.getValueAt(f,0).toString());
			for (int j = 0; j < table.getRowCount(); j++) {

			 celda=fila.createCell(1);
			celda.setCellValue(table.getValueAt(f,1).toString());
			
			}
			for (int j = 0; j < table.getRowCount(); j++) {

				 celda=fila.createCell(2);
				celda.setCellValue(table.getValueAt(f,2).toString());
				
				}
			for (int j = 0; j < table.getRowCount(); j++) {

				 celda=fila.createCell(3);
				celda.setCellValue(table.getValueAt(f,3).toString());
				
				}
			for (int j = 0; j < table.getRowCount(); j++) {

				 celda=fila.createCell(4);
				celda.setCellValue(table.getValueAt(f,4).toString());
				
				}
			for (int j = 0; j < table.getRowCount(); j++) {

				 celda=fila.createCell(5);
				celda.setCellValue(table.getValueAt(f,5).toString());
				
				}
			for (int j = 0; j < table.getRowCount(); j++) {
				
				celda=fila.createCell(6);
				celda.setCellValue(table.getValueAt(f,6).toString());
				
			}
			for (int j = 0; j < table.getRowCount(); j++) {
				
				celda=fila.createCell(7);
				celda.setCellValue(table.getValueAt(f,7).toString());
				
			}
			for (int j = 0; j < table.getRowCount(); j++) {
				
				celda=fila.createCell(8);
				celda.setCellValue(table.getValueAt(f,8).toString());
				
			}
			for (int j = 0; j < table.getRowCount(); j++) {
				
				celda=fila.createCell(9);
				celda.setCellValue(table.getValueAt(f,9).toString());
				
			}
			for (int j = 0; j < table.getRowCount(); j++) {
				
				celda=fila.createCell(10);
				celda.setCellValue(table.getValueAt(f,10).toString());
				
			}
			for (int j = 0; j < table.getRowCount(); j++) {
				
				celda=fila.createCell(11);
				celda.setCellValue(table.getValueAt(f,11).toString());
				
			}
			
	}
		
	}
		
		try {
			FileOutputStream f=new FileOutputStream(new File("clientes.xls"));
			libros.write(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void do_btnGrabar_actionPerformed(ActionEvent arg0) {
		
		//tabla cliente 
		
		excel();
		

		try {
			
			 Properties props = new Properties();
	        props.put("mail.smtp.auth","true");
	        props.put("mail.smtp.starttls.enable","true");
	        props.put("mail.smtp.host","smtp.gmail.com");
	        props.put("mail.smtp.port","587");
	        
		
	        
	        Session session=Session.getDefaultInstance(props);
	        String correoremitente="arturogilserpa18@gmail.com";
	        String password="bebeconejo";
	        String receptor="arturogilserpa18@gmail.com";
	        String asunto="Registro de Clientes";
	        String mensaje="Hola<br>Resiviste la Informacion de los Clientes</br>";
	        

	        
	        
	        BodyPart body=new MimeBodyPart();
	        body.setContent(mensaje,"text/html");
	        
	        BodyPart adjunto=new MimeBodyPart();
	        adjunto.setDataHandler(new DataHandler(new FileDataSource("clientes.xls")));
	        adjunto.setFileName("Clientes.xls");
		
	        Multipart mul=new  MimeMultipart();
	        mul.addBodyPart(body);
	        mul.addBodyPart(adjunto);
	        
	        MimeMessage m=new  MimeMessage(session);
	        m.setFrom(new InternetAddress(correoremitente));
	      m.addRecipient(Message.RecipientType.TO,new InternetAddress(receptor));
	 
	      m.setSubject(asunto);
	      m.setContent(mul);
	      
	      
	      Transport t=session.getTransport("smtp");
	      t.connect(correoremitente,password);
	      t.sendMessage(m,m.getRecipients(Message.RecipientType.TO));
	      t.close();
	      JOptionPane.showMessageDialog(null,"Correo Enviado Correctamente");

		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		
		
	}
	protected void do_btnImprimir_actionPerformed(ActionEvent arg0) {
		
		
		MessageFormat header=new MessageFormat("Acomm karaoke");
		MessageFormat footer=new MessageFormat("Detalle Cliente{0,number,integer}");
		try {
			table.print(JTable.PrintMode.NORMAL, header,footer);
			
		} catch (java.awt.print.PrinterException e) {
			System.err.format("Cannot print %s%n",e.getMessage());
		}
	}
	protected void do_btnAcon_actionPerformed(ActionEvent arg0) {
		
	
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
	protected void do_btnAñadir_actionPerformed(ActionEvent arg0) {
		
		scrollPane.setBounds(197, 11, 555, 489 );
		txtl.setBounds(197, 0, 555, 8 );
		txtlinea.setVisible(true);
		
		
		panelbuton.setVisible(false);
		panelbuton.setBounds(751, 0, 251, 588 );
		paneldiseño.setVisible(true);
		paneldiseño.setBounds(753, 11, 249, 577);
		panelAdicionar.setVisible(true);
		btnAdicionarr.setVisible(true);
		btnModificarr.setVisible(false);
		btnremover.setVisible(false);
		
	}
	protected void do_btnM_actionPerformed(ActionEvent arg0) {

		scrollPane.setBounds(197, 11, 555, 489 );
		txtl.setBounds(197, 0, 555, 8 );
		txtlinea.setVisible(true);
		
		
		panelbuton.setVisible(false);
		panelbuton.setBounds(751, 0, 251, 588 );
		paneldiseño.setVisible(true);
		paneldiseño.setBounds(753, 11, 249, 577);
		panelAdicionar.setVisible(true);
		btnAdicionarr.setVisible(false);
		btnModificarr.setVisible(true);
		btnremover.setVisible(false);
		
	}
	protected void do_btnE_actionPerformed(ActionEvent arg0) {

		scrollPane.setBounds(197, 11, 555, 489 );
		txtl.setBounds(197, 0, 555, 8 );
		txtlinea.setVisible(true);
		panelbuton.setVisible(false);
		panelbuton.setBounds(751, 0, 251, 588 );
		paneldiseño.setVisible(true);
		paneldiseño.setBounds(753, 11, 249, 577);
		panelAdicionar.setVisible(true);
		btnAdicionarr.setVisible(false);
		btnModificarr.setVisible(false);
		btnremover.setVisible(true);
	}
	
	private JDateChooser nacio;
	private JDateChooser afiliacion;
	private void limpiar(){

			txtpa.setText("");
			txtM.setText("");
			txtpa.setText("");
			txttelef.setText("");
			txtD.setText("");
			txtCorreo.setText("");
			txtN.setText("");
			cmtipo.setSelectedIndex(0);
			cmbC.setSelectedIndex(0);
			cmbUsuario.setSelectedIndex(0);
			lbimagennn.setIcon(null);
		
	}
	protected void do_btnN_actionPerformed(ActionEvent arg0) {
		limpiar();

	}
	ArrayUsuario au=new ArrayUsuario();
	private void codigoUsuario() {
		 Connection c=null;
		 try {
				
				Class.forName("com.mysql.jdbc.Driver");
				c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
						
				} catch (Exception e) {
				e.getMessage();
			}
		try {
			
			com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from usuarios");
					
			ResultSet r=p.executeQuery();


			while (r.next()) {
			
			cmbUsuario.addItem(r.getString("cod_usuarios"));	
			
	
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		 
		
	}
	FileInputStream fi;
	protected void do_btnAdicionarr_actionPerformed(ActionEvent arg0) {
		txtlinea.setVisible(false);
		panelAdicionar.setVisible(false);
		paneldiseño.setVisible(false);
		panelbuton.setVisible(true);
		panelbuton.setBounds(901, 0, 101, 588 );
		scrollPane.setBounds(197, 11, 704, 489);
		txtl.setBounds(197, 0, 704, 8 );

		DateFormat formato=new SimpleDateFormat("dd/MM/YYYY");
		String  nacimiento=formato.format(nacio.getDate());
	 String afiliado=formato.format(afiliacion.getDate());
	 
	 
		if(txtCorreo.getText().matches("[-\\w\\.]+@[gmail]+.[com]+")==false){

			txtCorreo.setText("");
				JOptionPane.showMessageDialog(null,"Porfavor Ingrese Correctamente el Correo de Gmail");
			}else{

				 
				 
				 Connection c=null;
				 
				 try {
						
					Class.forName("com.mysql.jdbc.Driver");
					c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
							
					} catch (Exception e) {
					e.getMessage();
				}
				 
				 try {
			PreparedStatement p=c.prepareStatement("insert into cliente values(?,?,?,?,?,?,?,?,?,?,?,?,?)");		 
			p.setInt(1,cliente.generar());
			p.setString(2,txtN.getText());
			p.setString(3,txtpa.getText());
			p.setString(4,txtM.getText());
			p.setString(5,txtCorreo.getText());
			p.setString(6,nacimiento);
			p.setString(7,afiliado);
			p.setString(8,cmbC.getSelectedItem().toString());
			p.setString(9,cmtipo.getSelectedItem().toString());
			p.setInt(10,Integer.parseInt(txtD.getText()));
			p.setString(11,cmbUsuario.getSelectedItem().toString());
			p.setInt(12,Integer.parseInt(txttelef.getText()));
			fi=new FileInputStream(ruta);
			p.setBinaryStream(13,fi);
			p.executeUpdate();
			listartabla();

			JOptionPane.showMessageDialog(null,"Correcto");
				} catch (Exception e) {	
					e.printStackTrace();
				}
					dispose();
					new Cliente().setVisible(true);
				limpiar();
				
			}
	 
	 
		
	}
	protected void do_btnModificarr_actionPerformed(ActionEvent arg0) {
		txtlinea.setVisible(false);
		panelAdicionar.setVisible(false);
		paneldiseño.setVisible(false);
		panelbuton.setVisible(true);
		panelbuton.setBounds(901, 0, 101, 588 );
		scrollPane.setBounds(197, 11, 704, 489);
		txtl.setBounds(197, 0, 704, 8 );
	

		DateFormat formato=new SimpleDateFormat("dd/MM/YYYY");
		 String nacimiento=formato.format(nacio.getDate());
	 String afiliado=formato.format(afiliacion.getDate());
	 p=table.getSelectedRow();
	 
	 
		if(txtCorreo.getText().matches("[-\\w\\.]+@[gmail]+.[com]+")==false){

			txtCorreo.setText("");
				JOptionPane.showMessageDialog(null,"Porfavor Ingrese Correctamente el Correo de Gmail");
			}else{
				 Connection c=null;
					try {
					Class.forName("com.mysql.jdbc.Driver");
					c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				
				
				
				try {
					
				
					int codigo=cliente.obtener(p).getIDcliente();
			PreparedStatement p=c.prepareStatement("update cliente set nombre=?,apellido_paterno=?,"
					+ "apellido_materno=?,direccion=?,fecha_nacimiento=?,fecha_afilicacion=?,estado_civil=?,"
					+ "tipo_cliente=?,dni=?,cod_usuarios=?,telefono=?,image=?  where cod_cliente="+codigo
					);

			p.setString(1,txtN.getText());
			p.setString(2,txtpa.getText());
			p.setString(3,txtM.getText());
			p.setString(4,txtCorreo.getText());
			p.setString(5,nacimiento);
			p.setString(6,afiliado);
			p.setString(7,cmbC.getSelectedItem().toString());
			p.setString(8,cmtipo.getSelectedItem().toString());
			p.setInt(9,Integer.parseInt(txtD.getText()));
			p.setString(10,cmbUsuario.getSelectedItem().toString());
			p.setInt(11,Integer.parseInt(txttelef.getText()));
			fi=new FileInputStream(ruta);
			p.setBinaryStream(12,fi);
			p.executeUpdate();

			listartabla();

				} catch (Exception ex) {
					
					try {
						p=table.getSelectedRow();
					int codigo=cliente.obtener(p).getIDcliente();
					PreparedStatement p=c.prepareStatement("update cliente set nombre=?,apellido_paterno=?,"
							+ "apellido_materno=?,direccion=?,fecha_nacimiento=?,fecha_afilicacion=?,estado_civil=?,"
							+ "tipo_cliente=?,dni=?,cod_usuarios=?,telefono=? where cod_cliente="+codigo
							);
					
					
						p.setString(1,txtN.getText());
						p.setString(2,txtpa.getText());
						p.setString(3,txtM.getText());
						p.setString(4,txtCorreo.getText());
						p.setString(5,nacimiento);
						p.setString(6,afiliado);
						p.setString(7,cmbC.getSelectedItem().toString());
						p.setString(8,cmtipo.getSelectedItem().toString());
						p.setInt(9,Integer.parseInt(txtD.getText()));
						p.setString(10,cmbUsuario.getSelectedItem().toString());
						p.setInt(11,Integer.parseInt(txttelef.getText()));
						p.executeUpdate();
						listartabla();
						
				
				
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					

				}
				
				JOptionPane.showMessageDialog(null,"Datos Actulizados con exito");
					
				dispose();
				new Cliente().setVisible(true);
				
			}
	
		//limpiar();
	}
	protected void do_btnremover_actionPerformed(ActionEvent arg0) {
		txtlinea.setVisible(false);
		panelAdicionar.setVisible(false);
		paneldiseño.setVisible(false);
		panelbuton.setVisible(true);
		panelbuton.setBounds(901, 0, 101, 588 );
		scrollPane.setBounds(197, 11, 704, 489);
		txtl.setBounds(197, 0, 704, 8 );
		
		Connection c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		p=table.getSelectedRow();
		int codigo=cliente.obtener(p).getIDcliente();
		try {
	PreparedStatement p=c.prepareStatement("delete from cliente where cod_cliente="+codigo);
		
	

		int i=JOptionPane.showConfirmDialog(null,"Desea Eliminar","Eliminar", 	JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(i==JOptionPane.YES_OPTION){
	
			p.executeUpdate();
			
			listartabla();
		}
		else{
		JOptionPane.showMessageDialog(null,"exito");
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == labelUsuario) {
			mouseDraggedLabelUsuario(arg0);
		}
	}
	int x,y;
	public void mouseMoved(MouseEvent arg0) {
		

		x=arg0.getX();
		y=arg0.getY();
	}
	protected void mouseDraggedLabelUsuario(MouseEvent arg0) {
		
		Point p=MouseInfo.getPointerInfo().getLocation();
		setLocation(p.x-x, p.y-y);
			
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtCorreo) {
			keyTypedTxtCorreo(arg0);
		}
		if (arg0.getSource() == txtD) {
			keyTypedTxtD(arg0);
		}
		if (arg0.getSource() == txttelef) {
			keyTypedTxttelef(arg0);
		}
		if (arg0.getSource() == txtM) {
			keyTypedTxtM(arg0);
		}
		if (arg0.getSource() == txtpa) {
			keyTypedTxtpa(arg0);
		}
		if (arg0.getSource() == txtN) {
			keyTypedTxtN(arg0);
		}
	}
	protected void keyTypedTxtN(KeyEvent arg0) {
		if(txtN.getText().matches("\\D*")==false){
			arg0.consume();
			txtN.setText("");
			JOptionPane.showMessageDialog(null,"No se acepta Numeros");
		}
	
	}
	protected void keyTypedTxtpa(KeyEvent arg0) {
		if(txtpa.getText().matches("\\D*")==false){
			arg0.consume();
			txtpa.setText("");
			JOptionPane.showMessageDialog(null,"No se acepta Numeros");
		}
	}
	protected void keyTypedTxtM(KeyEvent arg0) {
		if(txtM.getText().matches("\\D*")==false){
			arg0.consume();
			txtM.setText("");
			JOptionPane.showMessageDialog(null,"No se acepta Numeros");
		}
	}
	protected void keyTypedTxttelef(KeyEvent arg0) {
		
		if(txttelef.getText().matches("\\d*")==false){
			arg0.consume();
			txttelef.setText("");
			JOptionPane.showMessageDialog(null,"No se acepta Letras");
		}
		if(txttelef.getText().length()==9){
			arg0.consume();
			txttelef.setText("");
			JOptionPane.showMessageDialog(null,"Se acepta 9 digitos");
		}
	}
	protected void keyTypedTxtD(KeyEvent arg0){
		if(txtD.getText().length()==8){
			arg0.consume();
			txtD.setText("");
			JOptionPane.showMessageDialog(null,"Se acepta 8 digitos");
		}
		if(txtD.getText().matches("\\d*")==false){
			arg0.consume();
			txtD.setText("");
			JOptionPane.showMessageDialog(null,"No se acepta Letras");
		}
	
	}
	protected void keyTypedTxtCorreo(KeyEvent arg0) {
	
		
		
		
		
	}
}
