package mapas;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserContext;
import com.teamdev.jxbrowser.chromium.BrowserContextParams;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.awt.Cursor;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class google extends JFrame implements ActionListener, MouseListener ,Printable, MouseMotionListener, KeyListener{
	private JInternalFrame internalFrame;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel paneluno;
	private JPanel panel_dos;
	private JPanel paneltres;
	private JLabel lblIdcliente;
	private JLabel lblNombre;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JTextField txtcliente;
	private JTextField txtnombre;
	private JTextField txtdireccion;
	private JTextField txttelefono;
	private JLabel lblDatosDelCliente;
	private JLabel lblDatosDelUsuario;
	private JLabel lblUsuario;
	private JComboBox cmbUsuario;
	private JLabel lblFechaDeEntrega;
	private JLabel lblFecha;
	private JDateChooser date;
	private JLabel lblUbicacion;
	private JLabel lblU;
	private JTextField txtUbicacion;
	private JButton btnNewButton;
	private JButton button;
	private JLabel label_2;
	private JLabel lblKing;
	private JButton button_1;
	private JLabel lbcantidad;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox cmbcliente;
	private JLabel lblClientes;

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
					google frame = new google();
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
	public google() {
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		getContentPane().addMouseMotionListener(this);
		
		setUndecorated(true);
		
		getContentPane().setBackground(SystemColor.controlHighlight);
		getContentPane().setForeground(Color.RED);
		setBounds(100, 100, 1032, 651);
		getContentPane().setLayout(null);
		
		label_1 = new JLabel("");
		label_1.setBounds(498, 52, 46, 573);
		ImageIcon fondo2=new ImageIcon(getClass().getResource("/img/azulz.png"));
		ImageIcon icon2=new ImageIcon(fondo2.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(),Image.SCALE_DEFAULT));
		
		label_3 = new JLabel(".");
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.addMouseListener(this);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 37));
		label_3.setBounds(296, 11, 37, 25);
		getContentPane().add(label_3);
		
		label_6 = new JLabel(".");
		label_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_6.addMouseListener(this);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 37));
		label_6.setBounds(476, 11, 37, 25);
		getContentPane().add(label_6);
		
		label_5 = new JLabel(".");
		label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_5.addMouseListener(this);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 37));
		label_5.setBounds(413, 12, 37, 25);
		getContentPane().add(label_5);
		
		label_4 = new JLabel(".");
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_4.addMouseListener(this);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 37));
		label_4.setBounds(355, 12, 37, 25);
		getContentPane().add(label_4);
		
		label_7 = new JLabel(".");
		label_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_7.addMouseListener(this);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 37));
		label_7.setBounds(527, 11, 37, 25);
		getContentPane().add(label_7);
		
		lbprimero = new JLabel(".");
		lbprimero.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbprimero.addMouseListener(this);
		lbprimero.setForeground(Color.WHITE);
		lbprimero.setFont(new Font("Tahoma", Font.BOLD, 37));
		lbprimero.setBounds(249, 11, 30, 25);
		getContentPane().add(lbprimero);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(30, 144, 255));
		textField_2.setBounds(278, 269, 221, 14);
		getContentPane().add(textField_2);
		
		lblNewLabel = new JLabel("Prestamo de Instrumentos");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(this);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(29, 23, 210, 14);
		getContentPane().add(lblNewLabel);
		
		label_1.setIcon(icon2);
		getContentPane().add(label_1);
		
		label = new JLabel("");
		label.setBounds(0, 0, 1034, 55);
		getContentPane().add(label);
		ImageIcon fondo20=new ImageIcon(getClass().getResource("/img/azulz.png"));
		ImageIcon icon20=new ImageIcon(fondo20.getImage().getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_DEFAULT));
		label.setIcon(icon20);
		
		internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(538, 26, 496, 591);
		getContentPane().add(internalFrame);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setBounds(10, 66, 486, 548);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		paneluno = new JPanel();
		paneluno.setBackground(Color.WHITE);
		paneluno.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		paneluno.setBounds(0, 0, 486, 203);
		panel.add(paneluno);
		paneluno.setLayout(null);
		
		lblIdcliente = new JLabel("IDCliente");
		lblIdcliente.setForeground(Color.DARK_GRAY);
		lblIdcliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdcliente.setBounds(10, 36, 77, 14);
		paneluno.add(lblIdcliente);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 85, 77, 14);
		paneluno.add(lblNombre);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setForeground(Color.DARK_GRAY);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(241, 36, 77, 14);
		paneluno.add(lblDireccion);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.DARK_GRAY);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefono.setBounds(241, 86, 77, 14);
		paneluno.add(lblTelefono);
		
		txtcliente = new JTextField();
		txtcliente.setEditable(false);
		txtcliente.setBounds(68, 33, 147, 20);
		paneluno.add(txtcliente);
		txtcliente.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setEditable(false);
		txtnombre.setColumns(10);
		txtnombre.setBounds(68, 82, 147, 20);
		paneluno.add(txtnombre);
		
		txtdireccion = new JTextField();
		txtdireccion.setEditable(false);
		txtdireccion.setColumns(10);
		txtdireccion.setBounds(309, 33, 147, 20);
		paneluno.add(txtdireccion);
		
		txttelefono = new JTextField();
		txttelefono.setEditable(false);
		txttelefono.setColumns(10);
		txttelefono.setBounds(309, 82, 147, 20);
		paneluno.add(txttelefono);
		
		lblDatosDelCliente = new JLabel("Datos del Cliente");
		lblDatosDelCliente.setForeground(Color.DARK_GRAY);
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosDelCliente.setBounds(10, 0, 133, 14);
		paneluno.add(lblDatosDelCliente);
		
		panel_dos = new JPanel();
		panel_dos.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_dos.setBackground(Color.WHITE);
		panel_dos.setBounds(0, 214, 259, 334);
		panel.add(panel_dos);
		panel_dos.setLayout(null);
		
		lblDatosDelUsuario = new JLabel("Prestamo");
		lblDatosDelUsuario.setForeground(Color.DARK_GRAY);
		lblDatosDelUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosDelUsuario.setBounds(10, 11, 133, 14);
		panel_dos.add(lblDatosDelUsuario);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.DARK_GRAY);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(10, 91, 57, 14);
		panel_dos.add(lblUsuario);
		
		cmbUsuario = new JComboBox();
		cmbUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbUsuario.setBounds(77, 85, 162, 30);
		panel_dos.add(cmbUsuario);
		
		lblFechaDeEntrega = new JLabel("Fecha de Entrega");
		lblFechaDeEntrega.setForeground(Color.DARK_GRAY);
		lblFechaDeEntrega.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaDeEntrega.setBounds(10, 185, 133, 14);
		panel_dos.add(lblFechaDeEntrega);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.DARK_GRAY);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(10, 228, 57, 14);
		panel_dos.add(lblFecha);
		
		date = new JDateChooser();
		date.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		date.setBounds(76, 222, 163, 30);
		panel_dos.add(date);
		
		cmbcliente = new JComboBox();
		cmbcliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbcliente.addActionListener(this);
		cmbcliente.setBounds(77, 131, 162, 30);
		panel_dos.add(cmbcliente);
		
		lblClientes = new JLabel("Clientes");
		lblClientes.setForeground(Color.DARK_GRAY);
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClientes.setBounds(10, 139, 57, 14);
		panel_dos.add(lblClientes);
		
		lblCodprestamo = new JLabel("Codigo");
		lblCodprestamo.setForeground(Color.DARK_GRAY);
		lblCodprestamo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodprestamo.setBounds(10, 52, 98, 14);
		panel_dos.add(lblCodprestamo);
		
		txtcodigo = new JTextField();
		txtcodigo.addKeyListener(this);
		txtcodigo.setColumns(10);
		txtcodigo.setBounds(77, 44, 162, 30);
		panel_dos.add(txtcodigo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setBounds(77, 280, 126, 43);
		panel_dos.add(btnRegistrar);
		
		paneltres = new JPanel();
		paneltres.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		paneltres.setBackground(Color.WHITE);
		paneltres.setBounds(269, 214, 217, 334);
		panel.add(paneltres);
		paneltres.setLayout(null);
		
		lbmin = new JLabel("-");
		lbmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbmin.addMouseListener(this);
		lbmin.setBounds(196, 320, 21, 14);
		paneltres.add(lbmin);
		lbmin.setFont(new Font("Tahoma", Font.BOLD, 28));
		lbmin.setForeground(Color.DARK_GRAY);
		
		lbcantidad = new JLabel("");
		lbcantidad.setForeground(Color.WHITE);
		lbcantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbcantidad.setBounds(103, 181, 27, 14);
		paneltres.add(lbcantidad);
		
		lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setForeground(Color.DARK_GRAY);
		lblUbicacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUbicacion.setBounds(26, 11, 133, 14);
		paneltres.add(lblUbicacion);
		
		lblU = new JLabel("Ubi.");
		lblU.setForeground(Color.DARK_GRAY);
		lblU.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblU.setBounds(10, 71, 36, 14);
		paneltres.add(lblU);
		
		txtUbicacion = new JTextField();
		txtUbicacion.addKeyListener(this);
		txtUbicacion.setBounds(56, 58, 151, 39);
		paneltres.add(txtUbicacion);
		txtUbicacion.setColumns(10);
		
		btnNewButton = new JButton("Verificar");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(56, 108, 126, 43);
		paneltres.add(btnNewButton);
		
		button = new JButton("+");
		button.addActionListener(this);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBounds(56, 267, 46, 43);
		paneltres.add(button);
		
		label_2 = new JLabel("");
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.addMouseListener(this);
		label_2.setIcon(new ImageIcon(google.class.getResource("/img/kinck.png")));
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(48, 171, 144, 96);
		paneltres.add(label_2);
		
		lblKing = new JLabel("King instrumentos");
		lblKing.setForeground(Color.DARK_GRAY);
		lblKing.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKing.setBounds(10, 156, 120, 14);
		paneltres.add(lblKing);
		
		button_1 = new JButton("-");
		button_1.addActionListener(this);
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setBounds(112, 267, 46, 43);
		paneltres.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(30, 144, 255));
		textField_1.setBounds(0, 201, 262, 14);
		panel.add(textField_1);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		textField.setBackground(new Color(30, 144, 255));
		textField.setBounds(10, 50, 489, 15);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		textField_3.setBackground(new Color(0, 0, 0));
		textField_3.setBounds(0, 619, 1034, 36);
		getContentPane().add(textField_3);
		

		internalFrame.setVisible(true);
		codigoUsuario();
		codigocliente();
		 king();

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(arg0);
		}
		if (arg0.getSource() == cmbcliente) {
			actionPerformedCmbcliente(arg0);
		}
		if (arg0.getSource() == button_1) {
			actionPerformedButton_1(arg0);
		}
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_4) {
			mouseClickedLabel_4(arg0);
		}
		if (arg0.getSource() == label_3) {
			mouseClickedLabel_3(arg0);
		}
		if (arg0.getSource() == label_6) {
			mouseClickedLabel_6(arg0);
		}
		if (arg0.getSource() == lbprimero) {
			mouseClickedLbprimero(arg0);
		}
		if (arg0.getSource() == label_5) {
			mouseClickedLabel_5(arg0);
		}
		if (arg0.getSource() == label_7) {
			mouseClickedLabel_7(arg0);
		}
		if (arg0.getSource() == lblNewLabel) {
			mouseClickedLblNewLabel(arg0);
		}
		if (arg0.getSource() == lbmin) {
			mouseClickedLbmin(arg0);
		}
		if (arg0.getSource() == label_2) {
			mouseClickedLabel_2(arg0);
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
	Browser browser;
	BrowserContext context;
	private void googles(){
	
		try {
			 context= new BrowserContext(
			    	    new BrowserContextParams("D:\\data1"));

		     browser = new Browser(context);
		internalFrame.getContentPane().setLayout(null);
		BrowserView view = new BrowserView(browser);
		view.setBounds(0, 0, 484, 571);
		
		internalFrame.getContentPane().add(view);
		internalFrame.setSize(500, 600);
		internalFrame.setVisible(true);	
		browser.loadURL("https://www.google.com.pe/maps/place/"+txtUbicacion.getText());
			 
				
			
		}catch(Exception e){
			
		}

	


	}
	
	
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
	
	private void codigocliente() {
		 Connection c=null;
		 try {
				
				Class.forName("com.mysql.jdbc.Driver");
				c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
						
				} catch (Exception e) {
				e.getMessage();
			}
		try {
			
			com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from cliente");
					
			ResultSet r=p.executeQuery();


			while (r.next()) {
			
			cmbcliente.addItem(r.getString("cod_cliente"));	
			
	
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		 
		
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		
	txtUbicacion.setText(txtUbicacion.getText());
	browser.loadURL("https://www.google.com.pe/maps/place/"+txtUbicacion.getText());
		
	
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		lbcantidad.setText(Integer.parseInt(lbcantidad.getText())+1+"");
	}
	protected void actionPerformedButton_1(ActionEvent arg0) {
		
		
		lbcantidad.setText(Integer.parseInt(lbcantidad.getText())-1+"");
	}
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

		 if (pageIndex > 0) { 
		   return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D)graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	
		panel.printAll(graphics);

		return PAGE_EXISTS;

		
	}
	
	
	protected void mouseClickedLabel_2(MouseEvent arg0) {

		   try {
			   PrinterJob job = PrinterJob.getPrinterJob();
			   job.setPrintable(this);
			   job.printDialog();
			   job.print();
			 } catch (PrinterException ex) {
			   ex.printStackTrace();
			 }
		
		
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == getContentPane()) {
			mouseDraggedThisContentPane(arg0);
		}
	}
	
	
	int x,y;
	private JLabel lbmin;
	private JTextField textField_3;
	private JLabel lblCodprestamo;
	private JTextField txtcodigo;
	private JButton btnRegistrar;
	private JLabel lbprimero;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	public void mouseMoved(MouseEvent arg0) {


		x=arg0.getX();
		y=arg0.getY();
	}
	protected void mouseDraggedThisContentPane(MouseEvent arg0) {
		Point p=MouseInfo.getPointerInfo().getLocation();
		setLocation(p.x-x, p.y-y);
	}
	protected void mouseClickedLbmin(MouseEvent arg0) {
		
	
		
		
	dispose();
google g=new google();
g.setVisible(true);
g.setLocationRelativeTo(null);
		

		
		
		
		
		
	}
	protected void actionPerformedCmbcliente(ActionEvent arg0) {
		Connection c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			
			int cod=Integer.parseInt(cmbcliente.getSelectedItem().toString());
		com.mysql.jdbc.Statement s=(com.mysql.jdbc.Statement) c.createStatement();
		
	ResultSetImpl r=(ResultSetImpl) s.executeQuery("select cod_cliente,nombre,direccion,telefono from cliente where cod_cliente="+cod);
		
	if(r.next()){
		
		 
		txtcliente.setText(r.getInt(1)+"");
		txtnombre.setText(r.getString(2));
		txtdireccion.setText(r.getString(3));
		txttelefono.setText(r.getInt(4)+"");
		
		
		

	}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		
		
		
	}
	protected void mouseClickedLblNewLabel(MouseEvent arg0) {
		
		googles();
	}
	
	
	
	private void king(){
		Connection c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		try {
			
			com.mysql.jdbc.Statement s=(com.mysql.jdbc.Statement) c.createStatement();
			
		ResultSetImpl
		r=(ResultSetImpl) 
		s.executeQuery
		("select cantidad from king ");
			
		if(r.next()){
			
		lbcantidad.setText(r.getString(1));
			
			
			
		}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
	}
	
	
	protected void actionPerformedBtnRegistrar(ActionEvent arg0) {
		
		Connection c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
	PreparedStatement p=c.prepareStatement("insert into prestamo values(?,?,?,?,?)");
			
			String fecha= new SimpleDateFormat("dd/MM/yyyy").format(date.getDate());
	p.setString(1,txtcodigo.getText());
	p.setString(2,cmbUsuario.getSelectedItem().toString());
	p.setString(3,cmbcliente.getSelectedItem().toString());
	p.setString(4,fecha);
	p.setString(5,txtUbicacion.getText());
	
			p.executeUpdate();
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
		
		
		try {
		
			
PreparedStatement ps=c.prepareStatement("update king set cantidad=?");
			
		ps.setString(1,lbcantidad.getText());
				
				ps.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		txtcodigo.setText("");
		txtUbicacion.setText("");
		

		JOptionPane.showMessageDialog(null,"Registrado Correctamente");
		
		
		
		
		
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtUbicacion) {
			keyTypedTxtUbicacion(arg0);
		}
		if (arg0.getSource() == txtcodigo) {
			keyTypedTxtcodigo(arg0);
		}
	}
	protected void keyTypedTxtcodigo(KeyEvent arg0) {
		

		if(txtcodigo.getText().matches("\\d*")==false){
			arg0.consume();
			JOptionPane.showMessageDialog(null,"No se acepta letras");
		}
	
		
		
		
	}
	protected void keyTypedTxtUbicacion(KeyEvent arg0) {
		

		if(txtUbicacion.getText().matches("\\D*")==false){
			arg0.consume();
			JOptionPane.showMessageDialog(null,"No se acepta Numeros");
		}
	
	}
	protected void mouseClickedLabel_7(MouseEvent arg0) {
		
		try {
			 context= new BrowserContext(
			    	    new BrowserContextParams("D:\\data7"));

		     browser = new Browser(context);
		internalFrame.getContentPane().setLayout(null);
		BrowserView view = new BrowserView(browser);
		view.setBounds(0, 0, 484, 571);
		
		internalFrame.getContentPane().add(view);
		internalFrame.setSize(500, 600);
		internalFrame.setVisible(true);	
		browser.loadURL("https://www.google.com.pe/maps/place/"+txtUbicacion.getText());
			 
				
			
		}catch(Exception e){
			
		}
		
		
	}
	protected void mouseClickedLabel_5(MouseEvent arg0) {
		
		try {
			 context= new BrowserContext(
			    	    new BrowserContextParams("D:\\data4"));

		     browser = new Browser(context);
		internalFrame.getContentPane().setLayout(null);
		BrowserView view = new BrowserView(browser);
		view.setBounds(0, 0, 484, 571);
		
		internalFrame.getContentPane().add(view);
		internalFrame.setSize(500, 600);
		internalFrame.setVisible(true);	
		browser.loadURL("https://www.google.com.pe/maps/place/"+txtUbicacion.getText());
			 
				
			
		}catch(Exception e){
			
		}
	}
	protected void mouseClickedLbprimero(MouseEvent arg0) {

		try {
			 context= new BrowserContext(
			    	    new BrowserContextParams("D:\\data10"));

		     browser = new Browser(context);
		internalFrame.getContentPane().setLayout(null);
		BrowserView view = new BrowserView(browser);
		view.setBounds(0, 0, 484, 571);
		
		internalFrame.getContentPane().add(view);
		internalFrame.setSize(500, 600);
		internalFrame.setVisible(true);	
		browser.loadURL("https://www.google.com.pe/maps/place/"+txtUbicacion.getText());
			 
				
			
		}catch(Exception e){
			
		}
	}
	protected void mouseClickedLabel_6(MouseEvent arg0) {
		
		try {
			 context= new BrowserContext(
			    	    new BrowserContextParams("D:\\data6"));

		     browser = new Browser(context);
		internalFrame.getContentPane().setLayout(null);
		BrowserView view = new BrowserView(browser);
		view.setBounds(0, 0, 484, 571);
		
		internalFrame.getContentPane().add(view);
		internalFrame.setSize(500, 600);
		internalFrame.setVisible(true);	
		browser.loadURL("https://www.google.com.pe/maps/place/"+txtUbicacion.getText());
			 
				
			
		}catch(Exception e){
			
		}
	}
	protected void mouseClickedLabel_3(MouseEvent arg0) {
		
		try {
			 context= new BrowserContext(
			    	    new BrowserContextParams("D:\\data2"));

		     browser = new Browser(context);
		internalFrame.getContentPane().setLayout(null);
		BrowserView view = new BrowserView(browser);
		view.setBounds(0, 0, 484, 571);
		
		internalFrame.getContentPane().add(view);
		internalFrame.setSize(500, 600);
		internalFrame.setVisible(true);	
		browser.loadURL("https://www.google.com.pe/maps/place/"+txtUbicacion.getText());
			 
				
			
		}catch(Exception e){
			
		}
	}
	protected void mouseClickedLabel_4(MouseEvent arg0) {
		
		try {
			 context= new BrowserContext(
			    	    new BrowserContextParams("D:\\data3"));

		     browser = new Browser(context);
		internalFrame.getContentPane().setLayout(null);
		BrowserView view = new BrowserView(browser);
		view.setBounds(0, 0, 484, 571);
		
		internalFrame.getContentPane().add(view);
		internalFrame.setSize(500, 600);
		internalFrame.setVisible(true);	
		browser.loadURL("https://www.google.com.pe/maps/place/"+txtUbicacion.getText());
			 
				
			
		}catch(Exception e){
			
		}
	}
}
		    
		
		
		
	

