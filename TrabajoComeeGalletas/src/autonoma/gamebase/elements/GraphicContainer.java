package autonoma.gamebase.elements;

import java.awt.Rectangle;

/**
 * Interfaz que define los metodos necesarios para un contenedor grafico.
 * Cualquier clase que implemente esta interfaz debe poder actualizarse
 * y proporcionar sus limites (boundaries) como un objeto Rectangle.
 */
public interface GraphicContainer {

    /**
     * Metodo para actualizar o refrescar el contenido grafico del contenedor.
     */
    public void refresh();

    /**
     * Metodo para obtener los limites del contenedor grafico.
     * @return Rectangle que representa los limites del contenedor
     */
    public Rectangle getBoundaries();
}
