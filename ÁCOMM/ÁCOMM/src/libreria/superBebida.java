package libreria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Properties;

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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Clases.claseBebida;
import Clases.claseUsuario;
import Formulario.Bebida;
import Formulario.Usuario;

public class superBebida extends JFrame implements MouseListener, MouseMotionListener, ActionListener, KeyListener,Printable {

	private JPanel contentPane;
	private JLabel lbl1;
	private JPanel panel;
	private JPanel panelfondo;
	public static  JTextField txtC;
	private JLabel lbuscar;
	private JLabel lblN;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblConsultar;
	private JLabel label;
	private JLabel lblConsultaDeUsuarios;
	private JLabel lblAcomm;
	private JLabel lblTipoDeConsulta;
	private JButton btndatos;
	private JPanel panelB;
	private JButton btndatalle;
	private JLabel label_f;
	private JPanel panel_c;
	private JTextField txtc;
	private JTextField txtc2;
	private JPanel panel_1;
	private JLabel lblEstadisticas;
	private JButton btnPastel;
	private JTextField txtc3;
	private JPanel panel_2;
	private JLabel lblExportar;
	private JButton btnExportar;
	private JTextField txtc5;
	private JButton btnSalir;
	private JTextField txtc6;
	TableRowSorter<DefaultTableModel> buscar1;
	TableRowSorter<DefaultTableModel> buscar2;
	TableRowSorter<DefaultTableModel> buscar3;
	TableRowSorter<DefaultTableModel> buscar4;
	DefaultTableModel d=new DefaultTableModel();
	DefaultTableModel d2=new DefaultTableModel();
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
					superBebida frame = new superBebida();
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
	public  superBebida() {
		
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 713);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		contentPane.addMouseMotionListener(this);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lbl1 = new JLabel("");
		lbl1.setBounds(235, 0, 807, 53);	
		ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/anaran.png"));
		ImageIcon icon1=new ImageIcon(fondo1.getImage().getScaledInstance(lbl1.getWidth(),	lbl1.getHeight(),Image.SCALE_DEFAULT));
		
		lblNewLabel_1 = new JLabel("Bebidas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(969, 23, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(superBebida.class.getResource("/img/bebida.png")));
		lblNewLabel.setBounds(927, 5, 32, 41);
		contentPane.add(lblNewLabel);
		lbl1.setIcon(icon1);
		contentPane.add(lbl1);
		
		
		
		lblConsultar = new JLabel("   SuperConsulta/Acomm");
		lblConsultar.setForeground(Color.WHITE);
		lblConsultar.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblConsultar.setBounds(10, 13, 226, 30);
		contentPane.add(lblConsultar);
		
		lblN = new JLabel("");
		lblN.setBounds(0, 0, 236, 53);
		ImageIcon fondo10=new ImageIcon(getClass().getResource("/img/cuadrozul.png"));
		ImageIcon icon10=new ImageIcon(fondo10.getImage().getScaledInstance(lblN.getWidth(),lblN.getHeight(),Image.SCALE_DEFAULT));
		lblN.setIcon(new ImageIcon(superBebida.class.getResource("/img/anaran2.png")));
		contentPane.add(lblN);
	
		
		panelfondo = new JPanel();
		panelfondo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelfondo.setBackground(SystemColor.menuText);
		panelfondo.setBounds(0, 52, 236, 634);
		contentPane.add(panelfondo);
		panelfondo.setLayout(null);
		
		label = new JLabel("");
		label.setBounds(10, 2, 80, 79);
		ImageIcon fondo11=new ImageIcon(getClass().getResource("/img/bebidajava.png"));
		ImageIcon icon11=new ImageIcon(fondo11.getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_DEFAULT));
		
		
		txtC = new JTextField();
		txtC.addKeyListener(this);
		txtC.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtC.setForeground(Color.LIGHT_GRAY);
		txtC.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
		txtC.setBackground(Color.DARK_GRAY);
		txtC.setBounds(10, 98, 152, 41);
		txtC.setColumns(10);
		panelfondo.add(txtC);
			
		
		txtc6 = new JTextField();
		txtc6.setEditable(false);
		txtc6.setColumns(10);
		txtc6.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtc6.setBackground(new Color(124, 252, 0));
		txtc6.setBounds(231, 573, 5, 50);
		panelfondo.add(txtc6);
		
		btnSalir = new JButton("Salir");
		btnSalir.setOpaque(false);
		btnSalir.setRolloverEnabled(false);
		btnSalir.setRequestFocusEnabled(false);
		btnSalir.setDefaultCapable(false);
		btnSalir.setBorderPainted(false);
		btnSalir.addActionListener(this);
		btnSalir.addMouseListener(this);
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setForeground(Color.GRAY);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalir.setFocusable(false);
		btnSalir.setFocusTraversalKeysEnabled(false);
		btnSalir.setFocusPainted(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorder(new LineBorder(new Color(64, 64, 64), 0));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(0, 573, 232, 50);
		panelfondo.add(btnSalir);
		
		txtc5 = new JTextField();
		txtc5.setEditable(false);
		txtc5.setColumns(10);
		txtc5.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtc5.setBackground(new Color(255, 0, 0));
		txtc5.setBounds(231, 494, 5, 50);
		panelfondo.add(txtc5);
		
		btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(this);
		btnExportar.addMouseListener(this);
		btnExportar.setContentAreaFilled(false);
		btnExportar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExportar.setForeground(Color.GRAY);
		btnExportar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExportar.setFocusable(false);
		btnExportar.setFocusTraversalKeysEnabled(false);
		btnExportar.setFocusPainted(false);
		btnExportar.setBorder(new LineBorder(new Color(64, 64, 64), 0));
		btnExportar.setBackground(Color.BLACK);
		btnExportar.setBounds(0, 493, 232, 50);
		panelfondo.add(btnExportar);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 423, 236, 45);
		panelfondo.add(panel_2);
		
		lblExportar = new JLabel("Exportar Datos");
		lblExportar.setForeground(Color.DARK_GRAY);
		lblExportar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExportar.setBounds(14, 11, 153, 23);
		panel_2.add(lblExportar);
		
		txtc3 = new JTextField();
		txtc3.setEditable(false);
		txtc3.setColumns(10);
		txtc3.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtc3.setBackground(new Color(255, 140, 0));
		txtc3.setBounds(231, 364, 5, 48);
		panelfondo.add(txtc3);
		
		btnPastel = new JButton("Grafico Pastel");
		btnPastel.addActionListener(this);
		btnPastel.addMouseListener(this);
		btnPastel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPastel.setContentAreaFilled(false);
		btnPastel.setForeground(Color.GRAY);
		btnPastel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPastel.setFocusable(false);
		btnPastel.setFocusTraversalKeysEnabled(false);
		btnPastel.setFocusPainted(false);
		btnPastel.setBorder(new LineBorder(new Color(64, 64, 64), 0));
		btnPastel.setBackground(Color.BLACK);
		btnPastel.setBounds(0, 363, 232, 50);
		panelfondo.add(btnPastel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 319, 236, 45);
		panelfondo.add(panel_1);
		panel_1.setLayout(null);
		
		lblEstadisticas = new JLabel("Estadisticas");
		lblEstadisticas.setForeground(Color.DARK_GRAY);
		lblEstadisticas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstadisticas.setBounds(14, 11, 153, 23);
		panel_1.add(lblEstadisticas);
		
		txtc2 =new JTextField();
		txtc2.setEditable(false);
		txtc2.setColumns(10);
		txtc2.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtc2.setBackground(new Color(0, 128, 0));
		txtc2.setBounds(231, 244, 5, 48);
		panelfondo.add(txtc2);
		
		txtc = new JTextField();
		txtc.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtc.setEditable(false);
		txtc.setBackground(new Color(65, 105, 225));
		txtc.setBounds(231, 195, 5, 47);
		panelfondo.add(txtc);
		txtc.setColumns(10);
		
		lblTipoDeConsulta = new JLabel("Tipo de Consulta");
		lblTipoDeConsulta.setForeground(Color.DARK_GRAY);
		lblTipoDeConsulta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoDeConsulta.setBounds(18, 163, 152, 23);
		panelfondo.add(lblTipoDeConsulta);
		
		panel_c = new JPanel();
		panel_c.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_c.setBackground(Color.BLACK);
		panel_c.setBounds(0, 150, 236, 45);
		panelfondo.add(panel_c);
		label.setIcon(icon11);
		panelfondo.add(label);
		
		lblConsultaDeUsuarios = new JLabel("Consulta  de \r\n");
		lblConsultaDeUsuarios.setForeground(Color.WHITE);
		lblConsultaDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConsultaDeUsuarios.setBounds(95, 11, 92, 30);
		panelfondo.add(lblConsultaDeUsuarios);
		
		lblAcomm = new JLabel("Bebidas");
		lblAcomm.setForeground(Color.WHITE);
		lblAcomm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAcomm.setBounds(98, 32, 64, 30);
		panelfondo.add(lblAcomm);
		
		btndatos = new JButton("Datos de Bebidas");
		btndatos.addActionListener(this);
		btndatos.setContentAreaFilled(false);
		btndatos.addMouseListener(this);
		btndatos.setForeground(Color.GRAY);
		btndatos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btndatos.setBorder(new LineBorder(new Color(64, 64, 64), 0));
		btndatos.setFocusable(false);
		btndatos.setFocusPainted(false);
		btndatos.setFocusTraversalKeysEnabled(false);
		btndatos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btndatos.setBackground(Color.BLACK);
		btndatos.setBounds(0, 193, 232, 50);
		panelfondo.add(btndatos);
		
		panelB = new JPanel();
		panelB.setBackground(Color.DARK_GRAY);
		panelB.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelB.setBounds(162, 98, 61, 41);
		panelfondo.add(panelB);
		panelB.setLayout(null);
		
		lbuscar = new JLabel("");
		lbuscar.setBounds(0, 0, 61, 41);
		panelB.add(lbuscar);
		lbuscar.setIcon(new ImageIcon(superConsulta.class.getResource("/img/buscarbi.png")));
		
		btndatalle = new JButton("Detalle de Bebida");
		btndatalle.addActionListener(this);
		btndatalle.addMouseListener(this);
		btndatalle.setContentAreaFilled(false);
		btndatalle.setDefaultCapable(false);
		btndatalle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btndatalle.setForeground(Color.GRAY);
		btndatalle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btndatalle.setFocusable(false);
		btndatalle.setFocusTraversalKeysEnabled(false);
		btndatalle.setFocusPainted(false);
		btndatalle.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btndatalle.setBackground(Color.BLACK);
		btndatalle.setBounds(0, 243, 232, 50);
		panelfondo.add(btndatalle);
		
		label_f = new JLabel("");
		label_f.setBounds(0, 2, 237, 621);
		ImageIcon fondo13=new ImageIcon(getClass().getResource("/img/gray.png"));
		ImageIcon icon13=new ImageIcon(fondo13.getImage().getScaledInstance(label_f.getWidth(),label_f.getHeight(),Image.SCALE_DEFAULT));
		label_f.setIcon(icon13);
		panelfondo.add(label_f);
		lbuscar.setVisible(true);
		lbuscar.setVisible(true);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setBounds(236, 52, 807, 623);
		contentPane.add(panel);
		panel.setLayout(null);
		
		paneltabla = new JPanel();
		paneltabla.setBackground(Color.WHITE);
		paneltabla.setBorder(new LineBorder(new Color(192, 192, 192), 0));
		paneltabla.setBounds(10, 11, 787, 601);
		panel.add(paneltabla);
		paneltabla.setLayout(null);
		
		panelexportar = new JPanel();
		panelexportar.setVisible(false);
		
		panelDetalle = new JPanel();
		panelDetalle.setVisible(false);
		
		panelPastel = new JPanel();
		panelPastel.setVisible(false);
		
   
			
			panelPastel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
			panelPastel.setBackground(Color.WHITE);
			panelPastel.setBounds(0, 0, 787, 601);
			paneltabla.add(panelPastel);
			panelPastel.setLayout(null);
			
			panelde = new JPanel();
			panelde.setBackground(new Color(65, 105, 225));
			panelde.setBorder(new LineBorder(new Color(0, 0, 0), 0));
			panelde.setBounds(476, 68, 101, 30);
			panelPastel.add(panelde);
			panelde.setLayout(null);
			
			lblBebidas = new JLabel("Bebidas");
			lblBebidas.setForeground(Color.WHITE);
			lblBebidas.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblBebidas.setBounds(10, 0, 61, 30);
			panelde.add(lblBebidas);
			
			lbcanusua = new JLabel("");
			lbcanusua.setForeground(Color.WHITE);
			lbcanusua.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbcanusua.setBounds(672, 68, 50, 30);
			panelPastel.add(lbcanusua);
			
			lbsupe = new JLabel("");
			lbsupe.setForeground(Color.GRAY);
			lbsupe.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbsupe.setBounds(660, 385, 60, 30);
			panelPastel.add(lbsupe);
			
			lbmosu = new JLabel("");
			lbmosu.setForeground(Color.GRAY);
			lbmosu.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbmosu.setBounds(662, 508, 60, 30);
			panelPastel.add(lbmosu);
			
			lbadmi = new JLabel("");
			lbadmi.setForeground(Color.GRAY);
			lbadmi.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbadmi.setBounds(660, 279, 60, 30);
			panelPastel.add(lbadmi);
			
			lblMozos = new JLabel("Whiskv");
			lblMozos.setForeground(Color.GRAY);
			lblMozos.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblMozos.setBounds(662, 464, 60, 30);
			panelPastel.add(lblMozos);
			
			lblSupervisor = new JLabel("Vinos");
			lblSupervisor.setForeground(Color.GRAY);
			lblSupervisor.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSupervisor.setBounds(650, 347, 127, 30);
			panelPastel.add(lblSupervisor);
			
			lblAdministradores = new JLabel("Cerveza");
			lblAdministradores.setForeground(Color.GRAY);
			lblAdministradores.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblAdministradores.setBounds(650, 245, 127, 30);
			panelPastel.add(lblAdministradores);
			
			panelPas = new JPanel();
			panelPas.setForeground(Color.DARK_GRAY);
			panelPas.setBackground(Color.WHITE);
			panelPas.setBorder(new LineBorder(new Color(0, 0, 0), 0));
			panelPas.setBounds(10, 180, 501, 421);
			panelPastel.add(panelPas);
			
			panel_color2 = new JPanel();
			panel_color2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
			panel_color2.setBackground(new Color(0, 128, 0));
			panel_color2.setBounds(532, 201, 250, 6);
			panelPastel.add(panel_color2);
			
			label_2 = new JLabel("");
			label_2.setIcon(new ImageIcon(superConsulta.class.getResource("/img/paterno.png")));
			label_2.setBounds(521, 224, 256, 98);
			panelPastel.add(label_2);
			
			label_3 = new JLabel("");
			label_3.setIcon(new ImageIcon(superConsulta.class.getResource("/img/nombre.png")));
			label_3.setBounds(521, 333, 256, 98);
			panelPastel.add(label_3);
			
			label_4 = new JLabel("");
			label_4.setIcon(new ImageIcon(superConsulta.class.getResource("/img/materno.png")));
			label_4.setBounds(521, 454, 256, 98);
			panelPastel.add(label_4);
			
			lblCantidades = new JLabel("Cantidades");
			lblCantidades.setForeground(Color.DARK_GRAY);
			lblCantidades.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblCantidades.setBounds(604, 154, 101, 30);
			panelPastel.add(lblCantidades);
			
			lblRegistroDetallados = new JLabel("Registro de Precios");
			lblRegistroDetallados.setForeground(Color.DARK_GRAY);
			lblRegistroDetallados.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblRegistroDetallados.setBounds(159, 154, 147, 30);
			panelPastel.add(lblRegistroDetallados);
			
			btnImprimir1 = new JButton("");
			btnImprimir1.addActionListener(this);
			btnImprimir1.setContentAreaFilled(false);
			btnImprimir1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
			btnImprimir1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnImprimir1.setFocusPainted(false);
			btnImprimir1.setFocusTraversalKeysEnabled(false);
			btnImprimir1.setFocusable(false);
			btnImprimir1.setIcon(new ImageIcon(superConsulta.class.getResource("/img/amarilloIm.png")));
			btnImprimir1.setBounds(39, 35, 298, 108);
			panelPastel.add(btnImprimir1);
			
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(superConsulta.class.getResource("/img/azulusua.png")));
			lblNewLabel_2.setBounds(450, 35, 337, 123);
			panelPastel.add(lblNewLabel_2);
			
			lblExportar_1 = new JLabel("Exportar");
			lblExportar_1.setForeground(Color.GRAY);
			lblExportar_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblExportar_1.setBounds(158, 11, 71, 19);
			panelPastel.add(lblExportar_1);
			
			lblResgistrados = new JLabel("Registrados");
			lblResgistrados.setForeground(Color.GRAY);
			lblResgistrados.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblResgistrados.setBounds(545, 14, 101, 19);
			panelPastel.add(lblResgistrados);
			
        
        panel_color = new JPanel();
        panel_color.setBounds(0, 17, 491, 6);
        panelPas.add(panel_color);
        panel_color.setBackground(new Color(32, 178, 170));
        panel_color.setBorder(new LineBorder(new Color(0, 0, 0), 0));
        
        
		panelDetalle.setBorder(new LineBorder(new Color(100, 100, 100), 0));
		panelDetalle.setBounds(0, 0, 787, 154);
		paneltabla.add(panelDetalle);
		panelDetalle.setLayout(null);
		
		cmbMaterno = new JComboBox();
		cmbMaterno.addMouseListener(this);
		cmbMaterno.addActionListener(this);
		cmbMaterno.addKeyListener(this);
		cmbMaterno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbMaterno.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		cmbMaterno.setBounds(640, 78, 136, 28);
		panelDetalle.add(cmbMaterno);
		
		cmbPaterno = new JComboBox();
		cmbPaterno.addMouseListener(this);
		cmbPaterno.addActionListener(this);
		cmbPaterno.addKeyListener(this);
		cmbPaterno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbPaterno.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		cmbPaterno.setBounds(374, 78, 136, 28);
		panelDetalle.add(cmbPaterno);
		
		cmbN = new JComboBox();
		cmbN.addMouseListener(this);
		cmbN.addActionListener(this);
		cmbN.addKeyListener(this);
		cmbN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbN.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		cmbN.setBounds(115, 78, 136, 28);
		panelDetalle.add(cmbN);
		
		lblApellidoMaterno = new JLabel("Tipo de Bebida");
		lblApellidoMaterno.setForeground(Color.GRAY);
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidoMaterno.setBounds(648, 50, 128, 14);
		panelDetalle.add(lblApellidoMaterno);
		
		lblApellidoPaterno = new JLabel("Marca");
		lblApellidoPaterno.setForeground(Color.GRAY);
		lblApellidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidoPaterno.setBounds(386, 50, 128, 14);
		panelDetalle.add(lblApellidoPaterno);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setForeground(Color.GRAY);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(128, 49, 98, 14);
		panelDetalle.add(lblNombre);
		
		labelN = new JLabel("");
		labelN.setIcon(new ImageIcon(superConsulta.class.getResource("/img/nombre.png")));
		labelN.setBounds(1, 36, 256, 98);
		panelDetalle.add(labelN);
		
		labelPater = new JLabel("");
		labelPater.setIcon(new ImageIcon(superConsulta.class.getResource("/img/paterno.png")));
		labelPater.setBounds(265,  36, 256, 98);
		panelDetalle.add(labelPater);
		
		label_Mater = new JLabel("");
		label_Mater.setIcon(new ImageIcon(superConsulta.class.getResource("/img/materno.png")));
		label_Mater.setBounds(530, 36, 257, 98);
		panelDetalle.add(label_Mater);
		
		lblSearchOne = new JLabel("Search one");
		lblSearchOne.setForeground(Color.DARK_GRAY);
		lblSearchOne.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSearchOne.setBounds(83, 11, 98, 14);
		panelDetalle.add(lblSearchOne);
		
		lblSearchTwo = new JLabel("Search two");
		lblSearchTwo.setForeground(Color.DARK_GRAY);
		lblSearchTwo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSearchTwo.setBounds(346, 11, 85, 14);
		panelDetalle.add(lblSearchTwo);
		
		lblSearchThree = new JLabel("Search three");
		lblSearchThree.setForeground(Color.DARK_GRAY);
		lblSearchThree.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSearchThree.setBounds(609, 12, 85, 14);
		panelDetalle.add(lblSearchThree);
		panelexportar.setBounds(0, 0, 787, 601);
		paneltabla.add(panelexportar);
		panelexportar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelexportar.setBackground(Color.WHITE);
		panelexportar.setLayout(null);
		
		paneltabla2 = new JPanel();
		paneltabla2.setVisible(false);
		paneltabla2.setBackground(Color.WHITE);
		paneltabla2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		paneltabla2.setBounds(10, 135, 767, 455);
		panelexportar.add(paneltabla2);
		paneltabla2.setLayout(null);
		
		scrollPane1 = new JScrollPane();
		scrollPane1.setBorder(new LineBorder(new Color(130, 135, 144), 0));
		scrollPane1.setBounds(10, 11, 747, 421);
		paneltabla2.add(scrollPane1);
		
		table2 = new JTable();
		table2.setGridColor(Color.LIGHT_GRAY);
		table2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		scrollPane1.setViewportView(table2);
		
		btnpdf = new JButton("");
		btnpdf.addActionListener(this);
		btnpdf.setIcon(new ImageIcon(superConsulta.class.getResource("/img/pdf.png")));
		btnpdf.setContentAreaFilled(false);
		btnpdf.setFocusPainted(false);
		btnpdf.setFocusable(false);
		btnpdf.setFocusTraversalKeysEnabled(false);
		btnpdf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnpdf.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnpdf.setBounds(4, 23, 190, 113);
		panelexportar.add(btnpdf);
		
		btnword = new JButton("");
		btnword.addActionListener(this);
		btnword.setIcon(new ImageIcon(superConsulta.class.getResource("/img/word.png")));
		btnword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnword.setFocusable(false);
		btnword.setFocusTraversalKeysEnabled(false);
		btnword.setFocusPainted(false);
		btnword.setContentAreaFilled(false);
		btnword.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnword.setBounds(200, 23, 190, 113);
		panelexportar.add(btnword);
		
		btnexcel = new JButton("");
		btnexcel.addActionListener(this);
		btnexcel.setIcon(new ImageIcon(superConsulta.class.getResource("/img/excel.png")));
		btnexcel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnexcel.setFocusable(false);
		btnexcel.setFocusTraversalKeysEnabled(false);
		btnexcel.setFocusPainted(false);
		btnexcel.setContentAreaFilled(false);
		btnexcel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnexcel.setBounds(397, 23, 190, 113);
		panelexportar.add(btnexcel);
		
		btncorreo = new JButton("");
		btncorreo.addActionListener(this);
		btncorreo.setIcon(new ImageIcon(superConsulta.class.getResource("/img/correo.png")));
		btncorreo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btncorreo.setFocusable(false);
		btncorreo.setFocusTraversalKeysEnabled(false);
		btncorreo.setFocusPainted(false);
		btncorreo.setContentAreaFilled(false);
		btncorreo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btncorreo.setBounds(592, 23, 190, 113);
		panelexportar.add(btncorreo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(new Color(227, 227, 227), 0));
		scrollPane.setBounds(10, 172, 767, 406);
		paneltabla.add(scrollPane);
		
		tables = new JTable();
		tables.setGridColor(SystemColor.controlHighlight);
		tables.setBackground(Color.WHITE);
		tables.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		scrollPane.setViewportView(tables);
		tables.setModel(d);
		
		txtsupervisar = new JLabel("");
		txtsupervisar.setForeground(Color.DARK_GRAY);
		txtsupervisar.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtsupervisar.setBounds(232, 101, 26, 23);
		paneltabla.add(txtsupervisar);
		
		lbmozo = new JLabel("");
		lbmozo.setForeground(Color.DARK_GRAY);
		lbmozo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbmozo.setBounds(232, 135, 26, 23);
		paneltabla.add(lbmozo);
		
		txtadministrador = new JLabel("");
		txtadministrador.setForeground(Color.DARK_GRAY);
		txtadministrador.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtadministrador.setBounds(232, 67, 26, 23);
		paneltabla.add(txtadministrador);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(superConsulta.class.getResource("/img/Ufoto.png")));
		label_1.setBounds(288, 57, 108, 67);
		paneltabla.add(label_1);
		
		lblDetalles = new JLabel("Detalles de Bebidas");
		lblDetalles.setForeground(Color.DARK_GRAY);
		lblDetalles.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDetalles.setBounds(75, 11, 118, 23);
		paneltabla.add(lblDetalles);
	
		
		d=new DefaultTableModel();
		d.addColumn("ID");
		d.addColumn("Nombres");
		d.addColumn("Marca");
		d.addColumn("Tipo");
		d.addColumn("Precio");
		d.addColumn("Estado");
	
		d2=new DefaultTableModel();
		d2.addColumn("ID");
		d2.addColumn("Nombres");	
		d2.addColumn("Marca");
		d2.addColumn("Tipo");
		d2.addColumn("Precio");
		d2.addColumn("Estado");
		
		
		txtAdministracion = new JTextField();
		txtAdministracion.setEditable(false);
		txtAdministracion.setBackground(new Color(30, 144, 255));
		txtAdministracion.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtAdministracion.setBounds(34, 74, 188, 9);
		paneltabla.add(txtAdministracion);
		txtAdministracion.setColumns(10);
		
		txtsupervisor = new JTextField();
		txtsupervisor.setEditable(false);
		txtsupervisor.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtsupervisor.setBackground(new Color(154, 205, 50));
		txtsupervisor.setColumns(10);
		txtsupervisor.setBounds(34, 108, 188, 9);
		paneltabla.add(txtsupervisor);
		
		txtMozo = new JTextField();
		txtMozo.setEditable(false);
		txtMozo.setBackground(new Color(178, 34, 34));
		txtMozo.setColumns(10);
		txtMozo.setBounds(34, 140, 188, 9);
		paneltabla.add(txtMozo);
		
		lblCantidadDeAdministradores = new JLabel("Cantidad de Cervezas");
		lblCantidadDeAdministradores.setForeground(Color.GRAY);
		lblCantidadDeAdministradores.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCantidadDeAdministradores.setBounds(34, 45, 171, 23);
		paneltabla.add(lblCantidadDeAdministradores);
		
		lblCantidadDeSupervisores = new JLabel("Cantidad de Vinos");
		lblCantidadDeSupervisores.setForeground(Color.GRAY);
		lblCantidadDeSupervisores.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCantidadDeSupervisores.setBounds(34, 88, 171, 23);
		paneltabla.add(lblCantidadDeSupervisores);
		
		lblCantidadDeMozos = new JLabel("Cantidad de Whisky");
		lblCantidadDeMozos.setForeground(Color.GRAY);
		lblCantidadDeMozos.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCantidadDeMozos.setBounds(34, 121, 171, 23);
		paneltabla.add(lblCantidadDeMozos);
		
		lblCantidadDeUsuarios = new JLabel("Bebidas");
		lblCantidadDeUsuarios.setForeground(Color.GRAY);
		lblCantidadDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidadDeUsuarios.setBounds(425, 60, 78, 23);
		paneltabla.add(lblCantidadDeUsuarios);
		
		lbcantidad = new JLabel("");
		lbcantidad.setForeground(Color.GRAY);
		lbcantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbcantidad.setBounds(444, 88, 26, 23);
		paneltabla.add(lbcantidad);
		
		lbusu = new JLabel("");
		lbusu.setBounds(564, 57, 57, 50);
		ImageIcon fondo14=new ImageIcon(getClass().getResource("/img/bebida.png"));
		ImageIcon icon14=new ImageIcon(fondo14.getImage().getScaledInstance(lbusu .getWidth(),lbusu.getHeight(),Image.SCALE_DEFAULT));
		lbusu.setIcon(icon14);
		paneltabla.add(lbusu);
		
		btnactulizar = new JButton("Informacion\r\n");
		btnactulizar.addActionListener(this);
		btnactulizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnactulizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnactulizar.setForeground(Color.GRAY);
		btnactulizar.setFocusable(false);
		btnactulizar.setFocusTraversalKeysEnabled(false);
		btnactulizar.setFocusPainted(false);
		btnactulizar.setDefaultCapable(false);
		btnactulizar.setContentAreaFilled(false);
		btnactulizar.setBounds(617, 57, 101, 50);
		paneltabla.add(btnactulizar);
		
		lblCantidad = new JLabel("Cantidad\r\n");
		lblCantidad.setForeground(Color.DARK_GRAY);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidad.setBounds(336, 11, 78, 23);
		paneltabla.add(lblCantidad);
		
		lblActualizar = new JLabel("Actualizar");
		lblActualizar.setForeground(Color.DARK_GRAY);
		lblActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblActualizar.setBounds(633, 15, 78, 23);
		paneltabla.add(lblActualizar);
		
		listar();
		listar2();
		contarAdministrador();
		contarSupervisor();
		contarMozo();
		buscarnivel2();
		
		
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == cmbMaterno) {
			mouseClickedCmbMaterno(arg0);
		}
		if (arg0.getSource() == cmbPaterno) {
			mouseClickedCmbPaterno(arg0);
		}
		if (arg0.getSource() == cmbN) {
			mouseClickedCmbN(arg0);
		}
		
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			mouseEnteredBtnSalir(arg0);
		}
		if (arg0.getSource() == btnExportar) {
			mouseEnteredBtnExportar(arg0);
		}
		if (arg0.getSource() == btnPastel) {
			mouseEnteredBtnPastel(arg0);
		}
		if (arg0.getSource() == btndatalle) {
			mouseEnteredBtndatalle(arg0);
		}
		if (arg0.getSource() == btndatos) {
			mouseEnteredBtndatos(arg0);
		}
	}
	public void mouseExited(MouseEvent arg0) {
	
		
		listar();
		

		
		btndatos.setIcon(null);
		txtc.setBounds(231, 195, 5, 47);
		
		btndatalle.setIcon(null);
		txtc2.setBounds(231, 244, 5, 48);
		
		btnPastel.setIcon(null);
		txtc3.setBounds(231, 364, 5, 48);
		
		
		btnExportar.setIcon(null);
		txtc5.setBounds(231, 494, 5, 50);
		
		btnSalir.setIcon(null);
		txtc6.setBounds(231, 573, 5, 50);
		
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	
	int cantidad=0;
	private void listar(){
		Connection c = null;
		try {
		
				Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		try {
	
			
	com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from bebidas");
			
	ResultSet r=p.executeQuery();

	d.setRowCount(0);
	while (r.next()) {

	
	d.addRow(new Object[]{r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getDouble(5),r.getString(6)});
		tables.setModel(d);
		h.put(r.getString(2),new claseBebida(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getDouble(5),r.getString(6)));
		h2.put(r.getString(3),new claseBebida(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getDouble(5),r.getString(6)));
		h3.put(r.getString(4),new claseBebida(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getDouble(5),r.getString(6)));
		
		lbcantidad.setText(String.valueOf(d.getRowCount()));
		lbcanusua.setText(String.valueOf(d.getRowCount()));

		
	}
		} catch (Exception e) {
			e.printStackTrace();
		
		}

}	
	
	
	private void listar2(){
		Connection c = null;
		try {
		
				Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		try {
	
			
	com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from bebidas");
			
	ResultSet r=p.executeQuery();

	d2.setRowCount(0);
	while (r.next()) {
		

		
	d2.addRow(new Object[]{r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getDouble(5),r.getString(6)});
		table2.setModel(d2);
		
		
	}
		} catch (Exception e) {
			e.printStackTrace();
		
		}

}		
	

	protected void mouseEnteredBtndatos(MouseEvent arg0) {

	txtc.setBounds(232, 195, 5, 47);
	}
	protected void mouseEnteredBtndatalle(MouseEvent arg0) {
		
		txtc2.setBounds(232, 244, 5, 48);
	}
	protected void mouseEnteredBtnPastel(MouseEvent arg0) {
		
		btnPastel.setIcon(new ImageIcon(superConsulta.class.getResource("/img/pastel.png")));
		txtc3.setBounds(232, 364, 5, 48);
	
	}
	protected void mouseEnteredBtnExportar(MouseEvent arg0) {
		btnExportar.setIcon(new ImageIcon(superConsulta.class.getResource("/img/exportarr.png")));
		txtc5.setBounds(232, 494, 5, 50);
	
	
	}
	protected void mouseEnteredBtnSalir(MouseEvent arg0) {
		btnSalir.setIcon(new ImageIcon(superConsulta.class.getResource("/img/salirr.png")));
		txtc6.setBounds(232, 573, 5, 50);
	
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == contentPane) {
			mouseDraggedContentPane(arg0);
		}
	}
	int x,y;
	private JPanel paneltabla;
	private JTable tables;
	private JScrollPane scrollPane;
	private JLabel lblDetalles;
	private JTextField txtAdministracion;
	private JTextField txtsupervisor;
	private JTextField txtMozo;
	private JLabel txtadministrador;
	private JLabel txtsupervisar;
	private JLabel lbmozo;
	private JLabel lblCantidadDeAdministradores;
	private JLabel lblCantidadDeSupervisores;
	private JLabel lblCantidadDeMozos;
	private JLabel label_1;
	private JLabel lblCantidadDeUsuarios;
	private JLabel lbcantidad;
	private JLabel lbusu;
	private JButton btnactulizar;
	private JLabel lblCantidad;
	private JLabel lblActualizar;
	private JPanel panelDetalle;
	private JLabel labelN;
	private JLabel labelPater;
	private JLabel label_Mater;
	private JLabel lblSearchOne;
	private JLabel lblSearchTwo;
	private JLabel lblSearchThree;
	private JLabel lblNombre;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JComboBox cmbN;
	private JComboBox cmbPaterno;
	private JComboBox cmbMaterno;
	private JPanel panelPastel;
	private JPanel panelPas;
	private JPanel panel_color;
	private JPanel panel_color2;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel lblAdministradores;
	private JLabel lblSupervisor;
	private JLabel lblMozos;
	private JLabel lbmosu;
	private JLabel lbsupe;
	private JLabel lbadmi;
	private JLabel lblCantidades;
	private JLabel lblRegistroDetallados;
	private JButton btnImprimir1;
	private JLabel lblNewLabel_2;
	private JLabel lblExportar_1;
	private JLabel lblResgistrados;
	private JLabel lbcanusua;
	private JPanel panelexportar;
	private JPanel paneltabla2;
	private JTable table2;
	private JScrollPane scrollPane1;
	private JButton btnpdf;
	private JButton btnword;
	private JButton btnexcel;
	private JButton btncorreo;
	private HashMap<String,claseBebida> h2=new HashMap<>();
	private HashMap<String,claseBebida> h3=new HashMap<>();
	public void mouseMoved(MouseEvent arg0) {

		x=arg0.getX();
		y=arg0.getY();
		
	}
	protected void mouseDraggedContentPane(MouseEvent arg0) {
		
		Point p=MouseInfo.getPointerInfo().getLocation();
		setLocation(p.x-x, p.y-y);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnImprimir1) {
			actionPerformedBtnImprimir1(arg0);
		}
		if (arg0.getSource() == cmbN) {
			actionPerformedCmbN(arg0);
		}
		if (arg0.getSource() == cmbPaterno) {
			actionPerformedCmbPaterno(arg0);
		}
		if (arg0.getSource() == cmbMaterno) {
			actionPerformedCmbMaterno(arg0);
		}
		if (arg0.getSource() == btnpdf) {
			actionPerformedBtnpdf(arg0);
		}
		if (arg0.getSource() == btncorreo) {
			actionPerformedBtncorreo(arg0);
		}
		if (arg0.getSource() == btnexcel) {
			actionPerformedBtnexcel(arg0);
		}
		if (arg0.getSource() == btnword) {
			actionPerformedBtnword(arg0);
		}
		if (arg0.getSource() == btnExportar) {
			actionPerformedBtnExportar(arg0);
		}
		if (arg0.getSource() == btnPastel) {
			actionPerformedBtnPastel(arg0);
		}
		if (arg0.getSource() == btndatos) {
			actionPerformedBtndatos(arg0);
		}
		if (arg0.getSource() == btndatalle) {
			actionPerformedBtndatalle(arg0);
		}
		if (arg0.getSource() == btnactulizar) {
			actionPerformedBtnactulizar(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		
		dispose();
		Bebida b=new Bebida();
		b.setVisible(true);
		b.setLocationRelativeTo(null);
	}
	
	public void keyPressed(KeyEvent arg0) {
		
	}
	public void keyReleased(KeyEvent arg0) {
		
	
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == cmbMaterno) {
			keyTypedCmbMaterno(e);
		}
		if (e.getSource() == cmbPaterno) {
			keyTypedCmbPaterno(e);
		}
		if (e.getSource() == cmbN) {
			keyTypedCmbN(e);
		}
		if (e.getSource() == txtC) {
			keyTypedTxtC(e);
		}
		
		if(txtC.getText().matches("\\d*")==false){
			e.consume();
			JOptionPane.showMessageDialog(null,"No se acepta letras");
		}
	
	if(txtC.getText().length()==4){
			e.consume();
			JOptionPane.showMessageDialog(null,"El Codigo solo tiene 4 digitos");
		}
		
		
	}

	
	protected void keyTypedTxtC(KeyEvent arg0) {
	txtC.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent ev){
				buscar1.setRowFilter(RowFilter.regexFilter(txtC.getText(),0));
			
			}
			});
			buscar1=new TableRowSorter<DefaultTableModel>(d) ;
			tables.setRowSorter(buscar1);
	
			
			
	}
	private void contarAdministrador(){
		
		Connection c = null;
		try {
		
	Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		
		try {
			
			
			Statement s=(Statement) c.createStatement();
			ResultSet r=s.executeQuery("select count(u.tipo) from bebidas u where u.tipo='cerveza'");
			
			
			if(r.next()){
			
				txtadministrador.setText(r.getInt(1)+"");
				lbadmi.setText(r.getInt(1)+"");
			}
			
			
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "no hay cervezas");
		}
		
		
	}
	
	
	
private void contarSupervisor(){
		
		Connection c = null;
		try {
		
	Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		
		try {
			
			Statement s=(Statement) c.createStatement();
			ResultSet r=s.executeQuery("select count(u.tipo) from bebidas u where u.tipo='Vinos'");
			
			
			if(r.next()){
			
				txtsupervisar.setText(r.getInt(1)+"");
				lbsupe.setText(r.getInt(1)+"");
			}
			
			
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "no hay supervisores");
		}
		
		
	}

	private void contarMozo(){
		
		Connection c = null;
		try {
		
	Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		
		try {
			
			Statement s=(Statement) c.createStatement();
			ResultSet r=s.executeQuery("select count(u.tipo) from bebidas u where u.tipo='Whisky'");
			
			
			if(r.next()){
			
				lbmozo.setText(r.getInt(1)+"");
				lbmosu.setText(r.getInt(1)+"");
			}
			
			
		} catch (Exception e) {
		
			JOptionPane.showMessageDialog(null, "no hay mozos");
		}
		
		
	}
	

	
	protected void actionPerformedBtnactulizar(ActionEvent arg0) {
		
		dispose();
		Bebida b=new Bebida();
		b.setVisible(true);
		b.setLocationRelativeTo(null);
		Bebida.lbccodigo.setText(Integer.parseInt(txtC.getText())+"");
		
	}
	protected void actionPerformedBtndatalle(ActionEvent arg0) {
		panelexportar.setVisible(false);
		paneltabla2.setVisible(false);
		scrollPane1.setVisible(false);
		table2.setVisible(false);
		panelDetalle.setVisible(true);
		panelPastel.setVisible(false);
		scrollPane.setVisible(true);
		tables.setVisible(true);
	
		
		
	}
	protected void actionPerformedBtndatos(ActionEvent arg0) {
		panelexportar.setVisible(false);
		paneltabla2.setVisible(false);
		scrollPane1.setVisible(false);
		table2.setVisible(false);
		panelDetalle.setVisible(false);
		panelPastel.setVisible(false);
		scrollPane.setVisible(true);
		tables.setVisible(true);
		
	}
	double precios;
	private void graficoPastel(){
		
		

		Connection c = null;
		try {
		
	Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		
		
			try {
			
			Statement s=(Statement) c.createStatement();
		ResultSet r=s.executeQuery("select b.nombre,b.precio from bebidas b");
			
		DefaultPieDataset defaultpiedataset = null;
		defaultpiedataset = new DefaultPieDataset(); 
		while(r.next()){
			
			
	String nombre=r.getString(1);
	 precios=r.getDouble(2);
			
		if(precios>=150){
			 defaultpiedataset.setValue(nombre+"("+precios+")",precios); 
		}else{
			
			
		}
	  
			
		}
		
		
		
		if(precios<150){
		JOptionPane.showMessageDialog(null,"Los Precios deben ser mayores o igual a 150");
		}
		JFreeChart chart = ChartFactory.createPieChart3D("",defaultpiedataset,true, true, false); 
        PiePlot3D pieplot3d = (PiePlot3D)chart.getPlot(); 
        pieplot3d.setDepthFactor(0.1); 
        pieplot3d.setStartAngle(290D); 
       pieplot3d.setDirection(Rotation.CLOCKWISE); 
      pieplot3d.setForegroundAlpha(0.5F);
      pieplot3d.setOutlineVisible(false);
      
      ChartPanel chartPanel_1 = new ChartPanel(chart);
      chartPanel_1.setForeground(Color.DARK_GRAY);
      chartPanel_1.setMaximumDrawHeight(6000);
      chartPanel_1.setBounds(-5, 23, 500, 387);
      chartPanel_1.setBackground(Color.WHITE);
      chartPanel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
      panelPas.add(chartPanel_1);
      
        pieplot3d.setBackgroundPaint(Color.white);
        pieplot3d.setLabelBackgroundPaint(Color.white); 
        panelPas.setLayout(null); 
        
			
		} catch (Exception e) {
		
			JOptionPane.showMessageDialog(null, "no hay datos");
		}
		
		
		
		
		
	}
	
	
	private void graficobarra(){
		
	}
	
	
	
	
	
	
	protected void actionPerformedBtnPastel(ActionEvent arg0) {
		
	graficoPastel();
	
		panelDetalle.setVisible(false);
		scrollPane.setVisible(false);
		tables.setVisible(false);
		panelexportar.setVisible(false);
		paneltabla2.setVisible(false);
		scrollPane1.setVisible(false);
		table2.setVisible(false);
		panelPastel.setVisible(true);
		
		
		
	}
	protected void actionPerformedBtnExportar(ActionEvent arg0) {
		
		panelDetalle.setVisible(false);
		panelPastel.setVisible(false);
		scrollPane.setVisible(false);
		tables.setVisible(false);
		panelexportar.setVisible(true);
		paneltabla2.setVisible(true);
		scrollPane1.setVisible(true);
		table2.setVisible(true);
		
	}
	
	protected void actionPerformedBtnword(ActionEvent arg0) {
		
		String titulogrande ="Registro de Bebidas";
	
		
		
		XWPFDocument documento = new XWPFDocument();
		        

		XWPFParagraph titulo_doc = documento.createParagraph();
		titulo_doc.setAlignment(ParagraphAlignment.CENTER);
		titulo_doc.setVerticalAlignment(TextAlignment.TOP);
		        

		XWPFParagraph parrafo = documento.createParagraph();
		parrafo.setAlignment(ParagraphAlignment.BOTH);
		
		XWPFParagraph parrafo1= documento.createParagraph();
		parrafo.setAlignment(ParagraphAlignment.BOTH);
		
		XWPFRun r1 = titulo_doc.createRun();
		r1.setBold(true);
		r1.setText(titulogrande);
		r1.setFontFamily("Arial");
		r1.setFontSize(12);
		r1.setTextPosition(10);
		r1.setUnderline(UnderlinePatterns.SINGLE);
		        
		
		XWPFRun r2 = parrafo1.createRun();
		r2.setBold(true);
		r2.setText("ID            Nombre            Marca           Tipo            Precio                Estado          " );

		
		for (int i = 0; i <table2.getRowCount(); i++) {
			
		XWPFTable tableOne = documento.createTable();
		tableOne.setCellMargins( 50, 50, 250, 450);
		
		XWPFTableRow tableOneRowOne = tableOne.getRow(0);
		
	tableOneRowOne.getCell(0).setText(table2.getValueAt(i,0).toString());
	tableOneRowOne.addNewTableCell().setText(table2.getValueAt(i,1).toString());
	tableOneRowOne.addNewTableCell().setText(table2.getValueAt(i,2).toString());
	tableOneRowOne.addNewTableCell().setText(table2.getValueAt(i,3).toString());
	tableOneRowOne.addNewTableCell().setText(table2.getValueAt(i,4).toString());
	tableOneRowOne.addNewTableCell().setText(table2.getValueAt(i,5).toString());

		 
		

	
		}
		
		
try {
    FileOutputStream word = new FileOutputStream(titulogrande+".docx");
    documento.write(word);
    word.close();
    JOptionPane.showMessageDialog(null,"Archivo Word Generado Correctamente");
    Desktop.getDesktop().open(new File(titulogrande+".docx"));
} catch (FileNotFoundException ex) {
	ex.printStackTrace();
} catch (Exception ex) {
	ex.printStackTrace();
}
		
	}
	private void excel(){

		
		Workbook libros =new HSSFWorkbook();
		
		Sheet  hoja=libros.createSheet("hoja1");
	
		Row fila=null;
		Cell celda=null;
		
		
		
		
		fila=hoja.createRow(0);
		celda=fila.createCell(0);
		celda.setCellValue("Codigo");
		
		celda=fila.createCell(1);
		celda.setCellValue("Nombres");
		
		celda=fila.createCell(2);
		celda.setCellValue("Marca");
		celda=fila.createCell(3);
		celda.setCellValue("Tipo");
		
		celda=fila.createCell(4);
		celda.setCellValue("Precio");
		
		celda=fila.createCell(5);
		celda.setCellValue("Estado");
		
	
		for (int f = 0; f <table2.getRowCount();f++) {
			fila=hoja.createRow(f+2);
		for (int i = 0; i < table2.getRowCount(); i++) {
			
				 celda=fila.createCell(0);
			celda.setCellValue(table2.getValueAt(f,0).toString());
			for (int j = 0; j < table2.getRowCount(); j++) {

			 celda=fila.createCell(1);
			celda.setCellValue(table2.getValueAt(f,1).toString());
			
			}
			for (int j = 0; j < table2.getRowCount(); j++) {

				 celda=fila.createCell(2);
				celda.setCellValue(table2.getValueAt(f,2).toString());
				
				}
			for (int j = 0; j < table2.getRowCount(); j++) {

				 celda=fila.createCell(3);
				celda.setCellValue(table2.getValueAt(f,3).toString());
				
				}
			for (int j = 0; j < table2.getRowCount(); j++) {

				 celda=fila.createCell(4);
				celda.setCellValue(table2.getValueAt(f,4).toString());
				
				}
			for (int j = 0; j < table2.getRowCount(); j++) {

				 celda=fila.createCell(5);
				celda.setCellValue(table2.getValueAt(f,5).toString());
				
				}
			
	}
		
	}
		
		try {
			FileOutputStream f=new FileOutputStream(new File("bebidas.xls"));
			libros.write(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void actionPerformedBtnexcel(ActionEvent arg0) {

		
		Workbook libros =new HSSFWorkbook();
		
		Sheet  hoja=libros.createSheet("hoja1");
	
		Row fila=null;
		Cell celda=null;
		
		fila=hoja.createRow(0);
		celda=fila.createCell(0);
		celda.setCellValue("Codigo");
		
		celda=fila.createCell(1);
		celda.setCellValue("Nombres");
		
		celda=fila.createCell(2);
		celda.setCellValue("Marca");
		celda=fila.createCell(3);
		celda.setCellValue("Tipo");
		
		celda=fila.createCell(4);
		celda.setCellValue("Precio");
		
		celda=fila.createCell(5);
		celda.setCellValue("Estado");
		
	
		
		for (int f = 0; f <table2.getRowCount();f++) {
			fila=hoja.createRow(f+2);
		for (int i = 0; i < table2.getRowCount(); i++) {
			
				 celda=fila.createCell(0);
			celda.setCellValue(table2.getValueAt(f,0).toString());
			for (int j = 0; j < table2.getRowCount(); j++) {

			 celda=fila.createCell(1);
			celda.setCellValue(table2.getValueAt(f,1).toString());
			
			}
			for (int j = 0; j < table2.getRowCount(); j++) {

				 celda=fila.createCell(2);
				celda.setCellValue(table2.getValueAt(f,2).toString());
				
				}
			for (int j = 0; j < table2.getRowCount(); j++) {

				 celda=fila.createCell(3);
				celda.setCellValue(table2.getValueAt(f,3).toString());
				
				}
			for (int j = 0; j < table2.getRowCount(); j++) {

				 celda=fila.createCell(4);
				celda.setCellValue(table2.getValueAt(f,4).toString());
				
				}
			for (int j = 0; j < table2.getRowCount(); j++) {

				 celda=fila.createCell(5);
				celda.setCellValue(table2.getValueAt(f,5).toString());
				
				}
		
	}
		
	}
		
		try {
			FileOutputStream f=new FileOutputStream(new File("bebidas.xls"));
			libros.write(f);
			JOptionPane.showMessageDialog(null,"Archivo Excel Generado Correctamente");
			Desktop.getDesktop().open(new File("bebidas.xls"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void actionPerformedBtncorreo(ActionEvent arg0) {
		
		try {
			
			excel();
			
			
			
			 Properties props = new Properties();
	        props.put("mail.smtp.auth","true");
	        props.put("mail.smtp.starttls.enable","true");
	        props.put("mail.smtp.host","smtp.gmail.com");
	        props.put("mail.smtp.port","587");
	        
		
	        
	        Session session=Session.getDefaultInstance(props);
	        String correoremitente="arturogilserpa18@gmail.com";
	        String password="bebeconejo";
	        String receptor="arturogilserpa18@gmail.com";
	        String asunto="Registro de Bebidas";
	        String mensaje="Hola<br>Resiviste la Informacion de las Bebidas</br>";
	        

	        
	        
	        BodyPart body=new MimeBodyPart();
	        body.setContent(mensaje,"text/html");
	        
	        BodyPart adjunto=new MimeBodyPart();
	        adjunto.setDataHandler(new DataHandler(new FileDataSource("bebidas.xls")));
	        adjunto.setFileName("Bebidas.xls");
		
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
	protected void actionPerformedBtnpdf(ActionEvent arg0) {
		MessageFormat header=new MessageFormat("Acomm karaoke");
		MessageFormat footer=new MessageFormat("Detalle Bebidas{0,number,integer}");
		try {
			table2.print(JTable.PrintMode.NORMAL, header,footer);
			  JOptionPane.showMessageDialog(null,"Archivo PDF Generado Correctamente");
		      
		} catch (java.awt.print.PrinterException e) {
			System.err.format("Cannot print %s%n",e.getMessage());
		}
		
		
		
	}
	
	private HashMap<String,claseBebida> h=new HashMap<>();
	private JPanel panelde;
	private JLabel lblBebidas;
	
private void buscarnivel2(){
		
		Connection c = null;
		try {
		
	Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		
		try {
			
			Statement s=(Statement) c.createStatement();
			ResultSet r=s.executeQuery("select u.nombre,u.marca,u.tipo from bebidas u");
			
			
			while(r.next()){
			
				cmbN.addItem(r.getString(1));
				cmbPaterno.addItem(r.getString(2));
				cmbMaterno.addItem(r.getString(3));
		
			}
			
			
		} catch (Exception e) {
		
			JOptionPane.showMessageDialog(null, "no hay mozos");
		}
		
		
	}
	protected void keyTypedCmbN(KeyEvent e) {
	
	}
	protected void keyTypedCmbPaterno(KeyEvent e) {

	}
	protected void keyTypedCmbMaterno(KeyEvent e) {

	}
	protected void actionPerformedCmbMaterno(ActionEvent arg0) {
		
	
	}
	protected void actionPerformedCmbPaterno(ActionEvent arg0) {
	}
	protected void actionPerformedCmbN(ActionEvent arg0) {
		
	}
	protected void mouseClickedCmbN(MouseEvent arg0) {
			d.setRowCount(0);
		if(h.containsKey(cmbN.getSelectedItem().toString())){
			
			claseBebida cl=h.get(cmbN.getSelectedItem().toString());


			d.addRow(new Object[]{cl.getIDBebida(),cl.getNombre(),cl.getMarca(),cl.getTipoBebida(),
					cl.getPrecio(),cl.getEstado()});
			tables.setModel(d);
		
		}
	}
	protected void mouseClickedCmbPaterno(MouseEvent arg0) {
		d.setRowCount(0);
	if(h2.containsKey(cmbPaterno.getSelectedItem().toString())){
			
			claseBebida cl=h2.get(cmbPaterno.getSelectedItem().toString());
		

			d.addRow(new Object[]{cl.getIDBebida(),cl.getNombre(),cl.getMarca(),cl.getTipoBebida(),
					cl.getPrecio(),cl.getEstado()});
			tables.setModel(d);
		
		}
	}
	protected void mouseClickedCmbMaterno(MouseEvent arg0) {
		d.setRowCount(0);
		if(h3.containsKey(cmbMaterno.getSelectedItem().toString())){
				
				claseBebida cl=h3.get(cmbMaterno.getSelectedItem().toString());
			

				d.addRow(new Object[]{cl.getIDBebida(),cl.getNombre(),cl.getMarca(),cl.getTipoBebida(),
						cl.getPrecio(),cl.getEstado()});
				tables.setModel(d);
			
			}
	}
	
	@Override

	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

		 if (pageIndex > 0) { 
		   return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D)graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	

		panelPas.printAll(graphics);

			

		return PAGE_EXISTS;

		
	}
	protected void actionPerformedBtnImprimir1(ActionEvent arg0) {
		
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
