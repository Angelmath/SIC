package Login.Entidad;
// Generated 11/05/2014 06:20:53 PM by Hibernate Tools 3.2.1.GA

import java.sql.Date;

/**
 * Ctepagar generated by hbm2java
 */
public class Contactos  implements java.io.Serializable {


     private int id;
     private String nombre;
     private String cargo;
     private String correo;
     private String observaciones;
     private String telefono;
     private String cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Contactos(int id, String nombre, String cargo, String correo, String observaciones, String telefono, String cliente) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.correo = correo;
        this.observaciones = observaciones;
        this.telefono = telefono;
        this.cliente = cliente;
    }

    public Contactos() {
    }
     
 
    
}


