
package Clases;

public class Producto {
    
    private int codigo, unidadesDisponibles, indicePanelPadre;
    private float precio;
    private String nombre, descripcion, imagen1, imagen2, imagen3;
    
    public Producto(int codigo, String nombre, float precio, String descripcion,
            int unidadesDisponibles, String imagen1, String imagen2, String imagen3, int indicePanelPadre){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.unidadesDisponibles = unidadesDisponibles;
        this.imagen1 = imagen1;
        this.imagen3 = imagen2;
        this.imagen2 = imagen3;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public int getUnidadesDisponibles() {
        return this.unidadesDisponibles;
    }

    public float getPrecio() {
        return this.precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    
    public int getIndicePanelPadre(){
        return this.indicePanelPadre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setIndicePanelPadre(int nuevoValor){
        this.indicePanelPadre = nuevoValor;
    }
}
