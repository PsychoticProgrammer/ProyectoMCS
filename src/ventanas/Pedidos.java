/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author sebastchan
 */
public class Pedidos extends javax.swing.JPanel {

    /**
     * Creates new form Pedidos
     */
    public Pedidos(String numPedido, String fecha, String estado, String producto, String total) {
        initComponents();
        ImageIcon imagenProducto= new ImageIcon(this.getClass().getResource("/images/user.png"));
        this.imgPedido.setIcon(new ImageIcon(imagenProducto.getImage().
                getScaledInstance(250, 250, Image.SCALE_DEFAULT)));
        this.numPedidoText.setText(numPedido);
        this.fechaText.setText(fecha);
        this.estadoText.setText(estado);
        this.detalleText.setText(producto);
        this.totalText.setText(total);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgPedido = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        fechaText = new javax.swing.JLabel();
        numPedidoLabel = new javax.swing.JLabel();
        numPedidoText = new javax.swing.JLabel();
        estadoLabel = new javax.swing.JLabel();
        estadoText = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        totalText = new javax.swing.JLabel();
        detalleLabel = new javax.swing.JLabel();
        detalleText = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        imgPedido.setForeground(new java.awt.Color(204, 102, 255));

        fechaLabel.setFont(new java.awt.Font("Cantarell", 1, 30)); // NOI18N
        fechaLabel.setForeground(new java.awt.Color(0, 0, 0));
        fechaLabel.setText("Fecha:");

        fechaText.setFont(new java.awt.Font("Cantarell", 0, 30)); // NOI18N
        fechaText.setForeground(new java.awt.Color(0, 0, 0));
        fechaText.setText("23/01/2023");

        numPedidoLabel.setFont(new java.awt.Font("Cantarell", 1, 30)); // NOI18N
        numPedidoLabel.setForeground(new java.awt.Color(0, 0, 0));
        numPedidoLabel.setText("N. Pedido:");

        numPedidoText.setFont(new java.awt.Font("Cantarell", 0, 30)); // NOI18N
        numPedidoText.setForeground(new java.awt.Color(0, 0, 0));
        numPedidoText.setText("10");

        estadoLabel.setFont(new java.awt.Font("Cantarell", 1, 30)); // NOI18N
        estadoLabel.setForeground(new java.awt.Color(0, 0, 0));
        estadoLabel.setText("Estado:");

        estadoText.setFont(new java.awt.Font("Cantarell", 0, 30)); // NOI18N
        estadoText.setForeground(new java.awt.Color(0, 0, 0));
        estadoText.setText("Pagado");

        totalLabel.setFont(new java.awt.Font("Cantarell", 1, 30)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(0, 0, 0));
        totalLabel.setText("TOTAL:");

        totalText.setFont(new java.awt.Font("Cantarell", 0, 30)); // NOI18N
        totalText.setForeground(new java.awt.Color(0, 0, 0));
        totalText.setText("$10");

        detalleLabel.setFont(new java.awt.Font("Cantarell", 1, 30)); // NOI18N
        detalleLabel.setForeground(new java.awt.Color(0, 0, 0));
        detalleLabel.setText("Detalle:");

        detalleText.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        detalleText.setForeground(new java.awt.Color(0, 0, 0));
        detalleText.setText("<html><body>- Producto 1 <br>- Producto 2<br> - Producto 3 </body></html>");
        detalleText.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(imgPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numPedidoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numPedidoText, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(estadoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(estadoText, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fechaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaText, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detalleLabel)
                        .addGap(452, 452, 452))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(detalleText, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalText, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(detalleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detalleText, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(numPedidoLabel)
                                .addComponent(numPedidoText))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fechaLabel)
                                .addComponent(fechaText))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(estadoLabel)
                                .addComponent(estadoText)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(imgPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(totalText))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel detalleLabel;
    private javax.swing.JLabel detalleText;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JLabel estadoText;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JLabel fechaText;
    private javax.swing.JLabel imgPedido;
    private javax.swing.JLabel numPedidoLabel;
    private javax.swing.JLabel numPedidoText;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalText;
    // End of variables declaration//GEN-END:variables
}
