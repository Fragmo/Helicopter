/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author marcf
 */
public class Poder{
    
    Ellipse2D vida;
    Random aleatorio = new Random();
    Image vidaImage;
    public Poder (){
        
        
        int posY = aleatorio.nextInt(300);
        
        
        vida = new Ellipse2D.Double(300, posY, 30, 30);
        precargaImagenes();
    }
    private void precargaImagenes(){
         
        vidaImage = (new ImageIcon(new ImageIcon(
                getClass().getResource("/Imagenes/1 up.png"))
                .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)))
                .getImage();
     
    }
    public void creaVida(Graphics2D g2){
       // g2.setColor(Color.red);
       // g2.fill(vida);
        g2.drawImage(vidaImage, (int)vida.getX(), (int)vida.getY(), null);
        
        vida.setFrame(vida.getX()-1,vida.getY(), vida.getWidth(), vida.getHeight());
    }
    public void redireccion(Graphics2D g2){
       int posYaleatorio = aleatorio.nextInt(300);
       
        if(vida.getX() + vida.getWidth() ==0){
         vida.setFrame(500, posYaleatorio,vida.getWidth(), vida.getHeight());   
        }
 
    }
    public void restart(Graphics2D g2){
        int posYaleatorio = aleatorio.nextInt(300);
       vida.setFrame(500, posYaleatorio,vida.getWidth(), vida.getHeight());
    }
}
