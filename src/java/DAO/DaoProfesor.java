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
import java.util.ArrayList;
import java.util.Date;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author Sebastian
 */
public class DaoProfesor implements InterfazDaoUsuario {

    @Override
    public boolean registrarUsuario(Usuario usuario, Conexion conexion) throws SQLException {

    try {
         Statement statement;
         statement = (Statement) conexion.getConnection().createStatement();
         String query = "INSERT INTO juegotesis.t_usuario (username, correo, nombre, tipo) \n"
                    + " VALUES ('" + usuario.getUsername() + "', '" + usuario.getEmail() + "','" + usuario.getUsername() + "','estudiante')";
         statement.execute(query);
         String query1 = "INSERT INTO juegotesis.t_estudiante (nombre) \n"
                    + " VALUES ('" + usuario.getUsername() + "')";
         statement.execute(query1);

         String query2 = "CREATE USER " + usuario.getUsername() + " WITH PASSWORD '" + usuario.getPassword() + "'";
         statement.execute(query2);

         String query3 = "GRANT estudiante TO " + usuario.getUsername();
         statement.execute(query3);

         statement.close();
         return true;
     } catch (SQLException a) {
        
         System.out.println("error" + a);
         return false;

     }


    }

    public String[] buscarEstudiante(String usuario, Conexion conexion){

     try {
        Statement statement;
        statement = (Statement) conexion.getConnection().createStatement();
        String query = "SELECT * FROM juegotesis.t_usuario WHERE tipo='estudiante' AND username like  '%" + usuario.toLowerCase() + "%'";
        ResultSet rs = statement.executeQuery(query);
        String []usuarioEncontrados = new String[100];
        int contador = 0;
        while (rs.next()) {
                usuarioEncontrados[contador] = (String) rs.getObject("username");
                contador++;
        }
            rs.close();
            statement.close();
            return usuarioEncontrados;
        } catch (SQLException a) {
             String []usuarioEncontrados = new String[2];      
             usuarioEncontrados[0] =  a.toString();
            return usuarioEncontrados;

      }
    }
    
    public ArrayList buscarGrupo(String nombreGrupo, String idProfesor, Conexion conexion){

     try {
        Statement statement;
        statement = (Statement) conexion.getConnection().createStatement();
        String query = "SELECT * FROM juegotesis.t_grupo WHERE id_profesor = '"+ idProfesor +"' AND nombre_grupo = '" + nombreGrupo.toLowerCase() + "'";
        ResultSet rs = statement.executeQuery(query);
        ArrayList grupos = new ArrayList();
        while (rs.next()) {
                String temporal =  rs.getString("nombre_grupo");
                grupos.add(temporal); 
        }
            rs.close();
            statement.close();
            return grupos;
            
        } catch (SQLException a) {
             ArrayList grupos = new ArrayList();
             grupos.add(0, "001_ERROR"+a.toString());
            return grupos;
      }
    }

     public String crearGrupo(String nombreGrupo, String idProfesor , Conexion conexion){

     try {
            Statement statement;
            Date fechaActual = new Date();
            statement = (Statement) conexion.getConnection().createStatement();
            String query = "INSERT INTO juegotesis.t_grupo (id_profesor,fecha_creacion,nombre_grupo)VALUES ('"+ idProfesor +"','"+ fechaActual.toString() +"','" + nombreGrupo.toLowerCase() + "')";
            System.out.println("Query "+query);
            statement.executeUpdate(query);
            statement.close();
            return "0";
        } catch (SQLException a) {              
            return "005_ERROR "+a.toString();
      }
    }
    @Override
    public String recuperarUsuario(Usuario usuario, Conexion conexion) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actualizarUsuario(Usuario usuario, Conexion conexion) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String recuperarIdUsuario(Usuario usuario, Conexion conexion) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
