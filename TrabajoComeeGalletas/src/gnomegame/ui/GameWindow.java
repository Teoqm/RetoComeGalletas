/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnomegame.ui;


import autonoma.gamebase.elements.GraphicContainer;
import autonoma.trabjocomeegalletas.elements.Mapa;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author educacion
 */
public class GameWindow extends javax.swing.JFrame 
                        implements GraphicContainer {

    protected Mapa mapa;
    
    /**
     * Creates new form GameWindow
     */
    public GameWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_Q)
        {
            System.exit(0);
        }
        
        
        if(evt.getKeyCode() == KeyEvent.VK_G)
        {
            mapa.keyPressed(evt.getKeyCode());
        }

    }//GEN-LAST:event_formKeyPressed

    public void setGarden(Mapa mapa) {
        this.mapa = mapa;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
    
        if(mapa != null)
            mapa.paint(g);
    }

    @Override
    public void refresh() {
        this.repaint();
    }

    @Override
    public Rectangle getBoundaries() {
        return this.getBounds();
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
