
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
    
     public ArrayList<String[]> getProuctos (){
        try{
            this.ps = this.conexion.getConnection().prepareStatement("""
                    SELECT *
                    FROM PRODUCTOS=""" );
            
             this.rs = this.ps.executeQuery();
            ArrayList<String[]> productosList = new ArrayList<>();
            String datosProducto[] = new String[5];
                while(this.rs.next()){
                datosProducto[0] = this.rs.getString(1);
                datosProducto[1] = this.rs.getString(2);
                datosProducto[2] = this.rs.getString(3);
                datosProducto[3] = this.rs.getString(4);
                datosProducto[4] = this.rs.getString(5);
                productosList.add(datosProducto);
            }
            return productosList;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
}
