package rrhh.Entidad;
// Generated 23/01/2014 08:44:55 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Cuentas generated by hbm2java
 */
public class Cuentas  implements java.io.Serializable {


     private String ci;
     private String nombre;
     private Date fecha;

    public Cuentas() {
    }

	
    public Cuentas(String ci) {
        this.ci = ci;
    }
    public Cuentas(String ci, String nombre, Date fecha) {
       this.ci = ci;
       this.nombre = nombre;
       this.fecha = fecha;
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
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


