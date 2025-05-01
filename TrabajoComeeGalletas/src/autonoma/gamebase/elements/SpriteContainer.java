package autonoma.gamebase.elements;

import java.util.ArrayList;

/**
 * Clase abstracta que representa un contenedor de sprites.
 * Hereda de Sprite e implementa la interfaz GraphicContainer.
 * Puede contener y administrar multiples sprites dentro de si.
 */
public abstract class SpriteContainer extends Sprite implements GraphicContainer {

    // Lista de sprites contenidos
    protected ArrayList<Sprite> sprites;

    /**
     * Constructor del contenedor con posicion y tamaño inicial.
     * @param x coordenada en X
     * @param y coordenada en Y
     * @param height alto del contenedor
     * @param width ancho del contenedor
     */
    public SpriteContainer(int x, int y, int height, int width) {
        super(x, y, height, width);
        sprites = new ArrayList<Sprite>();
    }

    /**
     * Agrega un sprite al contenedor.
     * @param sprite el sprite a agregar
     * @return true si fue agregado correctamente
     */
    public boolean add(Sprite sprite) {
        return sprites.add(sprite);
    }

    /**
     * Elimina un sprite del contenedor segun su indice.
     * @param index posicion del sprite en la lista
     */
    public void remove(int index) {
        sprites.remove(index);
    }

    /**
     * Elimina un sprite especifico del contenedor.
     * @param sprite el sprite a eliminar
     */
    public void remove(Sprite sprite) {
        sprites.remove(sprite);
    }

    /**
     * Devuelve el numero de sprites contenidos.
     * @return cantidad de sprites
     */
    public int size() {
        return sprites.size();
    }
}
