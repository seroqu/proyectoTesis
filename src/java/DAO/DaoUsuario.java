/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import encapsulamiento.Usuario;
import java.sql.Statement;
import utilities.Conexion;
import interfaz.InterfazDaoUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author Sebastian
 */
public class DaoUsuario implements InterfazDaoUsuario {

    @Override
    public boolean registrarUsuario(Usuario usuario, Conexion conexion) throws SQLException {

    try {
         Statement statement;
         statement = (Statement) conexion.getConnection().createStatement();
         String query = "INSERT INTO juegotesis.t_usuario (username, correo, nombre, tipo) \n"
                    + " VALUES ('" + usuario.getUsername().toLowerCase() + "', '" + usuario.getEmail().toLowerCase() + "','" + usuario.getUsername().toLowerCase() + "','estudiante')";
         statement.execute(query);
         String query1 = "INSERT INTO juegotesis.t_estudiante (nombre) \n"
                    + " VALUES ('" + usuario.getUsername().toLowerCase() + "')";
         statement.execute(query1);

         String query2 = "CREATE USER " + usuario.getUsername().toLowerCase() + " WITH PASSWORD '" + usuario.getPassword().toLowerCase() + "'";
         statement.execute(query2);

         String query3 = "GRANT estudiante TO " + usuario.getUsername().toLowerCase();
         statement.execute(query3);

         statement.close();
         return true;
     } catch (SQLException a) {
        
         System.out.println("error" + a);
         return false;

     }


    }
    
    
  public boolean registrarUsuarioAdmin(Usuario usuario, Conexion conexion) throws SQLException {

    try {
         Statement statement;
         statement = (Statement) conexion.getConnection().createStatement();
         String query = "INSERT INTO juegotesis.t_usuario (username, correo, nombre, tipo) \n"
                    + " VALUES ('" + usuario.getUsername().toLowerCase() + "', '" + usuario.getEmail().toLowerCase() + "','" + usuario.getUsername().toLowerCase() + "','administrador')";
         statement.execute(query);
         
         String query2 = "CREATE USER " + usuario.getUsername().toLowerCase() + " WITH PASSWORD '" + usuario.getPassword().toLowerCase() + "'";
         statement.execute(query2);

         String query3 = "GRANT postgres TO " + usuario.getUsername().toLowerCase();
         statement.execute(query3);

         statement.close();
         return true;
     } catch (SQLException a) {
        
         System.out.println("error" + a);
         return false;

     }


    }
    
    

    @Override
    public String recuperarUsuario(Usuario usuario, Conexion conexion) throws SQLException {

        try {
            Statement statement;
            statement = (Statement) conexion.getConnection().createStatement();
            String query = "SELECT username FROM juegotesis.t_usuario WHERE correo = '" + usuario.getEmail().toLowerCase() + "'";
            ResultSet rs = statement.executeQuery(query);
            String userRecover = "";
            while (rs.next()) {
                userRecover = (String) rs.getObject("username");
            }
            rs.close();
            statement.close();
            if (!userRecover.equals("")) {
                return "0" + userRecover;
            } else {
                return "1";
            }


        } catch (SQLException a) {

            return a.toString();

        }


    }

    @Override
    public String recuperarIdUsuario(Usuario usuario, Conexion conexion) throws SQLException {

        try {
            Statement statement;
            statement = (Statement) conexion.getConnection().createStatement();
            String query = "SELECT id_usuario FROM juegotesis.t_usuario WHERE username = '" + usuario.getUsername().toLowerCase() + "'";
            ResultSet rs = statement.executeQuery(query);
            String userRecover = "";
            while (rs.next()) {
                userRecover = (String) rs.getObject("username");
            }

            rs.close();

            statement.close();
            return userRecover;
        } catch (SQLException a) {

            return "002_ERROR"+a.toString();

        }


    }
    @Override
    public String actualizarUsuario(Usuario usuario, Conexion conexion) throws SQLException {
        try {

            Statement statement;
            statement = (Statement) conexion.getConnection().createStatement();
            String query = "SELECT username FROM juegotesis.t_usuario WHERE key = '" + usuario.getKey() + "'";
            ResultSet rs = statement.executeQuery(query);
            String userRecover = "";
            while (rs.next()) {
                userRecover = (String) rs.getObject("username");

            }




            Statement statement2;
            statement2 = (Statement) conexion.getConnection().createStatement();

            String query2 = "ALTER USER " + userRecover + " WITH PASSWORD '" + usuario.getPassword() + "'";
            statement2.execute(query2);

            statement2.close();
            return "0";
        } catch (SQLException a) {

            return a.toString();

        }


    }

    public String actualizarLlave(Usuario usuario, Conexion conexion) throws SQLException {
        try {
            Statement statement;
            statement = (Statement) conexion.getConnection().createStatement();

            String query = "UPDATE juegotesis.t_usuario SET key = '" + usuario.getKey() + "' WHERE username = '" + usuario.getUsername().toLowerCase() + "'";
            statement.execute(query);


            statement.close();
            return "0";
        } catch (SQLException a) {

            return a.toString();

        }


    }
    
public Usuario obtenerUsuario(Usuario usuario, Conexion conexion) throws SQLException {
    
    try {
        Statement statement;
        statement = (Statement) conexion.getConnection().createStatement();
        String query = "SELECT * FROM juegotesis.t_usuario WHERE username = '" + usuario.getUsername().toLowerCase() + "'";
        ResultSet rs = statement.executeQuery(query);
        Usuario usuarioRetorno = new Usuario();
            while (rs.next()) {
                usuarioRetorno.setIdentificador(rs.getString("id_usuario"));
                usuarioRetorno.setUsername(rs.getString("username"));
                usuarioRetorno.setTipo( rs.getString("tipo"));
                usuarioRetorno.setEmail( rs.getString("correo"));
                usuarioRetorno.setNombre( rs.getString("nombre"));
                
            }           
            rs.close();
            statement.close();
            return usuarioRetorno;
        } catch (SQLException a) {
            Usuario usuarioRetornoError = new Usuario();
            usuarioRetornoError.setIdentificador("003_ERROR"+a.getMessage());
            return usuarioRetornoError ;
        }
    }
}
