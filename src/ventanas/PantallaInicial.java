
package ventanas;

import BDD.CRUDPedidos;
import Soporte.Dialogs;
import Carrito.Carrito;
import Carrito.Favoritos;
import Clases.Cliente;
import Clases.Usuario;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaInicial extends javax.swing.JFrame {
    
    public static PantallaInicial pantallaInicial;
    public boolean logged = false;
    int numeroFilas = 5; //Se obtendrá: (total de productos a mostrar) dividido para 3
    public static Usuario loggedClient;
    public static JPanel panelProductos;
    
    public PantallaInicial(Cliente cliente) {
        initComponents();
        loggedClient = cliente;
        pantallaInicial = this;
        panelProductos = this.jpnlProductos;
        GraphicsEnvironment env =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.setTitle("EMPRESA S.A.");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/images/icono.png")).getImage());
        this.setLabelImage(this.imgLog,"/images/user.png");
        this.setLabelImage(this.logoPrin,"/images/logoPrincipal.png");
        this.btnLog.setVisible(false);
        this.setLabelImage(this.logoPrin,"/images/logoPrincipal.png");
        this.setLabelImage(this.jlblCarrito,"/images/carrito.jpg");
        this.setLabelImage(this.jlblFavoritos,"/images/favorito.png");
        this.hideButtons();
        panels();
    }
    
    private void setLabelImage(JLabel target, String path){
        ImageIcon image = new ImageIcon(this.getClass().getResource(path));
        target.setIcon(new ImageIcon(image.getImage().
                getScaledInstance(target.getWidth(),target.getHeight(),Image.SCALE_SMOOTH)));
    }

    public void panels(){
        for (int i = 0; i < 4; i++) {
            //EVENTUALMENTE REEMPLAZAR i POR EL CODIGO DEL PRODUCTO QUE RECIBE
            jpnlProductos.add(new Product(i+1));           
        }
        jpnlProductos.validate();
        jpnlProductos.repaint();
    }
    
    public void cambiarTextLogBtn(){
        if(logged)
            btnLog.setText("Log out");
        else
            btnLog.setText("Log in");
        btnLog.validate();
        btnLog.repaint();
        btnLog.setVisible(false);
        this.repaint();
    }
    
    public void showAdminButtons(){
        this.btnPrdDev.setVisible(true);
        this.btnAgrAdm.setVisible(true);
        this.btnChgDatos.setVisible(true);
    }
    
    public void showClientButtons(){
        this.jlblCarrito.setVisible(true);
        this.jlblFavoritos.setVisible(true);
        this.btnChgDatos.setVisible(true);
        this.btnPedidos.setVisible(true);
    }
    
    public void hideBuyingButtons(){
        for(int i = 0; i < this.jpnlProductos.getComponentCount(); i++){
            Product p = (Product)this.jpnlProductos.getComponent(i);
            p.hideClientButtons();
        }
    }
    
    public void reloadBuyingButtons(){
        for(int i = 0; i < this.jpnlProductos.getComponentCount(); i++){
            Product p = (Product)this.jpnlProductos.getComponent(i);
            p.showClientButtons();
        }
    }
    
    public void chargeSelectedItems(){
        for(int i = 0; i < this.jpnlProductos.getComponentCount(); i++){
            Product p = (Product)this.jpnlProductos.getComponent(i);
            p.productoEnCarrito();
            p.productoEnFavoritos();
        }
    }
    
    private void hideButtons(){
        this.jlblCarrito.setVisible(false);
        this.jlblFavoritos.setVisible(false);
        this.btnChgDatos.setVisible(false);
        this.btnPedidos.setVisible(false);
        this.btnPrdDev.setVisible(false);
        this.btnAgrAdm.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnPedidos = new javax.swing.JButton();
        btnChgDatos = new javax.swing.JButton();
        logoPrin = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        imgLog = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlblCarrito = new javax.swing.JLabel();
        btnAgrAdm = new javax.swing.JButton();
        btnPrdDev = new javax.swing.JButton();
        jlblFavoritos = new javax.swing.JLabel();
        btnLog = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpnlProductos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EMPRESA S.A.");

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("© 2023 GRUPO 4");

        jButton1.setBackground(new java.awt.Color(0, 51, 204));
        jButton1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Menú");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnPedidos.setBackground(new java.awt.Color(0, 51, 204));
        btnPedidos.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        btnPedidos.setForeground(new java.awt.Color(255, 255, 255));
        btnPedidos.setText("Pedidos");
        btnPedidos.setBorder(null);
        btnPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });

        btnChgDatos.setBackground(new java.awt.Color(0, 51, 204));
        btnChgDatos.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        btnChgDatos.setForeground(new java.awt.Color(255, 255, 255));
        btnChgDatos.setText("Cambiar Datos");
        btnChgDatos.setBorder(null);
        btnChgDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChgDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChgDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChgDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(164, 164, 164))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(logoPrin, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoPrin, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnChgDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 442, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(24, 24, 24))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 339, 1010);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        imgLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imgLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgLogMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("¡Bienvenido!");

        jlblCarrito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblCarritoMouseClicked(evt);
            }
        });

        btnAgrAdm.setBackground(new java.awt.Color(51, 51, 51));
        btnAgrAdm.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        btnAgrAdm.setForeground(new java.awt.Color(255, 255, 255));
        btnAgrAdm.setText("Agregar admin");
        btnAgrAdm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAgrAdm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgrAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgrAdmActionPerformed(evt);
            }
        });

        btnPrdDev.setBackground(new java.awt.Color(51, 51, 51));
        btnPrdDev.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        btnPrdDev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrdDev.setText("Productos devueltos");
        btnPrdDev.setBorder(null);
        btnPrdDev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrdDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrdDevActionPerformed(evt);
            }
        });

        jlblFavoritos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblFavoritosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 590, Short.MAX_VALUE)
                .addComponent(btnPrdDev, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgrAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jlblFavoritos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlblCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(imgLog, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnPrdDev, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgrAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlblFavoritos, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(340, 0, 1570, 100);

        btnLog.setBackground(new java.awt.Color(204, 204, 204));
        btnLog.setFont(new java.awt.Font("Cantarell", 1, 22)); // NOI18N
        btnLog.setText("Log in");
        btnLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });
        jPanel1.add(btnLog);
        btnLog.setBounds(1770, 100, 120, 36);

        jLabel4.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 56)); // NOI18N
        jLabel4.setText("¡Productos para todos!");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(810, 120, 690, 80);

        jScrollPane1.setBorder(null);

        jpnlProductos.setBackground(new java.awt.Color(255, 255, 255));
        jpnlProductos.setLayout(new java.awt.GridLayout(numeroFilas, 3, 60, 60));
        jScrollPane1.setViewportView(jpnlProductos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(420, 230, 1490, 780);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1914, 1005);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void imgLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgLogMouseClicked
        if(btnLog.isVisible()){
            btnLog.setVisible(false);         
        }else{
            btnLog.setVisible(true);
        }
    }//GEN-LAST:event_imgLogMouseClicked
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        generarPedidos();
    }//GEN-LAST:event_btnPedidosActionPerformed
    
    public void generarPedidos(){
        if(logged){            
            CRUDPedidos cp = new CRUDPedidos();
            
            if(PantallaInicial.loggedClient.getPerfil().equals("C"))
                this.numeroFilas = cp.numeroPedidosCliente(PantallaInicial.loggedClient.getCedula());
            else
                this.numeroFilas = cp.numeroPedidosAdmin();
            
            this.jpnlProductos.removeAll();
            if(this.numeroFilas != 0){
                ArrayList<ArrayList<String[]>> detallesPedidos;
                if(PantallaInicial.loggedClient.getPerfil().equals("C"))
                    detallesPedidos = cp.getPedidosCliente(PantallaInicial.loggedClient.getCedula());
                else
                    detallesPedidos = cp.getPedidosAdmin();
                for (int i = 0; i < detallesPedidos.size(); i++) {
                    this.jpnlProductos.add(new Pedidos(detallesPedidos.get(i),
                                                        PantallaInicial.loggedClient.getPerfil()));
                }
            }else{
                this.jpnlProductos.add(new JLabel("<html><span style='font-size:22px'>"+"Por ahora, no existen pedidos."+"</span></html>"));
            }                
            this.jpnlProductos.revalidate();
            this.jpnlProductos.repaint();
            this.repaint();
            
        }else{
            Dialogs.informationDialog("Debe Iniciar Sesión para visualizar los pedidos.");
        }
    }
    
    
    private void btnChgDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChgDatosActionPerformed
        if(logged){
            ModifyUser mod=  new ModifyUser(this);
            mod.setVisible(true);
        }
    }//GEN-LAST:event_btnChgDatosActionPerformed

    private void jlblCarritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblCarritoMouseClicked
        Carrito cr = new Carrito();
        cr.setVisible(true);
    }//GEN-LAST:event_jlblCarritoMouseClicked

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        if(logged){
            loggedClient = null;
            this.logged = false;
            this.cambiarTextLogBtn();
            this.reloadBuyingButtons();
            this.hideButtons();
            //this.repaint();
            return;
        }
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_btnLogActionPerformed
        
    private void btnAgrAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrAdmActionPerformed
        if(RegistroForm.registro == null){
            RegistroForm.registro = new RegistroForm(this);
        }
        this.setVisible(false);
        RegistroForm.registro.setVisible(true);
    }//GEN-LAST:event_btnAgrAdmActionPerformed

    private void btnPrdDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrdDevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrdDevActionPerformed

    private void jlblFavoritosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblFavoritosMouseClicked
        Favoritos fav = new Favoritos();
        fav.setVisible(true);
    }//GEN-LAST:event_jlblFavoritosMouseClicked

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
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaInicial(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgrAdm;
    private javax.swing.JButton btnChgDatos;
    private javax.swing.JButton btnLog;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnPrdDev;
    private javax.swing.JLabel imgLog;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlblCarrito;
    private javax.swing.JLabel jlblFavoritos;
    private javax.swing.JPanel jpnlProductos;
    private javax.swing.JLabel logoPrin;
    // End of variables declaration//GEN-END:variables
}
