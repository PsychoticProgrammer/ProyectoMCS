
package Soporte;

import javax.swing.JTextField;

public class Validaciones {
    
    //En los métodos donde se de por parámetro un textfield, es para otorgarle
    //el foco si hay un error. 
    /*Cedula Verdadera, si el parametro es falso,   
    no valida que sea una cedula real solo que tenga la longitud.*/
    public static boolean validarCedula(JTextField txt, boolean active){
        //Si no quiere ingreso de CEdula reales
        if(!active){
            if(txt.getText().length() < 10){
                Dialogs.warningMessageDialog("Ingrese una cédula válida");
                txt.requestFocus();
                return false;
            }
        }
        String cedula = txt.getText();
        int sumPar = 0, sumImp = 0, dobImp, digitoVerificador;
        
        if(txt.getText().length() < 10 || Integer.parseInt(cedula.substring(0,2)) < 0 
                || Integer.parseInt(cedula.substring(0, 2)) > 24){
            Dialogs.warningMessageDialog("Ingrese una cédula válida");
            txt.requestFocus();
            return false;
        }
        for(int i = 1; i < 10; i++){
            if(i % 2 == 0){
                sumPar += Integer.valueOf(String.valueOf(cedula.charAt(i-1)));
                continue;
            }
            dobImp = Integer.valueOf(String.valueOf(cedula.charAt(i-1)))*2;
            if(dobImp > 9){
                dobImp -= 9;
            }
            sumImp += dobImp;
        }
        if((sumPar + sumImp) % 10 == 0 && cedula.charAt(9) == '0'){
            return true;
        }
        if((sumPar + sumImp) % 10 != 0 && cedula.charAt(9) == '0'){
            Dialogs.warningMessageDialog("Ingrese una cédula válida");
            txt.requestFocus();
            return false;
        }
        digitoVerificador = 10 - ((sumPar + sumImp) % 10);
        if(digitoVerificador != Integer.valueOf(String.valueOf(cedula.charAt(9)))){
            Dialogs.warningMessageDialog("Ingrese una cédula válida");
            txt.requestFocus();
            return false;
        }
        return true;
    }
    
    //Telefono real
    public static boolean validarTelefono(JTextField txt){
        if(txt.getText().length() < 10){
            Dialogs.warningMessageDialog("Ingrese un teléfono válido");
            txt.requestFocus();
            return false;
        }
        return true;
    }
    
    //Si ingresa la misma cedula
    public static void clavePrimariaNoRepetida(){
        Dialogs.errorMessageDialog("NUMERO DE CEDULA YA EXISTENTE");
    }
    
    //Si no llena un campo
    public static void campoVacio(JTextField txt, String nombreCampo){
        Dialogs.warningMessageDialog("Debe proporcionar un(a) " + nombreCampo);
        txt.requestFocus();
    }
    
    //cuando se modifica un caampo, valida que si se haya cambiado algo
    public static boolean cambioReal(String[] datosPrevios, String[] datosActuales){
        int i = 0;
        for(i = 0; i < datosPrevios.length; i++){
            if(!datosPrevios[i].equals(datosActuales[i])){
                return true;
            }
        }
        return false;
    }
}
