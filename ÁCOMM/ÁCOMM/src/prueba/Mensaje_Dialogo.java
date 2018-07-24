package prueba;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JDialog; 
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;


/**
 *
 * @author Oscar
 */
public class Mensaje_Dialogo extends JDialog implements ActionListener{
   
    private Boton_Personalizado okButton = null;  
    private boolean answer = false;
    private final boolean answer1 = false;
    
    
    public Mensaje_Dialogo(JFrame frame, boolean modal, String message) {        
        super(frame, modal);
        //Creación de las dimensiones del Dialogo
        Mensaje_Dialogo.this.setPreferredSize( new Dimension(400,60));
        Mensaje_Dialogo.this.setUndecorated(true);
        GridBagConstraints gridBagConstraints;
        
        JPanel myPanel = new JPanel();
        myPanel.setPreferredSize(new Dimension(500,100));
        myPanel.setBorder(BorderFactory.createLineBorder(new Color(119,232,228), 2));
        myPanel.setBackground(new Color(0,0,0));
        myPanel.setLayout(new GridBagLayout());
        
        Mensaje_Dialogo.this.getContentPane().add(myPanel);        
        
        JLabel lbMsg = new JLabel(message);
        lbMsg.setForeground(new Color(255,255,255));
        lbMsg.setOpaque(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        myPanel.add(lbMsg,gridBagConstraints);
        //Creación del Boton
        okButton = new Boton_Personalizado();
        okButton.setText("OK");
        okButton.setPreferredSize(new Dimension(80,34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        myPanel.add(okButton,gridBagConstraints);           
        //segundo Botton
        
        
        /*okButton1 = new Boton_Personalizado();
        okButton1.setText("CANCELAR");
        okButton1.setPreferredSize(new Dimension(80,34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        myPanel.add(okButton1,gridBagConstraints); */
        
        //listener
        Mensaje_Dialogo.this.okButton.addActionListener(Mensaje_Dialogo.this);        
       /* Mensaje_Dialogo.this.okButton1.addActionListener(Mensaje_Dialogo.this);  */ 
        Mensaje_Dialogo.this.pack();
        Mensaje_Dialogo.this.setLocationRelativeTo(frame);
        Mensaje_Dialogo.this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e ) {
        if(okButton == e.getSource()) {
            answer = true;
            setVisible(false);
            
        }/*else{
            if(okButton1 == e.getSource()) {
            answer1 = true;
           }
        }*/      
    }
    
   
    
    public boolean getAnswer() { return answer; }
    public boolean getAnswer1() { return answer1; }
    
    
    
}