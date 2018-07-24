package Formulario;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Desktop;
import javax.swing.border.LineBorder;
import Adicionales.calculadora;
import Clase.ventana;
import Imprimir.UsuarioImprimir;
import mapas.enviar;
import mapas.google;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Acomm extends JFrame implements ActionListener, MouseListener,MouseMotionListener {
	
	
	private JPanel contentPane;
	private JButton btnX;
	private JLabel lblX;
	private JButton button_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblHayVariosTipos;
	private JLabel lblHayVariosTipos_1;
	private JLabel lblHayVariosTipos_2;
	private JLabel lblcommKaraoke;
	private JButton btnLogo;
	private JButton btnCE;
	private JButton btnCalcu;
	private JButton btnP;
	private JButton btnPedido;
	private JButton btnUsu;
	private JButton btnAr;
	private JButton btnGe;
	private JButton btnSugeren;
	private JButton btnCan;
	private JButton btnUsuario;
	private JButton btnCliente;
	private JButton btnBebida;
	private JButton btnPiqueo;
	private JButton btnInforme;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_5;
	private JButton btnMan;
	private JLabel labelM;
	private JButton btnRP;
	private JLabel label_6;
	private JButton btnRC;
	private JButton btnMPC;
	private JLabel label_7;
	private JLabel label_8;
	private JButton btnApli;
	private JLabel labelcuerpo;
	public JLabel Carrusel;
	public static int velmil;
	public  static int contador;
	private Object lahora;
	private Object hora;
	private Object minuto;
	private Object segundo;
	private JLabel lbHora;
	 Thread  h1;
	 private JLabel laUsuario;
	 private JLabel lbCliente;
	 private JLabel lbBebida;
	 private JLabel lBPiqueo;
	 private JLabel Lbinforme;
	 private JButton btnFacebo;
	 private JButton btnTwiter;
	 private JLabel lbusuarios;
	 private JLabel lbAr;
	 private JLabel lbgenero;
	 private JLabel lbCancion;
	 private JLabel lbsugerencia;
	 public static Timer timer;
	 public static TimerTask tarea;
	 private JButton btnMultimedia;
	 private JButton btnPiqueos;
	 private Point i;
	 private int x,y;
	 
	/**
	 *  Dise�ador Arturo Gil Serpa
	 */
	public static void main(String[] args) {
		try {

			
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		Acomm t = new Acomm();
		t.setVisible(true);
		t.setLocationRelativeTo(null);
		
	
		EventQueue.invokeLater(new Runnable() {
			

			public void run() {
					
					
					
				try {
					

					
					
					 velmil=3000;
					
					tarea =new TimerTask(){
					

						public void run(){
							
						
							
							switch (contador) {
							case 0:
									contador=1;
									ImageIcon fondo=new ImageIcon(getClass().getResource("/img/music.png"));
									ImageIcon iconos=new ImageIcon(fondo.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel.getHeight(),Image.SCALE_DEFAULT));
									t.Carrusel.setIcon(iconos);
								break;

							case 1:
								contador=2;
								ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/cancion.jpg"));
								ImageIcon iconos1=new ImageIcon(fondo1.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel .getHeight(),Image.SCALE_DEFAULT));
								t.Carrusel.setIcon(iconos1);
								
								break;
							case 2:
								contador=3;
								ImageIcon fondo2=new ImageIcon(getClass().getResource("/img/noches.png"));
								ImageIcon iconos2=new ImageIcon(fondo2.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel .getHeight(),Image.SCALE_DEFAULT));
								t.Carrusel.setIcon(iconos2);
								break;
							case 3:
								contador=4;
								ImageIcon fondo3=new ImageIcon(getClass().getResource("/img/arcoiris.png"));
								ImageIcon iconos3=new ImageIcon(fondo3.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel .getHeight(),Image.SCALE_DEFAULT));
								t.Carrusel.setIcon(iconos3);
								break;
								
							case 4:
							contador=0;
							ImageIcon fondo4=new ImageIcon(getClass().getResource("/img/estrella.png"));
							ImageIcon iconos4=new ImageIcon(fondo4.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel .getHeight(),Image.SCALE_DEFAULT));
							t.Carrusel.setIcon(iconos4);
							break;
							
						
						}
							
					}
					
					
					
					};
					
					
					timer=new Timer();
					
					timer.scheduleAtFixedRate(tarea, velmil, velmil);
				

					
				}

						
		
				
					

			 catch (Exception e) {
				e.printStackTrace();
			
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Acomm() {
		
		

	
		setUndecorated(true);
		setTitle("ACOMM");
		final int ANCHO = 1000,
		          ALTO = 650,
		          DX = 8,
		          DY = 53;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((getToolkit().getScreenSize().width - ANCHO - DX) / 2,
				  (getToolkit().getScreenSize().height - ALTO - DY) / 2,
				   ANCHO + DX, ALTO + DY);

		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/princi2.png"));
		   setIconImage(icon);
		
		
		
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(this);
		contentPane.addMouseListener(this);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnX = new JButton("");
		
		btnX.setRolloverIcon(new ImageIcon(Acomm.class.getResource("/img/negro.png")));
		btnX.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnX.setBorderPainted(false);
		btnX.setContentAreaFilled(false);
		btnX.setIcon(new ImageIcon(Acomm.class.getResource("/img/btnx.png")));
		btnX.setFocusPainted(false);
		btnX.setFocusTraversalKeysEnabled(false);
		btnX.setFocusable(false);
		btnX.addActionListener(this);
		
		label_5 = new JLabel("");
		label_5.setVisible(false);
		
		btnMan = new JButton("     Mantenimiento");
		btnMan.addActionListener(this);
		btnMan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMan.addMouseListener(this);
		
		btnRP = new JButton("  Registro De Pedido");
		btnRP.addActionListener(this);
		btnRP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRP.addMouseListener(this);
		
		label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Acomm.class.getResource("/img/tri2.png")));
		label_6.setVisible(false);
		
		btnRC = new JButton("  Registro De Consumo\r\n");
		btnRC.addActionListener(this);
		btnRC.addMouseListener(this);
		
		label_7 = new JLabel("");
		label_7.setVisible(false);
		
		label_8 = new JLabel("");
		label_8.setVisible(false);
		ImageIcon fondo5=new ImageIcon(getClass().getResource("/img/micro.png"));
		
		btnMultimedia = new JButton("");
		btnMultimedia.addActionListener(this);
		btnMultimedia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMultimedia.setRolloverEnabled(false);
		btnMultimedia.setRequestFocusEnabled(false);
		btnMultimedia.setFocusable(false);
		btnMultimedia.setFocusTraversalKeysEnabled(false);
		btnMultimedia.setFocusPainted(false);
		btnMultimedia.setDefaultCapable(false);
		btnMultimedia.setContentAreaFilled(false);
		btnMultimedia.setBorderPainted(false);
		btnMultimedia.setBounds(255, 373, 140, 136);
		ImageIcon fondo40=new ImageIcon(getClass().getResource("/img/Multime.png"));
		ImageIcon icon40=new ImageIcon(fondo40.getImage().getScaledInstance(btnMultimedia.getWidth(), btnMultimedia.getHeight(),Image.SCALE_DEFAULT));
		btnMultimedia.setIcon(icon40);
		btnPiqueos = new JButton("");
		btnPiqueos.addActionListener(this);
		btnPiqueos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPiqueos.setRolloverEnabled(false);
		btnPiqueos.setRequestFocusEnabled(false);
		btnPiqueos.setFocusable(false);
		btnPiqueos.setFocusTraversalKeysEnabled(false);
		btnPiqueos.setFocusPainted(false);
		btnPiqueos.setDefaultCapable(false);
		btnPiqueos.setContentAreaFilled(false);
		btnPiqueos.setBorderPainted(false);
		btnPiqueos.setBounds(438, 360, 165, 149);
		ImageIcon fondo41=new ImageIcon(getClass().getResource("/img/carrito.png"));
		ImageIcon icon41=new ImageIcon(fondo41.getImage().getScaledInstance(btnPiqueos.getWidth(), 	btnPiqueos.getHeight(),Image.SCALE_DEFAULT));
		btnPiqueos.setIcon(icon41);
		contentPane.add(btnPiqueos);
		
		
		contentPane.add(btnMultimedia);
		
		lbsugerencia = new JLabel("");
		lbsugerencia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbsugerencia.setIcon(new ImageIcon(Acomm.class.getResource("/img/sugerencia.png")));
		lbsugerencia.setBounds(962, 149, 36, 41);
		contentPane.add(lbsugerencia);
		
		lbCancion = new JLabel("");
		lbCancion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbCancion.setIcon(new ImageIcon(Acomm.class.getResource("/img/canc.png")));
		lbCancion.setBounds(915, 149, 31, 41);
		contentPane.add(lbCancion);
		
		lbgenero = new JLabel("");
		lbgenero.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbgenero.setIcon(new ImageIcon(Acomm.class.getResource("/img/genero.png")));
		lbgenero.setBounds(107, 153, 33, 31);
		contentPane.add(lbgenero);
		
		lbAr = new JLabel("");
		lbAr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbAr.setIcon(new ImageIcon(Acomm.class.getResource("/img/artis.png")));
		lbAr.setBounds(63, 152, 27, 31);
		contentPane.add(lbAr);
		
		lbusuarios = new JLabel("");
		lbusuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbusuarios.setIcon(new ImageIcon(Acomm.class.getResource("/img/usuarioss.png")));
		lbusuarios.setBounds(19, 151, 27, 31);
		contentPane.add(lbusuarios);
		
		btnTwiter = new JButton("");
		btnTwiter.addActionListener(this);
		btnTwiter.setIcon(new ImageIcon(Acomm.class.getResource("/img/twiter.png")));
		btnTwiter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTwiter.setFocusable(false);
		btnTwiter.setFocusTraversalKeysEnabled(false);
		btnTwiter.setFocusPainted(false);
		btnTwiter.setDefaultCapable(false);
		btnTwiter.setContentAreaFilled(false);
		btnTwiter.setBorderPainted(false);
		btnTwiter.setBounds(937, 645, 49, 45);
		contentPane.add(btnTwiter);
		
		btnFacebo = new JButton("");
		btnFacebo.addActionListener(this);
		btnFacebo.setDefaultCapable(false);
		btnFacebo.setFocusPainted(false);
		btnFacebo.setFocusTraversalKeysEnabled(false);
		btnFacebo.setFocusable(false);
		btnFacebo.setContentAreaFilled(false);
		btnFacebo.setBorderPainted(false);
		btnFacebo.setIcon(new ImageIcon(Acomm.class.getResource("/img/facebook.png")));
		btnFacebo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFacebo.setBounds(874, 647, 49, 45);
		contentPane.add(btnFacebo);
		
		Lbinforme = new JLabel("");
		Lbinforme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Lbinforme.setIcon(new ImageIcon(Acomm.class.getResource("/img/informe.png")));
		Lbinforme.setBounds(707, 645, 51, 41);
		contentPane.add(Lbinforme);
		
		lBPiqueo = new JLabel("");
		lBPiqueo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lBPiqueo.setIcon(new ImageIcon(Acomm.class.getResource("/img/piqueo.png")));
		lBPiqueo.setBounds(526, 654, 51, 28);
		contentPane.add(lBPiqueo);
		
		lbBebida = new JLabel("");
		lbBebida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbBebida.setIcon(new ImageIcon(Acomm.class.getResource("/img/bebida.png")));
		lbBebida.setBounds(342, 651, 38, 31);
		contentPane.add(lbBebida);
		
		lbCliente = new JLabel("");
		lbCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbCliente.setIcon(new ImageIcon(Acomm.class.getResource("/img/clien.png")));
		lbCliente.setBounds(170, 651, 38, 31);
		contentPane.add(lbCliente);
		
		laUsuario = new JLabel("");
		laUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		laUsuario.setIcon(new ImageIcon(Acomm.class.getResource("/img/usuar.png")));
		laUsuario.setBounds(32, 654, 38, 28);
		contentPane.add(laUsuario);
		
		lbHora = new JLabel("");
		lbHora.setForeground(Color.WHITE);
		lbHora.setBounds(800, 44, 81, 28);
		contentPane.add(lbHora);
		
		Carrusel = new JLabel("");
	
		Carrusel.setForeground(Color.WHITE);
		Carrusel.setFont(new Font("Dialog", Font.BOLD, 11));
		Carrusel.setBounds(645, 201, 341, 302);
		contentPane.add(Carrusel);
		ImageIcon fondo20=new ImageIcon(getClass().getResource("/img/music.png"));
		ImageIcon icon20=new ImageIcon(fondo20.getImage().getScaledInstance(Carrusel.getWidth(), Carrusel.getHeight(),Image.SCALE_DEFAULT));
		Carrusel.setIcon(icon20);
		
	
		
		btnApli = new JButton("");
		btnApli.setBorderPainted(false);
		btnApli.setDefaultCapable(false);
		btnApli.setContentAreaFilled(false);
		btnApli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnApli.setFocusPainted(false);
		btnApli.setFocusTraversalKeysEnabled(false);
		btnApli.setFocusable(false);
		btnApli.setIcon(new ImageIcon(Acomm.class.getResource("/img/figu.png")));
		btnApli.setBounds(10, 86, 60, 45);
		contentPane.add(btnApli);
		label_8.setIcon(new ImageIcon(Acomm.class.getResource("/img/tri4.png")));
		label_8.setBounds(716, 129, 60, 41);
		contentPane.add(label_8);
		label_7.setIcon(new ImageIcon(Acomm.class.getResource("/img/tri3.png")));
		label_7.setBounds(514, 128, 49, 42);
		contentPane.add(label_7);
		
		btnMPC = new JButton("Registro de Pago");
		btnMPC.addActionListener(this);
		btnMPC.addMouseListener(this);
		btnMPC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMPC.setForeground(Color.WHITE);
		btnMPC.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMPC.setFocusable(false);
		btnMPC.setFocusTraversalKeysEnabled(false);
		btnMPC.setFocusPainted(false);
		btnMPC.setContentAreaFilled(false);
		btnMPC.setBorderPainted(false);
		btnMPC.setBounds(664, 83, 162, 46);
		contentPane.add(btnMPC);
		btnRC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRC.setForeground(Color.WHITE);
		btnRC.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRC.setFocusable(false);
		btnRC.setFocusTraversalKeysEnabled(false);
		btnRC.setFocusPainted(false);
		btnRC.setContentAreaFilled(false);
		btnRC.setBorderPainted(false);
		btnRC.setBounds(438, 86, 198, 46);
		contentPane.add(btnRC);
		label_6.setBounds(319, 128, 49, 42);
		contentPane.add(label_6);
		btnRP.setForeground(Color.WHITE);
		btnRP.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRP.setFocusable(false);
		btnRP.setFocusTraversalKeysEnabled(false);
		btnRP.setFocusPainted(false);
		btnRP.setContentAreaFilled(false);
		btnRP.setBorderPainted(false);
		btnRP.setBounds(255, 86, 177, 46);
		contentPane.add(btnRP);
		
		labelM = new JLabel("");
		labelM.setIcon(new ImageIcon(Acomm.class.getResource("/img/maa.png")));
		labelM.setBounds(94, 95, 32, 31);
		contentPane.add(labelM);
		btnMan.setForeground(Color.WHITE);
		btnMan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMan.setFocusable(false);
		btnMan.setFocusTraversalKeysEnabled(false);
		btnMan.setFocusPainted(false);
		btnMan.setContentAreaFilled(false);
		btnMan.setBorderPainted(false);
		btnMan.setBounds(90, 86, 162, 46);
		contentPane.add(btnMan);
		label_5.setIcon(new ImageIcon(Acomm.class.getResource("/img/tri.png")));
		label_5.setBounds(150, 124, 48, 49);
		contentPane.add(label_5);
		
		label_3 = new JLabel("\u00C1COMM Karaoke");
		label_3.setForeground(new Color(165, 42, 42));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(891, 50, 108, 14);
		contentPane.add(label_3);
		
		label_2 = new JLabel("");
		label_2.setBounds(10, 86, 989, 44);
		contentPane.add(label_2);
		ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/men.png"));
		ImageIcon icon1=new ImageIcon(fondo1.getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(),Image.SCALE_DEFAULT));
		label_2.setIcon(icon1);
		
		btnInforme = new JButton("Informe");
		btnInforme.addActionListener(this);
		btnInforme.setBorderPainted(false);
		btnInforme.setContentAreaFilled(false);
		btnInforme.setDefaultCapable(false);
		btnInforme.setFocusPainted(false);
		btnInforme.setFocusTraversalKeysEnabled(false);
		btnInforme.setFocusable(false);
		btnInforme.setForeground(Color.WHITE);
		btnInforme.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnInforme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInforme.setBounds(714, 654, 162, 28);
		contentPane.add(btnInforme);
		
		btnPiqueo = new JButton("Piqueos");
		btnPiqueo.addActionListener(this);
		btnPiqueo.setContentAreaFilled(false);
		btnPiqueo.setBorderPainted(false);
		btnPiqueo.setFocusPainted(false);
		btnPiqueo.setFocusTraversalKeysEnabled(false);
		btnPiqueo.setFocusable(false);
		btnPiqueo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPiqueo.setForeground(Color.WHITE);
		btnPiqueo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPiqueo.setBounds(527, 654, 162, 28);
		contentPane.add(btnPiqueo);
		
		btnBebida = new JButton("Bebidas");
		btnBebida.addActionListener(this);
		btnBebida.setBorderPainted(false);
		btnBebida.setContentAreaFilled(false);
		btnBebida.setDefaultCapable(false);
		btnBebida.setFocusPainted(false);
		btnBebida.setFocusTraversalKeysEnabled(false);
		btnBebida.setFocusable(false);
		btnBebida.setForeground(Color.WHITE);
		btnBebida.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBebida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBebida.setBounds(342, 654, 162, 28);
		contentPane.add(btnBebida);
		
		btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(this);
		btnCliente.setBorderPainted(false);
		btnCliente.setContentAreaFilled(false);
		btnCliente.setFocusPainted(false);
		btnCliente.setFocusTraversalKeysEnabled(false);
		btnCliente.setFocusable(false);
		btnCliente.setForeground(Color.WHITE);
		btnCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCliente.setBounds(170, 654, 162, 28);
		contentPane.add(btnCliente);
		
		btnUsuario = new JButton("Usuario");
		btnUsuario.addActionListener(this);
		btnUsuario.setBorderPainted(false);
		btnUsuario.setContentAreaFilled(false);
		btnUsuario.setFocusPainted(false);
		btnUsuario.setFocusTraversalKeysEnabled(false);
		btnUsuario.setFocusable(false);
		btnUsuario.setForeground(Color.WHITE);
		btnUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuario.setBounds(21, 654, 162, 28);
		contentPane.add(btnUsuario);
		
		btnCan = new JButton("");
		btnCan.addActionListener(this);
		btnCan.setRolloverIcon(new ImageIcon(Acomm.class.getResource("/img/bor.png")));
		btnCan.setIcon(new ImageIcon(Acomm.class.getResource("/img/cuadri.png")));
		btnCan.setFocusPainted(false);
		btnCan.setFocusTraversalKeysEnabled(false);
		btnCan.setFocusable(false);
		btnCan.setContentAreaFilled(false);
		btnCan.setBorderPainted(false);
		btnCan.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnCan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCan.setBounds(914, 146, 38, 44);
		contentPane.add(btnCan);
		
		btnSugeren = new JButton("");
		btnSugeren.addActionListener(this);
		btnSugeren.setRolloverIcon(new ImageIcon(Acomm.class.getResource("/img/bor.png")));
		btnSugeren.setIcon(new ImageIcon(Acomm.class.getResource("/img/cuadri.png")));
		btnSugeren.setFocusPainted(false);
		btnSugeren.setFocusTraversalKeysEnabled(false);
		btnSugeren.setFocusable(false);
		btnSugeren.setContentAreaFilled(false);
		btnSugeren.setBorderPainted(false);
		btnSugeren.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnSugeren.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSugeren.setBounds(961, 146, 38, 44);
		contentPane.add(btnSugeren);
		
		btnGe = new JButton("");
		btnGe.addActionListener(this);
		btnGe.setRolloverIcon(new ImageIcon(Acomm.class.getResource("/img/bor.png")));
		btnGe.setIcon(new ImageIcon(Acomm.class.getResource("/img/cuadri.png")));
		btnGe.setFocusPainted(false);
		btnGe.setFocusTraversalKeysEnabled(false);
		btnGe.setFocusable(false);
		btnGe.setContentAreaFilled(false);
		btnGe.setBorderPainted(false);
		btnGe.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnGe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGe.setBounds(100, 146, 42, 44);
		contentPane.add(btnGe);
		
		btnAr = new JButton("");
		btnAr.addActionListener(this);
		btnAr.setRolloverIcon(new ImageIcon(Acomm.class.getResource("/img/bor.png")));
		btnAr.setIcon(new ImageIcon(Acomm.class.getResource("/img/cuadri.png")));
		btnAr.setBorderPainted(false);
		btnAr.setContentAreaFilled(false);
		btnAr.setFocusPainted(false);
		btnAr.setFocusTraversalKeysEnabled(false);
		btnAr.setFocusable(false);
		btnAr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAr.setBounds(56, 146, 42, 44);
		contentPane.add(btnAr);
		
		btnUsu = new JButton("");
		btnUsu.addActionListener(this);
		btnUsu.setRolloverIcon(new ImageIcon(Acomm.class.getResource("/img/bor.png")));
		btnUsu.setContentAreaFilled(false);
		btnUsu.setDefaultCapable(false);
		btnUsu.setBorderPainted(false);
		btnUsu.setFocusPainted(false);
		btnUsu.setFocusTraversalKeysEnabled(false);
		btnUsu.setFocusable(false);
		btnUsu.setIcon(new ImageIcon(Acomm.class.getResource("/img/cuadri.png")));
		btnUsu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsu.setBounds(10, 140, 48, 56);
		contentPane.add(btnUsu);
		ImageIcon fondo8=new ImageIcon(getClass().getResource("/img/Multime.png"));
		ImageIcon fondo15=new ImageIcon(getClass().getResource("/img/paginaWeb.png"));
		
		btnPedido = new JButton("");
		btnPedido.addActionListener(this);
		btnPedido.addMouseListener(this);
		btnPedido.setBorderPainted(false);
		btnPedido.setContentAreaFilled(false);
		btnPedido.setDefaultCapable(false);
		btnPedido.setFocusPainted(false);
		btnPedido.setFocusTraversalKeysEnabled(false);
		btnPedido.setFocusable(false);
		btnPedido.setRequestFocusEnabled(false);
		btnPedido.setRolloverEnabled(false);
		btnPedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPedido.setBounds(240, 213, 165, 149);
		ImageIcon fondo19=new ImageIcon(getClass().getResource("/img/pedidos.png"));
		ImageIcon icon19=new ImageIcon(fondo19.getImage().getScaledInstance(btnPedido.getWidth(), btnPedido.getHeight(),Image.SCALE_DEFAULT));
		btnPedido.setIcon(icon19);
		contentPane.add(btnPedido);
		
		btnP = new JButton("");
		btnP.addActionListener(this);
		btnP.addMouseListener(this);
		btnP.setBorderPainted(false);
		btnP.setContentAreaFilled(false);
		btnP.setFocusPainted(false);
		btnP.setFocusTraversalKeysEnabled(false);
		btnP.setFocusable(false);
		btnP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnP.setBounds(459, 219, 140, 130);
		ImageIcon fondo16=new ImageIcon(getClass().getResource("/img/paginaWeb.png"));
		ImageIcon icon16=new ImageIcon(fondo16.getImage().getScaledInstance(btnP.getWidth(), btnP.getHeight(),Image.SCALE_DEFAULT));
		btnP.setIcon(icon16);
		contentPane.add(btnP);
		
		btnCalcu = new JButton("");
		btnCalcu.addActionListener(this);
		btnCalcu.addMouseListener(this);
		btnCalcu.setBorderPainted(false);
		btnCalcu.setContentAreaFilled(false);
		btnCalcu.setFocusPainted(false);
		btnCalcu.setFocusTraversalKeysEnabled(false);
		btnCalcu.setFocusable(false);
		
		btnCalcu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcu.setBounds(56, 363, 123, 136);
		contentPane.add(btnCalcu);
		
		ImageIcon fondo3=new ImageIcon(getClass().getResource("/img/ca.png"));
		ImageIcon icon3=new ImageIcon(fondo3.getImage().getScaledInstance(btnCalcu.getWidth(), btnCalcu.getHeight(),Image.SCALE_DEFAULT));
		btnCalcu.setIcon(icon3);
		ImageIcon fondo10=new ImageIcon(getClass().getResource("/img/diagrama.png"));
		ImageIcon fondo11=new ImageIcon(getClass().getResource("/img/carrito.png"));
		
		btnCE = new JButton("");
		btnCE.addActionListener(this);
		btnCE.addMouseListener(this);
		btnCE.setFocusTraversalKeysEnabled(false);
		btnCE.setFocusPainted(false);
		btnCE.setFocusable(false);
		btnCE.setDefaultCapable(false);
		btnCE.setContentAreaFilled(false);
		btnCE.setBorderPainted(false);
		btnCE.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCE.setBounds(43, 226, 144, 126);
		contentPane.add(btnCE);
		ImageIcon fondo6=new ImageIcon(getClass().getResource("/img/crontrol.png"));
		ImageIcon icon6=new ImageIcon(fondo6.getImage().getScaledInstance(btnCE.getWidth(),btnCE.getHeight(),Image.SCALE_DEFAULT));
		btnCE.setIcon(icon6);
		
		btnLogo = new JButton("");
		btnLogo.setRolloverIcon(new ImageIcon(Acomm.class.getResource("/img/princi2.png")));
		btnLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogo.setBorderPainted(false);
		btnLogo.setContentAreaFilled(false);
		btnLogo.setFocusPainted(false);
		btnLogo.setFocusTraversalKeysEnabled(false);
		btnLogo.setFocusable(false);
		btnLogo.setIcon(new ImageIcon(Acomm.class.getResource("/img/logo.png")));
		btnLogo.setBounds(5, -4, 48, 56);
		contentPane.add(btnLogo);
		
		lblcommKaraoke = new JLabel("\u00C1COMM Karaoke");
		lblcommKaraoke.setForeground(new Color(255, 255, 255));
		lblcommKaraoke.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblcommKaraoke.setBounds(68, 7, 140, 14);
		contentPane.add(lblcommKaraoke);
		
		lblHayVariosTipos_2 = new JLabel(" El equipo de karaoke b\u00E1sico consiste en un reproductor de m\u00FAsica, micr\u00F3fono y entradas, botones de control de tono y salida de audio. ");
		lblHayVariosTipos_2.setForeground(new Color(255, 255, 255));
		lblHayVariosTipos_2.setFont(new Font("Dialog", Font.BOLD, 11));
		lblHayVariosTipos_2.setBounds(116, 575, 856, 14);
		contentPane.add(lblHayVariosTipos_2);
		
		lblHayVariosTipos_1 = new JLabel("Tambi\u00E9n hay una serie de pistas de karaoke en formato CD, CD + Gs, discos l\u00E1ser, VCD y DVD para reproducir en la m\u00E1quina de karaoke");
		lblHayVariosTipos_1.setForeground(new Color(255, 255, 255));
		lblHayVariosTipos_1.setFont(new Font("Dialog", Font.BOLD, 11));
		lblHayVariosTipos_1.setBounds(154, 559, 844, 14);
		contentPane.add(lblHayVariosTipos_1);
		
		lblHayVariosTipos = new JLabel("Hay varios tipos de m\u00E1quinas de karaoke disponibles en el mercado. \r\n");
		lblHayVariosTipos.setForeground(new Color(255, 255, 255));
		lblHayVariosTipos.setFont(new Font("Dialog", Font.BOLD, 11));
		lblHayVariosTipos.setBounds(319, 536, 444, 28);
		contentPane.add(lblHayVariosTipos);
		
		label = new JLabel("-");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 19));
		label.setBounds(955, 1, 11, 14);
		contentPane.add(label);
		
		lblX = new JLabel("x");
		lblX.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(987, 2, 11, 14);
		contentPane.add(lblX);
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBackground(new Color(255, 255, 255));
		btnX.setBounds(974, -4, 37, 28);
		contentPane.add(btnX);
		
		button_1 = new JButton("");
		button_1.addActionListener(this);
		button_1.setRolloverIcon(new ImageIcon(Acomm.class.getResource("/img/transs.png")));
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setIcon(new ImageIcon(Acomm.class.getResource("/img/btnx.png")));
		button_1.setForeground(Color.WHITE);
		button_1.setFocusable(false);
		button_1.setFocusTraversalKeysEnabled(false);
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(940, -4, 37, 28);
		contentPane.add(button_1);
		
		labelcuerpo = new JLabel("");	
		labelcuerpo.setBounds(10, 193, 991, 329);
		contentPane.add(labelcuerpo);
		ImageIcon icon5=new ImageIcon(fondo5.getImage().getScaledInstance(labelcuerpo.getWidth(), labelcuerpo.getHeight(),Image.SCALE_DEFAULT));
		labelcuerpo .setIcon(icon5);
		
		label_1 = new JLabel("");
		label_1.addMouseMotionListener(this);
		label_1.addMouseListener(this);
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFocusTraversalKeysEnabled(false);
		label_1.setBounds(0, -4, 1008, 707);
		contentPane.add(label_1);
		ImageIcon fondo=new ImageIcon(getClass().getResource("/img/princi.png"));
		ImageIcon icon2=new ImageIcon(fondo.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(),Image.SCALE_DEFAULT));
		label_1.setIcon(icon2);
		
		
	
		
		
		
	}
	

	public void mouseReleased(MouseEvent e) {
		   setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	
		
	}
	 public void mouseDragged(MouseEvent e) {
	 	if (e.getSource() == contentPane) {
	 		mouseDraggedContentPane(e);
	 	}
	 	
	 	
	        int thisX = getLocation().x;
	        int thisY = getLocation().y;
	       
	        int xMoved = (thisX + e.getX()) - (thisX + i.x);
	        int yMoved = (thisY + e.getY()) - (thisY + i.y);
	       
	        int X = thisX + xMoved;
	        int Y = thisY + yMoved;
	        this.setLocation(X,Y);
	        
	        
	    }
	    
	   public void mousePressed(MouseEvent e) {
	   	if (e.getSource() == contentPane) {
	   		mousePressedContentPane(e);
	   	}
	   	
	   	
	   	
	        setCursor(new Cursor(Cursor.MOVE_CURSOR));
	        i = e.getPoint();
	        getComponentAt(i);
	        
	        
	        
	    }
	   
	   
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_1) {
			actionPerformedButton_1(e);
		}
		if (e.getSource() == btnMultimedia) {
			do_btnMultimedia_actionPerformed(e);
		}
		if (e.getSource() == btnPiqueos) {
			do_btnPiqueos_actionPerformed(e);
		}
		if (e.getSource() == btnInforme) {
			do_btnInforme_actionPerformed(e);
		}
		if (e.getSource() == btnPiqueo) {
			do_btnPiqueo_actionPerformed(e);
		}
		if (e.getSource() == btnBebida) {
			do_btnBebida_actionPerformed(e);
		}
		if (e.getSource() == btnCliente) {
			do_btnCliente_actionPerformed(e);
		}
		if (e.getSource() == btnTwiter) {
			do_btnTwiter_actionPerformed(e);
		}
		if (e.getSource() == btnFacebo) {
			do_btnFacebo_actionPerformed(e);
		}
		if (e.getSource() == btnCE) {
			do_btnCE_actionPerformed(e);
		}
		if (e.getSource() == btnMPC) {
			do_btnMPC_actionPerformed(e);
		}
		if (e.getSource() == btnRC) {
			do_btnRC_actionPerformed(e);
		}
		if (e.getSource() == btnRP) {
			do_btnRP_actionPerformed(e);
		}
		if (e.getSource() == btnMan) {
			do_btnMan_actionPerformed(e);
		}
		if (e.getSource() == btnSugeren) {
			do_btnSugeren_actionPerformed(e);
		}
		if (e.getSource() == btnGe) {
			do_btnGe_actionPerformed(e);
		}
		if (e.getSource() == btnCan) {
			do_btnCan_actionPerformed(e);
		}
		if (e.getSource() == btnAr) {
			do_btnAr_actionPerformed(e);
		}
		if (e.getSource() == btnP) {
			do_btnP_actionPerformed(e);
		}
		if (e.getSource() == btnPedido) {
			do_btnPedido_actionPerformed(e);
		}
		if (e.getSource() == btnUsu) {
			do_btnUsu_actionPerformed(e);
		}
		if (e.getSource() == btnUsuario) {
			do_btnUsuario_actionPerformed(e);
		}
		if (e.getSource() == btnCalcu) {
			do_btnCalcu_actionPerformed(e);
		}
		if (e.getSource() == btnX) {
			do_btnX_actionPerformed(e);
		}
	}



	
	
	private String  hora(){
		lahora = null;
		Calendar calendario= new GregorianCalendar();
		Date horas=new Date();
		calendario.setTime(horas);
		hora=calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
		minuto=calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
		segundo=calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
		
		return (String) (lahora=hora+":"+minuto+":"+segundo);
	}
	protected void do_btnX_actionPerformed(ActionEvent e) {
		int i=JOptionPane.showConfirmDialog(null,"Desea salir","salir", JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(i==JOptionPane.YES_OPTION)
		dispose();
		else
			JOptionPane.showMessageDialog(null,"exito");
	}
	
	
	
	
	
	
	
	
	
	
	
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnCE) {
			do_btnCE_mouseEntered(e);
		}
		if (e.getSource() == btnPedido) {
			do_btnPedido_mouseEntered(e);
		}
		if (e.getSource() == btnCalcu) {
			do_btnCalcu_mouseEntered(e);
		}
		if (e.getSource() == btnP) {
			do_btnP_mouseEntered(e);
		}
		if (e.getSource() == btnMPC) {
			do_btnMPC_mouseEntered(e);
		}
		if (e.getSource() == btnRC) {
			do_btnRC_mouseEntered(e);
		}
		if (e.getSource() == btnRP) {
			do_btnRP_mouseEntered(e);
		}
		if (e.getSource() == btnMan) {
			do_btnMan_mouseEntered(e);
		}
	}
	
	
	
	protected void do_btnMan_mouseEntered(MouseEvent e) {
		btnMan.setFocusTraversalKeysEnabled(true);
		btnMan.setContentAreaFilled(true);
		btnMan.setBorderPainted(false);
		btnMan.setIcon(new ImageIcon(Acomm.class.getResource("/img/manteni.png")));
			label_5.setVisible(true);
			labelM.setVisible(false);
			label_5.setIcon(new ImageIcon(Acomm.class.getResource("/img/tri.png")));
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnMan) {
			do_btnMan_mouseExited(e);
		}
		if (e.getSource() == btnRP) {
			do_btnRP_mouseExited(e);
		}
		if (e.getSource() == btnRC) {
			do_btnRC_mouseExited(e);
		}
		if (e.getSource() == btnMPC) {
			do_btnMPC_mouseExited(e);
		}
		if (e.getSource() == btnP) {
			do_btnP_mouseExited(e);
		}
		if (e.getSource() == btnCalcu) {
			do_btnCalcu_mouseExited(e);
		}
		if (e.getSource() == btnPedido) {
			do_btnPedido_mouseExited(e);
		}
		if (e.getSource() == btnCE) {
			do_btnCE_mouseExited(e);
		}
	}
	protected void do_btnMan_mouseExited(MouseEvent e) {
		btnMan.setFocusPainted(false);
		btnMan.setFocusTraversalKeysEnabled(false);
		btnMan.setFocusable(false);
		btnMan.setContentAreaFilled(false);
		btnMan.setBorderPainted(false);
		btnMan.setIcon(null);
		labelM.setVisible(true);
		label_5.setVisible(false);
		
	}

	protected void do_btnRP_mouseExited(MouseEvent e) {
		btnRP.setFocusPainted(false);
		btnRP.setFocusTraversalKeysEnabled(false);
		btnRP.setFocusable(false);
		btnRP.setContentAreaFilled(false);
		btnRP.setBorderPainted(false);
		btnRP.setIcon(null);
		label_6.setVisible(false);
		
	}
	protected void do_btnRC_mouseExited(MouseEvent e) {
		btnRC.setFocusPainted(false);
		btnRC.setFocusTraversalKeysEnabled(false);
		btnRC.setFocusable(false);
		btnRC.setContentAreaFilled(false);
		btnRC.setBorderPainted(false);
		btnRC.setIcon(null);
		label_7.setVisible(false);
		
		
		
	}
	protected void do_btnMPC_mouseExited(MouseEvent e) {
		btnMPC.setFocusPainted(false);
		btnMPC.setFocusTraversalKeysEnabled(false);
		btnMPC.setFocusable(false);
		btnMPC.setContentAreaFilled(false);
		btnMPC.setBorderPainted(false);
		btnMPC.setIcon(null);
		label_8.setVisible(false);
		
		
	}

	protected void do_btnP_mouseExited(MouseEvent e) {
	


		ImageIcon fondo3=new ImageIcon(getClass().getResource("/img/ca.png"));
		ImageIcon icon3=new ImageIcon(fondo3.getImage().getScaledInstance(btnCalcu.getWidth(), btnCalcu.getHeight(),Image.SCALE_DEFAULT));
		btnCalcu.setIcon(icon3);
		
		
	}
	

	protected void do_btnCalcu_mouseExited(MouseEvent e) {
	
	}
	
	protected void do_btnPedido_mouseExited(MouseEvent e) {
	
		
		ImageIcon fondo3=new ImageIcon(getClass().getResource("/img/ca.png"));
		ImageIcon icon3=new ImageIcon(fondo3.getImage().getScaledInstance(btnCalcu.getWidth(), btnCalcu.getHeight(),Image.SCALE_DEFAULT));
		btnCalcu.setIcon(icon3);
		

		
	}
	protected void do_btnCE_mouseExited(MouseEvent e) {
	
	
	}
	
	
	
	
	
	
	public void mouseClicked(MouseEvent e) {
		
		
	}







	protected void do_btnRP_mouseEntered(MouseEvent e) {
		btnRP.setFocusTraversalKeysEnabled(true);
		btnRP.setContentAreaFilled(true);
		btnRP.setBorderPainted(false);
		btnRP.setIcon(new ImageIcon(Acomm.class.getResource("/img/pedido12.png")));
			label_6.setVisible(true);
			label_6.setIcon(new ImageIcon(Acomm.class.getResource("/img/tri2.png")));
	}
	protected void do_btnRC_mouseEntered(MouseEvent e) {
		btnRC.setFocusTraversalKeysEnabled(true);
		btnRC.setContentAreaFilled(true);
		btnRC.setBorderPainted(false);
		btnRC.setIcon(new ImageIcon(Acomm.class.getResource("/img/consumo12.png")));
			label_7.setVisible(true);
			label_7.setIcon(new ImageIcon(Acomm.class.getResource("/img/tri3.png")));
			
	}
	protected void do_btnMPC_mouseEntered(MouseEvent e) {
		btnMPC.setFocusTraversalKeysEnabled(true);
		btnMPC.setContentAreaFilled(true);
		btnMPC.setBorderPainted(false);
		btnMPC.setIcon(new ImageIcon(Acomm.class.getResource("/img/pago12.png")));
		label_8.setVisible(true);
			label_8.setIcon(new ImageIcon(Acomm.class.getResource("/img/tri4.png")));
	}
	protected void do_btnP_mouseEntered(MouseEvent e) {
		
		ImageIcon fondo3=new ImageIcon(getClass().getResource("/img/ca.png"));
		ImageIcon icon3=new ImageIcon(fondo3.getImage().getScaledInstance(btnCalcu.getWidth(), btnCalcu.getHeight(),Image.SCALE_DEFAULT));
		btnCalcu.setIcon(icon3);
	
		
	}
	protected void do_btnCalcu_mouseEntered(MouseEvent e) {
		
		
		
		
	}
	protected void do_btnPedido_mouseEntered(MouseEvent e) {
		
		
		
	}
	protected void do_btnCE_mouseEntered(MouseEvent e) {
		
	
	
		
	}
	

	protected void do_btnCalcu_actionPerformed(ActionEvent e) {
		
		calculadora calcu=new calculadora();
		calcu.setVisible(true);
		calcu.setLocationRelativeTo(null);
		calcu.setResizable(false);
	}
	protected void do_btnUsuario_actionPerformed(ActionEvent e) {
		dispose();
		Usuario u=new Usuario();
		u.setVisible(true);
		u.setLocationRelativeTo(null);
		
	}
	protected void do_btnUsu_actionPerformed(ActionEvent e) {
		dispose();
		Usuario u=new Usuario();
		u.setVisible(true);
		u.setLocationRelativeTo(null);
		
	}
	protected void do_btnPedido_actionPerformed(ActionEvent e) {
		ventas v=new ventas();
		v.setVisible(true);
		v.setLocationRelativeTo(null);
		
		
		
		
	}
	protected void do_btnP_actionPerformed(ActionEvent e) {
		try {
			Desktop.getDesktop().browse(new URI("https://5a2b428d02a4b.wixsite.com/misitio"));
			} catch (URISyntaxException ex) {
				ex.printStackTrace();
			} catch (Exception ex) {
			
				ex.printStackTrace();
			}
	}
	protected void do_btnAr_actionPerformed(ActionEvent e) {
		dispose();
		Artista a=new Artista();
		a.setVisible(true);
		a.setLocationRelativeTo(null);
		}
	protected void do_btnCan_actionPerformed(ActionEvent e) {
		dispose();
		Cancion c=new Cancion();
		c.setVisible(true);
		c.setLocationRelativeTo(null);
	}
	protected void do_btnGe_actionPerformed(ActionEvent e) {
		dispose();
		Genero g=new Genero();
		g.setVisible(true);
		g.setLocationRelativeTo(null);
		
	}
	protected void do_btnSugeren_actionPerformed(ActionEvent e) {
		
		
		enviar ex=new enviar();
		ex.setVisible(true);
		ex.setLocationRelativeTo(null);
		
		
		
	}
	protected void do_btnMan_actionPerformed(ActionEvent e) {
		dispose();
		Cliente cl=new Cliente();
		cl.setVisible(true);
		cl.setLocationRelativeTo(null);
	}
	protected void do_btnRP_actionPerformed(ActionEvent e) {
		PedidoReserva pr=new PedidoReserva();
		pr.setVisible(true);
		pr.setLocationRelativeTo(null);
		
	}
	protected void do_btnRC_actionPerformed(ActionEvent e) {
		Detalleconsumo dc=new Detalleconsumo();
		dc.setVisible(true);
		dc.setLocationRelativeTo(null);
	}
	protected void do_btnMPC_actionPerformed(ActionEvent e) {
		consumopagos cp=new consumopagos();
		cp.setVisible(true);
		cp.setLocationRelativeTo(null);
	}
	protected void do_btnCE_actionPerformed(ActionEvent e) {
		controlUsuario cu = new controlUsuario();
		cu.setVisible(true);
		cu.setLocationRelativeTo(null);
	}
	protected void do_btnFacebo_actionPerformed(ActionEvent e) {
		
			 try{
			      Desktop dk = Desktop.getDesktop();
			      dk.browse(new URI("https://www.facebook.com/"));
			 }catch(Exception f){
			     JOptionPane.showMessageDialog(null,"Error al abrir URL: "+f.getMessage());
		}
		
	}
	protected void do_btnTwiter_actionPerformed(ActionEvent e) {
		
			 try{
			      Desktop dk = Desktop.getDesktop();
			      dk.browse(new URI("https://twitter.com/"));
			 }catch(Exception f){
			     JOptionPane.showMessageDialog(null,"Error al abrir URL: "+f.getMessage());
		}
		
		
	}
	protected void do_btnCliente_actionPerformed(ActionEvent e) {
		dispose();
		Cliente c=new Cliente();
		c.setVisible(true);
		c.setLocationRelativeTo(null);
	}
	protected void do_btnBebida_actionPerformed(ActionEvent e) {
		dispose();
		Bebida c=new Bebida();
		c.setVisible(true);
		c.setLocationRelativeTo(null);
	}
	protected void do_btnPiqueo_actionPerformed(ActionEvent e) {
		dispose();
		Piqueo c=new Piqueo();
		c.setVisible(true);
		c.setLocationRelativeTo(null);
	}
	protected void do_btnInforme_actionPerformed(ActionEvent e) {
		dispose();
		Pedido c=new Pedido();
		c.setVisible(true);
		c.setLocationRelativeTo(null);
	}
	protected void do_btnPiqueos_actionPerformed(ActionEvent e) {
	
	google g=new google();
	g.setVisible(true);
	g.setLocationRelativeTo(null);
	}
	protected void do_btnMultimedia_actionPerformed(ActionEvent e) {
		dispose();
		ventana v =new ventana();
		v.setVisible(true);
		v.setLocationRelativeTo(null);
	}
	protected void actionPerformedButton_1(ActionEvent e) {
		setExtendedState(1);
	
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		
	}


	
	

	protected void mousePressedContentPane(MouseEvent e) {
		 x=e.getX();
		 y=e.getY();
		
	}
	
	
	protected void mouseDraggedContentPane(MouseEvent e) {
		Point union=MouseInfo.getPointerInfo().getLocation();
		setLocation(union.x-x,union.y-y);
		
	}
}
		

