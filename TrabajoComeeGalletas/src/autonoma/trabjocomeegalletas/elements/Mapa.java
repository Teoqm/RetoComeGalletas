/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.trabjocomeegalletas.elements;

import autonoma.gamebase.elements.Sprite;
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
            
            //al moustro moverse se ve si si comio una galleta
            if(monstruo.move(sprites))
            {
                prosecarGalletasComidas();
            }
        
        
        if(code == KeyEvent.VK_G)
        {
            addGalleta();
            refresh();
        }
        
    }
    
    private void prosecarGalletasComidas()
    {
        for(int i=0; i<sprites.size(); i++)
        {
            if(sprites.get(i) instanceof  Galleta)
            {
                 Galleta galleta = ( Galleta) sprites.get(i);
                
                if(monstruo.checkCollision(galleta))
                {
                    
                        monstruo.grow();
                        sprites.remove(galleta);
                }
            }
        }
    }
    
    
    private void addGalleta()
    {
        
        //se cre la gaalleta 
        Galleta g = null;
        
        // DO WHILe dodnde se va va a dar un posicion al la nueva galleta y 
        // se va analizar si esa galleta se encuentra lejos de 
        do{
        try {
            ///se crea la nueva galleta 
            g = Galleta.create(width, height);
        } catch (InstantiationException ex) {
            Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
        }
        }while(!revisarGalleta(g));
        
        
        /// al ya verificar al galleta se ingelesa a la lista 
        sprites.add(g);
    }
    
    
    //se  crea un metdod qeu va revisar si la nueva gallesta no este encima de otra
    public boolean revisarGalleta (Galleta g){
    
        // se hace un for eche para ver si el nueva galleta esta encima de otra galleta
        for(Sprite sprite : sprites)
        {
            /// si se hay colicion 
             if(sprite.checkCollision(g)){ 
               return false;
   
        }
   
        }
        
       //se retorna verdadero para decir que la nueva galleta si sepuede ingresar 
        return true;
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

