package Adicionales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;

import Formulario.Acomm;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class iniciarSesion extends JFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private JLabel lbiniciarsecion;
	private JTextField txtusuario;
	private JPasswordField password;
	private JButton btnIngresar;
	private JLabel bltitulo;
	private JLabel lblIniciarSesion;
	private JButton btnSalir;

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
					iniciarSesion frame = new iniciarSesion();
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
	public iniciarSesion() {
		

		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/princi2.png"));
		   setIconImage(icon); 
		   
		setUndecorated(true);
		 this.setBackground(new Color(0,0,0,0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0,0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnIngresar = new JButton("");
		btnIngresar.setRolloverIcon(new ImageIcon(iniciarSesion.class.getResource("/img/ingresar20.png")));
		btnIngresar.setIcon(new ImageIcon(iniciarSesion.class.getResource("/img/ingresar.png")));
		btnIngresar.addActionListener(this);
		btnIngresar.addMouseListener(this);
		
		btnSalir = new JButton("Salir");
		btnSalir.setRolloverIcon(new ImageIcon(iniciarSesion.class.getResource("/img/salir10.png")));
		btnSalir.setIcon(new ImageIcon(iniciarSesion.class.getResource("/img/salir1.png")));
		btnSalir.addMouseListener(this);
		btnSalir.addActionListener(this);
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSalir.setFocusable(false);
		btnSalir.setFocusTraversalKeysEnabled(false);
		btnSalir.setFocusPainted(false);
		btnSalir.setDefaultCapable(false);
		btnSalir.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnSalir.setBackground(new Color(95, 158, 160));
		btnSalir.setBounds(359, 582, 98, 37);
		contentPane.add(btnSalir);
		
		lblIniciarSesion = new JLabel("Iniciar Sesion");
		lblIniciarSesion.setForeground(new Color(255, 255, 255));
		lblIniciarSesion.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblIniciarSesion.setBounds(199, 233, 116, 37);
		contentPane.add(lblIniciarSesion);
		
		bltitulo = new JLabel("Acomm Karaoke");
		bltitulo.setForeground(SystemColor.windowBorder);
		bltitulo.setFont(new Font("Times New Roman", Font.BOLD, 25));
		bltitulo.setBounds(153, 22, 188, 37);
		contentPane.add(bltitulo);
		btnIngresar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnIngresar.setDefaultCapable(false);
		btnIngresar.setFocusPainted(false);
		btnIngresar.setFocusTraversalKeysEnabled(false);
		btnIngresar.setFocusable(false);
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnIngresar.setBackground(new Color(178, 34, 34));
		btnIngresar.setBounds(153, 516, 205, 42);
		contentPane.add(btnIngresar);
		
		password = new JPasswordField();
		password.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		password.setForeground(Color.DARK_GRAY);
		password.setBounds(129, 443, 276, 37);
		contentPane.add(password);
		
		txtusuario = new JTextField();
		txtusuario.setForeground(Color.DARK_GRAY);
		txtusuario.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtusuario.setBounds(129, 324, 276, 37);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		lbiniciarsecion = new JLabel("");
		lbiniciarsecion.setBounds(0, 0, 495, 670);
		contentPane.add(lbiniciarsecion);
		ImageIcon fondo2=new ImageIcon(getClass().getResource("/img/iniciar Sesionn.png"));
		ImageIcon icon2=new ImageIcon(fondo2.getImage().getScaledInstance(lbiniciarsecion.getWidth(),lbiniciarsecion .getHeight(),Image.SCALE_DEFAULT));
		lbiniciarsecion.setIcon(icon2);
		
	}
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			do_btnIngresar_mouseEntered(arg0);
		}
	}
	
	public void mouseExited(MouseEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			do_btnIngresar_mouseExited(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_mouseExited(arg0);
		}
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void do_btnIngresar_mouseEntered(MouseEvent arg0) {
		btnIngresar.setBackground(new Color(210, 105, 30));
		
		
	}
	protected void do_btnIngresar_mouseExited(MouseEvent arg0) {
		btnIngresar.setBackground(new Color(178, 34, 34));
		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
	}
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		int i=JOptionPane.showConfirmDialog(null,"Desea salir","salir", JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(i==JOptionPane.YES_OPTION)
		dispose();
		else
			JOptionPane.showMessageDialog(null,"exito");
	}
	protected void do_btnSalir_mouseEntered(MouseEvent arg0) {
		btnSalir.setBackground(new Color(70, 130, 180));
	}
	protected void do_btnSalir_mouseExited(MouseEvent arg0) {
		btnSalir.setBackground(new Color(95, 158, 160));
	}
	protected void do_btnIngresar_actionPerformed(ActionEvent arg0) {
		
		Connection c = null;
		try {
		
				Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		
		
		String Usuario = null;
		String Contraseña = null;
				
		try {
			
			
			com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from seguridad");
					
			ResultSet r=p.executeQuery();

			while (r.next()) {
			
	 Usuario=r.getInt(1)+"";
	 Contraseña=r.getString(2);
				
			}
				} catch (Exception e) {
					e.printStackTrace();
				
				}

		
		
		
		
		
		String Pass=new String(password.getPassword());
		if(txtusuario.getText().equals(Usuario)&& Pass.equals(Contraseña)){
		
			
		
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

					
	 
	  

		}
		
	
	
		else{
			JOptionPane.showMessageDialog(null,"Usuario/Contraseña incorrecta","Error",JOptionPane.WARNING_MESSAGE);
		}
		
	}
}
	

