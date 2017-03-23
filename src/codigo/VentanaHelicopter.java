/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import static javafx.scene.input.KeyCode.X;
import javax.swing.Timer;
//////
import java.applet.AudioClip;

/**
 *
 * @author marcf
 */
public class VentanaHelicopter extends javax.swing.JFrame {
    Helicoptero miHelicoptero = new Helicoptero(100,100);
    Pared miPared = new Pared(600);
    Poder miPoder = new Poder();
    Niveles miNivel = new Niveles();
    AudioClip cancion;
    BufferedImage buffer = null;
    Graphics2D bufferGraphics, lienzoGraphics = null;
    
    
    
    
    Timer temporizador = new Timer(10,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            bucleJuego();
            miNivel.segundos++;
        }
    });

 
    /**
     * Creates new form VentanaHelicopter
     */
    public VentanaHelicopter() {
        initComponents();
        inicializaBuffers();
        boton.setVisible(false);
        temporizador.start();
        musica();      
        
        
        
        
    }
    
   public void inicializaBuffers(){
        lienzoGraphics = (Graphics2D) Lienzo.getGraphics(); 
        buffer = (BufferedImage) Lienzo.createImage(Lienzo.getWidth(), Lienzo.getHeight());
        bufferGraphics = buffer.createGraphics();
        
        bufferGraphics.setColor(Color.BLACK);
        bufferGraphics.fillRect(0, 0, Lienzo.getWidth(), Lienzo.getHeight());
   }
   
    public void musica (){
        
        cancion = java.applet.Applet.newAudioClip(getClass().getResource("/musica/Helicopter-Martin-Garrix.wav"));
        cancion.loop();
    }

   
   public void bucleJuego(){
       //declaracion de todas las clases
    bufferGraphics.setColor(Color.BLACK);
    bufferGraphics.fillRect(0, 0, Lienzo.getWidth(), Lienzo.getHeight());
    
    miHelicoptero.bajaHelicoptero(bufferGraphics);
    
    miPared.creaPared(bufferGraphics);
    miPared.redireccionPared(bufferGraphics);
    
    miPoder.creaVida(bufferGraphics);      //abajo de todo el codigo esta el del contador. Revisarlo
    miPoder.redireccion(bufferGraphics);
    
    //Niveles
    //Nivel2
    
    if(miNivel.segundos >=1000){     //-----------------------------------------------
       miNivel.nivel2(miPared);
   }

      //chequeo de la colision
   if(miHelicoptero.chequeaColision(miPared, miPoder)){
       
      miHelicoptero.vidas --;
      
      if(miHelicoptero.vidas>0 ){
          miPared.pared.setFrame(miPared.pared.getX()+miPared.Xinicial+ miPared.Xinicial, miPared.pared.getY(), miPared.pared.getWidth(), miPared.pared.getHeight());
          miPared.pared2.setFrame(miPared.pared2.getX()+miPared.Xinicial+ miPared.Xinicial, miPared.pared2.getY(), miPared.pared2.getWidth(), miPared.pared2.getHeight());
      }        
              
              
              
       if(miHelicoptero.vidas <= 0){
       temporizador.stop();
       cancion.stop();
       boton.setVisible(true);
       
       
       }
   }        
            
    lienzoGraphics.drawImage(buffer, 0,0, null);
   }
   
   
   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lienzo = new javax.swing.JPanel();
        boton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Lienzo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LienzoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LienzoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LienzoMousePressed(evt);
            }
        });

        boton.setText("REINICIAR");
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout LienzoLayout = new javax.swing.GroupLayout(Lienzo);
        Lienzo.setLayout(LienzoLayout);
        LienzoLayout.setHorizontalGroup(
            LienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(boton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(255, Short.MAX_VALUE))
        );
        LienzoLayout.setVerticalGroup(
            LienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LienzoLayout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(boton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LienzoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LienzoMousePressed
        miHelicoptero.subeHelicoptero();
    }//GEN-LAST:event_LienzoMousePressed

    private void LienzoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LienzoMouseExited
        temporizador.stop();
    }//GEN-LAST:event_LienzoMouseExited

    private void botonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMousePressed
        miHelicoptero.setFrame(100, 100, 100, 20);  //recoloca el helicoptero
        miPared.restart(bufferGraphics); // recoloca las paredes
        miPoder.restart(bufferGraphics);
        temporizador.start(); // pone a contar otra vez el temporizador
        cancion.play();
        boton.setVisible(false);
    }//GEN-LAST:event_botonMousePressed

    private void LienzoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LienzoMouseEntered
        temporizador.restart();
        
    }//GEN-LAST:event_LienzoMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaHelicopter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaHelicopter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaHelicopter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaHelicopter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaHelicopter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Lienzo;
    private javax.swing.JButton boton;
    // End of variables declaration//GEN-END:variables
}
