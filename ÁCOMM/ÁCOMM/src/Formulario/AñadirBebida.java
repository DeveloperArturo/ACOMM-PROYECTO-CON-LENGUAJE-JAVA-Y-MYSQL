package Formulario;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;

import Array.ArrayBebida;
import Array.arrayreserva;
import Array.añadirArrayBebida;
import Clases.claseBebida;
import Clases.claseañadirbebida;
import Clases.clasereserva;
import java.awt.event.MouseMotionListener;

public class AñadirBebida extends JFrame  implements  ActionListener, MouseListener, MouseMotionListener {

	private JPanel contentPane;
	private JLabel labelUsuario;
	private JButton btnmini;
	private JButton btnX;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JButton btnAcon;
	private JLabel lb;
	private JLabel label_3;
	private JLabel lblUsuarios;
	private JLabel label_4;
	private DefaultTableModel modelo;
	private JPanel panelfondo;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnImprimir;
	private JButton btnGrabar;
	private JTextField txtbutu;
	private JButton btnAñadir;
	private JButton btnEliminar;
	private int p;
	private DefaultTableModel modelo1;

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
					AñadirBebida frame = new AñadirBebida();
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
	public AñadirBebida() {
		setUndecorated(true);
		final int ANCHO = 1000,
		          ALTO = 650,
		          DX = 8,
		          DY = 53;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((getToolkit().getScreenSize().width - ANCHO - DX) / 2,
				  (getToolkit().getScreenSize().height - ALTO - DY) / 2,
				   1019, 737);


		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		contentPane.addMouseMotionListener(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/imprimir.png"));
			ImageIcon fondo2=new ImageIcon(getClass().getResource("/img/imprimir2.png"));
		ImageIcon fondo10=new ImageIcon(getClass().getResource("/img/paginaWeb.png"));
		
		label_17 = new JLabel("");
		label_17.setBounds(502, 118, 510, 45);
		contentPane.add(label_17);
		label_17.setIcon(new ImageIcon(AñadirBebida.class.getResource("/img/men.png")));
		
		panelfondo = new JPanel();
		panelfondo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelfondo.setBackground(SystemColor.control);
		panelfondo.setBounds(10, 118, 1002, 574);
		contentPane.add(panelfondo);
		panelfondo.setLayout(null);
		
		lblListaDeBebidas = new JLabel("Lista De Bebidas");
		lblListaDeBebidas.setForeground(Color.WHITE);
		lblListaDeBebidas.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblListaDeBebidas.setBounds(22, 11, 122, 14);
		panelfondo.add(lblListaDeBebidas);
		
		label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(AñadirBebida.class.getResource("/img/mm.png")));
		label_16.setBounds(0, 0, 484, 45);
		panelfondo.add(label_16);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		scrollPane.setBounds(0, 40, 484, 449);
		panelfondo.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.addMouseListener(this);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		btnImprimir = new JButton("");
		btnImprimir.addActionListener(this);
		btnImprimir.setRolloverIcon(new ImageIcon(Usuario.class.getResource("/img/imprimir2.png")));
		btnImprimir.setContentAreaFilled(false);
		btnImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImprimir.setBorderPainted(false);
		btnImprimir.setDefaultCapable(false);
		btnImprimir.setFocusTraversalKeysEnabled(false);
		btnImprimir.setFocusPainted(false);
		btnImprimir.setFocusable(false);
		btnImprimir.setIcon(new ImageIcon(Usuario.class.getResource("/img/imprimir.png")));
		btnImprimir.setBounds(523, 504, 198, 62);
		panelfondo.add(btnImprimir);
		
		btnGrabar = new JButton("");
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(AñadirBebida.class.getResource("/img/excel.png")));
		btnGrabar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGrabar.setFocusable(false);
		btnGrabar.setFocusTraversalKeysEnabled(false);
		btnGrabar.setFocusPainted(false);
		btnGrabar.setDefaultCapable(false);
		btnGrabar.setContentAreaFilled(false);
		btnGrabar.setBorderPainted(false);
		btnGrabar.setBounds(747, 504, 213, 59);
		panelfondo.add(btnGrabar);
		
		txtbutu = new JTextField();
		txtbutu.setColumns(10);
		txtbutu.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		txtbutu.setBackground(new Color(128, 0, 0));
		txtbutu.setBounds(0, 492, 1002, 8);
		panelfondo.add(txtbutu);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.addActionListener(this);
		btnAñadir.setIcon(new ImageIcon(Usuario.class.getResource("/img/a\u00F1adir.png")));
		btnAñadir.setFocusPainted(false);
		btnAñadir.setFocusTraversalKeysEnabled(false);
		btnAñadir.setFocusable(false);
		btnAñadir.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadir.setForeground(SystemColor.windowBorder);
		btnAñadir.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnAñadir.setBounds(351, 514, 149, 52);
		panelfondo.add(btnAñadir);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setIcon(new ImageIcon(Usuario.class.getResource("/img/remover.png")));
		btnEliminar.setForeground(SystemColor.windowBorder);
		btnEliminar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnEliminar.setFocusable(false);
		btnEliminar.setFocusTraversalKeysEnabled(false);
		btnEliminar.setFocusPainted(false);
		btnEliminar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnEliminar.setBounds(192, 514, 149, 52);
		panelfondo.add(btnEliminar);
		
		label_4 = new JLabel("\u00C1COMM Karaoke");
		label_4.setForeground(new Color(165, 42, 42));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(873, 49, 108, 14);
		contentPane.add(label_4);
		
		lblUsuarios = new JLabel("A\u00F1adir Bebida");
		lblUsuarios.setForeground(Color.WHITE);
		lblUsuarios.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUsuarios.setBounds(56, 86, 108, 14);
		contentPane.add(lblUsuarios);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Bebida.class.getResource("/img/bebida.png")));
		label_3.setBounds(20, 74, 38, 45);
		contentPane.add(label_3);
		
		lb = new JLabel("");
		lb.setBounds(9, 74, 1002, 45);
		contentPane.add(lb);
		ImageIcon fondo3=new ImageIcon(getClass().getResource("/img/mm.png"));
		ImageIcon icon3=new ImageIcon(fondo3.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(),Image.SCALE_DEFAULT));
		lb.setIcon(icon3);
		
		label_2 = new JLabel("\u00C1COMM Karaoke");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(68, 7, 140, 14);
		contentPane.add(label_2);
		
		btnAcon = new JButton("");
		btnAcon.addActionListener(this);
		btnAcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAcon.setRolloverIcon(new ImageIcon(Usuario.class.getResource("/img/princi2.png")));
		btnAcon.setIcon(new ImageIcon(Usuario.class.getResource("/img/logo.png")));
		btnAcon.setFocusable(false);
		btnAcon.setFocusTraversalKeysEnabled(false);
		btnAcon.setFocusPainted(false);
		btnAcon.setContentAreaFilled(false);
		btnAcon.setBorderPainted(false);
		btnAcon.setBounds(10, -4, 48, 56);
		contentPane.add(btnAcon);
		
		label_1 = new JLabel("-");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_1.setBounds(965, 1, 11, 14);
		contentPane.add(label_1);
		
		label = new JLabel("x");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(998, -1, 11, 14);
		contentPane.add(label);
		
		btnmini = new JButton("");
		btnmini.addActionListener(this);
		btnmini.setRolloverIcon(new ImageIcon(Usuario.class.getResource("/img/transs.png")));
		btnmini.setIcon(new ImageIcon(Usuario.class.getResource("/img/btnx.png")));
		btnmini.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnmini.setForeground(Color.WHITE);
		btnmini.setFocusable(false);
		btnmini.setFocusTraversalKeysEnabled(false);
		btnmini.setFocusPainted(false);
		btnmini.setContentAreaFilled(false);
		btnmini.setBorderPainted(false);
		btnmini.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnmini.setBackground(Color.WHITE);
		btnmini.setBounds(952, -4, 37, 28);
		contentPane.add(btnmini);
		
		btnX = new JButton("");
		btnX.addActionListener(this);
		btnX.setRolloverIcon(new ImageIcon(Usuario.class.getResource("/img/transs.png")));
		btnX.setIcon(new ImageIcon(Usuario.class.getResource("/img/btnx.png")));
		btnX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnX.setForeground(Color.WHITE);
		btnX.setFocusable(false);
		btnX.setFocusTraversalKeysEnabled(false);
		btnX.setFocusPainted(false);
		btnX.setContentAreaFilled(false);
		btnX.setBorderPainted(false);
		btnX.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnX.setBackground(Color.WHITE);
		btnX.setBounds(984, -4, 37, 28);
		contentPane.add(btnX);
		
		labelUsuario = new JLabel("");
		labelUsuario.setBounds(0, 0, 1019, 737);
		contentPane.add(labelUsuario);
		ImageIcon fondo20=new ImageIcon(getClass().getResource("/img/princi.png"));
		ImageIcon icon20=new ImageIcon(fondo20.getImage().getScaledInstance(labelUsuario.getWidth(), labelUsuario.getHeight(),Image.SCALE_DEFAULT));
		labelUsuario.setIcon(icon20);
		
		modelo=new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Tipo de Bebida");
		modelo.addColumn("Marca");
		modelo.addColumn("Precio");
		modelo.addColumn("Estado");
		table.setModel(modelo);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		scrollPane_1.setBounds(494, 45, 508, 444);
		panelfondo.add(scrollPane_1);
		
		tableAñadirB = new JTable();
		scrollPane_1.setViewportView(tableAñadirB);
		
		cmbReserva = new JComboBox();
		cmbReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbReserva.setBounds(22, 530, 149, 36);
		panelfondo.add(cmbReserva);
		
		lblIdreserva = new JLabel("IDReserva");
		lblIdreserva.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdreserva.setForeground(SystemColor.windowBorder);
		lblIdreserva.setBounds(55, 516, 89, 14);
		panelfondo.add(lblIdreserva);
		
		
		blID = new JLabel("");
		
		blID.setVisible(false);
		blID.setBounds(773, 50, 46, 14);
		contentPane.add(blID);
		
		
		modelo1=new DefaultTableModel();
		modelo1.addColumn("IDReserva");
		modelo1.addColumn("IDBebida");
		modelo1.addColumn("Nombre");
		modelo1.addColumn("Tipo Bebida");
		modelo1.addColumn("Marca");
		modelo1.addColumn("Precio");
		modelo1.addColumn("Estado");
		tableAñadirB.setModel(modelo1);
		ancho();
		listartabla();
		codigoReserva();
		listartabla2();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnmini) {
			actionPerformedBtnmini(arg0);
		}
		if (arg0.getSource() == btnAcon) {
			do_btnAcon_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnImprimir) {
			do_btnImprimir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			do_btnGrabar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAñadir) {
			do_btnAñadir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnX) {
			do_btnX_actionPerformed(arg0);
		}
	}

	private JLabel blID;
	
	
	
	
	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane .getWidth() / 100;
	}
	private void ancho(){
		TableColumnModel u = table.getColumnModel();
		u.getColumn(0).setPreferredWidth(anchoColumna(39)); 
		u.getColumn(1).setPreferredWidth(anchoColumna(63)); 
		u.getColumn(2).setPreferredWidth(anchoColumna(96));  
		u.getColumn(3).setPreferredWidth(anchoColumna(75)); 
		u.getColumn(4).setPreferredWidth(anchoColumna(59));  
		u.getColumn(5).setPreferredWidth(anchoColumna(59));  
		

	}
	
	arrayreserva ar=new arrayreserva();
	private void codigoReserva() {
		
		Connection  c=null;
		 try {
				
				Class.forName("com.mysql.jdbc.Driver");
				c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
						
				} catch (Exception e) {
				e.getMessage();
			}
		 try {
				
				com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from reserva");
						
				ResultSet r=p.executeQuery();


				while (r.next()) {
				
				cmbReserva.addItem(r.getString("cod_reserva"));	
				
		
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			 
		
		
		
		
		
		
	}

	
	
	protected void do_btnX_actionPerformed(ActionEvent arg0) {
		int i=JOptionPane.showConfirmDialog(null,"Desea salir","salir", JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(i==JOptionPane.YES_OPTION)
		dispose();
		else
			JOptionPane.showMessageDialog(null,"exito");
	}
	ArrayBebida bebida=new ArrayBebida();
	private JTable tableAñadirB;
	private JScrollPane scrollPane_1;
	private JLabel label_16;
	private JLabel label_17;
	private JComboBox cmbReserva;
	private JLabel lblIdreserva;
	private JLabel lblListaDeBebidas;
	int codigob;
	String nombre;
	String marca;
	String tipo;
	String estado;
	double precio;
	
	añadirArrayBebida añadirbebida=	new  añadirArrayBebida();
	
	
	protected void do_btnAñadir_actionPerformed(ActionEvent arg0) {
	
		
	Connection c=null;
	 try {
			
			Class.forName("com.mysql.jdbc.Driver");
			c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
					
			} catch (Exception e) {
			e.getMessage();
		}
	 
	 
	 
	 
			
	 try {
		 
		 
		
			PreparedStatement ps=c.prepareStatement("insert into añadir_bebida values(?,?,?,?,?,?,?)");
				

			ps.setString(1,cmbReserva.getSelectedItem().toString());


			try {
				
				 p=table.getSelectedRow();
				 
			com.mysql.jdbc.Statement s=(com.mysql.jdbc.Statement) c.createStatement();
			
		ResultSetImpl r=(ResultSetImpl) s.executeQuery("select cod_bebida,nombre,marca,tipo,estado,precio "
				+ " from bebidas where cod_bebida="+table.getValueAt(p,0));
			
			
		
		if(r.next()){
			
			ps.setInt(2,r.getInt(1));
			ps.setString(3,r.getString(2));
			ps.setString(4,r.getString(3));
			ps.setString(5,r.getString(4));
			ps.setString(6,r.getString(5));
			ps.setDouble(7,r.getDouble(6));
			ps.executeUpdate();
		}	
		
			listartabla();
				
			
			
	 }catch (Exception e) {
	e.printStackTrace();	
	}
			
				
			} catch (SQLException  e) {
				
	
				e.printStackTrace();
				
			}
	
			dispose();
			new AñadirBebida().setVisible(true);
				

	
	

	
		
	}

	private void listartabla(){
		
		Connection c = null;
		try {
		
				Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		
		try {
			
			
			com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from bebidas");
					
			ResultSet r=p.executeQuery();

		modelo.setRowCount(0);

			while (r.next()) {
modelo.addRow(new Object[]{r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getDouble(5),r.getString(6)});
		table.setModel(modelo);
	
				
			}
				} catch (Exception e) {
				
				
				}
			

		
		
		
		
		
			
}

	
	private void listartabla2(){
	
		
		Connection c = null;
		try {
		
				Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		
		try {
			
			
			com.mysql.jdbc.PreparedStatement p=(com.mysql.jdbc.PreparedStatement) c.prepareStatement("select*from añadir_bebida");
					
			ResultSet r=p.executeQuery();

		modelo1.setRowCount(0);

			while (r.next()) {
modelo1.addRow(new Object[]{r.getString(1),r.getInt(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getDouble(7)});
		tableAñadirB.setModel(modelo1);
	
	claseañadirbebida ct=new claseañadirbebida(r.getString(1),r.getInt(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getDouble(7));
				añadirbebida.agregar(ct);
		
			}
				} catch (Exception e) {
					e.printStackTrace();
				
				}
		
			
		}

	protected void do_btnEliminar_actionPerformed(ActionEvent arg0) {
	
		Connection c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			int codigo=añadirbebida.Obtener(p).getIDBebida();
	PreparedStatement p=c.prepareStatement("delete from añadir_bebida  where cod_bebida="+codigo);

	
		int i=JOptionPane.showConfirmDialog(null,"Desea Eliminar","Eliminar", JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(i==JOptionPane.YES_OPTION){
	
		p.executeUpdate();
		listartabla2();
		}
		else{
			JOptionPane.showMessageDialog(null,"exito");
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		
		
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == table) {
			do_table_mouseClicked(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	
	
	public void mousePressed(MouseEvent e) {
	}
	
	
	public void mouseReleased(MouseEvent e) {
	}
	
	
	
	
	protected void do_table_mouseClicked(MouseEvent arg0) {
	
			
			
	}
	


private void excel2(){
		


		Workbook libros =new HSSFWorkbook();
		
		Sheet  hoja=libros.createSheet("hoja1");
	
		Row fila=null;
		Cell celda=null;
		

		fila=hoja.createRow(0);
		celda=fila.createCell(0);
		celda.setCellValue("Codigo_reserva");
		
		celda=fila.createCell(1);
		celda.setCellValue("Codigo_Bebida");
		
		celda=fila.createCell(2);
		celda.setCellValue("Nombre");
		celda=fila.createCell(3);
		celda.setCellValue("Tipo");
		
		
		celda=fila.createCell(4);
		celda.setCellValue("marca");
		
		
		celda=fila.createCell(5);
		celda.setCellValue("precio");
		
		
		
		celda=fila.createCell(6);
		celda.setCellValue("estado");
		
		for (int f = 0; f <tableAñadirB.getRowCount();f++) {
			fila=hoja.createRow(f+2);
		for (int i = 0; i < tableAñadirB.getRowCount(); i++) {
			
				 celda=fila.createCell(0);
			celda.setCellValue(tableAñadirB.getValueAt(f,0).toString());
			for (int j = 0; j < tableAñadirB.getRowCount(); j++) {

			 celda=fila.createCell(1);
			celda.setCellValue(tableAñadirB.getValueAt(f,1).toString());
			
			}
			for (int j = 0; j < tableAñadirB.getRowCount(); j++) {

				 celda=fila.createCell(2);
				celda.setCellValue(tableAñadirB.getValueAt(f,2).toString());
				
				}
			for (int j = 0; j < tableAñadirB.getRowCount(); j++) {

				 celda=fila.createCell(3);
				celda.setCellValue(tableAñadirB.getValueAt(f,3).toString());
				
				}
			for (int j = 0; j <tableAñadirB.getRowCount(); j++) {

				 celda=fila.createCell(4);
				celda.setCellValue(tableAñadirB.getValueAt(f,4).toString());
				
				}
			for (int j = 0; j <tableAñadirB.getRowCount(); j++) {

				 celda=fila.createCell(5);
				celda.setCellValue(tableAñadirB.getValueAt(f,5).toString());
				
				
			}
			for (int j = 0; j <tableAñadirB.getRowCount(); j++) {

				 celda=fila.createCell(6);
				celda.setCellValue(tableAñadirB.getValueAt(f,5).toString());
				
				}
	}
		
	}
		
		try {
			FileOutputStream f=new FileOutputStream(new File("añadirbebida.xls"));
			libros.write(f);
			Desktop.getDesktop().open(new File("añadirbebida.xls"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void do_btnGrabar_actionPerformed(ActionEvent arg0) {
		
		
		excel2();
		
		
	}
	protected void do_btnImprimir_actionPerformed(ActionEvent arg0) {
		
	
		
		MessageFormat header=new MessageFormat("Acomm karaoke");
		MessageFormat footer=new MessageFormat("Detalle añadir bebida{0,number,integer}");
		try {
			tableAñadirB.print(JTable.PrintMode.NORMAL, header,footer);
			
		} catch (java.awt.print.PrinterException e) {
			System.err.format("Cannot print %s%n",e.getMessage());
		}
		
	}
	protected void do_btnAcon_actionPerformed(ActionEvent arg0) {
		
	
	}
	
	public void mouseExited(MouseEvent arg0) {
	}
	protected void actionPerformedBtnmini(ActionEvent arg0) {
		
		
		setExtendedState(1);
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == contentPane) {
			mouseDraggedContentPane(e);
		}
	}
	
	int x,y;
	public void mouseMoved(MouseEvent e) {
		x=e.getX();
		y=e.getY();
	}
	protected void mouseDraggedContentPane(MouseEvent e) {
		Point p=MouseInfo.getPointerInfo().getLocation();
		setLocation(p.x-x, p.y-y);
	}
}

