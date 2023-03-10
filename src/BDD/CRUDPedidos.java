
package BDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ventanas.PantallaInicial;

public class CRUDPedidos {
    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CRUDPedidos(){
        this.conexion = new Conexion();
    }
    
    public int numeroPedidosCliente(String cedula){
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
    
    public int numeroPedidosAdmin(){
        try{
            this.ps = this.conexion.getConnection().prepareStatement("""
                    SELECT COUNT(*)
                    FROM PEDIDOS PE
                    WHERE PE.DEV_EST = 'E'""");
            
            this.rs = this.ps.executeQuery();
            this.rs.next();
            return this.rs.getInt(1);
        }catch(SQLException e){
            System.out.println(e);
            return 0;
        }
    }
    
    public ArrayList<ArrayList<String[]>> getPedidosCliente(String cedula){
        try{
            this.ps = this.conexion.getConnection().prepareStatement("""
                    SELECT PE.NUM_PED, PE.FEC_PED, PE.EST_PED, PE.TOTAL, DEV_EST
                    FROM PEDIDOS PE
                    WHERE PE.ID_USU_PED = ?""");
            this.ps.setString(1,cedula);
            
            ArrayList<ArrayList<String[]>> todosLosPedidos = new ArrayList<>();
            
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                ArrayList<String[]> auxiliarDatos = new ArrayList<>();
                String datosPedido[] = new String[5];
                
                datosPedido[0] = this.rs.getString(1);
                datosPedido[1] = this.rs.getString(2);
                datosPedido[2] = this.rs.getString(3);
                datosPedido[3] = this.rs.getString(4);
                datosPedido[4] = this.rs.getString(5);
                
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
    
    private ArrayList<String[]> getDetallesProducto(String numPedido){
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = this.conexion.getConnection().prepareStatement("""
                    SELECT PR.NOM_PRO, PR.DES_PRO, PR.PRE_PRO, D.CAN_PRO_PED, PR.COD_PRO
                    FROM PEDIDOS PE, PRODUCTOS PR, DETALLE_PEDIDO D
                    WHERE PE.NUM_PED = D.NUM_PED_PER
                    AND PR.COD_PRO = D.ID_PRO_PED
                    AND PE.NUM_PED = ?""");
            ps.setString(1, numPedido);
            
            ArrayList<String[]> datosDeVuelta = new ArrayList<>();
            
            rs = ps.executeQuery();
            while(rs.next()){
                String datosDetalle[] = new String[5];
                datosDetalle[0] = rs.getString(1);
                datosDetalle[1] = rs.getString(2);
                datosDetalle[2] = rs.getString(3);
                datosDetalle[3] = rs.getString(4);
                datosDetalle[4] = rs.getString(5);
                datosDeVuelta.add(datosDetalle);
            }
            return datosDeVuelta;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    } 
    
    public void setSolicitudDevolucion(String numeroPedido){
        PreparedStatement ps;
        try{
            ps = this.conexion.getConnection().prepareStatement("""
                    UPDATE PEDIDOS SET DEV_EST = 'E' WHERE NUM_PED = ?""");
            ps.setString(1, numeroPedido);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void setDevolucionRechazada(String numeroPedido){
        PreparedStatement ps;
        try{
            ps = this.conexion.getConnection().prepareStatement("""
                    UPDATE PEDIDOS SET DEV_EST = 'N' WHERE NUM_PED = ?""");
            ps.setString(1, numeroPedido);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void setDevolucionAceptada(String numeroPedido){
        PreparedStatement ps;
        try{
            ps = this.conexion.getConnection().prepareStatement("""
                    UPDATE PEDIDOS SET DEV_EST = 'S' WHERE NUM_PED = ?""");
            ps.setString(1, numeroPedido);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void devolverProductosStock(String cantidad, String codigoProducto){
        PreparedStatement ps;
        try{
            ps = this.conexion.getConnection().prepareStatement("""
                    UPDATE PRODUCTOS SET UNI_DIS_PRO = UNI_DIS_PRO + ? WHERE COD_PRO = ?""");
            ps.setString(1, cantidad);
            ps.setString(2, codigoProducto);            
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void actualizarMonedero(String total, String cedula){
        PreparedStatement ps;
        try{
            ps = this.conexion.getConnection().prepareStatement("""
                    UPDATE PERSONAS SET MON_CLI = MON_CLI + ? WHERE ID_PER = ?""");
            ps.setString(1, total);
            ps.setString(2, cedula);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public ArrayList<ArrayList<String[]>> getPedidosAdmin(){
        try{
            this.ps = this.conexion.getConnection().prepareStatement("""
                    SELECT PE.NUM_PED, PE.FEC_PED, PE.EST_PED, PE.TOTAL, DEV_EST
                    FROM PEDIDOS PE
                    WHERE PE.DEV_EST = 'E'""");
            
            ArrayList<ArrayList<String[]>> todosLosPedidos = new ArrayList<>();
            
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                ArrayList<String[]> auxiliarDatos = new ArrayList<>();
                String datosPedido[] = new String[5];
                
                datosPedido[0] = this.rs.getString(1);
                datosPedido[1] = this.rs.getString(2);
                datosPedido[2] = this.rs.getString(3);
                datosPedido[3] = this.rs.getString(4);
                datosPedido[4] = this.rs.getString(5);
                System.out.println("aquii: " + datosPedido[0]);
                auxiliarDatos.add(datosPedido);
                ArrayList<String[]> detalles = getDetallesProducto(datosPedido[0]);
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
    
    public String getUsuarioPertenecePedido(String numPedido){
        try{
            this.ps = this.conexion.getConnection().prepareStatement("""
                    SELECT ID_USU_PED
                    FROM PEDIDOS
                    WHERE NUM_PED = ?""");
            ps.setString(1, numPedido);            
            this.rs = this.ps.executeQuery();
            String cedula = "";
            while(this.rs.next()){
                cedula = this.rs.getString(1);
            }
            return cedula;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
}
