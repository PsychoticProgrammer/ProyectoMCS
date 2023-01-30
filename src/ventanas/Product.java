
package ventanas;

import BDD.CRUDCarrito;
import BDD.CRUDFavoritos;
import Carrito.Carrito;
import Carrito.Favoritos;
import Soporte.Dialogs;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class Product extends javax.swing.JPanel {

    private CRUDCarrito baseDatos;
    private CRUDFavoritos baseDatosFavoritos;
    private int codigoProducto;
    
    public Product(int codigoProducto) {
        initComponents();
        this.codigoProducto = codigoProducto;
        this.baseDatos = new CRUDCarrito();
        this.baseDatosFavoritos = new CRUDFavoritos();
        ImageIcon imagenPro= new ImageIcon(this.getClass().getResource("/images/user.png"));
        this.imagenProducto.setIcon(new ImageIcon(imagenPro.getImage().
                getScaledInstance(280,280, Image.SCALE_SMOOTH)));
        this.repaint();
        this.setImage(this.jtbtnCarrito,"/images/agregarCarrito.png");
        this.setImage(this.jtbtnFavorito,"/images/favoritont.png");
    }
    
    public int getCodigoProducto(){
        return this.codigoProducto;
    }
    
    private void setImage(JToggleButton boton, String path){
        boton.setIcon(null);
        ImageIcon image = new ImageIcon(this.getClass().getResource(path));
        Icon icon =  new ImageIcon(image.getImage().getScaledInstance(
                58,49,Image.SCALE_SMOOTH));
        boton.setIcon(icon);
        boton.repaint();
    }
    
    private boolean validateLogged(){
        if(PantallaInicial.loggedClient == null){
            Dialogs.informationDialog("Debe Iniciar Sesión para realizar esta Acción");
            return false;
        }
        return true;
    }
    
    public void productoEnCarrito(){
        if(this.baseDatos.estaEnCarrito(this.codigoProducto)){
            this.setImage(this.jtbtnCarrito,"/images/quitarCarrito.png");
            this.jtbtnCarrito.setSelected(true);
        }
    }
    
    public void productoRetiradoCarrito(){
        this.setImage(this.jtbtnCarrito,"/images/agregarCarrito.png");
        this.jtbtnCarrito.setSelected(false);
    }
    
    public void productoEnFavoritos(){
        if(this.baseDatosFavoritos.isFavorito(this.codigoProducto)){
            this.setImage(this.jtbtnFavorito,"/images/favorito.png");
            this.jtbtnFavorito.setSelected(true);
        }
    }
    
    public void productoRetiradoFavoritos(){
        this.setImage(this.jtbtnFavorito,"/images/favoritont.png");
        this.jtbtnFavorito.setSelected(false);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenProducto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtbtnCarrito = new javax.swing.JToggleButton();
        jtbtnFavorito = new javax.swing.JToggleButton();

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
        jtbtnCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbtnCarritoActionPerformed(evt);
            }
        });

        jtbtnFavorito.setBackground(new java.awt.Color(204, 204, 0));
        jtbtnFavorito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbtnFavoritoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtbtnFavorito, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtbtnCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtbtnCarrito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtbtnFavorito, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtbtnCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbtnCarritoActionPerformed
        if(this.jtbtnCarrito.isSelected()&& this.validateLogged()){
            this.baseDatos.createProductoCarrito(this.codigoProducto);
            if(Carrito.productosCarrito != null && Carrito.productosCarrito.isVisible()){
                Carrito.productosCarrito.initPanelProductos();
            }
            this.setImage(this.jtbtnCarrito,"/images/quitarCarrito.png");
            return;
        } else if(!this.jtbtnCarrito.isSelected() && this.validateLogged()){
           int unidades = this.baseDatos.readCantidadUnidades(this.codigoProducto);
            if(unidades == -1){
                return;
            }
            this.baseDatos.deleteProductosCarrito(this.codigoProducto,unidades);
            if(Carrito.productosCarrito != null && Carrito.productosCarrito.isVisible() ){
                Carrito.productosCarrito.initPanelProductos();
            }
            this.setImage(this.jtbtnCarrito,"/images/agregarCarrito.png");
            return;
        }
        this.jtbtnCarrito.setSelected(false);
    }//GEN-LAST:event_jtbtnCarritoActionPerformed

    private void jtbtnFavoritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbtnFavoritoActionPerformed
        if(this.jtbtnFavorito.isSelected() && this.validateLogged()){
            this.baseDatosFavoritos.createProductoFavorito(this.codigoProducto);
            if(Favoritos.productosFavoritos != null && Favoritos.productosFavoritos.isVisible()){
                Favoritos.productosFavoritos.initPanelProductos();
            }
            this.setImage(this.jtbtnFavorito,"/images/favorito.png");
            return;
        } else if(!this.jtbtnFavorito.isSelected() && this.validateLogged()){

            this.baseDatosFavoritos.deleteProductoFavorito(this.codigoProducto);
            if(Favoritos.productosFavoritos != null && Favoritos.productosFavoritos.isVisible()){
                Favoritos.productosFavoritos.initPanelProductos();
            }
            this.setImage(this.jtbtnFavorito,"/images/favoritont.png");
            return;
        }
        this.jtbtnFavorito.setSelected(false);
    }//GEN-LAST:event_jtbtnFavoritoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imagenProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToggleButton jtbtnCarrito;
    private javax.swing.JToggleButton jtbtnFavorito;
    // End of variables declaration//GEN-END:variables
}
