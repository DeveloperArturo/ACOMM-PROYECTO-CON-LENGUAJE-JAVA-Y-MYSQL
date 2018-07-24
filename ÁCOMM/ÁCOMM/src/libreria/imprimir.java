package libreria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import Formulario.Usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseMotionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class imprimir extends JFrame implements MouseMotionListener, ActionListener,Printable {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel label_1;
	private JLabel lblInformacionGeneral;
	private JLabel label_2;
	private JLabel label_3;
	public static JTextField txtN;
	private JLabel label_4;
	public static JTextField txtP;
	private JLabel label_5;
	public static JTextField txtM;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	public static JTextField txtTurno;
	public static JTextField txtT;
	private JButton btnsalir;
	public static  JLabel lbima;
	private JButton btnimprimir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					imprimir frame = new imprimir();
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
	public imprimir() {
		setUndecorated(true);
		setBackground(new Color(0, 0, 0,0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 638);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(this);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon fondo3=new ImageIcon(getClass().getResource("/img/cuadrozul.png"));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 607, 64);
		ImageIcon fondo2=new ImageIcon(getClass().getResource("/img/cuadrozul.png"));
		ImageIcon icon2=new ImageIcon(fondo2.getImage().getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT));
		
		btnsalir = new JButton("");
		btnsalir.addActionListener(this);
		btnsalir.setBounds(-6, 0, 62, 58);
		contentPane.add(btnsalir);
		btnsalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnsalir.setIcon(new ImageIcon(imprimir.class.getResource("/img/celeste.png")));
		btnsalir.setFocusable(false);
		btnsalir.setFocusTraversalKeysEnabled(false);
		btnsalir.setFocusPainted(false);
		btnsalir.setDefaultCapable(false);
		btnsalir.setContentAreaFilled(false);
		btnsalir.setBorderPainted(false);
		lblNewLabel.setIcon(icon2);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(240, 240, 240), 3, true));
		panel.setBounds(0, 58, 607, 528);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbima = new JLabel("");
		lbima.setBounds(369, 49, 209, 193);

	
		
		panel.add(lbima);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(imprimir.class.getResource("/img/usuarioss.png")));
		label_1.setBounds(10, 22, 45, 40);
		panel.add(label_1);
		
		lblInformacionGeneral = new JLabel("Informacion General del Usuario\r\n");
		lblInformacionGeneral.setForeground(Color.DARK_GRAY);
		lblInformacionGeneral.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
		lblInformacionGeneral.setBounds(52, 22, 290, 40);
		panel.add(lblInformacionGeneral);
		
		label_2 = new JLabel("Datos Personales");
		label_2.setForeground(SystemColor.windowBorder);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(48, 85, 101, 14);
		panel.add(label_2);
		
		label_3 = new JLabel("Nombre");
		label_3.setForeground(SystemColor.windowBorder);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(20, 173, 55, 14);
		panel.add(label_3);
		
		txtN = new JTextField();
		txtN.setEditable(false);
		txtN.setForeground(SystemColor.windowBorder);
		txtN.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtN.setColumns(10);
		txtN.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtN.setBackground(SystemColor.controlHighlight);
		txtN.setBounds(139, 166, 203, 28);
		panel.add(txtN);
		
		label_4 = new JLabel("Apellido Paterno");
		label_4.setForeground(SystemColor.windowBorder);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(20, 227, 101, 14);
		panel.add(label_4);
		
		txtP = new JTextField();
		txtP.setEditable(false);
		txtP.setForeground(SystemColor.windowBorder);
		txtP.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtP.setColumns(10);
		txtP.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtP.setBackground(SystemColor.controlHighlight);
		txtP.setBounds(139, 216, 203, 28);
		panel.add(txtP);
		
		label_5 = new JLabel("Apellido Materno");
		label_5.setForeground(SystemColor.windowBorder);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(20, 276, 112, 14);
		panel.add(label_5);
		
		txtM = new JTextField();
		txtM.setEditable(false);
		txtM.setForeground(SystemColor.windowBorder);
		txtM.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtM.setColumns(10);
		txtM.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtM.setBackground(SystemColor.controlHighlight);
		txtM.setBounds(139, 264, 203, 28);
		panel.add(txtM);
		
		label_6 = new JLabel("Detalle de Empleado");
		label_6.setForeground(SystemColor.windowBorder);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(52, 326, 135, 14);
		panel.add(label_6);
		
		label_7 = new JLabel("Tipo ");
		label_7.setForeground(SystemColor.windowBorder);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(20, 384, 55, 14);
		panel.add(label_7);
		
		label_8 = new JLabel("Turno");
		label_8.setForeground(SystemColor.windowBorder);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setBounds(20, 424, 55, 14);
		panel.add(label_8);
		
		txtTurno = new JTextField();
		txtTurno.setEditable(false);
		txtTurno.setForeground(SystemColor.windowBorder);
		txtTurno.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtTurno.setColumns(10);
		txtTurno.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtTurno.setBackground(SystemColor.controlHighlight);
		txtTurno.setBounds(139, 418, 203, 28);
		panel.add(txtTurno);
		
		txtT = new JTextField();
		txtT.setEditable(false);
		txtT.setForeground(SystemColor.windowBorder);
		txtT.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtT.setColumns(10);
		txtT.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtT.setBackground(SystemColor.controlHighlight);
		txtT.setBounds(139, 370, 203, 28);
		panel.add(txtT);
		
		btnimprimir = new JButton("");
		btnimprimir.addActionListener(this);
		btnimprimir.setBounds(389, 253, 183, 39);
		panel.add(btnimprimir);
		btnimprimir.setIcon(new ImageIcon(imprimir.class.getResource("/img/imprrision.png")));
		btnimprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnimprimir.setFocusable(false);
		btnimprimir.setFocusTraversalKeysEnabled(false);
		btnimprimir.setFocusPainted(false);
		btnimprimir.setDefaultCapable(false);
		btnimprimir.setContentAreaFilled(false);
		btnimprimir.setBorderPainted(false);
		
		txtC = new JTextField();
		txtC.setForeground(SystemColor.windowBorder);
		txtC.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtC.setEditable(false);
		txtC.setColumns(10);
		txtC.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtC.setBackground(SystemColor.controlHighlight);
		txtC.setBounds(139, 121, 203, 28);
		panel.add(txtC);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setForeground(SystemColor.windowBorder);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo.setBounds(20, 128, 55, 14);
		panel.add(lblCodigo);
		
		label = new JLabel("");
		label.setBounds(0, 586, 617, 52);
		contentPane.add(label);
		ImageIcon fondo4=new ImageIcon(getClass().getResource("/img/cuadrozul.png"));
		ImageIcon icon4=new ImageIcon(fondo4.getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_DEFAULT));
		label.setIcon(icon4);
	}

	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == contentPane) {
			mouseDraggedContentPane(arg0);
		}
	}
	int x,y;
	private JLabel label;
	public static JTextField txtC;
	private JLabel lblCodigo;
	public void mouseMoved(MouseEvent arg0) {
		x=arg0.getX();
		y=arg0.getY();
		
	}
	protected void mouseDraggedContentPane(MouseEvent arg0) {
		Point p=MouseInfo.getPointerInfo().getLocation();
		setLocation(p.x-x, p.y-y);
			
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnimprimir) {
			actionPerformedBtnimprimir(arg0);
		}
		if (arg0.getSource() == btnsalir) {
			actionPerformedBtnsalir(arg0);
		}
	}
	protected void actionPerformedBtnsalir(ActionEvent arg0) {
	dispose();


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
	
	protected void actionPerformedBtnimprimir(ActionEvent arg0) {
		
		
		   try {
			   PrinterJob job = PrinterJob.getPrinterJob();
			   job.setPrintable(this);
			   job.printDialog();
			   job.print();
			 } catch (PrinterException ex) {
			   ex.printStackTrace();
			 }
		
		
	}
}
