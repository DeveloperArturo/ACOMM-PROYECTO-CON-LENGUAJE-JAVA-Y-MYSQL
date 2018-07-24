package prueba;


import java.awt.AlphaComposite;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Panel extends JPanel{
    
    private final Dimension dimension   =   new Dimension(500,400);    
 
    
    private final Image logo            =   new ImageIcon(getClass().
                                            getResource("/img/t.jpg")).getImage();
    private final Image image           =   new ImageIcon(getClass().
                                            getResource("/img/1.jpg")).getImage();
    private BufferedImage bufferedImage; 


 public Panel(){
        super();
        bufferedImage = imageToBI(image);  
        
        Panel.this.setSize(dimension);
        Panel.this.setPreferredSize(dimension);
    }   



 @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 =(Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);            
        
       
        int x1Points[] = {25,290,318,399,404,497,497,480,480,497,497,105,59,25,3,3,25,25,3,3};  
        int y1Points[] = {3,3,30,30,25,25,72,89,143,170,350,350,396,396,375,235,199,71,49,25};
        GeneralPath polygonPrincipal = new GeneralPath(GeneralPath.WIND_EVEN_ODD,x1Points.length);                 
        polygonPrincipal.moveTo(x1Points[0], y1Points[0]); 
        for(int i=0;i<x1Points.length;i++){
            polygonPrincipal.lineTo(x1Points[i], y1Points[i]);     
        }
        polygonPrincipal.closePath();
        
       
        g2.setComposite(AlphaComposite.getInstance(
        AlphaComposite.SRC_OVER, 0.8f));
        
        
        TexturePaint paint = new TexturePaint( bufferedImage,
         new Rectangle2D.Double( 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight() ) );                
        
       
        g2.setPaint(paint);
        g2.fill( polygonPrincipal );        
        g2.setStroke(new BasicStroke( 3 ));
        g2.draw( polygonPrincipal );
        
 
        Polygon panelCentral = new Polygon();
        panelCentral.addPoint( 40, 40 );
        panelCentral.addPoint( 460, 40 );
        panelCentral.addPoint( 460, 480);
        panelCentral.addPoint( 40, 310);  
       
        g2.setPaint(new GradientPaint(0, 0, new Color(255 ,0 ,0),255,255,new Color(0)));
        g2.fill( panelCentral );
        
       

         
    }
 
 
 

    
   
    private BufferedImage imageToBI(Image img){          
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return bi;
    }
 
 
 
}