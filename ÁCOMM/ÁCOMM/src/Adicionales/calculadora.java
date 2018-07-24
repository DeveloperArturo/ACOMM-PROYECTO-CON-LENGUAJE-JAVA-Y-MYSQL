package Adicionales;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.JInternalFrame;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import java.awt.Choice;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenu;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;

public class calculadora extends JFrame implements ActionListener, MouseListener {

	JPanel con;

	private static JTextField txtCaja;
	private JButton btnIgual;
	private JButton btnUno;
	private JButton btnDos;
	private JButton btnTres;
	private JButton btnMas;
	private JButton btnPor;
	private JButton btnDivi;
	private JButton btnCuatro;
	private JButton btnSiete;
	private JButton btnPunto;
	private JButton btnCinco;
	private JButton btnOcho;
	private JButton btnSeis;
	private JButton btnNueve;
	private JButton btn0;

	/**
	 * Launch the application.
	 */
	
	
	/*
	 * operadores logicos para solucionar los problemas
	 * 
	 */
 
	
	String signo="";
	String memoria1="";
	String memoria2="";
	
	
	int turno=1;
	int cu=1;


 
 
 
 

 
 
 
 private JButton btnL;
 private JButton btnMenos;
 private JButton btnraiz;
 private JLabel lblIngreseElNumero;
 private JButton btnC;
 private JTextField txtU;
 private JButton btnH;
 private JButton btnX;
 private JButton btncubo;
 private JButton btnP;
 private JButton btnPi;
 private JButton btnConteo;
 private JPanel panel;
	
		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadora frame = new calculadora();
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
	public calculadora() {

		
	
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icon.png"));
		   setIconImage(icon);
		setForeground(Color.BLACK);
		setBackground(new Color(0, 0, 0));
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 369, 450);
		con = new JPanel();
		con.setBackground(UIManager.getColor("windowText"));
		con.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(con);
		con.setLayout(null);
		
		
	
		panel = new JPanel();
		panel.setForeground(SystemColor.windowBorder);
		panel.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel.setBounds(0, 0, 366, 425);
		panel.setBackground(UIManager.getColor("windowText"));
		panel.setVisible(false);
		
		btnC = new JButton("C");
		btnC.setIcon(new ImageIcon(calculadora.class.getResource("/img/c1.png")));
		btnC.setBounds(104, 266, 84, 39);
		btnC.addMouseListener(this);
		btnC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnC.addActionListener(this);
		
		txtU = new JTextField();
		txtU.setBounds(10, 19, 345, 20);
		txtU.setForeground(Color.DARK_GRAY);
		txtU.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtU.setCaretColor(Color.WHITE);
		txtU.setBorder(new LineBorder(Color.WHITE, 0));
		txtU.setBackground(Color.WHITE);
		con.add(txtU);
		txtU.setColumns(10);
		
		btnCuatro = new JButton("");
		btnCuatro.setRolloverIcon(new ImageIcon(calculadora.class.getResource("/img/4v.png")));
		btnCuatro.setIcon(new ImageIcon(calculadora.class.getResource("/img/cuatro.png")));
		btnCuatro.setBounds(10, 176, 84, 35);
		btnCuatro.addMouseListener(this);
		btnCuatro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCuatro.addActionListener(this);
		btnCuatro.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCuatro.setForeground(new Color(255, 255, 255));
		btnCuatro.setBackground(Color.DARK_GRAY);
		btnCuatro.setFocusable(false);
		btnCuatro.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		con.add(btnCuatro);
		
		btnDivi = new JButton("/");
		btnDivi.setIcon(new ImageIcon(calculadora.class.getResource("/img/entre.png")));
		btnDivi.setBounds(292, 266, 64, 35);
		btnDivi.addMouseListener(this);
		btnDivi.addActionListener(this);
		btnDivi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDivi.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnDivi.setForeground(new Color(220, 220, 220));
		btnDivi.setBackground(SystemColor.windowBorder);
		btnDivi.setFocusable(false);
		btnDivi.setBorder(new LineBorder(SystemColor.windowBorder));
		con.add(btnDivi);
		
		btnMenos = new JButton("");
		btnMenos.setIcon(new ImageIcon(calculadora.class.getResource("/img/mimmm.png")));
		btnMenos.setBounds(292, 220, 64, 35);
		btnMenos.addActionListener(this);
		btnMenos.addMouseListener(this);
		btnMenos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMenos.setForeground(new Color(220, 220, 220));
		btnMenos.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMenos.setFocusable(false);
		btnMenos.setBorder(new LineBorder(SystemColor.windowBorder));
		btnMenos.setBackground(SystemColor.windowBorder);
		con.add(btnMenos);
		
		btnCinco = new JButton("");
		btnCinco.setRolloverIcon(new ImageIcon(calculadora.class.getResource("/img/5v.png")));
		btnCinco.setIcon(new ImageIcon(calculadora.class.getResource("/img/cinco.png")));
		btnCinco.setBounds(104, 176, 84, 35);
		btnCinco.addMouseListener(this);
		btnCinco.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCinco.addActionListener(this);
		btnCinco.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCinco.setForeground(new Color(255, 255, 255));
		btnCinco.setBackground(Color.DARK_GRAY);
		btnCinco.setFocusable(false);
		btnCinco.setBorder(new LineBorder(new Color(64, 64, 64), 1, true));
		con.add(btnCinco);
		
		btnConteo = new JButton("");
		btnConteo.setBounds(198, 360, 84, 41);
		btnConteo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConteo.setForeground(Color.WHITE);
		btnConteo.setIcon(new ImageIcon(calculadora.class.getResource("/img/ccc.png")));
		btnConteo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnConteo.setFocusable(false);
		btnConteo.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		btnConteo.setBackground(new Color(169, 169, 169));
		con.add(btnConteo);
		
		btn0 = new JButton("");
		btn0.setRolloverIcon(new ImageIcon(calculadora.class.getResource("/img/0v.png")));
		btn0.setIcon(new ImageIcon(calculadora.class.getResource("/img/cero.png")));
		btn0.setBounds(198, 267, 84, 35);
		btn0.addMouseListener(this);
		btn0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn0.addActionListener(this);
		btn0.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		btn0.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn0.setForeground(new Color(255, 255, 255));
		btn0.setBackground(Color.DARK_GRAY);
		btn0.setFocusable(false);
		con.add(btn0);
		
		btnPunto = new JButton("");
		btnPunto.setIcon(new ImageIcon(calculadora.class.getResource("/img/punto.png")));
		btnPunto.setBounds(10, 267, 84, 35);
		btnPunto.addMouseListener(this);
		btnPunto.addActionListener(this);
		btnPunto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPunto.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnPunto.setForeground(Color.WHITE);
		btnPunto.setBackground(Color.DARK_GRAY);
		btnPunto.setFocusable(false);
		btnPunto.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		con.add(btnPunto);
		
		btnraiz = new JButton("");
		btnraiz.setBounds(10, 313, 84, 36);
		btnraiz.addMouseListener(this);
		btnraiz.addActionListener(this);
		btnraiz.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnraiz.setIcon(new ImageIcon(calculadora.class.getResource("/img/r.png")));
		btnraiz.setForeground(Color.WHITE);
		btnraiz.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnraiz.setFocusable(false);
		btnraiz.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		btnraiz.setBackground(new Color(220, 220, 220));
		con.add(btnraiz);
		
		btnPi = new JButton("P/I");
		btnPi.setBounds(10, 360, 84, 41);
		btnPi.addActionListener(this);
		btnPi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPi.setForeground(new Color(0, 0, 0));
		btnPi.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnPi.setFocusable(false);
		btnPi.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		btnPi.setBackground(new Color(169, 169, 169));
		con.add(btnPi);
		
		btnOcho = new JButton("");
		btnOcho.setRolloverIcon(new ImageIcon(calculadora.class.getResource("/img/8v.png")));
		btnOcho.setIcon(new ImageIcon(calculadora.class.getResource("/img/ocho.png")));
		btnOcho.setBounds(104, 222, 84, 35);
		btnOcho.addMouseListener(this);
		btnOcho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOcho.addActionListener(this);
		btnOcho.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOcho.setForeground(new Color(255, 255, 255));
		btnOcho.setBackground(Color.DARK_GRAY);
		btnOcho.setFocusable(false);
		btnOcho.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		con.add(btnOcho);
		
		btnSiete = new JButton("");
		btnSiete.setRolloverIcon(new ImageIcon(calculadora.class.getResource("/img/7v.png")));
		btnSiete.setIcon(new ImageIcon(calculadora.class.getResource("/img/siete.png")));
		btnSiete.setBounds(10, 221, 84, 35);
		btnSiete.addMouseListener(this);
		btnSiete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSiete.addActionListener(this);
		btnSiete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSiete.setForeground(new Color(255, 255, 255));
		btnSiete.setBackground(Color.DARK_GRAY);
		btnSiete.setFocusable(false);
		btnSiete.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		con.add(btnSiete);
		
		btnNueve = new JButton("");
		btnNueve.setRolloverIcon(new ImageIcon(calculadora.class.getResource("/img/9v.png")));
		btnNueve.setIcon(new ImageIcon(calculadora.class.getResource("/img/nueve.png")));
		btnNueve.setBounds(198, 222, 84, 35);
		btnNueve.addMouseListener(this);
		btnNueve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNueve.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		btnNueve.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNueve.setForeground(new Color(255, 255, 255));
		btnNueve.setBackground(Color.DARK_GRAY);
		btnNueve.addActionListener(this);
		btnNueve.setFocusable(false);
		con.add(btnNueve);
		
		btnX = new JButton("");
		btnX.setBounds(104, 313, 84, 36);
		btnX.addActionListener(this);
		btnX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnX.setForeground(Color.WHITE);
		btnX.setFont(new Font("Tahoma", Font.BOLD, 38));
		btnX.setFocusable(false);
		btnX.setIcon(new ImageIcon(calculadora.class.getResource("/img/dus.png")));
		btnX.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		btnX.setBackground(new Color(220, 220, 220));
		con.add(btnX);
		
		btncubo = new JButton("");
		btncubo.setBounds(198, 312, 84, 41);
		btncubo.addActionListener(this);
		btncubo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btncubo.setForeground(Color.WHITE);
		btncubo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btncubo.setFocusable(false);
		btncubo.setIcon(new ImageIcon(calculadora.class.getResource("/img/cubus.png")));
		btncubo.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		btncubo.setBackground(new Color(220, 220, 220));
		con.add(btncubo);
		
		btnH = new JButton("");
		btnH.setIcon(new ImageIcon(calculadora.class.getResource("/img/barra.png")));
		btnH.setBounds(10, 78, 274, 39);
		btnH.addMouseListener(this);
		btnH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnH.setForeground(new Color(255, 255, 255));
		btnH.addActionListener(this);
		btnH.setBorder(new LineBorder(new Color(64, 64, 64), 0, true));
		btnH.setFocusable(false);
		btnH.setBorderPainted(false);
		btnH.setBackground(Color.DARK_GRAY);
		con.add(btnH);
		
		btnSeis = new JButton("");
		btnSeis.setRolloverIcon(new ImageIcon(calculadora.class.getResource("/img/6v.png")));
		btnSeis.setIcon(new ImageIcon(calculadora.class.getResource("/img/seis.png")));
		btnSeis.setBounds(198, 176, 84, 35);
		btnSeis.addMouseListener(this);
		btnSeis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSeis.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		btnSeis.addActionListener(this);
		btnSeis.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSeis.setForeground(new Color(255, 255, 255));
		btnSeis.setBackground(Color.DARK_GRAY);
		btnSeis.setFocusable(false);
		con.add(btnSeis);
		
		btnL = new JButton("LE");
		btnL.setIcon(new ImageIcon(calculadora.class.getResource("/img/le1.png")));
		btnL.setBounds(292, 79, 64, 38);
		btnL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnL.addMouseListener(this);
		btnL.addActionListener(this);
		btnL.setFocusable(false);
		btnL.setForeground(Color.WHITE);
		btnL.setBackground(new Color(32, 178, 170));
		btnL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnL.setBorder(new LineBorder(new Color(64, 64, 64), 0, true));
		con.add(btnL);
		
		btnP = new JButton("");
		btnP.setBounds(104, 360, 84, 41);
		btnP.addActionListener(this);
		btnP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnP.setForeground(Color.WHITE);
		btnP.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnP.setFocusable(false);
		btnP.setIcon(new ImageIcon(calculadora.class.getResource("/img/p.png")));
		btnP.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		btnP.setBackground(new Color(169, 169, 169));
		con.add(btnP);
		
		
		
		btnC.setForeground(Color.WHITE);
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnC.setFocusable(false);
		btnC.setBorder(new LineBorder(new Color(128, 128, 128), 0));
		btnC.setBackground(new Color(128, 0, 0));
		con.add(btnC);
		
		btnDos = new JButton("");
		btnDos.setRolloverIcon(new ImageIcon(calculadora.class.getResource("/img/2v.png")));
		btnDos.setIcon(new ImageIcon(calculadora.class.getResource("/img/dos.png")));
		btnDos.setBounds(104, 127, 84, 38);
		btnDos.addMouseListener(this);
		btnDos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDos.addActionListener(this);
		btnDos.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		btnDos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDos.setForeground(new Color(255, 255, 255));
		btnDos.setBackground(Color.DARK_GRAY);
		btnDos.setFocusable(false);
		con.add(btnDos);
		
		btnIgual = new JButton("");
		btnIgual.setIcon(new ImageIcon(calculadora.class.getResource("/img/igual.png")));
		btnIgual.setBounds(292, 312, 64, 89);
		btnIgual.addActionListener(this);
		btnIgual.addMouseListener(this);
		btnIgual.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIgual.setForeground(new Color(255, 255, 255));
		btnIgual.setBackground(new Color(255, 165, 0));
		btnIgual.setFont(new Font("Tahoma", Font.BOLD, 33));
		btnIgual.setFocusable(false);
		btnIgual.setBorder(new LineBorder(Color.ORANGE, 1, true));
		con.add(btnIgual);
		
		btnPor = new JButton("");
		btnPor.setIcon(new ImageIcon(calculadora.class.getResource("/img/xx.png")));
		btnPor.setBounds(292, 174, 64, 35);
		btnPor.addMouseListener(this);
		
			btnPor.addActionListener(this);
			btnPor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPor.setFont(new Font("Tahoma", Font.BOLD, 21));
			btnPor.setForeground(new Color(220, 220, 220));
			btnPor.setBackground(SystemColor.windowBorder);
			btnPor.setFocusable(false);
			btnPor.setBorder(new LineBorder(new Color(64, 64, 64)));
			con.add(btnPor);
		
		lblIngreseElNumero = new JLabel("0");
		lblIngreseElNumero.setBounds(20, 36, 224, 20);
		lblIngreseElNumero.setForeground(SystemColor.scrollbar);
		lblIngreseElNumero.setFont(new Font("Tahoma", Font.BOLD, 18));
		con.add(lblIngreseElNumero);
		
		txtCaja = new JTextField();
		txtCaja.setBounds(10, 35, 345, 28);
		txtCaja.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtCaja.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtCaja.setMargin(new Insets(0, 2, 0, 2));
		txtCaja.setMaximumSize(new Dimension(2147483647, 2147483636));
		txtCaja.setMinimumSize(new Dimension(0, 11));
		txtCaja.setForeground(SystemColor.windowBorder);
		txtCaja.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtCaja.setBackground(Color.WHITE);
		txtCaja.setEditable(false);
		con.add(txtCaja);
		txtCaja.setColumns(10);
		
		btnTres = new JButton("");
		btnTres.setRolloverIcon(new ImageIcon(calculadora.class.getResource("/img/3v.png")));
		btnTres.setIcon(new ImageIcon(calculadora.class.getResource("/img/tres.png")));
		btnTres.setBounds(198, 127, 84, 38);
		btnTres.addMouseListener(this);
		btnTres.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTres.addActionListener(this);
		btnTres.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		btnTres.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTres.setForeground(new Color(255, 255, 255));
		btnTres.setBackground(Color.DARK_GRAY);
		btnTres.setFocusable(false);
		con.add(btnTres);
		
		btnMas = new JButton("+");
		btnMas.setIcon(new ImageIcon(calculadora.class.getResource("/img/mas.png")));
		btnMas.setBounds(292, 128, 64, 35);
		btnMas.addMouseListener(this);
		btnMas.addActionListener(this);
		btnMas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMas.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnMas.setForeground(new Color(220, 220, 220));
		btnMas.setBackground(SystemColor.windowBorder);
		btnMas.setFocusable(false);
		btnMas.setBorder(new LineBorder(SystemColor.windowBorder));
		con.add(btnMas);
		
		btnUno = new JButton("");
		btnUno.setRolloverIcon(new ImageIcon(calculadora.class.getResource("/img/unov.png")));
		btnUno.setIcon(new ImageIcon(calculadora.class.getResource("/img/uno.png")));
		btnUno.setBounds(10, 127, 84, 38);
		btnUno.addMouseListener(this);
		btnUno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUno.addActionListener(this);
		btnUno.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		btnUno.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUno.setForeground(new Color(255, 255, 255));
		btnUno.setBackground(Color.DARK_GRAY);
		btnUno.setFocusable(false);
		con.add(btnUno);
		con.add(panel);
		panel.setLayout(null);
		
		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnPi) {
			do_btnPi_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnP) {
			do_btnP_actionPerformed(arg0);
		}
		if (arg0.getSource() == btncubo) {
			do_btncubo_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnX) {
			do_btnX_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnH) {
			do_btnH_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnraiz) {
			do_btnPromedio_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnC) {
			do_btnC_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnIgual) {
			do_btnIgual_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnMenos) {
			do_btnMenos_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnL) {
			do_btnL_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnDivi) {
			do_btnDivi_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnPunto) {
			do_btnPunto_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnPor) {
			do_btnPor_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnMas) {
			do_btnMas_actionPerformed(arg0);
		}
		if (arg0.getSource() == btn0) {
			do_btn0_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnOcho) {
			do_btnOcho_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSiete) {
			do_btnSiete_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnCinco) {
			do_btnCinco_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnCuatro) {
			do_btnCuatro_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnTres) {
			do_btnTres_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnDos) {
			do_btnDos_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnUno) {
			do_btnUno_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSeis) {
			do_btnSeis_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnNueve) {
			do_btnNueve_actionPerformed(arg0);
		}
	}
	protected void do_btnNueve_actionPerformed(ActionEvent arg0) {
		
		
	
		if(turno==1){

		txtCaja.setForeground(SystemColor.windowBorder);
		txtCaja.setText(txtCaja.getText()+9);
		
		
		}else if(turno==2){	
		
			txtCaja.setText("");
			txtCaja.setText(txtCaja.getText()+9);
			txtCaja.setForeground(SystemColor.windowBorder);
				turno=3;
		
			
		
		
			
		

		}else{
				txtCaja.setText(txtCaja.getText()+9);
				txtU.setVisible(true);
				txtU.setText(memoria1+" "+signo);
				txtCaja.setForeground(SystemColor.windowBorder);
			
		
	}
		
	}
	
	protected void do_btnSeis_actionPerformed(ActionEvent arg0) {

		if(turno==1){

		txtCaja.setForeground(SystemColor.windowBorder);
		txtCaja.setText(txtCaja.getText()+6);
		
		
		}else if(turno==2){	
			txtCaja.setText("");
			txtCaja.setText(txtCaja.getText()+6);
			txtCaja.setForeground(SystemColor.windowBorder);
			
				turno=3;
		
			
		
		
			
		

		}else{
				txtCaja.setText(txtCaja.getText()+6);
				txtU.setVisible(true);
				txtU.setText(memoria1+" "+signo);
				txtCaja.setForeground(SystemColor.windowBorder);
		}
			
		
	}

	protected void do_btnUno_actionPerformed(ActionEvent arg0) {
	
		if(turno==1){

			txtCaja.setForeground(SystemColor.windowBorder);
			txtCaja.setText(txtCaja.getText()+1);
			
			
			}else if(turno==2){	
				txtCaja.setText("");
				txtCaja.setText(txtCaja.getText()+1);
				txtCaja.setForeground(SystemColor.windowBorder);
				
					turno=3;
			
				
			
			
				
			

			}else{
					txtCaja.setText(txtCaja.getText()+1);
					txtU.setVisible(true);
					txtU.setText(memoria1+" "+signo);
					txtCaja.setForeground(SystemColor.windowBorder);
			}
				
			
		}
	protected void do_btnDos_actionPerformed(ActionEvent arg0) {

		if(turno==1){

			txtCaja.setForeground(SystemColor.windowBorder);
			txtCaja.setText(txtCaja.getText()+2);
			
			
			}else if(turno==2){	
				txtCaja.setText("");
				txtCaja.setText(txtCaja.getText()+2);
				txtCaja.setForeground(SystemColor.windowBorder);
				
					turno=3;
			
				
			
			
				
			

			}else{
					txtCaja.setText(txtCaja.getText()+2);
					txtU.setVisible(true);
					txtU.setText(memoria1+" "+signo);
					txtCaja.setForeground(SystemColor.windowBorder);
			}
				
			
		}
	
	protected void do_btnTres_actionPerformed(ActionEvent arg0) {

		if(turno==1){

			txtCaja.setForeground(SystemColor.windowBorder);
			txtCaja.setText(txtCaja.getText()+3);
			
			
			}else if(turno==2){	
				txtCaja.setText("");
				txtCaja.setText(txtCaja.getText()+3);
				txtCaja.setForeground(SystemColor.windowBorder);
				
					turno=3;
			
				
			
			
				
			

			}else{
					txtCaja.setText(txtCaja.getText()+3);
					txtU.setVisible(true);
					txtU.setText(memoria1+" "+signo);
					txtCaja.setForeground(SystemColor.windowBorder);
			}
				
			
		}

	
	protected void do_btnCuatro_actionPerformed(ActionEvent arg0) {

		if(turno==1){

			txtCaja.setForeground(SystemColor.windowBorder);
			txtCaja.setText(txtCaja.getText()+4);
			
			
			}else if(turno==2){	
				txtCaja.setText("");
				txtCaja.setText(txtCaja.getText()+4);
				txtCaja.setForeground(SystemColor.windowBorder);
				
					turno=3;
			
				
			
			
				
			

			}else{
					txtCaja.setText(txtCaja.getText()+4);
					txtU.setVisible(true);
					txtU.setText(memoria1+" "+signo);
					txtCaja.setForeground(SystemColor.windowBorder);
			}
				
			
		}
	protected void do_btnCinco_actionPerformed(ActionEvent arg0) {

		if(turno==1){

			txtCaja.setForeground(SystemColor.windowBorder);
			txtCaja.setText(txtCaja.getText()+5);
			
			
			}else if(turno==2){	
				txtCaja.setText("");
				txtCaja.setText(txtCaja.getText()+5);
				txtCaja.setForeground(SystemColor.windowBorder);
				
					turno=3;
			
				
			
			
				
			

			}else{
					txtCaja.setText(txtCaja.getText()+5);
					txtU.setVisible(true);
					txtU.setText(memoria1+" "+signo);
					txtCaja.setForeground(SystemColor.windowBorder);
			}
				
			
		}
	protected void do_btnSiete_actionPerformed(ActionEvent arg0) {

		if(turno==1){

			txtCaja.setForeground(SystemColor.windowBorder);
			txtCaja.setText(txtCaja.getText()+7);
			
			
			}else if(turno==2){	
				txtCaja.setText("");
				txtCaja.setText(txtCaja.getText()+7);
				txtCaja.setForeground(SystemColor.windowBorder);
				
					turno=3;
			
				
			
			
				
			

			}else{
					txtCaja.setText(txtCaja.getText()+7);
					txtU.setVisible(true);
					txtU.setText(memoria1+" "+signo);
					txtCaja.setForeground(SystemColor.windowBorder);
			}
				
			
		}
	protected void do_btnOcho_actionPerformed(ActionEvent arg0) {

		if(turno==1){

			txtCaja.setForeground(SystemColor.windowBorder);
			txtCaja.setText(txtCaja.getText()+8);
			
			
			}else if(turno==2){	
				txtCaja.setText("");
				txtCaja.setText(txtCaja.getText()+8);
				txtCaja.setForeground(SystemColor.windowBorder);
				
					turno=3;
			
				
			
			
				
			

			}else{
					txtCaja.setText(txtCaja.getText()+8);
					txtU.setVisible(true);
					txtU.setText(memoria1+" "+signo);
					txtCaja.setForeground(SystemColor.windowBorder);
			}
				
			
		}
	
	protected void do_btn0_actionPerformed(ActionEvent arg0) {

		if(turno==1){

			txtCaja.setForeground(SystemColor.windowBorder);
			txtCaja.setText(txtCaja.getText()+0);
			
			
			}else if(turno==2){	
				txtCaja.setText("");
				txtCaja.setText(txtCaja.getText()+0);
				txtCaja.setForeground(SystemColor.windowBorder);
				
					turno=3;
			
				
			
			
				
			

			}else{
					txtCaja.setText(txtCaja.getText()+0);
					txtU.setVisible(true);
					txtU.setText(memoria1+" "+signo);
					txtCaja.setForeground(SystemColor.windowBorder);
			}
				
			
		}
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnH) {
			do_btnH_mouseEntered(arg0);
		}
	
		if (arg0.getSource() == btnC) {
			do_btnC_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnMenos) {
			do_btnMenos_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnIgual) {
			do_btnIgual_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnL) {
			do_btnL_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnPunto) {
			do_btnPunto_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnDivi) {
			do_btnDivi_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnPor) {
			do_btnPor_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnMas) {
			do_btnMas_mouseEntered(arg0);
		}
	
		if (arg0.getSource() == btn0) {
			do_btn0_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnNueve) {
			do_btnNueve_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnOcho) {
			do_btnOcho_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnSiete) {
			do_btnSiete_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnSeis) {
			do_btnSeis_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnCinco) {
			do_btnCinco_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnCuatro) {
			do_btnCuatro_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnTres) {
			do_btnTres_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnDos) {
			do_btnDos_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnUno) {
			do_btnUno_mouseEntered(arg0);
		}
	}
	public void mouseExited(MouseEvent arg0) {
		btnUno.setBackground(Color.DARK_GRAY);
		btnDos.setBackground(Color.DARK_GRAY);
		btnTres.setBackground(Color.DARK_GRAY);
		btnCuatro.setBackground(Color.DARK_GRAY);
		btnCinco.setBackground(Color.DARK_GRAY);
		btnSeis.setBackground(Color.DARK_GRAY);
		btnSiete.setBackground(Color.DARK_GRAY);
		btnOcho.setBackground(Color.DARK_GRAY);
		btnNueve.setBackground(Color.DARK_GRAY);
		btn0.setBackground(Color.DARK_GRAY);
		btnMas.setBackground(SystemColor.windowBorder);
		btnPor.setBackground(SystemColor.windowBorder);
		btnDivi.setBackground(SystemColor.windowBorder);
		btnPunto.setBackground(Color.DARK_GRAY);
		btnIgual.setBackground(new Color(255, 165, 0));
		btnMenos.setBackground(SystemColor.windowBorder);
		btnC.setBackground(new Color(128, 0, 0));
		btnH.setBackground(Color.DARK_GRAY);
		
		
		

		

		
	
	}
	public void mousePressed(MouseEvent arg0) {
		
	}
	public void mouseReleased(MouseEvent arg0) {
		
	
	}
	protected void do_btnUno_mouseEntered(MouseEvent arg0) {
		btnUno.setBackground(new Color(0, 128, 0));
	}
	protected void do_btnTres_mouseEntered(MouseEvent arg0) {
		btnTres.setBackground(new Color(0, 128, 0));
	}
	protected void do_btnCuatro_mouseEntered(MouseEvent arg0) {
		btnCuatro.setBackground(new Color(0, 128, 0));
	}
	protected void do_btnCinco_mouseEntered(MouseEvent arg0) {
		btnCinco.setBackground(new Color(0, 128, 0));
	}
	protected void do_btnSeis_mouseEntered(MouseEvent arg0) {
		btnSeis.setBackground(new Color(0, 128, 0));
	}
	protected void do_btnSiete_mouseEntered(MouseEvent arg0) {
		btnSiete.setBackground(new Color(0, 128, 0));
	}
	protected void do_btnOcho_mouseEntered(MouseEvent arg0) {
		btnOcho.setBackground(new Color(0, 128, 0));
	}
	protected void do_btnNueve_mouseEntered(MouseEvent arg0) {
		btnNueve.setBackground(new Color(0, 128, 0));
	}
	protected void do_btnDos_mouseEntered(MouseEvent arg0) {
		btnDos.setBackground(new Color(0, 128, 0));
	}
	protected void do_btn0_mouseEntered(MouseEvent arg0) {
		btn0.setBackground(new Color(0, 128, 0));
	
	}
	protected void do_btnMas_actionPerformed(ActionEvent arg0) {
		
		turno=2;
		
		memoria1=txtCaja.getText();
		signo="+";
		
		lblIngreseElNumero.setVisible(false);
		txtU.setVisible(true);
		txtU.setText(memoria1+" "+"+");
	
		
		
		
	}
	protected void do_btnPor_actionPerformed(ActionEvent arg0) {
		
		turno=2;
		
		memoria1=txtCaja.getText();
		signo="*";
		
		lblIngreseElNumero.setVisible(false);
		txtU.setVisible(true);
		txtU.setText(memoria1+" "+"*");
	
	
		

	}
	protected void do_btnPunto_actionPerformed(ActionEvent arg0) {
		
			txtU.setVisible(true);	
		String cadena;
		cadena=txtCaja.getText();
		
		if(cadena.length()<=0){
			txtCaja.setForeground(SystemColor.windowBorder);
			txtCaja.setText("0.");
			
		
			

		}
		
		else{
			if(!existe(txtCaja.getText())){
				txtCaja.setText(txtCaja.getText()+".");
			
			

				
			}
		}
		
	
		}
		

			
			
		
			
			
			
		
		
	
	
	public static boolean existe(String cadena){
		boolean resultado=false;
		
		for(int i=0;i<cadena.length();i++){
			if(cadena.substring(i,i+1).equals(".")){
				resultado=true;
				break;
				
			}
		}
		return resultado;
	}
	
	
	
	
	
	protected void do_btnDivi_actionPerformed(ActionEvent arg0) {
		
		
		turno=2;
		
		memoria1=txtCaja.getText();
		signo="/";
		
		lblIngreseElNumero.setVisible(false);
		txtU.setVisible(true);
		txtU.setText(memoria1+" "+"/");
	
		
	

		}	
		
	
			
		
	
	
	protected void do_btnMas_mouseEntered(MouseEvent arg0) {
		btnMas.setBackground(new Color(128, 128, 128));
	
	}
	protected void do_btnPor_mouseEntered(MouseEvent arg0) {
		btnPor.setBackground(new Color(128, 128, 128));
		
	}
	protected void do_btnDivi_mouseEntered(MouseEvent arg0) {
		btnDivi.setBackground(new Color(128, 128, 128));
	}
	protected void do_btnPunto_mouseEntered(MouseEvent arg0) {
		btnPunto.setBackground(new Color(0, 128, 0));
		
	}
	protected void do_btnL_actionPerformed(ActionEvent arg0) {
		
		
		txtCaja.setText("");
		txtU.setText("");
		memoria1="";
		signo="";
	
		
	}
	protected void do_btnL_mouseEntered(MouseEvent arg0) {
	
  }
	protected void do_btnIgual_mouseEntered(MouseEvent arg0) {
		btnIgual.setBackground(new Color(255, 140, 0));
		
		
		
	}
	protected void do_btnMenos_mouseEntered(MouseEvent arg0) {
		btnMenos.setBackground(new Color(128, 128, 128));
		
	}
	protected void do_btnMenos_actionPerformed(ActionEvent arg0) {
		
	
	
		
		turno=2;
		
		memoria1=txtCaja.getText();
		signo="-";
		
		lblIngreseElNumero.setVisible(false);
		txtU.setVisible(true);
		txtU.setText(memoria1+" "+"-");
	
		
	

		
		
		
		
			


	}
	protected void do_btnIgual_actionPerformed(ActionEvent arg0) {
		
		
		String resultado;
		memoria2=txtCaja.getText();
		
		if(!memoria2.equals("")){
			
			resultado=calculadora(memoria1,memoria2,signo);
				txtU.setText("");
				txtCaja.setText(resultado);
			}
		}
			

			
		
		
		
	
	
	
	
	
	public static String calculadora (String memoria1,String memoria2,String signo){
		
		Double resultado=0.0;
		String respuesta;
		
		if(signo.equals("-")){
			
			
			resultado=Double.parseDouble(memoria1)-Double.parseDouble(memoria2);
			
		}
	
		if(signo.equals("+")){
			
			
			resultado=Double.parseDouble(memoria1)+Double.parseDouble(memoria2);
			
		}
		if(signo.equals("*")){
			
			
			resultado=Double.parseDouble(memoria1)*Double.parseDouble(memoria2);
			
		}
		if(signo.equals("/")){
			
			
			resultado=Double.parseDouble(memoria1)/Double.parseDouble(memoria2);
			
		}
	
	
		respuesta=resultado.toString();
		
		return respuesta;
	
	}
	protected void do_btnC_actionPerformed(ActionEvent arg0) {
		
		String cadena;
		cadena=txtCaja.getText();
		
		if(cadena.length()>0){
			cadena=cadena.substring(0,cadena.length()-1);
			txtCaja.setText(cadena);
		}
		
		memoria1="";
		signo="";
	
		
		

	}
	protected void do_btnC_mouseEntered(MouseEvent arg0) {
			}
	protected void do_btnPromedio_actionPerformed(ActionEvent arg0) {
		
		double raiz;
		double res;
	
		
		String cadena;
		cadena=txtCaja.getText();
		raiz=Double.parseDouble(cadena);
		res=Math.sqrt(raiz);
		
		
		cadena=Double.toString(res);
		txtCaja.setText(cadena);
		
		
		
		
		
		
		
		
		
		
	

	}
	protected void do_btnH_actionPerformed(ActionEvent arg0) {
	}

	protected void do_btnH_mouseEntered(MouseEvent arg0) {
		btnH.setBackground(Color.BLACK);
	}
	protected void do_btnX_actionPerformed(ActionEvent arg0) {
		
		String cuadrado=txtCaja.getText();
		double x;
		double x2;
		
		x=Double.parseDouble(cuadrado);
		x2=x*x;
		cuadrado=Double.toString(x2);
		txtCaja.setText(cuadrado);
		
		
		
		
		
		
		
	}
	protected void do_btncubo_actionPerformed(ActionEvent arg0) {
		String cubo=txtCaja.getText();
		double x;
		double x2;
		
		x=Double.parseDouble(cubo);
		x2=x*x*x;
		cubo=Double.toString(x2);
		txtCaja.setText(cubo);
		
	}
	protected void do_btnP_actionPerformed(ActionEvent arg0) {
	
		
		
		
	}
	protected void do_btnPi_actionPerformed(ActionEvent arg0) {
		btnUno.setVisible(false);
		btnDos.setVisible(false);
		btnTres.setVisible(false);
		btnCuatro.setVisible(false);
		btnCinco.setVisible(false);
		btnSeis.setVisible(false);
		btnSiete.setVisible(false);
		btnOcho.setVisible(false);
		btnNueve.setVisible(false);
		btn0.setVisible(false);
		btnMas.setVisible(false);
		btnPor.setVisible(false);
		btnDivi.setVisible(false);
		btnPunto.setVisible(false);
		btnIgual.setVisible(false);
		btnMenos.setVisible(false);
		btnC.setVisible(false);
		btnH.setVisible(false);
		txtU.setVisible(false);
		btnL.setVisible(false);
		btnraiz.setVisible(false);
		btnX.setVisible(false);
		btncubo.setVisible(false);
		btnPi.setVisible(false);
		btnP.setVisible(false);
		btnConteo.setVisible(false);
		
		panel.setVisible(true);
		setTitle("Par/Impar");

		
	}
}