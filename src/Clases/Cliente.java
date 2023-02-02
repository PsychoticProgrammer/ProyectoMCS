
package Clases;

import java.util.ArrayList;

public class Cliente extends Usuario{
    
    //HASTA QUE NO SE IMPLEMENTE COMO CAMBIO EL MONEDERO, DEBE ESTAR COMENTADO LO QUE ESTA COMENTADO
    private String perfil;
    private float monedero;
    private String tarjetaCredito;
    private ArrayList<Integer> carrito;
    
    public Cliente(String cedula, String nombre, String apellido, String direccion,
            String telefono, String correo,String monedero, String tarjeta, String perfil){
        super(cedula,nombre,apellido,direccion,telefono,correo);
        this.monedero = Float.parseFloat(monedero);
        this.perfil = perfil;
        this.tarjetaCredito = tarjeta;
        this.carrito = new ArrayList();
    }

    public float getMonedero() {
        return this.monedero;
    }

    public String getTarjetaCredito() {
        return this.tarjetaCredito;
    }
    
    public ArrayList<Integer> getCarrito(){
        return this.carrito;
    }

    public void setMonedero(float monedero) {
        this.monedero = monedero;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }
    
    public void setProductoCarrito(int codigoProducto){
        this.carrito.add(codigoProducto);
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
}
