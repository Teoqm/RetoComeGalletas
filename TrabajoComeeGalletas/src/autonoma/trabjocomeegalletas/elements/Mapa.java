package autonoma.trabjocomeegalletas.elements;

import autonoma.gamebase.elements.Sprite;
import autonoma.gamebase.elements.SpriteContainer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa el mapa del juego, donde se mueve el monstruo y se generan las galletas.
 */
public class Mapa extends SpriteContainer {

    protected ComeGalletas monstruo;

    /**
     * Constructor del mapa. Inicializa el monstruo y el color de fondo.
     */
    public Mapa(int x, int y, int height, int width) {
        super(x, y, height, width);

        // Se inicializa el monstruo en el centro del mapa
        monstruo = new ComeGalletas((width - ComeGalletas.INITIAL_WIDTH) / 2,
                                    (height - ComeGalletas.INITIAL_HEIGHT) / 2,
                                    ComeGalletas.INITIAL_WIDTH,
                                    ComeGalletas.INITIAL_HEIGHT);

        monstruo.setGraphicContainer(this);
        monstruo.setDelay(800); // mueve cada 0.8 segundos
        this.setColor(Color.BLACK);
    }

    /**
     * Procesa eventos de teclado.
     */
    public void keyPressed(int code) {
        if (code == KeyEvent.VK_G) {
            addGalleta();
            refresh();
        }
    }

    /**
     * Agrega una nueva galleta al mapa en una posición aleatoria válida.
     */
    private void addGalleta() {
        Galleta g = null;

        try {
            // Intentar crear una galleta hasta que no colisione con otras
            do {
                g = Galleta.create(width, height);
            } while (!revisarGalleta(g));
        } catch (Exception ex) {
            Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        sprites.add(g);
    }

    /**
     * Verifica si la nueva galleta no colisiona con otras ya existentes.
     */
    public boolean revisarGalleta(Galleta g) {
        for (Sprite sprite : sprites) {
            if (sprite.checkCollision(g)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Procesa las galletas comidas por el monstruo.
     */
    private void procesarGalletasComidas() {
        sprites.removeIf(sprite -> 
            sprite instanceof Galleta && monstruo.checkCollision(sprite)
        );
    }

    /**
     * Pinta el contenido del mapa.
     */
    @Override
    public void paint(Graphics g) {
        // Fondo
        g.setColor(color);
        g.fillRect(x, y, width, height);

        // Sprites
        for (Sprite sprite : sprites) {
            sprite.paint(g);
        }

        // Monstruo
        monstruo.paint(g);

        // Movimiento del monstruo y comer galletas
        if (monstruo.move(sprites)) {
            procesarGalletasComidas();
        }
    }

    /**
     * Fuerza la actualización del contenedor gráfico.
     */
    @Override
    public void refresh() {
        if (gameContainer != null)
            gameContainer.refresh();
    }

    /**
     * Retorna los límites del mapa.
     */
    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(x, y, width, height);
    }
}
