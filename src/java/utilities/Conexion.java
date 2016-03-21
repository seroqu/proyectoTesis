package utilities;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
public class Conexion {
    
        Connection connection = null;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
 
	public String conectar(String username,String password) throws SQLException{
 
		String respuesta;
		try {
                    Class.forName("org.postgresql.Driver");
 		} catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return e.toString();
 		}
 
		
 
		try {
                    connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", username,password);
 
		} catch (SQLException e){
			e.printStackTrace();
			return e.toString();
 
		}
 
		if (connection != null) {
                   respuesta = "0";
                   // close all the connections.
                   
                }
                else {
                   respuesta = "Failed to make connection!";
		}
                
                return respuesta;
                
	}
        
        
        public void close() throws SQLException{
            connection.close();
        }
 
}