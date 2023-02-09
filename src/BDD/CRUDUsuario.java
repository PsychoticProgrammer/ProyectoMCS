
package BDD;

import Clases.Cliente;
import Clases.Usuario;
import Soporte.Dialogs;
import java.sql.*;

public class CRUDUsuario {
    
    private final Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CRUDUsuario(){
        this.conexion = new Conexion();
    }
    
    public boolean createUsuario(String cedula, String nombre, String apellido, String direccion,
            String telefono, String correo, String password, String perfil){
        try{
            this.ps = this.conexion.getConnection().prepareStatement("INSERT INTO PERSONAS (ID_PER,NOM_PER,APE_PER,"+
                    "DIR_PER,TEL_PER,COR_PER,CONTR_PER,PERFIL,NUM_TAR_CLI,MON_CLI) VALUES(?,?,?,?,?,?,?,?,NULL,0);");
            this.ps.setString(1,cedula);
            this.ps.setString(2,nombre);
            this.ps.setString(3,apellido);
            this.ps.setString(4,direccion);
            this.ps.setString(5,telefono);
            this.ps.setString(6,correo);
            this.ps.setString(7,password);
            this.ps.setString(8,perfil);
            
            this.ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    //EL PERFIL Y MONEDERO SE CONSERVAN EN EL SQL PESE A QUE NO SE USE, PARA POSTERIOR IMPLEMENTACION
    public Usuario readUsuario(String userName, String password){
        try{
            String sql = "SELECT PERFIL FROM PERSONAS WHERE (ID_PER = ? OR COR_PER = ?) AND CONTR_PER = ?";
            this.ps = this.conexion.getConnection().prepareStatement(sql);
            this.ps.setString(1,userName);
            this.ps.setString(2,userName);
            this.ps.setString(3,password);
            
            this.rs = this.ps.executeQuery();
            this.rs.next();
            
            return this.selectType(this.rs.getString(1), userName, password);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    //PARA CASOS DE CAMBIOS DE DATOS
    public Usuario readUsuario(String cedula){
        try{
            String sql = "SELECT PERFIL, CONTR_PER FROM PERSONAS WHERE ID_PER = ?";
            this.ps = this.conexion.getConnection().prepareStatement(sql);
            this.ps.setString(1,cedula);
            
            this.rs = this.ps.executeQuery();
            this.rs.next();
            
            return this.selectType(this.rs.getString(1),cedula,this.rs.getString(2));
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public Usuario updateUsuario(String cedula, String nombre, String apellido, String direccion,
            String telefono, String correo, String password, String tarjeta){
        try{
            this.ps = this.conexion.getConnection().prepareStatement("UPDATE PERSONAS SET "
                    + "NOM_PER='"+nombre+"',APE_PER='"+apellido+"',DIR_PER='"+direccion+"',TEL_PER='"+telefono+"',"
                    + "COR_PER='"+correo+"',CONTR_PER='"+password+"', NUM_TAR_CLI='"+tarjeta+"' WHERE (ID_PER='"+cedula+"');");
            
            this.ps.executeUpdate();
            Dialogs.informationDialog("Información Modificada exitosamente");
            return this.readUsuario(cedula);
        }catch(SQLException e){
            Dialogs.warningMessageDialog("No se Pudieron Modificar los datos");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    private Usuario selectType(String perfil, String userName, String password){
        try{
            if(perfil.equals("C")){
                this.ps=this.conexion.getConnection().prepareStatement(
                        "SELECT ID_PER,NOM_PER,APE_PER,DIR_PER,TEL_PER,COR_PER,NUM_TAR_CLI,MON_CLI "+
                        "FROM PERSONAS WHERE (ID_PER = ? OR COR_PER = ?) AND CONTR_PER = ?");
                this.ps.setString(1,userName);
                this.ps.setString(2,userName);
                this.ps.setString(3,password);

                this.rs = this.ps.executeQuery();
                this.rs.next();
                return new Cliente(this.rs.getString(1),this.rs.getString(2),this.rs.getString(3),
                        this.rs.getString(4),this.rs.getString(5),this.rs.getString(6),this.rs.getString(7),this.rs.getString(8));
            }
            this.ps=this.conexion.getConnection().prepareStatement(
                        "SELECT ID_PER,NOM_PER,APE_PER,DIR_PER,TEL_PER,COR_PER "+
                        "FROM PERSONAS WHERE (ID_PER = ? OR COR_PER = ?) AND CONTR_PER = ?");
            this.ps.setString(1,userName);
            this.ps.setString(2,userName);
            this.ps.setString(3,password);

            this.rs = this.ps.executeQuery();
            this.rs.next();
            return new Usuario(this.rs.getString(1),this.rs.getString(2),this.rs.getString(3),
                        this.rs.getString(4),this.rs.getString(5),this.rs.getString(6));
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
