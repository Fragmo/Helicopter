/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author marcf
 */

public class Niveles {
    //Pared miPared = new Pared(600);
    
    int segundos = 0;
   boolean cambiaSentidoPared= false;
    

   
    
public void nivel2(Pared p){
 // NIVEL DOS
 //&& 
      //miPared.pared.getY()>=0 && miPared.pared2.getY()>=0 &&
    //  miPared.pared.getY() <= 390 && miPared.pared2.getY() <=390 //&&
    //pared.getY() <= pared.getY() +30 &&
    //pared2.getY() <= pared.getY() +30 &&
    //pared.getX()== 628 &&
    //pared2.getX() == 628      
  
  if(segundos >=15){
  
   // MOVIEMIENTO NUEVO DE LA PRIMERA PARED
      if(p.pared.getY()+ p.pared.getHeight() > 390){
       cambiaSentidoPared = false;
//       
//   // p.pared.setFrame(p.pared.getX()-1,p.pared.getY()+1 , p.pared.getWidth(), p.pared.getHeight());
   }
      
   if(cambiaSentidoPared == false){
 p.pared.setFrame(p.pared.getX()-1,p.pared.getY()-3 , p.pared.getWidth(), p.pared.getHeight());
    }
   if(p.pared.getY() <0 ){
       cambiaSentidoPared = true;
      // p.pared.setFrame(p.pared.getX()-1,p.pared.getY()+16 , p.pared.getWidth(), p.pared.getHeight());     
   }
   if(cambiaSentidoPared == true){
       p.pared.setFrame(p.pared.getX()-1,p.pared.getY()+3 , p.pared.getWidth(), p.pared.getHeight());
   }
//   if(cambiaSentidoPared == true){
//   p.cambiaY1();
// 
//   System.out.println("12");
//
//   }

   
   
   
   //movimiento de la segunda pared
 p.pared2.setFrame(p.pared2.getX()-1, p.pared2.getY()+1, p.pared2.getWidth(), p.pared2.getHeight());
   if(p.pared2.getY() == 0 ){
    p.pared2.setFrame(p.pared2.getX()-1, p.pared2.getY()-1, p.pared2.getWidth(), p.pared2.getHeight());   
   }
   if(p.pared2.getY() == 390){
    p.pared2.setFrame(p.pared2.getX()-1, p.pared2.getY()+1, p.pared2.getWidth(), p.pared2.getHeight());    
    }   
   } 
 }
}


