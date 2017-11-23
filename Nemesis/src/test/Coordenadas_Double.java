/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Vicky
 */
public class Coordenadas_Double {
    double x,y; 
  	
    //------------------------------------------------------
    // Constructor 1
    Coordenadas_Double(double sel_x,double sel_y) { x=sel_x; y=sel_y; };
 
    //------------------------------------------------------
    // Constructor 2
    Coordenadas_Double(double sel_x,double sel_y,int color_par) { x=sel_x; y=sel_y; }
 
    //------------------------------------------------------
    //Constructor de copia
    Coordenadas_Double(Coordenadas_Double obj) { x=obj.x; y=obj.y;  };

    //------------------------------------------------------
    // Constructor de asignacion
    void copia(Coordenadas_Double obj) { x=obj.x; y=obj.y; };

    //------------------------------------------------------    
    public boolean equals(Coordenadas_Double obj)  
    { return ((x==obj.x)&&(y==obj.y)); }

    //------------------------------------------------------    
    public void show()  
    {  System.out.print("("+x+","+y+")");  }  

    //------------------------------------------------------    
    public String get_Paquete()
    {  return ("("+x+","+y+")"); }
    
    //------------------------------------------------------    
    public void set_Paquete(String buf)
    {  x=(new Double(buf.substring(buf.indexOf("(")+1,buf.indexOf(",")))).doubleValue();
       y=(new Double(buf.substring(buf.indexOf(",")+1,buf.indexOf(")")))).doubleValue();
    }

    //------------------------------------------------------
    public double diferencia_absoluta(Coordenadas_Double obj)
    {  return(Math.sqrt(Math.pow(x-obj.x,2)+Math.pow(y-obj.y,2))); }
}
