package BDD;

import java.sql.*;

public class Conexion {
    
    private Connection connection;
    
    public Conexion(){
        this.connect();
    }
    
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            /*PORFAVOR, SI ALGUIEN TIENE CONTRASEÑA Y NO ES EL USARIO POR DEFECTO ROOT, CREAR UNA
            NUEVA ASIGNACION A CONNECTION, Y COMENTAR LA LINEA QUE ESTA, PARA NO TENER CONFLICTOS
            EN EL GIT. CADA VEZ QUE SE HAGA EL PULL, HAY QUE REVISAR LA CONEXION, PARA COMENTAR LA LINEA 
            QUE NO SIRVE, Y DESCOMENTAR LA QUE UTILICEN*/
            connection=DriverManager.getConnection("jdbc:mysql://localhost/catalogo","root","");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public Connection getConnection(){
        return this.connection;
    }
}
