package autonoma.trabjocomeegalletas.elements;

import autonoma.gamebase.elements.Sprite;
import autonoma.gamebase.elements.SpriteMobile;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 * Clase que representa al personaje principal "Come Galletas"
 * que se mueve hacia la galleta mas cercana y la consume.
 */
public class ComeGalletas extends SpriteMobile implements Runnable {

    // Constantes y atributos
    public static final int INITIAL_WIDTH = 50;
    public static final int INITIAL_HEIGHT = 50;
    
    protected int step = 5;
    public int velocidad = 10; // Pixeles por movimiento
    protected long delay;      // Tiempo entre movimientos
    private boolean running;
    private boolean paused;
    protected Thread thread;
    
    private int numeroGalletas = 0;

    // Constructor
    public ComeGalletas(int x, int y, int height, int width) {
        super(x, y, height, width);
        setColor(Color.BLUE);
    }

    /**
     * Metodo que mueve al personaje hacia la galleta mas cercana.
     * @param sprites lista de posibles galletas
     * @return true si se movio, false si no
     */
    public boolean move(ArrayList<Sprite> sprites) {
        Point posiciones = encontrarPosicionMasCercana(sprites);
        if (posiciones == null) return false;

        int posicionXGalleta = posiciones.x;
        int posicionYGalleta = posiciones.y;

        // Direccion hacia la galleta (1, 0 o -1)
        int dirX = Integer.signum(posicionXGalleta - x);
        int dirY = Integer.signum(posicionYGalleta - y);

        // Nuevo intento de posicion
        int nuevaX = x + dirX * velocidad;
        int nuevaY = y + dirY * velocidad;

        // Verifica si esta dentro del contenedor grafico
        if (!isOutOfGraphicContainer(nuevaX, nuevaY, width, height)) {
            x = nuevaX;
            y = nuevaY;

            if (gameContainer != null)
                gameContainer.refresh();

            return true;
        }

        return false;
    }

    /**
     * Aumenta el contador de galletas comidas.
     */
    public void grow() {
        this.numeroGalletas += 1;
    }

    /**
     * Busca la posicion de la galleta mas cercana.
     * @param sprites lista de galletas disponibles
     * @return Point con las coordenadas de la galleta mas cercana
     */
    public Point encontrarPosicionMasCercana(ArrayList<Sprite> sprites) {
        int posicionX = x;
        int posicionY = y;

        Sprite galletaMasCercana = null;
        double distanciaMinima = Double.MAX_VALUE;

        for (Sprite sprite : sprites) {
            int sx = sprite.getX();
            int sy = sprite.getY();

            double distancia = Math.sqrt(Math.pow(posicionX - sx, 2) + Math.pow(posicionY - sy, 2));

            if (distancia < distanciaMinima) {
                distanciaMinima = distancia;
                galletaMasCercana = sprite;
            }
        }

        if (galletaMasCercana != null) {
            return new Point(galletaMasCercana.getX(), galletaMasCercana.getY());
        }

        return null;
    }

    /**
     * Metodo principal que se ejecuta cuando el hilo arranca.
     * Mueve al personaje continuamente mientras este activo.
     * @param sprites lista de galletas
     */
    public void run(ArrayList<Sprite> sprites) {
        running = true;

        while (isRunning()) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            if (isPaused()) {
                continue;
            }

            move(sprites);
        }
    }

    // --- METODOS DE CONTROL DE HILO ---

    @Override
    public void run() {
        // Metodo por defecto del Runnable (no usado en esta implementacion)
        throw new UnsupportedOperationException("No implementado directamente.");
    }

    public boolean isRunning() {
        return running;
    }

    public void stop() {
        this.running = false;
    }

    public boolean isPaused() {
        return paused;
    }

    public void pause() {
        this.paused = true;
    }

    public void unpause() {
        this.paused = false;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    /**
     * Dibuja el personaje en pantalla.
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
