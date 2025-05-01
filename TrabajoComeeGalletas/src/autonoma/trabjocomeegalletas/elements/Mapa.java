/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.trabjocomeegalletas.elements;

import autonoma.gamebase.elements.SpriteContainer;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateo
 */
public class Mapa extends SpriteContainer{
    
    /// Atributos
    
     protected ComeGalletas monstruo;
    
    ///Metodo constructor
    public Mapa(int x, int y, int height, int width) {
        super(x, y, height, width);
        
        ///se crea el mostrue y se va encontrar en la mitada del mapa
        monstruo = new ComeGalletas(( width -  ComeGalletas.INITIAL_WIDTH)/2, 
                          ( height - ComeGalletas.INITIAL_HEIGHT)/2, 
                          monstruo.INITIAL_WIDTH, ComeGalletas.INITIAL_HEIGHT);
        
        //SE CREA EL MOSNTRO
        monstruo.setGraphicContainer(this);
        
        
    }
    
    //metdod paar resibir teclas y actuar
    public void keyPressed(int code)
    {
        if(code == KeyEvent.VK_UP |
           code == KeyEvent.VK_DOWN |
           code == KeyEvent.VK_LEFT |
           code == KeyEvent.VK_RIGHT)
        {
            if(monstruo.move(code))
            {
                processMushroomsEaten();
            }
        }
        
        if(code == KeyEvent.VK_G)
        {
            addGreenMushroom();
            refresh();
        }
        
    }
    
    private void addGalleta()
    {
        Mushroom m = null;
        
        try {
            m = Mushroom.create(GreenMushroom.class, width, height);
        } catch (InstantiationException ex) {
            Logger.getLogger(Garden.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Garden.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sprites.add(m);
    }
    
    ///Metodo abtractos
    @Override
    public void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Rectangle getBoundaries() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
    
    
}
