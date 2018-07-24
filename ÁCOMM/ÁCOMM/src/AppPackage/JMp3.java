package AppPackage;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import Formulario.Acomm;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class JMp3 extends javax.swing.JFrame implements ActionListener {

    
    
    Control Music = new Control();
    public JMp3() {
        initComponents();
        setLocationRelativeTo(null);
        
        }
   
   
  
    private void initComponents() {
    	Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/cubo.png"));
		   setIconImage(icon);
		

			setUndecorated(true);
        Display = new javax.swing.JTextField();
        Display.setForeground(Color.WHITE);
        Display.setBackground(Color.DARK_GRAY);
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(Color.BLACK);
        stop3 = new javax.swing.JLabel();
        stop3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        stop3.setBounds(297, 10, 88, 92);
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBounds(20, 10, 275, 92);
        stop1 = new javax.swing.JLabel();
        stop1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        stop2 = new javax.swing.JLabel();
        stop2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        stop = new javax.swing.JLabel();
        stop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        state = new javax.swing.JLabel();
        state.setBounds(303, 88, 59, 0);
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBorder(new LineBorder(new Color(0, 0, 0), 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reproductor Mp3 Java");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Display.setEditable(false);
        Display.setFont(new java.awt.Font("Square721 BT", 0, 24)); // NOI18N
        Display.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Display.setText(" ");
        getContentPane().add(Display, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 290, -1));

        stop3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon fondo1=new ImageIcon(getClass().getResource("/img/cubo.png"));
		ImageIcon icon1=new ImageIcon(fondo1.getImage().getScaledInstance(stop3.getWidth(), stop3.getHeight(),Image.SCALE_DEFAULT));
		stop3.setIcon(icon1);
        stop3.setToolTipText("Open");
        stop3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stop3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
               
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
           
            }
        });
        jPanel1.setLayout(null);
        
        label = new JLabel("x");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setBounds(372, 107, 18, 13);
        jPanel1.add(label);
        jPanel1.add(stop3);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        stop1.setIcon(new ImageIcon(JMp3.class.getResource("/img/4.png"))); // NOI18N
        stop1.setToolTipText("Stop");
        stop1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stop1MouseClicked(evt);
            }
        });

        stop2.setIcon(new ImageIcon(JMp3.class.getResource("/img/5.png"))); // NOI18N
        stop2.setToolTipText("Play/Resume");
        stop2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stop2MouseClicked(evt);
            }
        });

        stop.setIcon(new ImageIcon(JMp3.class.getResource("/img/6.png"))); // NOI18N
        stop.setToolTipText("Pause");
        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
              
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(stop1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stop2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stop)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stop2)
                    .addComponent(stop1)
                    .addComponent(stop))
                .addContainerGap())
        );

        jPanel1.add(jPanel2);

        state.setFont(new java.awt.Font("Tahoma", 0, 14));
        state.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(state);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 390, 120));
        
        btnsalir = new JButton("");
        btnsalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnsalir.addActionListener(this);
        btnsalir.setIcon(new ImageIcon(JMp3.class.getResource("/img/negro.png")));
        btnsalir.setForeground(Color.WHITE);
        btnsalir.setFocusable(false);
        btnsalir.setFocusTraversalKeysEnabled(false);
        btnsalir.setFocusPainted(false);
        btnsalir.setContentAreaFilled(false);
        btnsalir.setBorderPainted(false);
        btnsalir.setBorder(new LineBorder(new Color(0, 0, 0), 0));
        btnsalir.setBackground(Color.WHITE);
        btnsalir.setBounds(359, 101, 31, 19);
        jPanel1.add(btnsalir);

        jLabel3.setFont(new Font("Tahoma", Font.BOLD, 31)); 
        jLabel3.setForeground(Color.DARK_GRAY);
        jLabel3.setIcon(new ImageIcon(JMp3.class.getResource("/img/MP3.png"))); 
        ImageIcon fondo2=new ImageIcon(getClass().getResource("/img/cubo.png"));
		ImageIcon icon2=new ImageIcon(fondo2.getImage().getScaledInstance(stop3.getWidth(), stop3.getHeight(),Image.SCALE_DEFAULT));
		 jLabel3.setIcon(icon2);
        jLabel3.setText("\u00C1COMM  Reproductor");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setIcon(new ImageIcon(JMp3.class.getResource("/img/audifonos-de-musica-87792.jpg"))); 
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }
    private void stop1MouseClicked(java.awt.event.MouseEvent evt) {
       
        Music.Stop();
        state.setText("Stop");
    }

    private void stop2MouseClicked(java.awt.event.MouseEvent evt) {
 
        Music.Resume();
        state.setText("Playing");
    }

    private void stopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseClicked
        // TODO add your handling code here:
        Music.Pause();
        state.setText("Pause");
    }//GEN-LAST:event_stopMouseClicked

    private void stop3MouseClicked(java.awt.event.MouseEvent evt) {
        
         FileFilter filter = new FileNameExtensionFilter("MP3 Files","mp3","mpeg3");
        
        JFileChooser chooser = new JFileChooser("F:\\Music");
        chooser.addChoosableFileFilter(filter);
        
        int returnVal = chooser.showOpenDialog(null);
        
        if(returnVal == JFileChooser.APPROVE_OPTION){
            
            File myFile = chooser.getSelectedFile();
            String song = myFile + "";
            
            String name = chooser.getSelectedFile().getName();            
            Display.setText(name);
            state.setText("Playing");
            Music.Play(song);
        }
    }

   
    public static void main(String args[]) {
    	try {

			
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		
		} catch (Exception e) {
			e.printStackTrace();
       }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
        	

 
            public void run() {
              JMp3 mp=new   JMp3();
              mp.setVisible(true);
            }
        });
    }


    private javax.swing.JTextField Display;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel state;
    private javax.swing.JLabel stop;
    private javax.swing.JLabel stop1;
    private javax.swing.JLabel stop2;
    private javax.swing.JLabel stop3;
    private JButton btnsalir;
    private JLabel label;
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnsalir) {
			do_btnsalir_actionPerformed(arg0);
		}
	}
	protected void do_btnsalir_actionPerformed(ActionEvent arg0) {
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

				

		
			

	 catch (Exception e) {
		e.printStackTrace();
	
		
	}

					
	 
	  

		
	}
}
