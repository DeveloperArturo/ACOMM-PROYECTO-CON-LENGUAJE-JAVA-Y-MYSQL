package Clase;


import java.awt.Color;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import prueba.Boton_Personalizado;
import prueba.Caja_Texto_Editada;
import prueba.Caja_Texto_Editada_Pass;
import prueba.Mensaje_Dialogo;
import prueba.Panel;
import javax.swing.border.LineBorder;

import AppPackage.JMp3;
import Formulario.Acomm;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionListener;


public class ventana extends JFrame implements MouseListener,MouseMotionListener, ActionListener{
    
  
    
    
    private Font LABEL_FONT = new Font("Agency FB", Font.PLAIN, 18);
    private Color LABEL_COLOR= new Color(255,255,255);
    private Point initialClick;
    private Boton_Personalizado btn2;
    
    private void initCompoents()
    {
        
        setResizable(false);
        ventana.this.setBackground(new Color(0,0,0,0));
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/paginaWeb.png"));
		   setIconImage(icon);
        Panel panel = new Panel();
        panel.setLayout(null);
        panel.setBounds(800, 80, 800, 900);
        
        JLabel LbName = new JLabel("USUARIO");
        LbName.setFont(new Font("Tahoma", Font.BOLD, 16));
        LbName.setBounds(80,80,340,34);
        LbName.setForeground(LABEL_COLOR);
        
        Caja_Texto_Editada userText = new Caja_Texto_Editada();
        userText.setBounds(80,120,340,32);
        JLabel LbPass = new JLabel("CONTRASEÑA");
        LbPass.setFont(new Font("Tahoma", Font.BOLD, 16));
        LbPass.setBounds(80,170,340,32);
        LbPass.setForeground(LABEL_COLOR);
   
        Caja_Texto_Editada_Pass passText = new Caja_Texto_Editada_Pass();
        passText.setForeground(Color.WHITE);
        passText.setSelectedTextColor(Color.DARK_GRAY);
        passText.setDisabledTextColor(Color.DARK_GRAY);
        passText.setBorder(new LineBorder(new Color(0, 0, 0), 0));
        passText.setBounds(80,210,340,36);
        
      
        Boton_Personalizado btn1 = new Boton_Personalizado();
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn1.setBorder(new LineBorder(new Color(162, 183, 188), 0));
        btn1.setText("ACEPTAR");
        btn1.setBounds(80,260,120,36);
     
        btn2 = new Boton_Personalizado();
        btn2.addActionListener(this);
        btn2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn2.setBorder(new LineBorder(new Color(162, 183, 188), 0));
        btn2.setText("CANCELAR");
        btn2.setBounds(210,260,120,36);
        
        
    
        btn1.addActionListener((ActionEvent e)->{
            
            if(userText.getText().equals("admin") && passText.getText().equals("123"))
                {
                    
                    Mensaje_Dialogo myDialogo = new Mensaje_Dialogo(ventana.this, true, "Exitos los datos Son correcto");
                    dispose();
                    JMp3 m=new   JMp3();
                    m.setVisible(true);
                    m.setLocationRelativeTo(null);
                if(myDialogo.getAnswer())
                {
                    
                }
                }else{
          Mensaje_Dialogo myDialogo = new Mensaje_Dialogo(ventana.this, true, "Datos Incorrectos");

                if(myDialogo.getAnswer())
                {
                    
                }
                
            }
        
        });
        
        
        
        panel.add(LbName);
        panel.add(userText);
        panel.add(LbPass);
        panel.add(passText);
        panel.add(btn1);
        panel.add(btn2);
        
    
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(panel);
        pack();
        
        
    }
   
    @Override
    public void mouseDragged(MouseEvent e) {
        int thisX = getLocation().x;
        int thisY = getLocation().y;
       
        int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
        int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);
       
        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        this.setLocation(X, Y);
    }
    
 
    public void mouseClicked(MouseEvent e) {
     
    }


    public void mousePressed(MouseEvent e) {
        setCursor(new Cursor(Cursor.MOVE_CURSOR));
        initialClick = e.getPoint();
        getComponentAt(initialClick);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
    
    public ventana()
    {
        
        ventana.this.setUndecorated(true);
        initCompoents();
        ventana.this.setLocationRelativeTo(null);
        ventana.this.addMouseListener(ventana.this);
        ventana.this.addMouseMotionListener(ventana.this);
    }
    
    
    public static void main(String args[]) {
	try {

			
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		
		} catch (Exception e) {
			e.printStackTrace();
		}

          java.awt.EventQueue.invokeLater(() -> {
              new  ventana().setVisible(true);
          });
        
    }

    
    
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn2) {
			do_btn2_actionPerformed(e);
		}
	}
	protected void do_btn2_actionPerformed(ActionEvent e) {
		
		dispose();
		Acomm t=new Acomm(); 
		t.setVisible(true);
		t.setLocationRelativeTo(null);
		try {
			

			
			
			
			 Acomm.velmil=3000;
			
			 Acomm.tarea =new TimerTask(){
			

				public void run(){
					
				
					
					switch (Acomm.contador) {
					case 0:
						Acomm.contador=1;
							ImageIcon fondo=new ImageIcon(getClass().getResource("/img/music.png"));
							ImageIcon iconos=new ImageIcon(fondo.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel.getHeight(),Image.SCALE_DEFAULT));
							t.Carrusel.setIcon(iconos);
						break;

					case 1:
						Acomm.contador=2;
						ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/cancion.jpg"));
						ImageIcon iconos1=new ImageIcon(fondo1.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel .getHeight(),Image.SCALE_DEFAULT));
						t.Carrusel.setIcon(iconos1);
						
						break;
					case 2:
						Acomm.contador=3;
						ImageIcon fondo2=new ImageIcon(getClass().getResource("/img/noches.png"));
						ImageIcon iconos2=new ImageIcon(fondo2.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel .getHeight(),Image.SCALE_DEFAULT));
						t.Carrusel.setIcon(iconos2);
						break;
					case 3:
						Acomm.contador=4;
						ImageIcon fondo3=new ImageIcon(getClass().getResource("/img/arcoiris.png"));
						ImageIcon iconos3=new ImageIcon(fondo3.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel .getHeight(),Image.SCALE_DEFAULT));
						t.Carrusel.setIcon(iconos3);
						break;
						
					case 4:
						Acomm.contador=0;
					ImageIcon fondo4=new ImageIcon(getClass().getResource("/img/estrella.png"));
					ImageIcon iconos4=new ImageIcon(fondo4.getImage().getScaledInstance(t.Carrusel .getWidth(),t.Carrusel .getHeight(),Image.SCALE_DEFAULT));
					t.Carrusel.setIcon(iconos4);
					break;
					
				
				}
					
			}
			
			
			
			};
			
			
			Acomm.timer=new Timer();
			
			Acomm.timer.scheduleAtFixedRate(Acomm.tarea, Acomm.velmil,Acomm.velmil);
		

			
		}

				

		
			

	 catch (Exception f) {
		f.printStackTrace();
	
		
	}

					
	 
	  

	}
}
