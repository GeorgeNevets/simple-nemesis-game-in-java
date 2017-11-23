package test;

// Fichero Nemexis.java
import java.applet.*;
import java.awt.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.util.Calendar;
import java.applet.Applet;
import java.lang.InterruptedException;
import java.awt.event.*;
import java.awt.image.*;

//****************************************************************************************
//****************************************************************************************
//****************************************************************************************
//****************************************************************************************
//  Clase Nemexis
//   Juego de naves, scroll horizontal, enemigos especiales, y con enemigo final (espero).
// Todo un insulto al original de MSX.
//****************************************************************************************
//****************************************************************************************
//****************************************************************************************
public class Nemexis extends Applet implements KeyListener {

    /**
     * @return the ANCHO_CAMPO
     */
    public static int getANCHO_CAMPO() {
        return ANCHO_CAMPO;
    }

    /**
     * @return the ALTO_CAMPO
     */
    public static int getALTO_CAMPO() {
        return ALTO_CAMPO;
    }

    /**
     * @return the AMBITO_ACTIVACION
     */
    public static int getAMBITO_ACTIVACION() {
        return AMBITO_ACTIVACION;
    }

    /**
     * @return the DISTANCIA_CAPTURA
     */
    public static int getDISTANCIA_CAPTURA() {
        return DISTANCIA_CAPTURA;
    }

    /**
     * @return the IZQUIERDA
     */
    public static int getIZQUIERDA() {
        return IZQUIERDA;
    }

    /**
     * @return the DERECHA
     */
    public static int getDERECHA() {
        return DERECHA;
    }

    /**
     * @return the ARRIBA
     */
    public static int getARRIBA() {
        return ARRIBA;
    }

    /**
     * @return the ABAJO
     */
    public static int getABAJO() {
        return ABAJO;
    }

    /**
     * @return the ARRIBA_IZQUIERDA
     */
    public static int getARRIBA_IZQUIERDA() {
        return ARRIBA_IZQUIERDA;
    }

    /**
     * @return the ABAJO_IZQUIERDA
     */
    public static int getABAJO_IZQUIERDA() {
        return ABAJO_IZQUIERDA;
    }

    /**
     * @return the ARRIBA_DERECHA
     */
    public static int getARRIBA_DERECHA() {
        return ARRIBA_DERECHA;
    }

    /**
     * @return the ABAJO_DERECHA
     */
    public static int getABAJO_DERECHA() {
        return ABAJO_DERECHA;
    }

    /**
     * @return the NINGUNA
     */
    public static int getNINGUNA() {
        return NINGUNA;
    }

    /**
     * @return the TECLA_ARRIBA
     */
    public static int getTECLA_ARRIBA() {
        return TECLA_ARRIBA;
    }

    /**
     * @return the TECLA_ABAJO
     */
    public static int getTECLA_ABAJO() {
        return TECLA_ABAJO;
    }

    /**
     * @return the TECLA_RIGHT
     */
    public static int getTECLA_RIGHT() {
        return TECLA_RIGHT;
    }

    /**
     * @return the TECLA_LEFT
     */
    public static int getTECLA_LEFT() {
        return TECLA_LEFT;
    }

    /**
     * @return the TECLA_ESPACIO
     */
    public static int getTECLA_ESPACIO() {
        return TECLA_ESPACIO;
    }
    
  String nombre_jugador_applet;                   // Es el nombre del jugador
  static Tablero tabla=null;                             // Representa la tabla del juego
  Jugador protagonista=null;                      // Representa al protagonista del juego
  Pantalla pantalla=null;                         // Representa la pantalla del juego    
  Reloj_Nemexis reloj_nemexis;               // Representa el reloj del juego
  Label label_Puntuacion=null;                    // Representa la puntuacion del personaje
  Label label_Vidas=null;                         // Esta etiqueta muestra las vidas restantes del personaje  
  boolean es_partida_finalizada=false;            // Nos informa de si la partida ha finalizado
  String nombre_Ganador_Partida="";               // Nos informa de quien ha finalizado la partida

  static Gestor_Enemigos gestor_enemigos=null;           // Representa al gestor de enemigos del juego

  // Lista de jugadores de la partida
  static Hashtable lista_jugadores=new Hashtable();

  // Lista que contine las teclas pulsadas por el jugador
  static Hashtable teclas_pulsadas=new Hashtable();

  static Image imagen_nave=null;                    // Imagen del personaje (TEMPORAL)
  static Image imagen_explosion = null; 
  static Image imagen_nave_inmune = null;
  static Image imagen_monstruo=null;             // Imagenes de los malos
  static Image imagen_estrella=null;
  static Image imagen_jarjar=null;
  static Image imagen_pikachu=null;
  static Image imagen_prin=null;
  static Image imagen_pelusa=null;
  static Image imagen_xbox=null;
  static Image imagen_culo=null;
  static Image imagen_meneo=null;
  static Image imagen_bala=null;
  static Image imagen_monstruo_final=null;

  static Image imagen_ladrillos=null;                     // Imagen de un ladrillo  

  // Imagenes para ganadores y perdedores
  static Image image_ganador=null; 
  static Image image_perdedor=null; 
  static Image image_fondo=null;

  Random aleatorio_nemexis;                       // Numero utilizado para generacion de aleatorios

  // Constantes del tamanyo del campo del juego
  private static final int ANCHO_CAMPO = 8000;
  private static final int ALTO_CAMPO  = 200;    

  // Constantes del programa
  private static final int AMBITO_ACTIVACION = 1200;  // Define el ambito de activacion del personaje protagonista
  private static final int DISTANCIA_CAPTURA = 20;    // Define la distancia con la cual colisionamos con los elementos  
 
  // Constantes de direccion del personaje
  private static final int IZQUIERDA         = 0;
  private static final int DERECHA           = 1;
  private static final int ARRIBA            = 2;
  private static final int ABAJO             = 3;
  private static final int ARRIBA_IZQUIERDA  = 4;
  private static final int ABAJO_IZQUIERDA   = 5;
  private static final int ARRIBA_DERECHA    = 6;
  private static final int ABAJO_DERECHA     = 7;
  private static final int NINGUNA           = 8;

  // Constantes del teclado
  private static final int TECLA_ARRIBA    = 38;
  private static final int TECLA_ABAJO     = 40;
  private static final int TECLA_RIGHT     = 37;
  private static final int TECLA_LEFT      = 39;

  private static final int TECLA_ESPACIO   = 32;
  //****************************************************************************
  //****************************************************************************
  // Clase Coordenadas
  //****************************************************************************
  //****************************************************************************
  
    
// Fi clase Coordenadas
 //****************************************************************************
 





 //****************************************************************************
 //****************************************************************************
 // Clase Coordenadas_Double
 //****************************************************************************
 //****************************************************************************
 // Clase Coordenadas_Double
 
// Fi clase Coordenadas_Double
 //****************************************************************************
 

  //-----------------------------------------------------------------------------
  // Funcion reorientar_Angulo(double orientacion_par, double rang_inf, double rang_sup)
  //   Realizara el mapeo inverso entre los dos extremos
  double reorientar_Angulo(double orientacion_par, double rang_inf, double rang_sup)
  {
   return (-orientacion_par+rang_sup+rang_inf);
  }


  //---------------------------------------------------------------------------------------------
  //---------------------------------------------------------------------------------------------
  // Funcion reorienta_Angulo
  //   Reorientamos el angulo de lanzamiento
  //---------------------------------------------------------------------------------------------
  double reorienta_Angulo(double orientacion_lanzamiento) 
  {
    // Modificamos la orientacion
    if ((orientacion_lanzamiento>=0)&&(orientacion_lanzamiento<(Math.PI/2)))
    {  
      orientacion_lanzamiento=reorientar_Angulo(orientacion_lanzamiento, 0, Math.PI/2);
      orientacion_lanzamiento=((orientacion_lanzamiento)-Math.PI); 
     }
     else
    if ((orientacion_lanzamiento>=(Math.PI/2))&&(orientacion_lanzamiento<Math.PI))
    {     
       orientacion_lanzamiento=reorientar_Angulo(orientacion_lanzamiento, Math.PI/2, Math.PI);
       orientacion_lanzamiento=orientacion_lanzamiento;
     }
     else
     if ((orientacion_lanzamiento>=-Math.PI)&&(orientacion_lanzamiento<-(Math.PI/2)))
     {
       orientacion_lanzamiento=-(reorientar_Angulo(-orientacion_lanzamiento, Math.PI/2, Math.PI));
       orientacion_lanzamiento=(orientacion_lanzamiento)+Math.PI; 
     }
     else
     if ((orientacion_lanzamiento>=-(Math.PI/2))&&(orientacion_lanzamiento<0))
     {
      orientacion_lanzamiento=-reorientar_Angulo(-orientacion_lanzamiento, 0, Math.PI/2);     
      orientacion_lanzamiento=orientacion_lanzamiento;
     }
     return (orientacion_lanzamiento);
  }


  //---------------------------------------------------------------------------------------------
  //---------------------------------------------------------------------------------------------
  // Funcion obtener_Angulo_Lanzamiento
  //   Funcion que calculara el angulo efectivo entre la posicion inicial y la final
  //---------------------------------------------------------------------------------------------
  double obtener_Angulo_Lanzamiento(Coordenadas_Double pos_ini_par, Coordenadas_Double pos_fin_par)
  {
     // Calculamos la nueva orientacion
     double orientacion_lanzamiento=Math.atan2((pos_fin_par.x-pos_ini_par.x),(pos_fin_par.y-pos_ini_par.y));

     // Reorientamos el angulo de lanzamiento
     orientacion_lanzamiento=reorienta_Angulo(orientacion_lanzamiento);

     return (orientacion_lanzamiento); 
   }









  
//***************************************************************************************
//***************************************************************************************
//***************************************************************************************
//***************************************************************************************
// Clase Pantalla_Foto
//  Panel en que mostrem la foto final
//***************************************************************************************
//***************************************************************************************
//***************************************************************************************

 // Fi Clase Pantalla_Foto
 //***************************************************************************************































//***************************************************************************************
//***************************************************************************************
//***************************************************************************************
//***************************************************************************************
//***************************************************************************************
// Clase Pantalla
//   Esta clase se encargara de pintar al protagonista, la region donde se encuentra y
// los elementos que se encuentran dentro de esa region.
//***************************************************************************************
//***************************************************************************************
//***************************************************************************************

  // Fi clase Pantalla
 //****************************************************************************

























  //****************************************************************************************
  //****************************************************************************************
  //****************************************************************************************
  //****************************************************************************************
  //****************************************************************************************
  // Clase Reloj_Nemexis
  //  Panel que se encargara de mostrar un reloj por pantalla y llevar el tiempo
  //****************************************************************************************
  //****************************************************************************************
  //****************************************************************************************
   

































 





 //*****************************************************************************************
 //*****************************************************************************************
 // Clase Tablero
 //   Esta clase sera el contenedor del mapeado del juego. Ofrecera :
 //      -Funciones para consultar las posiciones dentro de ese mapeado.
 //      -Se encargara de mover a una velocidad constante el centro de la pantalla.
 //      -(Monoplayer): Creara y lanzara las rafagas de enemigos almacenadas en checkpoints
 //****************************************************************************************
 //****************************************************************************************
 class Tablero implements Runnable {
   
   // Posicion del centro del juego
   Coordenadas posicion_centro;

   // Lista de rectangulos que representaran el suelo del juego
   Vector lista_rectangulos=new Vector();   // Lista de (content=Vector)

   // Lista de checkpoint desde donde se lanzaran las rafagas de enemigos
   Hashtable lista_checkpoints=new Hashtable();

   // Variable booleana que determina el flujo de vida del juego
   boolean salir_tablero=false;

   // Variable que determinara si hemos lanzado el enemigo final
   boolean enemigo_final_lanzado=false;
  
   public final static int paso=200;   // Es el tamanyo del paso en el eje X de la pantalla

   // Constantes que nos definen el tamanyo del tablero
   public int ANCHO_TABLERO;
   public int ALTO_TABLERO;

   // Constante que determina la velocidad de desplazamiento
   public final static int VELOCIDAD_DESPLAZAMIENTO_CENTRO = 50;
 
   // Constante que determina el desplazamiento del centro
   public final static int DISTANCIA_DESPLAZAMIENTO_CENTRO = 2;

   Thread hilo;  // Hilo de ejecucion

   //-------------------------------------------------------------------------
   // Constructor: Inicializara todos los elementos del juego
   //     A-Inicializamos las coordenadas del centro
   //     A-Construira la lista de rectangulos del mapeado
   //     B-Inicializara el conjunto de checkpoints de rafagas de enemigos
   //     C-Arrancara el proceso
   Tablero()
   {
    // Incializamos el ancho y alto del tablero
    ANCHO_TABLERO =(int)(getANCHO_CAMPO()/20);
    ALTO_TABLERO = (int)(getALTO_CAMPO());

    // Inicializamos la posicion inicial del juego
    posicion_centro=new Coordenadas((int)(ANCHO_TABLERO/2),(int)(ALTO_TABLERO/2));
    

    // Construimo el mapa de rectangulos 
    construir_Mapa_Rectangulos();

    // Incializamos la lista de checkpoints de las rafagas de enemigos
    incializar_Lista_CheckPoint();
    
    // Arrancamos el hilo de ejecucion
    hilo=new Thread(this);
    hilo.start();
   }


   //-------------------------------------------------------------------------
   // Funcion crear_Rectangulo
   //   Funcion que construira un vector que representara un rectangulo de plataforma
   Vector crear_Rectangulo(int x1, int y1, int x2, int y2)
   { Vector salida=new Vector();
     
     salida.addElement(new Coordenadas(x1, y1));  // Construimos el punto de inicio
     salida.addElement(new Coordenadas(x2, y2));  // Construimos el punto de fin
    
     return (salida); 
   }


   //-------------------------------------------------------------------------
   // Procedimiento construir_Mapa_Rectangulos()
   //   Construiremos el mapeado del juego a partir de la construccion de rectangulos
   // los cuales representaran las plataformas.
   void construir_Mapa_Rectangulos()
   {    
//    // Rect 1
    lista_rectangulos.addElement(crear_Rectangulo(4*paso,20,7*paso,0));
//    // Rect 2
    lista_rectangulos.addElement(crear_Rectangulo(5*paso,200,9*paso,180));
//
//    // Rect 3
   lista_rectangulos.addElement(crear_Rectangulo(7*paso,60,12*paso,0));
//
//    // Rect 4
   lista_rectangulos.addElement(crear_Rectangulo(9*paso,200,11*paso,180));
//    // Rect 4.1
    lista_rectangulos.addElement(crear_Rectangulo(11*paso,200,14*paso,180));
//    // Rect 4.2
    lista_rectangulos.addElement(crear_Rectangulo(14*paso,200,15*paso,180));
//
//    // Rect 5 
    lista_rectangulos.addElement(crear_Rectangulo(12*paso,20,17*paso,0));
//
//    // Rect 6
    lista_rectangulos.addElement(crear_Rectangulo(19*paso,120,23*paso,80));
//
//    // Rect 7.0
//    // lista_rectangulos.addElement(crear_Rectangulo(25*paso,200,28*paso,160));
//    // Rect 7.1
//    // lista_rectangulos.addElement(crear_Rectangulo(28*paso,200,31*paso,160));
//    // Rect 7.2
//    // lista_rectangulos.addElement(crear_Rectangulo(31*paso,200,35*paso,160));
//
//    // Rect 8.0
//    // lista_rectangulos.addElement(crear_Rectangulo(25*paso,40,28*paso,0));
//    // Rect 8.1
//    // lista_rectangulos.addElement(crear_Rectangulo(28*paso,40,31*paso,0));
//    // Rect 8.2
 //    // lista_rectangulos.addElement(crear_Rectangulo(31*paso,40,35*paso,0));
//
//    // Rect 9
   lista_rectangulos.addElement(crear_Rectangulo(26*paso,140,29*paso,120));
    // Rect 10
   lista_rectangulos.addElement(crear_Rectangulo(26*paso,80,29*paso,60));
    // Rect 11
   lista_rectangulos.addElement(crear_Rectangulo(30*paso,120,34*paso,80));

   }

   //-------------------------------------------------------------------------
   // Procedimiento incializar_Lista_CheckPoint()
   //   Inicializaremos la lista de rafagas de enemigos
   void incializar_Lista_CheckPoint()
   {
     lista_checkpoints.put(new Coordenadas(aleatorio(2*paso,(2*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio(2*paso,(2*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio(3*paso,(3*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio((int)(3.5*paso),(int)(3.5*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio(4*paso,(4*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio((int)(4.5*paso),(int)(4.5*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio(5*paso,(5*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio(6*paso,(6*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio(7*paso,(7*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(7*paso,(7*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(8*paso,(8*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(9*paso,(9*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio((int)(9.5*paso),(int)(9.5*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(10*paso,(10*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio((int)(10.5*paso),(int)(10.5*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(11*paso,(11*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(12*paso,(12*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(13*paso,(13*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(13*paso,(13*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(14*paso,(14*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(15*paso,(15*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(15*paso,(15*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(15*paso,(15*paso)+10),-1),new Integer(aleatorio(0,8)));




     lista_checkpoints.put(new Coordenadas(aleatorio(17*paso,(17*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio(18*paso,(18*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio(19*paso,(19*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio((int)(19.5*paso),(int)(19.5*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio(20*paso,(20*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio((int)(20.5*paso),(int)(20.5*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio(22*paso,(22*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio(23*paso,(23*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio((int)(23.5*paso),(int)(23.5*paso)+10),-1),new Integer(aleatorio(0,3)));

     lista_checkpoints.put(new Coordenadas(aleatorio(24*paso,(24*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio((int)(24.5*paso),(int)(24.5*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(26*paso,(26*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(28*paso,(28*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(29*paso,(29*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(30*paso,(30*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(30*paso,(30*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(31*paso,(31*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(31*paso,(31*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(31*paso,(31*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(32*paso,(32*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(34*paso,(34*paso)+10),-1),new Integer(aleatorio(0,8)));

     lista_checkpoints.put(new Coordenadas(aleatorio(34*paso,(34*paso)+10),-1),new Integer(aleatorio(0,8)));
   }


   //-------------------------------------------------------------------------
   // Funcion esta_Dentro
   //   Esta funcion determinara si la posicion se encuentra dentro del rectangulo 
   // especificado.
   boolean esta_Dentro(Coordenadas posicion_par, Coordenadas ex1, Coordenadas ex2)   
   {
     // Comprobamos en el eje X
     if ((ex1.x<=posicion_par.x)&&(ex2.x>=posicion_par.x))
     { // Comprobamos en el eje Y
       if ((ex1.y>=posicion_par.y)&&(ex2.y<=posicion_par.y))
         return (true);
     } 
    return (false);
   }

   //-------------------------------------------------------------------------
   // Funcion esta_Ocupado
   //  Esta funcion comprobara si la posicion esta libre o ocupada
   boolean esta_Ocupado(Coordenadas posicion_par)
   { // Comprobamos las frontera del tablero
     if (posicion_par.x<=50) return (true);

     // Comprobamos las frontera del tablero
     if (posicion_par.x>=getANCHO_CAMPO()-50) return (true);

     // Recorremos el mapa de rectangulos hasta encontrar los rectangulos mas cercanos
     Enumeration e=lista_rectangulos.elements();
     while (e.hasMoreElements())
     { Vector slisrect=(Vector)e.nextElement();
       Coordenadas ex1=(Coordenadas)slisrect.elementAt(0);
       
       // Comprobamos si el punto se encuentra dentro del ambito
       if (Math.abs(posicion_par.x-ex1.x)<getAMBITO_ACTIVACION())
       { 
          // Capturamos las coordenadas de fin del rectangulo
          Coordenadas ex2=(Coordenadas)slisrect.elementAt(1);
   
          // Comprobamos si el punto esta dentro del rectangulo
          if (esta_Dentro(posicion_par,ex1,ex2)) return (true); 
       }
     
       // Comprobamos el rectangulo esta alejado si estamos lejos y no comprobamos mas
       if ((ex1.x-posicion_par.x)>getAMBITO_ACTIVACION()) break;
     }
 
     return (false);
   }

   //-------------------------------------------------------------------------
   // Funcion capturar_Rafaga_Checkpoint
   //   Esta funcion delvolvera el tipo de rafaga de enemigos asociado al checkpoint mas
   // cercano a la posicion por parametro
   int capturar_Rafaga_Checkpoint(Coordenadas pos_par)
   { int rafaga_seleccionada=-1; 
     Coordenadas coordenadas_seleccionada=null;

     // Por todos los checkpoints
     Enumeration e=lista_checkpoints.keys();
     while (e.hasMoreElements())
     { Coordenadas scord=(Coordenadas)e.nextElement();

       // Comprobamos si estamos cerca
       if (Math.abs(scord.x-pos_par.x)<=DISTANCIA_DESPLAZAMIENTO_CENTRO*20)
       {  rafaga_seleccionada=((Integer)lista_checkpoints.get(scord)).intValue();
          lista_checkpoints.remove(scord);
          break; 
       }

     } // Fi while

     return (rafaga_seleccionada);

   } // Fi capturar_Rafaga_Checkpoint
        

   //-------------------------------------------------------------------------
   // Procedimiento lanzar_Rafaga_Enemigos
   //  Este procedimiento lanzara un conjunto de enemigos segun la seleccion
   void lanzar_Rafaga_Enemigos(int rafaga_par, Coordenadas pos_par)
   { Coordenadas planzar=new Coordenadas(pos_par.x+(int)(ANCHO_TABLERO/(1.5)),pos_par.y);

     // Segun la rafaga seleccionada
     switch (rafaga_par) {
       case 0: gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x,planzar.y+50),Enemigo.ESTRELLA);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+40,planzar.y+40),Enemigo.ESTRELLA);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+80,planzar.y+30),Enemigo.ESTRELLA);
               break;
       case 1: gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x,planzar.y-50),Enemigo.JARJAR);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+40,planzar.y-40),Enemigo.JARJAR);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+80,planzar.y-30),Enemigo.JARJAR);
               break;
       case 2: gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x,planzar.y),Enemigo.PIKACHU);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+40,planzar.y-50),Enemigo.PIKACHU);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+80,planzar.y+50),Enemigo.PIKACHU);
               break;
       case 3: gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x,planzar.y),Enemigo.PRIN);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+40,planzar.y+25),Enemigo.PRIN);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+80,planzar.y+50),Enemigo.PRIN);
               break;
       case 4: gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x,planzar.y),Enemigo.PELUSA);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+40,planzar.y-25),Enemigo.PELUSA);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+80,planzar.y+25),Enemigo.PELUSA);
               break;
       case 5: gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x,planzar.y),Enemigo.XBOX);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+40,planzar.y-50),Enemigo.XBOX);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+80,planzar.y+50),Enemigo.XBOX);
               break;
       case 6: gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x,planzar.y),Enemigo.CULO);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+40,planzar.y+50),Enemigo.CULO);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+80,planzar.y-50),Enemigo.CULO);
               break;
       case 7: gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x,planzar.y),Enemigo.MENEO);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+40,planzar.y-50),Enemigo.MENEO);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+80,planzar.y-25),Enemigo.MENEO);
               break;
       default:gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x,planzar.y-20),Enemigo.ESTRELLA);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+40,planzar.y),Enemigo.ESTRELLA);
               gestor_enemigos.lanzar_Enemigo(new Coordenadas(planzar.x+80,planzar.y+20),Enemigo.ESTRELLA);
               break;
     }
   } // Fi lanzar_Rafaga_Enemigos
     

   //-------------------------------------------------------------------------
   // Procedimiento run
   //   Ejecutara periodicamente el desplazamiento del centro de la tabla y
   // comprobara si para esa posicion ha de activar alguna rafaga de enemigos
   public void run() 
   { int rafaga_activada=-1;

     // Mientras el proceso este vivo
     while (salir_tablero==false) 
     { 
       // Dormimos el intervalo de movimiento
       try { hilo.sleep(VELOCIDAD_DESPLAZAMIENTO_CENTRO); } catch (Exception egt) {};

       // Comprobamos si llegamos a la posicion final de pantalla
       if (posicion_centro.x<=getANCHO_CAMPO()-500) 
       {
         // Desplazamos el centro sobre el eje X
         posicion_centro.x+=DISTANCIA_DESPLAZAMIENTO_CENTRO;

         // Comprobamos si activamos alguna rafaga de enemigos
         rafaga_activada=capturar_Rafaga_Checkpoint(posicion_centro);
         if (rafaga_activada!=-1)
         { System.out.println("Rafaga encontrada en ="+posicion_centro.getPaquete());
           lanzar_Rafaga_Enemigos(rafaga_activada,posicion_centro);
         }
       } // Fi if
       else // Si llegamos al enemigo final
       { 
          // Lanzamos el enemigo final
          if (!enemigo_final_lanzado)
          {
            enemigo_final_lanzado=true;
            gestor_enemigos.lanzar_Enemigo(new Coordenadas(posicion_centro.x+80,posicion_centro.y),Enemigo.MONSTRUO_FINAL);
          }

          // Lanzamos rafagas de enemigos
          if (aleatorio(0,100)<1)
             lanzar_Rafaga_Enemigos(aleatorio(0,5),posicion_centro);          
       }
     } // Fi while
   }
       


 }  // Fi clase Tablero
 //****************************************************************************


























 //****************************************************************************
 //****************************************************************************
 // Clase Enemigo
 //****************************************************************************
 //****************************************************************************
 class Enemigo  {
   Coordenadas posicion;        // Posicion del Enemigo
   int direccion;               // Direccion del Enemigo (IZQUIERDA, DERECHA)
   int tipo;                    // Nos indica el tipo del Enemigo
   int vidas;                   // Nos indica de cuantas vidas tiene el enemigo

   int sentido=1;               // Sentido vertical del desplazamiento
   
   double incremento_velocidad=0; // Incremento gradual de velocidad

   Coordenadas_Double posicion_bala; // Posicion del enemigo bala
   double angulo_bala=-1;            // Representa el angulo de desplazamiento de la bala

   // Constantes que representan el tipo de los malos
   public static final int ESTRELLA   = 0;
   public static final int JARJAR     = 1;
   public static final int PIKACHU    = 2;
   public static final int PRIN       = 3;
   public static final int PELUSA     = 4;
   public static final int XBOX       = 5;
   public static final int CULO       = 6;
   public static final int MENEO      = 7;

   public static final int BALA       = 10;
   public static final int MONSTRUO_FINAL = 12;

   // Constantes del personaje
   private static final int DESPLAZAMIENTO_MALO = 2;

   //-------------------------------------------------------------------------
   // Constructor
   //   Inicializamos el personaje enemigo, su posicion y su tipo 
   Enemigo(Coordenadas pos_par, int tipo_par) 
   { posicion=new Coordenadas(pos_par);
     direccion=getIZQUIERDA();
     tipo=tipo_par;    
    
     // Asignamos el numero de vidas segun el tipo
     switch (tipo) {
         case  ESTRELLA: vidas=3; break;
         case  JARJAR:   vidas=3; break;
         case  PIKACHU:  vidas=2; break;
         case  PRIN:     vidas=1; break;
         case  PELUSA:   vidas=1; break;
         case  XBOX:     vidas=1; break;
         case  CULO:     vidas=3; break;
         case  MENEO:    vidas=3; break;
         case  MONSTRUO_FINAL: vidas=120; break;
         default:  vidas=1; break;
     }

   }

   //-------------------------------------------------------------------------
   // Constructor
   //   Inicializamos el malo correspondiente a la bala
   Enemigo(Coordenadas pos_ini_par, Coordenadas pos_fin_par)
   { posicion=new Coordenadas(pos_ini_par);
     direccion=getIZQUIERDA();
     tipo=BALA;
     vidas=5;
     posicion_bala=new Coordenadas_Double(pos_fin_par.x,pos_fin_par.y);
          
     // Calculamos el angulo de desplazamiento de la bala
     angulo_bala=obtener_Angulo_Lanzamiento(new Coordenadas_Double(pos_ini_par.x,pos_ini_par.y), new Coordenadas_Double(pos_fin_par.x,pos_fin_par.y));
   }

   //-------------------------------------------------------------------------
   // Constructor
   //   Inicializamos el malo correspondiente a la bala
   Enemigo(Enemigo enemigo_par)
   { posicion=new Coordenadas(enemigo_par.posicion);
     direccion=enemigo_par.direccion;
     tipo=enemigo_par.tipo;
     vidas=enemigo_par.vidas;
     posicion_bala=new Coordenadas_Double(enemigo_par.posicion_bala.x,enemigo_par.posicion_bala.y);
          
     // Calculamos el angulo de desplazamiento de la bala
     angulo_bala=enemigo_par.angulo_bala;
   }


   //-------------------------------------------------------------------------
   // Procedimiento determina_Imagen_Enemigo()
   //   Devolvera la imagen del Enemigo que se debe pintar
   Image determina_Imagen_Enemigo()
   { 
     switch (tipo) {
         case  ESTRELLA: return (imagen_estrella);
         case  JARJAR:   return (imagen_jarjar);
         case  PIKACHU:  return (imagen_pikachu);
         case  PRIN:     return (imagen_prin);
         case  PELUSA:   return (imagen_pelusa);
         case  XBOX:     return (imagen_xbox);
         case  CULO:     return (imagen_culo);
         case  MENEO:    return (imagen_meneo);

         case  BALA:     return (imagen_bala);
         case  MONSTRUO_FINAL: return (imagen_monstruo_final);

         default:  return (imagen_monstruo); 
     }
   }

   //-------------------------------------------------------------------------
   // Procedimiento velocidad_Malo
   //   Procedimiento que determina la velocidad del malo segun su tipo
   int velocidad_Malo(int tipo_par)
   { switch (tipo_par) {
         case  ESTRELLA: return (50);
         case  JARJAR:   return (50);
         case  PIKACHU:  return (50);
         case  PRIN:     return (50);
         case  PELUSA:   return (50);
         case  XBOX:     return (50);
         case  CULO:     return (50);
         case  MENEO:    return (50);
         default:         return (60); 
     }
   }   

   //----------------------------------------------------------------------------- 
   // Funcio mover_Direccion
   //  Retornara la nueva posicion segun la direccion elegida
   Coordenadas mover_Direccion(Coordenadas posicion_par,int direccion_par)
   { 
     // Segun el tipo de monstruo
     switch (tipo) {
        case  ESTRELLA: return (mover_Monstruo1(posicion_par));
        case  JARJAR:   return (mover_Monstruo2(posicion_par));
        case  PIKACHU:  return (mover_Monstruo3(posicion_par));
        case  PRIN:     return (mover_Monstruo4(posicion_par));
        case  PELUSA:   return (mover_Monstruo5(posicion_par));
        case  XBOX:     return (mover_Monstruo6(posicion_par));
        case  CULO:     return (mover_Monstruo7(posicion_par));
        case  MENEO:    return (mover_Monstruo8(posicion_par));
        case  BALA:     return (mover_Monstruo_Bala(posicion_par));
        case  MONSTRUO_FINAL: return (mover_Monstruo_Final(posicion_par));
        default:  return(mover_Monstruo2(posicion_par)); 
     }
  }

   //----------------------------------------------------------------------------- 
   // Procedimiento mover_Monstruo1: Se desplazara en linea recta (ESTRELLA)
   Coordenadas mover_Monstruo1(Coordenadas posicion_par) 
   { Coordenadas coord_sort=new Coordenadas(posicion_par);

     // Se desplazara sobre la horizontal
     coord_sort.x=posicion_par.x-DESPLAZAMIENTO_MALO;

     return (coord_sort);
   }

   //----------------------------------------------------------------------------- 
   // Procedimiento mover_Monstruo2: (JARJAR)
   Coordenadas mover_Monstruo2(Coordenadas posicion_par) 
   { Coordenadas coord_sort=new Coordenadas(posicion_par);
 
     // Se desplazara sobre la horizontal
     coord_sort.x=posicion_par.x-DESPLAZAMIENTO_MALO;

     // Desplazamos sobre la vertical
     int nueva_y=posicion_par.y+(sentido*(DESPLAZAMIENTO_MALO));

     // Comprobamos margenes inferior
     if (nueva_y<0)
     {
        sentido=1;
        return (coord_sort); 
     }

     // Comprobamos margenes superior
     if (nueva_y>tabla.ALTO_TABLERO)
     {
       sentido=-1;
       return (coord_sort); 
     }

     // Avanzamos en las y
     coord_sort.y=nueva_y;

     return (coord_sort);
   }


   //----------------------------------------------------------------------------- 
   // Procedimiento mover_Monstruo3: Se desplazara en una sinusoidal (PIKACHU)
   Coordenadas mover_Monstruo3(Coordenadas posicion_par) 
   { Coordenadas coord_sort=new Coordenadas(posicion_par);
 
     // Se desplazara sobre la horizontal
     coord_sort.x=posicion_par.x-DESPLAZAMIENTO_MALO;

     // Desplazamos sobre la vertical
     int desplaza_y=(int)(16*Math.sin(posicion_par.x/10));

     // Desplazamos sinusoidalmente en las y
     coord_sort.y+=desplaza_y;

     return (coord_sort);
   }

   //----------------------------------------------------------------------------- 
   // Procedimiento mover_Monstruo4: (PRIN)
   Coordenadas mover_Monstruo4(Coordenadas posicion_par) 
   { Coordenadas coord_sort=new Coordenadas(posicion_par);

     // Se desplazara sobre la horizontal
     coord_sort.x=posicion_par.x-DESPLAZAMIENTO_MALO+(int)(DESPLAZAMIENTO_MALO*Math.sin(posicion_par.x/10));

     // Desplazamos sobre la vertical
     int nueva_y=posicion_par.y+(sentido*(2*DESPLAZAMIENTO_MALO));

     // Comprobamos margenes inferior
     if (nueva_y<0)
     {
        sentido=1;
        return (coord_sort); 
     }

     // Comprobamos margenes superior
     if (nueva_y>tabla.ALTO_TABLERO)
     {
       sentido=-1;
       return (coord_sort); 
     }

     // Avanzamos en las y
     coord_sort.y=nueva_y;

     return (coord_sort);
   }

   //----------------------------------------------------------------------------- 
   // Procedimiento mover_Monstruo5: (PELUSA)
   Coordenadas mover_Monstruo5(Coordenadas posicion_par) 
   { Coordenadas coord_sort=new Coordenadas(posicion_par);

     // Se desplazara sobre la horizontal
     coord_sort.x=posicion_par.x-DESPLAZAMIENTO_MALO+((int)(DESPLAZAMIENTO_MALO*Math.sin(posicion_par.x/10)));

     // Desplazamos sobre la vertical
     coord_sort.y=posicion_par.y+(int)(5*Math.sin(posicion_par.x/20));

     // Comprobamos margenes inferior
     if (coord_sort.y<0)
     {
        coord_sort.y=tabla.ALTO_TABLERO;
        return (coord_sort); 
     }

     // Comprobamos margenes superior
     if (coord_sort.y>tabla.ALTO_TABLERO)
     {
       coord_sort.y=0;
       return (coord_sort); 
     }

     return (coord_sort);
   }


   //----------------------------------------------------------------------------- 
   // Procedimiento mover_Monstruo6: (XBOX)
   Coordenadas mover_Monstruo6(Coordenadas posicion_par) 
   { Coordenadas coord_sort=new Coordenadas(posicion_par);

     // Incrementamos la velocidad con la variable "sentido"
     incremento_velocidad+=0.2;

     // Se desplazara sobre la horizontal
     coord_sort.x=posicion_par.x-DESPLAZAMIENTO_MALO-(int)incremento_velocidad;

     return (coord_sort);
   }

   //----------------------------------------------------------------------------- 
   // Procedimiento mover_Monstruo7: (CULO)
   Coordenadas mover_Monstruo7(Coordenadas posicion_par) 
   { Coordenadas coord_sort=new Coordenadas(posicion_par);

     // Se desplazara sobre la horizontal
     coord_sort.x=posicion_par.x-DESPLAZAMIENTO_MALO;

     return (coord_sort);
   }

   //----------------------------------------------------------------------------- 
   // Procedimiento mover_Monstruo8: (MENEO)
   Coordenadas mover_Monstruo8(Coordenadas posicion_par) 
   { Coordenadas coord_sort=new Coordenadas(posicion_par);

     // Se desplazara sobre la horizontal
     coord_sort.x=posicion_par.x-DESPLAZAMIENTO_MALO;

     return (coord_sort);
   }


   //----------------------------------------------------------------------------- 
   // Procedimiento mover_Monstruo_Bala
   Coordenadas mover_Monstruo_Bala(Coordenadas posicion_par) 
   { Coordenadas coord_sort=new Coordenadas(posicion_par);

     posicion_bala.x+=(DESPLAZAMIENTO_MALO+1.75)*Math.cos(angulo_bala);
     posicion_bala.y+=(DESPLAZAMIENTO_MALO+1.75)*Math.sin(angulo_bala);
    
     coord_sort.x=(int)posicion_bala.x;
     coord_sort.y=(int)posicion_bala.y;

     return (coord_sort);
   }


   //----------------------------------------------------------------------------- 
   // Procedimiento mover_Monstruo_Final
   Coordenadas mover_Monstruo_Final(Coordenadas posicion_par) 
   { Coordenadas coord_sort=new Coordenadas(posicion_par);

     // Desplazamos sobre la vertical
     int nueva_y=posicion_par.y+(sentido*(2*DESPLAZAMIENTO_MALO));

     // Comprobamos margenes inferior
     if (nueva_y<0)
     {
        sentido=1;
        return (coord_sort); 
     }

     // Comprobamos margenes superior
     if (nueva_y>tabla.ALTO_TABLERO)
     {
       sentido=-1;
       return (coord_sort); 
     }

     // Avanzamos en las y
     coord_sort.y=nueva_y;

     return (coord_sort);
   }


   //-------------------------------------------------------------------------
   // Procedimiento mover
   //   El personaje malo se movera (IZQUIERDA, DERECHA) y solo cambiara de direccion cuando
   // encuentre un precipicio
   void mover()
   {
     Coordenadas nueva_posicion=mover_Direccion(posicion,direccion);
     
     // Actualizamos la posicion del personaje
     posicion.copia(nueva_posicion);

   } // Fi void mover


 }  // Fi clase Enemigo
 //****************************************************************************


































 //*******************************************************************************************
 //*******************************************************************************************
 // Clase Gestor_Enemigos
 //   Esta clase gestionara una lista de enemigos. Cada enemigo ofrecera su funcion de 
 // desplazamiento para realizar su desplazamiento. Tambien se controlara cuando el 
 // enemigo salga de la pantalla.
 //*******************************************************************************************
 //*******************************************************************************************
 class Gestor_Enemigos implements Runnable {

    Vector lista_enemigos=new Vector();  // En esta lista se encuentran los enemigos activos
    Vector lista_introducir_enemigos=new Vector(); // Lista de enemigos que se introduciran en la siguiente generacion
    Vector lista_eliminar_enemigos=new Vector();   // Lista de enemigos que se eliminara en la siguiente generacion

    boolean salir_gestor_enemigos=false;   // Determina el flujo del gestor de enemigos

    // Constates de enemigo
    public static final int RADIO_ENEMIGO = 12;       // Definicion del tamanyo del enemigo
    public static final int VELOCIDAD_ENEMIGOS = 40;  // Definicion de la velocidad de los enemigos

    Thread hilo;  // Hilo de ejecucion

    //---------------------------------------------------------------------------------------
    // Constructor: Inicializaremos el gestor de enemigos
    Gestor_Enemigos()  
    {
     // Arrancamos el hilo de ejecucion
     hilo=new Thread(this);
     hilo.start();
    }

    //---------------------------------------------------------------------------------------
    // Procedimiento lanzar_Enemigos
    //  Introduciremos un nuevo tipo de enemigo
    void lanzar_Enemigo(Coordenadas pos_par, int tipo_par)
    {
      // Lo introducimos en la lista para introducir enemigos
      lista_introducir_enemigos.addElement(new Enemigo(pos_par,tipo_par));
    }

    //---------------------------------------------------------------------------------------
    // Procedimiento lanzar_Enemigos
    //  Introduciremos un nuevo tipo de enemigo BALA
    void lanzar_Enemigo(Coordenadas pos_bala_par, Coordenadas pos_prota_par)
    {
      // Lo introducimos en la lista para introducir enemigos
      lista_introducir_enemigos.addElement(new Enemigo(pos_bala_par,pos_prota_par));
    }


    //---------------------------------------------------------------------------------------
    // Procedimiento introducir_Enemigos
    //   Este procedimiento introducir los enemigos encontrados en la lista a introducir
    void introducir_Enemigos()
    {
     try 
     {
      // Recorremos la lista de eliminar
      Enumeration e=lista_introducir_enemigos.elements();
      while (e.hasMoreElements())
      { Enemigo snuevo_enemigo=(Enemigo)e.nextElement();

        // Introducimos el enemigo de la lista
        if (snuevo_enemigo.tipo!=Enemigo.BALA)
        {
         lista_enemigos.addElement(new Enemigo(snuevo_enemigo.posicion,snuevo_enemigo.tipo)); 
        }
        else 
        { 
         lista_enemigos.addElement(new Enemigo(snuevo_enemigo));  
        }
      }
     } catch (Exception est)  {};

     // Vaciamos la lista de los objetos a introducir
     lista_introducir_enemigos.removeAllElements();
    }

    //---------------------------------------------------------------------------------------
    // Procedimiento eliminar_Enemigos
    //   Este procedimiento eleiminara los enemigos encontrados en la lista a eliminar
    void eliminar_Enemigos()
    {
     try 
     {
      // Recorremos la lista de eliminar
      Enumeration e=lista_eliminar_enemigos.elements();
      while (e.hasMoreElements())
      { int ieli=((Integer)e.nextElement()).intValue();
         
        // Eliminamos el enemigo de la lista
        lista_enemigos.removeElementAt(ieli);
      }
     } catch (Exception est)  {};

     // Vaciamos la lista de los objetos a eliminar
     lista_eliminar_enemigos.removeAllElements();
    }


    //---------------------------------------------------------------------------------------
    // Procedimiento capturar_Enemigo
    //   Esta funcion capturara al enemigo mas cercano a la posicion por parametro y que 
    // sea inferior al tamanyo del enemigo
    int capturar_Enemigo(Coordenadas pos_par)
    { int contador_enemigo=0;

      // Controlamos la lista vacia
      if (lista_enemigos.size()==0) return (-1);

      // Recorremos la lista de enemigos
      Enumeration e=lista_enemigos.elements();
      while (e.hasMoreElements())
      { Enemigo sene=(Enemigo)e.nextElement();
         
        // Comprobamos si esta lo sificientemente cerca
        if (Math.abs(sene.posicion.x-pos_par.x)<RADIO_ENEMIGO)
          if (Math.abs(sene.posicion.y-pos_par.y)<RADIO_ENEMIGO)
          { 
            // Si no tiene mas vidas eliminamos el enemigo
            if (sene.vidas<=0)
            {            
              // Comprobamos si hemos eliminado al monstruo final
              try 
              { if (sene.tipo==Enemigo.MONSTRUO_FINAL)
                  mostrar_Foto_Final_Partida(true,"Enhorabuena you win; Puntos="+protagonista.puntos); 
               } catch (Exception egg) {};
             return (contador_enemigo);  
            }
            else 
            {
              sene.vidas--;
              return (-2); 
            }
          }
 
       // Incrementamos el indice del enemigo
       contador_enemigo++;
      }
   
      return (-1);
    } // Fi void capturar_Enemigo

   
    //---------------------------------------------------------------------------------------
    // Procedimiento mover_Enemigo
    //  Este procedimiento movera el i-esimo enemigo segun su funcion de desplazamiento
    // y comprobara si la posicion de este a salido de la pantalla para eliminarlo
    void mover_Enemigo(int indice_enemigo_par) 
    {
     // Capturamos el enemigo seleccionado
     Enemigo selene=(Enemigo)lista_enemigos.elementAt(indice_enemigo_par);
   
     // Ejecutamos la funcion de desplazamiento del enemigo
     selene.mover();

     // Comprobamos si se trata de del enemigo final para dispara contra el protagonista
     switch (selene.tipo){
          case Enemigo.MONSTRUO_FINAL:
           if (aleatorio(0,20)<1)
              lanzar_Enemigo(protagonista.posicion ,selene.posicion);
           break;
         case Enemigo.ESTRELLA:
          if (aleatorio(0,80)<1)
             lanzar_Enemigo(protagonista.posicion ,selene.posicion);
           break;
         case Enemigo.CULO:
          if (aleatorio(0,70)<1)
             lanzar_Enemigo(protagonista.posicion ,selene.posicion);
           break;
         case Enemigo.MENEO:
          if (aleatorio(0,70)<1)
             lanzar_Enemigo(protagonista.posicion ,selene.posicion);
           break;
     }
 
     // Comprobamos la posicion del enemigo para determinar si lo eliminamos
     int mitad_ancho=(int)(tabla.ANCHO_TABLERO/2);
     if (selene.posicion.x<tabla.posicion_centro.x-mitad_ancho)
       lista_eliminar_enemigos.addElement(new Integer(indice_enemigo_par));
    }


    //---------------------------------------------------------------------------------------
    // Procedimiento run
    //   Ejecutara periodicamente eliminar,mover la lista de enemigos
    public void run()
    {
      // Mientras el flujo de gestor de enemigos este vivo
      while (salir_gestor_enemigos==false)
      {
       try 
       {
          // Dormimos el intervalo
          try { hilo.sleep(VELOCIDAD_ENEMIGOS); } catch (InterruptedException est) {};

          // Introducimos los enemigos
          if (lista_introducir_enemigos.size()>0) introducir_Enemigos();

          // Eliminamos los enemigos
          if (lista_eliminar_enemigos.size()>0) eliminar_Enemigos();

          // Movemos los enemigos
          for (int i=0;i<lista_enemigos.size();i++)
            mover_Enemigo(i);

        } catch (Exception egg) {};
       }// Fi while

     } // Fi void run
     
 } // Fi clase Gestor_Enemigos
     
    
































































 //*******************************************************************************************
 //*******************************************************************************************
 // Clase Gestor_Balas
 //   Esta clase se encargara de gestionar/managejar el movimiento de las balas
 // Controlaremos: 
 //   - El m�ximo numero de balas permitidas
 //   - La distancia entre dos balas sea de un minimo
 //   - La desaparicion de las balas (colision con enemigo o pared, o salir del tablero)
 //*******************************************************************************************
 //*******************************************************************************************
 class Gestor_Balas implements Runnable {

    Vector lista_balas=new Vector();  // Array donde se guardaran las balas
    int numero_balas_vivas=0;         // Numero de balas vivas
    int posicion_x_minima_bala=getANCHO_CAMPO();     // Posicion x de la bala mas cercana (la mas recientemente creada)
    boolean salir_gestor_balas=false;    // Determina el flujo de vida del gestor de balas
 
    Vector lista_introducir_balas=new Vector();  // Lista de las balas que debemos introducir
    Vector lista_eliminar_balas=new Vector();    // Lista de las balas que debemos eliminar

    Jugador jugador_local=null;                  // Referencia al jugador

    // Constante que define el ancho de la bala
    public static final int ANCHO_BALA     = 5;
    public static final int ALTO_BALA      = 2;

    // Constante que define la distancia de desplazamiento de la bala
    public static final int DISTANCIA_DESPLAZAMIENTO_BALA = 2;

    // Constante que define la velocidad de desplazamiento de las balas
    public static final int VELOCIDAD_BALAS = 4;
 

    // Hilo de ejecucion
    Thread hilo;

    //------------------------------------------------------------------------------
    // Constructor: Inicializamos el gestor de las balas
    Gestor_Balas(Jugador jugador_par)
    {  numero_balas_vivas=0;
       posicion_x_minima_bala=getANCHO_CAMPO();
   
       // Referenciamos el jugador
       jugador_local=jugador_par;

       // Arrancamos el proceso
       hilo=new Thread(this);
       hilo.start();
    }

    //------------------------------------------------------------------------------
    // Procedimiento disparar_Bala
    //   Este procedimiento disparara una nueva bala si se cumplen las condiciones:
    //     -El numero de balas no ha llegado al maximo
    //     -La distancia con las otra balas a de ser superior a una constante
    void disparar_Bala(Coordenadas pos_par)
    {
      // Comprobamos el numero de balas
      if (numero_balas_vivas>=10) return;
     
      // Comprobamos que se cumpla la distancia minima
      if (pos_par.x+(4*ANCHO_BALA)>posicion_x_minima_bala) return;

      // Lanzamos una nueva bala en la lista de balas a introducir
      lista_introducir_balas.addElement(new Coordenadas(pos_par));
     }


    //------------------------------------------------------------------------------
    // Procedimiento introducir_Lista_Balas
    //   Insertamos la lista de balas de la lista transitoria a la lista final y vaciaremos
    // dicha lista
    void introducir_Lista_Balas()
    {
     try 
     {
      // Por todas las balas a introducir
      Enumeration e=lista_introducir_balas.elements();
      while (e.hasMoreElements())
      {  
        Coordenadas snuevabala=(Coordenadas)e.nextElement();
         
        // Insertamos en la lista de balas
        lista_balas.addElement(new Coordenadas(snuevabala));

        // Establecemos la nueva poscion x minima
        posicion_x_minima_bala=snuevabala.x;

        numero_balas_vivas++;
      }
     } catch (Exception est) {};
   
      // Eliminamos el contenido
      lista_introducir_balas.removeAllElements(); 
    }


    //------------------------------------------------------------------------------
    // Procedimiento eliminar_Lista_Balas
    //   Eliminamos de la lista de balas las balas seleccionadas
    void eliminar_Lista_Balas()
    {
     try 
     {
      // Por todas las balas a introducir
      Enumeration e=lista_eliminar_balas.elements();
      while (e.hasMoreElements())
      {  
        int sbalaeli=((Integer)e.nextElement()).intValue();
         
        // Eliminamos la bala situada en la posicion
        lista_balas.removeElementAt(sbalaeli);

        numero_balas_vivas--;
       }
      } catch (Exception est) {};

      // Eliminamos el contenido
      lista_eliminar_balas.removeAllElements(); 
    }

             
    //------------------------------------------------------------------------------
    // Procedimiento mover_Bala
    //   Este procedimiento se encargara de realizar el desplazamiento de la bala
    // considerando:
    //        -Salir del tablero (desaparece)
    //        -Colision con la pared (desaparece)
    //        -Colision con un enemigo (enemigo y la bala desparecen
    //  Devolvemos la nueva posicion x de la bala
    int mover_Bala(int indice_bala_par) 
    {
      // Capturamos la bala seleccionada
      Coordenadas sbala=(Coordenadas)lista_balas.elementAt(indice_bala_par);
        
      // Despalazamos la bala en el eje
      Coordenadas nueva_bala=new Coordenadas(sbala.x+DISTANCIA_DESPLAZAMIENTO_BALA,sbala.y);
         
      // Comprobamos si salimos del tablero
      int mitad_ancho=(int)(tabla.ANCHO_TABLERO/2);
      if (nueva_bala.x>tabla.posicion_centro.x+mitad_ancho)
      {
       lista_eliminar_balas.addElement(new Integer(indice_bala_par)); // Eliminamos la bala
       return ( getANCHO_CAMPO());
      }
  
     // Comprobamos si nos chocamos con alguna pared, entonces ....
     if (tabla.esta_Ocupado(nueva_bala))
     {
      lista_eliminar_balas.addElement(new Integer(indice_bala_par)); // Eliminamos la bala
      return (  getANCHO_CAMPO());
     }
 
     // Comprobamos si chocamos con algun enemigo, entonces ....
     int enemigo_interseccion=gestor_enemigos.capturar_Enemigo(nueva_bala);
     if (enemigo_interseccion!=-1)
     {
      lista_eliminar_balas.addElement(new Integer(indice_bala_par)); // Eliminamos la bala
   
      // Eliminamos al enemigo si no le quedan mas vidas
      if (enemigo_interseccion!=-2)
      {
        gestor_enemigos.lista_eliminar_enemigos.addElement(new Integer(enemigo_interseccion));
        jugador_local.puntos++;
        
        // Si el jugador es protagonista refrescamos el marcador
        if (jugador_local.es_protagonista)
        { 
         label_Puntuacion.setText("Puntos="+jugador_local.puntos);
         label_Puntuacion.repaint();
        }
      }

      return (  getANCHO_CAMPO());
     }
      
     // Si todo es correcto entonces completamos el movimiento
     sbala.copia(nueva_bala);       

     return (sbala.x);

   } // Fi int mover_Bala
 

   //------------------------------------------------------------------------------
   // Procedimiento run
   //   Este procedimiento ejecutara:
   //    - Eliminacion de las balas
   //    - Insercion de las nuevas balas
   //    - Movimiento de las nuevas balas 
   public void run()
   {
    // Mientras el proceso siga vivo
    while (salir_gestor_balas==false) 
    {
     try 
     {
        // Dormimos el intervalo del disparo
        try { hilo.sleep(VELOCIDAD_BALAS);  } catch (InterruptedException est) {};

        // Eliminamos balas
        if (lista_eliminar_balas.size()>0) eliminar_Lista_Balas();

        // Introducimos balas
        if (lista_introducir_balas.size()>0) introducir_Lista_Balas();
 
        // Desplazamos la balas
        int minimo_x_tmp=getANCHO_CAMPO();
        for (int i=0;i<lista_balas.size();i++)
        { // Movemos la bala y obtenemos su x
          int tmp_x_bal=mover_Bala(i);
          if (tmp_x_bal<minimo_x_tmp) minimo_x_tmp=tmp_x_bal; 
        }
        // Establecemos el nuevo minimo
        posicion_x_minima_bala=minimo_x_tmp;    
      } 
      catch (Exception egg) {};

    } // Fi while

   } // Fi void run



} // Fi Gestor_Balas
































 //****************************************************************************
 //****************************************************************************
 // Clase Jugador
 //   Esta clase representara a un jugador del juego. Su funcion principal es 
 // representar la nave. La nave se podra desplazarse por el mapeado (con ciertos limites
 // respecto a la posicion central) y disparar (o no) balas.
 //****************************************************************************
 //****************************************************************************
 class Jugador implements Runnable {
   String nombre;               // Nombre del personaje
   int estado;                  // Estado del personaje (NORMAL, EXPLOSION, INMUNE)
   int estado_disparo;          // Indica si el jugador dispara o no (MODO_PAZ,MODO_DISPARO)
   int direccion;               // Direccion de desplazamiento del personaje (8 direcciones + NINGUNA=posicion_centro+CTE)
   Coordenadas posicion;        // Posicion del personaje
   int puntos;                  // Puntos del personajes
   int vidas;                   // Vidas del personaje
   boolean es_protagonista;     // Variable que informara si el personaje es el protagonista
   int unidades_explosion=0;    // Determina las unidades que estara explotando
   int unidades_inmune=0;       // Determina las unidades que estara inmune

   double DESPLAZAMIENTO_NINGUNO=-1;  // Desplazamiento en direccion NINGUNA

   Gestor_Balas gestor_balas;   // Es es gestor de disparos del jugador

   boolean salir_jugador=false; // Control de ciclo del personaje

   Thread hilo;                 // Hilo de ejecucion del personaje

   // Constantes de estado del jugador
   public static final int NORMAL    = 0;
   public static final int EXPLOSION = 1;
   public static final int INMUNE    = 2;

   // Constantes de estado del disparo
   public static final int MODO_PAZ     = 0;
   public static final int MODO_DISPARO = 1;

   // Constantes del jugador
   public static final int DISTANCIA_DESPLAZAMIENTO_JUGADOR   = 5;
   public static final int VELOCIDAD_JUGADOR                  = 30;

   //-------------------------------------------------------------------------
   // Constructor: Inicializamos los miembros del jugador
   Jugador(String nombre_par, boolean es_protagonista_par, Coordenadas posicion_par) 
   { nombre=new String(nombre_par);
     posicion=new Coordenadas(posicion_par);
     estado=NORMAL;
     estado_disparo=MODO_PAZ;
     direccion=getNINGUNA();
     es_protagonista=es_protagonista_par;
     unidades_explosion=0;
     unidades_inmune=0;
     puntos=0;
     vidas=7;

     // Creamos el gestor de balas
     gestor_balas=new Gestor_Balas(this);

     // Establecemos el desplazamiento ninguno
     DESPLAZAMIENTO_NINGUNO=(double)((double)(Tablero.DISTANCIA_DESPLAZAMIENTO_CENTRO)*((double)VELOCIDAD_JUGADOR/(double)Tablero.VELOCIDAD_DESPLAZAMIENTO_CENTRO));
     System.out.println("Desplazamiento NINGUNO="+DESPLAZAMIENTO_NINGUNO);

     // Arrancamos el hilo de ejecucion
     hilo=new Thread(this);
     hilo.start();
   }


   //-------------------------------------------------------------------------
   // Procedimiento determina_Imagen_Jugador()
   //   Devolvera la imagen del Jugador que se debe pintar
   Image determina_Imagen_Jugador()
   {
     // Determinamos si corremos o saltamos
     switch (estado) 
     { 
       case NORMAL:    return (imagen_nave);
       case EXPLOSION: return (imagen_explosion);
       case INMUNE:    return (imagen_nave_inmune);
     }
     return (null);
   } // Fi determina_Imagen_Jugador


   //-------------------------------------------------------------------------
   // Procedimiento actualizar_Personaje(String buf)
   //  Actualizamos los datos del personaje
   void actualizar_Personaje(String buf)
   {  // Comprobamos que no se trate del protagonista
      if (es_protagonista) return;
   }

   //-------------------------------------------------------------------------
   // Procedimiento cambiar_Direccion
   //  Determinara si existe un cambio de direccion para comunicarlo al resto de los jugadores
   void cambiar_Direccion(int direccion_par)
   {  
     // Comprobamos si hemos cambiado de direccion
     if (direccion_par!=direccion)
     {  
       direccion=direccion_par;   // Actualizamos la direccion        
     } 
    }


   //-------------------------------------------------------------------------
   // Procedimiento cambiar_Disparo
   //  Determinara si existe un cambio en el modo de disparo para comunicarlo al restor de los jugadores
   void cambiar_Disparo(int estado_disparo_par)
   {  
     // Comprobamos si hemos cambiado de estado del disparo
     if (estado_disparo!=estado_disparo_par)
     {  
       estado_disparo=estado_disparo_par;   // Actualizamos el estado del disparo
     }
   }


   //----------------------------------------------------------------------------- 
   // Funcio mover_Direccion
   //  Retornara la nueva posicion segun la direccion elegida
   Coordenadas mover_Direccion(Coordenadas posicion_par,int direccion_par, int desplazamiento_par)
   { Coordenadas coord_sort=new Coordenadas(posicion_par);
       
     // Segun la direccion elegida
     switch (direccion_par) { 
         case ABAJO:     coord_sort.y=posicion_par.y-desplazamiento_par; 
                         coord_sort.x=posicion_par.x+(int)(Math.rint(DESPLAZAMIENTO_NINGUNO)+1); 
                         break;
         case ARRIBA:    coord_sort.y=posicion_par.y+desplazamiento_par; 
                         coord_sort.x=posicion_par.x+(int)(Math.rint(DESPLAZAMIENTO_NINGUNO)+1); 
                         break;
         case IZQUIERDA: coord_sort.x=posicion_par.x-desplazamiento_par+(int)(Math.rint(DESPLAZAMIENTO_NINGUNO)+1); 
                         break;
         case DERECHA:   coord_sort.x=posicion_par.x+desplazamiento_par+(int)(Math.rint(DESPLAZAMIENTO_NINGUNO)+1);
                         break;
         case ABAJO_IZQUIERDA:
                         coord_sort.y=posicion_par.y-desplazamiento_par; 
                         coord_sort.x=posicion_par.x-desplazamiento_par+(int)(Math.rint(DESPLAZAMIENTO_NINGUNO)+1);
                         break;
         case ABAJO_DERECHA:
                         coord_sort.y=posicion_par.y-desplazamiento_par; 
                         coord_sort.x=posicion_par.x+desplazamiento_par+(int)(Math.rint(DESPLAZAMIENTO_NINGUNO)+1);
                         break;
         case ARRIBA_IZQUIERDA:
                         coord_sort.y=posicion_par.y+desplazamiento_par; 
                         coord_sort.x=posicion_par.x-desplazamiento_par+(int)(Math.rint(DESPLAZAMIENTO_NINGUNO)+1);
                         break;
         case ARRIBA_DERECHA:
                         coord_sort.y=posicion_par.y+desplazamiento_par;
                         coord_sort.x=posicion_par.x+desplazamiento_par+(int)(Math.rint(DESPLAZAMIENTO_NINGUNO)+1);
                         break;

         case NINGUNA:   coord_sort.x=posicion_par.x+(int)(Math.rint(DESPLAZAMIENTO_NINGUNO)+1); 
                         break;
      }
     return (coord_sort);
   }



   //-------------------------------------------------------------------------
   // Procedimiento mover()
   //  Ejecutara un movimiento del jugador(si es posible) y calculara las consecuencias
   public void mover()
   { Coordenadas nueva_posicion=null;
  
     // Comprobamos si hemos llegado al final de la pantalla
     if (tabla.enemigo_final_lanzado) DESPLAZAMIENTO_NINGUNO=-1;

     // Nos desplazamos segun la direccion
     nueva_posicion=mover_Direccion(posicion,direccion,DISTANCIA_DESPLAZAMIENTO_JUGADOR);

     // Comprobamos que la frontera horizontal inferior
     int mitad_ancho=(int)(tabla.ANCHO_TABLERO/2);
     if (nueva_posicion.x<tabla.posicion_centro.x-mitad_ancho)
     {
       posicion.x=tabla.posicion_centro.x-mitad_ancho;
       return; 
     }

     // Comprobamos que la frontera horizontal superior
     if (nueva_posicion.x>tabla.posicion_centro.x+mitad_ancho)
        return;
  
     // Comprobamos los margenes verticales
     if ((nueva_posicion.y<5)||(nueva_posicion.y>(tabla.ALTO_TABLERO-5)))
        return;
     
     // Comprobamos si nos chocamos con alguna pared, entonces ....
     if ((estado==NORMAL)&&(tabla.esta_Ocupado(nueva_posicion)))
     { // ... explotamos
       estado=EXPLOSION;
       unidades_explosion=50;
       vidas--;

       // Si el jugador es protagonista refrescamos las vidas
       if (es_protagonista)
       { 
        label_Vidas.setText("Vidas="+vidas);
        label_Vidas.repaint();
       }

       // Comprobamos si hemos consumido todas las vidas
       if (vidas<=0)
          mostrar_Foto_Final_Partida(false,"Lo siento... LOSER!!");

       return;
     }
 
     // Comprobamos si chocamos con algun enemigo, entonces ....
     int enemigo_interseccion=gestor_enemigos.capturar_Enemigo(nueva_posicion);
     if ((estado==NORMAL)&&(enemigo_interseccion!=-1))
     {  // ... volvemos a explotar
        estado=EXPLOSION;
        unidades_explosion=50;
        vidas--;

        // Si el jugador es protagonista refrescamos las vidas
        if (es_protagonista)
        { 
         label_Vidas.setText("Vidas="+vidas);
         label_Vidas.repaint();
        }

        // Comprobamos si hemos consumido todas las vidas
        if (vidas<=0)
           mostrar_Foto_Final_Partida(false,"Lo siento... LOSER!!");

        return;
     }
      
     // Si todo es correcto entonces completamos el movimiento
     posicion.copia(nueva_posicion);       

   } // Fi void mover()


   //-------------------------------------------------------------------------
   // Procedimiento run
   //   Este procedimiento ejecutara segun la velocidad del jugador el movimiento
   // correspondiente, solo si esta activo
   public void run() 
   {
    // Ejecutaremos ciclicamente el movimiento si el personaje esta activo
    while (salir_jugador==false) 
    {  
     try 
     {
      // Dormimos para establecer la velocidad del personaje
       try { hilo.sleep(VELOCIDAD_JUGADOR); } catch (InterruptedException e) {};

       // Miramos si estamos disparando
       if (estado_disparo==MODO_DISPARO) gestor_balas.disparar_Bala(posicion);
       
       // Segun el estado del jugador
       switch (estado) {
          case NORMAL:    break;
          case EXPLOSION: if (unidades_explosion<0) 
                          { unidades_inmune=100;
                            estado=INMUNE; 
                          }
                          else
                          {
                            unidades_explosion--; 
                          }
                          break;
          case INMUNE: if (unidades_inmune<0)
                           estado=NORMAL;
                       else
                       {
                          unidades_inmune--;
                         
                       }
                       break; 
         } // Fi switch 

       // Ejecutamos el desplazamiento
       mover();          

       // Si esta activado realizamos el movimiento
       if (es_protagonista)
       { 
         pantalla.repaint();
         repaint();
         requestFocus();
       }
     } catch (Exception egg) { egg.printStackTrace(); };
    } // Fi while 
   } // Fi void run()


 } // Fi clase Jugador
 //****************************************************************************






 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************
 //*****************************************************************************************

 


  //-------------------------------------------------------------------------
  // Procedimiento inicializar_Grupo_Personajes(String lista_nombres_par)
  //   Creamos la lista de los otros personajes humnanos con los que competiremos
  void inicializar_Grupo_Jugadores(String lista_nombres_par)
  { String buf=new String(lista_nombres_par);
    while (!buf.equals(""))
    {  String snom=buf.substring(buf.indexOf(":iNJug:")+7,buf.indexOf(":fNJug:"));
       // if (!snom.equals(protagonista.nombre))
       //    lista_personajes.put(new String(snom),new Personaje(snom,false,new Coordenadas(100,101)));
       buf=buf.substring(buf.indexOf(":fNJug:")+7,buf.length()); 
    }
  }


  //-----------------------------------------------------------------------------------------
  // Funcion aleatorio(int rini,int rfin)
  //  Esta funcion generara aleatoriamente un numero entre el rango seleccionado de int
  int aleatorio(int rini,int rfin)
  { int valor_salida=0;

    // Generem el numero aleatori entre 0 y 1
    double alea_generat=aleatorio_nemexis.nextDouble();

    // Escalem el numero entre el rang escollit
    return ((int)((alea_generat*(rfin-rini))+rini));
  }


   //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   // Leemos las imagenes asociadas a la prueba
   void Leer_Imagenes_Local()
   {
     // Seleccion aleatoria de las imagenes
     int igan_img=aleatorio(1,8);
     int iper_img=aleatorio(1,8);

     // Liberamos las imagenes
     try  { 
           image_ganador.flush(); 
           image_perdedor.flush(); 
          } catch (Exception egg) {}; 
      
         try {
          // Imagenes cargadas desde applet++++++++++++++++++++++++++++++++++++++  
          image_fondo = getImage(getCodeBase(), "images_nemexis/fondo.jpg");
          imagen_nave = getImage(getCodeBase(), "images_nemexis/jugador.gif");
          imagen_explosion = getImage(getCodeBase(), "images_nemexis/explosion.gif");
          imagen_nave_inmune = getImage(getCodeBase(), "images_nemexis/jugador_inmune.gif");
          imagen_monstruo= getImage(getCodeBase(), "images_nemexis/malo_monstruo.gif");

          imagen_estrella= getImage(getCodeBase(), "images_nemexis/malo_estrella.gif");
          imagen_jarjar= getImage(getCodeBase(), "images_nemexis/malo_jarjar.gif");
          imagen_pikachu= getImage(getCodeBase(), "images_nemexis/malo_pikachu.gif");
          imagen_prin= getImage(getCodeBase(), "images_nemexis/malo_prin.gif");
          imagen_pelusa= getImage(getCodeBase(), "images_nemexis/malo_pelusa.gif");
          imagen_xbox= getImage(getCodeBase(), "images_nemexis/malo_xbox.gif");
          imagen_culo= getImage(getCodeBase(), "images_nemexis/malo_culo.gif");
          imagen_meneo= getImage(getCodeBase(), "images_nemexis/malo_meneo.gif");

          imagen_bala= getImage(getCodeBase(), "images_nemexis/malo_bala.gif");
          imagen_monstruo_final= getImage(getCodeBase(), "images_nemexis/malo_monstruo_final.gif");

          imagen_ladrillos = getImage(getCodeBase(),"images_nemexis/ladrillos.jpg");
          return;
         } catch (Exception e) 
           { System.out.println("Load_Imagenes: Cargando desde fuera de applet"); 
             // e.printStackTrace();
           }

         // Cargando imagenes desde fichero++++++++++++++++++++++++++++++++++++
         Toolkit new_tool=Toolkit.getDefaultToolkit();
           try {
             image_fondo = new_tool.getImage("images_nemexis/fondo.jpg");
             imagen_nave = new_tool.getImage("images_nemexis/jugador.gif");
             imagen_explosion = new_tool.getImage("images_nemexis/explosion.gif");
             imagen_nave_inmune = new_tool.getImage("images_nemexis/jugador_inmune.gif");
             imagen_monstruo=new_tool.getImage("images_nemexis/malo_monstruo.gif");
             imagen_estrella=new_tool.getImage("images_nemexis/malo_estrella.gif");
             imagen_jarjar=new_tool.getImage("images_nemexis/malo_jarjar.gif");
             imagen_pikachu=new_tool.getImage("images_nemexis/malo_pikachu.gif");
             imagen_prin=new_tool.getImage("images_nemexis/malo_prin.gif");
             imagen_pelusa=new_tool.getImage("images_nemexis/malo_pelusa.gif");
             imagen_xbox= new_tool.getImage("images_nemexis/malo_xbox.gif");
             imagen_culo= new_tool.getImage("images_nemexis/malo_culo.gif");
             imagen_meneo=new_tool.getImage("images_nemexis/malo_meneo.gif");

             imagen_bala=new_tool.getImage("images_nemexis/malo_bala.gif");
             imagen_monstruo_final=new_tool.getImage("images_nemexis/malo_monstruo_final.gif");

             imagen_ladrillos= new_tool.getImage("images_nemexis/ladrillos.jpg");
             // return;
           } catch (Exception e) 
             { System.out.println("Error al cargar imagenes");  }       
 
        // Esperamos a capturarlas con el mediatracker++++++++++++++++++++++++++
        MediaTracker tracker_atle=new MediaTracker(this);
        tracker_atle.addImage(image_fondo,0);
        tracker_atle.addImage(imagen_nave,1);
        tracker_atle.addImage(imagen_explosion,2);
        tracker_atle.addImage(imagen_nave_inmune,3);
        // tracker_atle.addImage(imagen_ladrillos,6);
        try { tracker_atle.waitForAll();  } catch (InterruptedException e) {}
    }

  //----------------------------------------------------------------------------
  // Constructor
  public Nemexis()
  { 
    // Inicializamos la funcion aleatorio
    try { 
     Calendar ahora=Calendar.getInstance();
     aleatorio_nemexis=new Random(ahora.getTime().hashCode());             
    } catch (Exception ed) {  ed.printStackTrace();  }

     // Creamos al protagonista
     protagonista=new Jugador("Nabetse", true, new Coordenadas(50,100));
     nombre_jugador_applet="Nabetse";

     // Introducimos el jugador en la lista de jugadores
     lista_jugadores.put(new String(nombre_jugador_applet),protagonista);
 
     // Creacion del tablero del juego de billar, con la coleccion de bolas
     tabla=new Tablero();
    
     // Creamos el gestor de enemigos
     gestor_enemigos=new Gestor_Enemigos();
    
     // Creamos la pantalla del juego
     setLayout(new BorderLayout());
     pantalla=new Pantalla(1.5);
     add(pantalla,BorderLayout.CENTER);
     Panel panel_inferior=new Panel(new GridLayout(1,4));
     panel_inferior.add(new Label(nombre_jugador_applet));
     label_Puntuacion=new Label("Puntos = "+protagonista.puntos);
     panel_inferior.add(label_Puntuacion);
     label_Vidas=new Label("Vidas = "+protagonista.vidas);
     panel_inferior.add(label_Vidas);
     reloj_nemexis=new Reloj_Nemexis();
     panel_inferior.add(reloj_nemexis.getEtiqueta_tiempo());
     add(panel_inferior, BorderLayout.SOUTH);

     // Anaydimos los listeners
     pantalla.addKeyListener(this);
     addKeyListener(this);

     // Pedimos el foco
     pantalla.requestFocus();

     // Validamos y refrescamos
     validate();
     doLayout();
     repaint();
  }

  //-----------------------------------------------------------------------------------------
  //  Funcion mostrar_Foto_Final_Partida(boolean es_ganador,String texto_mensaje_par)
  //   Esta funcion mostrara a pantalla completa la foto correspondiente ganadora o perdedora
  // mas un texto por pantalla.
  public void mostrar_Foto_Final_Partida(boolean es_ganador,String texto_mensaje_par)
  {  Pantalla_Foto panta_foto=null;
     removeAll();
     setLayout(new GridLayout(1,1));
      
     // Desconectamos
     desconexion_procesos();

     // Mostramos imagen correspondiente
     if (es_ganador)
     {  
       panta_foto=new Pantalla_Foto(image_ganador,texto_mensaje_par);       
     }      
     else 
     {
       panta_foto=new Pantalla_Foto(image_perdedor,texto_mensaje_par);
     }

     add(panta_foto);            
      
     validate(); 
     doLayout();
     repaint(); 
   }


  //------------------------------------------------------------------------------
  // Procedimiento init()
  public void init() 
  {
   // Leemos las imagenes
   Leer_Imagenes_Local();
  }

  //------------------------------------------------------------------------------
  // Procedimiento desconexion_procesos
  //  Procedimiento que finalizara con todos los procesos y los recursos
  void desconexion_procesos()
  { 
     // Nos desconectamos de la comunicacion
     desconexion_procesos_comunicacion();
     
     // Liberamos las cosas
     try {       
       // Desconectamos los jugadores
       Enumeration e=lista_jugadores.keys();
       while(e.hasMoreElements())
       { String snom=(String)e.nextElement();
         Jugador sjug=(Jugador)lista_jugadores.get(snom);
 
         // Desconectamos el jugador y sus balas
         sjug.salir_jugador=true;
         sjug.gestor_balas.salir_gestor_balas=true;
          
         // Enviamos al garbage collector
         try { sjug.gestor_balas=null; } catch (Exception exgestbal) {};
         try { sjug=null;} catch (Exception exjug) {};
       }

       // Detenemos y eliminamos el tablero
       tabla.salir_tablero=true;
       try {  tabla=null; } catch (Exception extabla) {};

       // Detenemos y eliminamos los enemigos
       gestor_enemigos.salir_gestor_enemigos=true;
       try { gestor_enemigos=null; } catch (Exception exgestene) {};

       // Eliminamos la pantalla
       try { pantalla=null; } catch (Exception expant) {};
      } catch (Exception e) {};     
  }
 
  //------------------------------------------------------------------------------
  // Procedimiento desconexion_procesos_comunicacion
  //  Procedimiento que finalizara con todos los procesos y los recursos de comunicacion
  void desconexion_procesos_comunicacion()
  {
    // Liberamos el recurso de comunicacion
    try {
    //  Comunicador_Nemexis.Enviar_Paquete_Nemexis(Comunicador_Nemexis.DESCONECTAR,"");

    // Paramos el flujo de comunicacion
  //  Comunicador_Nemexis.escucha_comunica.salir_comunicacion_tcp=true;
  //  Comunicador_Nemexis.salir_comunicacion=true;

  //  Comunicador_Nemexis.escucha_comunica.comunica_hear.client.close();

  //  Comunicador_Nemexis.escucha_comunica=null;
  //  Comunicador_Nemexis=null;
   } catch (Exception ed) {}
  }


   //---------------------------------------------------------------------
   // Procedimiento stop
   //   Enviamos un paquete de comunicacion de abandono de partida y cerrado
   public void stop()
   { 
     try { desconexion_procesos(); } catch (Exception e) {};
   }


   //---------------------------------------------------------------------
   // Procedimiento destroy
   //   Enviamos un paquete de comunicacion de abandono de partida y cerrado
   public void destroy()
   { 
     try { desconexion_procesos(); } catch (Exception e) {};
   }

  
  //------------------------------------------------------------------------------
  // Procedimiento modificar_Lista_Teclas(Integer direccion_par, boolean accion_par)
  //   Este procedimiento insertara/eliminara entradas de la lista de teclas
  void modificar_Lista_Teclas(Integer direccion_par, boolean accion_par)
  { 
     // Dependiendo del tipo de accion ((accion_par==true-> insertar)((accion_par==false-> eliminar))
     if (accion_par)
     {  if ((Integer)teclas_pulsadas.get(direccion_par)==null)
        teclas_pulsadas.put(direccion_par,new Integer(direccion_par.intValue()));
     }
     else // Eliminar
     {
       if ((Integer)teclas_pulsadas.get(direccion_par)!=null)
         teclas_pulsadas.remove(direccion_par);
     }
  }

   //------------------------------------------------------------------------------
   // Funciones asociadas al teclado

   //------------------------------------------------------------------------------
   // Procedimiento keyPressed
   //   Este procedimiento anyadira (sin repetir) las direcciones de movimiento de la lista
   // y determinaremos la nueva direccion del jugador
   public void keyPressed( KeyEvent e ) 
   {  
     // Segun el codigo de tecla
     switch (e.getKeyCode())
     {  case TECLA_ARRIBA:    modificar_Lista_Teclas(new Integer(getARRIBA()),true);    break;
        case TECLA_ABAJO:     modificar_Lista_Teclas(new Integer(getABAJO()),true);     break;
        case TECLA_RIGHT:     modificar_Lista_Teclas(new Integer(getDERECHA()),true);   break;
        case TECLA_LEFT:      modificar_Lista_Teclas(new Integer(getIZQUIERDA()),true); break;
        case TECLA_ESPACIO:   protagonista.cambiar_Disparo(Jugador.MODO_DISPARO);  break;
     }

     // Determinamos la nueva direccion entre las 8 posibles
     int nueva_direccion=getNINGUNA();
     switch (teclas_pulsadas.size())
     {  case 1:  // Determinamos entre 4 direcciones
          if ((Integer)teclas_pulsadas.get(new Integer(getARRIBA()))!=null)
          {    nueva_direccion=getARRIBA(); break; }
          if ((Integer)teclas_pulsadas.get(new Integer(getABAJO()))!=null)
          {    nueva_direccion=getABAJO(); break; }
          if ((Integer)teclas_pulsadas.get(new Integer(getDERECHA()))!=null)
          {    nueva_direccion=getIZQUIERDA(); break; }
          if ((Integer)teclas_pulsadas.get(new Integer(getIZQUIERDA()))!=null)
          {    nueva_direccion=getDERECHA(); break; }
          break;
        case 2:
           if (((Integer)teclas_pulsadas.get(new Integer(getARRIBA()))!=null)&&((Integer)teclas_pulsadas.get(new Integer(getIZQUIERDA()))!=null))
           {    nueva_direccion=getARRIBA_DERECHA();   break; }
           if (((Integer)teclas_pulsadas.get(new Integer(getARRIBA()))!=null)&&((Integer)teclas_pulsadas.get(new Integer(getDERECHA()))!=null))
           {    nueva_direccion=getARRIBA_IZQUIERDA(); break; }
           if (((Integer)teclas_pulsadas.get(new Integer(getABAJO()))!=null)&&((Integer)teclas_pulsadas.get(new Integer(getIZQUIERDA()))!=null))
           {    nueva_direccion=getABAJO_DERECHA();    break; }
           if (((Integer)teclas_pulsadas.get(new Integer(getABAJO()))!=null)&&((Integer)teclas_pulsadas.get(new Integer(getDERECHA()))!=null))
           {    nueva_direccion=getABAJO_IZQUIERDA();  break; }
           break;
       }

       // Realizamos el cambio de direccion
       protagonista.cambiar_Direccion(nueva_direccion);
   }

   public void keyTyped( KeyEvent e ) {   }

   //------------------------------------------------------------------------------
   // Procedimiento keyPressed
   //   Este procedimiento eliminara la tecla pulsada de la lista
   public void keyReleased( KeyEvent e ) 
   {
     // Segun el codigo de tecla
     switch (e.getKeyCode())
     {  case TECLA_ARRIBA:    modificar_Lista_Teclas(new Integer(getARRIBA()),false);    break;
        case TECLA_ABAJO:     modificar_Lista_Teclas(new Integer(getABAJO()),false);     break;
        case TECLA_RIGHT:     modificar_Lista_Teclas(new Integer(getDERECHA()),false);   break;
        case TECLA_LEFT:      modificar_Lista_Teclas(new Integer(getIZQUIERDA()),false); break;     
        case TECLA_ESPACIO:   protagonista.cambiar_Disparo(Jugador.MODO_PAZ);       break;
      }

     // Controlamos la lista vacia
     if (teclas_pulsadas.size()==0) protagonista.cambiar_Direccion(getNINGUNA());
   }
  

  //************************************************************************************
  //************************************************************************************
  //************************************************************************************
  //************************************************************************************
  //************************************************************************************
  //************************************************************************************
  // Procedimiento principal 
  // Invocat nomes quan s'executa com a aplicacio
  public static void main(String[] args) {

        Frame frame = new Frame("Nemexis");
        final Nemexis nemexis = new Nemexis();
        nemexis.init();
        frame.setResizable(true);
        frame.setSize(550,430);
        // frame.setSize(750,550);
        frame.add(nemexis);                   

        frame.addWindowListener(new WindowAdapter() {
                                 public void windowClosing(WindowEvent me) 
                                 { System.exit(0); } 
                                });

        // frame.pack();  "pack()"= hace que los elementos SE AJUSTEN A SU TAMANYO PREFERIDO
        frame.setVisible(true);
    }
}

