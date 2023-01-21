
package Soporte;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private Connection connection;
    
    public boolean connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/Floricola","root","");
            return true;
        } catch (Exception e){
            Dialogs.errorMessageDialog("FATAL: NO SE PUDO CONECTAR CON LA BASE DE DATOS");
            return false;
        }
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public void closeConnection(){
        try{
            this.connection.close();
        } catch (Exception e){
            Dialogs.errorMessageDialog("FATAL: NO SE PUDO CERRAR LA CONEXION");
        }
    }
    
}
