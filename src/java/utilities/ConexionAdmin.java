/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;


/**
 *
 * @author Sebastian
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
public class ConexionAdmin {
 
	public void conectar(String username,String password) throws SQLException{
 
		String respuesta;
		try {
                	Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
 		Connection connection = null;
 		try {
                    connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
					"julia90210");
 		} catch (SQLException e){
			e.printStackTrace();
		}
		if (connection != null) {
                 // close all the connections.
                   connection.close();
                }
                else {
                   
		}
	}
}