/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tragamonedas;

/**
 *
 * @author mateo
 */


import javax.swing.ImageIcon;


public class Figura extends Thread {
    boolean stopThreads;
    int rollo;
    int identificador;
        
    /**
     *
     * @param rollo
     */
    //se pone que rollo representa la figura y si ahi que ejecutarlo
    public Figura(int rollo, boolean stopThreads) {
        this.rollo = rollo;
        this.stopThreads = stopThreads; // Inicializa la variable
    }

    @Override
    public void run() {
        while (!stopThreads) {
        // Código para cambiar la imagen
        int numero = (int) (Math.random() * 4 + 1);
        this.identificador = numero;
        String ruta = "src\\Imagenes\\" + numero + ".png";
        ImageIcon imageIcon = new ImageIcon(ruta);
        
        switch (this.rollo) {
            case 1 -> tragamonedas.Interfaz.Rodillo1.setIcon(imageIcon);
            case 2 -> tragamonedas.Interfaz.Rodillo2.setIcon(imageIcon);
            case 3 -> tragamonedas.Interfaz.Rodillo3.setIcon(imageIcon);
        }

        // Tiempo en milisegundos entre cada cambio de imagen
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            // Si el hilo se interrumpe durante el sueño, salimos del bucle
            Thread.currentThread().interrupt(); // Restablece el estado de interrupción
            break;
        }
    }
}
        // Método para detener el hilo
        public void detener() {
        stopThreads = true; 
    }
        public String getNombre(){
        return null;
}
}


