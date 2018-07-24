package Imprimir;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Array.ArrayUsuario;
import Formulario.Usuario;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.print.*;
import java.text.MessageFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsuarioImprimir extends  javax.swing.JFrame implements ActionListener 
{

	private JPanel contentPane;
	private JLabel label;
	private JPanel panel;
	private JButton btnAcom;
	private JLabel lblLbu;
	private JLabel label_2;
	private JLabel lblUsuario;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;

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
					UsuarioImprimir frame = new UsuarioImprimir();
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
	public UsuarioImprimir() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_3 = new JLabel("\u00C1COMM Karaoke");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(10, 652, 108, 14);
		contentPane.add(label_3);
		
		lblUsuario = new JLabel("Registro de Usuarios");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(10, 89, 226, 24);
		contentPane.add(lblUsuario);
		
		label_2 = new JLabel("");
		label_2.setBounds(412, 0, 48, 52);
		contentPane.add(label_2);
		ImageIcon fondo3=new ImageIcon(getClass().getResource("/img/paginaWeb.png"));
		ImageIcon icon3=new ImageIcon(fondo3.getImage().getScaledInstance(label_2.getWidth(),label_2.getHeight(),Image.SCALE_DEFAULT));
		label_2.setIcon(icon3);
		
		lblLbu = new JLabel("lbU");
		lblLbu.setIcon(new ImageIcon(UsuarioImprimir.class.getResource("/img/cv.png")));
		lblLbu.setBounds(4, 83, 470, 43);
		contentPane.add(lblLbu);
		
		btnAcom = new JButton("");
		btnAcom.addActionListener(this);
		btnAcom.setRolloverIcon(new ImageIcon(UsuarioImprimir.class.getResource("/img/princi2.png")));
		btnAcom.setIcon(new ImageIcon(UsuarioImprimir.class.getResource("/img/logo.png")));
		btnAcom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAcom.setFocusable(false);
		btnAcom.setFocusTraversalKeysEnabled(false);
		btnAcom.setFocusPainted(false);
		btnAcom.setContentAreaFilled(false);
		btnAcom.setBorderPainted(false);
		btnAcom.setBounds(4, -4, 48, 56);
		contentPane.add(btnAcom);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setBounds(4, 124, 470, 482);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 0));
		scrollPane.setBounds(10, 61, 450, 421);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	
		
		label = new JLabel("");
		label.setBounds(0, 0, 478, 693);
		contentPane.add(label);
		ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/princi.png"));
		ImageIcon icon1=new ImageIcon(fondo1.getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_DEFAULT));
		label.setIcon(icon1);
		
		modelo=new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombres");
		modelo.addColumn("Paterno");
		modelo.addColumn("Materno");
		modelo.addColumn("Empleado");
		modelo.addColumn("Turno");
		modelo.addColumn("Password");
		table.setModel(modelo);
		
		btnusua = new JButton("");
		btnusua.addActionListener(this);
		btnusua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnusua.setBorderPainted(false);
		btnusua.setContentAreaFilled(false);
		btnusua.setDefaultCapable(false);
		btnusua.setFocusPainted(false);
		btnusua.setFocusTraversalKeysEnabled(false);
		btnusua.setFocusable(false);
		btnusua.setIcon(new ImageIcon(UsuarioImprimir.class.getResource("/img/usuarioss.png")));
		btnusua.setBounds(189, 11, 89, 50);
		panel.add(btnusua);
		
		ancho();
		//listartabla();
		
	
	}
	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane .getWidth() / 100;
	}
	private void ancho(){
		TableColumnModel u = table.getColumnModel();
		u.getColumn(0).setPreferredWidth(anchoColumna(33)); 
		u.getColumn(1).setPreferredWidth(anchoColumna(54)); 
		u.getColumn(2).setPreferredWidth(anchoColumna(57));  
		u.getColumn(3).setPreferredWidth(anchoColumna(56)); 
		u.getColumn(4).setPreferredWidth(anchoColumna(59));  
		u.getColumn(5).setPreferredWidth(anchoColumna(38));  
		u.getColumn(6).setPreferredWidth(anchoColumna(60));  
		

	}
	ArrayUsuario au=new ArrayUsuario();
	private JLabel label_3;
	private JButton btnusua;
	/*
	private void listartabla(){
		modelo.setRowCount(0);
		for (int i = 0; i < au.tamaño(); i++) {
			
			Object lista[]={"u"+au.Obtener(i).codigo(),au.Obtener(i).getNombres(),au.Obtener(i).getApellidoPaterno(),au.Obtener(i).getApellidoMaterno(),
				
					au.Obtener(i).getTipoEmpleado(),au.Obtener(i).getTurno(),au.Obtener(i).getPassword()
			};
			
			
			modelo.addRow(lista);
			
			
		}
		
	}
		*/
		
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAcom) {
			do_btnAcom_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnusua) {
			do_btnusua_actionPerformed(arg0);
		}
	}
	protected void do_btnusua_actionPerformed(ActionEvent arg0) {
		
		
		MessageFormat header=new MessageFormat("Acomm karaoke");
		MessageFormat footer=new MessageFormat("Detalle Usuario{0,number,integer}");
		try {
			table.print(JTable.PrintMode.NORMAL, header,footer);
			dispose();
		} catch (java.awt.print.PrinterException e) {
			System.err.format("Cannot print %s%n",e.getMessage());
		}
	}
	protected void do_btnAcom_actionPerformed(ActionEvent arg0) {
		dispose();
	}
}
