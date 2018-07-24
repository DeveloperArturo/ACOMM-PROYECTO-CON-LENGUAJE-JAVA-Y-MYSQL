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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JCalendar;

import Array.ArrayBebida;
import Array.ArrayUsuario;
import Array.ArryPiqueo;
import Array.arraycancion;
import Array.arraypedido;
import Clases.claseUsuario;
import Clases.claseartista;
import Clases.clasepedido;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Pedido extends JFrame implements  ActionListener, MouseListener, MouseMotionListener, KeyListener {


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
	private JPanel panel;
	private JLabel lbdatos;
	private JPanel panelfondo;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblApellidoMaterno;
	private JButton btnImprimir;
	private JButton btnGrabar;
	private JButton btnAñadir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private int s;

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
					Pedido frame = new Pedido();
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
	public Pedido() {
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
		contentPane.addMouseMotionListener(this);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/imprimir.png"));
			ImageIcon fondo2=new ImageIcon(getClass().getResource("/img/imprimir2.png"));
		ImageIcon fondo10=new ImageIcon(getClass().getResource("/img/paginaWeb.png"));
		
		panelMenu = new JPanel();
		panelMenu.setBounds(10, 118, 261, 574);
		contentPane.add(panelMenu);
		panelMenu.setVisible(true);
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelMenu.setBackground(Color.BLACK);
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
		btnUsuario.setBounds(-11, 74, 248, 49);
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
		btnCliente.setBounds(-11, 136, 248, 49);
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
		btnBebida.setBounds(-11, 194, 248, 49);
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
		btncancion.setBounds(-11, 254, 248, 49);
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
		brnArtista.setBounds(-11, 312, 248, 49);
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
		btnGenero.setBounds(-11, 369, 248, 49);
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
		btnPedido.setBounds(-11, 428, 248, 49);
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
		
		panelfondo = new JPanel();
		panelfondo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelfondo.setBackground(SystemColor.control);
		panelfondo.setBounds(10, 118, 1002, 574);
		contentPane.add(panelfondo);
		panelfondo.setLayout(null);
		
		label_5 = new JLabel("");
		label_5.setBounds(261, 164, 743, 40);
		panelfondo.add(label_5);
		ImageIcon fondo5=new ImageIcon(getClass().getResource("/img/cadrorojo.png"));
		ImageIcon icon5=new ImageIcon(fondo5.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(),Image.SCALE_DEFAULT));
		label_5.setIcon(icon5);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(Color.WHITE, 3));
		scrollPane.setBounds(264, 201, 738, 309);
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
				"ID", "IDGenero", "Nombre", "Fecha de Registro", "Estado"
			}
		));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		label_4 = new JLabel("\u00C1COMM Karaoke");
		label_4.setForeground(new Color(165, 42, 42));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(873, 49, 108, 14);
		contentPane.add(label_4);
		
		lblUsuarios = new JLabel("Pedidos");
		lblUsuarios.setForeground(Color.WHITE);
		lblUsuarios.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUsuarios.setBounds(56, 86, 66, 14);
		contentPane.add(lblUsuarios);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Pedido.class.getResource("/img/informe.png")));
		label_3.setBounds(20, 74, 38, 45);
		contentPane.add(label_3);
		
		lb = new JLabel("");
		lb.setBounds(9, 74, 1002, 45);
		contentPane.add(lb);
		ImageIcon fondo3=new ImageIcon(getClass().getResource("/img/cadrorojo.png"));
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
		
	
		
		btnImprimir = new JButton("");
		btnImprimir.setBounds(267, 512, 147, 61);
		panelfondo.add(btnImprimir);
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
		
		panel = new JPanel();
		panel.setBounds(264, 0, 738, 177);
		panelfondo.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setLayout(null);
		
		lbdatos = new JLabel("Detalle de Pedido\r\n");
		lbdatos.setForeground(SystemColor.windowBorder);
		lbdatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbdatos.setBounds(37, 11, 101, 14);
		panel.add(lbdatos);
		
		lblApellidoMaterno = new JLabel("Estado");
		lblApellidoMaterno.setForeground(SystemColor.windowBorder);
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidoMaterno.setBounds(10, 68, 112, 14);
		panel.add(lblApellidoMaterno);
		
		cmbE = new JComboBox();
		cmbE.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbE.setModel(new DefaultComboBoxModel(new String[] {"Habilitado", "Inhabilitado"}));
		cmbE.setFont(new Font("Times New Roman", Font.BOLD, 13));
		cmbE.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		cmbE.setBounds(127, 62, 143, 27);
		panel.add(cmbE);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		textField.setBackground(SystemColor.controlHighlight);
		textField.setBounds(287, 0, 4, 151);
		panel.add(textField);
		
		lblFechaDePedido = new JLabel("Fecha de Pedido");
		lblFechaDePedido.setForeground(SystemColor.windowBorder);
		lblFechaDePedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaDePedido.setBounds(328, 11, 101, 14);
		panel.add(lblFechaDePedido);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(SystemColor.windowBorder);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(301, 49, 46, 14);
		panel.add(lblFecha);
		
		fechaPedido = new JCalendar();
		fechaPedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fechaPedido.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		fechaPedido.setWeekdayForeground(SystemColor.windowBorder);
		fechaPedido.setForeground(SystemColor.windowBorder);
		fechaPedido.setDecorationBackgroundColor(Color.WHITE);
		fechaPedido.setBounds(338, 31, 190, 116);
		panel.add(fechaPedido);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		textField_1.setBackground(SystemColor.controlHighlight);
		textField_1.setBounds(538, 0, 4, 151);
		panel.add(textField_1);
		
		lblIdusuario = new JLabel("IDUsuario");
		lblIdusuario.setForeground(SystemColor.windowBorder);
		lblIdusuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdusuario.setBounds(550, 11, 56, 14);
		panel.add(lblIdusuario);
		
		cmbU = new JComboBox();
		cmbU.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbU.setFont(new Font("Times New Roman", Font.BOLD, 13));
		cmbU.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		cmbU.setBounds(613, 8, 115, 27);
		panel.add(cmbU);
		
		lblCancion_1 = new JLabel("Cancion");
		lblCancion_1.setForeground(SystemColor.windowBorder);
		lblCancion_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCancion_1.setBounds(550, 53, 56, 14);
		panel.add(lblCancion_1);
		
		txtC = new JTextField();
		txtC.addKeyListener(this);
		txtC.setForeground(SystemColor.windowBorder);
		txtC.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtC.setColumns(10);
		txtC.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtC.setBackground(SystemColor.controlHighlight);
		txtC.setBounds(610, 46, 118, 28);
		panel.add(txtC);
		
		lblBebida_1 = new JLabel("Bebida");
		lblBebida_1.setForeground(SystemColor.windowBorder);
		lblBebida_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBebida_1.setBounds(550, 85, 56, 14);
		panel.add(lblBebida_1);
		
		txtBe = new JTextField();
		txtBe.addKeyListener(this);
		txtBe.setForeground(SystemColor.windowBorder);
		txtBe.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtBe.setColumns(10);
		txtBe.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtBe.setBackground(SystemColor.controlHighlight);
		txtBe.setBounds(610, 82, 118, 28);
		panel.add(txtBe);
		
		lblPiqueos = new JLabel("Piqueos");
		lblPiqueos.setForeground(SystemColor.windowBorder);
		lblPiqueos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPiqueos.setBounds(550, 124, 56, 14);
		panel.add(lblPiqueos);
		
		txtPiqueo = new JTextField();
		txtPiqueo.addKeyListener(this);
		txtPiqueo.setForeground(SystemColor.windowBorder);
		txtPiqueo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtPiqueo.setColumns(10);
		txtPiqueo.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtPiqueo.setBackground(SystemColor.controlHighlight);
		txtPiqueo.setBounds(610, 117, 118, 28);
		panel.add(txtPiqueo);
		
		btnGrabar = new JButton("");
		btnGrabar.setBounds(422, 517, 182, 52);
		panelfondo.add(btnGrabar);
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(Pedido.class.getResource("/img/correo.png")));
		btnGrabar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGrabar.setFocusable(false);
		btnGrabar.setFocusTraversalKeysEnabled(false);
		btnGrabar.setFocusPainted(false);
		btnGrabar.setDefaultCapable(false);
		btnGrabar.setContentAreaFilled(false);
		btnGrabar.setBorderPainted(false);
		
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setBounds(903, 521, 89, 52);
		panelfondo.add(btnAñadir);
		btnAñadir.addActionListener(this);
		btnAñadir.setIcon(new ImageIcon(Usuario.class.getResource("/img/a\u00F1adir.png")));
		btnAñadir.setFocusPainted(false);
		btnAñadir.setFocusTraversalKeysEnabled(false);
		btnAñadir.setFocusable(false);
		btnAñadir.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadir.setForeground(SystemColor.windowBorder);
		btnAñadir.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(791, 521, 102, 52);
		panelfondo.add(btnModificar);
		btnModificar.addActionListener(this);
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setIcon(new ImageIcon(Usuario.class.getResource("/img/modificar.png")));
		btnModificar.setForeground(SystemColor.windowBorder);
		btnModificar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnModificar.setFocusable(false);
		btnModificar.setFocusTraversalKeysEnabled(false);
		btnModificar.setFocusPainted(false);
		btnModificar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(685, 521, 96, 52);
		panelfondo.add(btnEliminar);
		btnEliminar.addActionListener(this);
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setIcon(new ImageIcon(Usuario.class.getResource("/img/remover.png")));
		btnEliminar.setForeground(SystemColor.windowBorder);
		btnEliminar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnEliminar.setFocusable(false);
		btnEliminar.setFocusTraversalKeysEnabled(false);
		btnEliminar.setFocusPainted(false);
		btnEliminar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(609, 521, 66, 52);
		panelfondo.add(btnNuevo);
		btnNuevo.addActionListener(this);
		btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevo.setIcon(new ImageIcon(Usuario.class.getResource("/img/nuevo.png")));
		btnNuevo.setForeground(SystemColor.windowBorder);
		btnNuevo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNuevo.setFocusable(false);
		btnNuevo.setFocusTraversalKeysEnabled(false);
		btnNuevo.setFocusPainted(false);
		btnNuevo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		
		modelo=new DefaultTableModel();
		modelo.addColumn("IDPedido");
		modelo.addColumn("Fecha Pedido");
		modelo.addColumn("IDUsuario");
		modelo.addColumn("Hora reserva");
		modelo.addColumn("Estado");
		modelo.addColumn("Canciones");
		modelo.addColumn("Bebidas");
		modelo.addColumn("Piqueos");
		table.setModel(modelo);
		
		ancho();
		listartabla();
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
		if (arg0.getSource() == btnAñadir) {
			do_btnAñadir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnX) {
			do_btnX_actionPerformed(arg0);
		}
	}

	private JLabel blID;
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
	private JLabel label_5;
	private JTextField textField;
	private JLabel lblFechaDePedido;
	private JLabel lblFecha;
	private JCalendar fechaPedido;
	private JTextField textField_1;
	private JLabel lblIdusuario;
	private JComboBox cmbU;
	private JLabel lblCancion_1;
	private JTextField txtC;
	private JLabel lblBebida_1;
	private JTextField txtBe;
	private JLabel lblPiqueos;
	private JTextField txtPiqueo;
	
	
	
	
	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane .getWidth() / 100;
	}
	private void ancho(){
		TableColumnModel u = table.getColumnModel();
		u.getColumn(0).setPreferredWidth(anchoColumna(39)); 
		u.getColumn(1).setPreferredWidth(anchoColumna(63)); 
		u.getColumn(2).setPreferredWidth(anchoColumna(58));  
		u.getColumn(3).setPreferredWidth(anchoColumna(101)); 
		u.getColumn(4).setPreferredWidth(anchoColumna(59));  
		u.getColumn(5).setPreferredWidth(anchoColumna(59));  
		u.getColumn(6).setPreferredWidth(anchoColumna(59));  
		u.getColumn(7).setPreferredWidth(anchoColumna(59));  
		

	}
	
	arraypedido pedido=new arraypedido();
	ArrayBebida abb=new ArrayBebida();
	arraycancion ac=new arraycancion();

	ArryPiqueo api=new ArryPiqueo();
	private void listartabla(){

		Connection c = null;
		try {
		
				Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
try {

			com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from pedido");
					
			ResultSet r=p.executeQuery();
		
		modelo.setRowCount(0);
			while (r.next()) {
	modelo.addRow(new Object[]{r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),
			r.getInt(6),r.getInt(7),r.getInt(8)});
		table.setModel(modelo);
			
	clasepedido u=new clasepedido(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),
			r.getInt(6),r.getInt(7),r.getInt(8));
		pedido.agregar(u);
	
				
			}
				} catch (Exception e) {
				
				
				}
	
		
	}
		
	protected void do_btnX_actionPerformed(ActionEvent arg0) {
		int i=JOptionPane.showConfirmDialog(null,"Desea salir","salir", JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(i==JOptionPane.YES_OPTION)
		dispose();
		else
			JOptionPane.showMessageDialog(null,"exito");
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
				
				cmbU.addItem(r.getString("cod_usuarios"));	
				
		
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			 
		
		
		
	}	

	private String  hora(){
		 String lahora = null;
		Calendar calendario= new GregorianCalendar();
		Date horas=new Date();
		calendario.setTime(horas);
		String hora=calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
		String minuto=calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
	String 	segundo=calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
		
		return lahora=hora+":"+minuto+":"+segundo;
	}
	private int cancion(){
		Connection c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		int cancion=Integer.parseInt(txtC.getText());
		try {
			
			Statement st=(Statement) c.createStatement();
			ResultSet r=st.executeQuery("select count(c.cod_cancion) from cancion c");
		
			if(r.next()){
				
			if(cancion<=r.getInt("count(c.cod_cancion")){
			cancion=Integer.parseInt(txtC.getText());
			}else{
			
			JOptionPane.showMessageDialog(null,"Paso el limite de la cancion");
			cancion=0;
			limpiar();
	
		}
		}
			
		
		
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cancion;
	}
	private int piqueo(){
		Connection c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		int piqueo=Integer.parseInt(txtPiqueo.getText());
		try {
			
			Statement st=(Statement) c.createStatement();
			ResultSet r=st.executeQuery("select count(c.cod_piqueo) from piqueo c");
		
			if(r.next()){
				
			if(piqueo<=r.getInt("count(c.cod_piqueo)")){
				
			
			piqueo=Integer.parseInt(txtPiqueo.getText());
			}else{
			
			JOptionPane.showMessageDialog(null,"Paso el limite de la piqueo");
			piqueo=0;
			limpiar();
	
		}
			
		}
			
		
		
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return piqueo;
	}
	private int bebida(){
		Connection c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		int bebida=Integer.parseInt(txtBe.getText());
		try {
			
			Statement st=(Statement) c.createStatement();
			ResultSet r=st.executeQuery("select count(c.cod_bebida) from bebida c");
		
			if(r.next()){
				
			if(bebida<=r.getInt("count(c.cod_bebida)")){
				bebida=Integer.parseInt(txtBe.getText());
			}else{
			
			JOptionPane.showMessageDialog(null,"Paso el limite de la bebida");
			bebida=0;
			limpiar();
	
		}
		}
			
		
		
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bebida;
	}
	protected void do_btnAñadir_actionPerformed(ActionEvent arg0) {
		DateFormat formato=new SimpleDateFormat("dd/MM/YYYY");
		 String pedidofecha=formato.format(fechaPedido.getDate());
		
		 
		 Connection c=null;
		
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
			
		} catch (Exception e) {
			e.getMessage();
		}
	
		 

		try {
			PreparedStatement ps=c.prepareStatement("insert into pedido values(?,?,?,?,?,?,?,?)");
				ps.setInt(1,pedido.generar());
				ps.setString(2,pedidofecha);
				ps.setString(3,cmbU.getSelectedItem().toString());
				ps.setString(4,hora());
				ps.setString(5,cmbE.getSelectedItem().toString());
				ps.setInt(6,cancion());
				ps.setInt(7,bebida());
				ps.setInt(8,piqueo());
				ps.executeUpdate();
				
				listartabla();
				JOptionPane.showMessageDialog(null,"Correcto");
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			}
			
			dispose();
			new Pedido() .setVisible(true);
				

	
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
		
		
		s=table.getSelectedRow();
		int codigo=pedido.obtener(s).getIDPedido();
		try {
	PreparedStatement p=c.prepareStatement("delete from pedido where cod_pedido="+codigo);
		
		int i=JOptionPane.showConfirmDialog(null,"Desea Eliminar","Eliminar", JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(i==JOptionPane.YES_OPTION){
	
		p.executeUpdate();
		listartabla();
		}
		else{
			JOptionPane.showMessageDialog(null,"exito");
		}
		}catch(Exception ex){
			
		}
		
		
		
	}
	protected void do_btnModificar_actionPerformed(ActionEvent arg0) {
		DateFormat formato=new SimpleDateFormat("dd/MM/YYYY");
		 String pedidofecha=formato.format(fechaPedido.getDate());
		
		 s=table.getSelectedRow();
		 Connection c=null;
			try {
			Class.forName("com.mysql.jdbc.Driver");
			c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
			} catch (Exception e) {
				e.printStackTrace();
			}
try {
				
	
	/*
	 	cod_pedido int,
    fecha_pedido varchar(100),
    cod_usuario varchar(40),
    hora_reserva varchar (100),
    estado varchar (200),
    cancion int,
    bebida int,
    piqueo int
	 */
			s=table.getSelectedRow();
					int codigo=pedido.obtener(s).getIDPedido();
		PreparedStatement ps=c.prepareStatement("update pedido  set fecha_pedido=?,cod_usuario=?,"
		+ "estado=?,cancion=?,bebida=?,piqueo=?  where cod_pedido="+codigo
					);
			ps.setString(1,pedidofecha);
			ps.setString(2,cmbU.getSelectedItem().toString());
			ps.setString(3,cmbE.getSelectedItem().toString());
			ps.setInt(4,cancion());
			ps.setInt(5,bebida());
			ps.setInt(6,piqueo());
			ps.executeUpdate();
			listartabla();
				
			
			JOptionPane.showMessageDialog(null,"Datos Actulizados con exito");

				}catch(Exception e){
					JOptionPane.showMessageDialog(null,"error");
				}
				
				

				
				dispose();
				new Pedido().setVisible(true);

		
		
		
	}
	private void limpiar(){
		cmbU.setSelectedIndex(0);
		cmbE.setSelectedIndex(0);
		txtBe.setText("");
		txtC.setText("");
		txtPiqueo.setText("");
	
		
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
	public void mouseReleased(MouseEvent e) {
	}
	
	
	
	clasepedido cp=new clasepedido();
	protected void do_table_mouseClicked(MouseEvent arg0) {
		s=table.getSelectedRow();
		fechaPedido.setDate(cp.SimpleDateFormat(pedido.obtener(s).getFechaPedido()));
		txtPiqueo.setText(""+pedido.obtener(s).getPiqueos());
		txtBe.setText(""+pedido.obtener(s).getBebidas());
		txtC.setText(""+pedido.obtener(s).getCanciones());
		cmbU.setSelectedItem(pedido.obtener(s).getIDUsuario());
		cmbE.setSelectedItem(pedido.obtener(s).getEstado());
			
			
	}
	private void excel(){

		Workbook libros =new HSSFWorkbook();
		
		Sheet  hoja=libros.createSheet("hoja1");
	
		Row fila=null;
		Cell celda=null;
		
		fila=hoja.createRow(0);
		celda=fila.createCell(0);
		celda.setCellValue("Codigo");
		
		celda=fila.createCell(1);
		celda.setCellValue("Pedido");
		
		celda=fila.createCell(2);
		celda.setCellValue("Usuario");
		
		celda=fila.createCell(3);
		celda.setCellValue("hora");
		
		celda=fila.createCell(4);
		celda.setCellValue("estado");
		
		celda=fila.createCell(5);
		celda.setCellValue("cancion");
		
		celda=fila.createCell(6);
		celda.setCellValue("bebida");
		
		celda=fila.createCell(7);
		celda.setCellValue("piqueo");
		
		
		
		
	
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
			
			
	}
		
	}
		
		try {
			FileOutputStream f=new FileOutputStream(new File("pedido.xls"));
			libros.write(f);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void do_btnGrabar_actionPerformed(ActionEvent arg0) {
		
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
	        String asunto="Registro de Pedidos";
	        String mensaje="Hola<br>Resiviste la Informacion de los Pedidos</br>";
	        

	        
	        
	        BodyPart body=new MimeBodyPart();
	        body.setContent(mensaje,"text/html");
	        
	        BodyPart adjunto=new MimeBodyPart();
	        adjunto.setDataHandler(new DataHandler(new FileDataSource("pedido.xls")));
	        adjunto.setFileName("Pedidos.xls");
		
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
		MessageFormat footer=new MessageFormat("Detalle Usuario{0,number,integer}");
		try {
			table.print(JTable.PrintMode.NORMAL, header,footer);
			dispose();
		} catch (java.awt.print.PrinterException e) {
			System.err.format("Cannot print %s%n",e.getMessage());
		}
		
	
		
		
	}
	protected void do_btnAcon_actionPerformed(ActionEvent arg0) {
		
	
	}
	
	protected void do_btnxx_actionPerformed(ActionEvent arg0) {
	
		
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
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == contentPane) {
			mouseDraggedContentPane(e);
		}
	}
	int x,y;
	public void mouseMoved(MouseEvent e) {
		x=e.getX();
		y=e.getY();
	}
	protected void mouseDraggedContentPane(MouseEvent e) {
		Point p=MouseInfo.getPointerInfo().getLocation();
		setLocation(p.x-x, p.y-y);
	}
	protected void actionPerformedBtnmini(ActionEvent arg0) {
		setExtendedState(1);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtPiqueo) {
			keyTypedTxtPiqueo(e);
		}
		if (e.getSource() == txtBe) {
			keyTypedTxtBe(e);
		}
		if (e.getSource() == txtC) {
			keyTypedTxtC(e);
		}
	}
	protected void keyTypedTxtC(KeyEvent e) {
		if(txtC.getText().matches("\\d*")==false){
			e.consume();
			JOptionPane.showMessageDialog(null,"No se acepta Letras");
		}
	}
	protected void keyTypedTxtBe(KeyEvent e) {
		if(txtBe.getText().matches("\\d*")==false){
			e.consume();
			JOptionPane.showMessageDialog(null,"No se acepta Letras");
		}
	}
	protected void keyTypedTxtPiqueo(KeyEvent e) {
		if(txtPiqueo.getText().matches("\\d*")==false){
			e.consume();
			JOptionPane.showMessageDialog(null,"No se acepta Letras");
		}
	}
}
