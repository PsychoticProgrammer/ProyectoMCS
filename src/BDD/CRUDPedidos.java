
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
                    FROM PEDIDOS PE
                    WHERE PE.ID_USU_PED = ?""");
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
                    SELECT PE.NUM_PED, PE.FEC_PED, PE.EST_PED, PE.TOTAL, PR.NOM_PRO, PR.DES_PRO, PR.PRE_PRO, D.CAN_PRO_PED
                    FROM PEDIDOS PE, PRODUCTOS PR, DETALLE_PEDIDO D
                    WHERE PE.NUM_PED = D.NUM_PED_PER
                    AND PR.COD_PRO = D.ID_PRO_PED
                    AND PE.ID_USU_PED = ?""");
            this.ps.setString(1,cedula);
            
            ArrayList<String[]> datosPedidos = new ArrayList<>();
            String datosPedido[] = new String[4];
            String datosDetalle[] = new String[4];
            int i = 0;
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                if(i == 0){
                    datosPedido[0] = this.rs.getString(1);
                    datosPedido[1] = this.rs.getString(2);
                    datosPedido[2] = this.rs.getString(3);
                    datosPedido[3] = this.rs.getString(4);
                    datosPedidos.add(datosPedido);
                }
                datosDetalle[0] = this.rs.getString(5);
                datosDetalle[1] = this.rs.getString(6);
                datosDetalle[2] = this.rs.getString(7);
                datosDetalle[3] = this.rs.getString(8);
                datosPedidos.add(datosDetalle);
                i++;
            }
            return datosPedidos;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
}
