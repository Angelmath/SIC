package Login.Entidad;
// Generated 14/03/2014 02:47:46 AM by Hibernate Tools 3.2.1.GA

import java.util.HashSet;
import java.util.Set;




/**
 * Clientes generated by hbm2java
 */
public class Clientes  implements java.io.Serializable {


     private int id;
     private String ci;
     private String ruc;
     private String nombre;
     private String apellido;
     private String persona;
     private String numero1;
     private String numero2;
     private String responsable;
     private String correo;
     private Login login;
     private Login login2;
     private Login login3;
     private String usuariotipo2;
     private String usuariotipo3;
     private Set instalacions = new HashSet(0);
     
    public Clientes() {
    }

    public Clientes(int id, String ci, String ruc, String nombre, String apellido, String persona, String numero1, String numero2, String responsable, String correo, Login login, Login login2, Login login3, String usuariotipo2, String usuariotipo3) {
        this.id = id;
        this.ci = ci;
        this.ruc = ruc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.persona = persona;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.responsable = responsable;
        this.correo = correo;
        this.login = login;
        this.login2 = login2;
        this.login3 = login3;
        this.usuariotipo2 = usuariotipo2;
        this.usuariotipo3 = usuariotipo3;
    }

    public Login getLogin2() {
        return login2;
    }

    public void setLogin2(Login login2) {
        this.login2 = login2;
    }

    public Login getLogin3() {
        return login3;
    }

    public void setLogin3(Login login3) {
        this.login3 = login3;
    }

    public String getUsuariotipo2() {
        return usuariotipo2;
    }

    public void setUsuariotipo2(String usuariotipo2) {
        this.usuariotipo2 = usuariotipo2;
    }

    public String getUsuariotipo3() {
        return usuariotipo3;
    }

    public void setUsuariotipo3(String usuariotipo3) {
        this.usuariotipo3 = usuariotipo3;
    }

    public Set getInstalacions() {
        return instalacions;
    }

    public void setInstalacions(Set instalacions) {
        this.instalacions = instalacions;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
	
    public Clientes(int id) {
        this.id = id;
    }
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getCi() {
        return this.ci;
    }
    
    public void setCi(String ci) {
        this.ci = ci;
    }
    public String getRuc() {
        return this.ruc;
    }
    
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getPersona() {
        return this.persona;
    }
    
    public void setPersona(String persona) {
        this.persona = persona;
    }
    public String getNumero1() {
        return this.numero1;
    }
    
    public void setNumero1(String numero1) {
        this.numero1 = numero1;
    }
    public String getNumero2() {
        return this.numero2;
    }
    
    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }
    public String getResponsable() {
        return this.responsable;
    }
    
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }




}


