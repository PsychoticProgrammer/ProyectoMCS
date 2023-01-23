
package Carrito;

import BDD.CRUDCarrito;
import ventanas.PantallaInicial;
import ventanas.Product;

public class ItemCarrito extends javax.swing.JPanel {
    
    private CRUDCarrito baseDatos;
    private int codigoProducto;
    private Carrito padre;
    
    public ItemCarrito(String[] datosProducto, Carrito padre){
        initComponents();
        this.baseDatos = new CRUDCarrito();
        this.jspnCantidad.setVisible(false);
        this.codigoProducto = Integer.parseInt(datosProducto[0]);
        this.jlblNombre.setText(datosProducto[1]);
        this.jlblPrecio.setText(datosProducto[2]);
        //this.jlblImagen.setIcon(Cambiar cuando haya fotos del producto);
        this.padre = padre;
    }
    
    public int getCodigoProducto(){
        return this.codigoProducto;
    }
    
    public void comprarProducto(){
        this.baseDatos.comprarProductosCarrito(this.codigoProducto,1);
        for(int i = 0; i < PantallaInicial.panelProductos.getComponentCount(); i++){
            Product p = (Product)PantallaInicial.panelProductos.getComponent(i);
            if(p.getCodigoProducto() == this.codigoProducto){
                p.productoRetiradoCarrito();
                return;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblImagen = new javax.swing.JLabel();
        jlblNombre = new javax.swing.JLabel();
        jlblPrecio = new javax.swing.JLabel();
        jspnCantidad = new javax.swing.JSpinner();
        jbtnEliminar = new javax.swing.JButton();

        jlblImagen.setBackground(new java.awt.Color(210, 242, 242));
        jlblImagen.setOpaque(true);

        jlblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlblNombre.setText("jLabel1");

        jlblPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlblPrecio.setText("jLabel1");

        jspnCantidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jbtnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jbtnEliminar)
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
                    .addComponent(jbtnEliminar))
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        PantallaInicial.loggedClient.getCarrito().remove((Object)this.codigoProducto);
        this.baseDatos.deleteProductosCarrito(this.codigoProducto,1);
        for(int i = 0; i < PantallaInicial.panelProductos.getComponentCount(); i++){
            Product p = (Product)PantallaInicial.panelProductos.getComponent(i);
            if(p.getCodigoProducto() == this.codigoProducto){
                p.productoRetiradoCarrito();
                this.padre.initPanelProductos();
                return;
            }
        }
    }//GEN-LAST:event_jbtnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JLabel jlblImagen;
    private javax.swing.JLabel jlblNombre;
    private javax.swing.JLabel jlblPrecio;
    private javax.swing.JSpinner jspnCantidad;
    // End of variables declaration//GEN-END:variables
}
