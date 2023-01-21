
package Soporte;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Secuencias {
    
    private static Conexion conexion = new Conexion();
    
    public static int inv_Seq_NextVal(){
        try{
            conexion.connect();
            String sql = "SELECT ULTIMO_VALOR FROM SECUENCIAS WHERE ID_SEQ = 'S001'";
            PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int newValue;
            rs.next();
            newValue = rs.getInt(1)+1;
            
            sql = "UPDATE SECUENCIAS SET ULTIMO_VALOR = ULTIMO_VALOR + 1 WHERE ID_SEQ = 'S001'";
            ps = conexion.getConnection().prepareStatement(sql);
            ps.executeUpdate();
            conexion.closeConnection();
            return newValue;
        }catch(Exception e){
            Dialogs.errorMessageDialog("ERROR CON LA BASE DE DATOS");
            return -1;
        }
    }
    
    public static int flor_Seq_NextVal(){
        try{
            conexion.connect();
            String sql = "SELECT ULTIMO_VALOR FROM SECUENCIAS WHERE ID_SEQ = 'S002'";
            PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int newValue;
            rs.next();
            newValue = rs.getInt(1)+1;
            
            sql = "UPDATE SECUENCIAS SET ULTIMO_VALOR = ULTIMO_VALOR + 1 WHERE ID_SEQ = 'S002'";
            ps = conexion.getConnection().prepareStatement(sql);
            ps.executeUpdate();
            conexion.closeConnection();
            return newValue;
        }catch(Exception e){
            Dialogs.errorMessageDialog("ERROR CON LA BASE DE DATOS");
            return -1;
        }
    }
    
    public static int rep_Seq_NextVal(){
        try{
            conexion.connect();
            String sql = "SELECT ULTIMO_VALOR FROM SECUENCIAS WHERE ID_SEQ = 'S003'";
            PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int newValue;
            rs.next();
            newValue = rs.getInt(1)+1;
            
            sql = "UPDATE SECUENCIAS SET ULTIMO_VALOR = ULTIMO_VALOR + 1 WHERE ID_SEQ = 'S003'";
            ps = conexion.getConnection().prepareStatement(sql);
            ps.executeUpdate();
            conexion.closeConnection();
            return newValue;
        }catch(Exception e){
            Dialogs.errorMessageDialog("ERROR CON LA BASE DE DATOS");
            return -1;
        }
    }
    
    public static int flor_Seq_CurrVal(){
        try{
            conexion.connect();
            String sql = "SELECT ULTIMO_VALOR FROM SECUENCIAS WHERE ID_SEQ = 'S002'";
            PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int actualNumber;
            
            rs.next();
            actualNumber = rs.getInt(1);
            conexion.closeConnection();
            return actualNumber;
        }catch(Exception e){
            Dialogs.errorMessageDialog("ERROR CON LA BASE DE DATOS");
            return -1;
        }
    }
    
    public static int rep_Seq_CurrVal(){
        try{
            conexion.connect();
            String sql = "SELECT ULTIMO_VALOR FROM SECUENCIAS WHERE ID_SEQ = 'S003'";
            PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int actualNumber;
            
            rs.next();
            actualNumber = rs.getInt(1);
            conexion.closeConnection();
            return actualNumber;
        }catch(Exception e){
            Dialogs.errorMessageDialog("ERROR CON LA BASE DE DATOS");
            return -1;
        }
    }
}
