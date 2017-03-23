/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author marcf
 */
public class Helicoptero extends Ellipse2D.Double {
    
  
    int posX;
    int posY;
    int vidas = 0;
    Image HelicopteroImage;
    Poder miPoder = new Poder();

  
    public Helicoptero (int PosX, int PosY){
        super(PosX, PosY, 50, 50);
       posX= PosX;
       posY = PosY;
       precargaImagenes();
    }
    
    private void precargaImagenes(){
         
        HelicopteroImage = (new ImageIcon(new ImageIcon(
                getClass().getResource("/Imagenes/kirby.png"))
                .getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)))
                .getImage();
     
    }
    
    public void bajaHelicoptero(Graphics2D g2){
      //  g2.setColor(Color.yellow);
      //  g2.fill(this);
        g2.drawImage(HelicopteroImage, (int)this.getX(), (int)this.getY(), null);
        this.y ++ ;
        
       
        
    }
    public void subeHelicoptero(){
        
        this.y = y-30;
    }
    
    public boolean chequeaColision(Pared p, Poder po ){
       
        Area AreaHelicoptero = new Area(this);
        Area AreaPared1 = new Area(p.pared);
        Area AreaPared2 = new Area(p.pared2);
        Area AreaVida = new Area(po.vida);
        
        boolean chocaPared1 = true;
        boolean chocaPared2 = true;
      // boolean chocaVida = true;
        
        
        AreaHelicoptero.intersect(AreaVida);// coger vidaaaaaaaaaaaaaaaaaaaaaaaaas
        if(!AreaHelicoptero.isEmpty()){
            //chocaVida= false;
            vidas ++;
            miPoder.vida.setFrame(miPoder.vida.getX()+100, miPoder.vida.getY(), 
            miPoder.vida.getWidth(), miPoder.vida.getHeight());
        }else{

            
        }
        AreaHelicoptero = new Area(this);
        AreaHelicoptero.intersect(AreaPared1);
        if(AreaHelicoptero.isEmpty()){
            chocaPared1 = false;
        }
        AreaHelicoptero = new Area(this);
        AreaHelicoptero.intersect(AreaPared2);
        
        if(AreaHelicoptero.isEmpty()){
            chocaPared2 = false;
        }
        
        
        
        return (AreaHelicoptero.intersects(p.pared) || 
                AreaHelicoptero.intersects(p.pared2) ||
                chocaPared1 || chocaPared2
                );
    }
}
