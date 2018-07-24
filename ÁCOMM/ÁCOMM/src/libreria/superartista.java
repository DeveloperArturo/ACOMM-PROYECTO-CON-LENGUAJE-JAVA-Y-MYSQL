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
import java.net.URI;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
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
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Clases.claseBebida;
import Clases.claseartista;
import Clases.clasecancion;
import Formulario.Artista;
import Formulario.AñadirCancion;
import Formulario.Bebida;
import Formulario.Cancion;
import com.toedter.calendar.JCalendar;

@SuppressWarnings("serial")
public class superartista extends JFrame  implements MouseListener, MouseMotionListener, ActionListener, KeyListener {

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
	private JLabel label_f;
	private JPanel panel_c;
	private JTextField txtc;
	private JTextField txtc3;
	private JPanel panel_2;
	private JLabel lblExportar;
	private JButton btnExportar;
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
					superartista frame = new superartista();
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
	public  superartista() {
		// TODO Auto-generated constructor st() {
		
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1170, 713);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		contentPane.addMouseMotionListener(this);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lbl1 = new JLabel("");
		lbl1.setBounds(235, 0, 935, 53);	
		ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/rojon.png"));
		ImageIcon icon1=new ImageIcon(fondo1.getImage().getScaledInstance(lbl1.getWidth(),	lbl1.getHeight(),Image.SCALE_DEFAULT));
		
		lblNewLabel_1 = new JLabel("Artista");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(this);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(1064, 23, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(superartista.class.getResource("/img/artis.png")));
		lblNewLabel.setBounds(1025, 12, 32, 41);
		contentPane.add(lblNewLabel);
		lbl1.setIcon(icon1);
		contentPane.add(lbl1);
		
		
		
		lblConsultar = new JLabel("   SuperConsulta/Acomm");
		lblConsultar.setForeground(SystemColor.control);
		lblConsultar.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblConsultar.setBounds(10, 13, 226, 30);
		contentPane.add(lblConsultar);
		
		lblN = new JLabel("");
		lblN.setBounds(0, 0, 236, 53);
		ImageIcon fondo10=new ImageIcon(getClass().getResource("/img/cuadrozul.png"));
		ImageIcon icon10=new ImageIcon(fondo10.getImage().getScaledInstance(lblN.getWidth(),lblN.getHeight(),Image.SCALE_DEFAULT));
		lblN.setIcon(new ImageIcon(superartista.class.getResource("/img/rojob.png")));
		contentPane.add(lblN);
	
		
		panelfondo = new JPanel();
		panelfondo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelfondo.setBackground(SystemColor.menuText);
		panelfondo.setBounds(0, 52, 236, 634);
		contentPane.add(panelfondo);
		panelfondo.setLayout(null);
		
		label = new JLabel("");
		label.setBounds(10, 2, 80, 79);
		ImageIcon fondo11=new ImageIcon(getClass().getResource("/img/artistap.png"));
		ImageIcon icon11=new ImageIcon(fondo11.getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_DEFAULT));
		
		
		txtC = new JTextField();
		txtC.addKeyListener(this);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 434, 236, 45);
		panelfondo.add(panel_1);
		
		lblSalidaDeConsulta = new JLabel("Salida de Consulta");
		lblSalidaDeConsulta.setForeground(Color.DARK_GRAY);
		lblSalidaDeConsulta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSalidaDeConsulta.setBounds(14, 11, 153, 23);
		panel_1.add(lblSalidaDeConsulta);
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
		txtc6.setBackground(new Color(32, 178, 170));
		txtc6.setBounds(231, 526, 5, 50);
		panelfondo.add(txtc6);
		
		btnSalir = new JButton("Salir");
		btnSalir.setContentAreaFilled(false);
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
		btnSalir.setBorder(new LineBorder(new Color(64, 64, 64), 0));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(0, 525, 232, 50);
		panelfondo.add(btnSalir);
		
		btnExportar = new JButton("Exportar");
		btnExportar.setContentAreaFilled(false);
		btnExportar.addActionListener(this);
		btnExportar.addMouseListener(this);
		btnExportar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExportar.setForeground(Color.GRAY);
		btnExportar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExportar.setFocusable(false);
		btnExportar.setFocusTraversalKeysEnabled(false);
		btnExportar.setFocusPainted(false);
		btnExportar.setBorder(new LineBorder(new Color(64, 64, 64), 0));
		btnExportar.setBackground(Color.BLACK);
		btnExportar.setBounds(0, 345, 232, 50);
		panelfondo.add(btnExportar);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 281, 236, 45);
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
		txtc3.setBackground(new Color(0, 128, 0));
		txtc3.setBounds(231, 347, 5, 48);
		panelfondo.add(txtc3);
		
		txtc = new JTextField();
		txtc.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtc.setEditable(false);
		txtc.setBackground(new Color(255, 0, 0));
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
		label.setIcon(new ImageIcon(superartista.class.getResource("/img/artistape.png")));
		panelfondo.add(label);
		
		lblConsultaDeUsuarios = new JLabel("Consulta  de \r\n");
		lblConsultaDeUsuarios.setForeground(Color.WHITE);
		lblConsultaDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConsultaDeUsuarios.setBounds(95, 11, 92, 30);
		panelfondo.add(lblConsultaDeUsuarios);
		
		lblAcomm = new JLabel("Artista");
		lblAcomm.setForeground(Color.WHITE);
		lblAcomm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAcomm.setBounds(98, 32, 89, 30);
		panelfondo.add(lblAcomm);
		
		btndatos = new JButton("Datos de Artista\r\n");
		btndatos.setContentAreaFilled(false);
		btndatos.addActionListener(this);
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
		
		label_f = new JLabel("");
		label_f.setBounds(0, 2, 237, 621);
		ImageIcon fondo13=new ImageIcon(getClass().getResource("/img/gray.png"));
		ImageIcon icon13=new ImageIcon(fondo13.getImage().getScaledInstance(label_f.getWidth(),label_f.getHeight(),Image.SCALE_DEFAULT));
		label_f.setIcon(icon13);
		panelfondo.add(label_f);
		lbuscar.setVisible(true);
		lbuscar.setVisible(true);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setBounds(236, 52, 935, 623);
		contentPane.add(panel);
		panel.setLayout(null);
		
		paneltabla = new JPanel();
		paneltabla.setBackground(Color.WHITE);
		paneltabla.setBorder(new LineBorder(new Color(192, 192, 192), 0));
		paneltabla.setBounds(10, 0, 925, 612);
		panel.add(paneltabla);
		paneltabla.setLayout(null);
			
			panelexportar = new JPanel();
			panelexportar.setVisible(false);
			panelexportar.setBackground(Color.WHITE);
			panelexportar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
			panelexportar.setBounds(10, 0, 915, 167);
			paneltabla.add(panelexportar);
			panelexportar.setLayout(null);
			
			btnexcel = new JButton("");
			btnexcel.addActionListener(this);
			btnexcel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnexcel.setIcon(new ImageIcon(supercancion.class.getResource("/img/excel.png")));
			btnexcel.setFocusable(false);
			btnexcel.setFocusTraversalKeysEnabled(false);
			btnexcel.setFocusPainted(false);
			btnexcel.setContentAreaFilled(false);
			btnexcel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
			btnexcel.setBounds(424, 36, 190, 113);
			panelexportar.add(btnexcel);
			
			btncorreo = new JButton("");
			btncorreo.addActionListener(this);
			btncorreo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btncorreo.setIcon(new ImageIcon(supercancion.class.getResource("/img/correo.png")));
			btncorreo.setFocusable(false);
			btncorreo.setFocusTraversalKeysEnabled(false);
			btncorreo.setFocusPainted(false);
			btncorreo.setContentAreaFilled(false);
			btncorreo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
			btncorreo.setBounds(619, 36, 190, 113);
			panelexportar.add(btncorreo);
			
			btnword = new JButton("");
			btnword.addActionListener(this);
			btnword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnword.setIcon(new ImageIcon(supercancion.class.getResource("/img/word.png")));
			btnword.setFocusable(false);
			btnword.setFocusTraversalKeysEnabled(false);
			btnword.setFocusPainted(false);
			btnword.setContentAreaFilled(false);
			btnword.setBorder(new LineBorder(new Color(0, 0, 0), 0));
			btnword.setBounds(227, 36, 190, 113);
			panelexportar.add(btnword);
			
			btnpdf = new JButton("");
			btnpdf.addActionListener(this);
			btnpdf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnpdf.setIcon(new ImageIcon(supercancion.class.getResource("/img/pdf.png")));
			btnpdf.setFocusable(false);
			btnpdf.setFocusTraversalKeysEnabled(false);
			btnpdf.setFocusPainted(false);
			btnpdf.setContentAreaFilled(false);
			btnpdf.setBorder(new LineBorder(new Color(0, 0, 0), 0));
			btnpdf.setBounds(31, 36, 190, 113);
			panelexportar.add(btnpdf);
			
			lblGenero = new JLabel("Genero");
			lblGenero.setForeground(Color.DARK_GRAY);
			lblGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblGenero.setBounds(376, 116, 78, 23);
			paneltabla.add(lblGenero);
			
			label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon(supercancion.class.getResource("/img/cuadroverde2.png")));
			label_1.setForeground(Color.GRAY);
			label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			label_1.setBounds(268, 54, 186, 93);
			paneltabla.add(label_1);
			
			lblActualizar = new JLabel("Detalle General ");
			lblActualizar.setForeground(Color.DARK_GRAY);
			lblActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblActualizar.setBounds(74, 11, 143, 23);
			paneltabla.add(lblActualizar);
		
		
			
			lblCantidadDeUsuarios = new JLabel("");
			lblCantidadDeUsuarios.setIcon(new ImageIcon(supercancion.class.getResource("/img/cuboazul.png")));
			lblCantidadDeUsuarios.setForeground(Color.GRAY);
			lblCantidadDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCantidadDeUsuarios.setBounds(29, 54, 193, 93);
			paneltabla.add(lblCantidadDeUsuarios);
		
		lblDetalles = new JLabel("Canciones");
		lblDetalles.setForeground(Color.DARK_GRAY);
		lblDetalles.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDetalles.setBounds(126, 112, 78, 23);
		paneltabla.add(lblDetalles);
		
		lbcancion = new JLabel("");
		lbcancion.setForeground(new Color(70, 130, 180));
		lbcancion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbcancion.setBounds(126, 77, 78, 23);
		paneltabla.add(lbcancion);
		
		lbgenero = new JLabel("");
		lbgenero.setForeground(new Color(0, 128, 0));
		lbgenero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbgenero.setBounds(376, 77, 51, 23);
		paneltabla.add(lbgenero);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(new Color(227, 227, 227), 0));
		scrollPane.setBounds(0, 170, 493, 431);
		paneltabla.add(scrollPane);
		
		tables = new JTable();
		tables.setGridColor(SystemColor.controlHighlight);
		tables.setBackground(Color.WHITE);
		tables.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		scrollPane.setViewportView(tables);
		tables.setModel(d);
	
		
		d=new DefaultTableModel();
		d.addColumn("ID");
		d.addColumn("Nombre");
		d.addColumn("IDGenero");
		d.addColumn("Fecha Registro");
		d.addColumn("Estado");
		ImageIcon fondo14=new ImageIcon(getClass().getResource("/img/bebida.png"));
		
		calendar = new JCalendar();
		calendar.addMouseListener(this);
		calendar.getDayChooser().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.getYearChooser().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.getMonthChooser().getSpinner().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.getMonthChooser().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.setFont(new Font("Tahoma", Font.BOLD, 13));
		calendar.getDayChooser().getDayPanel().setFont(new Font("Tahoma", Font.PLAIN, 18));
		calendar.getDayChooser().getDayPanel().setBackground(SystemColor.window);
		calendar.getMonthChooser().setForeground(Color.DARK_GRAY);
		calendar.getMonthChooser().setBackground(new Color(30, 144, 255));
		calendar.setWeekdayForeground(new Color(70, 130, 180));
		calendar.setSundayForeground(new Color(0, 100, 0));
		calendar.setForeground(Color.DARK_GRAY);
		calendar.setDecorationBackgroundColor(Color.WHITE);
		calendar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		calendar.setBounds(503, 170, 412, 431);
		paneltabla.add(calendar);
		
		label_facebokk = new JLabel("");
		label_facebokk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_facebokk.addMouseListener(this);
		label_facebokk.setIcon(new ImageIcon(supercancion.class.getResource("/img/facebook.png")));
		label_facebokk.setForeground(Color.DARK_GRAY);
		label_facebokk.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_facebokk.setBounds(855, 11, 60, 50);
		paneltabla.add(label_facebokk);
		
		btnactulizar = new JButton("");
		btnactulizar.setBounds(659, 78, 210, 69);
		paneltabla.add(btnactulizar);
		btnactulizar.setIcon(new ImageIcon(supercancion.class.getResource("/img/consultaazul.png")));
		btnactulizar.addActionListener(this);
		btnactulizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnactulizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnactulizar.setForeground(Color.GRAY);
		btnactulizar.setFocusable(false);
		btnactulizar.setFocusTraversalKeysEnabled(false);
		btnactulizar.setFocusPainted(false);
		
		lblDesarrollo = new JLabel("Desarrollo");
		lblDesarrollo.setBounds(735, 34, 91, 23);
		paneltabla.add(lblDesarrollo);
		lblDesarrollo.setForeground(Color.DARK_GRAY);
		lblDesarrollo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lbartista = new JLabel("");
		lbartista.setBounds(571, 77, 68, 23);
		paneltabla.add(lbartista);
		lbartista.setForeground(new Color(255, 140, 0));
		lbartista.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		label_2 = new JLabel("");
		label_2.setBounds(464, 54, 208, 93);
		paneltabla.add(label_2);
		label_2.setIcon(new ImageIcon(supercancion.class.getResource("/img/cuadronaranja.png")));
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblArtistas = new JLabel("Artistas");
		lblArtistas.setBounds(571, 112, 78, 23);
		paneltabla.add(lblArtistas);
		lblArtistas.setForeground(Color.DARK_GRAY);
		lblArtistas.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		listar();
		
		contarAdministrador();
		contarSupervisor();
	
		
		
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblNewLabel_1) {
			mouseClickedLblNewLabel_1(arg0);
		}
		if (arg0.getSource() == calendar) {
			mouseClickedCalendar(arg0);
		}
		if (arg0.getSource() == label_facebokk) {
			mouseClickedLabel_3(arg0);
		}
		
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			mouseEnteredBtnSalir(arg0);
		}
		if (arg0.getSource() == btnExportar) {
			mouseEnteredBtnExportar(arg0);
		}
		if (arg0.getSource() == btndatos) {
			mouseEnteredBtndatos(arg0);
		}
	}
	public void mouseExited(MouseEvent arg0) {
	
		
		listar();
		

		
		btndatos.setIcon(null);
		txtc.setBounds(231, 195, 5, 47);
		
	
		
		btnExportar.setIcon(null);
		txtc3.setBounds(231, 347, 5, 48);
		
		btnSalir.setIcon(null);
		txtc6.setBounds(231, 526, 5, 50);
		
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
	
			
	com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from artista");
			
	ResultSet r=p.executeQuery();

	d.setRowCount(0);
	while (r.next()) {

	
	d.addRow(new Object[]{r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5)});
		tables.setModel(d);
		
	h2.put(r.getString(4),new claseartista(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5)));
	
		
		lbartista.setText(String.valueOf(d.getRowCount()));

		
	}
		} catch (Exception e) {
			e.printStackTrace();
		
		}

}	
	
	
	
	protected void mouseEnteredBtndatos(MouseEvent arg0) {
	
	txtc.setBounds(232, 195, 5, 47);
	}
	protected void mouseEnteredBtnExportar(MouseEvent arg0) {
		
		txtc3.setBounds(232, 347, 5, 48);
	
	
	}
	protected void mouseEnteredBtnSalir(MouseEvent arg0) {
		
		txtc6.setBounds(232, 526, 5, 50);
	
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
	private JLabel lblCantidadDeUsuarios;
	private JButton btnactulizar;
	private JLabel lblActualizar;
	private HashMap<String,claseartista> h2=new HashMap<>();
	public void mouseMoved(MouseEvent arg0) {

		x=arg0.getX();
		y=arg0.getY();
		
	}
	protected void mouseDraggedContentPane(MouseEvent arg0) {
		
		Point p=MouseInfo.getPointerInfo().getLocation();
		setLocation(p.x-x, p.y-y);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btncorreo) {
			actionPerformedBtncorreo(arg0);
		}
		if (arg0.getSource() == btnexcel) {
			actionPerformedBtnexcel(arg0);
		}
		if (arg0.getSource() == btnword) {
			actionPerformedBtnword(arg0);
		}
		if (arg0.getSource() == btnpdf) {
			actionPerformedBtnpdf(arg0);
		}
		if (arg0.getSource() == btnExportar) {
			actionPerformedBtnExportar(arg0);
		}
		if (arg0.getSource() == btndatos) {
			actionPerformedBtndatos(arg0);
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
		Artista a=new Artista();
		a.setVisible(true);
		a.setLocationRelativeTo(null);
	}
	
	public void keyPressed(KeyEvent arg0) {
		
	}
	public void keyReleased(KeyEvent arg0) {
		
	
	}
	public void keyTyped(KeyEvent e) {
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
			ResultSet r=s.executeQuery("select count(u.cod_genero) from genero u ");
			
			
			if(r.next()){
			
				lbgenero.setText(r.getInt(1)+"");
				
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
			ResultSet r=s.executeQuery("select count(a.cod_cancion) from cancion a ");
			
			
			if(r.next()){
			
				lbcancion.setText(r.getInt(1)+"");
			
			}
			
			
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "no hay supervisores");
		}
		
		
}

	

	
	protected void actionPerformedBtnactulizar(ActionEvent arg0) {
		
		dispose();
		Artista a=new Artista();
		a.setVisible(true);
		a.setLocationRelativeTo(null);
		Artista.lbccodigo.setText(Integer.parseInt(txtC.getText())+"");
		
	}
	protected void actionPerformedBtndatos(ActionEvent arg0) {
		
		btnactulizar.setVisible(true);
		scrollPane.setVisible(true);
		tables.setVisible(true);
		panelexportar.setVisible(false);
		
	}
	
	
	double precios;
	
		
		
	
	
	
	private void graficobarra(){
		
	}
	protected void actionPerformedBtnExportar(ActionEvent arg0) {
	
	btnactulizar.setVisible(false);
	panelexportar.setVisible(true);
	scrollPane.setVisible(true);
	tables.setVisible(true);
		
		
	}
	
	private JPanel panel_1;
	private JLabel lblSalidaDeConsulta;
	private JCalendar calendar;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblGenero;
	private JLabel lblArtistas;
	private JLabel label_facebokk;
	private JLabel lblDesarrollo;
	private JLabel lbcancion;
	private JLabel lbgenero;
	private JLabel lbartista;
	private JPanel panelexportar;
	private JButton btnpdf;
	private JButton btnword;
	private JButton btnexcel;
	private JButton btncorreo;
	
	protected void mouseClickedLabel_3(MouseEvent arg0) {

		 try{
		      Desktop dk = Desktop.getDesktop();
		      dk.browse(new URI("https://www.facebook.com/"));
		 }catch(Exception f){
		     JOptionPane.showMessageDialog(null,"Error al abrir URL: "+f.getMessage());
	}
		
		
	}
	protected void mouseClickedCalendar(MouseEvent arg0) {
		
		
		
		
		
		
	}
	protected void mouseClickedLblNewLabel_1(MouseEvent arg0) {
		
String fecha = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getDate());
		
		if(h2.containsKey(fecha)){
			
			claseartista cc=h2.get(fecha);
			
			
			d.setRowCount(0);
			d.addRow(new Object[]{cc.getIDArtista(),cc.getNombreartistico(),cc.getIDGENERO(),cc.getRegistrocatalogo(),
					cc.getEstado()});
			tables.setModel(d);
			

		}
		
	}
	protected void actionPerformedBtnpdf(ActionEvent arg0) {
		MessageFormat header=new MessageFormat("Acomm karaoke");
		MessageFormat footer=new MessageFormat("Detalle Artista{0,number,integer}");
		try {
			tables.print(JTable.PrintMode.NORMAL, header,footer);
			  JOptionPane.showMessageDialog(null,"Archivo PDF Generado Correctamente");
		      
		} catch (java.awt.print.PrinterException e) {
			System.err.format("Cannot print %s%n",e.getMessage());
		}
		
		
	}
	protected void actionPerformedBtnword(ActionEvent arg0) {

		String titulogrande ="Registro de Artista";
	
		
		
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
		r2.setText("ID            Nombre            IDGenero            Fecha Registro           Estado" );
	
		for (int i = 0; i <tables.getRowCount(); i++) {
			
		XWPFTable tableOne = documento.createTable();
		tableOne.setCellMargins( 50, 50, 250, 450);
		
		XWPFTableRow tableOneRowOne = tableOne.getRow(0);
		
	tableOneRowOne.getCell(0).setText(tables.getValueAt(i,0).toString());
	tableOneRowOne.addNewTableCell().setText(tables.getValueAt(i,1).toString());
	tableOneRowOne.addNewTableCell().setText(tables.getValueAt(i,2).toString());
	tableOneRowOne.addNewTableCell().setText(tables.getValueAt(i,3).toString());
	tableOneRowOne.addNewTableCell().setText(tables.getValueAt(i,4).toString());


		 
		

	
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
		celda.setCellValue("IDGenero");
		celda=fila.createCell(3);
		celda.setCellValue("Fech Registro");
		
		celda=fila.createCell(4);
		celda.setCellValue("Estado");
		
		
		
	
		
		for (int f = 0; f <tables.getRowCount();f++) {
			fila=hoja.createRow(f+2);
		for (int i = 0; i < tables.getRowCount(); i++) {
			
				 celda=fila.createCell(0);
			celda.setCellValue(tables.getValueAt(f,0).toString());
			for (int j = 0; j < tables.getRowCount(); j++) {

			 celda=fila.createCell(1);
			celda.setCellValue(tables.getValueAt(f,1).toString());
			
			}
			for (int j = 0; j < tables.getRowCount(); j++) {

				 celda=fila.createCell(2);
				celda.setCellValue(tables.getValueAt(f,2).toString());
				
				}
			for (int j = 0; j < tables.getRowCount(); j++) {

				 celda=fila.createCell(3);
				celda.setCellValue(tables.getValueAt(f,3).toString());
				
				}
			for (int j = 0; j <tables.getRowCount(); j++) {

				 celda=fila.createCell(4);
				celda.setCellValue(tables.getValueAt(f,4).toString());
				
				}
			
	}
		
	}
		
		try {
			FileOutputStream f=new FileOutputStream(new File("artista.xls"));
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
		celda.setCellValue("IDGenero");
		celda=fila.createCell(3);
		celda.setCellValue("Fech Registro");
		
		celda=fila.createCell(4);
		celda.setCellValue("Estado");
		
		
		
	
		
		for (int f = 0; f <tables.getRowCount();f++) {
			fila=hoja.createRow(f+2);
		for (int i = 0; i < tables.getRowCount(); i++) {
			
				 celda=fila.createCell(0);
			celda.setCellValue(tables.getValueAt(f,0).toString());
			for (int j = 0; j < tables.getRowCount(); j++) {

			 celda=fila.createCell(1);
			celda.setCellValue(tables.getValueAt(f,1).toString());
			
			}
			for (int j = 0; j < tables.getRowCount(); j++) {

				 celda=fila.createCell(2);
				celda.setCellValue(tables.getValueAt(f,2).toString());
				
				}
			for (int j = 0; j < tables.getRowCount(); j++) {

				 celda=fila.createCell(3);
				celda.setCellValue(tables.getValueAt(f,3).toString());
				
				}
			for (int j = 0; j <tables.getRowCount(); j++) {

				 celda=fila.createCell(4);
				celda.setCellValue(tables.getValueAt(f,4).toString());
				
				}
			
		
	}
		
	}
		
		try {
			FileOutputStream f=new FileOutputStream(new File("artista.xls"));
			libros.write(f);
			JOptionPane.showMessageDialog(null,"Archivo Excel Generado Correctamente");
			Desktop.getDesktop().open(new File("artista.xls"));
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
	        String asunto="Registro de Cancion";
	        String mensaje="Hola<br>Resiviste la Informacion de los Artistas</br>";
	        

	        
	        
	        BodyPart body=new MimeBodyPart();
	        body.setContent(mensaje,"text/html");
	        
	        BodyPart adjunto=new MimeBodyPart();
	        adjunto.setDataHandler(new DataHandler(new FileDataSource("artista.xls")));
	        adjunto.setFileName("Artista.xls");
		
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
