/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.trabjocomeegalletas.elements;

import autonoma.gamebase.elements.Sprite;
import autonoma.gamebase.elements.SpriteMobile;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class ComeGalletas extends SpriteMobile implements Runnable {

    
    
    /// Atributos
    public static final int INITIAL_WIDTH = 50;
    public static final int INITIAL_HEIGHT = 50;
    protected int step = 5; 
    public int velocidad = 10;
    protected long delay;
    private boolean running;
    private boolean paused;
    protected Thread thread;
    
    private int numeroGalletas = 0;
    
    ///metodo contructor
    public ComeGalletas(int x, int y, int height, int width) {
        super(x, y, height, width);
        setColor(Color.BLUE);
    }

    public boolean move( ArrayList <Sprite> sprites)
    {
        
        // Obtener la posición actual de la galleta mas cercana
        Point posiciones = encontrarPosicionMasCercana(sprites);  
        
        
        // se separa los datos y se organizan para hacer los movimientos
        int posicionXGalleta = posiciones.x;
        int posicionYGalleta = posiciones.y;
        int posicionXComeGalletas = x;
        int posicionYComeGalletas = y;

        // Calcular la dirección en la que se debe mover el comme galletas
        int dirX = Integer.signum(posicionXComeGalletas - posicionXGalleta);
        int dirY = Integer.signum(posicionYComeGalletas - posicionYGalleta);

        // Mover al enemigo en la dirección calculada
        x = (posicionXGalleta + dirX * velocidad);
        y = (posicionYGalleta + dirY * velocidad);
        
        if(!isOutOfGraphicContainer(posicionXComeGalletas, posicionYComeGalletas, width, height))
        {
            x = posicionXComeGalletas;
            y = posicionYComeGalletas;

            if(gameContainer != null)
                gameContainer.refresh();
            
            return true;
        }
        
        return false;
        
    }
    
    
    public void grow(){
    
        this.numeroGalletas +=1;
    }
    
    
    public Point encontrarPosicionMasCercana(ArrayList<Sprite> sprites) {
        
    // Obtener la posición actual del personaje
    int posicionXComeGalletas = x;
    int posicionYComeGalletas = y;
    
    // Inicializar variables para la posición más cercana
    Sprite posicionMasCercana = null;
    double distanciaMinima = Double.MAX_VALUE;
    
    // Recorrer la lista de sprites
    for (Sprite sprite : sprites) {
        // Calcular la distancia entre el personaje y el sprite actual
        int posicionXSprite = sprite.getX();
        int posicionYSprite = sprite.getY();
        double distancia = Math.sqrt(Math.pow(posicionXComeGalletas - posicionXSprite, 2) 
                                 +  Math.pow(posicionYComeGalletas - posicionYSprite, 2));
        
        // Actualizar la posición más cercana si se encuentra una más cercana
        if (distancia < distanciaMinima) {
            distanciaMinima = distancia;
            posicionMasCercana = sprite;
        }
    }
    
    // Devolver las coordenadas de la posición más cercana
    if (posicionMasCercana != null) {
        return new Point(posicionMasCercana.getX(), posicionMasCercana.getY());
    } else {
        return null;
    }
    
    }


    //para qeu mueva el hilo
    public void run(ArrayList <Sprite> sprites) {
        
        running = true;

        while (isRunning()) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
            }

            if (isPaused()) {
                continue;
            }

            move(sprites);
        }    
    
    }







    
    ///metodo abtractos
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
      
    public boolean isRunning() {
        return running;
    }

    public void stop() {
        this.running = false;
    }

    public boolean isPaused() {
        return paused;
    }

    public void pause() {
        this.paused = true;
    }

    public void unpause() {
        this.paused = false;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
   
    
}
