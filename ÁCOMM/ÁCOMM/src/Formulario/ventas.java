package Formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseMotionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class ventas extends JFrame implements MouseMotionListener, MouseListener, ActionListener,Printable, KeyListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panelconsumo;
	private JPanel paneldatos;
	private JPanel panelPrecios;
	private JPanel panelventa;
	private JLabel label;
	private JLabel lblNewLabel_1;
	private JLabel lblDatosDelConsumo;
	private JLabel lblConsumo;
	private JLabel lblCliente;
	private JTextField txtConsumo;
	private JTextField txtClientes;
	private JLabel lblFechaDelConsumo;
	private JLabel lblFecha;
	private JTextField txtfecha;
	private JLabel lblPrecioDelConsumo;
	private JLabel lblIdbebida;
	private JTextField txtbebida;
	private JLabel lblIdpiqueo;
	private JTextField txtpiqueo;
	private JLabel lblPrecioBebida;
	private JTextField txtpreciobebida;
	private JLabel lblPrecio;
	private JTextField txtpreciopiqueo;
	private JLabel lblPagoDelConsumo;
	private JLabel lblUsuario;
	private JComboBox cmbusuario;
	private JLabel lblTotal;
	private JTextField txttotal;
	private JLabel lblPago;
	private JTextField txtpago;
	private JButton btnprocesar;
	private JButton btnimprimir;

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
					ventas frame = new ventas();
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
	public ventas() {
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 651);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		contentPane.addMouseMotionListener(this);
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(this);
		
		label.setBounds(652, 0, 62, 51);
		ImageIcon fondo20=new ImageIcon(getClass().getResource("/img/figu.png"));
		ImageIcon icon20=new ImageIcon(fondo20.getImage().getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_DEFAULT));
		
		panelver = new JPanel();
		panelver.setVisible(false);
		
		panel = new JPanel();
		panel.setVisible(false);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setBackground(Color.BLACK);
		panel.setBounds(164, 50, 406, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		labelcliente = new JLabel("");
		labelcliente.addMouseListener(this);
		labelcliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelcliente.setIcon(new ImageIcon(ventas.class.getResource("/img/clien.png")));
		labelcliente.setForeground(Color.DARK_GRAY);
		labelcliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelcliente.setBounds(25, 5, 56, 38);
		panel.add(labelcliente);
		
		labelArtista = new JLabel("");
		labelArtista.addMouseListener(this);
		labelArtista.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelArtista.setIcon(new ImageIcon(ventas.class.getResource("/img/artis.png")));
		labelArtista.setForeground(Color.DARK_GRAY);
		labelArtista.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelArtista.setBounds(102, 5, 56, 38);
		panel.add(labelArtista);
		
		labelbebida = new JLabel("");
		labelbebida.addMouseListener(this);
		labelbebida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelbebida.setIcon(new ImageIcon(ventas.class.getResource("/img/bebida.png")));
		labelbebida.setForeground(Color.DARK_GRAY);
		labelbebida.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelbebida.setBounds(168, 5, 56, 38);
		panel.add(labelbebida);
		
		labelPiqueo = new JLabel("");
		labelPiqueo.addMouseListener(this);
		labelPiqueo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelPiqueo.setIcon(new ImageIcon(ventas.class.getResource("/img/piqueo.png")));
		labelPiqueo.setForeground(Color.DARK_GRAY);
		labelPiqueo.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelPiqueo.setBounds(246, 5, 56, 38);
		panel.add(labelPiqueo);
		
		label_Pedido = new JLabel("");
		label_Pedido.addMouseListener(this);
		label_Pedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_Pedido.setIcon(new ImageIcon(ventas.class.getResource("/img/informe.png")));
		label_Pedido.setForeground(Color.DARK_GRAY);
		label_Pedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_Pedido.setBounds(340, 5, 56, 38);
		panel.add(label_Pedido);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 69, 0));
		textField_2.setBounds(709, 60, 5, 279);
		contentPane.add(textField_2);
		panelver.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelver.setBackground(new Color(0, 0, 0));
		panelver.setBounds(523, 50, 191, 211);
		contentPane.add(panelver);
		panelver.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo.setBounds(10, 46, 54, 27);
		panelver.add(lblCodigo);
		
		cmbcodigo = new JComboBox();
		cmbcodigo.addActionListener(this);
		cmbcodigo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbcodigo.setBounds(74, 49, 107, 24);
		panelver.add(cmbcodigo);
		
		lblSlir = new JLabel("Salir");
		lblSlir.setForeground(Color.WHITE);
		lblSlir.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSlir.setBounds(10, 117, 54, 27);
		panelver.add(lblSlir);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setForeground(Color.DARK_GRAY);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(74, 117, 107, 27);
		panelver.add(btnSalir);
		
		labelbolita = new JLabel("");
		labelbolita.addMouseListener(this);
		labelbolita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelbolita.setIcon(new ImageIcon(ventas.class.getResource("/img/bolita negra.png")));
		labelbolita.setBounds(295, 11, 138, 40);
		contentPane.add(labelbolita);
		
		lblNewLabel_1 = new JLabel("Ventas");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(this);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(25, 11, 101, 33);
		contentPane.add(lblNewLabel_1);
		label.setIcon(icon20);
		contentPane.add(label);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ventas.class.getResource("/img/anaran.png")));
		lblNewLabel.setBounds(0, 0, 714, 51);
		contentPane.add(lblNewLabel);
		
		panelconsumo = new JPanel();
		panelconsumo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelconsumo.setBackground(Color.WHITE);
		panelconsumo.setBounds(10, 62, 373, 133);
		contentPane.add(panelconsumo);
		panelconsumo.setLayout(null);
		
		lblDatosDelConsumo = new JLabel("Datos del Consumo");
		lblDatosDelConsumo.setForeground(Color.DARK_GRAY);
		lblDatosDelConsumo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosDelConsumo.setBounds(21, 3, 143, 33);
		panelconsumo.add(lblDatosDelConsumo);
		
		lblConsumo = new JLabel("Consumo");
		lblConsumo.setForeground(Color.DARK_GRAY);
		lblConsumo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsumo.setBounds(10, 46, 67, 27);
		panelconsumo.add(lblConsumo);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(Color.DARK_GRAY);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCliente.setBounds(10, 95, 67, 27);
		panelconsumo.add(lblCliente);
		
		txtConsumo = new JTextField();
		txtConsumo.setEditable(false);
		txtConsumo.setBounds(87, 47, 221, 26);
		panelconsumo.add(txtConsumo);
		txtConsumo.setColumns(10);
		
		txtClientes = new JTextField();
		txtClientes.setEditable(false);
		txtClientes.setColumns(10);
		txtClientes.setBounds(87, 95, 221, 26);
		panelconsumo.add(txtClientes);
		
		paneldatos = new JPanel();
		paneldatos.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		paneldatos.setBackground(Color.WHITE);
		paneldatos.setBounds(11, 208, 372, 133);
		contentPane.add(paneldatos);
		paneldatos.setLayout(null);
		
		lblFechaDelConsumo = new JLabel("Fecha del Consumo");
		lblFechaDelConsumo.setForeground(Color.DARK_GRAY);
		lblFechaDelConsumo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaDelConsumo.setBounds(22, 11, 143, 33);
		paneldatos.add(lblFechaDelConsumo);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.DARK_GRAY);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(16, 62, 55, 27);
		paneldatos.add(lblFecha);
		
		txtfecha = new JTextField();
		txtfecha.setEditable(false);
		txtfecha.setColumns(10);
		txtfecha.setBounds(93, 62, 221, 26);
		paneldatos.add(txtfecha);
		
		panelPrecios = new JPanel();
		panelPrecios.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelPrecios.setBackground(Color.WHITE);
		panelPrecios.setBounds(393, 62, 311, 279);
		contentPane.add(panelPrecios);
		panelPrecios.setLayout(null);
		
		lblPrecioDelConsumo = new JLabel("Precio del Consumo");
		lblPrecioDelConsumo.setForeground(Color.DARK_GRAY);
		lblPrecioDelConsumo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecioDelConsumo.setBounds(21, 11, 143, 33);
		panelPrecios.add(lblPrecioDelConsumo);
		
		lblIdbebida = new JLabel("IDBebida");
		lblIdbebida.setForeground(Color.DARK_GRAY);
		lblIdbebida.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdbebida.setBounds(10, 55, 67, 27);
		panelPrecios.add(lblIdbebida);
		
		txtbebida = new JTextField();
		txtbebida.setEditable(false);
		txtbebida.setColumns(10);
		txtbebida.setBounds(87, 56, 221, 26);
		panelPrecios.add(txtbebida);
		
		lblIdpiqueo = new JLabel("IDPiqueo");
		lblIdpiqueo.setForeground(Color.DARK_GRAY);
		lblIdpiqueo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdpiqueo.setBounds(10, 141, 67, 27);
		panelPrecios.add(lblIdpiqueo);
		
		txtpiqueo = new JTextField();
		txtpiqueo.setEditable(false);
		txtpiqueo.setColumns(10);
		txtpiqueo.setBounds(87, 141, 221, 26);
		panelPrecios.add(txtpiqueo);
		
		lblPrecioBebida = new JLabel("Precio");
		lblPrecioBebida.setForeground(Color.DARK_GRAY);
		lblPrecioBebida.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecioBebida.setBounds(10, 93, 67, 27);
		panelPrecios.add(lblPrecioBebida);
		
		txtpreciobebida = new JTextField();
		txtpreciobebida.setEditable(false);
		txtpreciobebida.setColumns(10);
		txtpreciobebida.setBounds(87, 93, 221, 26);
		panelPrecios.add(txtpreciobebida);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.DARK_GRAY);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setBounds(10, 180, 67, 27);
		panelPrecios.add(lblPrecio);
		
		txtpreciopiqueo = new JTextField();
		txtpreciopiqueo.setEditable(false);
		txtpreciopiqueo.setColumns(10);
		txtpreciopiqueo.setBounds(87, 180, 221, 26);
		panelPrecios.add(txtpreciopiqueo);
		
		panelventa = new JPanel();
		panelventa.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelventa.setBackground(Color.WHITE);
		panelventa.setBounds(10, 358, 694, 266);
		contentPane.add(panelventa);
		panelventa.setLayout(null);
		
		lblPagoDelConsumo = new JLabel("Pago del Consumo");
		lblPagoDelConsumo.setForeground(Color.DARK_GRAY);
		lblPagoDelConsumo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPagoDelConsumo.setBounds(20, 11, 143, 33);
		panelventa.add(lblPagoDelConsumo);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.DARK_GRAY);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(20, 54, 55, 27);
		panelventa.add(lblUsuario);
		
		cmbusuario = new JComboBox();
		cmbusuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbusuario.setBounds(85, 55, 319, 33);
		panelventa.add(cmbusuario);
		
		lblTotal = new JLabel("Total");
		lblTotal.setForeground(Color.DARK_GRAY);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotal.setBounds(20, 106, 55, 27);
		panelventa.add(lblTotal);
		
		txttotal = new JTextField();
		txttotal.setEditable(false);
		txttotal.setColumns(10);
		txttotal.setBounds(85, 109, 319, 26);
		panelventa.add(txttotal);
		
		lblPago = new JLabel("Pago");
		lblPago.setForeground(Color.DARK_GRAY);
		lblPago.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPago.setBounds(20, 184, 55, 27);
		panelventa.add(lblPago);
		
		txtpago = new JTextField();
		txtpago.addKeyListener(this);
		txtpago.setColumns(10);
		txtpago.setBounds(85, 165, 121, 65);
		panelventa.add(txtpago);
		
		btnprocesar = new JButton("");
		btnprocesar.addActionListener(this);
		btnprocesar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnprocesar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnprocesar.setBounds(476, 68, 208, 65);
		ImageIcon fondo21=new ImageIcon(getClass().getResource("/img/procesar.png"));
		ImageIcon icon21=new ImageIcon(fondo21.getImage().getScaledInstance(btnprocesar.getWidth(),btnprocesar.getHeight(),Image.SCALE_DEFAULT));
		btnprocesar.setIcon(icon21);
		panelventa.add(btnprocesar);
		
		btnimprimir = new JButton("");
		btnimprimir.addActionListener(this);
		btnimprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnimprimir.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		
		btnimprimir.setBounds(476, 172, 208, 58);
		ImageIcon fondo22=new ImageIcon(getClass().getResource("/img/imprimir2.png"));
		ImageIcon icon22=new ImageIcon(fondo22.getImage().getScaledInstance(btnimprimir.getWidth(),btnimprimir.getHeight(),Image.SCALE_DEFAULT));
		btnimprimir.setIcon(icon22);
		panelventa.add(btnimprimir);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		textField_3.setBackground(new Color(255, 255, 255));
		textField_3.setBounds(10, 277, 674, 3);
		panelventa.add(textField_3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		textField.setBackground(new Color(255, 140, 0));
		textField.setBounds(709, 361, 5, 290);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 627, 714, 24);
		contentPane.add(textField_1);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		textField_1.setBackground(new Color(210, 105, 30));
		
		panel_datos = new JPanel();
		panel_datos.setVisible(false);
		panel_datos.setBounds(10, 60, 694, 485);
		contentPane.add(panel_datos);
		panel_datos.setLayout(null);
		
		lbconsumo = new JLabel("");
		lbconsumo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lbconsumo.setBounds(21, 11, 184, 43);
		panel_datos.add(lbconsumo);
		
		lbpiqueo = new JLabel("");
		lbpiqueo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lbpiqueo.setBounds(21, 185, 184, 43);
		panel_datos.add(lbpiqueo);
		
		lbUsuario = new JLabel("");
		lbUsuario.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lbUsuario.setBounds(21, 410, 184, 43);
		panel_datos.add(lbUsuario);
		
		lbcliente = new JLabel("");
		lbcliente.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lbcliente.setBounds(21, 65, 184, 43);
		panel_datos.add(lbcliente);
		
		lbpiqueoprecio = new JLabel("");
		lbpiqueoprecio.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lbpiqueoprecio.setBounds(21, 259, 184, 43);
		panel_datos.add(lbpiqueoprecio);
		
		lbTotal = new JLabel("");
		lbTotal.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lbTotal.setBounds(371, 11, 184, 43);
		panel_datos.add(lbTotal);
		
		lbprecio = new JLabel("");
		lbprecio.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lbprecio.setBounds(21, 131, 184, 43);
		panel_datos.add(lbprecio);
		
		lbfecha = new JLabel("");
		lbfecha.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lbfecha.setBounds(21, 336, 184, 43);
		panel_datos.add(lbfecha);
		
		lbpagado = new JLabel("");
		lbpagado.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lbpagado.setBounds(371, 81, 184, 43);
		panel_datos.add(lbpagado);
		
		lbvuelto = new JLabel("");
		lbvuelto.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lbvuelto.setBounds(371, 157, 184, 43);
		panel_datos.add(lbvuelto);
		
		
		consumos();
		usuarios();
		
		
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == contentPane) {
			mouseDraggedContentPane(arg0);
		}
	}
	
	int x,y;
	private JLabel labelbolita;
	private JPanel panel;
	private JLabel labelcliente;
	private JLabel labelArtista;
	private JLabel labelbebida;
	private JLabel labelPiqueo;
	private JLabel label_Pedido;
	private JTextField textField_2;
	private JPanel panelver;
	private JLabel lblCodigo;
	private JComboBox cmbcodigo;
	private JLabel lblSlir;
	private JButton btnSalir;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panel_datos;
	private JLabel lbconsumo;
	private JLabel lbpiqueo;
	private JLabel lbUsuario;
	private JLabel lbcliente;
	private JLabel lbpiqueoprecio;
	private JLabel lbTotal;
	private JLabel lbprecio;
	private JLabel lbfecha;
	private JLabel lbpagado;
	private JLabel lbvuelto;
	public void mouseMoved(MouseEvent arg0) {
		x=arg0.getX();
		y=arg0.getY();
	}
	protected void mouseDraggedContentPane(MouseEvent arg0) {
		
		Point p=MouseInfo.getPointerInfo().getLocation();
		setLocation(p.x-x, p.y-y);
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_Pedido) {
			mouseClickedLabel_Pedido(arg0);
		}
		if (arg0.getSource() == labelPiqueo) {
			mouseClickedLabelPiqueo(arg0);
		}
		if (arg0.getSource() == labelbebida) {
			mouseClickedLabelbebida(arg0);
		}
		if (arg0.getSource() == labelArtista) {
			mouseClickedLabelArtista(arg0);
		}
		if (arg0.getSource() == labelcliente) {
			mouseClickedLabelcliente(arg0);
		}
		if (arg0.getSource() == label) {
			mouseClickedLabel(arg0);
		}
		if (arg0.getSource() == lblNewLabel_1) {
			mouseClickedLblNewLabel_1(arg0);
		}
		if (arg0.getSource() == labelbolita) {
			mouseClickedLabelbolita(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedLabelbolita(MouseEvent arg0) {
		
		panel.setVisible(true);
		panel_datos.setVisible(false);
	}
	protected void mouseClickedLblNewLabel_1(MouseEvent arg0) {
		dispose();
		ventas v=new ventas();
		v.setVisible(true);
		v.setLocationRelativeTo(null);
		
		panel.setVisible(false);
		panelver.setVisible(false);
	}
	protected void mouseClickedLabel(MouseEvent arg0) {
		panelver.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cmbcodigo) {
			actionPerformedCmbcodigo(arg0);
		}
		if (arg0.getSource() == btnprocesar) {
			actionPerformedBtnprocesar(arg0);
		}
		if (arg0.getSource() == btnimprimir) {
			actionPerformedBtnimprimir(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
	@Override

	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

		 if (pageIndex > 0) { 
		   return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D)graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	

		panel_datos.printAll(graphics);

			

		return PAGE_EXISTS;

		
	}
	protected void actionPerformedBtnimprimir(ActionEvent arg0) {

		
		 try {
			   PrinterJob job = PrinterJob.getPrinterJob();
			   job.setPrintable(this);
			   job.printDialog();
			   job.print();
			   dispose();
				ventas v=new ventas();
				v.setVisible(true);
				v.setLocationRelativeTo(null);
				
			 } catch (PrinterException ex) {
			   ex.printStackTrace();
			 }
		

	}
	protected void actionPerformedBtnprocesar(ActionEvent arg0) {
		
		Connection c=null;
		 try {
				
				Class.forName("com.mysql.jdbc.Driver");
				c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
						
				} catch (Exception e) {
				e.getMessage();
			
		 
	}
		 
		 double  falta = 0;
		 
	 if(Integer.parseInt(txtpago.getText())<Double.parseDouble(txttotal.getText())){
			 
		 falta=Double.parseDouble(txttotal.getText())-Integer.parseInt(txtpago.getText());
		 
		 JOptionPane.showMessageDialog(null,"No se Puede Procesar Falta   "+falta);
			 
			 
	}else{
			 
		try {
			
			int cod=Integer.parseInt(cmbcodigo.getSelectedItem().toString());
			
			lbUsuario.setText("usuario     : "+cod+"");
			lbpagado.setText(" Pago con    : "+txtpago.getText());
			
	PreparedStatement p=(PreparedStatement) c.prepareStatement("delete from detalle where consumo="+cod);
			p.executeUpdate();
			 
 if(Integer.parseInt(txtpago.getText())>Double.parseDouble(txttotal.getText())){
		falta=Integer.parseInt(txtpago.getText())-Double.parseDouble(txttotal.getText());
					
			
		 
		 JOptionPane.showMessageDialog(null,"excelente su vuelto es   "+falta);
			
		}else if(Integer.parseInt(txtpago.getText())==Double.parseDouble(txttotal.getText())){
			 
			 JOptionPane.showMessageDialog(null,"excelente compra muchas gracias");
				
		}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			 
			 
			 
 }

		
		 
		 
		
	lbvuelto.setText("vuelto        :"+falta+"");
		
		
		
		
	}
	
	private void consumos(){
		
		Connection c=null;
		 try {
				
				Class.forName("com.mysql.jdbc.Driver");
				c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
						
				} catch (Exception e) {
				e.getMessage();
			
		 
	}

		 try {
				
				com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from detalle");
						
				ResultSet r=p.executeQuery();


				while (r.next()) {
				
				cmbcodigo.addItem(r.getString("consumo"));	
				
		
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			 
			 

			 
		 
		
	}
	
	
private void usuarios(){
		
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
				
				cmbusuario.addItem(r.getString("cod_usuarios"));	
				
		
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			 
			 

			 
		 
		
	}
	
	protected void mouseClickedLabelcliente(MouseEvent arg0) {
		
		Cliente c=new Cliente();
		c.setVisible(true);
		c.setLocationRelativeTo(null);
	}
	protected void mouseClickedLabelArtista(MouseEvent arg0) {
		
		Artista a=new Artista();
		a.setVisible(true);
		a.setLocationRelativeTo(null);
	}
	protected void mouseClickedLabelbebida(MouseEvent arg0) {
		
		Bebida b=new Bebida();
		b.setVisible(true);
		b.setLocationRelativeTo(null);
	}
	protected void mouseClickedLabelPiqueo(MouseEvent arg0) {
		Piqueo p=new Piqueo();
		p.setVisible(true);
		p.setLocationRelativeTo(null);
	}
	protected void mouseClickedLabel_Pedido(MouseEvent arg0) {
		Pedido pe=new Pedido();
		pe.setVisible(true);
		pe.setLocationRelativeTo(null);
	}
	
	private void consumodatos(){
		
		int codigo=Integer.parseInt(cmbcodigo.getSelectedItem().toString());
		
		Connection c=null;
		 try {
				
				Class.forName("com.mysql.jdbc.Driver");
				c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
						
				} catch (Exception e) {
				e.getMessage();
			
		 
	}
		 
			try {
				
				com.mysql.jdbc.Statement s=(com.mysql.jdbc.Statement) c.createStatement();
	
		ResultSetImpl r=(ResultSetImpl) s.executeQuery("select consumo,cod_cliente,cod_bebida,precio_bebida,cod_piqueo,precio_piqueo,fecha,total "
				+ " from detalle where consumo="+codigo);
				
			if(r.next()){
				
					txtConsumo.setText(r.getInt(1)+"");
					txtClientes.setText(r.getString(2));
					txtbebida.setText(r.getInt(3)+"");
					txtpreciobebida.setText(r.getDouble(4)+"");
					txtpiqueo.setText(r.getInt(5)+"");
					txtpreciopiqueo.setText(r.getDouble(6)+"");
					txtfecha.setText(r.getString(7));
					txttotal.setText(r.getDouble(8)+"");
				
					lbconsumo.setText("IDconsumo        :"+r.getInt(1)+"");
					lbcliente.setText("IDCliente        :"+r.getString(2));
					labelbebida.setText("IDBebida         : "+r.getInt(3)+"");
					lbprecio.setText("Precio Bebida           :  "+r.getDouble(4)+"");
					lbpiqueo.setText("IDPiqueo                 : "+r.getInt(5)+"");
					lbpiqueoprecio.setText("Precio Piqueo        :  "+r.getDouble(6)+"");
					lbfecha.setText("fecha              : "+r.getString(7));
					lbTotal.setText("Total               :  "+r.getDouble(8)+"");
					
					
					
				
					
			}
				panelver.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
					
		 
		
	}
	
	
	
	
	
	protected void actionPerformedCmbcodigo(ActionEvent arg0) {
		
		consumodatos();
		
		
		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtpago) {
			keyTypedTxtpago(e);
		}
	}
	protected void keyTypedTxtpago(KeyEvent e) {
		
		if(txtpago.getText().matches("\\d*")==false){
			e.consume();
			JOptionPane.showMessageDialog(null,"No se acepta letras ");
		}
		
	}
}
