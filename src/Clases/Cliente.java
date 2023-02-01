
package Clases;

import java.util.ArrayList;

public class Cliente extends Usuario{
    
    //HASTA QUE NO SE IMPLEMENTE COMO CAMBIO EL MONEDERO, DEBE ESTAR COMENTADO LO QUE ESTA COMENTADO

    private float monedero;
    private String tarjetaCredito;
    private ArrayList<Integer> carrito;
    
    public Cliente(String cedula, String nombre, String apellido, String direccion,
            String telefono, String correo,float monedero, String tarjeta){
        super(cedula,nombre,apellido,direccion,telefono,correo);
        this.monedero = monedero;
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
}
