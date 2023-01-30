
package BDD;

import java.sql.*;

public class CRUDFavoritos extends CRUDCarrito{
    
    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CRUDFavoritos(){
        this.conexion = new Conexion();
    }
    
    public void createProductoFavorito(){
        
    }
}
