/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import DAO.DaoUsuario;
import encapsulamiento.Usuario;
import utilities.Conexion;

/**
 *
 * @author Sebastian
 */


public class EjbUsuario {

    private Usuario usuario;
    private final String USUARIO = "postgres";
    private final String PASS = "julia90210";
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }
    private Conexion conexion;
    private final DaoUsuario daoUsuario;
    
    
    public EjbUsuario(){
        usuario = new Usuario();
        daoUsuario = new DaoUsuario();
    }
    

    
    
    public boolean registrarUsuario(){
       
        boolean retorno;
        try{
            conexion = new Conexion();
            conexion.conectar(USUARIO, PASS);
            retorno = daoUsuario.registrarUsuario(usuario, conexion);
            conexion.getConnection().close();
            
        }
        catch(Exception e){
               retorno = false;
        } 
        return retorno;
    }
    
    
    public boolean registrarUsuarioAdmin(){
       
        boolean retorno;
        try{
            conexion = new Conexion();
            conexion.conectar(USUARIO, PASS);
            retorno = daoUsuario.registrarUsuarioAdmin(usuario, conexion);
            conexion.getConnection().close();
            
        }
        catch(Exception e){
               retorno = false;
        } 
        return retorno;
    }
    
    
    public String recuperarUsuario(){
       
        String retorno;
        try{
            conexion = new Conexion();
            conexion.conectar(USUARIO, PASS);
            retorno = daoUsuario.recuperarUsuario(usuario, conexion);
            conexion.getConnection().close();
        }
        catch(Exception e){
               retorno = e.toString();
        } 
        return retorno;
    }
    
    
    public String actualizarUsuario(){
       
        String retorno;
        try{
            conexion = new Conexion();
            
            conexion.conectar(USUARIO, PASS);
            retorno = daoUsuario.actualizarUsuario(usuario, conexion);
            conexion.getConnection().close();
            
        }
        catch(Exception e){
               retorno = e.toString();
        } 
        return retorno;
    }
    
    
    public String actualizarLlave(){
       
        String retorno;
        try{
            conexion = new Conexion();
            
            conexion.conectar(USUARIO, PASS);
            retorno = daoUsuario.actualizarLlave(usuario, conexion);
            conexion.getConnection().close();
            
        }
        catch(Exception e){
               retorno = e.toString();
        } 
        return retorno;
    }
    
    public Usuario obtenerUsuario(){
       
        Usuario usuarioRetorno = new Usuario();
        try{
            conexion = new Conexion();
            
            conexion.conectar(USUARIO, PASS);
            usuarioRetorno = daoUsuario.obtenerUsuario(usuario, conexion);
            conexion.getConnection().close();
            
        }
        catch(Exception e){
               usuarioRetorno = new Usuario();
        } 
        return usuarioRetorno;
    }
    
    
}
