
package BDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUDPedidos {
    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CRUDPedidos(){
        this.conexion = new Conexion();
    }
    
    public int numeroPedidos(String cedula){
        try{
            this.ps = this.conexion.getConnection().prepareStatement("""
                    SELECT COUNT(*)
                    FROM PEDIDOS_SIMPLES PE, PRODUCTOS PR
                    WHERE PE.ID_PRO_PER = PR.COD_PRO
                    AND PE.ID_USU_PED = ?""");
            this.ps.setString(1,cedula);
            
            this.rs = this.ps.executeQuery();
            this.rs.next();
            return this.rs.getInt(1);
        }catch(SQLException e){
            System.out.println(e);
            return 0;
        }
    }
    
    public ArrayList<String[]> detallesPedidos(String cedula){
        try{
            this.ps = this.conexion.getConnection().prepareStatement("""
                    SELECT PE.NUM_PED, PE.FEC_PED, PE.EST_PED, PR.NOM_PRO, PR.PRE_PRO
                    FROM PEDIDOS_SIMPLES PE, PRODUCTOS PR
                    WHERE PE.ID_PRO_PER = PR.COD_PRO
                    AND PE.ID_USU_PED = ?""");
            this.ps.setString(1,cedula);
            
            ArrayList<String[]> datosPedidos = new ArrayList<>();
            String datos[] = new String[5];
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                datos[0] = this.rs.getString(1);
                datos[1] = this.rs.getString(2);
                datos[2] = this.rs.getString(3);
                datos[3] = this.rs.getString(4);
                datos[4] = this.rs.getString(5);
                datosPedidos.add(datos);
            }
            return datosPedidos;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
}
