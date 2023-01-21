
package Carrito;

public class ItemCarrito extends javax.swing.JPanel {

    public ItemCarrito() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblImagen = new javax.swing.JLabel();
        jlblNombre = new javax.swing.JLabel();
        jlblDescripcion = new javax.swing.JLabel();
        jspnCantidad = new javax.swing.JSpinner();
        jbtnQuitarDelCarrito = new javax.swing.JButton();

        jlblImagen.setBackground(new java.awt.Color(210, 242, 242));
        jlblImagen.setOpaque(true);

        jlblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlblNombre.setText("jLabel1");

        jlblDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlblDescripcion.setText("jLabel1");

        jspnCantidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jbtnQuitarDelCarrito.setText("jButton1");

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
                .addComponent(jlblDescripcion)
                .addGap(62, 62, 62)
                .addComponent(jspnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jbtnQuitarDelCarrito)
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
                    .addComponent(jlblDescripcion)
                    .addComponent(jspnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnQuitarDelCarrito))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnQuitarDelCarrito;
    private javax.swing.JLabel jlblDescripcion;
    private javax.swing.JLabel jlblImagen;
    private javax.swing.JLabel jlblNombre;
    private javax.swing.JSpinner jspnCantidad;
    // End of variables declaration//GEN-END:variables
}
