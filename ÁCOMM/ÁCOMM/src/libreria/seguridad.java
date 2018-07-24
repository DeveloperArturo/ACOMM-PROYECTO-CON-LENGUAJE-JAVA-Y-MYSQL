package libreria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseMotionListener;
import java.sql.DriverManager;
import java.util.HashMap;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;

import Adicionales.iniciarSesion;
import Formulario.Usuario;

import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class seguridad extends JFrame implements MouseMotionListener, MouseListener, ActionListener, KeyListener {

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
					seguridad frame = new seguridad();
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
	public seguridad() {
		setBackground(Color.WHITE);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 296);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		contentPane.setBackground(Color.WHITE);
		contentPane.addMouseMotionListener(this);
		contentPane.setBorder(new LineBorder(Color.WHITE, 6, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtcodigo = new JTextField();
		txtcodigo.addKeyListener(this);
		txtcodigo.addMouseListener(this);
		
		btnBtnsalir = new JButton("");
		btnBtnsalir.addActionListener(this);
		btnBtnsalir.setIcon(new ImageIcon(seguridad.class.getResource("/img/or2.png")));
		btnBtnsalir.setContentAreaFilled(false);
		btnBtnsalir.setBorderPainted(false);
		btnBtnsalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBtnsalir.setOpaque(false);
		btnBtnsalir.setRequestFocusEnabled(false);
		btnBtnsalir.setRolloverEnabled(false);
		btnBtnsalir.setFocusPainted(false);
		btnBtnsalir.setFocusTraversalKeysEnabled(false);
		btnBtnsalir.setFocusable(false);
		btnBtnsalir.setBounds(295, 18, 47, 35);
		contentPane.add(btnBtnsalir);
		txtcodigo.setForeground(Color.GRAY);
		txtcodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtcodigo.setText("     Codigo");
		txtcodigo.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		txtcodigo.setBounds(10, 80, 482, 42);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtpassword = new JTextField();
		txtpassword.addKeyListener(this);
		txtpassword.addMouseListener(this);
		txtpassword.setForeground(Color.GRAY);
		txtpassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpassword.setText("    Password");
		txtpassword.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		txtpassword.setColumns(10);
		txtpassword.setBounds(10, 133, 482, 42);
		contentPane.add(txtpassword);
		
		btnseguridad = new JButton("");
		btnseguridad.addActionListener(this);
		btnseguridad.setRequestFocusEnabled(false);
		btnseguridad.setRolloverEnabled(false);
		btnseguridad.setDefaultCapable(false);
		btnseguridad.setBorderPainted(false);
		btnseguridad.setIcon(new ImageIcon(seguridad.class.getResource("/img/sistema2.png")));
		btnseguridad.setFocusPainted(false);
		btnseguridad.setFocusTraversalKeysEnabled(false);
		btnseguridad.setFocusable(false);
		btnseguridad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnseguridad.setBounds(155, 11, 158, 42);
		contentPane.add(btnseguridad);
		
		btnrecuperar = new JButton("");
		btnrecuperar.addActionListener(this);
		btnrecuperar.setRequestFocusEnabled(false);
		btnrecuperar.setRolloverEnabled(false);
		btnrecuperar.setDefaultCapable(false);
		btnrecuperar.setBorderPainted(false);
		btnrecuperar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnrecuperar.setIcon(new ImageIcon(seguridad.class.getResource("/img/recuperar2.png")));
		btnrecuperar.setContentAreaFilled(false);
		btnrecuperar.setFocusable(false);
		btnrecuperar.setFocusTraversalKeysEnabled(false);
		btnrecuperar.setFocusPainted(false);
		btnrecuperar.setBounds(332, 11, 158, 42);
		contentPane.add(btnrecuperar);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(this);
		btnGuardar.setRequestFocusEnabled(false);
		btnGuardar.setRolloverEnabled(false);
		btnGuardar.setDefaultCapable(false);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setIcon(new ImageIcon(seguridad.class.getResource("/img/guardar2.png")));
		btnGuardar.setFocusable(false);
		btnGuardar.setFocusTraversalKeysEnabled(false);
		btnGuardar.setFocusPainted(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBounds(334, 197, 158, 42);
		contentPane.add(btnGuardar);
	}

	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == contentPane) {
			mouseDraggedContentPane(arg0);
		}
	}
	int x,y;
	private JTextField txtcodigo;
	private JTextField txtpassword;
	private JButton btnseguridad;
	private JButton btnrecuperar;
	private JButton btnGuardar;
	private JButton btnBtnsalir;
	
	public void mouseMoved(MouseEvent arg0) {
		x=arg0.getX();
		y=arg0.getY();
		
	}
	protected void mouseDraggedContentPane(MouseEvent arg0) {
		
		Point p=MouseInfo.getPointerInfo().getLocation();
		setLocation(p.x-x, p.y-y);
	//10, 80, 482, 42 maximo codigo
		
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == txtpassword) {
			mouseClickedTxtpassword(arg0);
		}
		if (arg0.getSource() == txtcodigo) {
			mouseClickedTxtcodigo(arg0);
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
	protected void mouseClickedTxtcodigo(MouseEvent arg0) {
		
		txtcodigo.setText("");
		
		
	}
	protected void mouseClickedTxtpassword(MouseEvent arg0) {
		
		
		txtpassword.setText("");
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(arg0);
		}
		if (arg0.getSource() == btnrecuperar) {
			actionPerformedBtnrecuperar(arg0);
		}
		if (arg0.getSource() == btnseguridad) {
			actionPerformedBtnseguridad(arg0);
		}
		if (arg0.getSource() == btnBtnsalir) {
			actionPerformedBtnBtnsalir(arg0);
		}
	}
	protected void actionPerformedBtnBtnsalir(ActionEvent arg0) {
		dispose();
	
		Usuario u=new Usuario();
		u.setVisible(true);
		u.setLocationRelativeTo(null);
		
		
	}
	protected void actionPerformedBtnseguridad(ActionEvent arg0) {
		dispose();
		seguridad s=new seguridad();
		s.setVisible(true);
		s.setLocationRelativeTo(null);
	}
	protected void actionPerformedBtnrecuperar(ActionEvent arg0) {
		
		dispose();
		recuperar r=new  recuperar();
		r.setVisible(true);
		r.setLocationRelativeTo(null);
	}

	public void modificar(){
		
		Connection c=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		 c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
		    
PreparedStatement p=(PreparedStatement)
c.prepareStatement("update seguridad s set s.users=?,s.seguro=?");

p.setInt(1,Integer.parseInt(txtcodigo.getText()));
p.setString(2,txtpassword.getText());
p.executeUpdate();

dispose();

iniciarSesion i=new iniciarSesion();
i.setVisible(true);
i.setLocationRelativeTo(null);


		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		
		Connection c=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		 c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		try {
			
		com.mysql.jdbc.Statement s=(com.mysql.jdbc.Statement) c.createStatement();
		
	ResultSetImpl r=(ResultSetImpl) s.executeQuery("select u.cod_usuarios,u.passwor from usuarios u");
		
	HashMap<Integer,String> h=new HashMap<>();
	HashMap<String,String> h2=new HashMap<>();
		
	while(r.next()){
		h.put(r.getInt(1),"");
		h2.put(r.getString(2),"");
		
	}

		if(h.containsKey(Integer.parseInt(txtcodigo.getText()))){
		if(h2.containsKey(txtpassword.getText())){
			
			modificar();
			JOptionPane.showMessageDialog(null,"Datos Actualizados correctamente");
			
		}else{
			JOptionPane.showMessageDialog(null,"La contraseña es Incorrecta");
		}
		
	}else{
		JOptionPane.showMessageDialog(null,"El Codigo es Incorrecto");
	
	
}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtpassword) {
			keyTypedTxtpassword(arg0);
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

		if(txtcodigo.getText().length()==4){
				arg0.consume();
				JOptionPane.showMessageDialog(null,"El Codigo solo tiene 4 digitos");
			}
	}
	protected void keyTypedTxtpassword(KeyEvent arg0) {
		
		//El adorno pe jajajaja
		
	}
}
