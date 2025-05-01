package autonoma.gamebase.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * Clase abstracta que representa un objeto grafico (sprite) en el juego.
 * Un sprite tiene posicion, dimensiones, color, imagen y esta contenido en un GraphicContainer.
 */
public abstract class Sprite {
    protected int x;
    protected int y;
    protected int height;
    protected int width;
    protected Color color;
    protected ImageIcon image;
    protected GraphicContainer gameContainer;

    /**
     * Constructor del sprite con posicion y tamaño iniciales.
     * @param x coordenada en X
     * @param y coordenada en Y
     * @param height alto del sprite
     * @param width ancho del sprite
     */
    public Sprite(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    /**
     * Verifica si el sprite esta fuera del contenedor grafico.
     * @return true si esta fuera, false si esta dentro
     */
    public boolean isOutOfGraphicContainer() {
        return isOutOfGraphicContainer(x, y, width, height);
    }

    /**
     * Verifica si un rectangulo con las coordenadas dadas esta fuera del contenedor grafico.
     * @return true si esta fuera, false si esta dentro
     */
    public boolean isOutOfGraphicContainer(int x, int y, int width, int height) {
        if (gameContainer == null)
            return false;

        Rectangle bounds = gameContainer.getBoundaries();

        return !(x >= bounds.getX() &&
                 y >= bounds.getY() &&
                 x + width <= bounds.getX() + bounds.getWidth() &&
                 y + height <= bounds.getY() + bounds.getHeight());
    }

    /**
     * Verifica si este sprite colisiona con otro sprite.
     * @param other otro sprite
     * @return true si hay colision, false si no
     */
    public boolean checkCollision(Sprite other) {
        boolean collisionX = this.getX() + this.getWidth() >= other.getX() &&
                             this.getX() < other.getX() + other.getWidth();

        boolean collisionY = this.getY() + this.getHeight() >= other.getY() &&
                             this.getY() < other.getY() + other.getHeight();

        return collisionX && collisionY;
    }

    /**
     * Metodo abstracto que cada sprite debe implementar para pintarse.
     * @param g el objeto Graphics donde se dibujara
     */
    public abstract void paint(Graphics g);

    // Metodos getters y setters
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }

    public ImageIcon getImage() { return image; }
    public void setImage(ImageIcon image) { this.image = image; }

    public void setGraphicContainer(GraphicContainer gContainer) {
        this.gameContainer = gContainer;
    }
}
