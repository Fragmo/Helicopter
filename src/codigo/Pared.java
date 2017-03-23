/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;



/**
 *
 * @author marcf
 */
public class Pared{
        
    //las variables de aqui son aplicables a todos los metodos de la clase
        Rectangle2D pared, pared2;
        
        int altoPared = 100;
        int anchoPared = 100;
        int Xinicial;
        Random Aleatorio = new Random();
       Image chompImage;
         
         
        
  public Pared (int PosX) {    //constructor
       //las variables que declare aqui solo estaran para el constructor
      // desplazamiento = (int) pared.getX()*3;
      int posicionYPared = Aleatorio.nextInt(300);//declaro estos dos int aleatorios para que las dos 
      int posicionYPared2 = Aleatorio.nextInt(300);//primeras paredes no salgan en el mismo sitio
      Xinicial=PosX;

     pared = new Rectangle2D.Double(Xinicial,posicionYPared,anchoPared,altoPared);
     pared2 = new Rectangle2D.Double(Xinicial+ Xinicial/2, posicionYPared2, anchoPared, altoPared);
     precargaImagenes();
  }
  
    private void precargaImagenes(){
         
        chompImage = (new ImageIcon(new ImageIcon(
                getClass().getResource("/Imagenes/chomp.png"))
                .getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)))
                .getImage();

    }
     
  
public void creaPared(Graphics2D g2){

     
    //los pintamos
    g2.setColor(Color.blue);
    //g2.fill(pared);
    //g2.fill(pared2);
    
    g2.drawImage(chompImage, (int)pared.getX(), (int)pared.getY(), null);
    g2.drawImage(chompImage, (int)pared2.getX(), (int)pared2.getY(), null);
   //los movemos. NIVEL 1
   pared.setFrame(pared.getX()-3,pared.getY() , pared.getWidth(), pared.getHeight());
   pared2.setFrame(pared2.getX()-3, pared2.getY(), pared2.getWidth(), pared2.getHeight());
   
   
  
  }
public void redireccionPared(Graphics2D g2){
   
    int PosicionRedireccion = Aleatorio.nextInt(300);
    if(pared.getX()+pared.getWidth() <0 ){
        
    
      pared.setFrame(Xinicial+ Xinicial/2, PosicionRedireccion,pared.getWidth(), pared.getHeight());
       g2.drawImage(chompImage, (int)Xinicial+ Xinicial/2, (int)PosicionRedireccion, null);
   }
    //------- ESTO ANTES COMENTADO. TERMINAR DE COLOCAR BIEN
   if(pared2.getX()+pared.getWidth() <0 ){
      pared2.setFrame(Xinicial+ Xinicial/2, PosicionRedireccion,pared.getWidth(), pared.getHeight()); 
      g2.drawImage(chompImage, (int)pared2.getX(), (int)pared2.getY(), null);
   }
}

public void restart(Graphics2D g2){
    int PosicionRedireccion1 = Aleatorio.nextInt(300);
    int PosicionRedireccion2 = Aleatorio.nextInt(300);
    
    pared.setFrame(Xinicial,PosicionRedireccion1,anchoPared,altoPared);
    g2.drawImage(chompImage, (int)pared.getX(), (int)pared.getY(), null);
    pared2.setFrame(Xinicial+ Xinicial/2, PosicionRedireccion2, anchoPared, altoPared);
    g2.drawImage(chompImage, (int)pared2.getX(), (int)pared2.getY(), null);
    
}


}