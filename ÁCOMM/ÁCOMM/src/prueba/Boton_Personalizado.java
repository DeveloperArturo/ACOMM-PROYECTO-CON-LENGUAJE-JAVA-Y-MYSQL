package prueba;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;


public class Boton_Personalizado extends JButton implements FocusListener, MouseListener{
    
    public Boton_Personalizado(){
        super();
        Boton_Personalizado.this.setSize(new Dimension(100,42));
        Boton_Personalizado.this.setForeground(new Color(255,255,255));
        Boton_Personalizado.this.setBorderPainted(true);
        Boton_Personalizado.this.setContentAreaFilled(false);
        Boton_Personalizado.this.setOpaque(true);
        Boton_Personalizado.this.setBackground( new Color(0,0,0));
        Boton_Personalizado.this.setFocusPainted(false);
        Boton_Personalizado.this.addFocusListener(Boton_Personalizado.this);
        Boton_Personalizado.this.addMouseListener(Boton_Personalizado.this);
    }

    @Override
    public void focusGained(FocusEvent e) {
       
    }

    @Override
    public void focusLost(FocusEvent e) {
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {
        Boton_Personalizado.this.setBackground( new Color(0,0,0));
        Boton_Personalizado.this.setForeground(new Color(255,255,255));
  
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
       Boton_Personalizado.this.setBackground( new Color(70,98,110));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Boton_Personalizado.this.setBackground( new Color(0,0,0));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       Boton_Personalizado.this.setBackground( new Color(255,255,255));
       Boton_Personalizado.this.setForeground(new Color(0,0,0));      


    }

        
    
}
