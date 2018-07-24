package Adicionales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;
import Formulario.Acomm;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Font;




public class sphas extends JFrame implements ActionListener {

		private JPanel contentPane;
		private JLabel labelSphas;
		private JProgressBar Bar;
		private int num = 0;
		private JLabel labelcuadro;
		private JLabel lbKaraoke;
		private JLabel lbTapar;
		private JLabel label;
		private JLabel label_1;
		private JLabel bcuadro;
	  	private JLabel lblElEquipoDe;
	  	private JLabel lblTambinHayUna;
	  	private JLabel lblHayVariosTipos;
	  	private JLabel lblNewLabel;
	  	private JLabel lblNewLabel_1;

	  
		public static void main(String[] args) {	
			try {

			
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			sphas frame = new sphas();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);	
			 frame.iterate();
			EventQueue.invokeLater(new Runnable() {
			
				public void run() {
					try {
						
					
				
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			});
		}
		
		

	public sphas() {
		
		setUndecorated(true);
		 this.setBackground(new Color(0,0,0,0));
	
		final int ANCHO = 1000,
		          ALTO = 650,
		          DX = 8,
		          DY = 53;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((getToolkit().getScreenSize().width - ANCHO - DX) / 2,
				  (getToolkit().getScreenSize().height - ALTO - DY) / 2,
				   ANCHO + DX, ALTO + DY);

		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/cubo.png"));
		   setIconImage(icon);

		
		
		setBounds(100, 100, 658, 528);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0,0,0,0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel(" Reproductor de m\u00FAsica, micr\u00F3fono y entradas, ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel_1.setBounds(388, 260, 243, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("botones de control de tono y salida de audio. ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(406, 274, 236, 14);
		contentPane.add(lblNewLabel);
		
		lblElEquipoDe = new JLabel(" El equipo de karaoke b\u00E1sico consiste en un ");
		lblElEquipoDe.setForeground(Color.WHITE);
		lblElEquipoDe.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblElEquipoDe.setBounds(388, 239, 243, 14);
		contentPane.add(lblElEquipoDe);
		
		lblTambinHayUna = new JLabel("Tambi\u00E9n hay una serie de pistas de karaoke  CD.\r\n");
		lblTambinHayUna.setForeground(Color.WHITE);
		lblTambinHayUna.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblTambinHayUna.setBounds(388, 221, 243, 14);
		contentPane.add(lblTambinHayUna);
		
		lblHayVariosTipos = new JLabel("Hay varios tipos de m\u00E1quinas de karaoke.\r\n");
		lblHayVariosTipos.setForeground(Color.WHITE);
		lblHayVariosTipos.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblHayVariosTipos.setBounds(397, 196, 209, 28);
		contentPane.add(lblHayVariosTipos);
		
		bcuadro = new JLabel("");
		bcuadro.setBounds(435, 11, 157, 174);
		contentPane.add(bcuadro);
		ImageIcon fondo2=new ImageIcon(getClass().getResource("/img/cubo.png"));
		ImageIcon icon2=new ImageIcon(fondo2.getImage().getScaledInstance(bcuadro.getWidth(),bcuadro .getHeight(),Image.SCALE_DEFAULT));
		bcuadro.setIcon(icon2);
		
		
		
		lbKaraoke = new JLabel("");
		lbKaraoke.setBounds(-15, 43, 356, 299);
		contentPane.add(lbKaraoke);
		lbKaraoke.setIcon(new ImageIcon(sphas.class.getResource("/img/negri.png")));
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(sphas.class.getResource("/img/o.png")));
		label_1.setBounds(34, 35, 126, 195);
		contentPane.add(label_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(sphas.class.getResource("/img/o.png")));
		label.setBounds(171, 131, 80, 157);
		contentPane.add(label);
		
		lbTapar = new JLabel("");
		lbTapar.setIcon(new ImageIcon(sphas.class.getResource("/img/o.png")));
		lbTapar.setBounds(21, 82, 230, 206);
		contentPane.add(lbTapar);
		
		
		labelcuadro = new JLabel("");
		labelcuadro.setBounds(324, 312, 60, 78);
		contentPane.add(labelcuadro);
		labelcuadro.setIcon(new ImageIcon(sphas.class.getResource("/img/princi2.png")));
		
		Bar = new JProgressBar(0,2000);
		Bar.setBackground(Color.DARK_GRAY);
		Bar.setBorderPainted(false);
		Bar.setFocusTraversalKeysEnabled(false);
		Bar.setFocusable(false);
		Bar.setForeground(new Color(0, 0, 0));
		Bar.setValue(0);
		Bar.setStringPainted(true);
		Bar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		Bar.setBounds(208, 374, 341, 28);
		contentPane.add(Bar);
		
		labelSphas = new JLabel("");
		labelSphas.setBounds(0, 0, 642, 490);
		contentPane.add(labelSphas);
		ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/spathas.png"));
		ImageIcon icon1=new ImageIcon(fondo1.getImage().getScaledInstance(		labelSphas.getWidth(), 		labelSphas.getHeight(),Image.SCALE_DEFAULT));
		labelSphas.setIcon(icon1);
		
	}
	
	

	public void actionPerformed(ActionEvent arg0) {
	}
	
	

	public void iterate() {
		  while (num < 2000) {
		  Bar.setValue(num);
		  try {
		  Thread.sleep(300);
		  } catch (InterruptedException e) { 
		    }
		  num += 35;
		
		  }
		  

			
			dispose();
			iniciarSesion gn= new iniciarSesion();
			gn.setVisible(true);
			gn.setLocationRelativeTo(null);

						
		 
		  }
}
