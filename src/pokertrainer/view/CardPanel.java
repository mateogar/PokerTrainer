/*
 * Copyright (c) 2017, Aarón Durán Sánchez,Javier López de Lerma, Mateo García Fuentes, Carlos López Martínez 
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package pokertrainer.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;

/**
 * Clase de la vista encargada que crea y muestra el panel de las cartas.
 * @author Javi
 */
public class CardPanel extends javax.swing.JPanel {

    private ImageIcon card;
    private Image rescaledCard;
    private static final int CARD_HEIGHT = 64;
    private static final int CARD_WIDTH = 54;
    private static final ImageIcon DEFAULTCARD = new ImageIcon(CardPanel.class.getResource("img/behindCard.png"));

    /**
     * Constructor que crea un JPanel para la carta por defecto.
     */
    public CardPanel() {
        
        this(DEFAULTCARD);
    }
    
    /**
     * Constructor que crea un JPanel para la carta recibida por parámetro.
     * @param card Imagen de la carta a mostrar.
     */
    public CardPanel(ImageIcon card) {
        this.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));
        this.card = card;
        this.rescaledCard = card.getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_DEFAULT);
    }
    
    /**
     * Devuelve la imagen de la carta del JPanel. 
     */   
    public ImageIcon getCard(){
        return card;
    }
    
    /**
     * Devuelve la imagen de la carta con el tamaño adecuado.
     */
    public Image getRescaledCard(){
        return rescaledCard;
    }
    
    /**
     * Establece la imagen de la carta.
     * @param card Imagen de la carta 
     */
    public void setCard(ImageIcon card){
        if(card!=null){
            MediaTracker tracker = new MediaTracker(this);
            tracker.addImage(card.getImage(), 0);
            try {
              tracker.waitForAll();
            } catch (InterruptedException e) {
              System.out.println("Interrupted while loading Image");
            }
            this.card = card;
        }     
    }
    
    /**
     * Muestra el dorso de la carta.
     */
    public void hideCard(){
        this.rescaledCard = DEFAULTCARD.getImage();
        this.repaint();
    }
    
    /**
     * Muestra el haz de la carta.
     */
    public void showCard(){
        this.rescaledCard = card.getImage();
        this.repaint();
    }
    
    @Override
    /**
     * Método que pinta el componente
     * @param g Gráficos del componente a pintar
     */
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(rescaledCard, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Hace invisible el panel.
     */
    void disablePanel() {
        this.setVisible(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
