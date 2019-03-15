package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class database {

  Connection conn;
    
public database(){
    conectarBD();
}

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

public Connection conectarBD(){

       try {
            //Driver JDBC
            Class.forName("com.mysql.jdbc.Driver");
            //Nombre del servidor. localhost:3306 es la ruta y el puerto de la conexión MySQL
            //panamahitek_text es el nombre que le dimos a la base de datos
            String servidor = "jdbc:mysql://localhost:3306/proyecto";
            //El root es el nombre de usuario por default. No hay contraseña
            String usuario = "root";
            String pass = "";
            //Se inicia la conexión
            conn = DriverManager.getConnection(servidor, usuario, pass);
 
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conn = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conn = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conn = null;
        } finally {
            JOptionPane.showMessageDialog(null, "Conexión Exitosa");
            return conn;
        }
    }


public void actualizar(String query){ //recibe la consulta
    Statement sm;
    try {
        sm =conn.createStatement();
        sm.executeQuery(query);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"Error en la acción"+e.getMessage());
    }
}

public ResultSet consultar(String query){
    Statement sm;//statemen crea la sentencia
    ResultSet datos = null; //se almacena la respuesta
    try {
        sm = conn.createStatement();
        datos = sm.executeQuery(query);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"Error en la acción"+e.getMessage());
    }
    return datos;
}


}