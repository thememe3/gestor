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
// Librería de MySQL
    String driver = "com.mysql.jdbc.Driver";
    // Nombre de la base de datos
    String database = "SGPC";
    // Host
    String hostname = "localhost";
    // Puerto
    String port = "3306";
    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    // Nombre de usuario
    String username = "root";
    // Clave de usuario
    String password = "";
    Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            setConn(conn);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        
        return conn;
    }

    


public void actualizar(String query){ //recibe la consulta
    Statement sm;
    boolean resultado;
    try {
        sm =conn.createStatement();
        sm.executeUpdate(query);
        
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