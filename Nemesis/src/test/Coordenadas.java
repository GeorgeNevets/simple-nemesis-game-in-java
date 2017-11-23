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

public class Coordenadas {
     int x,y; 
	
    //------------------------------------------------------
    //Constructor 1
    Coordenadas(int sel_x,int sel_y) { x=sel_x; y=sel_y; };
 
    //------------------------------------------------------
    //Constructor 2
    Coordenadas(String buf_par) 
    { x=(new Integer(buf_par.substring(0,buf_par.indexOf(",")))).intValue();
      y=(new Integer(buf_par.substring(buf_par.indexOf(",")+1,buf_par.length()))).intValue();
    }

    //------------------------------------------------------
    //Constructor de copia
    Coordenadas(Coordenadas obj) { x=obj.x; y=obj.y; };

    //------------------------------------------------------
    //Constructor de asignacion
    void copia(Coordenadas obj) { x=obj.x; y=obj.y; };

    //------------------------------------------------------    
    public boolean equals(Coordenadas obj)  
    { return ((x==obj.x)&&(y==obj.y)); }

    //------------------------------------------------------    
    public void show()  
    {  System.out.print("("+x+","+y+")");  }  

    //------------------------------------------------------
    public double diferencia_absoluta(Coordenadas obj)
    {  return(Math.sqrt(Math.pow(x-obj.x,2)+Math.pow(y-obj.y,2))); }

    //------------------------------------------------------    
    public String getPaquete()  
    {  return(x+","+y);  }
}
