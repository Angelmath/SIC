package sgi.tablas;
// Generated 21-sep-2015 12:32:52 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int id;
     private Vehiculo vehiculo;
     private String ci;
     private String nombre;
     private String apellido;
     private String destino;
     private String materiales;
     private String inicioObservacion;
     private String finObservacion;
     private Set registroses = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(int id) {
        this.id = id;
    }
    public Usuario(int id, Vehiculo vehiculo, String ci, String nombre, String apellido, String destino, String materiales, String inicioObservacion, String finObservacion, Set registroses) {
       this.id = id;
       this.vehiculo = vehiculo;
       this.ci = ci;
       this.nombre = nombre;
       this.apellido = apellido;
       this.destino = destino;
       this.materiales = materiales;
       this.inicioObservacion = inicioObservacion;
       this.finObservacion = finObservacion;
       this.registroses = registroses;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }
    
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public String getCi() {
        return this.ci;
    }
    
    public void setCi(String ci) {
        this.ci = ci;
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
    public String getDestino() {
        return this.destino;
    }
    
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String getMateriales() {
        return this.materiales;
    }
    
    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }
    public String getInicioObservacion() {
        return this.inicioObservacion;
    }
    
    public void setInicioObservacion(String inicioObservacion) {
        this.inicioObservacion = inicioObservacion;
    }
    public String getFinObservacion() {
        return this.finObservacion;
    }
    
    public void setFinObservacion(String finObservacion) {
        this.finObservacion = finObservacion;
    }
    public Set getRegistroses() {
        return this.registroses;
    }
    
    public void setRegistroses(Set registroses) {
        this.registroses = registroses;
    }




}


