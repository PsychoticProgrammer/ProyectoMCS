
package BDD;

import java.sql.*;
import java.util.ArrayList;
import ventanas.PantallaInicial;

public class CRUDFavoritos extends CRUDCarrito{
    
    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CRUDFavoritos(){
        this.conexion = new Conexion();
    }
    
    public void createProductoFavorito(int codigoProducto){
        try{
            String sql = "INSERT INTO FAVORITOS(ID_USU_FAV,ID_PRO_FAV) VALUES(?,?);";
            this.ps = this.conexion.getConnection().prepareStatement(sql);
            this.ps.setString(1,PantallaInicial.loggedClient.getCedula());
            this.ps.setInt(2,codigoProducto);
            this.ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public ArrayList<String[]> readProductosFavoritos(){
        try{
            String sql = "SELECT P.COD_PRO, P.NOM_PRO, P.PRE_PRO, I.IMG1 FROM "+
                        "PRODUCTOS P, IMAGENES_PRODUCTO I, FAVORITOS F WHERE I.COD_PRO_PER = P.COD_PRO "+
                        "AND P.COD_PRO = F.ID_PRO_FAV AND F.ID_USU_FAV = ?";
            this.ps = this.conexion.getConnection().prepareStatement(sql);
            this.ps.setString(1,PantallaInicial.loggedClient.getCedula());
            this.rs = this.ps.executeQuery();
            ArrayList<String[]> favoritos = new ArrayList();
            while(this.rs.next()){
                String[] data = new String[4];
                data[0] = String.valueOf(this.rs.getInt(1));
                data[1] = this.rs.getString(2);
                data[2] = String.valueOf(this.rs.getFloat(3));
                data[3] = this.rs.getString(4);
                favoritos.add(data);
            }
            return favoritos;
        }catch(Exception e){
            System.out.println(e);   
            return null;
        }
    }
    
    public void deleteProductoFavorito(int codigoProducto){
        try{
            String sql = "DELETE FROM FAVORITOS WHERE ID_USU_FAV = ? AND ID_PRO_FAV = ?";
            this.ps = this.conexion.getConnection().prepareStatement(sql);
            this.ps.setString(1,PantallaInicial.loggedClient.getCedula());
            this.ps.setInt(2,codigoProducto);
            this.ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    /*public void agregarAlCarrito(int codigoProducto){
        this.deleteProductoFavorito(codigoProducto);
        super.createProductoCarrito(codigoProducto);
    }*/
}
