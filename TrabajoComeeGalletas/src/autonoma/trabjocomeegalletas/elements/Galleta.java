/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.trabjocomeegalletas.elements;

import autonoma.gamebase.elements.Sprite;
import java.awt.Graphics;

/**
 *
 * @author mateo
 */
public class Galleta extends Sprite {
   
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;

    public Galleta(int x, int y, int height, int width) {
        super(x, y, height, width);
    }

    ///metodo Constructor
    public static Galleta create( int width, int height)
    ///se salta unas expeciones si laa hay para las maneje mapa
            throws InstantiationException, IllegalAccessException
    {
        int x = (int)(Math.random() * (width - Galleta.WIDTH));
        int y = (int)(Math.random() * (height - Galleta.HEIGHT));

        Galleta g = null;
       
        g = new Galleta(x, y,Galleta.WIDTH, Galleta.HEIGHT);
        
        return g;
    }
    
    
    @Override
    public void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
