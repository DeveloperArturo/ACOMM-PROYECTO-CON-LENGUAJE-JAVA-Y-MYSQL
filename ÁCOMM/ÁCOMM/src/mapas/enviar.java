package mapas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;

import java.awt.Font;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Cursor;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class enviar extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

	private JPanel contentPane;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JLabel label_2;
	private JPanel paneldatos;
	private JPanel paneldetalle;
	private JPanel panel;
	private JTextField textField;
	private JLabel lblConsumos;
	private JLabel lblIdcliente;
	private JComboBox cmbcliente;
	private JLabel lblDetalleDeCliente;
	private JLabel lblNombre;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JTextField txtN;
	private JTextField txtP;
	private JTextField txtM;
	private JLabel lblEnviarCorreo;
	private JLabel lblDe;
	private JTextField txtacomm;
	private JLabel lblPara;
	private JTextField txtPara;
	private JLabel lblMensaje;
	private JTextArea txtmensaje;
	private JScrollPane scrollPane;
	private JLabel lblImagen;
	private JButton btnimagen;

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
					enviar frame = new enviar();
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
	public enviar() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 536);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		contentPane.addMouseMotionListener(this);
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_2 = new JLabel("");
		label_2.addMouseListener(this);
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		label_2.setBounds(748, 0, 76, 73);
		ImageIcon fondo20=new ImageIcon(getClass().getResource("/img/cubo.png"));
		ImageIcon icon20=new ImageIcon(fondo20.getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(),Image.SCALE_DEFAULT));
		label_2.setIcon(icon20);
		contentPane.add(label_2);
		
		lblNewLabel = new JLabel("Acomm Correo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(96, 22, 135, 20);
		contentPane.add(lblNewLabel);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(this);
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setIcon(new ImageIcon(enviar.class.getResource("/img/correo2.png")));
		label_1.setBounds(10, 11, 76, 43);
		contentPane.add(label_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(enviar.class.getResource("/img/verdepi.png")));
		
		label.setBounds(0, 0, 834, 59);
		contentPane.add(label);
		
		paneldatos = new JPanel();
		paneldatos.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		paneldatos.setBackground(Color.WHITE);
		paneldatos.setBounds(10, 75, 462, 213);
		contentPane.add(paneldatos);
		paneldatos.setLayout(null);
		
		lblConsumos = new JLabel("Prestamos");
		lblConsumos.setForeground(Color.DARK_GRAY);
		lblConsumos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConsumos.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lblConsumos.setBounds(22, 11, 135, 20);
		paneldatos.add(lblConsumos);
		
		lblIdcliente = new JLabel("IDCliente");
		lblIdcliente.setForeground(Color.DARK_GRAY);
		lblIdcliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdcliente.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lblIdcliente.setBounds(22, 79, 81, 20);
		paneldatos.add(lblIdcliente);
		
		cmbcliente = new JComboBox();
		cmbcliente.addActionListener(this);
		cmbcliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbcliente.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		cmbcliente.setBounds(113, 73, 279, 32);
		paneldatos.add(cmbcliente);
		
		lblImagen = new JLabel("Imagen");
		lblImagen.setForeground(Color.DARK_GRAY);
		lblImagen.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblImagen.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lblImagen.setBounds(22, 145, 81, 20);
		paneldatos.add(lblImagen);
		
		btnimagen = new JButton("Subir Archivo ");
		btnimagen.addActionListener(this);
		btnimagen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnimagen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnimagen.setForeground(Color.DARK_GRAY);
		btnimagen.setBounds(113, 135, 154, 41);
		paneldatos.add(btnimagen);
		
		paneldetalle = new JPanel();
		paneldetalle.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		paneldetalle.setBackground(Color.WHITE);
		paneldetalle.setBounds(10, 299, 462, 206);
		contentPane.add(paneldetalle);
		paneldetalle.setLayout(null);
		
		lblDetalleDeCliente = new JLabel("Detalle de Cliente");
		lblDetalleDeCliente.setForeground(Color.DARK_GRAY);
		lblDetalleDeCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDetalleDeCliente.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lblDetalleDeCliente.setBounds(10, 11, 116, 20);
		paneldetalle.add(lblDetalleDeCliente);
		
		lblNombre = new JLabel("Nombre            :");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lblNombre.setBounds(10, 56, 98, 20);
		paneldetalle.add(lblNombre);
		
		lblApellidoPaterno = new JLabel("Apellido paterno  :\r\n");
		lblApellidoPaterno.setForeground(Color.DARK_GRAY);
		lblApellidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidoPaterno.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lblApellidoPaterno.setBounds(10, 111, 125, 20);
		paneldetalle.add(lblApellidoPaterno);
		
		lblApellidoMaterno = new JLabel("Apellido Materno  :");
		lblApellidoMaterno.setForeground(Color.DARK_GRAY);
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidoMaterno.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lblApellidoMaterno.setBounds(10, 158, 125, 20);
		paneldetalle.add(lblApellidoMaterno);
		
		txtN = new JTextField();
		txtN.setEditable(false);
		txtN.setBackground(Color.WHITE);
		txtN.setBorder(new LineBorder(Color.GRAY));
		txtN.setBounds(118, 57, 156, 20);
		paneldetalle.add(txtN);
		txtN.setColumns(10);
		
		txtP = new JTextField();
		txtP.setEditable(false);
		txtP.setBackground(Color.WHITE);
		txtP.setBorder(new LineBorder(Color.GRAY));
		txtP.setColumns(10);
		txtP.setBounds(118, 112, 156, 20);
		paneldetalle.add(txtP);
		
		txtM = new JTextField();
		txtM.setEditable(false);
		txtM.setBackground(Color.WHITE);
		txtM.setBorder(new LineBorder(Color.GRAY));
		txtM.setColumns(10);
		txtM.setBounds(118, 159, 156, 20);
		paneldetalle.add(txtM);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setBackground(Color.WHITE);
		panel.setBounds(482, 70, 342, 435);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblEnviarCorreo = new JLabel("Enviar Correo");
		lblEnviarCorreo.setForeground(Color.DARK_GRAY);
		lblEnviarCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnviarCorreo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lblEnviarCorreo.setBounds(131, 11, 114, 20);
		panel.add(lblEnviarCorreo);
		
		lblDe = new JLabel("De");
		lblDe.setForeground(Color.DARK_GRAY);
		lblDe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDe.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lblDe.setBounds(27, 68, 27, 20);
		panel.add(lblDe);
		
		txtacomm = new JTextField();
		txtacomm.setColumns(10);
		txtacomm.setBorder(new LineBorder(Color.GRAY));
		txtacomm.setBackground(Color.WHITE);
		txtacomm.setBounds(67, 56, 246, 32);
		panel.add(txtacomm);
		
		lblPara = new JLabel("Para");
		lblPara.setForeground(Color.DARK_GRAY);
		lblPara.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPara.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lblPara.setBounds(27, 111, 27, 20);
		panel.add(lblPara);
		
		txtPara = new JTextField();
		txtPara.setEditable(false);
		txtPara.setColumns(10);
		txtPara.setBorder(new LineBorder(Color.GRAY));
		txtPara.setBackground(Color.WHITE);
		txtPara.setBounds(67, 99, 246, 32);
		panel.add(txtPara);
		
		lblMensaje = new JLabel("Mensaje");
		lblMensaje.setForeground(Color.DARK_GRAY);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMensaje.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		lblMensaje.setBounds(27, 153, 85, 20);
		panel.add(lblMensaje);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		scrollPane.setBounds(10, 173, 332, 251);
		panel.add(scrollPane);
		
		txtmensaje = new JTextArea();
		txtmensaje.setBorder(new LineBorder(new Color(128, 128, 128), 0));
		txtmensaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setViewportView(txtmensaje);
		
		textField = new JTextField();
		textField.setBackground(Color.BLACK);
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		textField.setBounds(0, 505, 834, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		codigocliente();
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_1) {
			mouseClickedLabel_1(arg0);
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
	protected void mouseClickedLabel_2(MouseEvent arg0) {
		dispose();
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
			
			com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from prestamo");
					
			ResultSet r=p.executeQuery();


			while (r.next()) {
			
			cmbcliente.addItem(r.getString("cod_cliente"));	
			
	
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	protected void mouseClickedLabel_1(MouseEvent arg0) {


		if(txtacomm.getText().matches("[-\\w\\.]+@[gmail]+.[com]+")==false){
			
			txtacomm.setText("");
			JOptionPane.showMessageDialog(null,"Porfavor Ingrese Correctamente el Correo de Gmail");
		}else{
			try {
				
				 Properties props = new Properties();
		        props.put("mail.smtp.auth","true");
		        props.put("mail.smtp.starttls.enable","true");
		        props.put("mail.smtp.host","smtp.gmail.com");
		        props.put("mail.smtp.port","587");
		        
			
		        
		        Session session=Session.getDefaultInstance(props);
		        String correoremitente="arturogilserpa18@gmail.com";
		        String password="bebeconejo";
		        String receptor=txtPara.getText();
		        String asunto="Acomm Correo";
		        String mensaje=txtmensaje.getText();
		        

		        
		        
		        BodyPart body=new MimeBodyPart();
		        body.setContent(mensaje,"text/html");
		        
		        BodyPart adjunto=new MimeBodyPart();
		        adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta)));
		        adjunto.setFileName("Karaoke.png");
			
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

	
		
		
		
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == contentPane) {
			mouseDraggedContentPane(arg0);
		}
	}
	

	int x,y;
	public void mouseMoved(MouseEvent arg0) {
		x=arg0.getX();
		y=arg0.getY();
	}
	protected void mouseDraggedContentPane(MouseEvent arg0) {
		
		Point p=MouseInfo.getPointerInfo().getLocation();
		setLocation(p.x-x, p.y-y);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cmbcliente) {
			actionPerformedCmbcliente(arg0);
		}
		if (arg0.getSource() == btnimagen) {
			actionPerformedBtnimagen(arg0);
		}
	}
	String ruta;
	protected void actionPerformedBtnimagen(ActionEvent arg0) {
		

		
		JFileChooser busca=new JFileChooser();
		
		FileNameExtensionFilter estension=new FileNameExtensionFilter("Seleccionar imagen","jpg","png");
		busca.setFileFilter(estension);
		
		
		if(busca.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
				Toolkit tool=Toolkit.getDefaultToolkit();
				 ruta=busca.getSelectedFile().toString();
				Image imagen=tool.createImage(ruta);
				
		}
		
		
		
		
		
	}
	
	
	protected void actionPerformedCmbcliente(ActionEvent arg0) {
		
		
		 Connection c=null;
		 try {
				
				Class.forName("com.mysql.jdbc.Driver");
				c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
						
				} catch (Exception e) {
				e.getMessage();
			}
		 

			try {
				int codigo=Integer.parseInt(cmbcliente.getSelectedItem().toString());
				
			com.mysql.jdbc.Statement s=(com.mysql.jdbc.Statement) c.createStatement();
			
		ResultSetImpl r=(ResultSetImpl) s.executeQuery("select nombre,apellido_paterno,apellido_materno,"
				+ "direccion from cliente where cod_cliente="+codigo);
			
		if(r.next()){
			
			 txtN.setText("      "+r.getString(1));
			 txtP.setText("      "+r.getString(2));
			 txtM.setText("      "+r.getString(3));
			 txtPara.setText("      "+r.getString(4));
			
		}
			}catch(Exception e){
				
			}
	}
			
}

