
package BDD;

import Clases.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ventanas.PantallaInicial;

public class CRUDCarrito {
    
    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CRUDCarrito(){
        this.conexion = new Conexion();
    }
    
    public void createProductoCarrito(int idProducto, int cantidad){
        try{
            String sql = "INSERT INTO CARRITO(ID_USU_CAR, ID_PRO_CAR, CAN_PRO_CAR) VALUES(?,?,?)";
            this.ps = this.conexion.getConnection().prepareStatement(sql);
            this.ps.setString(1,PantallaInicial.loggedClient.getCedula());
            this.ps.setInt(2, idProducto);
            this.ps.setInt(idProducto, cantidad);
            
            this.ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public ArrayList<String[]> readProductosCarrito(){
        try{
            String sql = "SELECT P.NOM_PRO, P.PRE_PRO, I.IMG1 FROM PRODUCTOS P, IMAGENES_PRODUCTO I "+
                    "WHERE I.COD_PRO_PER = P.COD_PRO AND P.COD_PRO = (SELECT COD_PRO_CAR FROM CARRITO WHERE ID_PER_CAR = ?)";
            this.ps = this.conexion.getConnection().prepareStatement(sql);
            this.ps.setString(1,PantallaInicial.loggedClient.getCedula());
            this.rs = this.ps.executeQuery();
            ArrayList<String[]> productos = new ArrayList();
            while(this.rs.next()){
                String[] datos = new String[3];
                datos[0] = this.rs.getString(1);
                datos[1] = String.valueOf(this.rs.getFloat(2));
                datos[2] = this.rs.getString(3);
                productos.add(datos);
            }
            return productos;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
