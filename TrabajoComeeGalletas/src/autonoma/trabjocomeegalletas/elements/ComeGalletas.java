/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.trabjocomeegalletas.elements;

import autonoma.gamebase.elements.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class ComeGalletas extends Sprite{

    
    
    /// Atributos
    public static final int INITIAL_WIDTH = 50;
    public static final int INITIAL_HEIGHT = 50;
    protected int step = 5; 
    
    private int numeroGalletas = 0;
    
    ///metodo contructor
    public ComeGalletas(int x, int y, int height, int width) {
        super(x, y, height, width);
        setColor(Color.BLUE);
    }

    public boolean move( ArrayList <Sprite> sprites)
    {
        ArrayList <int> direccion =  
        int ny = y;
        
        switch(direction)
        {
            case KeyEvent.VK_UP:
                ny -= step;
            break;

            case KeyEvent.VK_DOWN:
                ny += step;
            break;

            case KeyEvent.VK_LEFT:
                nx -= step;
            break;

            case KeyEvent.VK_RIGHT:
                nx += step;
            break;
        }
        
        if(!isOutOfGraphicContainer(nx, ny, width, height))
        {
            x = nx;
            y = ny;

            if(gameContainer != null)
                gameContainer.refresh();
            
            return true;
        }
        
        return false;
        
    }
    
    
    public void grow(){
    
        this.numeroGalletas +=1;
    }
    
    
    public ArrayList <int>  buscarDireccion(){
    
            // Obtener la posición actual del enemigo y del personaje rosado
            int posicionXEnemigo = enemigo.getX();
            int posicionYEnemigo = enemigo.getY();
            int posicionXPersonaje = personajeRosado.getX();
            int posicionYPersonaje = personajeRosado.getY();

            // Calcular la dirección en la que se debe mover el enemigo
            int dirX = Integer.signum(posicionXPersonaje - posicionXEnemigo);
            int dirY = Integer.signum(posicionYPersonaje - posicionYEnemigo);

            // Mover al enemigo en la dirección calculada
            enemigo.setX(posicionXEnemigo + dirX * velocidadEnemigo);
            enemigo.setY(posicionYEnemigo + dirY * velocidadEnemigo);
    
    }
    
    ///metodo abtrac
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    
    
        
   
    
}
