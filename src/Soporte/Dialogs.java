
package Soporte;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JOptionPane;

public class Dialogs extends JOptionPane{
    
    /*Propiedad para saber respecto a quien se centra
    util en el caso de los JInternal Fames. Si no se inicialza, queda centrado
    respecto a la pantalla.
    */
    public static Component caller;
    
    
    //Para información genérica
    public static void informationDialog(String message){
        showMessageDialog(caller,message);
    }
    
    //En caso de querer informacion titulo Alusivo
    public static void continuedDialog(String message){
        showMessageDialog(caller,message,"INFORMACIÓN",INFORMATION_MESSAGE);
    }
    
    //Error
    public static void errorMessageDialog(String message){
        showMessageDialog(caller,message,"ERROR",ERROR_MESSAGE);
    }
    
    //Advertencia
    public static void warningMessageDialog(String message){
        showMessageDialog(caller,message,"ADVERTENCIA",WARNING_MESSAGE);
    }
    
    //Confirmacion
    public static int confirmationDialog(String message){
        return showConfirmDialog(caller,message,"CONFIRMAR ACCIÓN",YES_NO_OPTION,WARNING_MESSAGE);
    }
}
