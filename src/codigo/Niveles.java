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
   
    

   
    
public void nivel2(Pared miPared){
 // NIVEL DOS
    if(segundos <4000000 //&& 
      //miPared.pared.getY()>=0 && miPared.pared2.getY()>=0 &&
    //  miPared.pared.getY() <= 390 && miPared.pared2.getY() <=390 //&&
    //pared.getY() <= pared.getY() +30 &&
    //pared2.getY() <= pared.getY() +30 &&
    //pared.getX()== 628 &&
    //pared2.getX() == 628      
            ){
   
   miPared.pared.setFrame(miPared.pared.getX()-3,miPared.pared.getY()-1 , miPared.pared.getWidth(), miPared.pared.getHeight());
   
   miPared.pared2.setFrame(miPared.pared2.getX()-3, miPared.pared2.getY()+1, miPared.pared2.getWidth(), miPared.pared2.getHeight());
   
    }
 }
}
