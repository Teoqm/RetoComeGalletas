/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonoma.gamebase.main;

import autonoma.trabjocomeegalletas.elements.Mapa;
import gnomegame.ui.GameWindow;

/**
 *
 * @author mateo
 */
public class TrabajoComeeGalletas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //se crea el grafico del mapa del juego
        Mapa mapa = new Mapa(0, 0, 500, 500);
        
        GameWindow window = new GameWindow();
        window.setGarden(mapa);
        mapa.setGraphicContainer(window);
        window.setSize(500, 500);
        window.setTitle("Come Galletas");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
}
