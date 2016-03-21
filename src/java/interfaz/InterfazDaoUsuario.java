/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import encapsulamiento.Usuario;
import utilities.Conexion;

/**
 *
 * @author Sebastian
 */
public interface InterfazDaoUsuario {
    
    public boolean registrarUsuario(Usuario usuario, Conexion conexion)throws Exception;
    public String recuperarUsuario(Usuario usuario, Conexion conexion)throws Exception;
    public String actualizarUsuario(Usuario usuario, Conexion conexion)throws Exception;
    public String recuperarIdUsuario(Usuario usuario, Conexion conexion)throws Exception;
}
