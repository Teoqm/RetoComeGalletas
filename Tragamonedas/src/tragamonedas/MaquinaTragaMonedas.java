/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tragamonedas;

/**
 *
 * @author mateo
 */
public class MaquinaTragaMonedas {

    /**
     * @param args the command line arguments
     */
    
    
    int puntajeGlobal;

    public MaquinaTragaMonedas(){
    this.puntajeGlobal =0;
    }
    public boolean jugar() {
    
        return false;
    }
    public int contarFigurasIguales(Figura[] figura){
    
    int cantidadIguales = 0;    
   //si son tads iguales
    if(figura[1].identificador == figura[2].identificador && figura[2].identificador == figura[3].identificador){
        
        cantidadIguales =3;
     }else if (figura[1].identificador == figura[2].identificador){
    cantidadIguales =2;
    }else if(figura[2].identificador == figura[3].identificador){
    cantidadIguales =2;
    }else if(figura[1].identificador == figura[3].identificador){
    cantidadIguales =2;
    }
  
        return calcularPuntosGanados(cantidadIguales);
        
    }
   public int calcularPuntosGanados(int cantidadFigurasIguales){
       
       //se va returnar los puntos que se ganaron
      if( cantidadFigurasIguales == 3){
        return 1000;
     }else if (cantidadFigurasIguales == 2){
        return 300;
    }else{
         return -50;
     }

   }
   
  public int getPuntajeGlobal(){

  return this.puntajeGlobal;
  }
}
