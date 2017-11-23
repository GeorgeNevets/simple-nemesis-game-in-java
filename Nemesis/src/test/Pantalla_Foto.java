/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

/**
 *
 * @author Vicky
 */
public class Pantalla_Foto extends Panel implements Runnable {
    Image imatge_final;          
     String mensaje_informativo="";
     int iteraciones=10;

     // Variables para hacer el doble buffering
     Dimension offDimension;
     Image offImage;
     Graphics offGraphics;

     Thread hilo_foto;

     // Constructor---------------------------------
     Pantalla_Foto(Image imag_par,String mensaje_par)
     { imatge_final=imag_par;
       mensaje_informativo=new String(mensaje_par);

       hilo_foto=new Thread(this);
       hilo_foto.start();
     }

     //--------------------------------------------
     // Procedimiento start()
     public void start() {}
 
     //--------------------------------------------
     // Procedimiento run()
     public void run()
     {
      iteraciones=40;

      while (iteraciones>0) 
      {
        repaint();
        try { hilo_foto.sleep(200); } catch (InterruptedException e) {};
        iteraciones--;
      }
     }


     //-----------------------------------------------------------
     // Procedimiento captura_Dimension
     //  Procedimiento que capturara la dimension para realizar el doble buffering
     void captura_Dimension()
     {try{
       Dimension d = getSize();
     
       // Calculamos las dimensiones de la pantalla pintada
       int ancho_pantalla=d.width;
       int alto_pantalla=d.height;

       // Si no estan instanciadas las variables de dimension, imagen y graficos
       if ((offGraphics == null) || (ancho_pantalla!=offDimension.width) || (alto_pantalla!=offDimension.height))
       { 
         // Capturamos la dimension
         offDimension=new Dimension(ancho_pantalla,alto_pantalla);     

         // Creamos una imagen
         offImage=createImage(ancho_pantalla,alto_pantalla);
 
         // Asociamos la imagen a los graficos
         offGraphics=offImage.getGraphics();
        } 
       } catch (Exception ed) { System.out.println("Dimension error"); }
      }

      // Pintamos el estado-------------------
      public void repaint(Graphics g) 
      {  update(g);
         paint(g);
       }


      // Pintamos la foto final-------------------
      public void update(Graphics g) 
      {  
        // Capturem la dimension
        captura_Dimension();

         // Mostramos el mensaje por la pantalla
         if (iteraciones>0)
         {  offGraphics.setColor(Color.yellow);
            offGraphics.fillRect(0,0,200,25);
            offGraphics.setColor(Color.black);
            offGraphics.drawString(mensaje_informativo,0,12);
         }

        // Escribimos el buffer en pantalla
        g.drawImage(offImage,10,10,this); 
        offImage.flush();     
       }
  
}
