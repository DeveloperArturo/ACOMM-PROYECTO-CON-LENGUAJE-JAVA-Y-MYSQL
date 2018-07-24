package libreria;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseMotionListener;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Properties;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;

import Formulario.Usuario;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
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
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class recuperar extends JFrame implements MouseMotionListener, MouseListener, ActionListener, KeyListener {

	private JPanel contentPane;

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
					recuperar frame = new recuperar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public recuperar() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 296);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		contentPane.setBackground(Color.WHITE);
		contentPane.addMouseMotionListener(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnsalir = new JButton("");
		btnsalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnsalir.addActionListener(this);
		btnsalir.setIcon(new ImageIcon(recuperar.class.getResource("/img/or3.png")));
		btnsalir.setRolloverEnabled(false);
		btnsalir.setRequestFocusEnabled(false);
		btnsalir.setOpaque(false);
		btnsalir.setFocusable(false);
		btnsalir.setFocusTraversalKeysEnabled(false);
		btnsalir.setFocusPainted(false);
		btnsalir.setContentAreaFilled(false);
		btnsalir.setBorderPainted(false);
		btnsalir.setBounds(303, 13, 47, 40);
		contentPane.add(btnsalir);
		
		btnrecuperar = new JButton("");
		btnrecuperar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnrecuperar.addActionListener(this);
		btnrecuperar.setIcon(new ImageIcon(recuperar.class.getResource("/img/recuperar3.png")));
		btnrecuperar.setRolloverEnabled(false);
		btnrecuperar.setRequestFocusEnabled(false);
		btnrecuperar.setFocusable(false);
		btnrecuperar.setFocusTraversalKeysEnabled(false);
		btnrecuperar.setFocusPainted(false);
		btnrecuperar.setDefaultCapable(false);
		btnrecuperar.setContentAreaFilled(false);
		btnrecuperar.setBorderPainted(false);
		btnrecuperar.setBounds(336, 11, 158, 42);
		contentPane.add(btnrecuperar);
		
		btnseguridad = new JButton("");
		btnseguridad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnseguridad.addActionListener(this);
		btnseguridad.setIcon(new ImageIcon(recuperar.class.getResource("/img/sistema2.png")));
		btnseguridad.setRolloverEnabled(false);
		btnseguridad.setRequestFocusEnabled(false);
		btnseguridad.setFocusable(false);
		btnseguridad.setFocusTraversalKeysEnabled(false);
		btnseguridad.setFocusPainted(false);
		btnseguridad.setDefaultCapable(false);
		btnseguridad.setBorderPainted(false);
		btnseguridad.setBounds(160, 10, 158, 44);
		contentPane.add(btnseguridad);
		
		txtcorreo = new JTextField();
		txtcorreo.addKeyListener(this);
		txtcorreo.addMouseListener(this);
		txtcorreo.setText("     @gmail.com");
		txtcorreo.setForeground(Color.GRAY);
		txtcorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtcorreo.setColumns(10);
		txtcorreo.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		txtcorreo.setBounds(10, 82, 482, 42);
		contentPane.add(txtcorreo);
		
		txtcodigo = new JTextField();
		txtcodigo.addKeyListener(this);
		txtcodigo.addMouseListener(this);
		txtcodigo.setText("    Codigo");
		txtcodigo.setForeground(Color.GRAY);
		txtcodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtcodigo.setColumns(10);
		txtcodigo.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		txtcodigo.setBounds(10, 135, 482, 42);
		contentPane.add(txtcodigo);
		
		btnmensaje = new JButton("");
		btnmensaje.addActionListener(this);
		btnmensaje.setIcon(new ImageIcon(recuperar.class.getResource("/img/correo2.png")));
		btnmensaje.setContentAreaFilled(false);
		btnmensaje.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnmensaje.setRolloverEnabled(false);
		btnmensaje.setRequestFocusEnabled(false);
		btnmensaje.setFocusable(false);
		btnmensaje.setFocusTraversalKeysEnabled(false);
		btnmensaje.setFocusPainted(false);
		btnmensaje.setDefaultCapable(false);
		btnmensaje.setBorderPainted(false);
		btnmensaje.setBounds(392, 229, 113, 44);
		contentPane.add(btnmensaje);
	}

	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == contentPane) {
			mouseDraggedContentPane(arg0);
		}
	}
	
	int x,y;
	private JTextField txtcorreo;
	private JTextField txtcodigo;
	private JButton btnseguridad;
	private JButton btnsalir;
	private JButton btnrecuperar;
	private JButton btnmensaje;
	public void mouseMoved(MouseEvent arg0) {
		x=arg0.getX();
		y=arg0.getY();
	}
	protected void mouseDraggedContentPane(MouseEvent arg0) {
		
		Point p=MouseInfo.getPointerInfo().getLocation();
		setLocation(p.x-x, p.y-y);
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == txtcodigo) {
			mouseClickedTxtcodigo(arg0);
		}
		if (arg0.getSource() == txtcorreo) {
			mouseClickedTxtcorreo(arg0);
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
	protected void mouseClickedTxtcorreo(MouseEvent arg0) {
			txtcorreo.setText("");
	}
	protected void mouseClickedTxtcodigo(MouseEvent arg0) {
		txtcodigo.setText("");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnmensaje) {
			actionPerformedBtnmensaje(e);
		}
		if (e.getSource() == btnseguridad) {
			actionPerformedBtnseguridad(e);
		}
		if (e.getSource() == btnsalir) {
			actionPerformedBtnsalir(e);
		}
		if (e.getSource() == btnrecuperar) {
			actionPerformedBtnrecuperar(e);
		}
	}
	protected void actionPerformedBtnrecuperar(ActionEvent e) {
		dispose();
		recuperar r=new recuperar();
		r.setVisible(true);
		r.setLocationRelativeTo(null);
		
		
	}
	protected void actionPerformedBtnsalir(ActionEvent e) {
		dispose();
		
		Usuario u=new Usuario();
		u.setVisible(true);
		u.setLocationRelativeTo(null);
	}
	protected void actionPerformedBtnseguridad(ActionEvent e) {
		
	dispose();
	seguridad s=new seguridad();
	s.setVisible(true);
	s.setLocationRelativeTo(null);
	
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtcodigo) {
			keyTypedTxtcodigo(e);
		}
		if (e.getSource() == txtcorreo) {
			keyTypedTxtcorreo(e);
		}
	}
	protected void keyTypedTxtcorreo(KeyEvent e) {
		
		
	}
	protected void keyTypedTxtcodigo(KeyEvent e) {

		if(txtcodigo.getText().matches("\\d*")==false){
			e.consume();
			JOptionPane.showMessageDialog(null,"No se acepta letras");
		}

		if(txtcodigo.getText().length()==4){
				e.consume();
				JOptionPane.showMessageDialog(null,"El Codigo solo tiene 4 digitos");
			}
		
	}
	protected void actionPerformedBtnmensaje(ActionEvent e) {
		
		
		if(txtcorreo.getText().matches("[-\\w\\.]+@[gmail]+.[com]+")==false){
			
			JOptionPane.showMessageDialog(null,"Porfavor Ingrese Correctamente el Correo de Gmail");
		}
		else{
			
			Connection c=null;
			try {
			Class.forName("com.mysql.jdbc.Driver");
			 c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
							
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			

			try {
				
			com.mysql.jdbc.Statement s=(com.mysql.jdbc.Statement) c.createStatement();
			
ResultSetImpl r=(ResultSetImpl) 
s.executeQuery("select u.cod_usuarios from usuarios u ");
			
		HashMap<Integer,String> h=new HashMap<>();
	
			
		while(r.next()){
			
			h.put(r.getInt(1),"");
		}

		
		if(h.containsKey(Integer.parseInt(txtcodigo.getText()))){
			String codigo="";
			com.mysql.jdbc.Statement s2=(com.mysql.jdbc.Statement) c.createStatement();
			
			ResultSetImpl r2=(ResultSetImpl) 
	s2.executeQuery("select u.passwor from usuarios u where u.cod_usuarios="
			+Integer.parseInt(txtcodigo.getText()));
						
			if(r2.next()){
				
				codigo=r2.getString(1);
				
			}
			
try{
			
			
			 Properties props = new Properties();
	        props.put("mail.smtp.auth","true");
	        props.put("mail.smtp.starttls.enable","true");
	        props.put("mail.smtp.host","smtp.gmail.com");
	        props.put("mail.smtp.port","587");
	        
		
	        
	        Session session=Session.getDefaultInstance(props);
	        String correoremitente=txtcorreo.getText();
	        String password="bebeconejo";
	        String receptor=txtcorreo.getText();
	        String asunto="Recuperar Password";
	        String mensaje="Hemos Resivido tus datos  tu Password de  Acomm Karaoke es   "+codigo;
	        

	        
	        
	       
	        MimeMessage m=new  MimeMessage(session);
	        m.setFrom(new InternetAddress(correoremitente));
	      m.addRecipient(Message.RecipientType.TO,new InternetAddress(receptor));
	 
	      m.setSubject(asunto);
	      m.setText(mensaje);
	      
	      
	      Transport t=session.getTransport("smtp");
	      t.connect(correoremitente,password);
	      t.sendMessage(m,m.getRecipients(Message.RecipientType.TO));
	      t.close();
	      JOptionPane.showMessageDialog(null,"Correo Enviado Correctamente");
	      
	      
	      
		
		} catch (Exception ef) {
			ef.printStackTrace();
		}
		  
			
			
			
		}else{
			
			JOptionPane.showMessageDialog(null,"El Codigo no Existe");
		}
		

		
		
			} catch (Exception ex) {
				ex.printStackTrace();

			}
		
		}
	

		
	}
}
