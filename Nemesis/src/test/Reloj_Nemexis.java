/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Label;
import java.awt.Panel;

/**
 *
 * @author Vicky
 */
public class Reloj_Nemexis extends Panel implements Runnable{
    
     int tiempo;
       private Label etiqueta_tiempo;
       
       Thread t;

       // Constructor---------------------------
       Reloj_Nemexis()
       { tiempo=0;
         etiqueta_tiempo=new Label("Tiempo = "+tiempo);
         add(etiqueta_tiempo);      
  
         t=new Thread(this); 
         t.start();
       }

      // Start ---------------------------
      public void start() { }         

      //----------------------------------------
      // Procedimiento run()
      //  Se encarga la etiqueta del reloj
      public void run() 
      { 
        while(tiempo>=0)
        { 
         // Damos el hilo a los otros
         try { Thread.currentThread().sleep(1000); }
         catch (InterruptedException e) {}   
         tiempo++;
            getEtiqueta_tiempo().setText("Tiempo = "+tiempo);
        }      
      }

    /**
     * @return the etiqueta_tiempo
     */
    public Label getEtiqueta_tiempo() {
        return etiqueta_tiempo;
    }
}
