
package BDD;

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
    
    public void createProductoCarrito(int codigoProducto){
        try{
            String sql = "INSERT INTO CARRITO(ID_PER_CAR, COD_PRO_CAR, CAN_PRO_CAR) VALUES(?,?,1)";
            this.ps = this.conexion.getConnection().prepareStatement(sql);
            this.ps.setString(1,PantallaInicial.loggedClient.getCedula());
            this.ps.setInt(2, codigoProducto);
            this.ps.executeUpdate();
            this.alterarCantidadProductos(codigoProducto,1,'-');
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public ArrayList<String[]> readProductosCarrito(){
        try{
            String sql = "SELECT P.COD_PRO, P.NOM_PRO, P.PRE_PRO, I.IMG1 FROM PRODUCTOS P, IMAGENES_PRODUCTO I "+
                    "WHERE I.COD_PRO_PER = P.COD_PRO AND P.COD_PRO IN (SELECT COD_PRO_CAR FROM CARRITO WHERE ID_PER_CAR = ?)";
            this.ps = this.conexion.getConnection().prepareStatement(sql);
            this.ps.setString(1,PantallaInicial.loggedClient.getCedula());
            this.rs = this.ps.executeQuery();
            ArrayList<String[]> productos = new ArrayList();
            while(this.rs.next()){
                String[] datos = new String[4];
                datos[0] = String.valueOf(this.rs.getInt(1));
                datos[1] = this.rs.getString(2);
                datos[2] = String.valueOf(this.rs.getFloat(3));
                datos[3] = this.rs.getString(4);
                productos.add(datos);
            }
            return productos;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public void deleteProductosCarrito(int codigoProducto, int cantidad){
        try{
            String sql = "DELETE FROM CARRITO WHERE ID_PER_CAR= ? AND COD_PRO_CAR = ?";
            this.ps = this.conexion.getConnection().prepareStatement(sql);
            this.ps.setString(1,PantallaInicial.loggedClient.getCedula());
            this.ps.setInt(2,codigoProducto);
            this.ps.executeUpdate();
            this.alterarCantidadProductos(codigoProducto,cantidad,'+');
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void comprarProductosCarrito(int codigoProducto, int cantidad){
        try{
            String sql = "DELETE FROM CARRITO WHERE ID_PER_CAR= ? AND COD_PRO_CAR = ?";
            this.ps = this.conexion.getConnection().prepareStatement(sql);
            this.ps.setString(1,PantallaInicial.loggedClient.getCedula());
            this.ps.setInt(2,codigoProducto);
            this.ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void alterarCantidadProductos(int codigoProducto, int cantidad, char operacion){
        try{
            String sql = "UPDATE PRODUCTOS SET UNI_DIS_PRO = UNI_DIS_PRO " + operacion + " ? " +
                    "WHERE COD_PRO = ?";
            this.ps = this.conexion.getConnection().prepareStatement(sql);
            this.ps.setInt(1,cantidad);
            this.ps.setInt(2,codigoProducto);
            this.ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public boolean estaEnCarrito(int codigoProducto){
        try{
            this.conexion = new Conexion();
            String sql = "SELECT COUNT(COD_PRO_CAR) FROM CARRITO WHERE COD_PRO_CAR = ? AND ID_PER_CAR = ?";
            this.ps = this.conexion.getConnection().prepareStatement(sql);
            this.ps.setInt(1,codigoProducto);
            this.ps.setString(2,PantallaInicial.loggedClient.getCedula());
            this.rs = ps.executeQuery();
            rs.next();
            if(rs.getInt(1) == 1){
                PantallaInicial.loggedClient.setProductoCarrito(codigoProducto);
                return true;
            }
            return false;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}
