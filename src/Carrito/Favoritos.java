
package Carrito;

import BDD.CRUDCarrito;
import Soporte.Dialogs;
import java.awt.GridLayout;
import java.util.ArrayList;
import ventanas.PantallaInicial;

public class Favoritos extends javax.swing.JFrame {

    private CRUDCarrito baseDatos;
    public static Favoritos productosCarrito;
    
    public Favoritos() {
        initComponents();
        this.setLocationRelativeTo(null);
        productosCarrito = this;
        this.jbtnComprar.setVisible(false);
        this.baseDatos = new CRUDCarrito();
        this.initPanelProductos();
    }
    
    public void initPanelProductos(){
        this.jpnlProductos.removeAll();
        this.jpnlProductos.updateUI();
        ArrayList<String[]> productos = this.baseDatos.readProductosCarrito();
        if(productos == null){
            return;
        }
        this.jbtnComprar.setVisible(true);
        this.jpnlProductos.setLayout(new GridLayout(productos.size(),1));
        for(int i = 0; i < productos.size(); i++){
            this.jpnlProductos.add(new ItemFavorito(productos.get(i),this));
        }
    }
    
    private void comprarProductos(){
        for(int i = 0; i < this.jpnlProductos.getComponentCount(); i++){
            ((ItemCarrito)this.jpnlProductos.getComponent(i)).comprarProducto();
        }
    }
    
    private void reservarProductos(){
        for(int i = 0; i < this.jpnlProductos.getComponentCount(); i++){
            ((ItemCarrito)this.jpnlProductos.getComponent(i)).reservarProducto();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbtnComprar = new javax.swing.JButton();
        jbtnAtras = new javax.swing.JButton();
        jscpProductos = new javax.swing.JScrollPane();
        jpnlProductos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Favoritos");

        jbtnComprar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtnComprar.setText("Ir al Carrito");
        jbtnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnComprarActionPerformed(evt);
            }
        });

        jbtnAtras.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtnAtras.setText("Atras");
        jbtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlProductosLayout = new javax.swing.GroupLayout(jpnlProductos);
        jpnlProductos.setLayout(jpnlProductosLayout);
        jpnlProductosLayout.setHorizontalGroup(
            jpnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );
        jpnlProductosLayout.setVerticalGroup(
            jpnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        jscpProductos.setViewportView(jpnlProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jscpProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(171, 171, 171)
                        .addComponent(jbtnComprar)
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbtnComprar)
                    .addComponent(jbtnAtras))
                .addGap(18, 18, 18)
                .addComponent(jscpProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAtrasActionPerformed
        this.reservarProductos();
        this.dispose();
    }//GEN-LAST:event_jbtnAtrasActionPerformed

    private void jbtnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnComprarActionPerformed
        if(PantallaInicial.loggedClient.getTarjetaCredito().equals("")){
            Dialogs.warningMessageDialog("Debe proporcionar un Método de Pago");
            return;
        }
        if(PantallaInicial.loggedClient.getDireccion().equals("")){
            Dialogs.warningMessageDialog("Debe proporcionar una Dirección de Envío");
            return;
        }
        this.comprarProductos();
        this.jpnlProductos.removeAll();
        this.jpnlProductos.updateUI();
        PantallaInicial.loggedClient.getCarrito().removeAll(PantallaInicial.loggedClient.getCarrito());
        this.jbtnComprar.setVisible(false);
        Dialogs.informationDialog("Compra Realizada");
    }//GEN-LAST:event_jbtnComprarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carrito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtnAtras;
    private javax.swing.JButton jbtnComprar;
    private javax.swing.JPanel jpnlProductos;
    private javax.swing.JScrollPane jscpProductos;
    // End of variables declaration//GEN-END:variables
}
