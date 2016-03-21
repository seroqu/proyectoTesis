/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import DAO.DaoUsuario;
import DAO.DaoProfesor;
import encapsulamiento.Usuario;
import java.util.ArrayList;
import utilities.Conexion;

/**
 *
 * @author Sebastian
 */


public class EjbProfesor {

    private final String MENSAJE_ERROR = "001_ERROR";
    private Usuario usuario;
    private String nombreEstudiante;
    private String nombreGrupo;

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }
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
    private final DaoProfesor daoProfesor;
    
    
    public EjbProfesor(){
        usuario = new Usuario();
        daoUsuario = new DaoUsuario();
        daoProfesor = new DaoProfesor();
    }
    
    
     public String[] buscarEstudiante(){
         boolean registrarUsuario;
         String a[] = new String[100];
         
        try{
            conexion = new Conexion();
            conexion.conectar(USUARIO, PASS);
            a = daoProfesor.buscarEstudiante(nombreEstudiante, conexion);
            conexion.getConnection().close();
            
        }
        catch(Exception e){
             registrarUsuario = false;
        } 
        return a;
    }

    public String crearGrupo(String nombreGrupo, String idProfesor){
         String resultado;
         ArrayList grupos = new ArrayList();
         EjbUsuario usuario = new EjbUsuario();
        try{
            conexion = new Conexion();
            conexion.conectar(USUARIO, PASS); 
            grupos = daoProfesor.buscarGrupo(nombreGrupo, idProfesor , conexion);
            if(grupos.isEmpty() || !grupos.get(0).toString().contains(MENSAJE_ERROR)){//to-do ARREGLAR ESTA SHIT
                System.out.println("Vamo a crearlo"); 
                resultado = daoProfesor.crearGrupo(nombreGrupo, idProfesor , conexion);
            }else{
                resultado = "Grupo ya existe";
            }
            conexion.getConnection().close();
        }
        catch(Exception e){
             resultado = "ERROR "+e.getMessage();
        } 
        
        return resultado;
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
       
        Usuario retorno;
        try{
            conexion = new Conexion();
            conexion.conectar(USUARIO, PASS);
            retorno = daoUsuario.obtenerUsuario(usuario, conexion);
            conexion.getConnection().close();
            
        }catch(Exception e){
                Usuario retornoError = new Usuario();
                retornoError.setIdentificador("004_ERROR"+e.toString());
                return retornoError ;
        } 
        return retorno;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
    
    
}
