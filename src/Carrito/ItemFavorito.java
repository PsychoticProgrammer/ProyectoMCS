
package Carrito;

import BDD.CRUDCarrito;
import BDD.CRUDFavoritos;
import Clases.Cliente;
import ventanas.PantallaInicial;
import ventanas.Product;

public class ItemFavorito extends javax.swing.JPanel {
    
    private CRUDCarrito baseDatos;
    private CRUDFavoritos baseDatosFavoritos;
    private int codigoProducto, unidades;
    private Favoritos padre;
    
    public ItemFavorito(String[] datosProducto, Favoritos padre){
        initComponents();
        this.baseDatos = new CRUDCarrito();
        this.baseDatosFavoritos = new CRUDFavoritos();
        this.codigoProducto = Integer.parseInt(datosProducto[0]);
        this.jlblNombre.setText(datosProducto[1]);
        this.jlblPrecio.setText(datosProducto[2]);
        //this.jlblImagen.setIcon(Cambiar cuando haya fotos del producto);
        this.padre = padre;
    }
    
    public int getCodigoProducto(){
        return this.codigoProducto;
    }
        
    public void reservarProducto(){
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblImagen = new javax.swing.JLabel();
        jlblNombre = new javax.swing.JLabel();
        jlblPrecio = new javax.swing.JLabel();
        jbtnEliminar = new javax.swing.JButton();
        jbtnCarrito = new javax.swing.JButton();

        jlblImagen.setBackground(new java.awt.Color(210, 242, 242));
        jlblImagen.setOpaque(true);

        jlblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlblNombre.setText("jLabel1");

        jlblPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlblPrecio.setText("jLabel1");

        jbtnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jbtnCarrito.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtnCarrito.setText("<html><center>Agregar al Carrito</center></html>");
        jbtnCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCarritoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlblNombre)
                .addGap(77, 77, 77)
                .addComponent(jlblPrecio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jbtnCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jbtnEliminar)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblNombre)
                            .addComponent(jlblPrecio)
                            .addComponent(jbtnEliminar))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jbtnCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        ((Cliente)PantallaInicial.loggedClient).getFavoritos().remove((Object)this.codigoProducto);
        this.baseDatosFavoritos.deleteProductoFavorito(this.codigoProducto);
        for(int i = 0; i < PantallaInicial.panelProductos.getComponentCount(); i++){
            Product p = (Product)PantallaInicial.panelProductos.getComponent(i);
            if(p.getCodigoProducto() == this.codigoProducto){
                p.productoRetiradoFavoritos();
                this.padre.initPanelProductos();
                return;
            }
        }
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCarritoActionPerformed
        ((Cliente)PantallaInicial.loggedClient).getFavoritos().remove((Object)this.codigoProducto);
        ((Cliente)PantallaInicial.loggedClient).setProductoCarrito(this.codigoProducto);
        this.baseDatosFavoritos.agregarAlCarrito(this.codigoProducto);
        for(int i = 0; i < PantallaInicial.panelProductos.getComponentCount(); i++){
            Product p = (Product)PantallaInicial.panelProductos.getComponent(i);
            if(p.getCodigoProducto() == this.codigoProducto){
                p.productoRetiradoFavoritos();
                p.productoEnCarrito();
                this.padre.initPanelProductos();
                return;
            }
        }
    }//GEN-LAST:event_jbtnCarritoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnCarrito;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JLabel jlblImagen;
    private javax.swing.JLabel jlblNombre;
    private javax.swing.JLabel jlblPrecio;
    // End of variables declaration//GEN-END:variables
}
