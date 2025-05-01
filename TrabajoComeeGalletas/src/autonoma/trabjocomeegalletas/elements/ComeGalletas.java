/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.trabjocomeegalletas.elements;

import autonoma.gamebase.elements.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author mateo
 */
public class ComeGalletas extends Sprite{

    
    
    /// Atributos
    public static final int INITIAL_WIDTH = 50;
    public static final int INITIAL_HEIGHT = 50;
    protected int step = 5; 
    
    ///metodo contructor
    public ComeGalletas(int x, int y, int height, int width) {
        super(x, y, height, width);
        setColor(Color.BLUE);
    }

    public boolean move(int direction)
    {
        int nx = x;
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
    
    ///metodo abtrac
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    
    
        
   
    
}
