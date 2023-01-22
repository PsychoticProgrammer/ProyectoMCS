
package Carrito;

import BDD.CRUDCarrito;
import Soporte.Dialogs;
import ventanas.PantallaInicial;

public class ItemCarrito extends javax.swing.JPanel {
    
    private CRUDCarrito baseDatos;
    
    public ItemCarrito(String[] datosProducto){
        initComponents();
        this.baseDatos = new CRUDCarrito();
        this.jspnCantidad.setVisible(false);
        this.jbtnComprar.setText("Comprar");
        this.jlblNombre.setText(datosProducto[0]);
        this.jlblPrecio.setText(datosProducto[1]);
        //this.jlblImagen.setIcon(Cambiar cuando haya fotos del producto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblImagen = new javax.swing.JLabel();
        jlblNombre = new javax.swing.JLabel();
        jlblPrecio = new javax.swing.JLabel();
        jspnCantidad = new javax.swing.JSpinner();
        jbtnComprar = new javax.swing.JButton();

        jlblImagen.setBackground(new java.awt.Color(210, 242, 242));
        jlblImagen.setOpaque(true);

        jlblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlblNombre.setText("jLabel1");

        jlblPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlblPrecio.setText("jLabel1");

        jspnCantidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jbtnComprar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtnComprar.setText("Comprar");
        jbtnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlblNombre)
                .addGap(77, 77, 77)
                .addComponent(jlblPrecio)
                .addGap(62, 62, 62)
                .addComponent(jspnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jbtnComprar)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNombre)
                    .addComponent(jlblPrecio)
                    .addComponent(jspnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnComprar))
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnComprarActionPerformed
        if(PantallaInicial.loggedClient.getTarjetaCredito().equals("")){
            Dialogs.warningMessageDialog("Debe proporcionar un Método de Pago");
            return;
        }
        if(PantallaInicial.loggedClient.getDireccion().equals("")){
            Dialogs.warningMessageDialog("Debe proporcionar una Dirección de Envío");
            return;
        }
        Dialogs.informationDialog("Compra realizada");
    }//GEN-LAST:event_jbtnComprarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnComprar;
    private javax.swing.JLabel jlblImagen;
    private javax.swing.JLabel jlblNombre;
    private javax.swing.JLabel jlblPrecio;
    private javax.swing.JSpinner jspnCantidad;
    // End of variables declaration//GEN-END:variables
}
