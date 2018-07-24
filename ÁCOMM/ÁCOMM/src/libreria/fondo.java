package libreria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Formulario.Graficos;
import Formulario.Usuario;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.text.MessageFormat;
import java.util.logging.Logger;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class fondo extends JFrame implements ActionListener, MouseMotionListener {

	private static final int PAGE_EXISTS = 0;
	private static final int NO_SUCH_PAGE = 0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fondo frame = new fondo();
					frame.setVisible(true);
					frame.setResizable(false);
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
	public fondo() {
		setUndecorated(true);
		setBackground(new Color(0, 0, 0,0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 615);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		contentPane.addMouseMotionListener(this);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/fondo.png"));
		
		
		btnflecha = new JButton("");
		btnflecha.setDefaultCapable(false);
		btnflecha.setBorderPainted(false);
		btnflecha.addActionListener(this);
		btnflecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnflecha.setContentAreaFilled(false);
		btnflecha.setFocusable(false);
		btnflecha.setFocusTraversalKeysEnabled(false);
		btnflecha.setFocusPainted(false);
		btnflecha.setIcon(new ImageIcon(fondo.class.getResource("/img/flecha.png")));
		btnflecha.setBounds(10, 23, 38, 26);
		ImageIcon fondo2=new ImageIcon(getClass().getResource("/img/flecha.png"));
		ImageIcon icon2=new ImageIcon(fondo2.getImage().getScaledInstance(btnflecha.getWidth(),btnflecha.getHeight(),Image.SCALE_DEFAULT));
		
		btndetalles = new JButton("");
		btndetalles.addActionListener(this);
	
		
		
	
		
		lbfondo = new JLabel("");
		lbfondo.setBounds(39, 94, 594, 405);
		contentPane.add(lbfondo);
		btndetalles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btndetalles.setIcon(new ImageIcon(fondo.class.getResource("/img/vacio.png")));
		btndetalles.setFocusable(false);
		btndetalles.setFocusTraversalKeysEnabled(false);
		btndetalles.setFocusPainted(false);
		btndetalles.setDefaultCapable(false);
		btndetalles.setContentAreaFilled(false);
		btndetalles.setBorderPainted(false);
		btndetalles.setBounds(623, 20, 38, 36);
		contentPane.add(btndetalles);
		btnflecha.setIcon(icon2);
		contentPane.add(btnflecha);
		
		labelprincipal = new JLabel("");
		labelprincipal.setBounds(0, 0, 671, 615);
		ImageIcon icon1=new ImageIcon(fondo1.getImage().getScaledInstance(labelprincipal.getWidth(),labelprincipal.getHeight(),Image.SCALE_DEFAULT));
		labelprincipal.setIcon(icon1);
		contentPane.add(labelprincipal);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btndetalles) {
			actionPerformedBtndetalles(arg0);
		}
		if (arg0.getSource() == btnflecha) {
			actionPerformedBtnflecha(arg0);
		}
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == contentPane) {
			mouseDraggedContentPane(arg0);
		}
	}
	int x,y;
	private JLabel labelprincipal;
	public static  JLabel lbfondo;
	private JButton btnflecha;
	private JButton btndetalles;
	 public static int codigo1;
	 public  static String nombre1;
	 public  static String paterno1;
	 public  static String materno1;
	 public  static String tipo1;
	 public  static  String turno1;
	 
	public void mouseMoved(MouseEvent arg0) {
		x=arg0.getX();
		y=arg0.getY();
	}
	protected void mouseDraggedContentPane(MouseEvent arg0) {
		
		Point p=MouseInfo.getPointerInfo().getLocation();
		setLocation(p.x-x, p.y-y);
	}

	
	protected void actionPerformedBtnflecha(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedBtndetalles(ActionEvent arg0) {
	
		dispose();
		
		imprimir im=new imprimir();
		im.setVisible(true);
		im.setLocationRelativeTo(null);
	
		ImageIcon ista=(ImageIcon) lbfondo.getIcon();
		imprimir.lbima.setIcon(new ImageIcon(ista.getImage().getScaledInstance(imprimir.lbima.getWidth(),imprimir.lbima.getHeight(), Image.SCALE_AREA_AVERAGING)));
	
		imprimir.txtC.setText(String.valueOf(codigo1));
		imprimir.txtN.setText(nombre1);
		imprimir.txtP.setText(paterno1);
		imprimir.txtM.setText(materno1);
		imprimir.txtTurno.setText(turno1);
		imprimir.txtT.setText(tipo1);
		

			
	}
}
