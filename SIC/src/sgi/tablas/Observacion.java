package sgi.tablas;
// Generated 21-sep-2015 12:32:52 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Observacion generated by hbm2java
 */
public class Observacion  implements java.io.Serializable {


     private int id;
     private String observacion;
     private Date fecha;
     private Integer idlogin;

    public Observacion() {
    }

	
    public Observacion(int id) {
        this.id = id;
    }
    public Observacion(int id, String observacion, Date fecha, Integer idlogin) {
       this.id = id;
       this.observacion = observacion;
       this.fecha = fecha;
       this.idlogin = idlogin;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Integer getIdlogin() {
        return this.idlogin;
    }
    
    public void setIdlogin(Integer idlogin) {
        this.idlogin = idlogin;
    }




}


