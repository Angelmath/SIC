package rrhh.Entidad;
// Generated 23/01/2014 08:44:55 AM by Hibernate Tools 3.2.1.GA



/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private int id;
     private String usuario;
     private String password;
     private String nombre;

    public Users() {
    }

	
    public Users(int id) {
        this.id = id;
    }
    public Users(int id, String usuario, String password, String nombre) {
       this.id = id;
       this.usuario = usuario;
       this.password = password;
       this.nombre = nombre;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}


