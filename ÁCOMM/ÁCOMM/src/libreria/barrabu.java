package libreria;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.MouseEvent;

public class barrabu extends JFrame implements MouseListener,Printable {

	private JPanel contentPane;
	private JPanel panelbarru;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					barrabu frame = new barrabu();
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
	public barrabu() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelbarru = new JPanel();
		panelbarru.setBackground(Color.WHITE);
		panelbarru.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panelbarru.setBounds(0, 0, 485, 437);
		contentPane.add(panelbarru);
		
		 contarSupervisor();
		 contaradministrador();
		 contarmoso();
		 graficobarra();
	}

	int supervisor;
	int moso;
	int adminid;
	private ChartPanel chartPanel;
private void contarSupervisor(){
		
		Connection c = null;
		try {
		
	Class.forName("com.mysql.jdbc.Driver");
	c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
				
		} catch (Exception e) {
		
		}
		
		try {
			
			Statement s=(Statement) c.createStatement();
			ResultSet r=s.executeQuery("select count(u.tipo) from usuarios u where u.tipo='supervisor'");
			
			
			if(r.next()){
			
				supervisor=r.getInt(1);
			
			}
			
			
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "no hay supervisores");
		}
		
}
private void contaradministrador(){
	
	Connection c = null;
	try {
	
Class.forName("com.mysql.jdbc.Driver");
c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
			
	} catch (Exception e) {
	
	}
	
	try {
		
		Statement s=(Statement) c.createStatement();
		ResultSet r=s.executeQuery("select count(u.tipo) from usuarios u where u.tipo='Administrador'");
		
		
		if(r.next()){
		adminid=r.getInt(1);
		
		}
		
		
	} catch (Exception e) {

		JOptionPane.showMessageDialog(null, "no hay supervisores");
	}
	
}
private void contarmoso(){
	
	Connection c = null;
	try {
	
Class.forName("com.mysql.jdbc.Driver");
c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/acomm","root","mysql");
			
	} catch (Exception e) {
	
	}
	
	try {
		
		Statement s=(Statement) c.createStatement();
		ResultSet r=s.executeQuery("select count(u.tipo) from usuarios u where u.tipo='Mozo'");
		
		
		if(r.next()){
		moso=r.getInt(1);
		
		}
		
		
	} catch (Exception e) {

		JOptionPane.showMessageDialog(null, "no hay supervisores");
	}
	
}
	private void graficobarra(){
		
		
		int adminidi=adminid;
		int supervi=supervisor;
		int mozo=moso;
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(adminidi, "Administradores", "Administradores");
        dataset.setValue(supervi, "Supervisores", "Supervisores");
        dataset.setValue(mozo, "Mozo", "Mozo");
    
     
        
        
        JFreeChart chart = ChartFactory.createBarChart3D 
       ("","Tipos", "Cantidad", 
        dataset, PlotOrientation.VERTICAL, true,true, false);
        chart.setBackgroundPaint(Color.white);
   
        chart.getTitle().setPaint(Color.darkGray); 
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.LIGHT_GRAY);
        p.setBackgroundPaint(Color.WHITE);
     
    	
		chartPanel = new ChartPanel(chart);
		chartPanel.addMouseListener(this);
		chartPanel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		chartPanel.setBounds(0, 0, 478, 437);
		panelbarru.add(chartPanel);
	
        panelbarru.setLayout(null);
		
	}
	
	
	
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == chartPanel) {
			mouseClickedChartPanel(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override

	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

		 if (pageIndex > 0) { 
		   return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D)graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	

		panelbarru.printAll(graphics);

			

		return PAGE_EXISTS;

		
	}
	protected void mouseClickedChartPanel(MouseEvent arg0) {
		

		
		 try {
			   PrinterJob job = PrinterJob.getPrinterJob();
			   job.setPrintable(this);
			   job.printDialog();
			   job.print();
			   dispose();
			 } catch (PrinterException ex) {
			   ex.printStackTrace();
			 }
		
	}

	
}
