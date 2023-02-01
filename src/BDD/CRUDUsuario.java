
package BDD;

import Clases.Cliente;
import java.sql.*;

public class CRUDUsuario {
    
    private final Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CRUDUsuario(){
        this.conexion = new Conexion();
    }
    
    public boolean createUsuario(String cedula, String nombre, String apellido, String direccion,
            String telefono, String correo, String password,String tarjeta, String perfil){
        try{
            this.ps = this.conexion.getConnection().prepareStatement("INSERT INTO PERSONAS (ID_PER,NOM_PER,APE_PER,"+
                    "DIR_PER,TEL_PER,COR_PER,CONTR_PER,PERFIL,NUM_TAR_CLI,MON_CLI) VALUES(?,?,?,?,?,?,?,?,?,0);");
            this.ps.setString(1,cedula);
            this.ps.setString(2,nombre);
            this.ps.setString(3,apellido);
            this.ps.setString(4,direccion);
            this.ps.setString(5,telefono);
            this.ps.setString(6,correo);
            this.ps.setString(7,password);
            this.ps.setString(8, perfil);
            this.ps.setString(9, tarjeta);
            
            this.ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    //EL PERFIL Y MONEDERO SE CONSERVAN EN EL SQL PESE A QUE NO SE USE, PARA POSTERIOR IMPLEMENTACION
    public Cliente readUsuario(String userName, String password){
        try{
            this.ps=this.conexion.getConnection().prepareStatement(
                    "SELECT ID_PER,NOM_PER,APE_PER,DIR_PER,TEL_PER,COR_PER,PERFIL,NUM_TAR_CLI,MON_CLI "+
                    "FROM PERSONAS WHERE (ID_PER = ? OR COR_PER = ?) AND CONTR_PER = ?");
            this.ps.setString(1,userName);
            this.ps.setString(2,userName);
            this.ps.setString(3,password);
            
            this.rs = this.ps.executeQuery();
            this.rs.next();
            return new Cliente(this.rs.getString(1),this.rs.getString(2),this.rs.getString(3),
                    this.rs.getString(4),this.rs.getString(5),this.rs.getString(6),this.rs.getString(7),this.rs.getString(8));
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public boolean updateUsuario(String cedula, String nombre, String apellido, String direccion,
            String telefono, String correo, String password){
        try{
            this.ps = this.conexion.getConnection().prepareStatement("UPDATE PERSONAS SET "
                    + "NOM_PER='"+nombre+"',APE_PER='"+apellido+"',DIR_PER='"+direccion+"',TEL_PER='"+telefono+"',"
                    + "COR_PER='"+correo+"',CONTR_PER='"+password+"' WHERE (ID_PER='"+cedula+"');");
            
            this.ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
