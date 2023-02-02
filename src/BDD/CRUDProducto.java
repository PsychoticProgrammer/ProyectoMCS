
package BDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUDProducto {
    
    private final Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CRUDProducto() {
        this.conexion = new Conexion();
    }
    
     public ArrayList<ArrayList> getProductos (){
        try{
            this.ps = this.conexion.getConnection().prepareStatement("""
                    SELECT *
                    FROM PRODUCTOS""" );
            
             this.rs = this.ps.executeQuery();
            ArrayList<ArrayList> productosList = new ArrayList();
            while(this.rs.next()){
                ArrayList datosProducto = new ArrayList();
                datosProducto.add(this.rs.getString(1));
                datosProducto.add(this.rs.getString(2));
                datosProducto.add(this.rs.getString(3));
                datosProducto.add(this.rs.getString(4));
                datosProducto.add(this.rs.getString(5));
                productosList.add(datosProducto);
            }
            return productosList;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

   
}
