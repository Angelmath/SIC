package sgi.tablas;
// Generated 21-sep-2015 12:32:52 by Hibernate Tools 4.3.1



/**
 * Revpat generated by hbm2java
 */
public class Revpat  implements java.io.Serializable {


     private int id;
     private Integer idfoto;
     private String nombre;
     private Integer idrPall;
     private String orden;
    
    public Revpat() {
    }

	
    public Revpat(int id) {
        this.id = id;
    }

    public Revpat(int id, Integer idfoto, String nombre, Integer idrPall, String orden) {
        this.id = id;
        this.idfoto = idfoto;
        this.nombre = nombre;
        this.idrPall = idrPall;
        this.orden = orden;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Integer getIdfoto() {
        return this.idfoto;
    }
    
    public void setIdfoto(Integer idfoto) {
        this.idfoto = idfoto;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getIdrPall() {
        return this.idrPall;
    }
    
    public void setIdrPall(Integer idrPall) {
        this.idrPall = idrPall;
    }




}


