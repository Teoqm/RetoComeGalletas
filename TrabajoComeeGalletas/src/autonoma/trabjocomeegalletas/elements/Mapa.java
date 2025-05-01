/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.trabjocomeegalletas.elements;

import autonoma.gamebase.elements.SpriteContainer;
import java.awt.Graphics;
import java.awt.Rectangle;

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
        monstruo = new ComeGalletas((width-ComeGalletas.INITIAL_WIDTH)/2, 
                          (height-ComeGalletas.INITIAL_HEIGHT)/2, 
                          monstruo.INITIAL_WIDTH, ComeGalletas.INITIAL_HEIGHT);
        monstruo.setGraphicContainer(this);
        
        
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
