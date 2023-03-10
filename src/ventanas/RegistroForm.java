
package ventanas;

import BDD.CRUDUsuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RegistroForm extends javax.swing.JFrame {
    
    public static RegistroForm registro;
    private JFrame caller;
    
    public RegistroForm(JFrame caller) {
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
        this.caller = caller;
        this.ingTar.setVisible(false);
        this.jlblTarjeta.setVisible(false);
        this.jsprTarjeta.setVisible(false);
    }

    protected void backToMain(){
        this.setVisible(false);
        this.caller.setVisible(true);
    }
    
    protected void processData(){
        CRUDUsuario dm = new CRUDUsuario();
        String ced=ingCedula.getText();
        String nombre=ingNombre.getText().toUpperCase();
        String apellido=ingApellido.getText().toUpperCase();
        String dir=ingDireccion.getText().toUpperCase();
        String tel=ingTelefono.getText();
        String email=ingEmail.getText().toLowerCase();
        String pass=ingPass.getText();
        ingCedula.setText(null);
        ingNombre.setText(null);
        ingApellido.setText(null);
        ingDireccion.setText(null);
        ingTelefono.setText(null);
        ingEmail.setText(null);
        ingPass.setText(null);
        String perfil = "C";
        if(PantallaInicial.loggedClient != null){
            perfil = "A";
        }
        if(dm.createUsuario(ced,nombre, apellido, dir, tel, email, pass, perfil)){
            JOptionPane.showMessageDialog(rootPane, "Datos guardados correctamente");
            this.backToMain();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Los datos no se han guardado");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ingCedula = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        ingNombre = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        ingApellido = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        ingDireccion = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        ingTelefono = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        ingEmail = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jlblPass = new javax.swing.JLabel();
        ingPass = new javax.swing.JTextField();
        jsprPass = new javax.swing.JSeparator();
        jlblTarjeta = new javax.swing.JLabel();
        ingTar = new javax.swing.JTextField();
        jsprTarjeta = new javax.swing.JSeparator();
        btnRegistro = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REGISTRO");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CEDULA:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        ingCedula.setBackground(new java.awt.Color(51, 51, 51));
        ingCedula.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        ingCedula.setForeground(new java.awt.Color(255, 255, 255));
        ingCedula.setBorder(null);
        jPanel1.add(ingCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 241, 30));

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 240, 10));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NOMBRE:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        ingNombre.setBackground(new java.awt.Color(51, 51, 51));
        ingNombre.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        ingNombre.setForeground(new java.awt.Color(255, 255, 255));
        ingNombre.setBorder(null);
        jPanel1.add(ingNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 241, 30));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 240, 10));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("APELLIDO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        ingApellido.setBackground(new java.awt.Color(51, 51, 51));
        ingApellido.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        ingApellido.setForeground(new java.awt.Color(255, 255, 255));
        ingApellido.setBorder(null);
        jPanel1.add(ingApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 241, 30));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 240, 10));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DIRECCION:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        ingDireccion.setBackground(new java.awt.Color(51, 51, 51));
        ingDireccion.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        ingDireccion.setForeground(new java.awt.Color(255, 255, 255));
        ingDireccion.setBorder(null);
        jPanel1.add(ingDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 241, 30));

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 240, 10));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TELEFONO:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        ingTelefono.setBackground(new java.awt.Color(51, 51, 51));
        ingTelefono.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        ingTelefono.setForeground(new java.awt.Color(255, 255, 255));
        ingTelefono.setBorder(null);
        jPanel1.add(ingTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 241, 30));

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 240, 10));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CORREO ELECTR??NICO:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, -1, -1));

        ingEmail.setBackground(new java.awt.Color(51, 51, 51));
        ingEmail.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        ingEmail.setForeground(new java.awt.Color(255, 255, 255));
        ingEmail.setBorder(null);
        jPanel1.add(ingEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 241, 30));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 240, 10));

        jlblPass.setBackground(new java.awt.Color(255, 255, 255));
        jlblPass.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlblPass.setForeground(new java.awt.Color(255, 255, 255));
        jlblPass.setText("CONTRASE??A:");
        jPanel1.add(jlblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, -1, -1));

        ingPass.setBackground(new java.awt.Color(51, 51, 51));
        ingPass.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        ingPass.setForeground(new java.awt.Color(255, 255, 255));
        ingPass.setBorder(null);
        jPanel1.add(ingPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 241, 30));

        jsprPass.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jsprPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 580, 240, 10));

        jlblTarjeta.setBackground(new java.awt.Color(255, 255, 255));
        jlblTarjeta.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlblTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        jlblTarjeta.setText("TARJETA CREDITO O DEBITO:");
        jPanel1.add(jlblTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 600, -1, -1));

        ingTar.setBackground(new java.awt.Color(51, 51, 51));
        ingTar.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        ingTar.setForeground(new java.awt.Color(255, 255, 255));
        ingTar.setBorder(null);
        ingTar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingTarActionPerformed(evt);
            }
        });
        jPanel1.add(ingTar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, 241, 30));

        jsprTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jsprTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 650, 240, 10));

        btnRegistro.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        btnRegistro.setText("REGISTRARSE");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 730, -1, 40));

        btnBack.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        btnBack.setText("VOLVER");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 740, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.backToMain();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        this.processData();
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void ingTarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingTarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingTarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new RegistroForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    protected javax.swing.JButton btnRegistro;
    protected javax.swing.JTextField ingApellido;
    protected javax.swing.JTextField ingCedula;
    protected javax.swing.JTextField ingDireccion;
    protected javax.swing.JTextField ingEmail;
    protected javax.swing.JTextField ingNombre;
    protected javax.swing.JTextField ingPass;
    protected javax.swing.JTextField ingTar;
    protected javax.swing.JTextField ingTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    protected javax.swing.JLabel jlblPass;
    protected javax.swing.JLabel jlblTarjeta;
    protected javax.swing.JSeparator jsprPass;
    protected javax.swing.JSeparator jsprTarjeta;
    // End of variables declaration//GEN-END:variables
}
