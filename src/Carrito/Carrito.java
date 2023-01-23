
package Carrito;

import BDD.CRUDCarrito;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import ventanas.PantallaInicial;

public class Carrito extends javax.swing.JFrame {

    private CRUDCarrito baseDatos;
    
    public Carrito() {
        initComponents();
        this.jbtnComprar.setVisible(false);
        this.setLocationRelativeTo(null);
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
        this.jpnlProductos.setLayout(new GridLayout(productos.size(),1));
        for(int i = 0; i < productos.size(); i++){
            this.jpnlProductos.add(new ItemCarrito(productos.get(i),this));
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
        jLabel1.setText("Carrito");

        jbtnComprar.setText("Comprar");

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
            .addGap(0, 634, Short.MAX_VALUE)
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
                        .addComponent(jscpProductos)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnAtras)
                        .addGap(199, 199, 199)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jscpProductos)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAtrasActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtnAtrasActionPerformed

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
