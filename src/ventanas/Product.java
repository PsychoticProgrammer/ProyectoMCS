
package ventanas;

import BDD.CRUDCarrito;
import BDD.Conexion;
import Soporte.Dialogs;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Product extends javax.swing.JPanel {

    private CRUDCarrito baseDatos;
    private int codigoProducto;
    
    public Product(int codigoProducto) {
        initComponents();
        this.codigoProducto = codigoProducto;
        this.baseDatos = new CRUDCarrito();
        ImageIcon imagenPro= new ImageIcon(this.getClass().getResource("/images/user.png"));
        this.imagenProducto.setIcon(new ImageIcon(imagenPro.getImage().
                getScaledInstance(280,280, Image.SCALE_SMOOTH)));
        this.repaint();
    }
    
    public int getCodigoProducto(){
        return this.codigoProducto;
    }
    
    private boolean validatePurchase(){
        if(PantallaInicial.loggedClient == null){
            Dialogs.informationDialog("Debe Iniciar Sesión para realizar una Compra");
            return false;
        }
        return true;
    }
    
    public void productoEnCarrito(){
        if(this.baseDatos.estaEnCarrito(this.codigoProducto)){
            this.jtbtnCarrito.setText("<html><center>Quitar del Carrito</center></html>");
            this.jtbtnCarrito.setSelected(true);
        }
    }
    
    public void productoRetiradoCarrito(){
        this.jtbtnCarrito.setText("<html><center>Quitar del Carrito</center></html>");
        this.jtbtnCarrito.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenProducto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtbtnCarrito = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(252, 247, 247));
        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 28)); // NOI18N
        jLabel1.setText("Nombre Producto ");

        jLabel2.setFont(new java.awt.Font("Comfortaa", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("$10.00");

        jLabel3.setFont(new java.awt.Font("Cantarell Light", 0, 18)); // NOI18N
        jLabel3.setText("Disponibles: 8");

        jtbtnCarrito.setBackground(new java.awt.Color(204, 204, 0));
        jtbtnCarrito.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtbtnCarrito.setText("<html><center>Agregar al Carrito</center></html>");
        jtbtnCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbtnCarritoActionPerformed(evt);
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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(23, 23, 23))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtbtnCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtbtnCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtbtnCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbtnCarritoActionPerformed
        if(this.jtbtnCarrito.isSelected()&& this.validatePurchase()){
            this.baseDatos.createProductoCarrito(this.codigoProducto);
            this.jtbtnCarrito.setText("<html><center>Quitar del Carrito</center></html>");
            return;
        } else if(!this.jtbtnCarrito.isSelected() && this.validatePurchase()){
            this.baseDatos.deleteProductosCarrito(this.codigoProducto,1);
            this.jtbtnCarrito.setText("<html><center>Agregar al Carrito</center></html>");
            return;
        }
        this.jtbtnCarrito.setSelected(false);
    }//GEN-LAST:event_jtbtnCarritoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imagenProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToggleButton jtbtnCarrito;
    // End of variables declaration//GEN-END:variables
}
