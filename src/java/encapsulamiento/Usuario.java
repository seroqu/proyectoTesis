/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package encapsulamiento;

/**
 *
 * @author Sebastian
 */
public class Usuario {
    
    private String username;
    private String email;
    private String password;
    private String key;
    private String tipo;
    private String identificador;
    private String nombre;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    
    
public Usuario(){}

public Usuario(String username, String email, String password,String key, String tipo, String identificador) {
this.username = username;
this.email = email;
this.password = password;
this.key = key;
this.tipo = tipo;
this.identificador = identificador;
}
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
