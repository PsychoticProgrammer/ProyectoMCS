
package Soporte;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class TxtField extends JTextField{
    
    //Propiedades para saber lo que va a permitir el textField
    private boolean onlyNumbers, onlyLetters, onlyLetter_SpacesAllowed;
    private int maxLength;
    
    public TxtField(){
        this.maxLength = 10;
        this.onlyLetters = false;
        this.onlyNumbers = false;
        this.onlyLetter_SpacesAllowed = false;
        
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent evt){
                initValidation(evt);
            }
        });
    }
    
    /*Metodo que se invoca cuando se escribe en el textField. Siempre valida que
    la longitud sea la indicada*/
    private void initValidation(KeyEvent e){
        if(this.getText().length() >= this.maxLength){
            e.consume();
            return;
        }
        onlyNumbers(e);
        onlyLetters(e);
        onlyLetter_SpacesAllowed(e);
    }
    
    /*Si la propiedad en cuestión está activa, entonces se ejecutara
    la restricción*/
    private void onlyNumbers(KeyEvent e){
        if(!this.onlyNumbers){
            return;
        }
        if(!Character.isDigit(e.getKeyChar())){
            e.consume();
        }
    }
    
    private void onlyLetters(KeyEvent e){
        if(!this.onlyLetters){
            return;
        }
        if(!Character.isAlphabetic(e.getKeyChar())){
            e.consume();
        }
    }
    
    private void onlyLetter_SpacesAllowed(KeyEvent e){
        if(!this.onlyLetter_SpacesAllowed){
            return;
        }
        if((!Character.isAlphabetic(e.getKeyChar()) && e.getKeyChar() != KeyEvent.VK_SPACE)){
            e.consume();
        }
    }
    
    //Setters de los booleanos
    public void setOnlyLetter_SpacesAllowed(boolean b){
        this.onlyLetter_SpacesAllowed = b;
    }
    
    public void setOnlyLetters(boolean b){
        this.onlyLetters = b;
    }
    
    public void setOnlyNumbers(boolean b){
        this.onlyNumbers = b;
    }
    
    public void setMaxLength(int length){
        this.maxLength = length;
    }
    
    //Para almacenar los datos siempre en mayusculas y sin espacios a los extremos
    @Override
    public String getText(){
        return super.getText().trim().toUpperCase();
    }
}
