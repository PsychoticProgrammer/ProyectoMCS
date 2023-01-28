
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
    
    public ArrayList<ArrayList<String[]>> getPedidos(String cedula){
        try{
            this.ps = this.conexion.getConnection().prepareStatement("""
                    SELECT PE.NUM_PED, PE.FEC_PED, PE.EST_PED, PE.TOTAL
                    FROM PEDIDOS PE
                    WHERE PE.ID_USU_PED = ?""");
            this.ps.setString(1,cedula);
            
            ArrayList<ArrayList<String[]>> todosLosPedidos = new ArrayList<>();
            
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                ArrayList<String[]> auxiliarDatos = new ArrayList<>();
                String datosPedido[] = new String[4];
                
                datosPedido[0] = this.rs.getString(1);
                datosPedido[1] = this.rs.getString(2);
                datosPedido[2] = this.rs.getString(3);
                datosPedido[3] = this.rs.getString(4);
                
                auxiliarDatos.add(datosPedido);
                ArrayList<String[]> detalles = getDetallesProducto(cedula, datosPedido[0]);
                for(String[] data: detalles)
                    auxiliarDatos.add(data);
                
                todosLosPedidos.add(auxiliarDatos);
            }
            return todosLosPedidos;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
    private ArrayList<String[]> getDetallesProducto(String cedula, String numPedido){
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = this.conexion.getConnection().prepareStatement("""
                    SELECT PR.NOM_PRO, PR.DES_PRO, PR.PRE_PRO, D.CAN_PRO_PED
                    FROM PEDIDOS PE, PRODUCTOS PR, DETALLE_PEDIDO D
                    WHERE PE.NUM_PED = D.NUM_PED_PER
                    AND PR.COD_PRO = D.ID_PRO_PED
                    AND PE.ID_USU_PED = ?
                    AND PE.NUM_PED = ?""");
            ps.setString(1,cedula);
            ps.setString(2, numPedido);
            
            ArrayList<String[]> datosDeVuelta = new ArrayList<>();
            
            rs = ps.executeQuery();
            while(rs.next()){
                String datosDetalle[] = new String[4];
                datosDetalle[0] = rs.getString(1);
                datosDetalle[1] = rs.getString(2);
                datosDetalle[2] = rs.getString(3);
                datosDetalle[3] = rs.getString(4);
                datosDeVuelta.add(datosDetalle);
            }
            return datosDeVuelta;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }    
}
