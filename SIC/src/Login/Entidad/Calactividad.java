package Login.Entidad;
// Generated 13/04/2015 15:59:07 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Calactividad generated by hbm2java
 */
public class Calactividad  implements java.io.Serializable {


     private int id;
     private String nombre;
     private Set caldepartamentoactividads = new HashSet(0);

    public Calactividad() {
    }

	
    public Calactividad(int id) {
        this.id = id;
    }
    public Calactividad(int id, String nombre, Set caldepartamentoactividads) {
       this.id = id;
       this.nombre = nombre;
       this.caldepartamentoactividads = caldepartamentoactividads;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getCaldepartamentoactividads() {
        return this.caldepartamentoactividads;
    }
    
    public void setCaldepartamentoactividads(Set caldepartamentoactividads) {
        this.caldepartamentoactividads = caldepartamentoactividads;
    }




}

