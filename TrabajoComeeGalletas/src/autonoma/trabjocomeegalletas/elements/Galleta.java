package autonoma.trabjocomeegalletas.elements;

import autonoma.gamebase.elements.Sprite;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Clase que representa una galleta en el mapa.
 */
public class Galleta extends Sprite {
   
    // Constantes de tamaño estándar
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;

    /**
     * Constructor de galleta con posición y tamaño personalizados.
     */
    public Galleta(int x, int y, int height, int width) {
        super(x, y, height, width);
        setColor(new Color(163, 115, 81)); // Color marrón tipo galleta
    }

    /**
     * Crea una nueva galleta aleatoriamente ubicada dentro del contenedor.
     * @param width ancho del contenedor
     * @param height alto del contenedor
     * @return nueva instancia de galleta
     * @throws InstantiationException si no se puede crear
     * @throws IllegalAccessException si hay problemas de acceso
     */
    public static Galleta create(int width, int height)
            throws InstantiationException, IllegalAccessException {

        // Coordenadas aleatorias dentro del contenedor
        int x = (int)(Math.random() * (width - Galleta.WIDTH));
        int y = (int)(Math.random() * (height - Galleta.HEIGHT));

        return new Galleta(x, y, Galleta.WIDTH, Galleta.HEIGHT);
    }

    /**
     * Metodo que dibuja la galleta.
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height); // Representacion visual de la galleta
    }
}
