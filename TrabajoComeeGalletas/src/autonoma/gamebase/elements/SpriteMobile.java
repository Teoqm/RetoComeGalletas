package autonoma.gamebase.elements;

/**
 * Clase abstracta que representa un sprite con capacidad de movimiento.
 * Hereda de Sprite y agrega el atributo step para controlar la velocidad.
 */
public abstract class SpriteMobile extends Sprite {

    // Cantidad de pixeles que se mueve en cada paso
    protected int step;

    /**
     * Constructor que inicializa la posicion y el tamaño del sprite.
     * @param x coordenada en X
     * @param y coordenada en Y
     * @param height alto del sprite
     * @param width ancho del sprite
     */
    public SpriteMobile(int x, int y, int height, int width) {
        super(x, y, height, width);
    }

    /**
     * Devuelve el valor actual del paso (step).
     * @return cantidad de pixeles que se mueve
     */
    public int getStep() {
        return step;
    }

    /**
     * Establece el valor del paso (step).
     * @param step cantidad de pixeles que se movera por accion
     */
    public void setStep(int step) {
        this.step = step;
    }
}
