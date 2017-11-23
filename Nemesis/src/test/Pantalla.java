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
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Vicky
 */
public class Pantalla extends Panel{
    // Variables para hacer el doble buffering
       Dimension offDimension;
       Image offImage;
       Graphics offGraphics;

      // Variable que nos determinara el crecimiento del juego
       double krecer;

      // Constantes que determinan la region del mapa globaL que pintaremos
       private int ANCHO_REGION; 
       private int ALTO_REGION; 

       // ---------------------------------------------------------------------------------
       // Constructor 
       Pantalla(double krecer_par)
       {        
         // Establecemos el tamanyo del tablero
         krecer=krecer_par;

         // Establecemos el rango de visualizacion del personaje
         ANCHO_REGION = (int)(Nemexis.getANCHO_CAMPO()/20);   // = 400
         ALTO_REGION  = (int)(Nemexis.getALTO_CAMPO());       // = 200
             
         // Establecemos el tamanyo inicial
         setSize((int)(ANCHO_REGION*krecer), (int)(ALTO_REGION*krecer)); 
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

       // ---------------------------------------------------------------------------------
       // Procedimiento paint
       public void paint(Graphics g)    {               } // Fi paint
    
       // ---------------------------------------------------------------------------------
       // Procedimiento repaint
       public void repaint(Graphics g)  {  update(g);   } // Fi repaint


       // ---------------------------------------------------------------------------------
       //  Procedimiento obtener_Punto_Pintar
       //    Dado un punto calcularemos el punto de la pantalla donde tenemos que pintarlo
       Coordenadas obtener_Punto_Pintar(Coordenadas pos_par, Coordenadas referencia_par)
       { Coordenadas pos_salida=new Coordenadas(pos_par);
          
         pos_salida.x-=referencia_par.x;
         pos_salida.y-=referencia_par.y; 

         pos_salida.x+=(ANCHO_REGION/2);
         pos_salida.y+=(ALTO_REGION/2);

         return (pos_salida);
       }

          
       // ---------------------------------------------------------------------------------
       //  Procedimiento update
       //    Este procedimiento pintara la region donde se encuentra el personaje
       // y los elementos que se encuentre dentro de la region (rectangulos,personajes,malos,revistas)
       public void update(Graphics g) 
       { 
       try
        {        
         // Capturem la dimension
         captura_Dimension();

         // Limpiamos
         // offGraphics.setColor(Color.blue);
         // offGraphics.fillRect(0, 0, (2*ANCHO_REGION*krecer), (int)(1.25*ALTO_REGION*krecer));  
         offGraphics.drawImage(Nemexis.image_fondo, 0, 0,(int)(ANCHO_REGION*krecer), (int)(1.25*ALTO_REGION*krecer), this);

         // Dibujamos el marco
         offGraphics.setColor(Color.black);
         offGraphics.drawRect(0, 0, (int)(2*ANCHO_REGION*krecer), (int)(1.25*ALTO_REGION*krecer));  
   
         // Capturamos la posicion del centro del tablero
         Coordenadas pos_centro=new Coordenadas(Nemexis.tabla.posicion_centro);                               

         // Pintamos el conjunto de rectangulos
         int contador_rectangulos=1;
         Enumeration erect=test.Nemexis.tabla.lista_rectangulos.elements();         
         while (erect.hasMoreElements())
         { Vector svect_rect=(Vector)erect.nextElement();
           Coordenadas scord=(Coordenadas)svect_rect.elementAt(0);
 
           // Comprobamos si el rectangulo se encuentra dentro del AMBITO_ACTIVACION
           if (Math.abs(scord.x-pos_centro.x)<test.Nemexis.getAMBITO_ACTIVACION())
           {   
            // Pintamos el rectangulo
            Coordenadas ex1=obtener_Punto_Pintar((Coordenadas)svect_rect.elementAt(0),pos_centro);
            Coordenadas ex2=obtener_Punto_Pintar((Coordenadas)svect_rect.elementAt(1),pos_centro);
 
            // Establecemos el rectangulo de color verde
            int x1=(int)(ex1.x*krecer);
            int y1=(int)((ALTO_REGION+25-ex1.y)*krecer);
            int x2=(int)(Math.abs(ex1.x-ex2.x)*krecer);
            int y2=(int)(Math.abs(ex1.y-ex2.y)*krecer);

            offGraphics.setColor(Color.green);          
            // offGraphics.fillRect(x1,y1,x2,y2);
            offGraphics.drawImage(Nemexis.imagen_ladrillos,x1,y1,x2,y2,this);
            offGraphics.setColor(Color.black);
            offGraphics.drawRect(x1,y1,x2,y2);
            offGraphics.drawString("Plataforma "+contador_rectangulos, x1+5,y1+10);
           } 

           // Si pasamos el limite, no comprobamos mas rectangulos y salimos del flujo
           // if (scord.x-pos_centro.x>AMBITO_ACTIVACION) break;
           
           // Incrementamos el numero de rectangulos
           contador_rectangulos++;
          } // Fi while


        // Pintamos los jugadores 
        Enumeration ejug= test.Nemexis.lista_jugadores.keys();
        while (ejug.hasMoreElements()) 
        { String snom=(String)ejug.nextElement();
          test.Nemexis.Jugador sjug=(test.Nemexis.Jugador)test.Nemexis.lista_jugadores.get(snom);

          // Obtenemos el punto en la pantalla para el personaje
          Coordenadas pos_jug_pintar=obtener_Punto_Pintar(sjug.posicion,pos_centro);
          // Pintamos el personaje y su nombre
          offGraphics.drawImage(sjug.determina_Imagen_Jugador(), (int)((pos_jug_pintar.x-15)*krecer), (int)((ALTO_REGION-pos_jug_pintar.y+5)*krecer), this);
          offGraphics.drawString(sjug.nombre, (int)((pos_jug_pintar.x-5)*krecer), (int)((ALTO_REGION-pos_jug_pintar.y-5)*krecer));

          // Pintamos las balas
          Enumeration ebal=sjug.gestor_balas.lista_balas.elements();
          while (ebal.hasMoreElements())
          { Coordenadas scordbala=(Coordenadas)ebal.nextElement();
 
            // Obtenemos el punto en la pantalla para el personaje
            Coordenadas pos_bal_pintar=obtener_Punto_Pintar(scordbala,pos_centro);
            
            // Establecemos las balas de color amarillo
            offGraphics.setColor(Color.yellow);
            offGraphics.fillRect((int)(pos_bal_pintar.x*krecer), (int)((ALTO_REGION-pos_bal_pintar.y)*krecer)+50, (int)(Nemexis.Gestor_Balas.ANCHO_BALA*krecer), (int)(Nemexis.Gestor_Balas.ALTO_BALA*krecer));
            offGraphics.setColor(Color.black);
            offGraphics.drawRect((int)(pos_bal_pintar.x*krecer), (int)((ALTO_REGION-pos_bal_pintar.y)*krecer)+50, (int)(Nemexis.Gestor_Balas.ANCHO_BALA*krecer), (int)(Nemexis.Gestor_Balas.ALTO_BALA*krecer));            

          } // Fi while balas

        } // Fi while jugadores


        // Pintamos los enemigos
        Enumeration e=test.Nemexis.gestor_enemigos.lista_enemigos.elements();
        while (e.hasMoreElements())
        { test.Nemexis.Enemigo sene=(test.Nemexis.Enemigo)e.nextElement();
          
          // Obtenemos el punto en la pantalla para el enemigo
          Coordenadas pos_ene_pintar=obtener_Punto_Pintar(sene.posicion,pos_centro);

          // Pintamos el personaje y su nombre
          offGraphics.drawImage(sene.determina_Imagen_Enemigo(), (int)((pos_ene_pintar.x+10)*krecer), (int)((ALTO_REGION-pos_ene_pintar.y+15)*krecer), this);
 
         } // Fi while enemigos

       } catch (Exception egg) {};

       // Escribimos el buffer en pantalla
       g.drawImage(offImage, 0, 0, this);
       paint(g);
     }
}
