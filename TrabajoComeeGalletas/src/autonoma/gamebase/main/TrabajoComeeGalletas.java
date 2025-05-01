package autonoma.gamebase.main;

import autonoma.trabjocomeegalletas.elements.Mapa;
import gnomegame.ui.GameWindow;

/**
 * Clase principal que lanza la aplicacion del juego "Come Galletas".
 * Crea la ventana del juego y carga el mapa donde se desarrolla.
 */
public class TrabajoComeeGalletas {

    /**
     * Metodo principal que inicia el juego.
     * @param args argumentos de linea de comandos (no usados)
     */
    public static void main(String[] args) {

        // Se crea el grafico del mapa del juego (escenario)
        Mapa mapa = new Mapa(0, 0, 500, 500);

        // Se crea la ventana del juego y se configura
        GameWindow window = new GameWindow();
        window.setGarden(mapa);                  // Se establece el mapa como el area de juego
        mapa.setGraphicContainer(window);        // Se vincula la ventana como contenedor del mapa
        window.setSize(500, 500);                // Se define el tamaño de la ventana
        window.setTitle("Come Galletas");        // Titulo de la ventana
        window.setLocationRelativeTo(null);      // Centrar ventana en pantalla
        window.setVisible(true);                 // Hacer visible la ventana
    }
}
