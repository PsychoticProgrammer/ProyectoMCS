
package ventanas;

import Soporte.Dialogs;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Product extends javax.swing.JPanel {

    public Product() {
        initComponents();
        ImageIcon imagenPro= new ImageIcon(this.getClass().getResource("/images/user.png"));
        this.imagenProducto.setIcon(new ImageIcon(imagenPro.getImage().
                getScaledInstance(280,280, Image.SCALE_SMOOTH)));
        this.repaint();
    }
    
    private void validatePurchase(){
        if(PantallaInicial.loggedClient == null){
            Dialogs.informationDialog("Debe Iniciar Sesión para realizar una Compra");
            return;
        }
        if(PantallaInicial.loggedClient.getTarjetaCredito().equals("")){
            Dialogs.warningMessageDialog("Debe proporcionar un Método de Pago");
            return;
        }
        Dialogs.informationDialog("Compra Realizada");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenProducto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbtnComprar = new javax.swing.JButton();

        setBackground(new java.awt.Color(252, 247, 247));
        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre Producto ");

        jLabel2.setFont(new java.awt.Font("Comfortaa", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("$10.00");

        jLabel3.setFont(new java.awt.Font("Cantarell Light", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Disponibles: 8");

        jbtnComprar.setBackground(new java.awt.Color(204, 204, 0));
        jbtnComprar.setFont(new java.awt.Font("Cantarell", 1, 20)); // NOI18N
        jbtnComprar.setForeground(new java.awt.Color(0, 0, 0));
        jbtnComprar.setText("Comprar");
        jbtnComprar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtnComprar))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addComponent(imagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jbtnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnComprarActionPerformed
        this.validatePurchase();
    }//GEN-LAST:event_jbtnComprarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imagenProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnComprar;
    // End of variables declaration//GEN-END:variables
}
