
package ventanas;

import BDD.CRUDUsuario;
import Clases.Cliente;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ModifyUser extends RegistroForm{
        
    public ModifyUser(JFrame caller){
        super(caller);
        super.btnRegistro.setText("Aceptar");
        super.ingCedula.setEditable(false);
        super.ingPass.setVisible(false);
        super.jlblPass.setVisible(false);
        super.jsprPass.setVisible(false);
        this.isAdmin();
        this.setPreviousData();
    }
    
    private void isAdmin(){
        if(PantallaInicial.loggedClient.getPerfil().equals("A")){
            super.ingTar.setVisible(false);
            super.jlblTarjeta.setVisible(false);
            super.jsprTarjeta.setVisible(false);
        }
    }

    private void setPreviousData(){
        super.ingCedula.setText(PantallaInicial.loggedClient.getCedula());
        super.ingNombre.setText(PantallaInicial.loggedClient.getNombre());
        super.ingApellido.setText(PantallaInicial.loggedClient.getApellido());
        super.ingDireccion.setText(PantallaInicial.loggedClient.getDireccion());
        super.ingTelefono.setText(PantallaInicial.loggedClient.getTelefono());
        super.ingEmail.setText(PantallaInicial.loggedClient.getCorreo());
        if(PantallaInicial.loggedClient.getPerfil().equals("C")){
            super.ingTar.setText(((Cliente)PantallaInicial.loggedClient).getTarjetaCredito());
        }
    }
    
    @Override
    public void processData(){
        CRUDUsuario dm = new CRUDUsuario();
        String ced=ingCedula.getText();
        String nombre=ingNombre.getText().toUpperCase();
        String apellido=ingApellido.getText().toUpperCase();
        String dir=ingDireccion.getText().toUpperCase();
        String tel=ingTelefono.getText();
        String email=ingEmail.getText().toLowerCase();
        String pass=ingPass.getText();
        String tarjeta = "";
        if(PantallaInicial.loggedClient.getPerfil().equals("C")){
            tarjeta = super.ingTar.getText();
        }
        PantallaInicial.loggedClient = 
                dm.updateUsuario(ced, nombre,apellido, dir, tel, email, pass, tarjeta);
        this.setVisible(false);
    }
}
